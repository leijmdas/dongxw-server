package com.kunlong.dongxw.consts;

// ORDER_STATUS: [[0, '草稿'], [10, '下单'], [20, '生产中'], [30, '生产完成'],
// [40, '发货完成'], [50, '收款完成'], [100, '取消']],

import java.util.HashMap;
import java.util.Map;

public class OrderStatusConsts {
    public static int OrderStatus_DRAFT = 0;
    static Map<Integer, String> mapStatus = new HashMap<Integer, String>() {
        {
            put(0, "草稿");
            put(10, "下单");
            put(20, "生产中");
            put(30, "生产完成");
            put(40, "发货完成");
            put(50, "收款完成");
            put(100, "取消");
        }
    };


    public static final String getStatus(int type) {

        return mapStatus.get(type);
    }

}
