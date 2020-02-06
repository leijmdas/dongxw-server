package com.kunlong.dongxw.data.dto;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

import com.kunlong.platform.model.KunlongModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * BomCost
 * @author generator
 * @date 2020年02月02日
 */
@ApiModel(value="BomCostDTO",description="BOM成本核算表")
public class BomCostDTO extends KunlongModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * BOM成本标识 
	  * nullable:true,length:11
	  */
	@ApiModelProperty(value = "BOM成本标识 ",required = false,notes = "BOM成本标识  [自增]")
	private Integer id;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "产品标识 ",required = true,notes = "产品标识  ")
	private Integer productId;
	/**
	  * 版本 
	  * nullable:false,length:15
	  */
	@ApiModelProperty(value = "版本 ",required = true,notes = "版本  ")
	private String version;
	/**
	  * 材料费用 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "材料费用 ",required = true,notes = "材料费用  ")
	private BigDecimal rmFee;
	/**
	  * 材料损耗 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "材料损耗 ",required = true,notes = "材料损耗  ")
	private BigDecimal lossRm;
	/**
	  * 开料 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "开料 ",required = true,notes = "开料  ")
	private BigDecimal cutRm;
	/**
	  * 刀模 
	  * nullable:false,length:11
	  */
	@ApiModelProperty(value = "刀模 ",required = true,notes = "刀模  ")
	private BigDecimal knifeModel;
	/**
	  * 人工费用 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "人工费用 ",required = true,notes = "人工费用  ")
	private BigDecimal workFee;
	/**
	  * 运输费用 
	  * nullable:false,length:10
	  */
	@ApiModelProperty(value = "运输费用 ",required = true,notes = "运输费用  ")
	private BigDecimal shippingFee;
	/**
	  * 总费用 
	  * nullable:false,length:12
	  */
	@ApiModelProperty(value = "总费用 ",required = true,notes = "总费用  ")
	private BigDecimal totalFee;
	/**
	  * 备注 
	  * nullable:false,length:512
	  */
	@ApiModelProperty(value = "备注 ",required = true,notes = "备注  ")
	private String remark;
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
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
    }
    public String getVersion(){
    	return this.version;
    }
    public void setVersion(String version){
    	this.version = version;
    }
    public BigDecimal getRmFee(){
    	return this.rmFee;
    }
    public void setRmFee(BigDecimal rmFee){
    	this.rmFee = rmFee;
    }
    public BigDecimal getLossRm(){
    	return this.lossRm;
    }
    public void setLossRm(BigDecimal lossRm){
    	this.lossRm = lossRm;
    }
    public BigDecimal getCutRm(){
    	return this.cutRm;
    }
    public void setCutRm(BigDecimal cutRm){
    	this.cutRm = cutRm;
    }
    public BigDecimal getKnifeModel(){
    	return this.knifeModel;
    }
    public void setKnifeModel(BigDecimal knifeModel){
    	this.knifeModel = knifeModel;
    }
    public BigDecimal getWorkFee(){
    	return this.workFee;
    }
    public void setWorkFee(BigDecimal workFee){
    	this.workFee = workFee;
    }
    public BigDecimal getShippingFee(){
    	return this.shippingFee;
    }
    public void setShippingFee(BigDecimal shippingFee){
    	this.shippingFee = shippingFee;
    }
    public BigDecimal getTotalFee(){
    	return this.totalFee;
    }
    public void setTotalFee(BigDecimal totalFee){
    	this.totalFee = totalFee;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
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