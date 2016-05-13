package com.zisal.learn.vaadin.ui.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.zisal.learn.vaadin.component.IViewInitalizer;
import com.zisal.learn.vaadin.data.EntityEmployee;
import com.zisal.learn.vaadin.data.RepoEmployee;
import com.zisal.learn.vaadin.ui.lov.LOVDisplayDataRowTable;
import com.zisal.learn.vaadin.ui.scaffolding.EmployeeEditor;
import com.zisal.learn.vaadin.ui.textfield.TextFieldSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ladies Man on 5/12/2016.
 */

@SpringView(name = ViewMain.VIEW_NAME)
public class ViewMain extends VerticalLayout implements View, IViewInitalizer{

    private static final long serialVersionUID = -1455222850637822862L;

    public static final String VIEW_NAME = "MAIN_VIEW";

    private Logger logger = LoggerFactory.getLogger(ViewMain.class);

    private Grid grid;
    private TextField filter;
    private Button addNewButton;

    @Autowired
    private RepoEmployee repoEmployee;

    @Autowired
    private EmployeeEditor employeeEditor;

    @Autowired
    LOVDisplayDataRowTable lovDisplayDataRowTable;

    @Autowired
    TextFieldSearch textFieldSearch;

    public ViewMain(){
    }

    @PostConstruct
    @Override
    public void init() {
        grid = new Grid();
        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "firstName", "lastName");

        filter = new TextField();
        filter.setInputPrompt("Filter By Last Name");

        addNewButton = new Button("New Employee", FontAwesome.PLUS);
        Label labelMaxRows = new Label("Max Rows : ");

        HorizontalLayout actions = new HorizontalLayout(filter, addNewButton, labelMaxRows, lovDisplayDataRowTable, textFieldSearch);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, employeeEditor);
        addComponent(mainLayout);

        actions.setSpacing(true);
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);

        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                employeeEditor.setVisible(false);
            }
            else {
                logger.info("Selected Row : {}", grid.getSelectedRow().toString());
                employeeEditor.editEmploye((EntityEmployee) grid.getSelectedRow());
            }
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewButton.addClickListener(e -> employeeEditor.editEmploye(new EntityEmployee("", "")));

        // Listen changes made by the editor, refresh data from backend
        employeeEditor.setChangeHandler(() -> {
            employeeEditor.setVisible(false);
            //listCustomers(filter.getData());
        });

        // Initialize listing
        loadAllEmployee();
    }

    private void loadAllEmployee(){
        grid.setContainerDataSource(new BeanItemContainer<>(EntityEmployee.class, (List<EntityEmployee>) repoEmployee.findAll()));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
