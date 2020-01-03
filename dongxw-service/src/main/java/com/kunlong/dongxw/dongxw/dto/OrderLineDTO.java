package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.Byte;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * OrderLine
 * @author generator
 * @date 2020年01月04日
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
	  * 客款号 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "客款号 ",required = true,notes = "客款号  ")
	private String customerCode;
	/**
	  * 图片 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "图片 ",required = true,notes = "图片  ")
	private String picUrl;
	/**
	  * 尺寸 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "尺寸 ",required = true,notes = "尺寸  ")
	private String size;
	/**
	  * 配色 
	  * nullable:false,length:16
	  */
	@ApiModelProperty(value = "配色 ",required = true,notes = "配色  ")
	private String color;
	/**
	  * 数量 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "数量 ",required = true,notes = "数量  ")
	private Integer qty;
	/**
	  * 单位 
	  * nullable:false,length:16
	  */
	@ApiModelProperty(value = "单位 ",required = true,notes = "单位  ")
	private String unit;
	/**
	  * 单价 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "单价 ",required = true,notes = "单价  ")
	private BigDecimal price;
	/**
	  * 货币 
	  * nullable:false,length:16
	  */
	@ApiModelProperty(value = "货币 ",required = true,notes = "货币  ")
	private String currency;
	/**
	  * 金额 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "金额 ",required = true,notes = "金额  ")
	private BigDecimal money;
	/**
	  * 供应商 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "供应商 ",required = true,notes = "供应商  ")
	private Integer supplierId;
	/**
	  * 主料 
	  * nullable:false,length:512
	  */
	@ApiModelProperty(value = "主料 ",required = true,notes = "主料  ")
	private String material;
	/**
	  * 内盒数量 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "内盒数量 ",required = true,notes = "内盒数量  ")
	private Integer ibQty;
	/**
	  * 毛重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "毛重 ",required = true,notes = "毛重  ")
	private BigDecimal ibGw;
	/**
	  * 净重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "净重 ",required = true,notes = "净重  ")
	private BigDecimal ibNw;
	/**
	  * 内盒尺寸 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "内盒尺寸 ",required = true,notes = "内盒尺寸  ")
	private String ibSize;
	/**
	  * 外箱数量 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "外箱数量 ",required = true,notes = "外箱数量  ")
	private Integer obQty;
	/**
	  * 毛重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "毛重 ",required = true,notes = "毛重  ")
	private BigDecimal obGw;
	/**
	  * 净重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "净重 ",required = true,notes = "净重  ")
	private BigDecimal obNw;
	/**
	  * 外箱尺寸 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "外箱尺寸 ",required = true,notes = "外箱尺寸  ")
	private String obSize;
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
	  * 状态 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态 ",required = true,notes = "状态  ")
	private Byte status;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
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
    public String getCustomerCode(){
    	return this.customerCode;
    }
    public void setCustomerCode(String customerCode){
    	this.customerCode = customerCode;
    }
    public String getPicUrl(){
    	return this.picUrl;
    }
    public void setPicUrl(String picUrl){
    	this.picUrl = picUrl;
    }
    public String getSize(){
    	return this.size;
    }
    public void setSize(String size){
    	this.size = size;
    }
    public String getColor(){
    	return this.color;
    }
    public void setColor(String color){
    	this.color = color;
    }
    public Integer getQty(){
    	return this.qty;
    }
    public void setQty(Integer qty){
    	this.qty = qty;
    }
    public String getUnit(){
    	return this.unit;
    }
    public void setUnit(String unit){
    	this.unit = unit;
    }
    public BigDecimal getPrice(){
    	return this.price;
    }
    public void setPrice(BigDecimal price){
    	this.price = price;
    }
    public String getCurrency(){
    	return this.currency;
    }
    public void setCurrency(String currency){
    	this.currency = currency;
    }
    public BigDecimal getMoney(){
    	return this.money;
    }
    public void setMoney(BigDecimal money){
    	this.money = money;
    }
    public Integer getSupplierId(){
    	return this.supplierId;
    }
    public void setSupplierId(Integer supplierId){
    	this.supplierId = supplierId;
    }
    public String getMaterial(){
    	return this.material;
    }
    public void setMaterial(String material){
    	this.material = material;
    }
    public Integer getIbQty(){
    	return this.ibQty;
    }
    public void setIbQty(Integer ibQty){
    	this.ibQty = ibQty;
    }
    public BigDecimal getIbGw(){
    	return this.ibGw;
    }
    public void setIbGw(BigDecimal ibGw){
    	this.ibGw = ibGw;
    }
    public BigDecimal getIbNw(){
    	return this.ibNw;
    }
    public void setIbNw(BigDecimal ibNw){
    	this.ibNw = ibNw;
    }
    public String getIbSize(){
    	return this.ibSize;
    }
    public void setIbSize(String ibSize){
    	this.ibSize = ibSize;
    }
    public Integer getObQty(){
    	return this.obQty;
    }
    public void setObQty(Integer obQty){
    	this.obQty = obQty;
    }
    public BigDecimal getObGw(){
    	return this.obGw;
    }
    public void setObGw(BigDecimal obGw){
    	this.obGw = obGw;
    }
    public BigDecimal getObNw(){
    	return this.obNw;
    }
    public void setObNw(BigDecimal obNw){
    	this.obNw = obNw;
    }
    public String getObSize(){
    	return this.obSize;
    }
    public void setObSize(String obSize){
    	this.obSize = obSize;
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
    public Byte getStatus(){
    	return this.status;
    }
    public void setStatus(Byte status){
    	this.status = status;
    }
    // ==== 自定义属性 ====
}