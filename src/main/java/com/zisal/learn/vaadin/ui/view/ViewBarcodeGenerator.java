package com.zisal.learn.vaadin.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.data.EntityBarcode;
import com.zisal.learn.vaadin.data.RepoBarcode;
import com.zisal.learn.vaadin.ui.chooser.FileChooser;
import com.zisal.learn.vaadin.util.DCGeneratorParam;
import com.zisal.learn.vaadin.util.IDCGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ladies Man on 4/21/2016.
 */
@SpringView(name = ViewBarcodeGenerator.VIEW_NAME)
@UIScope
public class ViewBarcodeGenerator extends VerticalLayout implements View, IComponentInitalizer {

    private static final long serialVersionUID = 500666161853502479L;

    public static final String VIEW_NAME = "VIEW_BARCODE_GENERATOR";

    @Autowired
    IDCGenerator dcGenerator;

    @Autowired
    RepoBarcode repoBarcode;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        setSizeFull();
        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    private Component buildLoginForm(){
        final VerticalLayout panel = new VerticalLayout();
        panel.setSizeUndefined();
        panel.setSpacing(true);
        Responsive.makeResponsive(panel);
        panel.addStyleName("login-panel");


        Button button = new Button("Generate Barcode");

        //FileChooser fileChooser = new FileChooser("E://", "Pilih Folder", true);

        //panel.addComponent(fileChooser);
        panel.addComponent(button);



        List<EntityBarcode> entityBarcodes = (List<EntityBarcode>) repoBarcode.findAll();
        List<DCGeneratorParam> dcGeneratorParams = new ArrayList<>();
        for (EntityBarcode entityBarcode: entityBarcodes){
            DCGeneratorParam dcGeneratorParam = new DCGeneratorParam();
            dcGeneratorParam.setCode(entityBarcode.getCode());
            dcGeneratorParam.setFileName(entityBarcode.getCode().concat(".png"));
            dcGeneratorParam.setPath("E://BARCODE/");
            dcGeneratorParams.add(dcGeneratorParam);
        }

        button.addClickListener(e -> dcGenerator.generateBarcode(dcGeneratorParams));
        return panel;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

}
