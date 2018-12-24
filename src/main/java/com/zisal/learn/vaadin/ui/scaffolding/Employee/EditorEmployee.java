package com.zisal.learn.vaadin.ui.scaffolding.Employee;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.button.ButtonScaffoldingAction;
import com.zisal.learn.vaadin.ui.editor.ScaffoldingEditor;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class EditorEmployee extends ScaffoldingEditor implements IComponentInitalizer{

    private static final long serialVersionUID = -1268995318730192711L;

    @Autowired
    private SimpleMessageSource simpleMessageSource;

    @Autowired
    private ButtonScaffoldingAction buttonScaffoldingAction;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        simpleMessageSource.setKey("ui.scaffolding.editor.employee.first_name");
        TextField tfFirstName = new TextField(simpleMessageSource.getMessage());

        simpleMessageSource.setKey("ui.scaffolding.editor.employee.last_name");
        TextField tfLastName = new TextField(simpleMessageSource.getMessage());

        List<Component> componentList = new ArrayList<>();
        componentList.add(tfFirstName);
        componentList.add(tfLastName);

        scaffoldingEditorParam.setComponents(componentList);
        scaffoldingEditorParam.setButtonScaffoldingAction(buttonScaffoldingAction);

        setParamComponent(scaffoldingEditorParam);
        super.initComponents();
    }
}
