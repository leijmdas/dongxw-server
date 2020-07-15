package com.kunlong.dongxw.data.domain;

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
 * VRmType VIEW
 * @author generator
 * @date 2020年05月31日
 */
@Table(VRmType.EntityNode.class)
public class VRmType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 
	  * nullable:true,length:11
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "")	
	private Integer id;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@Column(comment = "")	
	@NotNull
	private Byte active;
	/**
	  * 
	  * nullable:true,length:32
	  */
	@Column(comment = "")	
	private String code;
	/**
	  * 
	  * nullable:true,length:128
	  */
	@Column(comment = "")	
	private String name;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@Column(comment = "")	
	@NotNull
	private Integer parentId;
	/**
	  * 
	  * nullable:false,length:4
	  */
	@Column(comment = "")	
	@NotNull
	private Integer prdFlag;
	/**
	  * 
	  * nullable:true,length:255
	  */
	@Column(comment = "")	
	private String remark;
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
    public String getRemark(){
    	return this.remark;
    }
    public void setRemark(String remark){
    	this.remark = remark;
    }

    public static class EntityNode extends AbstractEntityNode<VRmType> {
        public static final EntityNode INSTANCE = new EntityNode("vrt");;
    	/**  */
        public FieldNode<VRmType, Integer> id =  createFieldNode("id","id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VRmType, Byte> active =  createFieldNode("active","active",Byte.class,JdbcType.TINYINT);
    	/**  */
        public FieldNode<VRmType, String> code =  createFieldNode("code","code",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<VRmType, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/**  */
        public FieldNode<VRmType, Integer> parentId =  createFieldNode("parentId","parent_id",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VRmType, Integer> prdFlag =  createFieldNode("prdFlag","prd_flag",Integer.class,JdbcType.INTEGER);
    	/**  */
        public FieldNode<VRmType, String> remark =  createFieldNode("remark","remark",String.class,JdbcType.VARCHAR);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(VRmType.class,"v_rm_type",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<VRmType> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<VRmType>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}