package com.zisal.learn.vaadin.ui.dialog;

import com.vaadin.ui.UI;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.vaadin.dialogs.ConfirmDialog;
//import org.vaadin.dialogs.ConfirmDialog;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Ladies Man on 5/13/2016.
 */
@Component
public class ConfirmationDialogDeleteSingleRecord implements IComponentInitalizer {

    private ISimpleConfirmDialogListener iSimpleConfirmDialogListener;
    private UI ui;
    private SimpleMessageSource simpleMessageSource;

    public ConfirmationDialogDeleteSingleRecord(
    		ISimpleConfirmDialogListener p_ISimpleConfirmDialogListener, 
    		UI p_UI,
            SimpleMessageSource simpleMessageSource) throws Exception {
        this.iSimpleConfirmDialogListener = p_ISimpleConfirmDialogListener;
        this.ui = p_UI;
        this.simpleMessageSource = simpleMessageSource;
    }

    public ConfirmationDialogDeleteSingleRecord(){}

    @Override
    public void initComponents() throws Exception {
        simpleMessageSource.setKey("ui.dialog.confirm.message");
        if (ui != null){
            ConfirmDialog.show(ui, simpleMessageSource.getMessage(),
                    new ConfirmDialog.Listener() {
                        private static final long serialVersionUID = -8078866196349094995L;
                        @Override
                        public void onClose(ConfirmDialog confirmDialog) {
                            if (confirmDialog.isConfirmed()){
                                iSimpleConfirmDialogListener.confirmed();
                            }else{
                                iSimpleConfirmDialogListener.unConfirmed();
                            }
                        }
                    }

            );
        }else{
            simpleMessageSource.setKey("error");
            throw new Exception(simpleMessageSource.getMessage());
        }
    }
}
