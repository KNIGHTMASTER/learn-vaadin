package com.zisal.learn.vaadin.ui.button;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class ButtonScaffoldingAction extends CssLayout implements IComponentInitalizer, IBSAListener {

    private static final long serialVersionUID = -7321694294074882263L;

    @Autowired
    SimpleMessageSource messageSource;

    private Button btSave;
    private Button btCancel;
    private Button btDelete;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        messageSource.setKey("ui.button.save");
        String saveWord = messageSource.getMessage();
        messageSource.setKey("ui.button.cancel");
        String cancelWord = messageSource.getMessage();
        messageSource.setKey("ui.button.delete");
        String deleteWord = messageSource.getMessage();

        btSave = new Button(saveWord, FontAwesome.SAVE);
        btSave.setStyleName(ValoTheme.BUTTON_PRIMARY);
        btSave.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        btSave.addClickListener(e -> onSaveClicked());

        btCancel = new Button(cancelWord);
        btCancel.addClickListener(e -> onCancelClicked());

        btDelete = new Button(deleteWord, FontAwesome.TRASH_O);
        btDelete.addClickListener(e -> onDeleteClicked());


        this.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        this.addComponents(btSave, btDelete, btCancel);
    }

    public Button getBtSave() {
        return btSave;
    }

    public void setBtSave(Button btSave) {
        this.btSave = btSave;
    }

    public Button getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(Button btCancel) {
        this.btCancel = btCancel;
    }

    public Button getBtDelete() {
        return btDelete;
    }

    public void setBtDelete(Button btDelete) {
        this.btDelete = btDelete;
    }

    @Override
    public void onSaveClicked() {

    }

    @Override
    public void onCancelClicked() {

    }

    @Override
    public void onDeleteClicked() {

    }
}
