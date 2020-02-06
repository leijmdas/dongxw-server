package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * BomCost BOM成本核算表
 * @author generator
 * @date 2020年02月02日
 */
@Table(BomCost.EntityNode.class)
public class BomCost extends BomCostBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * BOM成本标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "BOM成本标识 ")	
	private Integer id;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品标识 ")	
	@NotNull
	private Integer productId;
	/**
	  * 版本 
	  * nullable:false,length:15
	  */
	@Column(comment = "版本 ")	
	@NotNull
	private String version;
	/**
	  * 材料费用 
	  * nullable:false,length:12
	  */
	@Column(comment = "材料费用 ")	
	@NotNull
	private BigDecimal rmFee;
	/**
	  * 材料损耗 
	  * nullable:false,length:12
	  */
	@Column(comment = "材料损耗 ")	
	@NotNull
	private BigDecimal lossRm;
	/**
	  * 开料 
	  * nullable:false,length:12
	  */
	@Column(comment = "开料 ")	
	@NotNull
	private BigDecimal cutRm;
	/**
	  * 刀模 
	  * nullable:false,length:11
	  */
	@Column(comment = "刀模 ")	
	@NotNull
	private BigDecimal knifeModel;
	/**
	  * 人工费用 
	  * nullable:false,length:12
	  */
	@Column(comment = "人工费用 ")	
	@NotNull
	private BigDecimal workFee;
	/**
	  * 运输费用 
	  * nullable:false,length:10
	  */
	@Column(comment = "运输费用 ")	
	@NotNull
	private BigDecimal shippingFee;
	/**
	  * 总费用 
	  * nullable:false,length:12
	  */
	@Column(comment = "总费用 ")	
	@NotNull
	private BigDecimal totalFee;
	/**
	  * 备注 
	  * nullable:false,length:512
	  */
	@Column(comment = "备注 ")	
	@NotNull
	private String remark;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@Column(comment = "建档时间 ")	
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:true,length:11
	  */
	@Column(comment = "建档人 ")	
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

    public static class EntityNode extends AbstractEntityNode<BomCost> {
        public static final EntityNode INSTANCE = new EntityNode("bc");;
    	/** BOM成本标识  */
        public FieldNode<BomCost, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 产品标识  */
        public FieldNode<BomCost, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 版本  */
        public FieldNode<BomCost, String> version =  createFieldNode("version","version",String.class,JdbcType.VARCHAR);
    	/** 材料费用  */
        public FieldNode<BomCost, BigDecimal> rmFee =  createFieldNode("rmFee","rm_fee",BigDecimal.class,JdbcType.DECIMAL);
    	/** 材料损耗  */
        public FieldNode<BomCost, BigDecimal> lossRm =  createFieldNode("lossRm","loss_rm",BigDecimal.class,JdbcType.DECIMAL);
    	/** 开料  */
        public FieldNode<BomCost, BigDecimal> cutRm =  createFieldNode("cutRm","cut_rm",BigDecimal.class,JdbcType.DECIMAL);
    	/** 刀模  */
        public FieldNode<BomCost, BigDecimal> knifeModel =  createFieldNode("knifeModel","knife_model",BigDecimal.class,JdbcType.DECIMAL);
    	/** 人工费用  */
        public FieldNode<BomCost, BigDecimal> workFee =  createFieldNode("workFee","work_fee",BigDecimal.class,JdbcType.DECIMAL);
    	/** 运输费用  */
        public FieldNode<BomCost, BigDecimal> shippingFee =  createFieldNode("shippingFee","shipping_fee",BigDecimal.class,JdbcType.DECIMAL);
    	/** 总费用  */
        public FieldNode<BomCost, BigDecimal> totalFee =  createFieldNode("totalFee","total_fee",BigDecimal.class,JdbcType.DECIMAL);
    	/** 备注  */
        public FieldNode<BomCost, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 建档时间  */
        public FieldNode<BomCost, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 建档人  */
        public FieldNode<BomCost, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(BomCost.class,"bom_cost",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<BomCost> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<BomCost>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}