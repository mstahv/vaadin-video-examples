package com.example.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class CustomerView extends VerticalLayout {

    private final CustomerRepository repository;
    private final Grid<Customer> grid;

    public CustomerView(CustomerRepository repository) {
        this.repository = repository;
        this.grid = new Grid<>(Customer.class);
        
        grid.setItems(repository.findAll());
        
        add(grid);
        setSizeFull();
    }
}
