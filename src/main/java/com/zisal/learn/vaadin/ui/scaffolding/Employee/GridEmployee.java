package com.zisal.learn.vaadin.ui.scaffolding.Employee;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.data.EntityEmployee;
import com.zisal.learn.vaadin.data.RepoEmployee;
import com.zisal.learn.vaadin.ui.grid.GridScaffolding;
import com.zisal.learn.vaadin.ui.grid.GridScaffoldingParam;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class GridEmployee extends GridScaffolding implements IComponentInitalizer {

    private static final long serialVersionUID = 8850255448205293102L;

    @Autowired
    private SimpleMessageSource simpleMessageSource;
    @Autowired
    private RepoEmployee repoEmployee;

    @PostConstruct
    @Override
    public void init() throws Exception {
        String idWord = simpleMessageSource.getMessage("id");
        String firstNameWord = simpleMessageSource.getMessage("ui.scaffolding.editor.employee.first_name");
        String lastNameWord = simpleMessageSource.getMessage("ui.scaffolding.editor.employee.last_name");

        GridScaffoldingParam gridScaffoldingParam = new GridScaffoldingParam();
        gridScaffoldingParam.setColumns(new String[]{idWord, firstNameWord, lastNameWord});
        gridScaffoldingParam.setHeight(300);

        setParamComponent(gridScaffoldingParam);
        super.init();
    }

    @Override
    public void onSelection() {
        logger.info("On Selection");
    }

    @Override
    public void loadDataSource() {
        this.setContainerDataSource(new BeanItemContainer<>(EntityEmployee.class, (List<EntityEmployee>) repoEmployee.findAll()));
    }
}
