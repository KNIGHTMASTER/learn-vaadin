package com.zisal.learn.vaadin.ui.view;

import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.component.IComponentInitalizer;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 4/21/2016.
 */
@SpringView(name = ViewAuth.VIEW_NAME)
@UIScope
public class ViewAuth extends VerticalLayout implements View, IComponentInitalizer {

    private static final long serialVersionUID = 7467966466747200914L;

    public static final String VIEW_NAME = "VIEW_AUTH";

    private TextField userName;
    private PasswordField password;

    @PostConstruct
    @Override
    public void init() throws Exception {
        setSizeFull();
        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    private Component buildLoginForm(){
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new CheckBox("Remember Me", true));
        return loginPanel;
    }

    private Component buildLabels(){
        CssLayout labels = new CssLayout();
        labels.addStyleName("labels");

        Label welcome = new Label("Welcome");
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = new Label("Login");
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);

        return labels;
    }

    private Component buildFields(){
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName("fields");

        userName = new TextField();
        userName.setIcon(FontAwesome.USER);
        userName.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        userName.setInputPrompt("User Name");

        password =  new PasswordField();
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        password.setInputPrompt("Password");

        final Button signIn = new Button("Sign in");
        signIn.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signIn.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        signIn.focus();

        fields.addComponents(userName, password, signIn);
        fields.setComponentAlignment(signIn, Alignment.BOTTOM_LEFT);

        signIn.addClickListener(event -> doLogin());
        return fields;
    }

    private void doLogin(){
        if (userName.getValue().equals("fauzi") && password.getValue().equals("fauzi123")){
            Notification.show("Success Login");
            getUI().getNavigator().navigateTo(ViewMain.VIEW_NAME);
        }else{
            Notification.show("Failed Login", Notification.Type.ERROR_MESSAGE);
        }
    }



    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }


}
