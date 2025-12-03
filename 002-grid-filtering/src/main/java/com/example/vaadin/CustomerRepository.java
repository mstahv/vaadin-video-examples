package com.example.vaadin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for fetching {@link Customer} entities from the database
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}