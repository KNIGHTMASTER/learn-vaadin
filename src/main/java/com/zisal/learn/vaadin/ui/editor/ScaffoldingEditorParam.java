package com.zisal.learn.vaadin.ui.editor;

import com.vaadin.ui.Component;
import com.zisal.learn.vaadin.ui.button.ButtonScaffoldingAction;

import java.util.List;

/**
 * Created by Ladies Man on 5/16/2016.
 */
public class ScaffoldingEditorParam {

    private ButtonScaffoldingAction buttonScaffoldingAction;
    private List<Component> components;

    public ButtonScaffoldingAction getButtonScaffoldingAction() {
        return buttonScaffoldingAction;
    }

    public void setButtonScaffoldingAction(ButtonScaffoldingAction buttonScaffoldingAction) {
        this.buttonScaffoldingAction = buttonScaffoldingAction;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
