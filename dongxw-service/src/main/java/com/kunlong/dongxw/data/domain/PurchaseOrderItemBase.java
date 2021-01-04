package com.kunlong.dongxw.data.domain;

import lombok.Data;

@Data
public class PurchaseOrderItemBase {
    String makePlanIds;
    String purchasePlanIds;

    Product product;
    String createByName;
    public String getMakePlanIds() {
        return makePlanIds;
    }

    public void setMakePlanIds(String makePlanIds) {
        this.makePlanIds = makePlanIds;
    }

    public String getPurchasePlanIds() {
        return purchasePlanIds;
    }

    public void setPurchasePlanIds(String purchasePlanIds) {
        this.purchasePlanIds = purchasePlanIds;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }


}
