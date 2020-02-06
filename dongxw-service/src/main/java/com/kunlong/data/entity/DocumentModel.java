package com.kunlong.data.entity;

import java.io.Serializable;
import java.util.Date;

public class DocumentModel implements Serializable {
    private Long id;

    private String name;

    private Short type;

    private Byte saveMode;

    private String picType;

    private String url;

    private String qrcode;

    private Integer size;

    private Date createDate;

    private Integer createBy;

    private Byte compressFlag;

    private Byte isDeleted;

    private String document;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public DocumentModel withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public DocumentModel withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getType() {
        return type;
    }

    public DocumentModel withType(Short type) {
        this.setType(type);
        return this;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Byte getSaveMode() {
        return saveMode;
    }

    public DocumentModel withSaveMode(Byte saveMode) {
        this.setSaveMode(saveMode);
        return this;
    }

    public void setSaveMode(Byte saveMode) {
        this.saveMode = saveMode;
    }

    public String getPicType() {
        return picType;
    }

    public DocumentModel withPicType(String picType) {
        this.setPicType(picType);
        return this;
    }

    public void setPicType(String picType) {
        this.picType = picType == null ? null : picType.trim();
    }

    public String getUrl() {
        return url;
    }

    public DocumentModel withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public DocumentModel withQrcode(String qrcode) {
        this.setQrcode(qrcode);
        return this;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public Integer getSize() {
        return size;
    }

    public DocumentModel withSize(Integer size) {
        this.setSize(size);
        return this;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public DocumentModel withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public DocumentModel withCreateBy(Integer createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Byte getCompressFlag() {
        return compressFlag;
    }

    public DocumentModel withCompressFlag(Byte compressFlag) {
        this.setCompressFlag(compressFlag);
        return this;
    }

    public void setCompressFlag(Byte compressFlag) {
        this.compressFlag = compressFlag;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public DocumentModel withIsDeleted(Byte isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDocument() {
        return document;
    }

    public DocumentModel withDocument(String document) {
        this.setDocument(document);
        return this;
    }

    public void setDocument(String document) {
        this.document = document == null ? null : document.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DocumentModel other = (DocumentModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSaveMode() == null ? other.getSaveMode() == null : this.getSaveMode().equals(other.getSaveMode()))
            && (this.getPicType() == null ? other.getPicType() == null : this.getPicType().equals(other.getPicType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getQrcode() == null ? other.getQrcode() == null : this.getQrcode().equals(other.getQrcode()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCompressFlag() == null ? other.getCompressFlag() == null : this.getCompressFlag().equals(other.getCompressFlag()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getDocument() == null ? other.getDocument() == null : this.getDocument().equals(other.getDocument()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSaveMode() == null) ? 0 : getSaveMode().hashCode());
        result = prime * result + ((getPicType() == null) ? 0 : getPicType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getQrcode() == null) ? 0 : getQrcode().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCompressFlag() == null) ? 0 : getCompressFlag().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getDocument() == null) ? 0 : getDocument().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", saveMode=").append(saveMode);
        sb.append(", picType=").append(picType);
        sb.append(", url=").append(url);
        sb.append(", qrcode=").append(qrcode);
        sb.append(", size=").append(size);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", compressFlag=").append(compressFlag);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", document=").append(document);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}