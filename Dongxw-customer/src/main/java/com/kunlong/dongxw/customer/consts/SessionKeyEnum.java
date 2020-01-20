package com.kunlong.dongxw.customer.consts;


//private static final long TOKEN_TIMEOUT = 7200;

public enum SessionKeyEnum {
	KEY_PREFIX ( "customer" ),

	WEB_CUSTOMER("customer"),
	WEB_CUSTOMER_ID("customerId"),

	PROMOTION_APP_CUSTOMERID("pApp:customerId"),
	WAP_CUSTOMERID("wap:customerId");

	private String key;
	SessionKeyEnum(String key){
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	
}
