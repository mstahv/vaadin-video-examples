package com.example.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.function.Supplier;

@Route("")
public class EmployeeView extends Div {

  public EmployeeView(EmployeeService service) {
    setSizeFull();

    var grid = new EmployeeGrid();
    add(grid);

    var employees = service.getAllEmployees();
    grid.setItems(employees);
  }

  class EmployeeGrid extends Grid<Employee> {

    public EmployeeGrid() {
      addThemeVariants(GridVariant.LUMO_NO_BORDER);
      setMultiSort(true);
      setSizeFull();

      addComponentColumn(employee -> new EmployeeImage(employee));

      addSortableColumn(Employee::getName, "Name");
      addSortableColumn(Employee::getDepartment, "Department");
      addSortableColumn(Employee::getEmail, "Email");

      getColumns().forEach(c -> c.setAutoWidth(true));
    }

    private void addSortableColumn(ValueProvider<Employee,String> columnContent, String header) {
        addColumn(columnContent)
                .setHeader(header)
                .setSortable(true);
    }
  }

  class EmployeeImage extends Image {

    public EmployeeImage(Employee employee) {
      super(employee.getPicture(), employee.getName());
      addClassNames(LumoUtility.BorderRadius.FULL);
      setHeight("48px");
      setWidth("48px");
    }
  }
}
