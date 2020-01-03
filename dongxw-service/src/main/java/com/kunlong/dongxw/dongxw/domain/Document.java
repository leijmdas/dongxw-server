package com.kunlong.dongxw.dongxw.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.mybatis.hbatis.core.type.JdbcType;
import org.mybatis.hbatis.core.annotation.*;
import org.mybatis.hbatis.core.*;
import java.lang.Long;
import java.lang.String;
import java.lang.Short;
import java.lang.Byte;
import java.lang.Integer;
import java.util.Date;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;
/**
 * Document 模板资源表
 * @author generator
 * @date 2020年01月03日
 */
@Table(Document.EntityNode.class)
public class Document implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  * 资源标识 
	  * nullable:true,length:20
	  */
	@Column(primaryKey = true,autoIncrement = true,comment = "资源标识 ")	
	private Long id;
	/**
	  * 源文件名称 
	  * nullable:false,length:255
	  */
	@Column(comment = "源文件名称 ")	
	@NotNull
	private String name;
	/**
	  * 文件类型 
	  * nullable:false,length:6
	  */
	@Column(comment = "文件类型 ")	
	@NotNull
	private Short type;
	/**
	  * 保存方式 
	  * nullable:false,length:4
	  */
	@Column(comment = "保存方式 ")	
	@NotNull
	private Byte saveMode;
	/**
	  * 图片类型 
	  * nullable:false,length:20
	  */
	@Column(comment = "图片类型 ")	
	@NotNull
	private String picType;
	/**
	  * 路径 
	  * nullable:false,length:255
	  */
	@Column(comment = "路径 ")	
	@NotNull
	private String url;
	/**
	  * 二维码路径 
	  * nullable:false,length:256
	  */
	@Column(comment = "二维码路径 ")	
	@NotNull
	private String qrcode;
	/**
	  * 大小 
	  * nullable:false,length:11
	  */
	@Column(comment = "大小 ")	
	@NotNull
	private Integer size;
	/**
	  * 文档内容 
	  * nullable:false,length:65,535
	  */
	@Column(comment = "文档内容 ")	
	@NotNull
	private byte[] document;
	/**
	  * 保存时间 
	  * nullable:true,length:19
	  */
	@Column(comment = "保存时间 ")	
	private Date saveTime;
	/**
	  * 压缩标识 
	  * nullable:false,length:4
	  */
	@Column(comment = "压缩标识 ")	
	@NotNull
	private Byte compressFlag;
    public Long getId(){
    	return this.id;
    }
    public void setId(Long id){
    	this.id = id;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public Short getType(){
    	return this.type;
    }
    public void setType(Short type){
    	this.type = type;
    }
    public Byte getSaveMode(){
    	return this.saveMode;
    }
    public void setSaveMode(Byte saveMode){
    	this.saveMode = saveMode;
    }
    public String getPicType(){
    	return this.picType;
    }
    public void setPicType(String picType){
    	this.picType = picType;
    }
    public String getUrl(){
    	return this.url;
    }
    public void setUrl(String url){
    	this.url = url;
    }
    public String getQrcode(){
    	return this.qrcode;
    }
    public void setQrcode(String qrcode){
    	this.qrcode = qrcode;
    }
    public Integer getSize(){
    	return this.size;
    }
    public void setSize(Integer size){
    	this.size = size;
    }
    public byte[] getDocument(){
    	return this.document;
    }
    public void setDocument(byte[] document){
    	this.document = document;
    }
    public Date getSaveTime(){
    	return this.saveTime;
    }
    public void setSaveTime(Date saveTime){
    	this.saveTime = saveTime;
    }
    public Byte getCompressFlag(){
    	return this.compressFlag;
    }
    public void setCompressFlag(Byte compressFlag){
    	this.compressFlag = compressFlag;
    }

    public static class EntityNode extends AbstractEntityNode<Document> {
        public static final EntityNode INSTANCE = new EntityNode("dd");;
    	/** 资源标识  */
        public FieldNode<Document, Long> id =  createFieldNode("id","id",Long.class,JdbcType.BIGINT);
    	/** 源文件名称  */
        public FieldNode<Document, String> name =  createFieldNode("name","name",String.class,JdbcType.VARCHAR);
    	/** 文件类型  */
        public FieldNode<Document, Short> type =  createFieldNode("type","type",Short.class,JdbcType.SMALLINT);
    	/** 保存方式  */
        public FieldNode<Document, Byte> saveMode =  createFieldNode("saveMode","save_mode",Byte.class,JdbcType.TINYINT);
    	/** 图片类型  */
        public FieldNode<Document, String> picType =  createFieldNode("picType","pic_type",String.class,JdbcType.VARCHAR);
    	/** 路径  */
        public FieldNode<Document, String> url =  createFieldNode("url","url",String.class,JdbcType.VARCHAR);
    	/** 二维码路径  */
        public FieldNode<Document, String> qrcode =  createFieldNode("qrcode","qrcode",String.class,JdbcType.VARCHAR);
    	/** 大小  */
        public FieldNode<Document, Integer> size =  createFieldNode("size","size",Integer.class,JdbcType.INTEGER);
    	/** 保存时间  */
        public FieldNode<Document, Date> saveTime =  createFieldNode("saveTime","save_time",Date.class,JdbcType.TIMESTAMP);
    	/** 压缩标识  */
        public FieldNode<Document, Byte> compressFlag =  createFieldNode("compressFlag","compress_flag",Byte.class,JdbcType.TINYINT);
	
        /**
         * @param alias 别名
         */
        public EntityNode(String alias) {
            super(Document.class,"dxw_document",alias);
        }
    }
    
    //-- 实体参数(允许新增属性) 
	public static class QueryParam extends AbstractQueryParam<Document> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<Document>(EntityNode.INSTANCE));
		}
	}
	
	public static enum ValueField {
	}
    // ==== 自定义属性 ====
}