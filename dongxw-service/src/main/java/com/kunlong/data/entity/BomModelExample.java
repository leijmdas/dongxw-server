package com.kunlong.data.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BomModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BomModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andBigTypeIsNull() {
            addCriterion("big_type is null");
            return (Criteria) this;
        }

        public Criteria andBigTypeIsNotNull() {
            addCriterion("big_type is not null");
            return (Criteria) this;
        }

        public Criteria andBigTypeEqualTo(Integer value) {
            addCriterion("big_type =", value, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeNotEqualTo(Integer value) {
            addCriterion("big_type <>", value, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeGreaterThan(Integer value) {
            addCriterion("big_type >", value, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("big_type >=", value, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeLessThan(Integer value) {
            addCriterion("big_type <", value, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeLessThanOrEqualTo(Integer value) {
            addCriterion("big_type <=", value, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeIn(List<Integer> values) {
            addCriterion("big_type in", values, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeNotIn(List<Integer> values) {
            addCriterion("big_type not in", values, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeBetween(Integer value1, Integer value2) {
            addCriterion("big_type between", value1, value2, "bigType");
            return (Criteria) this;
        }

        public Criteria andBigTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("big_type not between", value1, value2, "bigType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeIsNull() {
            addCriterion("small_type is null");
            return (Criteria) this;
        }

        public Criteria andSmallTypeIsNotNull() {
            addCriterion("small_type is not null");
            return (Criteria) this;
        }

        public Criteria andSmallTypeEqualTo(Integer value) {
            addCriterion("small_type =", value, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeNotEqualTo(Integer value) {
            addCriterion("small_type <>", value, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeGreaterThan(Integer value) {
            addCriterion("small_type >", value, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("small_type >=", value, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeLessThan(Integer value) {
            addCriterion("small_type <", value, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeLessThanOrEqualTo(Integer value) {
            addCriterion("small_type <=", value, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeIn(List<Integer> values) {
            addCriterion("small_type in", values, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeNotIn(List<Integer> values) {
            addCriterion("small_type not in", values, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeBetween(Integer value1, Integer value2) {
            addCriterion("small_type between", value1, value2, "smallType");
            return (Criteria) this;
        }

        public Criteria andSmallTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("small_type not between", value1, value2, "smallType");
            return (Criteria) this;
        }

        public Criteria andChildIdIsNull() {
            addCriterion("child_id is null");
            return (Criteria) this;
        }

        public Criteria andChildIdIsNotNull() {
            addCriterion("child_id is not null");
            return (Criteria) this;
        }

        public Criteria andChildIdEqualTo(Integer value) {
            addCriterion("child_id =", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotEqualTo(Integer value) {
            addCriterion("child_id <>", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdGreaterThan(Integer value) {
            addCriterion("child_id >", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("child_id >=", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdLessThan(Integer value) {
            addCriterion("child_id <", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdLessThanOrEqualTo(Integer value) {
            addCriterion("child_id <=", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdIn(List<Integer> values) {
            addCriterion("child_id in", values, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotIn(List<Integer> values) {
            addCriterion("child_id not in", values, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdBetween(Integer value1, Integer value2) {
            addCriterion("child_id between", value1, value2, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotBetween(Integer value1, Integer value2) {
            addCriterion("child_id not between", value1, value2, "childId");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("qty is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("qty is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(BigDecimal value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(BigDecimal value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(BigDecimal value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(BigDecimal value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<BigDecimal> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<BigDecimal> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andLossTypeIsNull() {
            addCriterion("loss_type is null");
            return (Criteria) this;
        }

        public Criteria andLossTypeIsNotNull() {
            addCriterion("loss_type is not null");
            return (Criteria) this;
        }

        public Criteria andLossTypeEqualTo(Integer value) {
            addCriterion("loss_type =", value, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeNotEqualTo(Integer value) {
            addCriterion("loss_type <>", value, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeGreaterThan(Integer value) {
            addCriterion("loss_type >", value, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loss_type >=", value, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeLessThan(Integer value) {
            addCriterion("loss_type <", value, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeLessThanOrEqualTo(Integer value) {
            addCriterion("loss_type <=", value, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeIn(List<Integer> values) {
            addCriterion("loss_type in", values, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeNotIn(List<Integer> values) {
            addCriterion("loss_type not in", values, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeBetween(Integer value1, Integer value2) {
            addCriterion("loss_type between", value1, value2, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("loss_type not between", value1, value2, "lossType");
            return (Criteria) this;
        }

        public Criteria andLossQtyIsNull() {
            addCriterion("loss_qty is null");
            return (Criteria) this;
        }

        public Criteria andLossQtyIsNotNull() {
            addCriterion("loss_qty is not null");
            return (Criteria) this;
        }

        public Criteria andLossQtyEqualTo(Short value) {
            addCriterion("loss_qty =", value, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyNotEqualTo(Short value) {
            addCriterion("loss_qty <>", value, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyGreaterThan(Short value) {
            addCriterion("loss_qty >", value, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyGreaterThanOrEqualTo(Short value) {
            addCriterion("loss_qty >=", value, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyLessThan(Short value) {
            addCriterion("loss_qty <", value, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyLessThanOrEqualTo(Short value) {
            addCriterion("loss_qty <=", value, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyIn(List<Short> values) {
            addCriterion("loss_qty in", values, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyNotIn(List<Short> values) {
            addCriterion("loss_qty not in", values, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyBetween(Short value1, Short value2) {
            addCriterion("loss_qty between", value1, value2, "lossQty");
            return (Criteria) this;
        }

        public Criteria andLossQtyNotBetween(Short value1, Short value2) {
            addCriterion("loss_qty not between", value1, value2, "lossQty");
            return (Criteria) this;
        }

        public Criteria andSizeLIsNull() {
            addCriterion("size_l is null");
            return (Criteria) this;
        }

        public Criteria andSizeLIsNotNull() {
            addCriterion("size_l is not null");
            return (Criteria) this;
        }

        public Criteria andSizeLEqualTo(BigDecimal value) {
            addCriterion("size_l =", value, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLNotEqualTo(BigDecimal value) {
            addCriterion("size_l <>", value, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLGreaterThan(BigDecimal value) {
            addCriterion("size_l >", value, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("size_l >=", value, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLLessThan(BigDecimal value) {
            addCriterion("size_l <", value, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLLessThanOrEqualTo(BigDecimal value) {
            addCriterion("size_l <=", value, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLIn(List<BigDecimal> values) {
            addCriterion("size_l in", values, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLNotIn(List<BigDecimal> values) {
            addCriterion("size_l not in", values, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("size_l between", value1, value2, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeLNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("size_l not between", value1, value2, "sizeL");
            return (Criteria) this;
        }

        public Criteria andSizeXIsNull() {
            addCriterion("size_x is null");
            return (Criteria) this;
        }

        public Criteria andSizeXIsNotNull() {
            addCriterion("size_x is not null");
            return (Criteria) this;
        }

        public Criteria andSizeXEqualTo(String value) {
            addCriterion("size_x =", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXNotEqualTo(String value) {
            addCriterion("size_x <>", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXGreaterThan(String value) {
            addCriterion("size_x >", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXGreaterThanOrEqualTo(String value) {
            addCriterion("size_x >=", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXLessThan(String value) {
            addCriterion("size_x <", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXLessThanOrEqualTo(String value) {
            addCriterion("size_x <=", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXLike(String value) {
            addCriterion("size_x like", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXNotLike(String value) {
            addCriterion("size_x not like", value, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXIn(List<String> values) {
            addCriterion("size_x in", values, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXNotIn(List<String> values) {
            addCriterion("size_x not in", values, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXBetween(String value1, String value2) {
            addCriterion("size_x between", value1, value2, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeXNotBetween(String value1, String value2) {
            addCriterion("size_x not between", value1, value2, "sizeX");
            return (Criteria) this;
        }

        public Criteria andSizeWIsNull() {
            addCriterion("size_w is null");
            return (Criteria) this;
        }

        public Criteria andSizeWIsNotNull() {
            addCriterion("size_w is not null");
            return (Criteria) this;
        }

        public Criteria andSizeWEqualTo(BigDecimal value) {
            addCriterion("size_w =", value, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWNotEqualTo(BigDecimal value) {
            addCriterion("size_w <>", value, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWGreaterThan(BigDecimal value) {
            addCriterion("size_w >", value, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("size_w >=", value, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWLessThan(BigDecimal value) {
            addCriterion("size_w <", value, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWLessThanOrEqualTo(BigDecimal value) {
            addCriterion("size_w <=", value, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWIn(List<BigDecimal> values) {
            addCriterion("size_w in", values, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWNotIn(List<BigDecimal> values) {
            addCriterion("size_w not in", values, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("size_w between", value1, value2, "sizeW");
            return (Criteria) this;
        }

        public Criteria andSizeWNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("size_w not between", value1, value2, "sizeW");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Integer value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Integer value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Integer value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Integer value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Integer value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Integer> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Integer> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Integer value1, Integer value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Integer value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Integer value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Integer value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Integer value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Integer value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Integer> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Integer> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Integer value1, Integer value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyIsNull() {
            addCriterion("knife_qty is null");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyIsNotNull() {
            addCriterion("knife_qty is not null");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyEqualTo(Short value) {
            addCriterion("knife_qty =", value, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyNotEqualTo(Short value) {
            addCriterion("knife_qty <>", value, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyGreaterThan(Short value) {
            addCriterion("knife_qty >", value, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyGreaterThanOrEqualTo(Short value) {
            addCriterion("knife_qty >=", value, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyLessThan(Short value) {
            addCriterion("knife_qty <", value, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyLessThanOrEqualTo(Short value) {
            addCriterion("knife_qty <=", value, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyIn(List<Short> values) {
            addCriterion("knife_qty in", values, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyNotIn(List<Short> values) {
            addCriterion("knife_qty not in", values, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyBetween(Short value1, Short value2) {
            addCriterion("knife_qty between", value1, value2, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andKnifeQtyNotBetween(Short value1, Short value2) {
            addCriterion("knife_qty not between", value1, value2, "knifeQty");
            return (Criteria) this;
        }

        public Criteria andDepthIsNull() {
            addCriterion("depth is null");
            return (Criteria) this;
        }

        public Criteria andDepthIsNotNull() {
            addCriterion("depth is not null");
            return (Criteria) this;
        }

        public Criteria andDepthEqualTo(Short value) {
            addCriterion("depth =", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotEqualTo(Short value) {
            addCriterion("depth <>", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThan(Short value) {
            addCriterion("depth >", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThanOrEqualTo(Short value) {
            addCriterion("depth >=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThan(Short value) {
            addCriterion("depth <", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThanOrEqualTo(Short value) {
            addCriterion("depth <=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthIn(List<Short> values) {
            addCriterion("depth in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotIn(List<Short> values) {
            addCriterion("depth not in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthBetween(Short value1, Short value2) {
            addCriterion("depth between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotBetween(Short value1, Short value2) {
            addCriterion("depth not between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Byte value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Byte value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Byte value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Byte value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Byte value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Byte> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Byte> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Byte value1, Byte value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUnitLikeInsensitive(String value) {
            addCriterion("upper(unit) like", value.toUpperCase(), "unit");
            return (Criteria) this;
        }

        public Criteria andSizeXLikeInsensitive(String value) {
            addCriterion("upper(size_x) like", value.toUpperCase(), "sizeX");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}