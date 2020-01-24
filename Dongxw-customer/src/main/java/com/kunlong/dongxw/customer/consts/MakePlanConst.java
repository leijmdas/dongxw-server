package com.kunlong.dongxw.customer.consts;

import java.util.HashMap;
import java.util.Map;

public class MakePlanConst {
        //0--自产1--外发
    public static final int OUT_FLAG_SELF = 0;
    public static final int OUT_FLAG_OUT =1;
    //FINISH_FLAG: [[1, '完成'], [0, '未完成']],
    public static final int FINISH_FLAG = 1;
    public static final int FINISH_FLAG_UN = 0;

    static Map<Integer, String> mapOutFlag = new HashMap<Integer, String>() {
        {
            put(OUT_FLAG_SELF, "自产");
            put(OUT_FLAG_OUT, "外发");
        }
    };

    static Map<Integer, String> mapFinishFlag = new HashMap<Integer, String>() {
        {
            put(FINISH_FLAG, "完成");
            put(FINISH_FLAG_UN, "未完成");
        }
    };


    public static final String getOutFlag(int flag) {

        return mapOutFlag.get(flag);
    }
    public static final String getFinishFlag(int flag) {

        return mapFinishFlag.get(flag);
    }

}
