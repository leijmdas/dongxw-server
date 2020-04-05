package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * PoDaySeq 采购单序号表
 * @author generator
 * @date 2020年04月05日
 */
@Table(PoDaySeq.EntityNode.class)
public class PoDaySeq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 序号标识 int(11)
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "序号标识 int(11)")	
	private Integer id;
	/**
	  * 年月日 varchar(32)
	  * nullable:false,length:11
	  */
	@Column(comment = "年月日 varchar(32)")	
	@NotNull
	private Integer ymd;
	/**
	  * 采购单序号 r
	  * nullable:false,length:11
	  */
	@Column(comment = "采购单序号 r")	
	@NotNull
	private Integer poSeq;
	/**
	  * 外发单序号 r
	  * nullable:false,length:11
	  */
	@Column(comment = "外发单序号 r")	
	@NotNull
	private Integer outSeq;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getYmd(){
    	return this.ymd;
    }
    public void setYmd(Integer ymd){
    	this.ymd = ymd;
    }
    public Integer getPoSeq(){
    	return this.poSeq;
    }
    public void setPoSeq(Integer poSeq){
    	this.poSeq = poSeq;
    }
    public Integer getOutSeq(){
    	return this.outSeq;
    }
    public void setOutSeq(Integer outSeq){
    	this.outSeq = outSeq;
    }

    public static class EntityNode extends AbstractEntityNode<PoDaySeq> {
        public static final EntityNode INSTANCE = new EntityNode("pds");;
    	/** 序号标识 int(11) */
        public FieldNode<PoDaySeq, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 年月日 varchar(32) */
        public FieldNode<PoDaySeq, Integer> ymd =  createFieldNode("ymd","ymd",Integer.class,JdbcType.INTEGER);
    	/** 采购单序号 r */
        public FieldNode<PoDaySeq, Integer> poSeq =  createFieldNode("poSeq","po_seq",Integer.class,JdbcType.INTEGER);
    	/** 外发单序号 r */
        public FieldNode<PoDaySeq, Integer> outSeq =  createFieldNode("outSeq","out_seq",Integer.class,JdbcType.INTEGER);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(PoDaySeq.class,"po_day_seq",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<PoDaySeq> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<PoDaySeq>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}