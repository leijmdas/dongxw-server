package com.kunlong.dongxw.data.domain;

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
 * PurchasePlan 采购计划单
 * @author generator
 * @date 2020年02月05日
 */
@Table(PurchasePlan.EntityNode.class)
public class PurchasePlan extends PurchasePlanBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 采购计划标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "采购计划标识 ")	
	private Integer id;
	/**
	  * 订单标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "订单标识 ")	
	@NotNull
	private Integer orderId;
	/**
	  * 订单产品标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "订单产品标识 ")	
	@NotNull
	private Integer orderLineId;
	/**
	  * 生产计划标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "生产计划标识 ")	
	@NotNull
	private Integer planId;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品标识 ")	
	@NotNull
	private Integer productId;
	/**
	  * 物料标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "物料标识 ")	
	@NotNull
	private Integer rmId;
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
	  * 每个用量 
	  * nullable:false,length:12
	  */
	@Column(comment = "每个用量 ")	
	@NotNull
	private BigDecimal pQty;
	/**
	  * 用量 
	  * nullable:false,length:12
	  */
	@Column(comment = "用量 ")	
	@NotNull
	private BigDecimal qty;
	/**
	  * 总用量 
	  * nullable:false,length:12
	  */
	@Column(comment = "总用量 ")	
	@NotNull
	private BigDecimal totalQty;
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
	  * 损耗类型   1 损耗率(%) 0 损耗数 
	  * nullable:false,length:11
	  */
	@Column(comment = "损耗类型   1 损耗率(%) 0 损耗数 ")	
	@NotNull
	private Integer lossType;
	/**
	  * 损耗值 
	  * nullable:false,length:10
	  */
	@Column(comment = "损耗值 ")	
	@NotNull
	private BigDecimal lossQty;
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
	  * 物料到位日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "物料到位日期 ")	
	private Date rmDate;
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
    public Integer getPlanId(){
    	return this.planId;
    }
    public void setPlanId(Integer planId){
    	this.planId = planId;
    }
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
    }
    public Integer getRmId(){
    	return this.rmId;
    }
    public void setRmId(Integer rmId){
    	this.rmId = rmId;
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
    public BigDecimal getpQty(){
    	return this.pQty;
    }
    public void setpQty(BigDecimal pQty){
    	this.pQty = pQty;
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
    public BigDecimal getLossQty(){
    	return this.lossQty;
    }
    public void setLossQty(BigDecimal lossQty){
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
    public Date getRmDate(){
    	return this.rmDate;
    }
    public void setRmDate(Date rmDate){
    	this.rmDate = rmDate;
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

    public static class EntityNode extends AbstractEntityNode<PurchasePlan> {
        public static final EntityNode INSTANCE = new EntityNode("pp");;
    	/** 采购计划标识  */
        public FieldNode<PurchasePlan, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 订单标识  */
        public FieldNode<PurchasePlan, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 订单产品标识  */
        public FieldNode<PurchasePlan, Integer> orderLineId =  createFieldNode("orderLineId","order_line_id",Integer.class,JdbcType.INTEGER);
    	/** 生产计划标识  */
        public FieldNode<PurchasePlan, Integer> planId =  createFieldNode("planId","plan_id",Integer.class,JdbcType.INTEGER);
    	/** 产品标识  */
        public FieldNode<PurchasePlan, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 物料标识  */
        public FieldNode<PurchasePlan, Integer> rmId =  createFieldNode("rmId","rm_id",Integer.class,JdbcType.INTEGER);
    	/** 父件标识  */
        public FieldNode<PurchasePlan, Integer> parentId =  createFieldNode("parentId","parent_id",Integer.class,JdbcType.INTEGER);
    	/** 大类  */
        public FieldNode<PurchasePlan, Integer> bigType =  createFieldNode("bigType","big_type",Integer.class,JdbcType.INTEGER);
    	/** 小类  */
        public FieldNode<PurchasePlan, Integer> smallType =  createFieldNode("smallType","small_type",Integer.class,JdbcType.INTEGER);
    	/** 子件标识  */
        public FieldNode<PurchasePlan, Integer> childId =  createFieldNode("childId","child_id",Integer.class,JdbcType.INTEGER);
    	/** 单位  */
        public FieldNode<PurchasePlan, String> unit =  createFieldNode("unit","unit",String.class,JdbcType.VARCHAR);
    	/** 每个用量  */
        public FieldNode<PurchasePlan, BigDecimal> pQty =  createFieldNode("pQty","p_qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 用量  */
        public FieldNode<PurchasePlan, BigDecimal> qty =  createFieldNode("qty","qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 总用量  */
        public FieldNode<PurchasePlan, BigDecimal> totalQty =  createFieldNode("totalQty","total_qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 单价  */
        public FieldNode<PurchasePlan, BigDecimal> price =  createFieldNode("price","price",BigDecimal.class,JdbcType.DECIMAL);
    	/** 金额  */
        public FieldNode<PurchasePlan, BigDecimal> money =  createFieldNode("money","money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 损耗类型   1 损耗率(%) 0 损耗数  */
        public FieldNode<PurchasePlan, Integer> lossType =  createFieldNode("lossType","loss_type",Integer.class,JdbcType.INTEGER);
    	/** 损耗值  */
        public FieldNode<PurchasePlan, BigDecimal> lossQty =  createFieldNode("lossQty","loss_qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 尺寸(长）  */
        public FieldNode<PurchasePlan, BigDecimal> sizeL =  createFieldNode("sizeL","size_l",BigDecimal.class,JdbcType.DECIMAL);
    	/** 尺寸X  */
        public FieldNode<PurchasePlan, String> sizeX =  createFieldNode("sizeX","size_x",String.class,JdbcType.VARCHAR);
    	/** 尺寸(宽）  */
        public FieldNode<PurchasePlan, BigDecimal> sizeW =  createFieldNode("sizeW","size_w",BigDecimal.class,JdbcType.DECIMAL);
    	/** 长封度  */
        public FieldNode<PurchasePlan, Integer> length =  createFieldNode("length","length",Integer.class,JdbcType.INTEGER);
    	/** 宽封度  */
        public FieldNode<PurchasePlan, Integer> width =  createFieldNode("width","width",Integer.class,JdbcType.INTEGER);
    	/** 刀数  */
        public FieldNode<PurchasePlan, Short> knifeQty =  createFieldNode("knifeQty","knife_qty",Short.class,JdbcType.SMALLINT);
    	/** 层次  */
        public FieldNode<PurchasePlan, Short> depth =  createFieldNode("depth","depth",Short.class,JdbcType.SMALLINT);
    	/** 来源 0--采购1--生产 */
        public FieldNode<PurchasePlan, Byte> source =  createFieldNode("source","source",Byte.class,JdbcType.TINYINT);
    	/** 物料到位日期  */
        public FieldNode<PurchasePlan, Date> rmDate =  createFieldNode("rmDate","rm_date",Date.class,JdbcType.DATE);
    	/** 建档时间  */
        public FieldNode<PurchasePlan, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 建档人  */
        public FieldNode<PurchasePlan, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(PurchasePlan.class,"purchase_plan",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<PurchasePlan> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<PurchasePlan>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}