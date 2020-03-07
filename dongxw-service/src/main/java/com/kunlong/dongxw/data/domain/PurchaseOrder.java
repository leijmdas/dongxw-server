package com.kunlong.dongxw.data.domain;

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
 * PurchaseOrder 采购单
 * @author generator
 * @date 2020年03月07日
 */
@Table(PurchaseOrder.EntityNode.class)
public class PurchaseOrder extends  PurchaseOrderBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 标识 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "标识 ")	
	private Integer id;
	/**
	  * 客户订单 客户订单
	  * nullable:false,length:11
	  */
	@Column(comment = "客户订单 客户订单")	
	@NotNull
	private Integer orderId;
	/**
	  * 供应商 r
	  * nullable:false,length:11
	  */
	@Column(comment = "供应商 r")	
	@NotNull
	private Integer supplyId;
	/**
	  * 联系人 
	  * nullable:false,length:32
	  */
	@Column(comment = "联系人 ")	
	@NotNull
	private String contact;
	/**
	  * 电话 r
	  * nullable:false,length:32
	  */
	@Column(comment = "电话 r")	
	@NotNull
	private String tel;
	/**
	  * 币种 r
	  * nullable:false,length:11
	  */
	@Column(comment = "币种 r")	
	@NotNull
	private Integer moneyType;
	/**
	  * 开单日期 r
	  * nullable:true,length:10
	  */
	@Column(comment = "开单日期 r")	
	private Date openDate;
	/**
	  * 交货日期 r
	  * nullable:true,length:10
	  */
	@Column(comment = "交货日期 r")	
	private Date issueDate;
	/**
	  * 存货分类 0成品100 200
	  * nullable:false,length:11
	  */
	@Column(comment = "存货分类 0成品100 200")	
	@NotNull
	private Integer prdFlg;
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
	private Date createTime;
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
    public Integer getOrderId(){
    	return this.orderId;
    }
    public void setOrderId(Integer orderId){
    	this.orderId = orderId;
    }
    public Integer getSupplyId(){
    	return this.supplyId;
    }
    public void setSupplyId(Integer supplyId){
    	this.supplyId = supplyId;
    }
    public String getContact(){
    	return this.contact;
    }
    public void setContact(String contact){
    	this.contact = contact;
    }
    public String getTel(){
    	return this.tel;
    }
    public void setTel(String tel){
    	this.tel = tel;
    }
    public Integer getMoneyType(){
    	return this.moneyType;
    }
    public void setMoneyType(Integer moneyType){
    	this.moneyType = moneyType;
    }
    public Date getOpenDate(){
    	return this.openDate;
    }
    public void setOpenDate(Date openDate){
    	this.openDate = openDate;
    }
    public Date getIssueDate(){
    	return this.issueDate;
    }
    public void setIssueDate(Date issueDate){
    	this.issueDate = issueDate;
    }
    public Integer getPrdFlg(){
    	return this.prdFlg;
    }
    public void setPrdFlg(Integer prdFlg){
    	this.prdFlg = prdFlg;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Date getCreateTime(){
    	return this.createTime;
    }
    public void setCreateTime(Date createTime){
    	this.createTime = createTime;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }

    public static class EntityNode extends AbstractEntityNode<PurchaseOrder> {
        public static final EntityNode INSTANCE = new EntityNode("po");;
    	/** 标识  */
        public FieldNode<PurchaseOrder, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户订单 客户订单 */
        public FieldNode<PurchaseOrder, Integer> orderId =  createFieldNode("orderId","order_id",Integer.class,JdbcType.INTEGER);
    	/** 供应商 r */
        public FieldNode<PurchaseOrder, Integer> supplyId =  createFieldNode("supplyId","supply_id",Integer.class,JdbcType.INTEGER);
    	/** 联系人  */
        public FieldNode<PurchaseOrder, String> contact =  createFieldNode("contact","contact",String.class,JdbcType.VARCHAR);
    	/** 电话 r */
        public FieldNode<PurchaseOrder, String> tel =  createFieldNode("tel","tel",String.class,JdbcType.VARCHAR);
    	/** 币种 r */
        public FieldNode<PurchaseOrder, Integer> moneyType =  createFieldNode("moneyType","money_type",Integer.class,JdbcType.INTEGER);
    	/** 开单日期 r */
        public FieldNode<PurchaseOrder, Date> openDate =  createFieldNode("openDate","open_date",Date.class,JdbcType.DATE);
    	/** 交货日期 r */
        public FieldNode<PurchaseOrder, Date> issueDate =  createFieldNode("issueDate","issue_date",Date.class,JdbcType.DATE);
    	/** 存货分类 0成品100 200 */
        public FieldNode<PurchaseOrder, Integer> prdFlg =  createFieldNode("prdFlg","prd_flg",Integer.class,JdbcType.INTEGER);
    	/** 备注 r */
        public FieldNode<PurchaseOrder, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建时间 r */
        public FieldNode<PurchaseOrder, Date> createTime =  createFieldNode("createTime","create_time",Date.class,JdbcType.TIMESTAMP);
    	/** 创建人 r */
        public FieldNode<PurchaseOrder, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(PurchaseOrder.class,"purchase_order",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<PurchaseOrder> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<PurchaseOrder>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}