package com.zisal.learn.vaadin.ui.label;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Label;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class LabelRowPerPage extends Label implements IComponentInitalizer {
	
	/**
	 * 
	 * 
	 */
    private static final long serialVersionUID = 7709365689020633014L;

    @Autowired
    SimpleMessageSource simpleMessageSource;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        this.setCaption(simpleMessageSource.getMessage("ui.label.row_per_page"));
        this.setSizeFull();
    }
}
