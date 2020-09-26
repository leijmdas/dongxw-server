package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Wharehouse
 * @author generator
 * @date 2020年09月22日
 */
@ApiModel(value="WharehouseDTO",description="仓库")
public class WharehouseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 序号标识 int(11)
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "序号标识 int(11)",required = false,notes = "序号标识 int(11) [自增]")
	private Integer id;
	/**
	  * 编号 varchar(32)
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "编号 varchar(32)",required = true,notes = "编号 varchar(32) ")
	private String code;
	/**
	  * 仓库名称 r
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "仓库名称 r",required = true,notes = "仓库名称 r ")
	private String name;
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
    // ==== 自定义属性 ====
}