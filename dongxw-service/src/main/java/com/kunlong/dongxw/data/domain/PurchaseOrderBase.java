package com.kunlong.dongxw.data.domain;

import lombok.Data;

@Data
public class PurchaseOrderBase  {

    OrderMaster orderMaster;
    String createByName;
    String supplierName;
}
