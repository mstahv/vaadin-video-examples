# vaadin-video-examples

A minimal Vaadin 24.9.5 + Spring Boot project demonstrating how to display a database entity in a Vaadin Grid component.

## Features

- **Customer Entity**: JPA entity with id, name, and email fields
- **CustomerRepository**: Spring Data JPA repository
- **CustomerView**: Vaadin view displaying all customers in a Grid component
- **Grid with Type Reflection**: Grid columns are automatically generated from the Customer class
- **Sample Data**: 20 customers pre-populated via data.sql in H2 embedded database

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080/

## Technology Stack

- Vaadin 24.9.5
- Spring Boot 3.3.5
- Spring Data JPA
- H2 Database (embedded)
- Java 17