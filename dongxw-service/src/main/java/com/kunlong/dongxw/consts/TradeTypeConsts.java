package com.kunlong.dongxw.consts;

public class TradeTypeConsts {
    public static final int TradeTYPE_IN = 10;//入库，
    public static final int TradeTYPE_IN_CANCEL = 11;//取消入库
    public static final int TradeTYPE_OUT = 20;//领料
    public static final int TradeTYPEOUT_CANCEL = 21;//退料
    public static final int TradeTYPE_ISSUE = 30;//送货
    public static final int TradeTYPE_ISSUE_CANCEL = 31;//退货
    public static final int TradeTYPE_CHECK = 40;//盘点
    public static final int TradeTYPE_CHECK_CANCEL = 41;//取消盘点

    public static final int getType(Integer type){
        if(type==null){
            return -1;
        }

        return  0;
    }

}
