package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * OrderLine
 * @author generator
 * @date 2019年12月29日
 */
@ApiModel(value="OrderLineDTO",description="")
public class OrderLineDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * id 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "id ",required = false,notes = "id  [自增]")
	private Integer id;
	/**
	  * A 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "A ",required = true,notes = "A  ")
	private String a;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getA(){
    	return this.a;
    }
    public void setA(String a){
    	this.a = a;
    }
    // ==== 自定义属性 ====
}