package com.zisal.learn.vaadin.ui.lov;

import java.math.BigInteger;

/**
 * Created by Ladies Man on 4/22/2016.
 */
public class LOVDto {
    private BigInteger id;
    private String data;

    public LOVDto(BigInteger id, String data) {
        this.id = id;
        this.data = data;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
