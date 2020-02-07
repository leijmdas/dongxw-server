package com.kunlong.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductModel implements Serializable {
    private Integer id;

    private String epCode;

    private String code;

    private String remark;

    private Integer parentId;

    private Integer productTypeId;

    private String picUrl;

    private String barCode;

    private String color;

    private String unit;

    private String size;

    private String upcA;

    private Integer status;

    private String memo;

    private Date createDate;

    private Integer createBy;

    private Integer customerId;

    private String imgUrls;

    private Integer ibQty;

    private BigDecimal ibGw;

    private BigDecimal ibNw;

    private String ibSize;

    private Integer obQty;

    private BigDecimal obGw;

    private BigDecimal obNw;

    private String obSize;

    private String pkgFront;

    private String pkgSide;

    private String pkgRemark;

    private String imgRemark;

    private String name;

    private String pkgSideImgRemark;

    private String pkgFrontImgUrls;

    private String pkgSideImgUrls;

    private String pkgFrontImgRemark;

    private Short prdFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public ProductModel withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEpCode() {
        return epCode;
    }

    public ProductModel withEpCode(String epCode) {
        this.setEpCode(epCode);
        return this;
    }

    public void setEpCode(String epCode) {
        this.epCode = epCode == null ? null : epCode.trim();
    }

    public String getCode() {
        return code;
    }

    public ProductModel withCode(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRemark() {
        return remark;
    }

    public ProductModel withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public ProductModel withParentId(Integer parentId) {
        this.setParentId(parentId);
        return this;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public ProductModel withProductTypeId(Integer productTypeId) {
        this.setProductTypeId(productTypeId);
        return this;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public ProductModel withPicUrl(String picUrl) {
        this.setPicUrl(picUrl);
        return this;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public ProductModel withBarCode(String barCode) {
        this.setBarCode(barCode);
        return this;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getColor() {
        return color;
    }

    public ProductModel withColor(String color) {
        this.setColor(color);
        return this;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getUnit() {
        return unit;
    }

    public ProductModel withUnit(String unit) {
        this.setUnit(unit);
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSize() {
        return size;
    }

    public ProductModel withSize(String size) {
        this.setSize(size);
        return this;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getUpcA() {
        return upcA;
    }

    public ProductModel withUpcA(String upcA) {
        this.setUpcA(upcA);
        return this;
    }

    public void setUpcA(String upcA) {
        this.upcA = upcA == null ? null : upcA.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public ProductModel withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public ProductModel withMemo(String memo) {
        this.setMemo(memo);
        return this;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public ProductModel withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public ProductModel withCreateBy(Integer createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public ProductModel withCustomerId(Integer customerId) {
        this.setCustomerId(customerId);
        return this;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public ProductModel withImgUrls(String imgUrls) {
        this.setImgUrls(imgUrls);
        return this;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls == null ? null : imgUrls.trim();
    }

    public Integer getIbQty() {
        return ibQty;
    }

    public ProductModel withIbQty(Integer ibQty) {
        this.setIbQty(ibQty);
        return this;
    }

    public void setIbQty(Integer ibQty) {
        this.ibQty = ibQty;
    }

    public BigDecimal getIbGw() {
        return ibGw;
    }

    public ProductModel withIbGw(BigDecimal ibGw) {
        this.setIbGw(ibGw);
        return this;
    }

    public void setIbGw(BigDecimal ibGw) {
        this.ibGw = ibGw;
    }

    public BigDecimal getIbNw() {
        return ibNw;
    }

    public ProductModel withIbNw(BigDecimal ibNw) {
        this.setIbNw(ibNw);
        return this;
    }

    public void setIbNw(BigDecimal ibNw) {
        this.ibNw = ibNw;
    }

    public String getIbSize() {
        return ibSize;
    }

    public ProductModel withIbSize(String ibSize) {
        this.setIbSize(ibSize);
        return this;
    }

    public void setIbSize(String ibSize) {
        this.ibSize = ibSize == null ? null : ibSize.trim();
    }

    public Integer getObQty() {
        return obQty;
    }

    public ProductModel withObQty(Integer obQty) {
        this.setObQty(obQty);
        return this;
    }

    public void setObQty(Integer obQty) {
        this.obQty = obQty;
    }

    public BigDecimal getObGw() {
        return obGw;
    }

    public ProductModel withObGw(BigDecimal obGw) {
        this.setObGw(obGw);
        return this;
    }

    public void setObGw(BigDecimal obGw) {
        this.obGw = obGw;
    }

    public BigDecimal getObNw() {
        return obNw;
    }

    public ProductModel withObNw(BigDecimal obNw) {
        this.setObNw(obNw);
        return this;
    }

    public void setObNw(BigDecimal obNw) {
        this.obNw = obNw;
    }

    public String getObSize() {
        return obSize;
    }

    public ProductModel withObSize(String obSize) {
        this.setObSize(obSize);
        return this;
    }

    public void setObSize(String obSize) {
        this.obSize = obSize == null ? null : obSize.trim();
    }

    public String getPkgFront() {
        return pkgFront;
    }

    public ProductModel withPkgFront(String pkgFront) {
        this.setPkgFront(pkgFront);
        return this;
    }

    public void setPkgFront(String pkgFront) {
        this.pkgFront = pkgFront == null ? null : pkgFront.trim();
    }

    public String getPkgSide() {
        return pkgSide;
    }

    public ProductModel withPkgSide(String pkgSide) {
        this.setPkgSide(pkgSide);
        return this;
    }

    public void setPkgSide(String pkgSide) {
        this.pkgSide = pkgSide == null ? null : pkgSide.trim();
    }

    public String getPkgRemark() {
        return pkgRemark;
    }

    public ProductModel withPkgRemark(String pkgRemark) {
        this.setPkgRemark(pkgRemark);
        return this;
    }

    public void setPkgRemark(String pkgRemark) {
        this.pkgRemark = pkgRemark == null ? null : pkgRemark.trim();
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public ProductModel withImgRemark(String imgRemark) {
        this.setImgRemark(imgRemark);
        return this;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark == null ? null : imgRemark.trim();
    }

    public String getName() {
        return name;
    }

    public ProductModel withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPkgSideImgRemark() {
        return pkgSideImgRemark;
    }

    public ProductModel withPkgSideImgRemark(String pkgSideImgRemark) {
        this.setPkgSideImgRemark(pkgSideImgRemark);
        return this;
    }

    public void setPkgSideImgRemark(String pkgSideImgRemark) {
        this.pkgSideImgRemark = pkgSideImgRemark == null ? null : pkgSideImgRemark.trim();
    }

    public String getPkgFrontImgUrls() {
        return pkgFrontImgUrls;
    }

    public ProductModel withPkgFrontImgUrls(String pkgFrontImgUrls) {
        this.setPkgFrontImgUrls(pkgFrontImgUrls);
        return this;
    }

    public void setPkgFrontImgUrls(String pkgFrontImgUrls) {
        this.pkgFrontImgUrls = pkgFrontImgUrls == null ? null : pkgFrontImgUrls.trim();
    }

    public String getPkgSideImgUrls() {
        return pkgSideImgUrls;
    }

    public ProductModel withPkgSideImgUrls(String pkgSideImgUrls) {
        this.setPkgSideImgUrls(pkgSideImgUrls);
        return this;
    }

    public void setPkgSideImgUrls(String pkgSideImgUrls) {
        this.pkgSideImgUrls = pkgSideImgUrls == null ? null : pkgSideImgUrls.trim();
    }

    public String getPkgFrontImgRemark() {
        return pkgFrontImgRemark;
    }

    public ProductModel withPkgFrontImgRemark(String pkgFrontImgRemark) {
        this.setPkgFrontImgRemark(pkgFrontImgRemark);
        return this;
    }

    public void setPkgFrontImgRemark(String pkgFrontImgRemark) {
        this.pkgFrontImgRemark = pkgFrontImgRemark == null ? null : pkgFrontImgRemark.trim();
    }

    public Short getPrdFlag() {
        return prdFlag;
    }

    public ProductModel withPrdFlag(Short prdFlag) {
        this.setPrdFlag(prdFlag);
        return this;
    }

    public void setPrdFlag(Short prdFlag) {
        this.prdFlag = prdFlag;
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
        ProductModel other = (ProductModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEpCode() == null ? other.getEpCode() == null : this.getEpCode().equals(other.getEpCode()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getProductTypeId() == null ? other.getProductTypeId() == null : this.getProductTypeId().equals(other.getProductTypeId()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getBarCode() == null ? other.getBarCode() == null : this.getBarCode().equals(other.getBarCode()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getUpcA() == null ? other.getUpcA() == null : this.getUpcA().equals(other.getUpcA()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getImgUrls() == null ? other.getImgUrls() == null : this.getImgUrls().equals(other.getImgUrls()))
            && (this.getIbQty() == null ? other.getIbQty() == null : this.getIbQty().equals(other.getIbQty()))
            && (this.getIbGw() == null ? other.getIbGw() == null : this.getIbGw().equals(other.getIbGw()))
            && (this.getIbNw() == null ? other.getIbNw() == null : this.getIbNw().equals(other.getIbNw()))
            && (this.getIbSize() == null ? other.getIbSize() == null : this.getIbSize().equals(other.getIbSize()))
            && (this.getObQty() == null ? other.getObQty() == null : this.getObQty().equals(other.getObQty()))
            && (this.getObGw() == null ? other.getObGw() == null : this.getObGw().equals(other.getObGw()))
            && (this.getObNw() == null ? other.getObNw() == null : this.getObNw().equals(other.getObNw()))
            && (this.getObSize() == null ? other.getObSize() == null : this.getObSize().equals(other.getObSize()))
            && (this.getPkgFront() == null ? other.getPkgFront() == null : this.getPkgFront().equals(other.getPkgFront()))
            && (this.getPkgSide() == null ? other.getPkgSide() == null : this.getPkgSide().equals(other.getPkgSide()))
            && (this.getPkgRemark() == null ? other.getPkgRemark() == null : this.getPkgRemark().equals(other.getPkgRemark()))
            && (this.getImgRemark() == null ? other.getImgRemark() == null : this.getImgRemark().equals(other.getImgRemark()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPkgSideImgRemark() == null ? other.getPkgSideImgRemark() == null : this.getPkgSideImgRemark().equals(other.getPkgSideImgRemark()))
            && (this.getPkgFrontImgUrls() == null ? other.getPkgFrontImgUrls() == null : this.getPkgFrontImgUrls().equals(other.getPkgFrontImgUrls()))
            && (this.getPkgSideImgUrls() == null ? other.getPkgSideImgUrls() == null : this.getPkgSideImgUrls().equals(other.getPkgSideImgUrls()))
            && (this.getPkgFrontImgRemark() == null ? other.getPkgFrontImgRemark() == null : this.getPkgFrontImgRemark().equals(other.getPkgFrontImgRemark()))
            && (this.getPrdFlag() == null ? other.getPrdFlag() == null : this.getPrdFlag().equals(other.getPrdFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEpCode() == null) ? 0 : getEpCode().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getProductTypeId() == null) ? 0 : getProductTypeId().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getBarCode() == null) ? 0 : getBarCode().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getUpcA() == null) ? 0 : getUpcA().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getImgUrls() == null) ? 0 : getImgUrls().hashCode());
        result = prime * result + ((getIbQty() == null) ? 0 : getIbQty().hashCode());
        result = prime * result + ((getIbGw() == null) ? 0 : getIbGw().hashCode());
        result = prime * result + ((getIbNw() == null) ? 0 : getIbNw().hashCode());
        result = prime * result + ((getIbSize() == null) ? 0 : getIbSize().hashCode());
        result = prime * result + ((getObQty() == null) ? 0 : getObQty().hashCode());
        result = prime * result + ((getObGw() == null) ? 0 : getObGw().hashCode());
        result = prime * result + ((getObNw() == null) ? 0 : getObNw().hashCode());
        result = prime * result + ((getObSize() == null) ? 0 : getObSize().hashCode());
        result = prime * result + ((getPkgFront() == null) ? 0 : getPkgFront().hashCode());
        result = prime * result + ((getPkgSide() == null) ? 0 : getPkgSide().hashCode());
        result = prime * result + ((getPkgRemark() == null) ? 0 : getPkgRemark().hashCode());
        result = prime * result + ((getImgRemark() == null) ? 0 : getImgRemark().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPkgSideImgRemark() == null) ? 0 : getPkgSideImgRemark().hashCode());
        result = prime * result + ((getPkgFrontImgUrls() == null) ? 0 : getPkgFrontImgUrls().hashCode());
        result = prime * result + ((getPkgSideImgUrls() == null) ? 0 : getPkgSideImgUrls().hashCode());
        result = prime * result + ((getPkgFrontImgRemark() == null) ? 0 : getPkgFrontImgRemark().hashCode());
        result = prime * result + ((getPrdFlag() == null) ? 0 : getPrdFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", epCode=").append(epCode);
        sb.append(", code=").append(code);
        sb.append(", remark=").append(remark);
        sb.append(", parentId=").append(parentId);
        sb.append(", productTypeId=").append(productTypeId);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", barCode=").append(barCode);
        sb.append(", color=").append(color);
        sb.append(", unit=").append(unit);
        sb.append(", size=").append(size);
        sb.append(", upcA=").append(upcA);
        sb.append(", status=").append(status);
        sb.append(", memo=").append(memo);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", customerId=").append(customerId);
        sb.append(", imgUrls=").append(imgUrls);
        sb.append(", ibQty=").append(ibQty);
        sb.append(", ibGw=").append(ibGw);
        sb.append(", ibNw=").append(ibNw);
        sb.append(", ibSize=").append(ibSize);
        sb.append(", obQty=").append(obQty);
        sb.append(", obGw=").append(obGw);
        sb.append(", obNw=").append(obNw);
        sb.append(", obSize=").append(obSize);
        sb.append(", pkgFront=").append(pkgFront);
        sb.append(", pkgSide=").append(pkgSide);
        sb.append(", pkgRemark=").append(pkgRemark);
        sb.append(", imgRemark=").append(imgRemark);
        sb.append(", name=").append(name);
        sb.append(", pkgSideImgRemark=").append(pkgSideImgRemark);
        sb.append(", pkgFrontImgUrls=").append(pkgFrontImgUrls);
        sb.append(", pkgSideImgUrls=").append(pkgSideImgUrls);
        sb.append(", pkgFrontImgRemark=").append(pkgFrontImgRemark);
        sb.append(", prdFlag=").append(prdFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}