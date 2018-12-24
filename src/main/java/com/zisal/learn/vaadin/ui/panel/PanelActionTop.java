package com.zisal.learn.vaadin.ui.panel;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.HorizontalLayout;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.button.ButtonCreate;
import com.zisal.learn.vaadin.ui.textfield.TextFieldSearch;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class PanelActionTop extends HorizontalLayout implements IComponentInitalizer {

    private static final long serialVersionUID = -6045432023086676401L;

    @Autowired
    PanelRowPage panelRowPage;

    @Autowired
    TextFieldSearch textFieldSearch;

    @Autowired
    ButtonCreate buttonCreate;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        this.addComponents(buttonCreate, panelRowPage, textFieldSearch);
        this.setSpacing(true);
    }
}
