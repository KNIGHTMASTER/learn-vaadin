package com.zisal.learn.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

/**
 * Created by Achmad Fauzi on 4/21/2016.
 */
@SpringUI
@Theme(value = "valo")
public class VaadinUI extends UI{

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click me", e-> Notification.show("Hello Spring + Vaadin User")));
    }
}
