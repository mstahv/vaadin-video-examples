package com.example.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/customers")
public class CustomerView extends VerticalLayout {

  public CustomerView(CustomerRepository repository) {

    var grid = new Grid<Customer>(Customer.class);
    add(grid);

    var customers = repository.findAll();
    grid.setItems(customers);
  }
}
