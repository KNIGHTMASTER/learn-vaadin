package com.zisal.learn.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.constant.ApplicationConstant.View;
import com.zisal.learn.vaadin.constant.GeneralConstant;
import com.zisal.learn.vaadin.ui.view.ViewAuth;
import com.zisal.learn.vaadin.ui.view.ViewMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by Achmad Fauzi on 4/21/2016.
 */
@SpringUI
@Theme(value = View.THEME)
public class UIMain extends UI implements ErrorHandler, Serializable{

    private static final long serialVersionUID = -7306067026718781942L;

    private Logger logger = LoggerFactory.getLogger(UIMain.class);

    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("Main VIew", ViewMain.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Auth VIew", ViewAuth.VIEW_NAME));
        root.addComponent(navigationBar);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        navigator.addView(GeneralConstant.Punctuation.EMPTY, ViewMain.class);
        navigator.addView(ViewAuth.class.getSimpleName(), ViewAuth.class);
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }


    @Override
    public void error(com.vaadin.server.ErrorEvent errorEvent) {
        Notification.show("Error "+errorEvent.toString());
    }
}
