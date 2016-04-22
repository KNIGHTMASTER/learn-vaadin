package com.zisal.learn.vaadin.constant;

import java.util.ResourceBundle;

/**
 * Created by Ladies Man on 4/21/2016.
 */
public interface ApplicationConstant {
    interface View{
        String THEME            = "valo";
    }

    interface Configuration{
        interface SpringConfiguration{
            String COMPONENT_SCAN   = "com.zisal.learn.vaadin";
        }
        String RESOURCE_BUNDLE_BASE_NAME    = "classpath:locale/message";
        int RB_CACHE_SECONDS    = 3600;
    }
}
