package com.zisal.learn.vaadin.constant;

/**
 * Created by Ladies Man on 4/21/2016.
 */
public interface ApplicationConstant {

    interface VAADINTheme {
        String VALO             = "valo";
    }

    interface View{
        String THEME            = VAADINTheme.VALO;
        interface ListOfValue {
            String CAPTION_PROPERTY = "data";
            interface DisplayDataRowTable{
                String ITEM_5       = "5";
                String ITEM_10      = "10";
                String ITEM_15      = "15";
                String ITEM_20      = "20";
                String ITEM_50      = "50";
                float WIDTH         = 80;
            }
            interface RowSelection{
            	String ALL = "ALL";
            	String NONE = "NONE";
            }
        }
    }

    interface Configuration{
        interface SpringConfiguration{
            String COMPONENT_SCAN   = "com.zisal.learn.vaadin";
        }
        String RESOURCE_BUNDLE_BASE_NAME    = "classpath:locale/message";
        int RB_CACHE_SECONDS    = 3600;
    }
}
