package com.zisal.learn.vaadin.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.vaadin.ui.Notification;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.constant.GeneralConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ladies Man on 5/18/2016.
 */
@Component
public class DimensionalCodeGenerator implements IDCGenerator, IComponentInitalizer{

    private Logger logger = LoggerFactory.getLogger(DimensionalCodeGenerator.class);

    private BitMatrix bitMatrix;
    private Writer writer;
    private DCGeneratorParam dcGeneratorParam;
    private String filePath;


    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        writer = new QRCodeWriter();
    }


    @Override
    public void generateBarcode() {
        try {
            bitMatrix = new Code128Writer().encode(dcGeneratorParam.getCode(), BarcodeFormat.CODE_128, 150, 80, null);
            filePath = dcGeneratorParam.getPath().concat(dcGeneratorParam.getFileName());
            logger.info("File Path : "+filePath);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(filePath)));
            logger.info("Success Generate BARCODE ");
        } catch (Exception e) {
            showErrorNotification();
            e.printStackTrace();
        }
    }



    private void showErrorNotification(){
        Notification.show("Error Process",
                "This process can not continue",
                Notification.Type.ERROR_MESSAGE);
    }

    @Override
    public void generateBarcode(List<DCGeneratorParam> dcGeneratorParams) {
        for (DCGeneratorParam generatorParam : dcGeneratorParams){
            setParamComponent(generatorParam);
            generateBarcode();
        }
    }

    @Override
    public void generateQRCode() {
        try {
            bitMatrix = writer.encode(dcGeneratorParam.getCode(), BarcodeFormat.QR_CODE, 200, 200);
            try {
                filePath = dcGeneratorParam.getPath().concat(GeneralConstant.Punctuation.DOUBLE_SLASH.concat(dcGeneratorParam.getFileName()));
                MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generatePDF417() {
        writer = new PDF417Writer();
        try {
            bitMatrix = writer.encode(dcGeneratorParam.getCode(), BarcodeFormat.PDF_417, 80, 150);
            try {
                filePath = dcGeneratorParam.getPath().concat(GeneralConstant.Punctuation.DOUBLE_SLASH.concat(dcGeneratorParam.getFileName()));
                MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setParamComponent(DCGeneratorParam p_Component) {
        this.dcGeneratorParam = p_Component;
    }

    @Override
    public DCGeneratorParam getParamComponent() {
        return dcGeneratorParam;
    }
}
