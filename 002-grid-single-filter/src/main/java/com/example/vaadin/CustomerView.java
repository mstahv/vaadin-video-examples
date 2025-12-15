package com.example.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * View where we display a list of all customers in a {@link Grid} component.
 */
@Route("")
@PageTitle("Customers")
@Menu(title = "Customers", icon = "vaadin:user")
public class CustomerView extends VerticalLayout {

  public CustomerView(CustomerService service) {
    bestPracticeExample(service);
    // minimalExample(service);
  }

  /**
   * Below is a more in-depth explanation of adding filtering to a {@link Grid} component.
   * The code in this function represents a best-practice approach and is the preferred approach
   * for production quality code.
   * @param service
   */
  private void bestPracticeExample(CustomerService service) {
    // create the grid and search field components
    var grid = new CustomerGrid();
    var searchField = new SearchField();

    // add components and make grid consume all the space
    add(searchField);
    addAndExpand(grid);

    // refresh grid when search field value changes
    searchField.addValueChangeListener(e -> grid.setItems(service.filterCustomers(searchField.getValue())));
    grid.setItems(service.findAll());
  }

  class CustomerGrid extends Grid<Customer> {

    public CustomerGrid() {
      addColumn(Customer::getId).setHeader("Id");
      addColumn(Customer::getName).setHeader("Name");
      addColumn(Customer::getEmail).setHeader("Email");

      // automatically determine column widths based on content
      getColumns().forEach(c -> c.setAutoWidth(true));
      setSizeFull();
    }
  }

  class SearchField extends TextField {{
    // With lazy value change mode, event is fired afer user has a short break,
    // no need to hit enter
    setValueChangeMode(ValueChangeMode.LAZY);
    setPlaceholder("Search");
    setPrefixComponent(new Icon(VaadinIcon.SEARCH));
    setWidthFull();
    setClearButtonVisible(true);
  }}

  /**
   * This is a minimal example used for focusing on the high-level concepts. Use this to
   * get an overview of the feature, but refer to the {@link #bestPracticeExample}
   * method for reference on production quality code.
   */
  private void minimalExample(CustomerService service) {
    var grid = new Grid<Customer>(Customer.class);

    var searchField = new TextField();
    searchField.addValueChangeListener(e ->
            grid.setItems(service.filterCustomers(searchField.getValue())));

    add(searchField);
    addAndExpand(grid);

    grid.setItems(service.findAll());

  }

}
