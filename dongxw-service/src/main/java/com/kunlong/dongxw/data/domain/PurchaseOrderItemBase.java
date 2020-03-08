package com.kunlong.dongxw.data.domain;

import lombok.Data;

@Data
public class PurchaseOrderItemBase {
    String makePlanIds;
    Product product;
    String createByName;
}
