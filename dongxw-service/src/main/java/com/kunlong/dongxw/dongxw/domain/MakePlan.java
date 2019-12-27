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
 * MakePlan 
 * @author generator
 * @date 2019年12月27日
 */
@Table(MakePlan.EntityNode.class)
public class MakePlan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 客户
	  * nullable:false,length:11
	  */
	@Column(comment = "客户")	
	@NotNull
	private Integer custId;
	/**
	  * 订单号
	  * nullable:false,length:11
	  */
	@Column(comment = "订单号")	
	@NotNull
	private Integer orderId;
	/**
	  * 款号
	  * nullable:false,length:11
	  */
	@Column(comment = "款号")	
	@NotNull
	private Integer productId;
	/**
	  * 数量
	  * nullable:true,length:11
	  */
	@Column(comment = "数量")	
	private Integer qty;
	/**
	  * 颜色
	  * nullable:true,length:32
	  */
	@Column(comment = "颜色")	
	private String color;
	/**
	  * 接单日期
	  * nullable:true,length:10
	  */
	@Column(comment = "接单日期")	
	private Date orderDate;
	/**
	  * 要求交期
	  * nullable:true,length:10
	  */
	@Column(comment = "要求交期")	
	private Date issueDate;
	/**
	  * 物料到位日期
	  * nullable:true,length:10
	  */
	@Column(comment = "物料到位日期")	
	private Date preItemDate;
	/**
	  * 包装到位日期
	  * nullable:true,length:10
	  */
	@Column(comment = "包装到位日期")	
	private Date prePackageDate;
	/**
	  * 计划上线
	  * nullable:true,length:10
	  */
	@Column(comment = "计划上线")	
	private Date planOnlineDate;
	/**
	  * 计划完成
	  * nullable:true,length:10
	  */
	@Column(comment = "计划完成")	
	private Date planFinishDate;
	/**
	  * 备注
	  * nullable:true,length:255
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 状态 1-草稿2-批准-3完成4-取消
	  * nullable:true,length:4
	  */
	@Column(comment = "状态 1-草稿2-批准-3完成4-取消")	
	private Integer status;
	/**
	  * 制定人
	  * nullable:true,length:4
	  */
	@Column(comment = "制定人")	
	private Integer createBy;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getCustId(){
    	return this.custId;
    }
    public void setCustId(Integer custId){
    	this.custId = custId;
    }
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
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
    public String getColor(){
    	return this.color;
    }
    public void setColor(String color){
    	this.color = color;
    }
    public Date getOrderDate(){
    	return this.orderDate;
    }
    public void setOrderDate(Date orderDate){
    	this.orderDate = orderDate;
    }
    public Date getIssueDate(){
    	return this.issueDate;
    }
    public void setIssueDate(Date issueDate){
    	this.issueDate = issueDate;
    }
    public Date getPreItemDate(){
    	return this.preItemDate;
    }
    public void setPreItemDate(Date preItemDate){
    	this.preItemDate = preItemDate;
    }
    public Date getPrePackageDate(){
    	return this.prePackageDate;
    }
    public void setPrePackageDate(Date prePackageDate){
    	this.prePackageDate = prePackageDate;
    }
    public Date getPlanOnlineDate(){
    	return this.planOnlineDate;
    }
    public void setPlanOnlineDate(Date planOnlineDate){
    	this.planOnlineDate = planOnlineDate;
    }
    public Date getPlanFinishDate(){
    	return this.planFinishDate;
    }
    public void setPlanFinishDate(Date planFinishDate){
    	this.planFinishDate = planFinishDate;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }

    public static class EntityNode extends AbstractEntityNode<MakePlan> {
        public static final EntityNode INSTANCE = new EntityNode("mp");;
    	/**  */
        public FieldNode<MakePlan, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户 */
        public FieldNode<MakePlan, Integer> custId =  createFieldNode("custId","cust_id",Integer.class,JdbcType.INTEGER);
    	/** 订单号 */
        public FieldNode<MakePlan, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 款号 */
        public FieldNode<MakePlan, Integer> productId =  createFieldNode("productId","product_id",Integer.class,JdbcType.INTEGER);
    	/** 数量 */
        public FieldNode<MakePlan, Integer> qty =  createFieldNode("qty","qty",Integer.class,JdbcType.INTEGER);
    	/** 颜色 */
        public FieldNode<MakePlan, String> color =  createFieldNode("color","color",String.class,JdbcType.VARCHAR);
    	/** 接单日期 */
        public FieldNode<MakePlan, Date> orderDate =  createFieldNode("orderDate","order_date",Date.class,JdbcType.DATE);
    	/** 要求交期 */
        public FieldNode<MakePlan, Date> issueDate =  createFieldNode("issueDate","issue_date",Date.class,JdbcType.DATE);
    	/** 物料到位日期 */
        public FieldNode<MakePlan, Date> preItemDate =  createFieldNode("preItemDate","pre_item_date",Date.class,JdbcType.DATE);
    	/** 包装到位日期 */
        public FieldNode<MakePlan, Date> prePackageDate =  createFieldNode("prePackageDate","pre_package_date",Date.class,JdbcType.DATE);
    	/** 计划上线 */
        public FieldNode<MakePlan, Date> planOnlineDate =  createFieldNode("planOnlineDate","plan_online_date",Date.class,JdbcType.DATE);
    	/** 计划完成 */
        public FieldNode<MakePlan, Date> planFinishDate =  createFieldNode("planFinishDate","plan_finish_date",Date.class,JdbcType.DATE);
    	/** 备注 */
        public FieldNode<MakePlan, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 状态 1-草稿2-批准-3完成4-取消 */
        public FieldNode<MakePlan, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 制定人 */
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