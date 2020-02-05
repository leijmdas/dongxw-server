package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Boolean;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * OrderLine 订单产品表
 * @author generator
 * @date 2020年02月05日
 */
@Table(OrderLine.EntityNode.class)
public class OrderLine extends OrderLineBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 订单产品标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "订单产品标识 ")	
	private Integer id;
	/**
	  * 客户标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "客户标识 ")	
	@NotNull
	private Integer customerId;
	/**
	  * 订单标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "订单标识 ")	
	@NotNull
	private Integer orderId;
	/**
	  * 产品大类 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品大类 ")	
	@NotNull
	private Integer parentId;
	/**
	  * 产品小类 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品小类 ")	
	@NotNull
	private Integer productTypeId;
	/**
	  * 产品标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品标识 ")	
	@NotNull
	private Integer productId;
	/**
	  * 数量 
	  * nullable:false,length:11
	  */
	@Column(comment = "数量 ")	
	@NotNull
	private Integer qty;
	/**
	  * 单价 
	  * nullable:false,length:10
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
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@Column(comment = "建档时间 ")	
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@Column(comment = "建档人 ")	
	@NotNull
	private Integer createBy;
	/**
	  * 备注 
	  * nullable:true,length:256
	  */
	@Column(comment = "备注 ")	
	private String remark;
	/**
	  * 
	  * nullable:false,length:1
	  */
	@Column(comment = "")	
	@NotNull
	private Boolean status;
	/**
	  * 货币 
	  * nullable:false,length:16
	  */
	@Column(comment = "货币 ")	
	@NotNull
	private String currency;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
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
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
    }
    public Integer getQty(){
    	return this.qty;
    }
    public void setQty(Integer qty){
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
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Boolean getStatus(){
    	return this.status;
    }
    public void setStatus(Boolean status){
    	this.status = status;
    }
    public String getCurrency(){
    	return this.currency;
    }
    public void setCurrency(String currency){
    	this.currency = currency;
    }

    public static class EntityNode extends AbstractEntityNode<OrderLine> {
        public static final EntityNode INSTANCE = new EntityNode("ol");;
    	/** 订单产品标识  */
        public FieldNode<OrderLine, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户标识  */
        public FieldNode<OrderLine, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 订单标识  */
        public FieldNode<OrderLine, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 产品大类  */
        public FieldNode<OrderLine, Integer> parentId =  createFieldNode("parentId","parent_id",Integer.class,JdbcType.INTEGER);
    	/** 产品小类  */
        public FieldNode<OrderLine, Integer> productTypeId =  createFieldNode("productTypeId","product_type_id",Integer.class,JdbcType.INTEGER);
    	/** 产品标识  */
        public FieldNode<OrderLine, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 数量  */
        public FieldNode<OrderLine, Integer> qty =  createFieldNode("qty","qty",Integer.class,JdbcType.INTEGER);
    	/** 单价  */
        public FieldNode<OrderLine, BigDecimal> price =  createFieldNode("price","price",BigDecimal.class,JdbcType.DECIMAL);
    	/** 金额  */
        public FieldNode<OrderLine, BigDecimal> money =  createFieldNode("money","money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 建档时间  */
        public FieldNode<OrderLine, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 建档人  */
        public FieldNode<OrderLine, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 备注  */
        public FieldNode<OrderLine, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<OrderLine, Boolean> status =  createFieldNode("status","status",Boolean.class,JdbcType.BIT);
    	/** 货币  */
        public FieldNode<OrderLine, String> currency =  createFieldNode("currency","currency",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(OrderLine.class,"order_line",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<OrderLine> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<OrderLine>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}