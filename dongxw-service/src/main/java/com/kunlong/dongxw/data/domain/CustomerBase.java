package com.kunlong.dongxw.data.domain;

import com.kunlong.platform.model.KunlongModel;

import javax.persistence.Transient;

public class CustomerBase extends KunlongModel {
    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    // ==== 自定义属性 ====
    @Transient
    String createByName;

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    @Transient
    String saleType;
}
