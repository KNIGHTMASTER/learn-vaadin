package com.zisal.learn.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.zisal.learn.vaadin.constant.ApplicationConstant;
import com.zisal.learn.vaadin.data.EntityEmployee;
import com.zisal.learn.vaadin.data.RepoEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Achmad Fauzi on 4/21/2016.
 */
@SpringUI
@Theme(value = ApplicationConstant.View.THEME)
public class MainUI extends UI implements ErrorHandler, Serializable{

    private static final long serialVersionUID = -7306067026718781942L;
    private final RepoEmployee repoEmployee;
    private final EmployeeEditor employeeEditor;
    private final Grid grid;
    private final TextField filter;
    private final Button addNewButton;

    private Logger logger = LoggerFactory.getLogger(MainUI.class);

    @Autowired
    public MainUI(RepoEmployee repoEmployee, EmployeeEditor employeeEditor){
        this.repoEmployee = repoEmployee;
        this.employeeEditor = employeeEditor;
        this.grid = new Grid();
        this.filter = new TextField();
        this.addNewButton = new Button("New Employee", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        /*Build Layout*/
        HorizontalLayout actions = new HorizontalLayout(filter, addNewButton);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, employeeEditor);
        setContent(mainLayout);

        /*Configure layout and components*/
        actions.setSpacing(true);
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);

        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "firstName", "lastName");

        filter.setInputPrompt("Filter By Last Name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
//        filter.addTextChangeListener(e -> listCustomers(e.getText()));

        // Connect selected Customer to editor or hide if none is selected
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                employeeEditor.setVisible(false);
            }
            else {
                logger.info("Selected Row : {}", ((EntityEmployee)grid.getSelectedRow()).toString());
                employeeEditor.editEmploye((EntityEmployee) grid.getSelectedRow());
            }
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewButton.addClickListener(e -> employeeEditor.editEmploye(new EntityEmployee("", "")));

        // Listen changes made by the editor, refresh data from backend
        employeeEditor.setChangeHandler(() -> {
            employeeEditor.setVisible(false);
            //listCustomers(filter.getValue());
        });

        // Initialize listing
        loadAllEmployee();
    }


    private void loadAllEmployee(){
        grid.setContainerDataSource(new BeanItemContainer<>(EntityEmployee.class, (List<EntityEmployee>) repoEmployee.findAll()));
    }

    @Override
    public void error(com.vaadin.server.ErrorEvent errorEvent) {
        Notification.show("Error "+errorEvent.toString());
    }
}
