package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * PoDaySeq
 * @author generator
 * @date 2020年04月05日
 */
@ApiModel(value="PoDaySeqDTO",description="采购单序号表")
public class PoDaySeqDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 序号标识 int(11)
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "序号标识 int(11)",required = false,notes = "序号标识 int(11) [自增]")
	private Integer id;
	/**
	  * 年月日 varchar(32)
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "年月日 varchar(32)",required = true,notes = "年月日 varchar(32) ")
	private Integer ymd;
	/**
	  * 采购单序号 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "采购单序号 r",required = true,notes = "采购单序号 r ")
	private Integer poSeq;
	/**
	  * 外发单序号 r
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "外发单序号 r",required = true,notes = "外发单序号 r ")
	private Integer outSeq;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getYmd(){
    	return this.ymd;
    }
    public void setYmd(Integer ymd){
    	this.ymd = ymd;
    }
    public Integer getPoSeq(){
    	return this.poSeq;
    }
    public void setPoSeq(Integer poSeq){
    	this.poSeq = poSeq;
    }
    public Integer getOutSeq(){
    	return this.outSeq;
    }
    public void setOutSeq(Integer outSeq){
    	this.outSeq = outSeq;
    }
    // ==== 自定义属性 ====
}