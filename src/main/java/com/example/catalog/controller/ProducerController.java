package com.example.catalog.controller;

import com.example.catalog.model.Producer;
import com.example.catalog.repository.ProducerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producers")
public class ProducerController {

    private final ProducerRepository producerRepository;

    public ProducerController(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @GetMapping
    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producer createProducer(@RequestBody Producer producer) {
        return producerRepository.save(producer);
    }
}