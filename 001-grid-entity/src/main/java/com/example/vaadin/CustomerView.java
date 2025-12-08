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
    bestPracticeExample(repository);
    // minimalExample(repository);
  }

  /**
   * Below is a more in-depth explanation of binding an entity to a {@link Grid} component.
   * The code in this function represents a best-practice approach and is the preferred approach
   * for production quality code.
   * @param repository
   */
  private void bestPracticeExample(CustomerRepository repository) {

    // tell the view to take up all of the remaining screen space
    setSizeFull();

    // create the grid component and define our columns
    var grid = new Grid<Customer>();
    grid.setSizeFull();
    grid.addColumn(Customer::getId)
      .setHeader("ID");
    grid.addColumn(Customer::getName)
      .setHeader("Name");
    grid.addColumn(Customer::getEmail)
      .setHeader("Email");

    // automatically adjust column widths based on their content
    grid.getColumns().forEach(c -> c.setAutoWidth(true));

    // add the grid to our view
    add(grid);

    // fetch all of the customers and add them to our grid
    var customers = repository.findAll();
    grid.setItems(customers);
  }

  /**
   * This is a minimal example used for focusing on the high-level concepts. Use this to 
   * get an overview of the feature, but refer to the {@link #bestPracticeExample} 
   * method for reference on production quality code.
   */
  private void minimalExample(CustomerRepository repository) {

    var grid = new Grid<Customer>(Customer.class);
    add(grid);

    var customers = repository.findAll();
    grid.setItems(customers);
  }

}
