package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * PurchaseOrderItem 采购清单
 * @author generator
 * @date 2020年03月08日
 */
@Table(PurchaseOrderItem.EntityNode.class)
public class PurchaseOrderItem extends  PurchaseOrderItemBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "标识 ")	
	private Integer id;
	/**
	  * 采购订单主表 客户订单
	  * nullable:false,length:11
	  */
	@Column(comment = "采购订单主表 客户订单")	
	@NotNull
	private Integer purchaseOrderId;
	/**
	  *   生产计划产品标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "  生产计划产品标识 r")	
	@NotNull
	private Integer makePlanId;
	/**
	  * 客户订单产品标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "客户订单产品标识 r")	
	@NotNull
	private Integer orderLineId;
	/**
	  * 产品 0成品100 200
	  * nullable:false,length:11
	  */
	@Column(comment = "产品 0成品100 200")	
	@NotNull
	private Integer productId;
	/**
	  * 数量 
	  * nullable:false,length:34
	  */
	@Column(comment = "数量 ")	
	@NotNull
	private BigDecimal qty;
	/**
	  * 单价 r
	  * nullable:false,length:12
	  */
	@Column(comment = "单价 r")	
	@NotNull
	private BigDecimal price;
	/**
	  * 金额 r
	  * nullable:false,length:14
	  */
	@Column(comment = "金额 r")	
	@NotNull
	private BigDecimal money;
	/**
	  * 备注 r
	  * nullable:false,length:1,024
	  */
	@Column(comment = "备注 r")	
	@NotNull
	private String remark;
	/**
	  * 创建时间 r
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间 r")	
	@NotNull
	private Date createDate;
	/**
	  * 创建人 r
	  * nullable:false,length:11
	  */
	@Column(comment = "创建人 r")	
	@NotNull
	private Integer createBy;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getPurchaseOrderId(){
    	return this.purchaseOrderId;
    }
    public void setPurchaseOrderId(Integer purchaseOrderId){
    	this.purchaseOrderId = purchaseOrderId;
    }
    public Integer getMakePlanId(){
    	return this.makePlanId;
    }
    public void setMakePlanId(Integer makePlanId){
    	this.makePlanId = makePlanId;
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

    public static class EntityNode extends AbstractEntityNode<PurchaseOrderItem> {
        public static final EntityNode INSTANCE = new EntityNode("poi");;
    	/** 标识  */
        public FieldNode<PurchaseOrderItem, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 采购订单主表 客户订单 */
        public FieldNode<PurchaseOrderItem, Integer> purchaseOrderId =  createFieldNode("purchaseOrderId","purchase_order_id",Integer.class,JdbcType.INTEGER);
    	/**   生产计划产品标识 r */
        public FieldNode<PurchaseOrderItem, Integer> makePlanId =  createFieldNode("makePlanId","make_plan_id",Integer.class,JdbcType.INTEGER);
    	/** 客户订单产品标识 r */
        public FieldNode<PurchaseOrderItem, Integer> orderLineId =  createFieldNode("orderLineId","order_line_id",Integer.class,JdbcType.INTEGER);
    	/** 产品 0成品100 200 */
        public FieldNode<PurchaseOrderItem, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 数量  */
        public FieldNode<PurchaseOrderItem, BigDecimal> qty =  createFieldNode("qty","qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 单价 r */
        public FieldNode<PurchaseOrderItem, BigDecimal> price =  createFieldNode("price","price",BigDecimal.class,JdbcType.DECIMAL);
    	/** 金额 r */
        public FieldNode<PurchaseOrderItem, BigDecimal> money =  createFieldNode("money","money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 备注 r */
        public FieldNode<PurchaseOrderItem, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建时间 r */
        public FieldNode<PurchaseOrderItem, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 创建人 r */
        public FieldNode<PurchaseOrderItem, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(PurchaseOrderItem.class,"purchase_order_item",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<PurchaseOrderItem> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<PurchaseOrderItem>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}