package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * PurchaseOrder
 * @author generator
 * @date 2020年03月07日
 */
@ApiModel(value="PurchaseOrderDTO",description="采购单")
public class PurchaseOrderDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "标识 ",required = false,notes = "标识  [自增]")
	private Integer id;
	/**
	  * 客户订单 客户订单
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "客户订单 客户订单",required = true,notes = "客户订单 客户订单 ")
	private Integer orderId;
	/**
	  * 供应商 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "供应商 r",required = true,notes = "供应商 r ")
	private Integer supplyId;
	/**
	  * 联系人 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "联系人 ",required = true,notes = "联系人  ")
	private String contact;
	/**
	  * 电话 r
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "电话 r",required = true,notes = "电话 r ")
	private String tel;
	/**
	  * 币种 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "币种 r",required = true,notes = "币种 r ")
	private Integer moneyType;
	/**
	  * 开单日期 r
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "开单日期 r",required = false,notes = "开单日期 r ")
	private Date openDate;
	/**
	  * 交货日期 r
	  * nullable:true,length:10
	  */
	@ApiModelProperty(value = "交货日期 r",required = false,notes = "交货日期 r ")
	private Date issueDate;
	/**
	  * 存货分类 0成品100 200
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "存货分类 0成品100 200",required = true,notes = "存货分类 0成品100 200 ")
	private Integer prdFlg;
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
	private Date createTime;
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
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public String getContact(){
    	return this.contact;
    }
    public void setContact(String contact){
    	this.contact = contact;
    }
    public String getTel(){
    	return this.tel;
    }
    public void setTel(String tel){
    	this.tel = tel;
    }
    public Integer getMoneyType(){
    	return this.moneyType;
    }
    public void setMoneyType(Integer moneyType){
    	this.moneyType = moneyType;
    }
    public Date getOpenDate(){
    	return this.openDate;
    }
    public void setOpenDate(Date openDate){
    	this.openDate = openDate;
    }
    public Date getIssueDate(){
    	return this.issueDate;
    }
    public void setIssueDate(Date issueDate){
    	this.issueDate = issueDate;
    }
    public Integer getPrdFlg(){
    	return this.prdFlg;
    }
    public void setPrdFlg(Integer prdFlg){
    	this.prdFlg = prdFlg;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Date getCreateTime(){
    	return this.createTime;
    }
    public void setCreateTime(Date createTime){
    	this.createTime = createTime;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    // ==== 自定义属性 ====
}