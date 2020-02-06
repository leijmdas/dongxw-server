package com.kunlong.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BomModel implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer parentId;

    private Integer bigType;

    private Integer smallType;

    private Integer childId;

    private String unit;

    private BigDecimal qty;

    private BigDecimal price;

    private BigDecimal money;

    private Integer lossType;

    private Short lossQty;

    private BigDecimal sizeL;

    private String sizeX;

    private BigDecimal sizeW;

    private Integer length;

    private Integer width;

    private Short knifeQty;

    private Short depth;

    private Byte source;

    private Integer createBy;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public BomModel withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public BomModel withProductId(Integer productId) {
        this.setProductId(productId);
        return this;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public BomModel withParentId(Integer parentId) {
        this.setParentId(parentId);
        return this;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getBigType() {
        return bigType;
    }

    public BomModel withBigType(Integer bigType) {
        this.setBigType(bigType);
        return this;
    }

    public void setBigType(Integer bigType) {
        this.bigType = bigType;
    }

    public Integer getSmallType() {
        return smallType;
    }

    public BomModel withSmallType(Integer smallType) {
        this.setSmallType(smallType);
        return this;
    }

    public void setSmallType(Integer smallType) {
        this.smallType = smallType;
    }

    public Integer getChildId() {
        return childId;
    }

    public BomModel withChildId(Integer childId) {
        this.setChildId(childId);
        return this;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getUnit() {
        return unit;
    }

    public BomModel withUnit(String unit) {
        this.setUnit(unit);
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public BomModel withQty(BigDecimal qty) {
        this.setQty(qty);
        return this;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BomModel withPrice(BigDecimal price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public BomModel withMoney(BigDecimal money) {
        this.setMoney(money);
        return this;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getLossType() {
        return lossType;
    }

    public BomModel withLossType(Integer lossType) {
        this.setLossType(lossType);
        return this;
    }

    public void setLossType(Integer lossType) {
        this.lossType = lossType;
    }

    public Short getLossQty() {
        return lossQty;
    }

    public BomModel withLossQty(Short lossQty) {
        this.setLossQty(lossQty);
        return this;
    }

    public void setLossQty(Short lossQty) {
        this.lossQty = lossQty;
    }

    public BigDecimal getSizeL() {
        return sizeL;
    }

    public BomModel withSizeL(BigDecimal sizeL) {
        this.setSizeL(sizeL);
        return this;
    }

    public void setSizeL(BigDecimal sizeL) {
        this.sizeL = sizeL;
    }

    public String getSizeX() {
        return sizeX;
    }

    public BomModel withSizeX(String sizeX) {
        this.setSizeX(sizeX);
        return this;
    }

    public void setSizeX(String sizeX) {
        this.sizeX = sizeX == null ? null : sizeX.trim();
    }

    public BigDecimal getSizeW() {
        return sizeW;
    }

    public BomModel withSizeW(BigDecimal sizeW) {
        this.setSizeW(sizeW);
        return this;
    }

    public void setSizeW(BigDecimal sizeW) {
        this.sizeW = sizeW;
    }

    public Integer getLength() {
        return length;
    }

    public BomModel withLength(Integer length) {
        this.setLength(length);
        return this;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public BomModel withWidth(Integer width) {
        this.setWidth(width);
        return this;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Short getKnifeQty() {
        return knifeQty;
    }

    public BomModel withKnifeQty(Short knifeQty) {
        this.setKnifeQty(knifeQty);
        return this;
    }

    public void setKnifeQty(Short knifeQty) {
        this.knifeQty = knifeQty;
    }

    public Short getDepth() {
        return depth;
    }

    public BomModel withDepth(Short depth) {
        this.setDepth(depth);
        return this;
    }

    public void setDepth(Short depth) {
        this.depth = depth;
    }

    public Byte getSource() {
        return source;
    }

    public BomModel withSource(Byte source) {
        this.setSource(source);
        return this;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public BomModel withCreateBy(Integer createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public BomModel withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        BomModel other = (BomModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getBigType() == null ? other.getBigType() == null : this.getBigType().equals(other.getBigType()))
            && (this.getSmallType() == null ? other.getSmallType() == null : this.getSmallType().equals(other.getSmallType()))
            && (this.getChildId() == null ? other.getChildId() == null : this.getChildId().equals(other.getChildId()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getQty() == null ? other.getQty() == null : this.getQty().equals(other.getQty()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getLossType() == null ? other.getLossType() == null : this.getLossType().equals(other.getLossType()))
            && (this.getLossQty() == null ? other.getLossQty() == null : this.getLossQty().equals(other.getLossQty()))
            && (this.getSizeL() == null ? other.getSizeL() == null : this.getSizeL().equals(other.getSizeL()))
            && (this.getSizeX() == null ? other.getSizeX() == null : this.getSizeX().equals(other.getSizeX()))
            && (this.getSizeW() == null ? other.getSizeW() == null : this.getSizeW().equals(other.getSizeW()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getKnifeQty() == null ? other.getKnifeQty() == null : this.getKnifeQty().equals(other.getKnifeQty()))
            && (this.getDepth() == null ? other.getDepth() == null : this.getDepth().equals(other.getDepth()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getBigType() == null) ? 0 : getBigType().hashCode());
        result = prime * result + ((getSmallType() == null) ? 0 : getSmallType().hashCode());
        result = prime * result + ((getChildId() == null) ? 0 : getChildId().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getQty() == null) ? 0 : getQty().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getLossType() == null) ? 0 : getLossType().hashCode());
        result = prime * result + ((getLossQty() == null) ? 0 : getLossQty().hashCode());
        result = prime * result + ((getSizeL() == null) ? 0 : getSizeL().hashCode());
        result = prime * result + ((getSizeX() == null) ? 0 : getSizeX().hashCode());
        result = prime * result + ((getSizeW() == null) ? 0 : getSizeW().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getKnifeQty() == null) ? 0 : getKnifeQty().hashCode());
        result = prime * result + ((getDepth() == null) ? 0 : getDepth().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", parentId=").append(parentId);
        sb.append(", bigType=").append(bigType);
        sb.append(", smallType=").append(smallType);
        sb.append(", childId=").append(childId);
        sb.append(", unit=").append(unit);
        sb.append(", qty=").append(qty);
        sb.append(", price=").append(price);
        sb.append(", money=").append(money);
        sb.append(", lossType=").append(lossType);
        sb.append(", lossQty=").append(lossQty);
        sb.append(", sizeL=").append(sizeL);
        sb.append(", sizeX=").append(sizeX);
        sb.append(", sizeW=").append(sizeW);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", knifeQty=").append(knifeQty);
        sb.append(", depth=").append(depth);
        sb.append(", source=").append(source);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}