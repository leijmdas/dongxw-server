package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Customer
 * @author generator
 * @date 2020年01月18日
 */
@ApiModel(value="CustomerDTO",description="")
public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 客户主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "客户主键",required = false,notes = "客户主键 [自增]")
	private Integer id;
	/**
	  * 客户编号
	  * nullable:false,length:24
	  */
	@ApiModelProperty(value = "客户编号",required = true,notes = "客户编号 ")
	private String custNo;
	/**
	  * 客户名称
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "客户名称",required = true,notes = "客户名称 ")
	private String custName;
	/**
	  * 客户详细名称
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "客户详细名称",required = true,notes = "客户详细名称 ")
	private String custSname;
	/**
	  * 客户国家
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "客户国家",required = false,notes = "客户国家 ")
	private String country;
	/**
	  * 客户地址
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "客户地址",required = true,notes = "客户地址 ")
	private String addr;
	/**
	  * 结算币种
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "结算币种",required = true,notes = "结算币种 ")
	private Integer moneyType;
	/**
	  * 联系人
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "联系人",required = false,notes = "联系人 ")
	private String contact;
	/**
	  * 联系人电话
	  * nullable:true,length:24
	  */
	@ApiModelProperty(value = "联系人电话",required = false,notes = "联系人电话 ")
	private String tel;
	/**
	  * 联系人邮箱
	  * nullable:true,length:64
	  */
	@ApiModelProperty(value = "联系人邮箱",required = false,notes = "联系人邮箱 ")
	private String email;
	/**
	  * 建档时间
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "建档时间",required = true,notes = "建档时间 ")
	private Date createDate;
	/**
	  * 建档人
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "建档人",required = true,notes = "建档人 ")
	private Integer createBy;
	/**
	  * 
	  * nullable:true,length:4
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Integer status;
	/**
	  * 
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String remark;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String fax;
	/**
	  * 客户登录开关
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "客户登录开关",required = true,notes = "客户登录开关 ")
	private Integer loginSwitch;
	/**
	  * 
	  * nullable:true,length:64
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String loginName;
	/**
	  * 语言类型
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "语言类型",required = true,notes = "语言类型 ")
	private Integer language;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String loginPassword;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getCustNo(){
    	return this.custNo;
    }
    public void setCustNo(String custNo){
    	this.custNo = custNo;
    }
    public String getCustName(){
    	return this.custName;
    }
    public void setCustName(String custName){
    	this.custName = custName;
    }
    public String getCustSname(){
    	return this.custSname;
    }
    public void setCustSname(String custSname){
    	this.custSname = custSname;
    }
    public String getCountry(){
    	return this.country;
    }
    public void setCountry(String country){
    	this.country = country;
    }
    public String getAddr(){
    	return this.addr;
    }
    public void setAddr(String addr){
    	this.addr = addr;
    }
    public Integer getMoneyType(){
    	return this.moneyType;
    }
    public void setMoneyType(Integer moneyType){
    	this.moneyType = moneyType;
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
    public String getEmail(){
    	return this.email;
    }
    public void setEmail(String email){
    	this.email = email;
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
    public String getFax(){
    	return this.fax;
    }
    public void setFax(String fax){
    	this.fax = fax;
    }
    public Integer getLoginSwitch(){
    	return this.loginSwitch;
    }
    public void setLoginSwitch(Integer loginSwitch){
    	this.loginSwitch = loginSwitch;
    }
    public String getLoginName(){
    	return this.loginName;
    }
    public void setLoginName(String loginName){
    	this.loginName = loginName;
    }
    public Integer getLanguage(){
    	return this.language;
    }
    public void setLanguage(Integer language){
    	this.language = language;
    }
    public String getLoginPassword(){
    	return this.loginPassword;
    }
    public void setLoginPassword(String loginPassword){
    	this.loginPassword = loginPassword;
    }
    // ==== 自定义属性 ====
}