package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * Product 产品
 * @author generator
 * @date 2019年12月29日
 */
@Table(Product.EntityNode.class)
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * EP款号 
	  * nullable:false,length:32
	  */
	@Column(comment = "EP款号 ")	
	@NotNull
	private String epCode;
	/**
	  * 编码
	  * nullable:false,length:32
	  */
	@Column(comment = "编码")	
	@NotNull
	private String code;
	/**
	  * 描述 
	  * nullable:false,length:128
	  */
	@Column(comment = "描述 ")	
	@NotNull
	private String remark;
	/**
	  * 产品类型 
	  * nullable:false,length:11
	  */
	@Column(comment = "产品类型 ")	
	@NotNull
	private Integer productTypeId;
	/**
	  * 图片 
	  * nullable:false,length:128
	  */
	@Column(comment = "图片 ")	
	@NotNull
	private String picUrl;
	/**
	  * 条码 
	  * nullable:false,length:4
	  */
	@Column(comment = "条码 ")	
	@NotNull
	private String barCode;
	/**
	  * UPC-A 
	  * nullable:false,length:32
	  */
	@Column(comment = "UPC-A ")	
	@NotNull
	private String upcA;
	/**
	  * 颜色 
	  * nullable:false,length:16
	  */
	@Column(comment = "颜色 ")	
	@NotNull
	private String color;
	/**
	  * 尺寸 
	  * nullable:false,length:24
	  */
	@Column(comment = "尺寸 ")	
	@NotNull
	private String size;
	/**
	  * 状态 1-使用 0-停用
	  * nullable:false,length:11
	  */
	@Column(comment = "状态 1-使用 0-停用")	
	@NotNull
	private Integer status;
	/**
	  * 备注 
	  * nullable:false,length:128
	  */
	@Column(comment = "备注 ")	
	@NotNull
	private String memo;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getEpCode(){
    	return this.epCode;
    }
    public void setEpCode(String epCode){
    	this.epCode = epCode;
    }
    public String getCode(){
    	return this.code;
    }
    public void setCode(String code){
    	this.code = code;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Integer getProductTypeId(){
    	return this.productTypeId;
    }
    public void setProductTypeId(Integer productTypeId){
    	this.productTypeId = productTypeId;
    }
    public String getPicUrl(){
    	return this.picUrl;
    }
    public void setPicUrl(String picUrl){
    	this.picUrl = picUrl;
    }
    public String getBarCode(){
    	return this.barCode;
    }
    public void setBarCode(String barCode){
    	this.barCode = barCode;
    }
    public String getUpcA(){
    	return this.upcA;
    }
    public void setUpcA(String upcA){
    	this.upcA = upcA;
    }
    public String getColor(){
    	return this.color;
    }
    public void setColor(String color){
    	this.color = color;
    }
    public String getSize(){
    	return this.size;
    }
    public void setSize(String size){
    	this.size = size;
    }
    public Integer getStatus(){
    	return this.status;
    }
    public void setStatus(Integer status){
    	this.status = status;
    }
    public String getMemo(){
    	return this.memo;
    }
    public void setMemo(String memo){
    	this.memo = memo;
    }

    public static class EntityNode extends AbstractEntityNode<Product> {
        public static final EntityNode INSTANCE = new EntityNode("p");;
    	/** 主键 */
        public FieldNode<Product, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** EP款号  */
        public FieldNode<Product, String> epCode =  createFieldNode("epCode","ep_code",String.class,JdbcType.VARCHAR);
    	/** 编码 */
        public FieldNode<Product, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 描述  */
        public FieldNode<Product, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 产品类型  */
        public FieldNode<Product, Integer> productTypeId =  createFieldNode("productTypeId","product_type_id",Integer.class,JdbcType.INTEGER);
    	/** 图片  */
        public FieldNode<Product, String> picUrl =  createFieldNode("picUrl","pic_url",String.class,JdbcType.VARCHAR);
    	/** 条码  */
        public FieldNode<Product, String> barCode =  createFieldNode("barCode","bar_code",String.class,JdbcType.VARCHAR);
    	/** UPC-A  */
        public FieldNode<Product, String> upcA =  createFieldNode("upcA","upc_a",String.class,JdbcType.VARCHAR);
    	/** 颜色  */
        public FieldNode<Product, String> color =  createFieldNode("color","color",String.class,JdbcType.VARCHAR);
    	/** 尺寸  */
        public FieldNode<Product, String> size =  createFieldNode("size","size",String.class,JdbcType.VARCHAR);
    	/** 状态 1-使用 0-停用 */
        public FieldNode<Product, Integer> status =  createFieldNode("status","status",Integer.class,JdbcType.INTEGER);
    	/** 备注  */
        public FieldNode<Product, String> memo =  createFieldNode("memo","memo",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Product.class,"product",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Product> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Product>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ==== 
	ProductType  productType ;
	public ProductType getProductType () {
		return productType;
	}

	public void setProductType (ProductType productType) {
		this.productType = productType;
	}

}