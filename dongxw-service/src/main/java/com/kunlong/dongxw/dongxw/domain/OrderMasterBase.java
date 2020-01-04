package com.kunlong.dongxw.dongxw.domain;


import java.io.Serializable;
/**
 * OrderMaster 客户订单
 * @author generator
 * @date 2020年01月03日
 */
public class OrderMasterBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// ==== 自定义属性 ====
	Customer customer;

}