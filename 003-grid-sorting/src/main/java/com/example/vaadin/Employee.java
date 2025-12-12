package com.example.vaadin;

/**
 * Model class representing an Employee.
 */
public class Employee {

  private Long id;
  private String name;
  private String picture;
  private String email;
  private String department;

  public Employee() {
  }

  public Employee(Long id, String name, String picture, String email, String department) {
    this.id = id;
    this.name = name;
    this.picture = picture;
    this.email = email;
    this.department = department;
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

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

}
