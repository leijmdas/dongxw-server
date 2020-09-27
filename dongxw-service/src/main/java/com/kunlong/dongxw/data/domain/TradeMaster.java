package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.lang.Boolean;
import java.lang.Short;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * TradeMaster 交易主表
 * @author generator
 * @date 2020年09月27日
 */
@Table(TradeMaster.EntityNode.class)
public class TradeMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 交易标识 int(11)
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "交易标识 int(11)")	
	private Integer id;
	/**
	  * 月结标识 r
	  * nullable:false,length:11
	  */
	@Column(comment = "月结标识 r")	
	@NotNull
	private Integer mcId;
	/**
	  * 仓库  r
	  * nullable:false,length:11
	  */
	@Column(comment = "仓库  r")	
	@NotNull
	private Integer wh;
	/**
	  * 单号 varchar(32)
	  * nullable:false,length:64
	  */
	@Column(comment = "单号 varchar(32)")	
	@NotNull
	private String code;
	/**
	  * 交易类型 10 20 30 40
	  * nullable:false,length:11
	  */
	@Column(comment = "交易类型 10 20 30 40")	
	@NotNull
	private Integer tradeType;
	/**
	  * 交易状态 10草稿 20有效 30无效
	  * nullable:false,length:11
	  */
	@Column(comment = "交易状态 10草稿 20有效 30无效")	
	@NotNull
	private Integer status;
	/**
	  * 交易时间 r
	  * nullable:true,length:19
	  */
	@Column(comment = "交易时间 r")	
	private Date tradeTime;
	/**
	  * 过帐标识 r
	  * nullable:false,length:1
	  */
	@Column(comment = "过帐标识 r")	
	@NotNull
	private Boolean calFlag;
	/**
	  * 产品名称 r
	  * nullable:false,length:128
	  */
	@Column(comment = "产品名称 r")	
	@NotNull
	private String prdName;
	/**
	  * 产品用途 r
	  * nullable:false,length:64
	  */
	@Column(comment = "产品用途 r")	
	@NotNull
	private String useExp;
	/**
	  * 客户 r
	  * nullable:false,length:11
	  */
	@Column(comment = "客户 r")	
	@NotNull
	private Integer customerId;
	/**
	  * 客户名称 r
	  * nullable:false,length:128
	  */
	@Column(comment = "客户名称 r")	
	@NotNull
	private String custName;
	/**
	  * 付款方式 r
	  * nullable:false,length:64
	  */
	@Column(comment = "付款方式 r")	
	@NotNull
	private String payMode;
	/**
	  * 供方 r
	  * nullable:false,length:11
	  */
	@Column(comment = "供方 r")	
	@NotNull
	private Integer supplyId;
	/**
	  * 领料部门 r
	  * nullable:false,length:32
	  */
	@Column(comment = "领料部门 r")	
	@NotNull
	private String useDpt;
	/**
	  * 客户订单 r
	  * nullable:false,length:11
	  */
	@Column(comment = "客户订单 r")	
	@NotNull
	private Integer orderId;
	/**
	  * 交易人 r
	  * nullable:false,length:32
	  */
	@Column(comment = "交易人 r")	
	@NotNull
	private String tradeBy;
	/**
	  * 采购订单 r
	  * nullable:false,length:11
	  */
	@Column(comment = "采购订单 r")	
	@NotNull
	private Integer poId;
	/**
	  * 制单人 r
	  * nullable:false,length:32
	  */
	@Column(comment = "制单人 r")	
	@NotNull
	private String sheetBy;
	/**
	  * 交货仓库 r
	  * nullable:false,length:128
	  */
	@Column(comment = "交货仓库 r")	
	@NotNull
	private String issueWh;
	/**
	  * 货送联系人 r
	  * nullable:false,length:32
	  */
	@Column(comment = "货送联系人 r")	
	@NotNull
	private String contact;
	/**
	  * 交货地址 r
	  * nullable:false,length:128
	  */
	@Column(comment = "交货地址 r")	
	@NotNull
	private String issueAddr;
	/**
	  * 送货联系电话 r
	  * nullable:false,length:31
	  */
	@Column(comment = "送货联系电话 r")	
	@NotNull
	private String tel;
	/**
	  * 
	  * nullable:false,length:8
	  */
	@Column(comment = "")	
	@NotNull
	private Short tradeCount;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer ym;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer moneyType;
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
    public Integer getWh(){
    	return this.wh;
    }
    public void setWh(Integer wh){
    	this.wh = wh;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public Integer getTradeType(){
    	return this.tradeType;
    }
    public void setTradeType(Integer tradeType){
    	this.tradeType = tradeType;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public Date getTradeTime(){
    	return this.tradeTime;
    }
    public void setTradeTime(Date tradeTime){
    	this.tradeTime = tradeTime;
    }
    public Boolean getCalFlag(){
    	return this.calFlag;
    }
    public void setCalFlag(Boolean calFlag){
    	this.calFlag = calFlag;
    }
    public String getPrdName(){
    	return this.prdName;
    }
    public void setPrdName(String prdName){
    	this.prdName = prdName;
    }
    public String getUseExp(){
    	return this.useExp;
    }
    public void setUseExp(String useExp){
    	this.useExp = useExp;
    }
    public Integer getCustomerId(){
    	return this.customerId;
    }
    public void setCustomerId(Integer customerId){
    	this.customerId = customerId;
    }
    public String getCustName(){
    	return this.custName;
    }
    public void setCustName(String custName){
    	this.custName = custName;
    }
    public String getPayMode(){
    	return this.payMode;
    }
    public void setPayMode(String payMode){
    	this.payMode = payMode;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public String getUseDpt(){
    	return this.useDpt;
    }
    public void setUseDpt(String useDpt){
    	this.useDpt = useDpt;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public String getTradeBy(){
    	return this.tradeBy;
    }
    public void setTradeBy(String tradeBy){
    	this.tradeBy = tradeBy;
    }
    public Integer getPoId(){
    	return this.poId;
    }
    public void setPoId(Integer poId){
    	this.poId = poId;
    }
    public String getSheetBy(){
    	return this.sheetBy;
    }
    public void setSheetBy(String sheetBy){
    	this.sheetBy = sheetBy;
    }
    public String getIssueWh(){
    	return this.issueWh;
    }
    public void setIssueWh(String issueWh){
    	this.issueWh = issueWh;
    }
    public String getContact(){
    	return this.contact;
    }
    public void setContact(String contact){
    	this.contact = contact;
    }
    public String getIssueAddr(){
    	return this.issueAddr;
    }
    public void setIssueAddr(String issueAddr){
    	this.issueAddr = issueAddr;
    }
    public String getTel(){
    	return this.tel;
    }
    public void setTel(String tel){
    	this.tel = tel;
    }
    public Short getTradeCount(){
    	return this.tradeCount;
    }
    public void setTradeCount(Short tradeCount){
    	this.tradeCount = tradeCount;
    }
    public Integer getYm(){
    	return this.ym;
    }
    public void setYm(Integer ym){
    	this.ym = ym;
    }
    public Integer getMoneyType(){
    	return this.moneyType;
    }
    public void setMoneyType(Integer moneyType){
    	this.moneyType = moneyType;
    }

    public static class EntityNode extends AbstractEntityNode<TradeMaster> {
        public static final EntityNode INSTANCE = new EntityNode("tm");;
    	/** 交易标识 int(11) */
        public FieldNode<TradeMaster, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 月结标识 r */
        public FieldNode<TradeMaster, Integer> mcId =  createFieldNode("mcId","mc_id",Integer.class,JdbcType.INTEGER);
    	/** 仓库  r */
        public FieldNode<TradeMaster, Integer> wh =  createFieldNode("wh","wh",Integer.class,JdbcType.INTEGER);
    	/** 单号 varchar(32) */
        public FieldNode<TradeMaster, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 交易类型 10 20 30 40 */
        public FieldNode<TradeMaster, Integer> tradeType =  createFieldNode("tradeType","trade_type",Integer.class,JdbcType.INTEGER);
    	/** 交易状态 10草稿 20有效 30无效 */
        public FieldNode<TradeMaster, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 交易时间 r */
        public FieldNode<TradeMaster, Date> tradeTime =  createFieldNode("tradeTime","trade_time",Date.class,JdbcType.TIMESTAMP);
    	/** 过帐标识 r */
        public FieldNode<TradeMaster, Boolean> calFlag =  createFieldNode("calFlag","cal_flag",Boolean.class,JdbcType.BIT);
    	/** 产品名称 r */
        public FieldNode<TradeMaster, String> prdName =  createFieldNode("prdName","prd_name",String.class,JdbcType.VARCHAR);
    	/** 产品用途 r */
        public FieldNode<TradeMaster, String> useExp =  createFieldNode("useExp","use_exp",String.class,JdbcType.VARCHAR);
    	/** 客户 r */
        public FieldNode<TradeMaster, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 客户名称 r */
        public FieldNode<TradeMaster, String> custName =  createFieldNode("custName","cust_name",String.class,JdbcType.VARCHAR);
    	/** 付款方式 r */
        public FieldNode<TradeMaster, String> payMode =  createFieldNode("payMode","pay_mode",String.class,JdbcType.VARCHAR);
    	/** 供方 r */
        public FieldNode<TradeMaster, Integer> supplyId =  createFieldNode("supplyId","supply_Id",Integer.class,JdbcType.INTEGER);
    	/** 领料部门 r */
        public FieldNode<TradeMaster, String> useDpt =  createFieldNode("useDpt","use_dpt",String.class,JdbcType.VARCHAR);
    	/** 客户订单 r */
        public FieldNode<TradeMaster, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 交易人 r */
        public FieldNode<TradeMaster, String> tradeBy =  createFieldNode("tradeBy","trade_by",String.class,JdbcType.VARCHAR);
    	/** 采购订单 r */
        public FieldNode<TradeMaster, Integer> poId =  createFieldNode("poId","po_id",Integer.class,JdbcType.INTEGER);
    	/** 制单人 r */
        public FieldNode<TradeMaster, String> sheetBy =  createFieldNode("sheetBy","sheet_by",String.class,JdbcType.VARCHAR);
    	/** 交货仓库 r */
        public FieldNode<TradeMaster, String> issueWh =  createFieldNode("issueWh","issue_wh",String.class,JdbcType.VARCHAR);
    	/** 货送联系人 r */
        public FieldNode<TradeMaster, String> contact =  createFieldNode("contact","contact",String.class,JdbcType.VARCHAR);
    	/** 交货地址 r */
        public FieldNode<TradeMaster, String> issueAddr =  createFieldNode("issueAddr","issue_addr",String.class,JdbcType.VARCHAR);
    	/** 送货联系电话 r */
        public FieldNode<TradeMaster, String> tel =  createFieldNode("tel","tel",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<TradeMaster, Short> tradeCount =  createFieldNode("tradeCount","trade_count",Short.class,JdbcType.SMALLINT);
    	/**  */
        public FieldNode<TradeMaster, Integer> ym =  createFieldNode("ym","ym",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<TradeMaster, Integer> moneyType =  createFieldNode("moneyType","money_type",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(TradeMaster.class,"trade_master",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<TradeMaster> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<TradeMaster>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}