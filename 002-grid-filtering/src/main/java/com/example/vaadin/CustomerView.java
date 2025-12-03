package com.example.vaadin;

import org.apache.commons.lang3.StringUtils;
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
@Menu(title = "Customers", icon = "VAADIN_USER")
public class CustomerView extends VerticalLayout {

  public CustomerView(CustomerRepository repository) {

    // tell the view to take up all of the remaining screen space
    setSizeFull();

    // create the grid component and add to the UI
    var grid = new Grid<Customer>();
    grid.setSizeFull();

    // add columns for each field in the User class
    grid.addColumn(Customer::getId);
    grid.addColumn(Customer::getName);
    grid.addColumn(Customer::getEmail);

    // instantiate grid's data view by setting an empty list of items
    var dataView = grid.setItems();

    // create the search field component
    var searchField = new TextField();
    searchField.setValueChangeMode(ValueChangeMode.LAZY);
    searchField.addValueChangeListener(e -> dataView.refreshAll());
    searchField.setPlaceholder("Search");
    searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
    searchField.setWidthFull();

    add(searchField, grid);

    // tell grid to always filter its items based on our search field
    dataView.addFilter(customer -> {
      var searchStr = searchField.getValue();
      if (searchField.isEmpty()
          || StringUtils.containsIgnoreCase(customer.getName(), searchStr)
          || StringUtils.containsIgnoreCase(customer.getEmail(), searchStr)) {
        return true;
      }
      return false; // this customer did not pass the filter requirements - don't show in UI
    });

    // fetch all of the users and add them to our grid
    var customers = repository.findAll();
    dataView.setItems(customers);

    // end of demo --------------------------------

    // optional: automatically determine column widths based on content
    grid.getColumns().forEach(c -> c.setAutoWidth(true));
  }

}
