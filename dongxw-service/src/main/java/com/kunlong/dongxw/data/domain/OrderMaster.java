package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.lang.Long;
import java.lang.Boolean;
import java.math.BigDecimal;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * OrderMaster 客户订单
 * @author generator
 * @date 2020年11月07日
 */
@Table(OrderMaster.EntityNode.class)
public class OrderMaster extends  OrderMasterBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键 ")	
	private Integer id;
	/**
	  * 客户 
	  * nullable:false,length:11
	  */
	@Column(comment = "客户 ")	
	@NotNull
	private Integer customerId;
	/**
	  * 业务员 
	  * nullable:false,length:32
	  */
	@Column(comment = "业务员 ")	
	@NotNull
	private String businessBy;
	/**
	  * 状态 0-草稿10-下单20-在生产-30-生产完成40--发货完成50-收款完成100-取消
	  * nullable:false,length:11
	  */
	@Column(comment = "状态 0-草稿10-下单20-在生产-30-生产完成40--发货完成50-收款完成100-取消")	
	@NotNull
	private Integer status;
	/**
	  * 客户订单号 
	  * nullable:false,length:64
	  */
	@Column(comment = "客户订单号 ")	
	@NotNull
	private String customerOrderCode;
	/**
	  * EP订单号 
	  * nullable:false,length:64
	  */
	@Column(comment = "EP订单号 ")	
	@NotNull
	private String epOrderCode;
	/**
	  * 结算币种 
	  * nullable:false,length:11
	  */
	@Column(comment = "结算币种 ")	
	@NotNull
	private Integer moneyType;
	/**
	  * 初始发票编号 初始预付款
	  * nullable:false,length:128
	  */
	@Column(comment = "初始发票编号 初始预付款")	
	@NotNull
	private String invoiceNoIni;
	/**
	  * 正式发票编号 
	  * nullable:false,length:128
	  */
	@Column(comment = "正式发票编号 ")	
	@NotNull
	private String invoiceNo;
	/**
	  * 下单日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "下单日期 ")	
	private Date orderDate;
	/**
	  * 客户交货日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "客户交货日期 ")	
	private Date customerIssueDate;
	/**
	  * 验货日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "验货日期 ")	
	private Date checkDate;
	/**
	  * 工厂交货日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "工厂交货日期 ")	
	private Date factroyIssueDate;
	/**
	  * 订单原件 
	  * nullable:true,length:256
	  */
	@Column(comment = "订单原件 ")	
	private String customerOrderImg;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@Column(comment = "建档人 ")	
	@NotNull
	private Integer createBy;
	/**
	  * 建档时间 
	  * nullable:true,length:19
	  */
	@Column(comment = "建档时间 ")	
	private Date createDate;
	/**
	  * 备注 
	  * nullable:false,length:512
	  */
	@Column(comment = "备注 ")	
	@NotNull
	private String remark;
	/**
	  * 初始发票图片 
	  * nullable:false,length:20
	  */
	@Column(comment = "初始发票图片 ")	
	@NotNull
	private Long invoiceIdIni;
	/**
	  * 正式发票图片 
	  * nullable:false,length:20
	  */
	@Column(comment = "正式发票图片 ")	
	@NotNull
	private Long invoiceId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer parentId;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@Column(comment = "")	
	@NotNull
	private Integer orderType;
	/**
	  * 是否含税
	  * nullable:false,length:1
	  */
	@Column(comment = "是否含税")	
	@NotNull
	private Boolean includeTax;
	/**
	  * 订单总金额
	  * nullable:false,length:16
	  */
	@Column(comment = "订单总金额")	
	@NotNull
	private BigDecimal totalMoney;
	/**
	  * 定金
	  * nullable:false,length:14
	  */
	@Column(comment = "定金")	
	@NotNull
	private BigDecimal orderMoney;
	/**
	  * 支付方式
	  * nullable:false,length:32
	  */
	@Column(comment = "支付方式")	
	@NotNull
	private String payMode;
	/**
	  * 支付备注
	  * nullable:false,length:256
	  */
	@Column(comment = "支付备注")	
	@NotNull
	private String payMemo;
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
    public String getBusinessBy(){
    	return this.businessBy;
    }
    public void setBusinessBy(String businessBy){
    	this.businessBy = businessBy;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public String getCustomerOrderCode(){
    	return this.customerOrderCode;
    }
    public void setCustomerOrderCode(String customerOrderCode){
    	this.customerOrderCode = customerOrderCode;
    }
    public String getEpOrderCode(){
    	return this.epOrderCode;
    }
    public void setEpOrderCode(String epOrderCode){
    	this.epOrderCode = epOrderCode;
    }
    public Integer getMoneyType(){
    	return this.moneyType;
    }
    public void setMoneyType(Integer moneyType){
    	this.moneyType = moneyType;
    }
    public String getInvoiceNoIni(){
    	return this.invoiceNoIni;
    }
    public void setInvoiceNoIni(String invoiceNoIni){
    	this.invoiceNoIni = invoiceNoIni;
    }
    public String getInvoiceNo(){
    	return this.invoiceNo;
    }
    public void setInvoiceNo(String invoiceNo){
    	this.invoiceNo = invoiceNo;
    }
    public Date getOrderDate(){
    	return this.orderDate;
    }
    public void setOrderDate(Date orderDate){
    	this.orderDate = orderDate;
    }
    public Date getCustomerIssueDate(){
    	return this.customerIssueDate;
    }
    public void setCustomerIssueDate(Date customerIssueDate){
    	this.customerIssueDate = customerIssueDate;
    }
    public Date getCheckDate(){
    	return this.checkDate;
    }
    public void setCheckDate(Date checkDate){
    	this.checkDate = checkDate;
    }
    public Date getFactroyIssueDate(){
    	return this.factroyIssueDate;
    }
    public void setFactroyIssueDate(Date factroyIssueDate){
    	this.factroyIssueDate = factroyIssueDate;
    }
    public String getCustomerOrderImg(){
    	return this.customerOrderImg;
    }
    public void setCustomerOrderImg(String customerOrderImg){
    	this.customerOrderImg = customerOrderImg;
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
    public Long getInvoiceIdIni(){
    	return this.invoiceIdIni;
    }
    public void setInvoiceIdIni(Long invoiceIdIni){
    	this.invoiceIdIni = invoiceIdIni;
    }
    public Long getInvoiceId(){
    	return this.invoiceId;
    }
    public void setInvoiceId(Long invoiceId){
    	this.invoiceId = invoiceId;
    }
    public Integer getParentId(){
    	return this.parentId;
    }
    public void setParentId(Integer parentId){
    	this.parentId = parentId;
    }
    public Integer getOrderType(){
    	return this.orderType;
    }
    public void setOrderType(Integer orderType){
    	this.orderType = orderType;
    }
    public Boolean getIncludeTax(){
    	return this.includeTax;
    }
    public void setIncludeTax(Boolean includeTax){
    	this.includeTax = includeTax;
    }
    public BigDecimal getTotalMoney(){
    	return this.totalMoney;
    }
    public void setTotalMoney(BigDecimal totalMoney){
    	this.totalMoney = totalMoney;
    }
    public BigDecimal getOrderMoney(){
    	return this.orderMoney;
    }
    public void setOrderMoney(BigDecimal orderMoney){
    	this.orderMoney = orderMoney;
    }
    public String getPayMode(){
    	return this.payMode;
    }
    public void setPayMode(String payMode){
    	this.payMode = payMode;
    }
    public String getPayMemo(){
    	return this.payMemo;
    }
    public void setPayMemo(String payMemo){
    	this.payMemo = payMemo;
    }

    public static class EntityNode extends AbstractEntityNode<OrderMaster> {
        public static final EntityNode INSTANCE = new EntityNode("om");;
    	/** 主键  */
        public FieldNode<OrderMaster, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户  */
        public FieldNode<OrderMaster, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 业务员  */
        public FieldNode<OrderMaster, String> businessBy =  createFieldNode("businessBy","business_by",String.class,JdbcType.VARCHAR);
    	/** 状态 0-草稿10-下单20-在生产-30-生产完成40--发货完成50-收款完成100-取消 */
        public FieldNode<OrderMaster, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 客户订单号  */
        public FieldNode<OrderMaster, String> customerOrderCode =  createFieldNode("customerOrderCode","customer_order_code",String.class,JdbcType.VARCHAR);
    	/** EP订单号  */
        public FieldNode<OrderMaster, String> epOrderCode =  createFieldNode("epOrderCode","ep_order_code",String.class,JdbcType.VARCHAR);
    	/** 结算币种  */
        public FieldNode<OrderMaster, Integer> moneyType =  createFieldNode("moneyType","money_type",Integer.class,JdbcType.INTEGER);
    	/** 初始发票编号 初始预付款 */
        public FieldNode<OrderMaster, String> invoiceNoIni =  createFieldNode("invoiceNoIni","invoice_no_ini",String.class,JdbcType.VARCHAR);
    	/** 正式发票编号  */
        public FieldNode<OrderMaster, String> invoiceNo =  createFieldNode("invoiceNo","invoice_no",String.class,JdbcType.VARCHAR);
    	/** 下单日期  */
        public FieldNode<OrderMaster, Date> orderDate =  createFieldNode("orderDate","order_date",Date.class,JdbcType.DATE);
    	/** 客户交货日期  */
        public FieldNode<OrderMaster, Date> customerIssueDate =  createFieldNode("customerIssueDate","customer_issue_date",Date.class,JdbcType.DATE);
    	/** 验货日期  */
        public FieldNode<OrderMaster, Date> checkDate =  createFieldNode("checkDate","check_date",Date.class,JdbcType.DATE);
    	/** 工厂交货日期  */
        public FieldNode<OrderMaster, Date> factroyIssueDate =  createFieldNode("factroyIssueDate","factroy_issue_date",Date.class,JdbcType.DATE);
    	/** 订单原件  */
        public FieldNode<OrderMaster, String> customerOrderImg =  createFieldNode("customerOrderImg","customer_order_img",String.class,JdbcType.VARCHAR);
    	/** 建档人  */
        public FieldNode<OrderMaster, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 建档时间  */
        public FieldNode<OrderMaster, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
    	/** 备注  */
        public FieldNode<OrderMaster, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 初始发票图片  */
        public FieldNode<OrderMaster, Long> invoiceIdIni =  createFieldNode("invoiceIdIni","invoice_id_ini",Long.class,JdbcType.BIGINT);
    	/** 正式发票图片  */
        public FieldNode<OrderMaster, Long> invoiceId =  createFieldNode("invoiceId","invoice_id",Long.class,JdbcType.BIGINT);
    	/**  */
        public FieldNode<OrderMaster, Integer> parentId =  createFieldNode("parentId","parent_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<OrderMaster, Integer> orderType =  createFieldNode("orderType","order_type",Integer.class,JdbcType.INTEGER);
    	/** 是否含税 */
        public FieldNode<OrderMaster, Boolean> includeTax =  createFieldNode("includeTax","include_tax",Boolean.class,JdbcType.BIT);
    	/** 订单总金额 */
        public FieldNode<OrderMaster, BigDecimal> totalMoney =  createFieldNode("totalMoney","total_money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 定金 */
        public FieldNode<OrderMaster, BigDecimal> orderMoney =  createFieldNode("orderMoney","order_money",BigDecimal.class,JdbcType.DECIMAL);
    	/** 支付方式 */
        public FieldNode<OrderMaster, String> payMode =  createFieldNode("payMode","pay_mode",String.class,JdbcType.VARCHAR);
    	/** 支付备注 */
        public FieldNode<OrderMaster, String> payMemo =  createFieldNode("payMemo","pay_memo",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(OrderMaster.class,"order_master",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<OrderMaster> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<OrderMaster>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}