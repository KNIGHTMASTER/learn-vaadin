package com.zisal.learn.vaadin.ui;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.data.EntityEmployee;
import com.zisal.learn.vaadin.data.RepoEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ladies Man on 4/22/2016.
 */
@SpringComponent
@UIScope
public class EmployeeEditor extends VerticalLayout{

    private static final long serialVersionUID = -446280545995904466L;

    private EntityEmployee entityEmployee;
    private RepoEmployee repoEmployee;
    private Logger logger = LoggerFactory.getLogger(EmployeeEditor.class);

    TextField firstName = new TextField("First Name");
    TextField lastName = new TextField("Last Name");

    Button save = new Button("Save", FontAwesome.SAVE);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", FontAwesome.TRASH_O);

    CssLayout actions = new CssLayout(save, delete, cancel);

    @Autowired
    public EmployeeEditor(RepoEmployee repoEmployee){
        this.repoEmployee = repoEmployee;
        addComponents(firstName, lastName, actions);
        setSpacing(true);

        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        save.addClickListener(e->repoEmployee.save(entityEmployee));
        delete.addClickListener(e->repoEmployee.delete(entityEmployee));
        cancel.addClickListener(e->editEmploye(entityEmployee));
    }

    public final void editEmploye(EntityEmployee p_EntityEMployee) {
        logger.info("ERROR : {}", p_EntityEMployee.toString());
        final boolean persisted = p_EntityEMployee.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            entityEmployee = repoEmployee.findOne(p_EntityEMployee.getId());
        }
        else {
            entityEmployee = p_EntityEMployee;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        BeanFieldGroup.bindFieldsUnbuffered(entityEmployee, this);

        setVisible(true);

        // A hack to ensure the whole form is visible
        save.focus();
        // Select all text in firstName field automatically
        firstName.selectAll();
    }

    public interface ChangeHandler {

        void onChange();
    }

    public void setChangeHandler(ChangeHandler changeHandler){
        save.addClickListener(e->changeHandler.onChange());
        save.addClickListener(e->changeHandler.onChange());
    }
}
