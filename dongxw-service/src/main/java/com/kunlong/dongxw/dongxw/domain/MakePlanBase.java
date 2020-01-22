package com.kunlong.dongxw.dongxw.domain;

public class MakePlanBase extends OrderLineBase {
    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    OrderLine orderLine;
}
