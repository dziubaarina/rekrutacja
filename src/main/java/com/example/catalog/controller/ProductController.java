package com.example.catalog.controller;

import com.example.catalog.model.Product;
import com.example.catalog.model.Producer;
import com.example.catalog.repository.ProductRepository;
import com.example.catalog.repository.ProducerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;

    public ProductController(ProductRepository productRepository, ProducerRepository producerRepository) {
        this.productRepository = productRepository;
        this.producerRepository = producerRepository;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(search);
        }
        return productRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest request) {
        Producer producer = producerRepository.findById(request.producerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Producer not found"));

        Product product = new Product();
        product.setName(request.name());
        product.setProducer(producer);
        product.setAttributes(request.attributes());

        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        Producer producer = producerRepository.findById(request.producerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Producer not found"));

        product.setName(request.name());
        product.setProducer(producer);
        product.setAttributes(request.attributes());

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        productRepository.deleteById(id);
    }

    public record ProductRequest(String name, Long producerId, java.util.Map<String, Object> attributes) {}
}