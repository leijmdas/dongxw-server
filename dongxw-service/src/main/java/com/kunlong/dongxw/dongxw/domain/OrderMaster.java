package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * OrderMaster 客户订单
 * @author generator
 * @date 2020年01月03日
 */
@Table(OrderMaster.EntityNode.class)
public class OrderMaster implements Serializable {
	
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
	  * 状态 0-草稿1-下单2-在生产-3-生产完成4--发货完成5-收款完成
	  * nullable:false,length:11
	  */
	@Column(comment = "状态 0-草稿1-下单2-在生产-3-生产完成4--发货完成5-收款完成")	
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
	  * 主料描述 
	  * nullable:false,length:512
	  */
	@Column(comment = "主料描述 ")	
	@NotNull
	private String materialRemark;
	/**
	  * 供应商 
	  * nullable:false,length:11
	  */
	@Column(comment = "供应商 ")	
	@NotNull
	private Integer supplyId;
	/**
	  * 备注 
	  * nullable:false,length:512
	  */
	@Column(comment = "备注 ")	
	@NotNull
	private String remark;
	/**
	  * 订单图片存档 
	  * nullable:true,length:256
	  */
	@Column(comment = "订单图片存档 ")	
	private String customerOrderImg;
	/**
	  * 发票编号 
	  * nullable:false,length:128
	  */
	@Column(comment = "发票编号 ")	
	@NotNull
	private String invoiceNo;
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
    public String getMaterialRemark(){
    	return this.materialRemark;
    }
    public void setMaterialRemark(String materialRemark){
    	this.materialRemark = materialRemark;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public String getCustomerOrderImg(){
    	return this.customerOrderImg;
    }
    public void setCustomerOrderImg(String customerOrderImg){
    	this.customerOrderImg = customerOrderImg;
    }
    public String getInvoiceNo(){
    	return this.invoiceNo;
    }
    public void setInvoiceNo(String invoiceNo){
    	this.invoiceNo = invoiceNo;
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

    public static class EntityNode extends AbstractEntityNode<OrderMaster> {
        public static final EntityNode INSTANCE = new EntityNode("om");;
    	/** 主键  */
        public FieldNode<OrderMaster, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户  */
        public FieldNode<OrderMaster, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 业务员  */
        public FieldNode<OrderMaster, String> businessBy =  createFieldNode("businessBy","business_by",String.class,JdbcType.VARCHAR);
    	/** 状态 0-草稿1-下单2-在生产-3-生产完成4--发货完成5-收款完成 */
        public FieldNode<OrderMaster, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 客户订单号  */
        public FieldNode<OrderMaster, String> customerOrderCode =  createFieldNode("customerOrderCode","customer_order_code",String.class,JdbcType.VARCHAR);
    	/** EP订单号  */
        public FieldNode<OrderMaster, String> epOrderCode =  createFieldNode("epOrderCode","ep_order_code",String.class,JdbcType.VARCHAR);
    	/** 下单日期  */
        public FieldNode<OrderMaster, Date> orderDate =  createFieldNode("orderDate","order_date",Date.class,JdbcType.DATE);
    	/** 客户交货日期  */
        public FieldNode<OrderMaster, Date> customerIssueDate =  createFieldNode("customerIssueDate","customer_issue_date",Date.class,JdbcType.DATE);
    	/** 验货日期  */
        public FieldNode<OrderMaster, Date> checkDate =  createFieldNode("checkDate","check_date",Date.class,JdbcType.DATE);
    	/** 工厂交货日期  */
        public FieldNode<OrderMaster, Date> factroyIssueDate =  createFieldNode("factroyIssueDate","factroy_issue_date",Date.class,JdbcType.DATE);
    	/** 主料描述  */
        public FieldNode<OrderMaster, String> materialRemark =  createFieldNode("materialRemark","material_remark",String.class,JdbcType.VARCHAR);
    	/** 供应商  */
        public FieldNode<OrderMaster, Integer> supplyId =  createFieldNode("supplyId","supply_id",Integer.class,JdbcType.INTEGER);
    	/** 备注  */
        public FieldNode<OrderMaster, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 订单图片存档  */
        public FieldNode<OrderMaster, String> customerOrderImg =  createFieldNode("customerOrderImg","customer_order_img",String.class,JdbcType.VARCHAR);
    	/** 发票编号  */
        public FieldNode<OrderMaster, String> invoiceNo =  createFieldNode("invoiceNo","invoice_no",String.class,JdbcType.VARCHAR);
    	/** 建档人  */
        public FieldNode<OrderMaster, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 建档时间  */
        public FieldNode<OrderMaster, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.TIMESTAMP);
	
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// ==== 自定义属性 ====
	Customer customer;

}