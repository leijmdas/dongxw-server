package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
import java.util.Date;
import java.lang.Short;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * VOrderPlan
 * @author generator
 * @date 2020年03月21日
 */
@ApiModel(value="VOrderPlanDTO",description="VIEW")
public class VOrderPlanDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String customerOrderCode;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String epOrderCode;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer orderStatus;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer customerId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer orderId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer orderLineId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer outFlag;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date orderDate;
	/**
	  * 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Short outPrepareRm;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date issueDate;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date rmDate;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date pkgDate;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date planStart;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date planEnd;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Date realEnd;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Integer finishFlag;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer status;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String remark;
	/**
	  * 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Date createDate;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer createBy;
    public String getCustomerOrderCode(){
    	return this.customerOrderCode;
    }
    public void setCustomerOrderCode(String customerOrderCode){
    	this.customerOrderCode = customerOrderCode;
    }
    public String getEpOrderCode(){
    	return this.epOrderCode;
    }
    public void setEpOrderCode(String epOrderCode){
    	this.epOrderCode = epOrderCode;
    }
    public Integer getOrderStatus(){
    	return this.orderStatus;
    }
    public void setOrderStatus(Integer orderStatus){
    	this.orderStatus = orderStatus;
    }
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
    public Integer getOrderLineId(){
    	return this.orderLineId;
    }
    public void setOrderLineId(Integer orderLineId){
    	this.orderLineId = orderLineId;
    }
    public Integer getOutFlag(){
    	return this.outFlag;
    }
    public void setOutFlag(Integer outFlag){
    	this.outFlag = outFlag;
    }
    public Date getOrderDate(){
    	return this.orderDate;
    }
    public void setOrderDate(Date orderDate){
    	this.orderDate = orderDate;
    }
    public Short getOutPrepareRm(){
    	return this.outPrepareRm;
    }
    public void setOutPrepareRm(Short outPrepareRm){
    	this.outPrepareRm = outPrepareRm;
    }
    public Date getIssueDate(){
    	return this.issueDate;
    }
    public void setIssueDate(Date issueDate){
    	this.issueDate = issueDate;
    }
    public Date getRmDate(){
    	return this.rmDate;
    }
    public void setRmDate(Date rmDate){
    	this.rmDate = rmDate;
    }
    public Date getPkgDate(){
    	return this.pkgDate;
    }
    public void setPkgDate(Date pkgDate){
    	this.pkgDate = pkgDate;
    }
    public Date getPlanStart(){
    	return this.planStart;
    }
    public void setPlanStart(Date planStart){
    	this.planStart = planStart;
    }
    public Date getPlanEnd(){
    	return this.planEnd;
    }
    public void setPlanEnd(Date planEnd){
    	this.planEnd = planEnd;
    }
    public Date getRealEnd(){
    	return this.realEnd;
    }
    public void setRealEnd(Date realEnd){
    	this.realEnd = realEnd;
    }
    public Integer getFinishFlag(){
    	return this.finishFlag;
    }
    public void setFinishFlag(Integer finishFlag){
    	this.finishFlag = finishFlag;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
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