package com.example.vaadin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for fetching {@link Product} entities from the database
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}