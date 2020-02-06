package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.lang.Short;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * MakePlan
 * @author generator
 * @date 2020年02月05日
 */
@ApiModel(value="MakePlanDTO",description="生产计划表")
public class MakePlanDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 计划标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "计划标识 ",required = false,notes = "计划标识  [自增]")
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
	  * 订单产品标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "订单产品标识 ",required = true,notes = "订单产品标识  ")
	private Integer orderLineId;
	/**
	  * 发外标志 0--生产1--外发
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "发外标志 0--生产1--外发",required = true,notes = "发外标志 0--生产1--外发 ")
	private Integer outFlag;
	/**
	  * 接单日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "接单日期 ",required = false,notes = "接单日期  ")
	private Date orderDate;
	/**
	  * 外发备料 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "外发备料 ",required = true,notes = "外发备料  ")
	private Short outPrepareRm;
	/**
	  * 要求交期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "要求交期 ",required = false,notes = "要求交期  ")
	private Date issueDate;
	/**
	  * 物料到位日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "物料到位日期 ",required = false,notes = "物料到位日期  ")
	private Date rmDate;
	/**
	  * 包材到位日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "包材到位日期 ",required = false,notes = "包材到位日期  ")
	private Date pkgDate;
	/**
	  * 计划上线 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "计划上线 ",required = false,notes = "计划上线  ")
	private Date planStart;
	/**
	  * 计划完成 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "计划完成 ",required = false,notes = "计划完成  ")
	private Date planEnd;
	/**
	  * 实际完成日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "实际完成日期 ",required = false,notes = "实际完成日期  ")
	private Date realEnd;
	/**
	  * 完成标志 0--未完成1--完成
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "完成标志 0--未完成1--完成",required = false,notes = "完成标志 0--未完成1--完成 ")
	private Integer finishFlag;
	/**
	  * 审核状态 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "审核状态 ",required = true,notes = "审核状态  ")
	private Integer status;
	/**
	  * 备注 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "备注 ",required = false,notes = "备注  ")
	private String remark;
	/**
	  * 建档时间 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "建档时间 ",required = true,notes = "建档时间  ")
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "建档人 ",required = true,notes = "建档人  ")
	private Integer createBy;
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