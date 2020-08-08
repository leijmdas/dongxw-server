package com.kunlong.dongxw.data.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.Boolean;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * SelfMonthClose 成品与材料库月结表
 * @author generator
 * @date 2020年08月08日
 */
@Table(SelfMonthClose.EntityNode.class)
public class SelfMonthClose implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 序号标识 int(11)
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "序号标识 int(11)")	
	private Integer id;
	/**
	  * 年月 varchar(32)
	  * nullable:false,length:11
	  */
	@Column(comment = "年月 varchar(32)")	
	@NotNull
	private Integer ym;
	/**
	  * 月结标志 r
	  * nullable:false,length:1
	  */
	@Column(comment = "月结标志 r")	
	@NotNull
	private Boolean closeFlag;
    public Integer getId(){
    	return this.id;
    }
    public void setId(Integer id){
    	this.id = id;
    }
    public Integer getYm(){
    	return this.ym;
    }
    public void setYm(Integer ym){
    	this.ym = ym;
    }
    public Boolean getCloseFlag(){
    	return this.closeFlag;
    }
    public void setCloseFlag(Boolean closeFlag){
    	this.closeFlag = closeFlag;
    }

    public static class EntityNode extends AbstractEntityNode<SelfMonthClose> {
        public static final EntityNode INSTANCE = new EntityNode("smc");;
    	/** 序号标识 int(11) */
        public FieldNode<SelfMonthClose, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/** 年月 varchar(32) */
        public FieldNode<SelfMonthClose, Integer> ym =  createFieldNode("ym","ym",Integer.class,JdbcType.INTEGER);
    	/** 月结标志 r */
        public FieldNode<SelfMonthClose, Boolean> closeFlag =  createFieldNode("closeFlag","close_flag",Boolean.class,JdbcType.BIT);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(SelfMonthClose.class,"self_month_close",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<SelfMonthClose> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<SelfMonthClose>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}