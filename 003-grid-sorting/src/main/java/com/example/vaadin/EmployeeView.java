package com.example.vaadin;
  
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("")
public class EmployeeView extends Div {

  public EmployeeView(EmployeeService service) {

    setSizeFull();

    var grid = new Grid<Employee>();
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
    grid.setMultiSort(true);
    grid.setSizeFull();

    grid.addComponentColumn(employee -> createEmployeeImage(employee))
        .setAutoWidth(true);

    grid.addColumn(Employee::getName)
        .setHeader("Name")
        .setAutoWidth(true)
        .setSortable(true);

    grid.addColumn(Employee::getDepartment)
        .setHeader("Department")
        .setAutoWidth(true)
        .setSortable(true);

    grid.addColumn(Employee::getEmail)
        .setHeader("Email")
        .setAutoWidth(true)
        .setSortable(true);

    add(grid);

    var employees = service.getAllEmployees();
    grid.setItems(employees);
  }
  
  private Image createEmployeeImage(Employee employee) {
    var image = new Image(employee.getPicture(), employee.getName());
    image.addClassNames(LumoUtility.BorderRadius.FULL);
    image.setHeight("48px");
    image.setWidth("48px");
    return image;
  }
}
