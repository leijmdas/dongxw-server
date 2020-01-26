package com.kunlong.dongxw.dongxw.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.math.BigDecimal;
import java.lang.Short;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Product
 * @author generator
 * @date 2020年01月24日
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
	  * nullable:false,length:512
	  */
	@ApiModelProperty(value = "描述",required = true,notes = "描述 ")
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
	  * nullable:true,length:256
	  */
	@ApiModelProperty(value = "图片 ",required = false,notes = "图片  ")
	private String picUrl;
	/**
	  * 条码 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "条码 ",required = true,notes = "条码  ")
	private String barCode;
	/**
	  * 配色 
	  * nullable:false,length:64
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
	  * nullable:false,length:32
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
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "状态 1-使用 0-停用",required = true,notes = "状态 1-使用 0-停用 ")
	private Integer status;
	/**
	  * 备注 
	  * nullable:false,length:128
	  */
	@ApiModelProperty(value = "备注 ",required = true,notes = "备注  ")
	private String memo;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "建档时间 ",required = false,notes = "建档时间  ")
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "建档人 ",required = true,notes = "建档人  ")
	private Integer createBy;
	/**
	  * 
	  * nullable:true,length:4
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private Integer customerId;
	/**
	  * 图片集
	  * nullable:true,length:1,024
	  */
	@ApiModelProperty(value = "图片集",required = false,notes = "图片集 ")
	private String imgUrls;
	/**
	  * 内盒数量 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "内盒数量 ",required = true,notes = "内盒数量  ")
	private Integer ibQty;
	/**
	  * 毛重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "毛重 ",required = true,notes = "毛重  ")
	private BigDecimal ibGw;
	/**
	  * 净重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "净重 ",required = true,notes = "净重  ")
	private BigDecimal ibNw;
	/**
	  * 内盒尺寸 
	  * nullable:false,length:64
	  */
	@ApiModelProperty(value = "内盒尺寸 ",required = true,notes = "内盒尺寸  ")
	private String ibSize;
	/**
	  * 外箱数量 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "外箱数量 ",required = true,notes = "外箱数量  ")
	private Integer obQty;
	/**
	  * 毛重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "毛重 ",required = true,notes = "毛重  ")
	private BigDecimal obGw;
	/**
	  * 净重 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "净重 ",required = true,notes = "净重  ")
	private BigDecimal obNw;
	/**
	  * 
	  * nullable:false,length:255
	  */
	@ApiModelProperty(value = "",required = true,notes = " ")
	private String obSize;
	/**
	  * 
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgFront;
	/**
	  * 
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgSide;
	/**
	  * 
	  * nullable:true,length:512
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgRemark;
	/**
	  * 
	  * nullable:true,length:512
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String imgRemark;
	/**
	  * 产品类型名称
	  * nullable:true,length:255
	  */
	@ApiModelProperty(value = "产品类型名称",required = false,notes = "产品类型名称 ")
	private String name;
	/**
	  * 
	  * nullable:true,length:512
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgSideImgRemark;
	/**
	  * 
	  * nullable:true,length:1,024
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgFrontImgUrls;
	/**
	  * 
	  * nullable:true,length:1,024
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgSideImgUrls;
	/**
	  * 
	  * nullable:true,length:512
	  */
	@ApiModelProperty(value = "",required = false,notes = " ")
	private String pkgFrontImgRemark;
	/**
	  * 0-成品100-半成品-200-原料
	  * nullable:false,length:255
	  */
	@ApiModelProperty(value = "0-成品100-半成品-200-原料",required = true,notes = "0-成品100-半成品-200-原料 ")
	private Short prdFlag;
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
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public String getImgUrls(){
    	return this.imgUrls;
    }
    public void setImgUrls(String imgUrls){
    	this.imgUrls = imgUrls;
    }
    public Integer getIbQty(){
    	return this.ibQty;
    }
    public void setIbQty(Integer ibQty){
    	this.ibQty = ibQty;
    }
    public BigDecimal getIbGw(){
    	return this.ibGw;
    }
    public void setIbGw(BigDecimal ibGw){
    	this.ibGw = ibGw;
    }
    public BigDecimal getIbNw(){
    	return this.ibNw;
    }
    public void setIbNw(BigDecimal ibNw){
    	this.ibNw = ibNw;
    }
    public String getIbSize(){
    	return this.ibSize;
    }
    public void setIbSize(String ibSize){
    	this.ibSize = ibSize;
    }
    public Integer getObQty(){
    	return this.obQty;
    }
    public void setObQty(Integer obQty){
    	this.obQty = obQty;
    }
    public BigDecimal getObGw(){
    	return this.obGw;
    }
    public void setObGw(BigDecimal obGw){
    	this.obGw = obGw;
    }
    public BigDecimal getObNw(){
    	return this.obNw;
    }
    public void setObNw(BigDecimal obNw){
    	this.obNw = obNw;
    }
    public String getObSize(){
    	return this.obSize;
    }
    public void setObSize(String obSize){
    	this.obSize = obSize;
    }
    public String getPkgFront(){
    	return this.pkgFront;
    }
    public void setPkgFront(String pkgFront){
    	this.pkgFront = pkgFront;
    }
    public String getPkgSide(){
    	return this.pkgSide;
    }
    public void setPkgSide(String pkgSide){
    	this.pkgSide = pkgSide;
    }
    public String getPkgRemark(){
    	return this.pkgRemark;
    }
    public void setPkgRemark(String pkgRemark){
    	this.pkgRemark = pkgRemark;
    }
    public String getImgRemark(){
    	return this.imgRemark;
    }
    public void setImgRemark(String imgRemark){
    	this.imgRemark = imgRemark;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getPkgSideImgRemark(){
    	return this.pkgSideImgRemark;
    }
    public void setPkgSideImgRemark(String pkgSideImgRemark){
    	this.pkgSideImgRemark = pkgSideImgRemark;
    }
    public String getPkgFrontImgUrls(){
    	return this.pkgFrontImgUrls;
    }
    public void setPkgFrontImgUrls(String pkgFrontImgUrls){
    	this.pkgFrontImgUrls = pkgFrontImgUrls;
    }
    public String getPkgSideImgUrls(){
    	return this.pkgSideImgUrls;
    }
    public void setPkgSideImgUrls(String pkgSideImgUrls){
    	this.pkgSideImgUrls = pkgSideImgUrls;
    }
    public String getPkgFrontImgRemark(){
    	return this.pkgFrontImgRemark;
    }
    public void setPkgFrontImgRemark(String pkgFrontImgRemark){
    	this.pkgFrontImgRemark = pkgFrontImgRemark;
    }
    public Short getPrdFlag(){
    	return this.prdFlag;
    }
    public void setPrdFlag(Short prdFlag){
    	this.prdFlag = prdFlag;
    }
    // ==== 自定义属性 ====
}