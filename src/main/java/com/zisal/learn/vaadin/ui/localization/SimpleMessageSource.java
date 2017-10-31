package com.zisal.learn.vaadin.ui.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


/**
 * Created by Ladies Man on 5/15/2016.
 */
@Component
public class SimpleMessageSource {

    @Autowired
    MessageSource messageSource;

    private String key;

    public String getMessage() throws Exception{
        return messageSource.getMessage(key, null, Locale.getDefault());
    }

    public String getMessage(String p_Key) throws Exception{
        return messageSource.getMessage(p_Key, null, Locale.getDefault());
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
