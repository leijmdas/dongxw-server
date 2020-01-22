package com.kunlong.dongxw.dongxw.domain;

import com.kunlong.platform.model.KunlongModel;

import java.io.Serializable;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class OrderLineBase extends KunlongModel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ==== 自定义属性 ====
	Customer customer;

	OrderMaster orderMaster;
	ProductType productType;
	ProductType parentProductType;
	Product product;
	//Supplier supplier;

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	String createByName;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderMaster getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(OrderMaster orderMaster) {
		this.orderMaster = orderMaster;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductType getParentProductType() {
		return parentProductType;
	}

	public void setParentProductType(ProductType parentProductType) {
		this.parentProductType = parentProductType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}