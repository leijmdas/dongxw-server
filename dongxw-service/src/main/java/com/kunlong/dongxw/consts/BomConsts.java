package com.kunlong.dongxw.consts;

import java.util.HashMap;
import java.util.Map;

public class BomConsts {
    public static Integer TYPE_LOSS_RATE = 1;
    public static Integer TYPE_LOSS_QTY = 0;
    public static Integer TYPE_SUB = 200;

    static Map<Integer, String> mapType = new HashMap<Integer, String>() {
        {
//            put(TYPE_NORMARL, "'损耗率(%)'");
//            put(TYPE_PARENT, "'损耗数'");
//            put(TYPE_SUB, "子订单");
        }
    };


    public static final String getType(int type) {

        return mapType.get(type);
    }


}
