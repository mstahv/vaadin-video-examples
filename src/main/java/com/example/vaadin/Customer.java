package com.example.vaadin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;
  private String name;
  private String email;

  public Customer() {
  }

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long id) {
    this.customerId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
