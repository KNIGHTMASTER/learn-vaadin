package com.zisal.learn.vaadin.util;

import com.zisal.learn.vaadin.component.IParamComponent;

import java.util.List;

/**
 * Created by Ladies Man on 5/18/2016.
 */
public interface IDCGenerator extends IParamComponent<DCGeneratorParam> {

    void generateBarcode();

    void generateBarcode(List<DCGeneratorParam> dcGeneratorParams);

    void generateQRCode();

    void generatePDF417();
}
