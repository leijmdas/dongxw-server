package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Boolean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * OrderLine
 * @author generator
 * @date 2020年02月05日
 */
@ApiModel(value="OrderLineDTO",description="订单产品表")
public class OrderLineDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 订单产品标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "订单产品标识 ",required = false,notes = "订单产品标识  [自增]")
	private Integer id;
	/**
	  * 客户标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户标识 ",required = true,notes = "客户标识  ")
	private Integer customerId;
	/**
	  * 订单标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "订单标识 ",required = true,notes = "订单标识  ")
	private Integer orderId;
	/**
	  * 产品大类 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品大类 ",required = true,notes = "产品大类  ")
	private Integer parentId;
	/**
	  * 产品小类 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品小类 ",required = true,notes = "产品小类  ")
	private Integer productTypeId;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品标识 ",required = true,notes = "产品标识  ")
	private Integer productId;
	/**
	  * 数量 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "数量 ",required = true,notes = "数量  ")
	private Integer qty;
	/**
	  * 单价 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "单价 ",required = true,notes = "单价  ")
	private BigDecimal price;
	/**
	  * 金额 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "金额 ",required = true,notes = "金额  ")
	private BigDecimal money;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "建档时间 ",required = false,notes = "建档时间  ")
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "建档人 ",required = true,notes = "建档人  ")
	private Integer createBy;
	/**
	  * 备注 
	  * nullable:true,length:256
	  */
	@ApiModelProperty(value = "备注 ",required = false,notes = "备注  ")
	private String remark;
	/**
	  * 
	  * nullable:false,length:1
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Boolean status;
	/**
	  * 货币 
	  * nullable:false,length:16
	  */
	@ApiModelProperty(value = "货币 ",required = true,notes = "货币  ")
	private String currency;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public Integer getParentId(){
    	return this.parentId;
    }
    public void setParentId(Integer parentId){
    	this.parentId = parentId;
    }
    public Integer getProductTypeId(){
    	return this.productTypeId;
    }
    public void setProductTypeId(Integer productTypeId){
    	this.productTypeId = productTypeId;
    }
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
    }
    public Integer getQty(){
    	return this.qty;
    }
    public void setQty(Integer qty){
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
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Boolean getStatus(){
    	return this.status;
    }
    public void setStatus(Boolean status){
    	this.status = status;
    }
    public String getCurrency(){
    	return this.currency;
    }
    public void setCurrency(String currency){
    	this.currency = currency;
    }
    // ==== 自定义属性 ====
}