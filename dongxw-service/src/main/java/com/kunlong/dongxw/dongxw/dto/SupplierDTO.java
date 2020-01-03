package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Supplier
 * @author generator
 * @date 2020年01月03日
 */
@ApiModel(value="SupplierDTO",description="供应商")
public class SupplierDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 供应商主键 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "供应商主键 ",required = false,notes = "供应商主键  [自增]")
	private Integer id;
	/**
	  * 供应商编号 
	  * nullable:false,length:24
	  */
	@ApiModelProperty(value = "供应商编号 ",required = true,notes = "供应商编号  ")
	private String code;
	/**
	  * 供应商名称 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "供应商名称 ",required = true,notes = "供应商名称  ")
	private String name;
	/**
	  * 供应商详细名称 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "供应商详细名称 ",required = true,notes = "供应商详细名称  ")
	private String sname;
	/**
	  * 供应商国家 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "供应商国家 ",required = false,notes = "供应商国家  ")
	private String country;
	/**
	  * 供应商地址 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "供应商地址 ",required = true,notes = "供应商地址  ")
	private String addr;
	/**
	  * 结算币种 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "结算币种 ",required = true,notes = "结算币种  ")
	private Integer moneyType;
	/**
	  * 联系人 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "联系人 ",required = false,notes = "联系人  ")
	private String contact;
	/**
	  * 联系人电话 
	  * nullable:true,length:24
	  */
	@ApiModelProperty(value = "联系人电话 ",required = false,notes = "联系人电话  ")
	private String tel;
	/**
	  * 联系人邮箱 
	  * nullable:true,length:64
	  */
	@ApiModelProperty(value = "联系人邮箱 ",required = false,notes = "联系人邮箱  ")
	private String email;
	/**
	  * 状态 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "状态 ",required = true,notes = "状态  ")
	private Integer status;
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
	/**
	  * 备注 
	  * nullable:false,length:256
	  */
	@ApiModelProperty(value = "备注 ",required = true,notes = "备注  ")
	private String remark;
	/**
	  * 营业执照 
	  * nullable:true,length:256
	  */
	@ApiModelProperty(value = "营业执照 ",required = false,notes = "营业执照  ")
	private String businessLicense;
	/**
	  * 环境 
	  * nullable:true,length:256
	  */
	@ApiModelProperty(value = "环境 ",required = false,notes = "环境  ")
	private String env;
	/**
	  * 资质 
	  * nullable:true,length:4
	  */
	@ApiModelProperty(value = "资质 ",required = false,notes = "资质  ")
	private String intelligence;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String fax;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getSname(){
    	return this.sname;
    }
    public void setSname(String sname){
    	this.sname = sname;
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
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
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
    public String getBusinessLicense(){
    	return this.businessLicense;
    }
    public void setBusinessLicense(String businessLicense){
    	this.businessLicense = businessLicense;
    }
    public String getEnv(){
    	return this.env;
    }
    public void setEnv(String env){
    	this.env = env;
    }
    public String getIntelligence(){
    	return this.intelligence;
    }
    public void setIntelligence(String intelligence){
    	this.intelligence = intelligence;
    }
    public String getFax(){
    	return this.fax;
    }
    public void setFax(String fax){
    	this.fax = fax;
    }
    // ==== 自定义属性 ====
}