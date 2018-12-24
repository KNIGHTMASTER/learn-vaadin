package com.zisal.learn.vaadin.ui.textfield;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.TextField;
import com.zisal.learn.vaadin.component.IComponentInitalizer;

@SpringComponent
@ViewScope
public class TextFieldNumeric extends TextField implements IComponentInitalizer {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 2009612383515879878L;
	
	@Autowired
	MessageSource messageSource;
	
	protected int minValue;
	protected int maxValue;

	@PostConstruct
	@Override
	public void initComponents() throws Exception {
		minValue = 1;
		maxValue = 999999999;
		this.addValidator(new IntegerRangeValidator(messageSource.getMessage("ui.textfield.numeric.validator", null, getLocale()), minValue, maxValue));		
	}

}
