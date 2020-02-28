package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.lang.Short;
import java.lang.Boolean;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * MakeSheet
 * @author generator
 * @date 2020年02月28日
 */
@ApiModel(value="MakeSheetDTO",description="生产制造单")
public class MakeSheetDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 生产制造单标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "生产制造单标识 ",required = false,notes = "生产制造单标识  [自增]")
	private Integer id;
	/**
	  * 计划标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "计划标识 ",required = true,notes = "计划标识  ")
	private Integer planId;
	/**
	  * 订单标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "订单标识 ",required = true,notes = "订单标识  ")
	private Integer orderId;
	/**
	  * 订单产品标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "订单产品标识 ",required = true,notes = "订单产品标识  ")
	private Integer orderLineId;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品标识 ",required = true,notes = "产品标识  ")
	private Integer productId;
	/**
	  * BOM标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "BOM标识 ",required = true,notes = "BOM标识  ")
	private Integer bomId;
	/**
	  * BOM父件标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "BOM父件标识 ",required = true,notes = "BOM父件标识  ")
	private Integer parentId;
	/**
	  * 大类 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "大类 ",required = false,notes = "大类  ")
	private Integer bigType;
	/**
	  * 小类 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "小类 ",required = false,notes = "小类  ")
	private Integer smallType;
	/**
	  * 审核状态 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "审核状态 ",required = true,notes = "审核状态  ")
	private Integer status;
	/**
	  * 物料标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "物料标识 ",required = true,notes = "物料标识  ")
	private Integer childId;
	/**
	  * 宽封度 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "宽封度 ",required = true,notes = "宽封度  ")
	private Integer width;
	/**
	  * 裁片名称 
	  * nullable:true,length:32
	  */
	@ApiModelProperty(value = "裁片名称 ",required = false,notes = "裁片名称  ")
	private String cutPartName;
	/**
	  * 尺寸(长） 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "尺寸(长） ",required = true,notes = "尺寸(长）  ")
	private BigDecimal sizeL;
	/**
	  * 尺寸X 
	  * nullable:false,length:4
	  */
	@ApiModelProperty(value = "尺寸X ",required = true,notes = "尺寸X  ")
	private String sizeX;
	/**
	  * 尺寸(宽） 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "尺寸(宽） ",required = true,notes = "尺寸(宽）  ")
	private BigDecimal sizeW;
	/**
	  * 件数 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "件数 ",required = true,notes = "件数  ")
	private Short pieces;
	/**
	  * 刀数 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "刀数 ",required = true,notes = "刀数  ")
	private Short knifeQty;
	/**
	  * 长封度 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "长封度 ",required = true,notes = "长封度  ")
	private Integer length;
	/**
	  * 损耗类型   1 损耗率(%) 0 损耗数 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "损耗类型   1 损耗率(%) 0 损耗数 ",required = true,notes = "损耗类型   1 损耗率(%) 0 损耗数  ")
	private Integer lossType;
	/**
	  * 损耗率 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "损耗率 ",required = true,notes = "损耗率  ")
	private Short lossRate;
	/**
	  * 每个用量 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "每个用量 ",required = true,notes = "每个用量  ")
	private BigDecimal eachQty;
	/**
	  * 损耗量 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "损耗量 ",required = true,notes = "损耗量  ")
	private BigDecimal lossQty;
	/**
	  * 用量 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "用量 ",required = true,notes = "用量  ")
	private BigDecimal qty;
	/**
	  * 总用量 
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "总用量 ",required = true,notes = "总用量  ")
	private BigDecimal totalQty;
	/**
	  * 单位 
	  * nullable:false,length:32
	  */
	@ApiModelProperty(value = "单位 ",required = true,notes = "单位  ")
	private String unit;
	/**
	  * 单价 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "单价 ",required = true,notes = "单价  ")
	private BigDecimal price;
	/**
	  * 金额 
	  * nullable:false,length:14
	  */
	@ApiModelProperty(value = "金额 ",required = true,notes = "金额  ")
	private BigDecimal money;
	/**
	  * 层次 
	  * nullable:false,length:6
	  */
	@ApiModelProperty(value = "层次 ",required = true,notes = "层次  ")
	private Short depth;
	/**
	  * 有组件 1-组件0-物料
	  * nullable:false,length:1
	  */
	@ApiModelProperty(value = "有组件 1-组件0-物料",required = true,notes = "有组件 1-组件0-物料 ")
	private Boolean source;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@ApiModelProperty(value = "建档时间 ",required = false,notes = "建档时间  ")
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "建档人 ",required = false,notes = "建档人  ")
	private Integer createBy;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getPlanId(){
    	return this.planId;
    }
    public void setPlanId(Integer planId){
    	this.planId = planId;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public Integer getOrderLineId(){
    	return this.orderLineId;
    }
    public void setOrderLineId(Integer orderLineId){
    	this.orderLineId = orderLineId;
    }
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
    }
    public Integer getBomId(){
    	return this.bomId;
    }
    public void setBomId(Integer bomId){
    	this.bomId = bomId;
    }
    public Integer getParentId(){
    	return this.parentId;
    }
    public void setParentId(Integer parentId){
    	this.parentId = parentId;
    }
    public Integer getBigType(){
    	return this.bigType;
    }
    public void setBigType(Integer bigType){
    	this.bigType = bigType;
    }
    public Integer getSmallType(){
    	return this.smallType;
    }
    public void setSmallType(Integer smallType){
    	this.smallType = smallType;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public Integer getChildId(){
    	return this.childId;
    }
    public void setChildId(Integer childId){
    	this.childId = childId;
    }
    public Integer getWidth(){
    	return this.width;
    }
    public void setWidth(Integer width){
    	this.width = width;
    }
    public String getCutPartName(){
    	return this.cutPartName;
    }
    public void setCutPartName(String cutPartName){
    	this.cutPartName = cutPartName;
    }
    public BigDecimal getSizeL(){
    	return this.sizeL;
    }
    public void setSizeL(BigDecimal sizeL){
    	this.sizeL = sizeL;
    }
    public String getSizeX(){
    	return this.sizeX;
    }
    public void setSizeX(String sizeX){
    	this.sizeX = sizeX;
    }
    public BigDecimal getSizeW(){
    	return this.sizeW;
    }
    public void setSizeW(BigDecimal sizeW){
    	this.sizeW = sizeW;
    }
    public Short getPieces(){
    	return this.pieces;
    }
    public void setPieces(Short pieces){
    	this.pieces = pieces;
    }
    public Short getKnifeQty(){
    	return this.knifeQty;
    }
    public void setKnifeQty(Short knifeQty){
    	this.knifeQty = knifeQty;
    }
    public Integer getLength(){
    	return this.length;
    }
    public void setLength(Integer length){
    	this.length = length;
    }
    public Integer getLossType(){
    	return this.lossType;
    }
    public void setLossType(Integer lossType){
    	this.lossType = lossType;
    }
    public Short getLossRate(){
    	return this.lossRate;
    }
    public void setLossRate(Short lossRate){
    	this.lossRate = lossRate;
    }
    public BigDecimal getEachQty(){
    	return this.eachQty;
    }
    public void setEachQty(BigDecimal eachQty){
    	this.eachQty = eachQty;
    }
    public BigDecimal getLossQty(){
    	return this.lossQty;
    }
    public void setLossQty(BigDecimal lossQty){
    	this.lossQty = lossQty;
    }
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
    }
    public BigDecimal getTotalQty(){
    	return this.totalQty;
    }
    public void setTotalQty(BigDecimal totalQty){
    	this.totalQty = totalQty;
    }
    public String getUnit(){
    	return this.unit;
    }
    public void setUnit(String unit){
    	this.unit = unit;
    }
    public BigDecimal getPrice(){
    	return this.price;
    }
    public void setPrice(BigDecimal price){
    	this.price = price;
    }
    public BigDecimal getMoney(){
    	return this.money;
    }
    public void setMoney(BigDecimal money){
    	this.money = money;
    }
    public Short getDepth(){
    	return this.depth;
    }
    public void setDepth(Short depth){
    	this.depth = depth;
    }
    public Boolean getSource(){
    	return this.source;
    }
    public void setSource(Boolean source){
    	this.source = source;
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
    // ==== 自定义属性 ====
}