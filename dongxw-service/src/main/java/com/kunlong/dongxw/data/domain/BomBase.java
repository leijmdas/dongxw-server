package com.kunlong.dongxw.data.domain;

import com.kunlong.platform.model.KunlongModel;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class BomBase extends KunlongModel implements Serializable {
	private static final long serialVersionUID = 1L;

    public static Bom defaultBom() {
        Bom bom = new Bom();
        bom.setProductId(-1);
        bom.setBigType(-1);
        bom.setSmallType(-1);
		bom.setPieces(Short.valueOf("1"));

        bom.setParentId(0);
        bom.setLossRate(Short.valueOf("0"));
        bom.setQty(BigDecimal.ZERO);
        bom.setEachQty(BigDecimal.ZERO);
        bom.setLossQty(BigDecimal.ZERO);
        bom.setLossMoney(BigDecimal.ZERO);
        bom.setMoney(BigDecimal.ZERO);
        bom.setUnit("0");
        bom.setPrice(BigDecimal.ZERO);
        bom.setLossType(0);
        bom.setCreateBy(-1);
        bom.setCreateDate(new Date());

        bom.setSource((byte)0);
        bom.setDepth(Short.valueOf("0"));

        bom.setKnifeQty(Short.valueOf("0"));
        bom.setSizeL(BigDecimal.ZERO);
        bom.setSizeW(BigDecimal.ZERO);
        bom.setSizeX(" ");
        bom.setWidth(0);
        bom.setLength(0);
        return bom;

    }


	// ==== 自定义属性 ====
	@Transient
	String rmIds ;
	@Transient
	BigDecimal lossMoney;
	//@Transient
	//BigDecimal totalMoney=money;

	ProductType productType;
	ProductType productSubType;
	// 子件
	Product childRm;
	public String getRmIds() {
		return rmIds;
	}

	public void setRmIds(String rmIds) {
		this.rmIds = rmIds;
	}

	public BigDecimal getLossMoney() {
		return lossMoney;
	}

	public void setLossMoney(BigDecimal lossMoney) {
		this.lossMoney = lossMoney;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	Product product;

	Customer customer;
	@Transient
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