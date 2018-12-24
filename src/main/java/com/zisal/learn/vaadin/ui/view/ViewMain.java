package com.zisal.learn.vaadin.ui.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Runo;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.component.IListenerInitializer;
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
public class ViewMain extends VerticalLayout implements View, IComponentInitalizer, IListenerInitializer {

    private static final long serialVersionUID = -1455222850637822862L;

    public static final String VIEW_NAME = "MAIN_VIEW";

    private Logger logger = LoggerFactory.getLogger(ViewMain.class);

    @Autowired
    private RepoEmployee repoEmployee;
    @Autowired
    private EmployeeEditor employeeEditor;
    @Autowired
    private LOVDisplayDataRowTable lovDisplayDataRowTable;
    @Autowired
    private TextFieldSearch textFieldSearch;

    private Grid grid;
    private Button addNewButton;
    Grid.MultiSelectionModel selectionModel;

    public ViewMain(){}

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        grid = new Grid();
        grid.setColumns("id", "firstName", "lastName");
        selectionModel = (Grid.MultiSelectionModel) grid.setSelectionMode(Grid.SelectionMode.MULTI);
        selectionModel.selectAll();
        grid.setSizeFull();

        addNewButton = new Button("Create", FontAwesome.PLUS);

        HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
        hsplit.setLocked(true);

        Panel panel = new Panel();
        panel.setContent(textFieldSearch);
        textFieldSearch.setMaxLength(50);

        HorizontalLayout actionComponents = new HorizontalLayout(lovDisplayDataRowTable, textFieldSearch);
        actionComponents.setSpacing(true);
        hsplit.setFirstComponent(addNewButton);

        VerticalLayout rightTopGrid = new VerticalLayout();
        rightTopGrid.setSizeFull();
        rightTopGrid.addComponent(actionComponents);
        rightTopGrid.setComponentAlignment(actionComponents, Alignment.MIDDLE_RIGHT);

        hsplit.setSecondComponent(rightTopGrid);

        VerticalLayout mainLayout = new VerticalLayout(hsplit, grid, employeeEditor);
        mainLayout.setSizeFull();
        addComponent(mainLayout);

        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);

        loadAllEmployee();
        initListener();
    }

    private void loadAllEmployee(){
        grid.setContainerDataSource(new BeanItemContainer<>(EntityEmployee.class, (List<EntityEmployee>) repoEmployee.findAll()));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @Override
    public void initListener() throws Exception {
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                employeeEditor.setVisible(false);
            }
            else {
                int size = selectionModel.getSelectedRows().size();
                if (size == 0){
                    employeeEditor.setVisible(false);
                }
                if (size == 1){
                    employeeEditor.editEmployee((EntityEmployee) grid.getSelectedRows().iterator().next());
                }else{
                    employeeEditor.setVisible(false);
                    for (Object entityEmployee : selectionModel.getSelectedRows()){
                        EntityEmployee data = (EntityEmployee) entityEmployee;
                        logger.info(data.toString());
                    }
                }

            }
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewButton.addClickListener(e -> employeeEditor.editEmployee(new EntityEmployee("", "")));

        // Listen changes made by the editor, refresh data from backend
        employeeEditor.setChangeHandler(() -> {
            employeeEditor.setVisible(false);
            loadAllEmployee();
        });

    }
}
