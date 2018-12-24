package com.zisal.learn.vaadin.ui.lov;

import com.vaadin.ui.ComboBox;
import com.zisal.learn.vaadin.component.IComponent;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import static com.zisal.learn.vaadin.constant.ApplicationConstant.View.ListOfValue.CAPTION_PROPERTY;

/**
 * Created by Ladies Man on 4/22/2016.
 */
public abstract class LOVBase extends ComboBox implements IComponent<LOVParam, ComboBox>, IComponentInitalizer {

    private static final long serialVersionUID = -224953578935535606L;

    protected LOVParam LOVParam;

    protected Logger logger = LoggerFactory.getLogger(LOVBase.class);

    @Autowired
    protected MessageSource messageSource;

    @Override
    public void initComponents() throws Exception{
        if(LOVParam == null){
            logger.error(messageSource.getMessage("ui.lov.param.error.null", null, getLocale()));
        }else{
            this.setContainerDataSource(LOVParam.getBeanItemContainer());
            this.setItemCaptionMode(ItemCaptionMode.PROPERTY);
            this.setItemCaptionPropertyId(CAPTION_PROPERTY);
        }
    }

    @Override
    public void setParamComponent(LOVParam p_Component) {
        this.LOVParam = p_Component;
    }

    @Override
    public LOVParam getParamComponent() {
        return LOVParam;
    }

    @Override
    public ComboBox getResultComponent() {
        return this;
    }
}
