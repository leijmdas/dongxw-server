package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.lang.Short;
import java.lang.Byte;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * Bom BOM表
 * @author generator
 * @date 2020年02月02日
 */
@Table(Bom.EntityNode.class)
public class Bom extends BomBase implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * BOM成本标识
	 * nullable:true,length:11
	 */
	@Column(primaryKey = true, autoIncrement = true,comment = "BOM成本标识 ")
	private Integer id;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品标识 ")	
	@NotNull
	private Integer productId;
	/**
	  * 父件标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "父件标识 ")	
	@NotNull
	private Integer parentId;
	/**
	  * 大类 
	  * nullable:true,length:11
	  */
	@Column(comment = "大类 ")	
	private Integer bigType;
	/**
	  * 小类 
	  * nullable:true,length:11
	  */
	@Column(comment = "小类 ")	
	private Integer smallType;
	/**
	  * 子件标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "子件标识 ")	
	@NotNull
	private Integer childId;
	/**
	  * 单位 
	  * nullable:false,length:32
	  */
	@Column(comment = "单位 ")	
	@NotNull
	private String unit;
	/**
	  * 数量 
	  * nullable:false,length:12
	  */
	@Column(comment = "数量 ")	
	@NotNull
	private BigDecimal qty;
	/**
	  * 单价 
	  * nullable:false,length:12
	  */
	@Column(comment = "单价 ")	
	@NotNull
	private BigDecimal price;
	/**
	  * 金额 
	  * nullable:false,length:12
	  */
	@Column(comment = "金额 ")	
	@NotNull
	private BigDecimal money;
	/**
	  * 损耗率(%) 
	  * nullable:false,length:8
	  */
	@Column(comment = "损耗率(%) ")	
	@NotNull
	private Integer lossType;
	/**
	  * 损耗数 
	  * nullable:false,length:6
	  */
	@Column(comment = "损耗数 ")	
	@NotNull
	private Short lossQty;
	/**
	  * 尺寸(长） 
	  * nullable:false,length:12
	  */
	@Column(comment = "尺寸(长） ")	
	@NotNull
	private BigDecimal sizeL;
	/**
	  * 尺寸X 
	  * nullable:false,length:4
	  */
	@Column(comment = "尺寸X ")	
	@NotNull
	private String sizeX;
	/**
	  * 尺寸(宽） 
	  * nullable:false,length:12
	  */
	@Column(comment = "尺寸(宽） ")	
	@NotNull
	private BigDecimal sizeW;
	/**
	  * 长封度 
	  * nullable:false,length:11
	  */
	@Column(comment = "长封度 ")	
	@NotNull
	private Integer length;
	/**
	  * 宽封度 
	  * nullable:false,length:11
	  */
	@Column(comment = "宽封度 ")	
	@NotNull
	private Integer width;
	/**
	  * 刀数 
	  * nullable:false,length:6
	  */
	@Column(comment = "刀数 ")	
	@NotNull
	private Short knifeQty;
	/**
	  * 层次 
	  * nullable:false,length:6
	  */
	@Column(comment = "层次 ")	
	@NotNull
	private Short depth;
	/**
	  * 来源 0--采购1--生产
	  * nullable:false,length:4
	  */
	@Column(comment = "来源 0--采购1--生产")	
	@NotNull
	private Byte source;
	/**
	  * 建档人 
	  * nullable:true,length:11
	  */
	@Column(comment = "建档人 ")	
	private Integer createBy;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@Column(comment = "建档时间 ")	
	private Date createDate;
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
    public Integer getChildId(){
    	return this.childId;
    }
    public void setChildId(Integer childId){
    	this.childId = childId;
    }
    public String getUnit(){
    	return this.unit;
    }
    public void setUnit(String unit){
    	this.unit = unit;
    }
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
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
    public Integer getLossType(){
    	return this.lossType;
    }
    public void setLossType(Integer lossType){
    	this.lossType = lossType;
    }
    public Short getLossQty(){
    	return this.lossQty;
    }
    public void setLossQty(Short lossQty){
    	this.lossQty = lossQty;
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
    public Integer getLength(){
    	return this.length;
    }
    public void setLength(Integer length){
    	this.length = length;
    }
    public Integer getWidth(){
    	return this.width;
    }
    public void setWidth(Integer width){
    	this.width = width;
    }
    public Short getKnifeQty(){
    	return this.knifeQty;
    }
    public void setKnifeQty(Short knifeQty){
    	this.knifeQty = knifeQty;
    }
    public Short getDepth(){
    	return this.depth;
    }
    public void setDepth(Short depth){
    	this.depth = depth;
    }
    public Byte getSource(){
    	return this.source;
    }
    public void setSource(Byte source){
    	this.source = source;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    public Date getCreateDate(){
    	return this.createDate;
    }
    public void setCreateDate(Date createDate){
    	this.createDate = createDate;
    }

    public static class EntityNode extends AbstractEntityNode<Bom> {
        public static final EntityNode INSTANCE = new EntityNode("b");;
    	/** BOM成本标识  */
        public FieldNode<Bom, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 产品标识  */
        public FieldNode<Bom, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 父件标识  */
        public FieldNode<Bom, Integer> parentId =  createFieldNode("parentId","parent_id",Integer.class,JdbcType.INTEGER);
    	/** 大类  */
        public FieldNode<Bom, Integer> bigType =  createFieldNode("bigType","big_type",Integer.class,JdbcType.INTEGER);
    	/** 小类  */
        public FieldNode<Bom, Integer> smallType =  createFieldNode("smallType","small_type",Integer.class,JdbcType.INTEGER);
    	/** 子件标识  */
        public FieldNode<Bom, Integer> childId =  createFieldNode("childId","child_id",Integer.class,JdbcType.INTEGER);
    	/** 单位  */
        public FieldNode<Bom, String> unit =  createFieldNode("unit","unit",String.class,JdbcType.VARCHAR);
    	/** 数量  */
        public FieldNode<Bom, BigDecimal> qty =  createFieldNode("qty","qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 单价  */
        public FieldNode<Bom, BigDecimal> price =  createFieldNode("price","price",BigDecimal.class,JdbcType.DECIMAL);
    	/** 金额  */
        public FieldNode<Bom, BigDecimal> money =  createFieldNode("money","money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 损耗率(%)  */
        public FieldNode<Bom, Integer> lossType =  createFieldNode("lossType","loss_type",Integer.class,JdbcType.INTEGER);
    	/** 损耗数  */
        public FieldNode<Bom, Short> lossQty =  createFieldNode("lossQty","loss_qty",Short.class,JdbcType.SMALLINT);
    	/** 尺寸(长）  */
        public FieldNode<Bom, BigDecimal> sizeL =  createFieldNode("sizeL","size_l",BigDecimal.class,JdbcType.DECIMAL);
    	/** 尺寸X  */
        public FieldNode<Bom, String> sizeX =  createFieldNode("sizeX","size_x",String.class,JdbcType.VARCHAR);
    	/** 尺寸(宽）  */
        public FieldNode<Bom, BigDecimal> sizeW =  createFieldNode("sizeW","size_w",BigDecimal.class,JdbcType.DECIMAL);
    	/** 长封度  */
        public FieldNode<Bom, Integer> length =  createFieldNode("length","length",Integer.class,JdbcType.INTEGER);
    	/** 宽封度  */
        public FieldNode<Bom, Integer> width =  createFieldNode("width","width",Integer.class,JdbcType.INTEGER);
    	/** 刀数  */
        public FieldNode<Bom, Short> knifeQty =  createFieldNode("knifeQty","knife_qty",Short.class,JdbcType.SMALLINT);
    	/** 层次  */
        public FieldNode<Bom, Short> depth =  createFieldNode("depth","depth",Short.class,JdbcType.SMALLINT);
    	/** 来源 0--采购1--生产 */
        public FieldNode<Bom, Byte> source =  createFieldNode("source","source",Byte.class,JdbcType.TINYINT);
    	/** 建档人  */
        public FieldNode<Bom, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 建档时间  */
        public FieldNode<Bom, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Bom.class,"bom",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Bom> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Bom>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}