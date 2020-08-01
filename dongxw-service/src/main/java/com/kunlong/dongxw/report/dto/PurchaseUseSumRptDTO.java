package com.kunlong.dongxw.report.dto;

import com.google.common.collect.ImmutableMap;
import com.kunlong.dongxw.report.base.IRptDTO;
import com.kunlong.platform.model.KunlongModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

//MW订单物料采购进度表
@Data
public class PurchaseUseSumRptDTO extends KunlongModel implements IRptDTO {

    public String[] getHeaders() {
        List<String> ts = new ArrayList<>();
        ts.addAll( headersStart.values() );
        if (this.getMap() != null) {
            ts.addAll(getMap().keySet());

        }

        ts.addAll( headersEnd.values() );
        String[] newHeaders = new String[ts.size()];
        ts.toArray(newHeaders);

        return newHeaders;
    }



    //public transient String[] headersStart = {"物料编码", "物料名称", "颜色" };
    transient Map<String, String> headersStart = ImmutableMap.<String, String>builder()
            .put("code", "物料编码")
            .put("name", "物料名称")
            .put("color", "颜色").build();

    // public transient String[] headersEnd = {  "汇总",  "单位", "库存", "采购量",  "供应商", "订购数量", "回仓数量", "发出数量"};
    transient Map<String, String> headersEnd = ImmutableMap.<String, String>builder()
            .put("sum", "汇总")
            .put("unit", "单位")
            .put("stock", "库存")
            .put("purchaseQty", "采购量")
            .put("supplyName", "供应商")
            .put("purchaseOrderQty", "订购数量")
            .put("reback", "回仓数量")
            .put("issuse", "发出数量")


            .build();


    //物料编码
    String code;

    String name;

    String color;

    Map<String,Object> map;

    //汇总 单位	库存	采购量	供应商	订购数量	回仓数量	发出数量
    BigDecimal sum;
    String unit;
    BigDecimal stock;
    BigDecimal purchaseQty;
    String supplyName;
    BigDecimal purchaseOrderQty;
    BigDecimal reback;
    BigDecimal issuse;

    public PurchaseUseSumRptDTO(){
         //KunlongModel.setDefault(this);
    }


}
