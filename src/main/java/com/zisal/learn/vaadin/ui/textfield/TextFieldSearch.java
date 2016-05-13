package com.zisal.learn.vaadin.ui.textfield;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.component.IViewInitalizer;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 4/22/2016.
 */
@SpringComponent
@ViewScope
public class TextFieldSearch extends TextField implements IViewInitalizer{

    private static final long serialVersionUID = -4931843141601000290L;

    @Value(value = "${ui.main.title}")
    String searchWord;

    @PostConstruct
    @Override
    public void init() throws Exception {
        this.setInputPrompt("Search");
        this.setIcon(FontAwesome.SEARCH);
        this.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
    }
}
