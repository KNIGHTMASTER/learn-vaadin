package com.zisal.learn.vaadin.util;

/**
 * Created by Ladies Man on 5/18/2016.
 */
public class DCGeneratorParam {

    private String code;
    private String path;
    private String fileName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "DCGeneratorParam{" +
                "code='" + code + '\'' +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
