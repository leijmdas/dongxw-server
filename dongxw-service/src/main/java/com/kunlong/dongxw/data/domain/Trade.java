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
 * Trade 交易明细表
 * @author generator
 * @date 2020年11月28日
 */
@Table(Trade.EntityNode.class)
public class Trade  extends TradeBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 交易标识 int(11)
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "交易标识 int(11)")	
	private Integer id;
	/**
	  * 交易主表标识 10 11 20 21 30 31 40 41
	  * nullable:false,length:11
	  */
	@Column(comment = "交易主表标识 10 11 20 21 30 31 40 41")	
	@NotNull
	private Integer masterId;
	/**
	  * 月结标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "月结标识 r")	
	@NotNull
	private Integer mcId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer ym;
	/**
	  * 仓库  r
	  * nullable:false,length:11
	  */
	@Column(comment = "仓库  r")	
	@NotNull
	private Integer wh;
	/**
	  * 客户订单 r
	  * nullable:false,length:11
	  */
	@Column(comment = "客户订单 r")	
	@NotNull
	private Integer orderId;
	/**
	  * 客户订单编号 r
	  * nullable:false,length:32
	  */
	@Column(comment = "客户订单编号 r")	
	@NotNull
	private String orderCode;
	/**
	  * 采购订单 r
	  * nullable:false,length:11
	  */
	@Column(comment = "采购订单 r")	
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
	  * 订单数量 r
	  * nullable:false,length:14
	  */
	@Column(comment = "订单数量 r")	
	@NotNull
	private BigDecimal qtyOrder;
	/**
	  * 完成数量 r
	  * nullable:false,length:14
	  */
	@Column(comment = "完成数量 r")	
	@NotNull
	private BigDecimal qtyFinish;
	/**
	  * 数量 
	  * nullable:false,length:14
	  */
	@Column(comment = "数量 ")	
	@NotNull
	private BigDecimal qty;
	/**
	  * 备品数量 r
	  * nullable:false,length:14
	  */
	@Column(comment = "备品数量 r")	
	@NotNull
	private BigDecimal qtyBackup;
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
	  * 交易类型 10 20 30 40
	  * nullable:false,length:255
	  */
	@Column(comment = "交易类型 10 20 30 40")	
	@NotNull
	private Integer tradeType;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getMasterId(){
    	return this.masterId;
    }
    public void setMasterId(Integer masterId){
    	this.masterId = masterId;
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
    public String getOrderCode(){
    	return this.orderCode;
    }
    public void setOrderCode(String orderCode){
    	this.orderCode = orderCode;
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
    public BigDecimal getQtyOrder(){
    	return this.qtyOrder;
    }
    public void setQtyOrder(BigDecimal qtyOrder){
    	this.qtyOrder = qtyOrder;
    }
    public BigDecimal getQtyFinish(){
    	return this.qtyFinish;
    }
    public void setQtyFinish(BigDecimal qtyFinish){
    	this.qtyFinish = qtyFinish;
    }
    public BigDecimal getQty(){
    	return this.qty;
    }
    public void setQty(BigDecimal qty){
    	this.qty = qty;
    }
    public BigDecimal getQtyBackup(){
    	return this.qtyBackup;
    }
    public void setQtyBackup(BigDecimal qtyBackup){
    	this.qtyBackup = qtyBackup;
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
    public Integer getTradeType(){
    	return this.tradeType;
    }
    public void setTradeType(Integer tradeType){
    	this.tradeType = tradeType;
    }

    public static class EntityNode extends AbstractEntityNode<Trade> {
        public static final EntityNode INSTANCE = new EntityNode("t");;
    	/** 交易标识 int(11) */
        public FieldNode<Trade, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 交易主表标识 10 11 20 21 30 31 40 41 */
        public FieldNode<Trade, Integer> masterId =  createFieldNode("masterId","master_id",Integer.class,JdbcType.INTEGER);
    	/** 月结标识 r */
        public FieldNode<Trade, Integer> mcId =  createFieldNode("mcId","mc_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<Trade, Integer> ym =  createFieldNode("ym","ym",Integer.class,JdbcType.INTEGER);
    	/** 仓库  r */
        public FieldNode<Trade, Integer> wh =  createFieldNode("wh","wh",Integer.class,JdbcType.INTEGER);
    	/** 客户订单 r */
        public FieldNode<Trade, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 客户订单编号 r */
        public FieldNode<Trade, String> orderCode =  createFieldNode("orderCode","order_code",String.class,JdbcType.VARCHAR);
    	/** 采购订单 r */
        public FieldNode<Trade, Integer> poId =  createFieldNode("poId","po_id",Integer.class,JdbcType.INTEGER);
    	/** 客户 r */
        public FieldNode<Trade, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 供应商 r */
        public FieldNode<Trade, Integer> supplyId =  createFieldNode("supplyId","supply_id",Integer.class,JdbcType.INTEGER);
    	/** 存货分类 r */
        public FieldNode<Trade, Integer> stockType =  createFieldNode("stockType","stock_type",Integer.class,JdbcType.INTEGER);
    	/** 物料 0成品100 200 */
        public FieldNode<Trade, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 订单数量 r */
        public FieldNode<Trade, BigDecimal> qtyOrder =  createFieldNode("qtyOrder","qty_order",BigDecimal.class,JdbcType.DECIMAL);
    	/** 完成数量 r */
        public FieldNode<Trade, BigDecimal> qtyFinish =  createFieldNode("qtyFinish","qty_finish",BigDecimal.class,JdbcType.DECIMAL);
    	/** 数量  */
        public FieldNode<Trade, BigDecimal> qty =  createFieldNode("qty","qty",BigDecimal.class,JdbcType.DECIMAL);
    	/** 备品数量 r */
        public FieldNode<Trade, BigDecimal> qtyBackup =  createFieldNode("qtyBackup","qty_backup",BigDecimal.class,JdbcType.DECIMAL);
    	/** 单价 r */
        public FieldNode<Trade, BigDecimal> price =  createFieldNode("price","price",BigDecimal.class,JdbcType.DECIMAL);
    	/** 金额 r */
        public FieldNode<Trade, BigDecimal> money =  createFieldNode("money","money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 备注 r */
        public FieldNode<Trade, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 r */
        public FieldNode<Trade, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 r */
        public FieldNode<Trade, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 交易类型 10 20 30 40 */
        public FieldNode<Trade, Integer> tradeType =  createFieldNode("tradeType","trade_type",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Trade.class,"trade",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Trade> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Trade>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}