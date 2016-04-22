package com.zisal.learn.vaadin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Ladies Man on 4/21/2016.
 */
@Service
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

    @Autowired
    MessageSource messageSource;

    @Override
    public String getMessage(String p_Id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(p_Id, null, locale);
    }
}
