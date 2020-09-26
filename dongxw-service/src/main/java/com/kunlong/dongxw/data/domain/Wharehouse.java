package com.kunlong.dongxw.data.domain;

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
 * Wharehouse 仓库
 * @author generator
 * @date 2020年09月22日
 */
@Table(Wharehouse.EntityNode.class)
public class Wharehouse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 序号标识 int(11)
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "序号标识 int(11)")	
	private Integer id;
	/**
	  * 编号 varchar(32)
	  * nullable:false,length:64
	  */
	@Column(comment = "编号 varchar(32)")	
	@NotNull
	private String code;
	/**
	  * 仓库名称 r
	  * nullable:false,length:128
	  */
	@Column(comment = "仓库名称 r")	
	@NotNull
	private String name;
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

    public static class EntityNode extends AbstractEntityNode<Wharehouse> {
        public static final EntityNode INSTANCE = new EntityNode("w");;
    	/** 序号标识 int(11) */
        public FieldNode<Wharehouse, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 编号 varchar(32) */
        public FieldNode<Wharehouse, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/** 仓库名称 r */
        public FieldNode<Wharehouse, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Wharehouse.class,"wharehouse",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Wharehouse> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Wharehouse>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}