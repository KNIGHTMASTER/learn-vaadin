package com.zisal.learn.vaadin.ui.textfield;

import javax.annotation.PostConstruct;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class TextFieldNumericMandatory extends TextFieldNumeric {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2722129120206334348L;

	@PostConstruct
	@Override
	public void initComponents() throws Exception {
		super.initComponents();
		this.addValidator(new NullValidator(messageSource.getMessage("ui.textfield.numeric.validator.notnull", null, getLocale()), false));
	}
	
}
