package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Boolean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * MonthClose
 * @author generator
 * @date 2020年08月09日
 */
@ApiModel(value="MonthCloseDTO",description="月结周期表")
public class MonthCloseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 序号标识 int(11)
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "序号标识 int(11)",required = false,notes = "序号标识 int(11) [自增]")
	private Integer id;
	/**
	  * 年月 varchar(32)
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "年月 varchar(32)",required = true,notes = "年月 varchar(32) ")
	private Integer ym;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private Integer wh;
	/**
	  * 月结标志 r
	  * nullable:false,length:1
	  */
	@ApiModelProperty(value = "月结标志 r",required = true,notes = "月结标志 r ")
	private Boolean closeFlag;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getYm(){
    	return this.ym;
    }
    public void setYm(Integer ym){
    	this.ym = ym;
    }
    public Integer getWh(){
    	return this.wh;
    }
    public void setWh(Integer wh){
    	this.wh = wh;
    }
    public Boolean getCloseFlag(){
    	return this.closeFlag;
    }
    public void setCloseFlag(Boolean closeFlag){
    	this.closeFlag = closeFlag;
    }
    // ==== 自定义属性 ====
}