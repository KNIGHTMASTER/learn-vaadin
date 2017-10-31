package com.zisal.learn.vaadin.ui.editor;

import com.vaadin.ui.VerticalLayout;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.component.IComponent;

/**
 * Created by Ladies Man on 5/16/2016.
 */
public class ScaffoldingEditor extends VerticalLayout implements IComponent<ScaffoldingEditorParam, VerticalLayout>, IComponentInitalizer {

    private static final long serialVersionUID = 5406610453650714248L;

    protected ScaffoldingEditorParam scaffoldingEditorParam = new ScaffoldingEditorParam();

    @Override
    public void init() throws Exception {
        scaffoldingEditorParam.getComponents().forEach(this::addComponent);
        //this.setStyleName("");
    }

    @Override
    public void setParamComponent(ScaffoldingEditorParam p_Component) {
        this.scaffoldingEditorParam = p_Component;
    }

    @Override
    public ScaffoldingEditorParam getParamComponent() {
        return scaffoldingEditorParam;
    }

    @Override
    public VerticalLayout getResultComponent() {
        return this;
    }
}
