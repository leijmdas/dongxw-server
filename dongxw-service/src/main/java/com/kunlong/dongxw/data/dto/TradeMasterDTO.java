package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.lang.Boolean;
import java.lang.Short;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * TradeMaster
 * @author generator
 * @date 2020年09月26日
 */
@ApiModel(value="TradeMasterDTO",description="交易主表")
public class TradeMasterDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 交易标识 int(11)
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "交易标识 int(11)",required = false,notes = "交易标识 int(11) [自增]")
	private Integer id;
	/**
	  * 月结标识 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "月结标识 r",required = true,notes = "月结标识 r ")
	private Integer mcId;
	/**
	  * 仓库  r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "仓库  r",required = true,notes = "仓库  r ")
	private Integer wh;
	/**
	  * 单号 varchar(32)
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "单号 varchar(32)",required = true,notes = "单号 varchar(32) ")
	private String code;
	/**
	  * 交易类型 10 20 30 40
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "交易类型 10 20 30 40",required = true,notes = "交易类型 10 20 30 40 ")
	private Integer tradeType;
	/**
	  * 交易状态 10草稿 20有效 30无效
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "交易状态 10草稿 20有效 30无效",required = true,notes = "交易状态 10草稿 20有效 30无效 ")
	private Integer status;
	/**
	  * 交易时间 r
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "交易时间 r",required = false,notes = "交易时间 r ")
	private Date tradeTime;
	/**
	  * 过帐标识 r
	  * nullable:false,length:1
	  */
	@ApiModelProperty(value = "过帐标识 r",required = true,notes = "过帐标识 r ")
	private Boolean calFlag;
	/**
	  * 产品名称 r
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "产品名称 r",required = true,notes = "产品名称 r ")
	private String prdName;
	/**
	  * 产品用途 r
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "产品用途 r",required = true,notes = "产品用途 r ")
	private String useExp;
	/**
	  * 客户 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户 r",required = true,notes = "客户 r ")
	private Integer customerId;
	/**
	  * 客户名称 r
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "客户名称 r",required = true,notes = "客户名称 r ")
	private String custName;
	/**
	  * 付款方式 r
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "付款方式 r",required = true,notes = "付款方式 r ")
	private String payMode;
	/**
	  * 供方 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "供方 r",required = true,notes = "供方 r ")
	private Integer supplyId;
	/**
	  * 领料部门 r
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "领料部门 r",required = true,notes = "领料部门 r ")
	private String useDpt;
	/**
	  * 客户订单 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户订单 r",required = true,notes = "客户订单 r ")
	private Integer orderId;
	/**
	  * 交易人 r
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "交易人 r",required = true,notes = "交易人 r ")
	private String tradeBy;
	/**
	  * 采购订单 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "采购订单 r",required = true,notes = "采购订单 r ")
	private Integer poId;
	/**
	  * 制单人 r
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "制单人 r",required = true,notes = "制单人 r ")
	private String sheetBy;
	/**
	  * 交货仓库 r
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "交货仓库 r",required = true,notes = "交货仓库 r ")
	private String issueWh;
	/**
	  * 货送联系人 r
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "货送联系人 r",required = true,notes = "货送联系人 r ")
	private String contact;
	/**
	  * 交货地址 r
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "交货地址 r",required = true,notes = "交货地址 r ")
	private String issueAddr;
	/**
	  * 送货联系电话 r
	  * nullable:false,length:31
	  */
	@ApiModelProperty(value = "送货联系电话 r",required = true,notes = "送货联系电话 r ")
	private String tel;
	/**
	  * 
	  * nullable:false,length:8
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Short tradeCount;
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
    public Integer getWh(){
    	return this.wh;
    }
    public void setWh(Integer wh){
    	this.wh = wh;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public Integer getTradeType(){
    	return this.tradeType;
    }
    public void setTradeType(Integer tradeType){
    	this.tradeType = tradeType;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public Date getTradeTime(){
    	return this.tradeTime;
    }
    public void setTradeTime(Date tradeTime){
    	this.tradeTime = tradeTime;
    }
    public Boolean getCalFlag(){
    	return this.calFlag;
    }
    public void setCalFlag(Boolean calFlag){
    	this.calFlag = calFlag;
    }
    public String getPrdName(){
    	return this.prdName;
    }
    public void setPrdName(String prdName){
    	this.prdName = prdName;
    }
    public String getUseExp(){
    	return this.useExp;
    }
    public void setUseExp(String useExp){
    	this.useExp = useExp;
    }
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public String getCustName(){
    	return this.custName;
    }
    public void setCustName(String custName){
    	this.custName = custName;
    }
    public String getPayMode(){
    	return this.payMode;
    }
    public void setPayMode(String payMode){
    	this.payMode = payMode;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public String getUseDpt(){
    	return this.useDpt;
    }
    public void setUseDpt(String useDpt){
    	this.useDpt = useDpt;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public String getTradeBy(){
    	return this.tradeBy;
    }
    public void setTradeBy(String tradeBy){
    	this.tradeBy = tradeBy;
    }
    public Integer getPoId(){
    	return this.poId;
    }
    public void setPoId(Integer poId){
    	this.poId = poId;
    }
    public String getSheetBy(){
    	return this.sheetBy;
    }
    public void setSheetBy(String sheetBy){
    	this.sheetBy = sheetBy;
    }
    public String getIssueWh(){
    	return this.issueWh;
    }
    public void setIssueWh(String issueWh){
    	this.issueWh = issueWh;
    }
    public String getContact(){
    	return this.contact;
    }
    public void setContact(String contact){
    	this.contact = contact;
    }
    public String getIssueAddr(){
    	return this.issueAddr;
    }
    public void setIssueAddr(String issueAddr){
    	this.issueAddr = issueAddr;
    }
    public String getTel(){
    	return this.tel;
    }
    public void setTel(String tel){
    	this.tel = tel;
    }
    public Short getTradeCount(){
    	return this.tradeCount;
    }
    public void setTradeCount(Short tradeCount){
    	this.tradeCount = tradeCount;
    }
    // ==== 自定义属性 ====
}