package com.zisal.learn.vaadin.ui.scaffolding;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.data.EntityEmployee;
import com.zisal.learn.vaadin.data.RepoEmployee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringView(name = ViewScaffoldingEmployee.VIEW_NAME)
public class ViewScaffoldingEmployee extends ABaseScaffolding implements View, IComponentInitalizer{

    private static final long serialVersionUID = -7906873535819691832L;

    public static final String VIEW_NAME = "EMPLOYEE_SCAFFOLDING";

    @Autowired
    private RepoEmployee repoEmployee;
    private EntityEmployee entityEmployee;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        ParamScaffolding paramScaffolding = new ParamScaffolding();
        paramScaffolding.setData(entityEmployee);
        paramScaffolding.setRepo(repoEmployee);
        setParamComponent(paramScaffolding);
        super.initComponents();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
