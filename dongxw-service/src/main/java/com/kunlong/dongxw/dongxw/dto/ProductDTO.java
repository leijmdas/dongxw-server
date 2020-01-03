package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Product
 * @author generator
 * @date 2020年01月03日
 */
@ApiModel(value="ProductDTO",description="产品")
public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * EP款号 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "EP款号 ",required = true,notes = "EP款号  ")
	private String epCode;
	/**
	  * 编码
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "编码",required = true,notes = "编码 ")
	private String code;
	/**
	  * 描述 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "描述 ",required = true,notes = "描述  ")
	private String remark;
	/**
	  * 父类
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "父类",required = true,notes = "父类 ")
	private Integer parentId;
	/**
	  * 产品小类 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品小类 ",required = true,notes = "产品小类  ")
	private Integer productTypeId;
	/**
	  * 图片 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "图片 ",required = false,notes = "图片  ")
	private String picUrl;
	/**
	  * 条码 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "条码 ",required = true,notes = "条码  ")
	private String barCode;
	/**
	  * 配色 
	  * nullable:false,length:16
	  */
	@ApiModelProperty(value = "配色 ",required = true,notes = "配色  ")
	private String color;
	/**
	  * 单位 
	  * nullable:false,length:16
	  */
	@ApiModelProperty(value = "单位 ",required = true,notes = "单位  ")
	private String unit;
	/**
	  * 尺寸 
	  * nullable:false,length:24
	  */
	@ApiModelProperty(value = "尺寸 ",required = true,notes = "尺寸  ")
	private String size;
	/**
	  * UPC-A 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "UPC-A ",required = true,notes = "UPC-A  ")
	private String upcA;
	/**
	  * 状态 1-使用 0-停用
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "状态 1-使用 0-停用",required = true,notes = "状态 1-使用 0-停用 ")
	private Integer status;
	/**
	  * 备注 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "备注 ",required = true,notes = "备注  ")
	private String memo;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getEpCode(){
    	return this.epCode;
    }
    public void setEpCode(String epCode){
    	this.epCode = epCode;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
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
    public String getPicUrl(){
    	return this.picUrl;
    }
    public void setPicUrl(String picUrl){
    	this.picUrl = picUrl;
    }
    public String getBarCode(){
    	return this.barCode;
    }
    public void setBarCode(String barCode){
    	this.barCode = barCode;
    }
    public String getColor(){
    	return this.color;
    }
    public void setColor(String color){
    	this.color = color;
    }
    public String getUnit(){
    	return this.unit;
    }
    public void setUnit(String unit){
    	this.unit = unit;
    }
    public String getSize(){
    	return this.size;
    }
    public void setSize(String size){
    	this.size = size;
    }
    public String getUpcA(){
    	return this.upcA;
    }
    public void setUpcA(String upcA){
    	this.upcA = upcA;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public String getMemo(){
    	return this.memo;
    }
    public void setMemo(String memo){
    	this.memo = memo;
    }
    // ==== 自定义属性 ====
}