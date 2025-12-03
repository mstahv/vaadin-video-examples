package com.example.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * View where we display a list of all customers in a {@link Grid} component.
 */
@Route("")
@PageTitle("Customers")
@Menu(title = "Customers", icon = "VAADIN_USER")
public class CustomerView extends VerticalLayout {

  public CustomerView(CustomerRepository repository) {

    // tell the view to take up all of the remaining screen space
    setSizeFull();

    // create the grid component and generate columns for the Customer class
    var grid = new Grid<Customer>(Customer.class);
    grid.setSizeFull();
    add(grid);

    // fetch all of the customers and add them to our grid
    var customers = repository.findAll();
    grid.setItems(customers);

    // end of demo --------------------------------

    // optional: set the desired order of columns
    grid.setColumnOrder(
      grid.getColumnByKey("id"),
      grid.getColumnByKey("name"),
      grid.getColumnByKey("email")
    );

    // optional: automatically determine column widths based on content
    grid.getColumns().forEach(c -> c.setAutoWidth(true));
  }

}
