package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.persistence.Id;
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
 * Customer 
 * @author generator
 * @date 2020年01月18日
 */
@Table(Customer.EntityNode.class)
public class Customer extends  CustomerBase implements Serializable {
	
	private transient static final long serialVersionUID = 1L;
	/**
	  * 客户主键
	  * nullable:true,length:11
	  */
	@Id
	@Column(primaryKey = true,autoIncrement = true,comment = "客户主键")	
	private Integer id;
	/**
	  * 客户编号
	  * nullable:false,length:24
	  */
	@Column(comment = "客户编号")	
	@NotNull
	private String custNo;
	/**
	  * 客户名称
	  * nullable:false,length:64
	  */
	@Column(comment = "客户名称")	
	@NotNull
	private String custName;
	/**
	  * 客户详细名称
	  * nullable:false,length:64
	  */
	@Column(comment = "客户详细名称")	
	@NotNull
	private String custSname;
	/**
	  * 客户国家
	  * nullable:true,length:32
	  */
	@Column(comment = "客户国家")	
	private String country;
	/**
	  * 客户地址
	  * nullable:false,length:128
	  */
	@Column(comment = "客户地址")	
	@NotNull
	private String addr;
	/**
	  * 结算币种
	  * nullable:false,length:4
	  */
	@Column(comment = "结算币种")	
	@NotNull
	private Integer moneyType;
	/**
	  * 联系人
	  * nullable:true,length:32
	  */
	@Column(comment = "联系人")	
	private String contact;
	/**
	  * 联系人电话
	  * nullable:true,length:24
	  */
	@Column(comment = "联系人电话")	
	private String tel;
	/**
	  * 联系人邮箱
	  * nullable:true,length:64
	  */
	@Column(comment = "联系人邮箱")	
	private String email;
	/**
	  * 建档时间
	  * nullable:false,length:10
	  */
	@Column(comment = "建档时间")	
	@NotNull
	private Date createDate;
	/**
	  * 建档人
	  * nullable:false,length:11
	  */
	@Column(comment = "建档人")	
	@NotNull
	private Integer createBy;
	/**
	  * 
	  * nullable:true,length:4
	  */
	@Column(comment = "")	
	private Integer status;
	/**
	  * 
	  * nullable:true,length:255
	  */
	@Column(comment = "")	
	private String remark;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@Column(comment = "")	
	private String fax;
	/**
	  * 客户登录开关
	  * nullable:false,length:4
	  */
	@Column(comment = "客户登录开关")	
	@NotNull
	private Integer loginSwitch;
	/**
	  * 
	  * nullable:true,length:64
	  */
	@Column(comment = "")	
	private String loginName;
	/**
	  * 语言类型
	  * nullable:false,length:4
	  */
	@Column(comment = "语言类型")	
	@NotNull
	private Integer language;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@Column(comment = "")	
	private String loginPassword;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getCustNo(){
    	return this.custNo;
    }
    public void setCustNo(String custNo){
    	this.custNo = custNo;
    }
    public String getCustName(){
    	return this.custName;
    }
    public void setCustName(String custName){
    	this.custName = custName;
    }
    public String getCustSname(){
    	return this.custSname;
    }
    public void setCustSname(String custSname){
    	this.custSname = custSname;
    }
    public String getCountry(){
    	return this.country;
    }
    public void setCountry(String country){
    	this.country = country;
    }
    public String getAddr(){
    	return this.addr;
    }
    public void setAddr(String addr){
    	this.addr = addr;
    }
    public Integer getMoneyType(){
    	return this.moneyType;
    }
    public void setMoneyType(Integer moneyType){
    	this.moneyType = moneyType;
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
    public String getEmail(){
    	return this.email;
    }
    public void setEmail(String email){
    	this.email = email;
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
    public String getFax(){
    	return this.fax;
    }
    public void setFax(String fax){
    	this.fax = fax;
    }
    public Integer getLoginSwitch(){
    	return this.loginSwitch;
    }
    public void setLoginSwitch(Integer loginSwitch){
    	this.loginSwitch = loginSwitch;
    }
    public String getLoginName(){
    	return this.loginName;
    }
    public void setLoginName(String loginName){
    	this.loginName = loginName;
    }
    public Integer getLanguage(){
    	return this.language;
    }
    public void setLanguage(Integer language){
    	this.language = language;
    }
    public String getLoginPassword(){
    	return this.loginPassword;
    }
    public void setLoginPassword(String loginPassword){
    	this.loginPassword = loginPassword;
    }

    public static class EntityNode extends AbstractEntityNode<Customer> {
        public static final EntityNode INSTANCE = new EntityNode("c");;
    	/** 客户主键 */
        public FieldNode<Customer, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 客户编号 */
        public FieldNode<Customer, String> custNo =  createFieldNode("custNo","cust_no",String.class,JdbcType.VARCHAR);
    	/** 客户名称 */
        public FieldNode<Customer, String> custName =  createFieldNode("custName","cust_name",String.class,JdbcType.VARCHAR);
    	/** 客户详细名称 */
        public FieldNode<Customer, String> custSname =  createFieldNode("custSname","cust_sname",String.class,JdbcType.VARCHAR);
    	/** 客户国家 */
        public FieldNode<Customer, String> country =  createFieldNode("country","country",String.class,JdbcType.VARCHAR);
    	/** 客户地址 */
        public FieldNode<Customer, String> addr =  createFieldNode("addr","addr",String.class,JdbcType.VARCHAR);
    	/** 结算币种 */
        public FieldNode<Customer, Integer> moneyType =  createFieldNode("moneyType","money_type",Integer.class,JdbcType.INTEGER);
    	/** 联系人 */
        public FieldNode<Customer, String> contact =  createFieldNode("contact","contact",String.class,JdbcType.VARCHAR);
    	/** 联系人电话 */
        public FieldNode<Customer, String> tel =  createFieldNode("tel","tel",String.class,JdbcType.VARCHAR);
    	/** 联系人邮箱 */
        public FieldNode<Customer, String> email =  createFieldNode("email","email",String.class,JdbcType.VARCHAR);
    	/** 建档时间 */
        public FieldNode<Customer, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.DATE);
    	/** 建档人 */
        public FieldNode<Customer, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<Customer, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<Customer, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<Customer, String> fax =  createFieldNode("fax","fax",String.class,JdbcType.VARCHAR);
    	/** 客户登录开关 */
        public FieldNode<Customer, Integer> loginSwitch =  createFieldNode("loginSwitch","login_switch",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<Customer, String> loginName =  createFieldNode("loginName","login_name",String.class,JdbcType.VARCHAR);
    	/** 语言类型 */
        public FieldNode<Customer, Integer> language =  createFieldNode("language","language",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<Customer, String> loginPassword =  createFieldNode("loginPassword","login_password",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Customer.class,"customer",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Customer> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Customer>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}