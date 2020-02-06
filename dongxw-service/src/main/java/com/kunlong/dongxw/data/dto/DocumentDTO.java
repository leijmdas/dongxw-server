package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.lang.Short;
import java.lang.Byte;
import java.lang.Integer;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Document
 * @author generator
 * @date 2020年01月03日
 */
@ApiModel(value="DocumentDTO",description="模板资源表")
public class DocumentDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 资源标识 
	  * nullable:true,length:20
	  */
	@ApiModelProperty(value = "资源标识 ",required = false,notes = "资源标识  [自增]")
	private Long id;
	/**
	  * 源文件名称 
	  * nullable:false,length:255
	  */
	@ApiModelProperty(value = "源文件名称 ",required = true,notes = "源文件名称  ")
	private String name;
	/**
	  * 文件类型 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "文件类型 ",required = true,notes = "文件类型  ")
	private Short type;
	/**
	  * 保存方式 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "保存方式 ",required = true,notes = "保存方式  ")
	private Byte saveMode;
	/**
	  * 图片类型 
	  * nullable:false,length:20
	  */
	@ApiModelProperty(value = "图片类型 ",required = true,notes = "图片类型  ")
	private String picType;
	/**
	  * 路径 
	  * nullable:false,length:255
	  */
	@ApiModelProperty(value = "路径 ",required = true,notes = "路径  ")
	private String url;
	/**
	  * 二维码路径 
	  * nullable:false,length:256
	  */
	@ApiModelProperty(value = "二维码路径 ",required = true,notes = "二维码路径  ")
	private String qrcode;
	/**
	  * 大小 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "大小 ",required = true,notes = "大小  ")
	private Integer size;
	/**
	  * 文档内容 
	  * nullable:false,length:65,535
	  */
	@ApiModelProperty(value = "文档内容 ",required = true,notes = "文档内容  ")
	private Byte[] document;
	/**
	  * 保存时间 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "保存时间 ",required = false,notes = "保存时间  ")
	private Date saveTime;
	/**
	  * 压缩标识 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "压缩标识 ",required = true,notes = "压缩标识  ")
	private Byte compressFlag;
    public Long getId(){
    	return this.id;
    }
    public void setId(Long id){
    	this.id = id;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public Short getType(){
    	return this.type;
    }
    public void setType(Short type){
    	this.type = type;
    }
    public Byte getSaveMode(){
    	return this.saveMode;
    }
    public void setSaveMode(Byte saveMode){
    	this.saveMode = saveMode;
    }
    public String getPicType(){
    	return this.picType;
    }
    public void setPicType(String picType){
    	this.picType = picType;
    }
    public String getUrl(){
    	return this.url;
    }
    public void setUrl(String url){
    	this.url = url;
    }
    public String getQrcode(){
    	return this.qrcode;
    }
    public void setQrcode(String qrcode){
    	this.qrcode = qrcode;
    }
    public Integer getSize(){
    	return this.size;
    }
    public void setSize(Integer size){
    	this.size = size;
    }
    public Byte[] getDocument(){
    	return this.document;
    }
    public void setDocument(Byte[] document){
    	this.document = document;
    }
    public Date getSaveTime(){
    	return this.saveTime;
    }
    public void setSaveTime(Date saveTime){
    	this.saveTime = saveTime;
    }
    public Byte getCompressFlag(){
    	return this.compressFlag;
    }
    public void setCompressFlag(Byte compressFlag){
    	this.compressFlag = compressFlag;
    }
    // ==== 自定义属性 ====
}