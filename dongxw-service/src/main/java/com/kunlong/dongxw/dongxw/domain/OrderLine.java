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
 * OrderLine 
 * @author generator
 * @date 2019年12月29日
 */
@Table(OrderLine.EntityNode.class)
public class OrderLine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * id 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "id ")	
	private Integer id;
	/**
	  * A 
	  * nullable:false,length:4
	  */
	@Column(comment = "A ")	
	@NotNull
	private String a;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public String getA(){
    	return this.a;
    }
    public void setA(String a){
    	this.a = a;
    }

    public static class EntityNode extends AbstractEntityNode<OrderLine> {
        public static final EntityNode INSTANCE = new EntityNode("ol");;
    	/** id  */
        public FieldNode<OrderLine, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** A  */
        public FieldNode<OrderLine, String> a =  createFieldNode("a","A",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(OrderLine.class,"order_line",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<OrderLine> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<OrderLine>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}