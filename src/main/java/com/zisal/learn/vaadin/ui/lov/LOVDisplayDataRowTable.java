package com.zisal.learn.vaadin.ui.lov;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.zisal.learn.vaadin.constant.ApplicationConstant.View.ListOfValue.DisplayDataRowTable;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 4/22/2016.
 */
@SpringComponent
@ViewScope
public class LOVDisplayDataRowTable extends LOVBase {

    private static final long serialVersionUID = 1727150704699762885L;

    private ILOVListener ilovListener;

    public LOVDisplayDataRowTable(ILOVListener ilovListener) {
        this.ilovListener = ilovListener;
    }

    public LOVDisplayDataRowTable() {
    }

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        LOVParam LOVParam = new LOVParam();
        BeanItemContainer<LOVDto> container = new BeanItemContainer<>(LOVDto.class);
        container.addItem(new LOVDto(null, DisplayDataRowTable.ITEM_5));
        container.addItem(new LOVDto(null, DisplayDataRowTable.ITEM_10));
        container.addItem(new LOVDto(null, DisplayDataRowTable.ITEM_15));
        container.addItem(new LOVDto(null, DisplayDataRowTable.ITEM_20));
        container.addItem(new LOVDto(null, DisplayDataRowTable.ITEM_50));
        LOVParam.setBeanItemContainer(container);

        setParamComponent(LOVParam);

        this.setNullSelectionAllowed(false);
        this.setTextInputAllowed(false);
        this.setWidth(DisplayDataRowTable.WIDTH, Unit.PIXELS);
        this.select(container.firstItemId());
        super.initComponents();
        this.addItemSetChangeListener(e -> ilovListener.onItemChange());
    }

}
