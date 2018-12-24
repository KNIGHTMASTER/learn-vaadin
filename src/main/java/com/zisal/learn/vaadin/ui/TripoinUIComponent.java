package com.zisal.learn.vaadin.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.vaadin.spring.annotation.SpringComponent;
import com.zisal.learn.vaadin.component.IComponentInitalizer;

@SpringComponent
public abstract class TripoinUIComponent implements IComponentInitalizer {

	@Autowired
    protected MessageSource messageSource;
	
	protected Logger LOGGER = LoggerFactory.getLogger(TripoinUIComponent.class);
}
