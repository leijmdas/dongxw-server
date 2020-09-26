package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * WhStock 库存
 * @author generator
 * @date 2020年09月22日
 */
@Table(WhStock.EntityNode.class)
public class WhStock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "标识 ")	
	private Integer id;
	/**
	  * 月结周期标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "月结周期标识 r")	
	@NotNull
	private Integer mcId;
	/**
	  * 年月 r
	  * nullable:false,length:11
	  */
	@Column(comment = "年月 r")	
	@NotNull
	private Integer ym;
	/**
	  * 仓库标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "仓库标识 r")	
	@NotNull
	private Integer wh;
	/**
	  * 客户订单标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "客户订单标识 r")	
	@NotNull
	private Integer orderId;
	/**
	  * 采购订单标识 客户订单
	  * nullable:false,length:11
	  */
	@Column(comment = "采购订单标识 客户订单")	
	@NotNull
	private Integer poId;
	/**
	  * 客户 r
	  * nullable:false,length:11
	  */
	@Column(comment = "客户 r")	
	@NotNull
	private Integer customerId;
	/**
	  * 供应商 r
	  * nullable:false,length:11
	  */
	@Column(comment = "供应商 r")	
	@NotNull
	private Integer supplyId;
	/**
	  * 存货分类 r
	  * nullable:false,length:11
	  */
	@Column(comment = "存货分类 r")	
	@NotNull
	private Integer stockType;
	/**
	  * 物料 0成品100 200
	  * nullable:false,length:11
	  */
	@Column(comment = "物料 0成品100 200")	
	@NotNull
	private Integer productId;
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
	  * 库存数量 
	  * nullable:false,length:34
	  */
	@Column(comment = "库存数量 ")	
	@NotNull
	private BigDecimal qty;
	/**
	  * 入库数量 r
	  * nullable:false,length:14
	  */
	@Column(comment = "入库数量 r")	
	@NotNull
	private BigDecimal qtyIn;
	/**
	  * 出库数量 r
	  * nullable:false,length:14
	  */
	@Column(comment = "出库数量 r")	
	@NotNull
	private BigDecimal qtyOut;
	/**
	  * 创建人 r
	  * nullable:false,length:11
	  */
	@Column(comment = "创建人 r")	
	@NotNull
	private Integer createBy;
	/**
	  * 创建时间 r
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间 r")	
	@NotNull
	private Date createDate;
	/**
	  * 备注 r
	  * nullable:false,length:1,024
	  */
	@Column(comment = "备注 r")	
	@NotNull
	private String remark;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getMcId(){
    	return this.mcId;
    }
    public void setMcId(Integer mcId){
    	this.mcId = mcId;
    }
    public Integer getYm(){
    	return this.ym;
    }
    public void setYm(Integer ym){
    	this.ym = ym;
    }
    public Integer getWh(){
    	return this.wh;
    }
    public void setWh(Integer wh){
    	this.wh = wh;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public Integer getPoId(){
    	return this.poId;
    }
    public void setPoId(Integer poId){
    	this.poId = poId;
    }
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public Integer getStockType(){
    	return this.stockType;
    }
    public void setStockType(Integer stockType){
    	this.stockType = stockType;
    }
    public Integer getProductId(){
    	return this.productId;
    }
    public void setProductId(Integer productId){
    	this.productId = productId;
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
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
    }
    public BigDecimal getQtyIn(){
    	return this.qtyIn;
    }
    public void setQtyIn(BigDecimal qtyIn){
    	this.qtyIn = qtyIn;
    }
    public BigDecimal getQtyOut(){
    	return this.qtyOut;
    }
    public void setQtyOut(BigDecimal qtyOut){
    	this.qtyOut = qtyOut;
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
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }

    public static class EntityNode extends AbstractEntityNode<WhStock> {
        public static final EntityNode INSTANCE = new EntityNode("ws");;
    	/** 标识  */
        public FieldNode<WhStock, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 月结周期标识 r */
        public FieldNode<WhStock, Integer> mcId =  createFieldNode("mcId","mc_id",Integer.class,JdbcType.INTEGER);
    	/** 年月 r */
        public FieldNode<WhStock, Integer> ym =  createFieldNode("ym","ym",Integer.class,JdbcType.INTEGER);
    	/** 仓库标识 r */
        public FieldNode<WhStock, Integer> wh =  createFieldNode("wh","wh",Integer.class,JdbcType.INTEGER);
    	/** 客户订单标识 r */
        public FieldNode<WhStock, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 采购订单标识 客户订单 */
        public FieldNode<WhStock, Integer> poId =  createFieldNode("poId","po_id",Integer.class,JdbcType.INTEGER);
    	/** 客户 r */
        public FieldNode<WhStock, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 供应商 r */
        public FieldNode<WhStock, Integer> supplyId =  createFieldNode("supplyId","supply_id",Integer.class,JdbcType.INTEGER);
    	/** 存货分类 r */
        public FieldNode<WhStock, Integer> stockType =  createFieldNode("stockType","stock_type",Integer.class,JdbcType.INTEGER);
    	/** 物料 0成品100 200 */
        public FieldNode<WhStock, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 单价 r */
        public FieldNode<WhStock, BigDecimal> price =  createFieldNode("price","price",BigDecimal.class,JdbcType.DECIMAL);
    	/** 金额 r */
        public FieldNode<WhStock, BigDecimal> money =  createFieldNode("money","money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 库存数量  */
        public FieldNode<WhStock, BigDecimal> qty =  createFieldNode("qty","qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 入库数量 r */
        public FieldNode<WhStock, BigDecimal> qtyIn =  createFieldNode("qtyIn","qty_in",BigDecimal.class,JdbcType.DECIMAL);
    	/** 出库数量 r */
        public FieldNode<WhStock, BigDecimal> qtyOut =  createFieldNode("qtyOut","qty_out",BigDecimal.class,JdbcType.DECIMAL);
    	/** 创建人 r */
        public FieldNode<WhStock, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 r */
        public FieldNode<WhStock, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 备注 r */
        public FieldNode<WhStock, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(WhStock.class,"wh_stock",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<WhStock> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<WhStock>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}