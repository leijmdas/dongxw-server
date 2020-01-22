package com.kunlong.dongxw.dongxw.domain;

import com.kunlong.platform.model.KunlongModel;

import java.io.Serializable;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class ProductBase extends KunlongModel implements Serializable {

	private static final long serialVersionUID = 1L;
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductType getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(ProductType productSubType) {
		this.productSubType = productSubType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// ==== 自定义属性 ====
	ProductType productType;
	ProductType productSubType;

	Customer customer;

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	String createByName;
}