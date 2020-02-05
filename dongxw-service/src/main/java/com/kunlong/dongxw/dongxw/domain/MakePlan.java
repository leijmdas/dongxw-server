package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.util.Date;
import java.lang.Short;
import java.lang.String;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * MakePlan 生产计划表
 * @author generator
 * @date 2020年02月05日
 */
@Table(MakePlan.EntityNode.class)
public class MakePlan extends  MakePlanBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 计划标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "计划标识 ")	
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
	  * 订单产品标识 
	  * nullable:false,length:11
	  */
	@Column(comment = "订单产品标识 ")	
	@NotNull
	private Integer orderLineId;
	/**
	  * 发外标志 0--生产1--外发
	  * nullable:false,length:11
	  */
	@Column(comment = "发外标志 0--生产1--外发")	
	@NotNull
	private Integer outFlag;
	/**
	  * 接单日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "接单日期 ")	
	private Date orderDate;
	/**
	  * 外发备料 
	  * nullable:false,length:6
	  */
	@Column(comment = "外发备料 ")	
	@NotNull
	private Short outPrepareRm;
	/**
	  * 要求交期 
	  * nullable:true,length:10
	  */
	@Column(comment = "要求交期 ")	
	private Date issueDate;
	/**
	  * 物料到位日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "物料到位日期 ")	
	private Date rmDate;
	/**
	  * 包材到位日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "包材到位日期 ")	
	private Date pkgDate;
	/**
	  * 计划上线 
	  * nullable:true,length:10
	  */
	@Column(comment = "计划上线 ")	
	private Date planStart;
	/**
	  * 计划完成 
	  * nullable:true,length:10
	  */
	@Column(comment = "计划完成 ")	
	private Date planEnd;
	/**
	  * 实际完成日期 
	  * nullable:true,length:10
	  */
	@Column(comment = "实际完成日期 ")	
	private Date realEnd;
	/**
	  * 完成标志 0--未完成1--完成
	  * nullable:true,length:11
	  */
	@Column(comment = "完成标志 0--未完成1--完成")	
	private Integer finishFlag;
	/**
	  * 审核状态 
	  * nullable:false,length:11
	  */
	@Column(comment = "审核状态 ")	
	@NotNull
	private Integer status;
	/**
	  * 备注 
	  * nullable:true,length:128
	  */
	@Column(comment = "备注 ")	
	private String remark;
	/**
	  * 建档时间 
	  * nullable:false,length:10
	  */
	@Column(comment = "建档时间 ")	
	@NotNull
	private Date createDate;
	/**
	  * 建档人 
	  * nullable:false,length:11
	  */
	@Column(comment = "建档人 ")	
	@NotNull
	private Integer createBy;
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

    public static class EntityNode extends AbstractEntityNode<MakePlan> {
        public static final EntityNode INSTANCE = new EntityNode("mp");;
    	/** 计划标识  */
        public FieldNode<MakePlan, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户标识  */
        public FieldNode<MakePlan, Integer> customerId =  createFieldNode("customerId","customer_id",Integer.class,JdbcType.INTEGER);
    	/** 订单标识  */
        public FieldNode<MakePlan, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 订单产品标识  */
        public FieldNode<MakePlan, Integer> orderLineId =  createFieldNode("orderLineId","order_line_id",Integer.class,JdbcType.INTEGER);
    	/** 发外标志 0--生产1--外发 */
        public FieldNode<MakePlan, Integer> outFlag =  createFieldNode("outFlag","out_flag",Integer.class,JdbcType.INTEGER);
    	/** 接单日期  */
        public FieldNode<MakePlan, Date> orderDate =  createFieldNode("orderDate","order_date",Date.class,JdbcType.DATE);
    	/** 外发备料  */
        public FieldNode<MakePlan, Short> outPrepareRm =  createFieldNode("outPrepareRm","out_prepare_rm",Short.class,JdbcType.SMALLINT);
    	/** 要求交期  */
        public FieldNode<MakePlan, Date> issueDate =  createFieldNode("issueDate","issue_date",Date.class,JdbcType.DATE);
    	/** 物料到位日期  */
        public FieldNode<MakePlan, Date> rmDate =  createFieldNode("rmDate","rm_date",Date.class,JdbcType.DATE);
    	/** 包材到位日期  */
        public FieldNode<MakePlan, Date> pkgDate =  createFieldNode("pkgDate","pkg_date",Date.class,JdbcType.DATE);
    	/** 计划上线  */
        public FieldNode<MakePlan, Date> planStart =  createFieldNode("planStart","plan_start",Date.class,JdbcType.DATE);
    	/** 计划完成  */
        public FieldNode<MakePlan, Date> planEnd =  createFieldNode("planEnd","plan_end",Date.class,JdbcType.DATE);
    	/** 实际完成日期  */
        public FieldNode<MakePlan, Date> realEnd =  createFieldNode("realEnd","real_end",Date.class,JdbcType.DATE);
    	/** 完成标志 0--未完成1--完成 */
        public FieldNode<MakePlan, Integer> finishFlag =  createFieldNode("finishFlag","finish_flag",Integer.class,JdbcType.INTEGER);
    	/** 审核状态  */
        public FieldNode<MakePlan, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 备注  */
        public FieldNode<MakePlan, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 建档时间  */
        public FieldNode<MakePlan, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.DATE);
    	/** 建档人  */
        public FieldNode<MakePlan, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(MakePlan.class,"make_plan",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<MakePlan> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<MakePlan>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}