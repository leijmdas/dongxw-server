package com.kunlong.dongxw.consts;

public class MoneyTypeConsts {
    public static final String MONEYTYPE_CHINA = "CNY";
    public static final String MONEYTYPE_HONGKONG = "港元";
    public static final String MONEYTYPE_AMERICAN = "美元";

    public static final String getMoneyType(Integer type){
        if(type==null){
            return "-";
        }
        // MONEY_TYPE: [ [100, '人民币'], [200, '美元'], [300, '港币'] ]
        if(type==100){
            return MONEYTYPE_CHINA;
        }
        if(type==200){
            return MONEYTYPE_AMERICAN;
        }
        if(type==300){
            return MONEYTYPE_HONGKONG;
        }

        return  "-";
    }

}
