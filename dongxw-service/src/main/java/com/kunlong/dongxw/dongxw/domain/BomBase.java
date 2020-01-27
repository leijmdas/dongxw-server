package com.kunlong.dongxw.dongxw.domain;

import com.kunlong.platform.model.KunlongModel;

import java.io.Serializable;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class BomBase extends KunlongModel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ==== 自定义属性 ====
	ProductType productType;
	ProductType productSubType;
	//子件
	Product childRm;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	Product product;

	Customer customer;

	String createByName;

	public Product getChildRm() {
		return childRm;
	}

	public void setChildRm(Product childRm) {
		this.childRm = childRm;
	}

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


	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

}