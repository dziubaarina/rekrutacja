# Product Catalog Management System

Zadanie techniczne na stanowisko Support Java Developer. System to proste REST API do zarządzania katalogiem produktów od wielu producentów.

Dziuba Arina
## Technologia
* **Java**: 21
* **Spring Boot**: 3.x
* **Liquibase**: Zarządzanie schematem bazy danych
* **Baza danych**: H2 (in-memory)
* **Build Tool**: Maven

## Funkcjonalności API
Zaimplementowano endpointy obsługujące wymagane operacje:
1. **List Products**: Pobieranie wszystkich produktów wraz z detalami producenta.
2. **Create Product**: Dodawanie nowych produktów i przypisywanie ich do producentów.
3. **Update Product**: Modyfikacja danych produktu oraz jego atrybutów.
4. **Delete Product**: Usuwanie produktów z systemu.
5. **Dodatki (Bonus)**: Endpointy dla producentów oraz filtrowanie/wyszukiwanie produktów.

## Obsługa atrybutów
System został zaprojektowany tak, aby obsługiwać produkty o różnej złożoności – od prostych (kilka cech) po bardziej złożonych (50-200 atrybutów). Wykorzystano mapowanie typu JSON, co zapewnia maksymalną elastyczność bez komplikowania schematu bazy danych.

## Jak uruchomić projekt
1. Sklonuj repozytorium na dysk.
2. Upewnij się, że masz zainstalowaną Javę 21.
3. Uruchom aplikację za pomocą Mavena:
   ```bash
   ./mvnw spring-boot:run
4. API będzie dostępne pod adresem: http://localhost:8080.

5. Konsola bazy danych H2 dostępna pod: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:catalogdb, login: sa, bez hasła).
