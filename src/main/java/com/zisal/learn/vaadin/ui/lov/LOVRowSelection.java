package com.zisal.learn.vaadin.ui.lov;

import javax.annotation.PostConstruct;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.zisal.learn.vaadin.constant.ApplicationConstant;
import com.zisal.learn.vaadin.constant.ApplicationConstant.View.ListOfValue.DisplayDataRowTable;

@SpringComponent
@ViewScope
public class LOVRowSelection extends LOVBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5089854941196417237L;

	private ILOVListener ilovListener;

    public LOVRowSelection(ILOVListener ilovListener) {
        this.ilovListener = ilovListener;
    }
    
	@PostConstruct
	@Override
	public void initComponents() throws Exception {
		
		BeanItemContainer<LOVDto> container = new BeanItemContainer<>(LOVDto.class);
        container.addItem(new LOVDto(null, ApplicationConstant.View.ListOfValue.RowSelection.ALL));
        container.addItem(new LOVDto(null, ApplicationConstant.View.ListOfValue.RowSelection.NONE));
        LOVParam = new LOVParam<>();
        LOVParam.setBeanItemContainer(container);
        
        this.setNullSelectionAllowed(false);
        this.setTextInputAllowed(false);
        this.setWidth(DisplayDataRowTable.WIDTH, Unit.PIXELS);
        this.select(container.firstItemId());
        
		super.initComponents();
		
		this.addItemSetChangeListener(e -> ilovListener.onItemChange());		
	}
}
