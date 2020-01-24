package com.kunlong.dongxw.customer.consts;

import java.util.HashMap;
import java.util.Map;

public class OrderTypeConsts {
    public static Integer TYPE_NORMARL = 0;
    public static Integer TYPE_PARENT = 100;
    public static Integer TYPE_SUB = 200;

    static Map<Integer, String> mapType = new HashMap<Integer, String>() {
        {
            put(TYPE_NORMARL, "普通订单");
            put(TYPE_PARENT, "父订单");
            put(TYPE_SUB, "子订单");
        }
    };


    public static final String getType(int type) {

        return mapType.get(type);
    }


}
