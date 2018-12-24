package com.zisal.learn.vaadin.ui.textfield;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 4/22/2016.
 */
@SpringComponent
@ViewScope
public class TextFieldSearch extends TextField implements IComponentInitalizer {

    private static final long serialVersionUID = -4931843141601000290L;

    @Autowired
    MessageSource messageSource;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        Responsive.makeResponsive(this);
        this.setInputPrompt(messageSource.getMessage("ui.textfield.search.input.prompt", null, getLocale()));
        this.setIcon(FontAwesome.SEARCH);
        this.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
    }

}
