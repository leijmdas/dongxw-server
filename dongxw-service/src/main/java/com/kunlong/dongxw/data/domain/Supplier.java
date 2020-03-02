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
 * Supplier 供应商
 * @author generator
 * @date 2020年03月02日
 */
@Table(Supplier.EntityNode.class)
public class Supplier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 供应商主键 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "供应商主键 ")	
	private Integer id;
	/**
	  * 供应商编号 
	  * nullable:false,length:24
	  */
	@Column(comment = "供应商编号 ")	
	@NotNull
	private String code;
	/**
	  * 供应商名称 
	  * nullable:false,length:64
	  */
	@Column(comment = "供应商名称 ")	
	@NotNull
	private String name;
	/**
	  * 供应商详细名称 
	  * nullable:false,length:128
	  */
	@Column(comment = "供应商详细名称 ")	
	@NotNull
	private String sname;
	/**
	  * 供应商国家 
	  * nullable:true,length:32
	  */
	@Column(comment = "供应商国家 ")	
	private String country;
	/**
	  * 供应商地址 
	  * nullable:false,length:128
	  */
	@Column(comment = "供应商地址 ")	
	@NotNull
	private String addr;
	/**
	  * 结算币种 
	  * nullable:false,length:11
	  */
	@Column(comment = "结算币种 ")	
	@NotNull
	private Integer moneyType;
	/**
	  * 联系人 
	  * nullable:true,length:32
	  */
	@Column(comment = "联系人 ")	
	private String contact;
	/**
	  * 联系人电话 
	  * nullable:true,length:24
	  */
	@Column(comment = "联系人电话 ")	
	private String tel;
	/**
	  * 联系人邮箱 
	  * nullable:true,length:64
	  */
	@Column(comment = "联系人邮箱 ")	
	private String email;
	/**
	  * 状态 
	  * nullable:false,length:11
	  */
	@Column(comment = "状态 ")	
	@NotNull
	private Integer status;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@Column(comment = "")	
	@NotNull
	private Integer type;
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
	/**
	  * 备注 
	  * nullable:false,length:256
	  */
	@Column(comment = "备注 ")	
	@NotNull
	private String remark;
	/**
	  * 营业执照 
	  * nullable:true,length:256
	  */
	@Column(comment = "营业执照 ")	
	private String businessLicense;
	/**
	  * 环境 
	  * nullable:true,length:256
	  */
	@Column(comment = "环境 ")	
	private String env;
	/**
	  * 资质 
	  * nullable:true,length:4
	  */
	@Column(comment = "资质 ")	
	private String intelligence;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@Column(comment = "")	
	private String fax;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getSname(){
    	return this.sname;
    }
    public void setSname(String sname){
    	this.sname = sname;
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
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public Integer getType(){
    	return this.type;
    }
    public void setType(Integer type){
    	this.type = type;
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
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public String getBusinessLicense(){
    	return this.businessLicense;
    }
    public void setBusinessLicense(String businessLicense){
    	this.businessLicense = businessLicense;
    }
    public String getEnv(){
    	return this.env;
    }
    public void setEnv(String env){
    	this.env = env;
    }
    public String getIntelligence(){
    	return this.intelligence;
    }
    public void setIntelligence(String intelligence){
    	this.intelligence = intelligence;
    }
    public String getFax(){
    	return this.fax;
    }
    public void setFax(String fax){
    	this.fax = fax;
    }

    public static class EntityNode extends AbstractEntityNode<Supplier> {
        public static final EntityNode INSTANCE = new EntityNode("s");;
    	/** 供应商主键  */
        public FieldNode<Supplier, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 供应商编号  */
        public FieldNode<Supplier, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 供应商名称  */
        public FieldNode<Supplier, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/** 供应商详细名称  */
        public FieldNode<Supplier, String> sname =  createFieldNode("sname","sname",String.class,JdbcType.VARCHAR);
    	/** 供应商国家  */
        public FieldNode<Supplier, String> country =  createFieldNode("country","country",String.class,JdbcType.VARCHAR);
    	/** 供应商地址  */
        public FieldNode<Supplier, String> addr =  createFieldNode("addr","addr",String.class,JdbcType.VARCHAR);
    	/** 结算币种  */
        public FieldNode<Supplier, Integer> moneyType =  createFieldNode("moneyType","money_type",Integer.class,JdbcType.INTEGER);
    	/** 联系人  */
        public FieldNode<Supplier, String> contact =  createFieldNode("contact","contact",String.class,JdbcType.VARCHAR);
    	/** 联系人电话  */
        public FieldNode<Supplier, String> tel =  createFieldNode("tel","tel",String.class,JdbcType.VARCHAR);
    	/** 联系人邮箱  */
        public FieldNode<Supplier, String> email =  createFieldNode("email","email",String.class,JdbcType.VARCHAR);
    	/** 状态  */
        public FieldNode<Supplier, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<Supplier, Integer> type =  createFieldNode("type","type",Integer.class,JdbcType.INTEGER);
    	/** 建档时间  */
        public FieldNode<Supplier, Date> createDate =  createFieldNode("createDate","create_date",Date.class,JdbcType.DATE);
    	/** 建档人  */
        public FieldNode<Supplier, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 备注  */
        public FieldNode<Supplier, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 营业执照  */
        public FieldNode<Supplier, String> businessLicense =  createFieldNode("businessLicense","business_license",String.class,JdbcType.VARCHAR);
    	/** 环境  */
        public FieldNode<Supplier, String> env =  createFieldNode("env","env",String.class,JdbcType.VARCHAR);
    	/** 资质  */
        public FieldNode<Supplier, String> intelligence =  createFieldNode("intelligence","intelligence",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<Supplier, String> fax =  createFieldNode("fax","fax",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Supplier.class,"supplier",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Supplier> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Supplier>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}