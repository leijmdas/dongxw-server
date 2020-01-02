package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Byte;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * ProductType
 * @author generator
 * @date 2020年01月02日
 */
@ApiModel(value="ProductTypeDTO",description="")
public class ProductTypeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "主键",required = false,notes = "主键 [自增]")
	private Integer id;
	/**
	  * 有效标识
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "有效标识",required = true,notes = "有效标识 ")
	private Byte active;
	/**
	  * 编码
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "编码",required = false,notes = "编码 ")
	private String code;
	/**
	  * 产品类型名称
	  * nullable:true,length:128
	  */
	@ApiModelProperty(value = "产品类型名称",required = false,notes = "产品类型名称 ")
	private String name;
	/**
	  * 父类
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "父类",required = true,notes = "父类 ")
	private Integer parentId;
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
    // ==== 自定义属性 ====
}