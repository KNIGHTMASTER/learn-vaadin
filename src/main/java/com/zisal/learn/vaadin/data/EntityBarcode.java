package com.zisal.learn.vaadin.data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Ladies Man on 5/18/2016.
 */
@Entity
@Table(name = "mst_barcode", schema = "master")
public class EntityBarcode implements Serializable{

    private static final long serialVersionUID = -5367409757533734891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "code")
    private String code;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
