package com.kunlong.dongxw.data.domain;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseOrderBase  {

    OrderMaster orderMaster;
    String createByName;
    String supplierName;
    Supplier supplier;

    List<PurchaseOrderItem> orderItems;
}
