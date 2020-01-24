package com.kunlong.dongxw.consts;

import java.util.HashMap;
import java.util.Map;

public class ProductTypeConst {
    //成品
    public static final int PT_PRD = 0;
    public static final int PT_HALF = 100;
    public static final int PT_RM = 200;

    static Map<Integer, String> mapStoreType = new HashMap<Integer, String>() {
        {
            put(PT_PRD, "成品");
            put(PT_HALF, "半成品");
            put(PT_RM, "原材料");
        }
    };

    public static final String getStoreType(int flag) {

        return mapStoreType.get(flag);
    }

}
