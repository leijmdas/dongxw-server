package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.Byte;
import java.lang.String;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * ProductType 
 * @author generator
 * @date 2020年01月22日
 */
@Table(ProductType.EntityNode.class)
public class ProductType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 主键
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "主键")	
	private Integer id;
	/**
	  * 有效标识
	  * nullable:false,length:4
	  */
	@Column(comment = "有效标识")	
	@NotNull
	private Byte active;
	/**
	  * 编码
	  * nullable:true,length:32
	  */
	@Column(comment = "编码")	
	private String code;
	/**
	  * 产品类型名称
	  * nullable:true,length:128
	  */
	@Column(comment = "产品类型名称")	
	private String name;
	/**
	  * 父类
	  * nullable:false,length:4
	  */
	@Column(comment = "父类")	
	@NotNull
	private Integer parentId;
	/**
	  * 0-成品100-半成品-200-原料
	  * nullable:false,length:4
	  */
	@Column(comment = "0-成品100-半成品-200-原料")	
	@NotNull
	private Integer prdFlag;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Byte getActive(){
    	return this.active;
    }
    public void setActive(Byte active){
    	this.active = active;
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
    public Integer getParentId(){
    	return this.parentId;
    }
    public void setParentId(Integer parentId){
    	this.parentId = parentId;
    }
    public Integer getPrdFlag(){
    	return this.prdFlag;
    }
    public void setPrdFlag(Integer prdFlag){
    	this.prdFlag = prdFlag;
    }

    public static class EntityNode extends AbstractEntityNode<ProductType> {
        public static final EntityNode INSTANCE = new EntityNode("pt");;
    	/** 主键 */
        public FieldNode<ProductType, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 有效标识 */
        public FieldNode<ProductType, Byte> active =  createFieldNode("active","active",Byte.class,JdbcType.TINYINT);
    	/** 编码 */
        public FieldNode<ProductType, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 产品类型名称 */
        public FieldNode<ProductType, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/** 父类 */
        public FieldNode<ProductType, Integer> parentId =  createFieldNode("parentId","parent_id",Integer.class,JdbcType.INTEGER);
    	/** 0-成品100-半成品-200-原料 */
        public FieldNode<ProductType, Integer> prdFlag =  createFieldNode("prdFlag","prd_flag",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(ProductType.class,"product_type",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<ProductType> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<ProductType>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}