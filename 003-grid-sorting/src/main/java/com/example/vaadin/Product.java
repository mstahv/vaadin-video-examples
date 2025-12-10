package com.example.vaadin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * JPA entity that represents the `product` table in our database.
 */
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String category;
  @Column(name = "inventory_count")
  private int inventoryCount;

  public Product() {
  }

  public Product(String name, String category, int inventoryCount) {
    this.name = name;
    this.category = category;
    this.inventoryCount = inventoryCount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getInventoryCount() {
    return inventoryCount;
  }

  public void setInventoryCount(int inventoryCount) {
    this.inventoryCount = inventoryCount;
  }

}
