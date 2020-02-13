package com.kunlong.dongxw.consts;

import java.util.HashMap;
import java.util.Map;

public class BomConsts {
    public static Integer HAS_COM = 1;
    public static Integer NO_COM = 0;

    public static Integer TYPE_LOSS_QTY = 0;
    public static Integer TYPE_LOSS_RATE = 1;

    static Map<Integer, String> mapType = new HashMap<Integer, String>() {
        {
            put(TYPE_LOSS_QTY, "损耗数");
            put(TYPE_LOSS_RATE, "损耗率(%)");
        }
    };


    public static final String getType(int type) {

        return mapType.get(type);
    }


}
