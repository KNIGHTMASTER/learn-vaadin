package com.zisal.learn.vaadin.ui.button;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Button;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class ButtonCreate extends Button implements IComponentInitalizer {

    private static final long serialVersionUID = 5494857975616913267L;
    private Logger logger = LoggerFactory.getLogger(ButtonCreate.class);

    @Autowired
    SimpleMessageSource simpleMessageSource;

    @PostConstruct
    @Override
    public void init() throws Exception {
        simpleMessageSource.setKey("ui.button.create");
        this.setCaption(simpleMessageSource.getMessage());
        this.setIcon(FontAwesome.PLUS);
    }
}
