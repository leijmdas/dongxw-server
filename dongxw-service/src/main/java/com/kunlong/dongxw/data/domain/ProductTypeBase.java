package com.kunlong.dongxw.data.domain;

import java.io.Serializable;

public class ProductTypeBase implements Serializable {
    private Integer prdFlagNot ;


    private ProductType pProductType;


    public ProductType getpProductType() {
        return pProductType;
    }

    public void setpProductType(ProductType pProductType) {
        this.pProductType = pProductType;
    }

    public Integer getPrdFlagNot() {
        return prdFlagNot;
    }

    public void setPrdFlagNot(Integer prdFlagNot) {
        this.prdFlagNot = prdFlagNot;
    }


}
