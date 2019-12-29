package com.kunlong.dongxw.consts;

public class OrderConsts {
    //    ORDER_STATUS: [[0, '草稿'], [1, '下单'], [2, '在生产'], [3, '生产完成'], [4, '发货完成'], [5, '收款完成']],
    //0'草稿'
    public static int ORDER_STATUS_DRAFT = 0;
    //1下单
    public static int ORDER_STATUS_ORDERED = 1;

    //2 在生产
    public static int ORDER_STATUS_MAKE = 2;
    //3 生产完成
    public static int ORDER_STATUS_MAKE_FINISH = 3;
    //4 发货完成
    public static int ORDER_STATUS_ISSUED = 4;
    //5 收款完成
    public static int ORDER_STATUS_RECEIVED = 5;

}
