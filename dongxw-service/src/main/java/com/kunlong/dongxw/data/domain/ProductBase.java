package com.kunlong.dongxw.data.domain;

import com.kunlong.platform.model.KunlongModel;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;

import java.io.Serializable;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class ProductBase extends KunlongModel implements Serializable {
	public Integer getPrdFlagNot() {
		return prdFlagNot;
	}

	public void setPrdFlagNot(Integer prdFlagNot) {
		this.prdFlagNot = prdFlagNot;
	}

	private Integer prdFlagNot ;
	// ==== 自定义属性 ====
	ProductType productType;
	ProductType productSubType;

	Customer customer;
	String createByName;

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


	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}



}