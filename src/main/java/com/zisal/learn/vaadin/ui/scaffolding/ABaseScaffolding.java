package com.zisal.learn.vaadin.ui.scaffolding;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.VerticalLayout;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.component.IParamComponent;
import com.zisal.learn.vaadin.ui.dialog.ConfirmationDialogDeleteSingleRecord;
import com.zisal.learn.vaadin.ui.dialog.ISimpleConfirmDialogListener;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import com.zisal.learn.vaadin.ui.panel.PanelActionTop;
import com.zisal.learn.vaadin.ui.scaffolding.Employee.EditorEmployee;
import com.zisal.learn.vaadin.ui.scaffolding.Employee.GridEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public abstract class ABaseScaffolding
        extends VerticalLayout
        implements IComponentInitalizer, IParamComponent<ParamScaffolding>, ISimpleConfirmDialogListener{

    private static final long serialVersionUID = -7618997303270331555L;

    protected Logger logger = LoggerFactory.getLogger(ABaseScaffolding.class);

    private ParamScaffolding paramScaffolding;

    @Autowired
    protected ConfirmationDialogDeleteSingleRecord confirmationDialogDeleteSingleRecord;
    @Autowired
    protected SimpleMessageSource simpleMessageSource;

    @Autowired
    private GridEmployee gridEmployee;
    @Autowired
    private EditorEmployee editorEmployee;
    @Autowired
    PanelActionTop panelActionTop;

    @Override
    public void initComponents() throws Exception {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponents(panelActionTop, editorEmployee, gridEmployee);
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);

        addComponent(mainLayout);
    }

    @Override
    public void setParamComponent(ParamScaffolding p_Component) {
        this.paramScaffolding = p_Component;
    }

    @Override
    public ParamScaffolding getParamComponent() {
        return paramScaffolding;
    }

    @Override
    public void confirmed() {
        logger.info("Confirmed");
    }

    @Override
    public void unConfirmed() {
        logger.info("unConfirmed");
    }
}
