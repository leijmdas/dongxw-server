package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * OrderMaster
 * @author generator
 * @date 2020年01月03日
 */
@ApiModel(value="OrderMasterDTO",description="客户订单")
public class OrderMasterDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键 ",required = false,notes = "主键  [自增]")
	private Integer id;
	/**
	  * 客户 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户 ",required = true,notes = "客户  ")
	private Integer customerId;
	/**
	  * 业务员 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "业务员 ",required = true,notes = "业务员  ")
	private String businessBy;
	/**
	  * 状态 0-草稿1-下单2-在生产-3-生产完成4--发货完成5-收款完成
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "状态 0-草稿1-下单2-在生产-3-生产完成4--发货完成5-收款完成",required = true,notes = "状态 0-草稿1-下单2-在生产-3-生产完成4--发货完成5-收款完成 ")
	private Integer status;
	/**
	  * 客户订单号 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "客户订单号 ",required = true,notes = "客户订单号  ")
	private String customerOrderCode;
	/**
	  * EP订单号 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "EP订单号 ",required = true,notes = "EP订单号  ")
	private String epOrderCode;
	/**
	  * 下单日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "下单日期 ",required = false,notes = "下单日期  ")
	private Date orderDate;
	/**
	  * 客户交货日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "客户交货日期 ",required = false,notes = "客户交货日期  ")
	private Date customerIssueDate;
	/**
	  * 验货日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "验货日期 ",required = false,notes = "验货日期  ")
	private Date checkDate;
	/**
	  * 工厂交货日期 
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "工厂交货日期 ",required = false,notes = "工厂交货日期  ")
	private Date factroyIssueDate;
	/**
	  * 主料描述 
	  * nullable:false,length:512
	  */
	@ApiModelProperty(value = "主料描述 ",required = true,notes = "主料描述  ")
	private String materialRemark;
	/**
	  * 供应商 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "供应商 ",required = true,notes = "供应商  ")
	private Integer supplyId;
	/**
	  * 备注 
	  * nullable:false,length:512
	  */
	@ApiModelProperty(value = "备注 ",required = true,notes = "备注  ")
	private String remark;
	/**
	  * 订单图片存档 
	  * nullable:true,length:256
	  */
	@ApiModelProperty(value = "订单图片存档 ",required = false,notes = "订单图片存档  ")
	private String customerOrderImg;
	/**
	  * 发票编号 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "发票编号 ",required = true,notes = "发票编号  ")
	private String invoiceNo;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "建档人 ",required = true,notes = "建档人  ")
	private Integer createBy;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "建档时间 ",required = false,notes = "建档时间  ")
	private Date createDate;
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
    public String getBusinessBy(){
    	return this.businessBy;
    }
    public void setBusinessBy(String businessBy){
    	this.businessBy = businessBy;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
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
    public Date getOrderDate(){
    	return this.orderDate;
    }
    public void setOrderDate(Date orderDate){
    	this.orderDate = orderDate;
    }
    public Date getCustomerIssueDate(){
    	return this.customerIssueDate;
    }
    public void setCustomerIssueDate(Date customerIssueDate){
    	this.customerIssueDate = customerIssueDate;
    }
    public Date getCheckDate(){
    	return this.checkDate;
    }
    public void setCheckDate(Date checkDate){
    	this.checkDate = checkDate;
    }
    public Date getFactroyIssueDate(){
    	return this.factroyIssueDate;
    }
    public void setFactroyIssueDate(Date factroyIssueDate){
    	this.factroyIssueDate = factroyIssueDate;
    }
    public String getMaterialRemark(){
    	return this.materialRemark;
    }
    public void setMaterialRemark(String materialRemark){
    	this.materialRemark = materialRemark;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public String getCustomerOrderImg(){
    	return this.customerOrderImg;
    }
    public void setCustomerOrderImg(String customerOrderImg){
    	this.customerOrderImg = customerOrderImg;
    }
    public String getInvoiceNo(){
    	return this.invoiceNo;
    }
    public void setInvoiceNo(String invoiceNo){
    	this.invoiceNo = invoiceNo;
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