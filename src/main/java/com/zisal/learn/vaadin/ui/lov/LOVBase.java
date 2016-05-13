package com.zisal.learn.vaadin.ui.lov;

import com.vaadin.ui.ComboBox;
import com.zisal.learn.vaadin.component.IUNAComponent;
import com.zisal.learn.vaadin.component.IViewInitalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.zisal.learn.vaadin.constant.ApplicationConstant.View.ListOfValue.CAPTION_PROPERTY;

/**
 * Created by Ladies Man on 4/22/2016.
 */
public abstract class LOVBase extends ComboBox implements IUNAComponent<LOVParam, ComboBox>, IViewInitalizer {

    private static final long serialVersionUID = -224953578935535606L;

    private LOVParam LOVParam;

    protected Logger logger = LoggerFactory.getLogger(LOVBase.class);

    @Override
    public void init() throws Exception{
        if(LOVParam == null){
            logger.info("LOVParam is null");
        }else{
            this.setContainerDataSource(LOVParam.getBeanItemContainer());
            this.setItemCaptionMode(ItemCaptionMode.PROPERTY);
            this.setItemCaptionPropertyId(CAPTION_PROPERTY);
            this.setTextInputAllowed(false);
            this.setCaption(LOVParam.getCaption());
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
