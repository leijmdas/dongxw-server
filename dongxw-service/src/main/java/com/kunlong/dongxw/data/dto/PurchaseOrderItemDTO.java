package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * PurchaseOrderItem
 * @author generator
 * @date 2020年03月08日
 */
@ApiModel(value="PurchaseOrderItemDTO",description="采购清单")
public class PurchaseOrderItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "标识 ",required = false,notes = "标识  [自增]")
	private Integer id;
	/**
	  * 采购订单主表 客户订单
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "采购订单主表 客户订单",required = true,notes = "采购订单主表 客户订单 ")
	private Integer purchaseOrderId;
	/**
	  *   生产计划产品标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "  生产计划产品标识 r",required = true,notes = "  生产计划产品标识 r ")
	private Integer makePlanId;
	/**
	  * 客户订单产品标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户订单产品标识 r",required = true,notes = "客户订单产品标识 r ")
	private Integer orderLineId;
	/**
	  * 产品 0成品100 200
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品 0成品100 200",required = true,notes = "产品 0成品100 200 ")
	private Integer productId;
	/**
	  * 数量 
	  * nullable:false,length:34
	  */
	@ApiModelProperty(value = "数量 ",required = true,notes = "数量  ")
	private BigDecimal qty;
	/**
	  * 单价 r
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "单价 r",required = true,notes = "单价 r ")
	private BigDecimal price;
	/**
	  * 金额 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "金额 r",required = true,notes = "金额 r ")
	private BigDecimal money;
	/**
	  * 备注 r
	  * nullable:false,length:1,024
	  */
	@ApiModelProperty(value = "备注 r",required = true,notes = "备注 r ")
	private String remark;
	/**
	  * 创建时间 r
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "创建时间 r",required = true,notes = "创建时间 r ")
	private Date createDate;
	/**
	  * 创建人 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "创建人 r",required = true,notes = "创建人 r ")
	private Integer createBy;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getPurchaseOrderId(){
    	return this.purchaseOrderId;
    }
    public void setPurchaseOrderId(Integer purchaseOrderId){
    	this.purchaseOrderId = purchaseOrderId;
    }
    public Integer getMakePlanId(){
    	return this.makePlanId;
    }
    public void setMakePlanId(Integer makePlanId){
    	this.makePlanId = makePlanId;
    }
    public Integer getOrderLineId(){
    	return this.orderLineId;
    }
    public void setOrderLineId(Integer orderLineId){
    	this.orderLineId = orderLineId;
    }
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
    }
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
    }
    public BigDecimal getPrice(){
    	return this.price;
    }
    public void setPrice(BigDecimal price){
    	this.price = price;
    }
    public BigDecimal getMoney(){
    	return this.money;
    }
    public void setMoney(BigDecimal money){
    	this.money = money;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Date getCreateDate(){
    	return this.createDate;
    }
    public void setCreateDate(Date createDate){
    	this.createDate = createDate;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    // ==== 自定义属性 ====
}