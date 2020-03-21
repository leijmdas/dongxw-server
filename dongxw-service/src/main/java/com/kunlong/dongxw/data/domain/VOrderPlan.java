package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.String;
import java.lang.Integer;
import java.util.Date;
import java.lang.Short;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * VOrderPlan VIEW
 * @author generator
 * @date 2020年03月21日
 */
@Table(VOrderPlan.EntityNode.class)
public class VOrderPlan extends MakePlanBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@Column(comment = "")	
	@NotNull
	private String customerOrderCode;
	/**
	  * 
	  * nullable:false,length:64
	  */
	@Column(comment = "")	
	@NotNull
	private String epOrderCode;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer orderStatus;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer customerId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer orderId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer orderLineId;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer outFlag;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date orderDate;
	/**
	  * 
	  * nullable:false,length:6
	  */
	@Column(comment = "")	
	@NotNull
	private Short outPrepareRm;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date issueDate;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date rmDate;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date pkgDate;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date planStart;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date planEnd;
	/**
	  * 
	  * nullable:true,length:10
	  */
	@Column(comment = "")	
	private Date realEnd;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(comment = "")	
	private Integer finishFlag;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer status;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@Column(comment = "")	
	private String remark;
	/**
	  * 
	  * nullable:false,length:10
	  */
	@Column(comment = "")	
	@NotNull
	private Date createDate;
	/**
	  * 
	  * nullable:false,length:11
	  */
	@Column(comment = "")	
	@NotNull
	private Integer createBy;
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
    public Integer getOrderStatus(){
    	return this.orderStatus;
    }
    public void setOrderStatus(Integer orderStatus){
    	this.orderStatus = orderStatus;
    }
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
    public Integer getOrderLineId(){
    	return this.orderLineId;
    }
    public void setOrderLineId(Integer orderLineId){
    	this.orderLineId = orderLineId;
    }
    public Integer getOutFlag(){
    	return this.outFlag;
    }
    public void setOutFlag(Integer outFlag){
    	this.outFlag = outFlag;
    }
    public Date getOrderDate(){
    	return this.orderDate;
    }
    public void setOrderDate(Date orderDate){
    	this.orderDate = orderDate;
    }
    public Short getOutPrepareRm(){
    	return this.outPrepareRm;
    }
    public void setOutPrepareRm(Short outPrepareRm){
    	this.outPrepareRm = outPrepareRm;
    }
    public Date getIssueDate(){
    	return this.issueDate;
    }
    public void setIssueDate(Date issueDate){
    	this.issueDate = issueDate;
    }
    public Date getRmDate(){
    	return this.rmDate;
    }
    public void setRmDate(Date rmDate){
    	this.rmDate = rmDate;
    }
    public Date getPkgDate(){
    	return this.pkgDate;
    }
    public void setPkgDate(Date pkgDate){
    	this.pkgDate = pkgDate;
    }
    public Date getPlanStart(){
    	return this.planStart;
    }
    public void setPlanStart(Date planStart){
    	this.planStart = planStart;
    }
    public Date getPlanEnd(){
    	return this.planEnd;
    }
    public void setPlanEnd(Date planEnd){
    	this.planEnd = planEnd;
    }
    public Date getRealEnd(){
    	return this.realEnd;
    }
    public void setRealEnd(Date realEnd){
    	this.realEnd = realEnd;
    }
    public Integer getFinishFlag(){
    	return this.finishFlag;
    }
    public void setFinishFlag(Integer finishFlag){
    	this.finishFlag = finishFlag;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
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

    public static class EntityNode extends AbstractEntityNode<VOrderPlan> {
        public static final EntityNode INSTANCE = new EntityNode("vop");;
    	/**  */
        public FieldNode<VOrderPlan, String> customerOrderCode =  createFieldNode("customerOrderCode","customer_order_code",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<VOrderPlan, String> epOrderCode =  createFieldNode("epOrderCode","ep_order_code",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<VOrderPlan, Integer> orderStatus =  createFieldNode("orderStatus","order_status",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Integer> orderLineId =  createFieldNode("orderLineId","order_line_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Integer> outFlag =  createFieldNode("outFlag","out_flag",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Date> orderDate =  createFieldNode("orderDate","order_date",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Short> outPrepareRm =  createFieldNode("outPrepareRm","out_prepare_rm",Short.class,JdbcType.SMALLINT);
    	/**  */
        public FieldNode<VOrderPlan, Date> issueDate =  createFieldNode("issueDate","issue_date",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Date> rmDate =  createFieldNode("rmDate","rm_date",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Date> pkgDate =  createFieldNode("pkgDate","pkg_date",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Date> planStart =  createFieldNode("planStart","plan_start",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Date> planEnd =  createFieldNode("planEnd","plan_end",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Date> realEnd =  createFieldNode("realEnd","real_end",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Integer> finishFlag =  createFieldNode("finishFlag","finish_flag",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VOrderPlan, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<VOrderPlan, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.DATE);
    	/**  */
        public FieldNode<VOrderPlan, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(VOrderPlan.class,"v_order_plan",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<VOrderPlan> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<VOrderPlan>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}