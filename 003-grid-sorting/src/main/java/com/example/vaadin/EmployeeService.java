package com.example.vaadin;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service class to manage Employee data.
 */
@Service
public class EmployeeService {

  private static final List<Employee> EMPLOYEES = List.of(
    new Employee(1L, "Ava Thompson", "https://randomuser.me/api/portraits/women/44.jpg", "ava@test.io", "Sales"),
    new Employee(2L, "Liam Carter", "https://randomuser.me/api/portraits/men/32.jpg", "liam@test.io", "Engineering"),
    new Employee(3L, "Sophia Martinez", "https://randomuser.me/api/portraits/women/68.jpg", "sophia@test.io", "Marketing"),
    new Employee(4L, "Ethan Brooks", "https://randomuser.me/api/portraits/men/15.jpg", "ethan@test.io", "Sales"),
    new Employee(5L, "Chloe Patel", "https://randomuser.me/api/portraits/women/12.jpg", "chloe@test.io", "Engineering"),
    new Employee(6L, "Noah Jenkins", "https://randomuser.me/api/portraits/men/21.jpg", "noah@test.io", "Marketing"),
    new Employee(7L, "Isabella Flores", "https://randomuser.me/api/portraits/women/23.jpg", "isabella@test.io", "Sales"),
    new Employee(8L, "Mason Rivera", "https://randomuser.me/api/portraits/men/83.jpg", "mason@test.io", "Engineering"),
    new Employee(9L, "Mia Sullivan", "https://randomuser.me/api/portraits/women/46.jpg", "mia@test.io", "Marketing"),
    new Employee(10L, "Henry Collins", "https://randomuser.me/api/portraits/men/57.jpg", "henry@test.io", "Sales"),
    new Employee(11L, "Ella Nguyen", "https://randomuser.me/api/portraits/women/48.jpg", "ella@test.io", "Engineering"),
    new Employee(12L, "James Turner", "https://randomuser.me/api/portraits/men/41.jpg", "james@test.io", "Marketing"),
    new Employee(13L, "Olivia Bennett", "https://randomuser.me/api/portraits/women/62.jpg", "olivia@test.io", "Sales"),
    new Employee(14L, "Lucas Ramirez", "https://randomuser.me/api/portraits/men/77.jpg", "lucas@test.io", "Engineering"),
    new Employee(15L, "Grace Howard", "https://randomuser.me/api/portraits/women/55.jpg", "grace@test.io", "Marketing"));

  public List<Employee> getAllEmployees() {
    return EMPLOYEES;
  }
}
