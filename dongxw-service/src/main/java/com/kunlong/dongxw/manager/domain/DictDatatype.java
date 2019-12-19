package com.kunlong.dongxw.manager.domain;

import java.io.Serializable;
import javax.validation.constraints.*;

import com.kunlong.platform.model.KunlongModel;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * DictDatatype 数据字典
 * @author generator
 * @date 2019年12月19日
 */
@Table(DictDatatype.EntityNode.class)
public class DictDatatype extends KunlongModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 字典ID
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "字典ID")	
	private Integer dataInnerId;
	/**
	  * 分类编号
	  * nullable:true,length:11
	  */
	@Column(comment = "分类编号")	
	private Integer typeId;
	/**
	  * 分类名称
	  * nullable:true,length:32
	  */
	@Column(comment = "分类名称")	
	private String typeName;
	/**
	  * 字典编号
	  * nullable:true,length:11
	  */
	@Column(comment = "字典编号")	
	private Integer dataId;
	/**
	  * 字典名称
	  * nullable:true,length:32
	  */
	@Column(comment = "字典名称")	
	private String dataName;
	/**
	  * 备注
	  * nullable:true,length:64
	  */
	@Column(comment = "备注")	
	private String remark;
	/**
	  * 创建人
	  * nullable:true,length:11
	  */
	@Column(comment = "创建人")	
	private Integer createBy;
	/**
	  * 创建时间
	  * nullable:false,length:19
	  */
	@Column(comment = "创建时间")	
	@NotNull
	private Date createTime;
    public Integer getDataInnerId(){
    	return this.dataInnerId;
    }
    public void setDataInnerId(Integer dataInnerId){
    	this.dataInnerId = dataInnerId;
    }
    public Integer getTypeId(){
    	return this.typeId;
    }
    public void setTypeId(Integer typeId){
    	this.typeId = typeId;
    }
    public String getTypeName(){
    	return this.typeName;
    }
    public void setTypeName(String typeName){
    	this.typeName = typeName;
    }
    public Integer getDataId(){
    	return this.dataId;
    }
    public void setDataId(Integer dataId){
    	this.dataId = dataId;
    }
    public String getDataName(){
    	return this.dataName;
    }
    public void setDataName(String dataName){
    	this.dataName = dataName;
    }
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }
    public Integer getCreateBy(){
    	return this.createBy;
    }
    public void setCreateBy(Integer createBy){
    	this.createBy = createBy;
    }
    public Date getCreateTime(){
    	return this.createTime;
    }
    public void setCreateTime(Date createTime){
    	this.createTime = createTime;
    }

    public static class EntityNode extends AbstractEntityNode<DictDatatype> {
        public static final EntityNode INSTANCE = new EntityNode("dd");;
    	/** 字典ID */
        public FieldNode<DictDatatype, Integer> dataInnerId =  createFieldNode("dataInnerId","data_inner_id",Integer.class,JdbcType.INTEGER);
    	/** 分类编号 */
        public FieldNode<DictDatatype, Integer> typeId =  createFieldNode("typeId","type_id",Integer.class,JdbcType.INTEGER);
    	/** 分类名称 */
        public FieldNode<DictDatatype, String> typeName =  createFieldNode("typeName","type_name",String.class,JdbcType.VARCHAR);
    	/** 字典编号 */
        public FieldNode<DictDatatype, Integer> dataId =  createFieldNode("dataId","data_id",Integer.class,JdbcType.INTEGER);
    	/** 字典名称 */
        public FieldNode<DictDatatype, String> dataName =  createFieldNode("dataName","data_name",String.class,JdbcType.VARCHAR);
    	/** 备注 */
        public FieldNode<DictDatatype, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
    	/** 创建人 */
        public FieldNode<DictDatatype, Integer> createBy =  createFieldNode("createBy","create_by",Integer.class,JdbcType.INTEGER);
    	/** 创建时间 */
        public FieldNode<DictDatatype, Date> createTime =  createFieldNode("createTime","create_time",Date.class,JdbcType.TIMESTAMP);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(DictDatatype.class,"dict_datatype",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<DictDatatype> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<DictDatatype>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}