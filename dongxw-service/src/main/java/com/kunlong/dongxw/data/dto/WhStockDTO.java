package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * WhStock
 * @author generator
 * @date 2020年09月22日
 */
@ApiModel(value="WhStockDTO",description="库存")
public class WhStockDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "标识 ",required = false,notes = "标识  [自增]")
	private Integer id;
	/**
	  * 月结周期标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "月结周期标识 r",required = true,notes = "月结周期标识 r ")
	private Integer mcId;
	/**
	  * 年月 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "年月 r",required = true,notes = "年月 r ")
	private Integer ym;
	/**
	  * 仓库标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "仓库标识 r",required = true,notes = "仓库标识 r ")
	private Integer wh;
	/**
	  * 客户订单标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户订单标识 r",required = true,notes = "客户订单标识 r ")
	private Integer orderId;
	/**
	  * 采购订单标识 客户订单
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "采购订单标识 客户订单",required = true,notes = "采购订单标识 客户订单 ")
	private Integer poId;
	/**
	  * 客户 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户 r",required = true,notes = "客户 r ")
	private Integer customerId;
	/**
	  * 供应商 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "供应商 r",required = true,notes = "供应商 r ")
	private Integer supplyId;
	/**
	  * 存货分类 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "存货分类 r",required = true,notes = "存货分类 r ")
	private Integer stockType;
	/**
	  * 物料 0成品100 200
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "物料 0成品100 200",required = true,notes = "物料 0成品100 200 ")
	private Integer productId;
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
	  * 库存数量 
	  * nullable:false,length:34
	  */
	@ApiModelProperty(value = "库存数量 ",required = true,notes = "库存数量  ")
	private BigDecimal qty;
	/**
	  * 入库数量 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "入库数量 r",required = true,notes = "入库数量 r ")
	private BigDecimal qtyIn;
	/**
	  * 出库数量 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "出库数量 r",required = true,notes = "出库数量 r ")
	private BigDecimal qtyOut;
	/**
	  * 创建人 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "创建人 r",required = true,notes = "创建人 r ")
	private Integer createBy;
	/**
	  * 创建时间 r
	  * nullable:false,length:19
	  */
	@ApiModelProperty(value = "创建时间 r",required = true,notes = "创建时间 r ")
	private Date createDate;
	/**
	  * 备注 r
	  * nullable:false,length:1,024
	  */
	@ApiModelProperty(value = "备注 r",required = true,notes = "备注 r ")
	private String remark;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getMcId(){
    	return this.mcId;
    }
    public void setMcId(Integer mcId){
    	this.mcId = mcId;
    }
    public Integer getYm(){
    	return this.ym;
    }
    public void setYm(Integer ym){
    	this.ym = ym;
    }
    public Integer getWh(){
    	return this.wh;
    }
    public void setWh(Integer wh){
    	this.wh = wh;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public Integer getPoId(){
    	return this.poId;
    }
    public void setPoId(Integer poId){
    	this.poId = poId;
    }
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public Integer getStockType(){
    	return this.stockType;
    }
    public void setStockType(Integer stockType){
    	this.stockType = stockType;
    }
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
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
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
    }
    public BigDecimal getQtyIn(){
    	return this.qtyIn;
    }
    public void setQtyIn(BigDecimal qtyIn){
    	this.qtyIn = qtyIn;
    }
    public BigDecimal getQtyOut(){
    	return this.qtyOut;
    }
    public void setQtyOut(BigDecimal qtyOut){
    	this.qtyOut = qtyOut;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    public Date getCreateDate(){
    	return this.createDate;
    }
    public void setCreateDate(Date createDate){
    	this.createDate = createDate;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    // ==== 自定义属性 ====
}