package com.zisal.learn.vaadin.ui.lov;

import com.vaadin.data.util.BeanItemContainer;

import java.io.Serializable;

/**
 * Created by Ladies Man on 4/22/2016.
 */
public class LOVParam<DATA> implements Serializable{

    private static final long serialVersionUID = -6737465365530313939L;

    private String caption;

    private BeanItemContainer<DATA> beanItemContainer;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public BeanItemContainer<DATA> getBeanItemContainer() {
        return beanItemContainer;
    }

    public void setBeanItemContainer(BeanItemContainer<DATA> beanItemContainer) {
        this.beanItemContainer = beanItemContainer;
    }
}
