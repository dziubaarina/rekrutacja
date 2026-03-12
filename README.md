# Product Catalog Management System

This system is a REST API for managing a product catalog with multiple producers and highly dynamic attributes.

## Technology Stack
* **Java**: 21
* **Spring Boot**: 3.x
* **Liquibase**: Database schema management
* **Database**: H2 (In-memory)
* **Build Tool**: Maven

## Business Context & Features
The system handles products from approximately 100 different producers. 
Key functionalities implemented:
1. **List Products**: Retrieve all products with producer details.
2. **Create Product**: Add new products and associate them with producers.
3. **Update Product**: Modify product info and attributes.
4. **Delete Product**: Remove products from the system.
5. **Bonus**: Implemented producer-related endpoints and product search/filtering.

## Attribute Handling
To meet the requirement of handling between 50-200 attributes (specifications, dimensions, certifications) per product, this solution utilizes a JSON-based mapping. This ensures maximum flexibility for varying product complexities without performance overhead.

## Setup & Running Instructions
1. Clone the repository.
2. Ensure you have Java 21 installed.
3. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
4. The API will be available at: http://localhost:8080.
5. H2 Database console (for verification): http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:catalogdb, Login: sa, no password).
