package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Trade
 * @author generator
 * @date 2020年09月26日
 */
@ApiModel(value="TradeDTO",description="交易明细表")
public class TradeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 交易标识 int(11)
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "交易标识 int(11)",required = false,notes = "交易标识 int(11) [自增]")
	private Integer id;
	/**
	  * 交易主表标识 10 11 20 21 30 31 40 41
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "交易主表标识 10 11 20 21 30 31 40 41",required = true,notes = "交易主表标识 10 11 20 21 30 31 40 41 ")
	private Integer masterId;
	/**
	  * 月结标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "月结标识 r",required = true,notes = "月结标识 r ")
	private Integer mcId;
	/**
	  * 年月 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "年月 r",required = true,notes = "年月 r ")
	private Integer ym;
	/**
	  * 仓库  r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "仓库  r",required = true,notes = "仓库  r ")
	private Integer wh;
	/**
	  * 客户订单 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户订单 r",required = true,notes = "客户订单 r ")
	private Integer orderId;
	/**
	  * 客户订单编号 r
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "客户订单编号 r",required = true,notes = "客户订单编号 r ")
	private String orderCode;
	/**
	  * 采购订单 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "采购订单 r",required = true,notes = "采购订单 r ")
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
	  * 订单数量 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "订单数量 r",required = true,notes = "订单数量 r ")
	private BigDecimal qtyOrder;
	/**
	  * 完成数量 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "完成数量 r",required = true,notes = "完成数量 r ")
	private BigDecimal qtyFinish;
	/**
	  * 数量 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "数量 r",required = true,notes = "数量 r ")
	private BigDecimal qty;
	/**
	  * 备品数量 r
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "备品数量 r",required = true,notes = "备品数量 r ")
	private BigDecimal qtyBackup;
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
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getMasterId(){
    	return this.masterId;
    }
    public void setMasterId(Integer masterId){
    	this.masterId = masterId;
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
    public String getOrderCode(){
    	return this.orderCode;
    }
    public void setOrderCode(String orderCode){
    	this.orderCode = orderCode;
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
    public BigDecimal getQtyOrder(){
    	return this.qtyOrder;
    }
    public void setQtyOrder(BigDecimal qtyOrder){
    	this.qtyOrder = qtyOrder;
    }
    public BigDecimal getQtyFinish(){
    	return this.qtyFinish;
    }
    public void setQtyFinish(BigDecimal qtyFinish){
    	this.qtyFinish = qtyFinish;
    }
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
    }
    public BigDecimal getQtyBackup(){
    	return this.qtyBackup;
    }
    public void setQtyBackup(BigDecimal qtyBackup){
    	this.qtyBackup = qtyBackup;
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
    // ==== 自定义属性 ====
}