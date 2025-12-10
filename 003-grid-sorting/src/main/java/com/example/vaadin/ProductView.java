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
 * View where we display a list of all products in a {@link Grid} component.
 */
@Route("")
@PageTitle("Users")
@Menu(title = "Users", icon = "VAADIN_USER")
public class ProductView extends VerticalLayout {

  public ProductView(ProductRepository repository) {
    bestPracticeExample(repository);
    // minimalExample(repository);
  }
  
  /**
   * Below is a more in-depth explanation of adding sorting to a {@link Grid} component.
   * The code in this function represents a best-practice approach and is the preferred approach
   * for production quality code.
   * @param repository
   */
  private void bestPracticeExample(ProductRepository repository) {

    // tell the view to take up all of the remaining screen space
    setSizeFull();

    // create the grid component and add to the UI
    var grid = new Grid<Product>();
    grid.setSizeFull();

    // add columns with sorting enabled
    grid.addColumn(Product::getName)
        .setHeader("Name")
        .setAutoWidth(true) 
        .setSortable(true);

    grid.addColumn(Product::getCategory)
        .setHeader("Category")
        .setAutoWidth(true)
        .setSortable(true);

    grid.addColumn(Product::getInventoryCount)
        .setHeader("Inventory")
        .setAutoWidth(true)
        .setSortable(true);

    grid.setMultiSort(true);

    add(grid);

    // fetch products from backend and set as items in the grid
    var customers = repository.findAll();
    grid.setItems(customers);
  }
  
  /**
   * This is a minimal example used for focusing on the high-level concepts. Use this to 
   * get an overview of the feature, but refer to the {@link #bestPracticeExample} 
   * method for reference on production quality code.
   */
  private void minimalExample(ProductRepository repository) {
    setSizeFull();

    // providing the class to the grid will auto-generate columns for all fields
    var grid = new Grid<Product>(Product.class);

    // get the name column and enable sorting
    grid.getColumnByKey("name")
        .setSortable(true);
    add(grid);

    var products = repository.findAll();
    grid.setItems(products);
  }

}
