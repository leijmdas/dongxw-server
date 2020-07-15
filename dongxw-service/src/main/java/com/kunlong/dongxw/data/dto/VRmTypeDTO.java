package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Byte;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * VRmType
 * @author generator
 * @date 2020年05月31日
 */
@ApiModel(value="VRmTypeDTO",description="VIEW")
public class VRmTypeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "",required = false,notes = " [自增]")
	private Integer id;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Byte active;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String code;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String name;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer parentId;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer prdFlag;
	/**
	  * 
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String remark;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Byte getActive(){
    	return this.active;
    }
    public void setActive(Byte active){
    	this.active = active;
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
    public Integer getParentId(){
    	return this.parentId;
    }
    public void setParentId(Integer parentId){
    	this.parentId = parentId;
    }
    public Integer getPrdFlag(){
    	return this.prdFlag;
    }
    public void setPrdFlag(Integer prdFlag){
    	this.prdFlag = prdFlag;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    // ==== 自定义属性 ====
}