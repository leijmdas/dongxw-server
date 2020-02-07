package com.kunlong.data.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductModelExample() {
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

        public Criteria andEpCodeIsNull() {
            addCriterion("ep_code is null");
            return (Criteria) this;
        }

        public Criteria andEpCodeIsNotNull() {
            addCriterion("ep_code is not null");
            return (Criteria) this;
        }

        public Criteria andEpCodeEqualTo(String value) {
            addCriterion("ep_code =", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeNotEqualTo(String value) {
            addCriterion("ep_code <>", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeGreaterThan(String value) {
            addCriterion("ep_code >", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ep_code >=", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeLessThan(String value) {
            addCriterion("ep_code <", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeLessThanOrEqualTo(String value) {
            addCriterion("ep_code <=", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeLike(String value) {
            addCriterion("ep_code like", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeNotLike(String value) {
            addCriterion("ep_code not like", value, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeIn(List<String> values) {
            addCriterion("ep_code in", values, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeNotIn(List<String> values) {
            addCriterion("ep_code not in", values, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeBetween(String value1, String value2) {
            addCriterion("ep_code between", value1, value2, "epCode");
            return (Criteria) this;
        }

        public Criteria andEpCodeNotBetween(String value1, String value2) {
            addCriterion("ep_code not between", value1, value2, "epCode");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andProductTypeIdIsNull() {
            addCriterion("product_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNotNull() {
            addCriterion("product_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdEqualTo(Integer value) {
            addCriterion("product_type_id =", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotEqualTo(Integer value) {
            addCriterion("product_type_id <>", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThan(Integer value) {
            addCriterion("product_type_id >", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type_id >=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThan(Integer value) {
            addCriterion("product_type_id <", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_type_id <=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIn(List<Integer> values) {
            addCriterion("product_type_id in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotIn(List<Integer> values) {
            addCriterion("product_type_id not in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id not between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("bar_code in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("bar_code not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
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

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andUpcAIsNull() {
            addCriterion("upc_a is null");
            return (Criteria) this;
        }

        public Criteria andUpcAIsNotNull() {
            addCriterion("upc_a is not null");
            return (Criteria) this;
        }

        public Criteria andUpcAEqualTo(String value) {
            addCriterion("upc_a =", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcANotEqualTo(String value) {
            addCriterion("upc_a <>", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcAGreaterThan(String value) {
            addCriterion("upc_a >", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcAGreaterThanOrEqualTo(String value) {
            addCriterion("upc_a >=", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcALessThan(String value) {
            addCriterion("upc_a <", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcALessThanOrEqualTo(String value) {
            addCriterion("upc_a <=", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcALike(String value) {
            addCriterion("upc_a like", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcANotLike(String value) {
            addCriterion("upc_a not like", value, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcAIn(List<String> values) {
            addCriterion("upc_a in", values, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcANotIn(List<String> values) {
            addCriterion("upc_a not in", values, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcABetween(String value1, String value2) {
            addCriterion("upc_a between", value1, value2, "upcA");
            return (Criteria) this;
        }

        public Criteria andUpcANotBetween(String value1, String value2) {
            addCriterion("upc_a not between", value1, value2, "upcA");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andImgUrlsIsNull() {
            addCriterion("img_urls is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlsIsNotNull() {
            addCriterion("img_urls is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlsEqualTo(String value) {
            addCriterion("img_urls =", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotEqualTo(String value) {
            addCriterion("img_urls <>", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsGreaterThan(String value) {
            addCriterion("img_urls >", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("img_urls >=", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsLessThan(String value) {
            addCriterion("img_urls <", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsLessThanOrEqualTo(String value) {
            addCriterion("img_urls <=", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsLike(String value) {
            addCriterion("img_urls like", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotLike(String value) {
            addCriterion("img_urls not like", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsIn(List<String> values) {
            addCriterion("img_urls in", values, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotIn(List<String> values) {
            addCriterion("img_urls not in", values, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsBetween(String value1, String value2) {
            addCriterion("img_urls between", value1, value2, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotBetween(String value1, String value2) {
            addCriterion("img_urls not between", value1, value2, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andIbQtyIsNull() {
            addCriterion("ib_qty is null");
            return (Criteria) this;
        }

        public Criteria andIbQtyIsNotNull() {
            addCriterion("ib_qty is not null");
            return (Criteria) this;
        }

        public Criteria andIbQtyEqualTo(Integer value) {
            addCriterion("ib_qty =", value, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyNotEqualTo(Integer value) {
            addCriterion("ib_qty <>", value, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyGreaterThan(Integer value) {
            addCriterion("ib_qty >", value, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ib_qty >=", value, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyLessThan(Integer value) {
            addCriterion("ib_qty <", value, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyLessThanOrEqualTo(Integer value) {
            addCriterion("ib_qty <=", value, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyIn(List<Integer> values) {
            addCriterion("ib_qty in", values, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyNotIn(List<Integer> values) {
            addCriterion("ib_qty not in", values, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyBetween(Integer value1, Integer value2) {
            addCriterion("ib_qty between", value1, value2, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("ib_qty not between", value1, value2, "ibQty");
            return (Criteria) this;
        }

        public Criteria andIbGwIsNull() {
            addCriterion("ib_gw is null");
            return (Criteria) this;
        }

        public Criteria andIbGwIsNotNull() {
            addCriterion("ib_gw is not null");
            return (Criteria) this;
        }

        public Criteria andIbGwEqualTo(BigDecimal value) {
            addCriterion("ib_gw =", value, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwNotEqualTo(BigDecimal value) {
            addCriterion("ib_gw <>", value, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwGreaterThan(BigDecimal value) {
            addCriterion("ib_gw >", value, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ib_gw >=", value, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwLessThan(BigDecimal value) {
            addCriterion("ib_gw <", value, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ib_gw <=", value, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwIn(List<BigDecimal> values) {
            addCriterion("ib_gw in", values, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwNotIn(List<BigDecimal> values) {
            addCriterion("ib_gw not in", values, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ib_gw between", value1, value2, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbGwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ib_gw not between", value1, value2, "ibGw");
            return (Criteria) this;
        }

        public Criteria andIbNwIsNull() {
            addCriterion("ib_nw is null");
            return (Criteria) this;
        }

        public Criteria andIbNwIsNotNull() {
            addCriterion("ib_nw is not null");
            return (Criteria) this;
        }

        public Criteria andIbNwEqualTo(BigDecimal value) {
            addCriterion("ib_nw =", value, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwNotEqualTo(BigDecimal value) {
            addCriterion("ib_nw <>", value, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwGreaterThan(BigDecimal value) {
            addCriterion("ib_nw >", value, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ib_nw >=", value, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwLessThan(BigDecimal value) {
            addCriterion("ib_nw <", value, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ib_nw <=", value, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwIn(List<BigDecimal> values) {
            addCriterion("ib_nw in", values, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwNotIn(List<BigDecimal> values) {
            addCriterion("ib_nw not in", values, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ib_nw between", value1, value2, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbNwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ib_nw not between", value1, value2, "ibNw");
            return (Criteria) this;
        }

        public Criteria andIbSizeIsNull() {
            addCriterion("ib_size is null");
            return (Criteria) this;
        }

        public Criteria andIbSizeIsNotNull() {
            addCriterion("ib_size is not null");
            return (Criteria) this;
        }

        public Criteria andIbSizeEqualTo(String value) {
            addCriterion("ib_size =", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeNotEqualTo(String value) {
            addCriterion("ib_size <>", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeGreaterThan(String value) {
            addCriterion("ib_size >", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeGreaterThanOrEqualTo(String value) {
            addCriterion("ib_size >=", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeLessThan(String value) {
            addCriterion("ib_size <", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeLessThanOrEqualTo(String value) {
            addCriterion("ib_size <=", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeLike(String value) {
            addCriterion("ib_size like", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeNotLike(String value) {
            addCriterion("ib_size not like", value, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeIn(List<String> values) {
            addCriterion("ib_size in", values, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeNotIn(List<String> values) {
            addCriterion("ib_size not in", values, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeBetween(String value1, String value2) {
            addCriterion("ib_size between", value1, value2, "ibSize");
            return (Criteria) this;
        }

        public Criteria andIbSizeNotBetween(String value1, String value2) {
            addCriterion("ib_size not between", value1, value2, "ibSize");
            return (Criteria) this;
        }

        public Criteria andObQtyIsNull() {
            addCriterion("ob_qty is null");
            return (Criteria) this;
        }

        public Criteria andObQtyIsNotNull() {
            addCriterion("ob_qty is not null");
            return (Criteria) this;
        }

        public Criteria andObQtyEqualTo(Integer value) {
            addCriterion("ob_qty =", value, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyNotEqualTo(Integer value) {
            addCriterion("ob_qty <>", value, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyGreaterThan(Integer value) {
            addCriterion("ob_qty >", value, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ob_qty >=", value, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyLessThan(Integer value) {
            addCriterion("ob_qty <", value, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyLessThanOrEqualTo(Integer value) {
            addCriterion("ob_qty <=", value, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyIn(List<Integer> values) {
            addCriterion("ob_qty in", values, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyNotIn(List<Integer> values) {
            addCriterion("ob_qty not in", values, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyBetween(Integer value1, Integer value2) {
            addCriterion("ob_qty between", value1, value2, "obQty");
            return (Criteria) this;
        }

        public Criteria andObQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("ob_qty not between", value1, value2, "obQty");
            return (Criteria) this;
        }

        public Criteria andObGwIsNull() {
            addCriterion("ob_gw is null");
            return (Criteria) this;
        }

        public Criteria andObGwIsNotNull() {
            addCriterion("ob_gw is not null");
            return (Criteria) this;
        }

        public Criteria andObGwEqualTo(BigDecimal value) {
            addCriterion("ob_gw =", value, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwNotEqualTo(BigDecimal value) {
            addCriterion("ob_gw <>", value, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwGreaterThan(BigDecimal value) {
            addCriterion("ob_gw >", value, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ob_gw >=", value, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwLessThan(BigDecimal value) {
            addCriterion("ob_gw <", value, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ob_gw <=", value, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwIn(List<BigDecimal> values) {
            addCriterion("ob_gw in", values, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwNotIn(List<BigDecimal> values) {
            addCriterion("ob_gw not in", values, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ob_gw between", value1, value2, "obGw");
            return (Criteria) this;
        }

        public Criteria andObGwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ob_gw not between", value1, value2, "obGw");
            return (Criteria) this;
        }

        public Criteria andObNwIsNull() {
            addCriterion("ob_nw is null");
            return (Criteria) this;
        }

        public Criteria andObNwIsNotNull() {
            addCriterion("ob_nw is not null");
            return (Criteria) this;
        }

        public Criteria andObNwEqualTo(BigDecimal value) {
            addCriterion("ob_nw =", value, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwNotEqualTo(BigDecimal value) {
            addCriterion("ob_nw <>", value, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwGreaterThan(BigDecimal value) {
            addCriterion("ob_nw >", value, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ob_nw >=", value, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwLessThan(BigDecimal value) {
            addCriterion("ob_nw <", value, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ob_nw <=", value, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwIn(List<BigDecimal> values) {
            addCriterion("ob_nw in", values, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwNotIn(List<BigDecimal> values) {
            addCriterion("ob_nw not in", values, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ob_nw between", value1, value2, "obNw");
            return (Criteria) this;
        }

        public Criteria andObNwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ob_nw not between", value1, value2, "obNw");
            return (Criteria) this;
        }

        public Criteria andObSizeIsNull() {
            addCriterion("ob_size is null");
            return (Criteria) this;
        }

        public Criteria andObSizeIsNotNull() {
            addCriterion("ob_size is not null");
            return (Criteria) this;
        }

        public Criteria andObSizeEqualTo(String value) {
            addCriterion("ob_size =", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeNotEqualTo(String value) {
            addCriterion("ob_size <>", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeGreaterThan(String value) {
            addCriterion("ob_size >", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeGreaterThanOrEqualTo(String value) {
            addCriterion("ob_size >=", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeLessThan(String value) {
            addCriterion("ob_size <", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeLessThanOrEqualTo(String value) {
            addCriterion("ob_size <=", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeLike(String value) {
            addCriterion("ob_size like", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeNotLike(String value) {
            addCriterion("ob_size not like", value, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeIn(List<String> values) {
            addCriterion("ob_size in", values, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeNotIn(List<String> values) {
            addCriterion("ob_size not in", values, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeBetween(String value1, String value2) {
            addCriterion("ob_size between", value1, value2, "obSize");
            return (Criteria) this;
        }

        public Criteria andObSizeNotBetween(String value1, String value2) {
            addCriterion("ob_size not between", value1, value2, "obSize");
            return (Criteria) this;
        }

        public Criteria andPkgFrontIsNull() {
            addCriterion("pkg_front is null");
            return (Criteria) this;
        }

        public Criteria andPkgFrontIsNotNull() {
            addCriterion("pkg_front is not null");
            return (Criteria) this;
        }

        public Criteria andPkgFrontEqualTo(String value) {
            addCriterion("pkg_front =", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontNotEqualTo(String value) {
            addCriterion("pkg_front <>", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontGreaterThan(String value) {
            addCriterion("pkg_front >", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_front >=", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontLessThan(String value) {
            addCriterion("pkg_front <", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontLessThanOrEqualTo(String value) {
            addCriterion("pkg_front <=", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontLike(String value) {
            addCriterion("pkg_front like", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontNotLike(String value) {
            addCriterion("pkg_front not like", value, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontIn(List<String> values) {
            addCriterion("pkg_front in", values, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontNotIn(List<String> values) {
            addCriterion("pkg_front not in", values, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontBetween(String value1, String value2) {
            addCriterion("pkg_front between", value1, value2, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgFrontNotBetween(String value1, String value2) {
            addCriterion("pkg_front not between", value1, value2, "pkgFront");
            return (Criteria) this;
        }

        public Criteria andPkgSideIsNull() {
            addCriterion("pkg_side is null");
            return (Criteria) this;
        }

        public Criteria andPkgSideIsNotNull() {
            addCriterion("pkg_side is not null");
            return (Criteria) this;
        }

        public Criteria andPkgSideEqualTo(String value) {
            addCriterion("pkg_side =", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideNotEqualTo(String value) {
            addCriterion("pkg_side <>", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideGreaterThan(String value) {
            addCriterion("pkg_side >", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_side >=", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideLessThan(String value) {
            addCriterion("pkg_side <", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideLessThanOrEqualTo(String value) {
            addCriterion("pkg_side <=", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideLike(String value) {
            addCriterion("pkg_side like", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideNotLike(String value) {
            addCriterion("pkg_side not like", value, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideIn(List<String> values) {
            addCriterion("pkg_side in", values, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideNotIn(List<String> values) {
            addCriterion("pkg_side not in", values, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideBetween(String value1, String value2) {
            addCriterion("pkg_side between", value1, value2, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgSideNotBetween(String value1, String value2) {
            addCriterion("pkg_side not between", value1, value2, "pkgSide");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkIsNull() {
            addCriterion("pkg_remark is null");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkIsNotNull() {
            addCriterion("pkg_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkEqualTo(String value) {
            addCriterion("pkg_remark =", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkNotEqualTo(String value) {
            addCriterion("pkg_remark <>", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkGreaterThan(String value) {
            addCriterion("pkg_remark >", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_remark >=", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkLessThan(String value) {
            addCriterion("pkg_remark <", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkLessThanOrEqualTo(String value) {
            addCriterion("pkg_remark <=", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkLike(String value) {
            addCriterion("pkg_remark like", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkNotLike(String value) {
            addCriterion("pkg_remark not like", value, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkIn(List<String> values) {
            addCriterion("pkg_remark in", values, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkNotIn(List<String> values) {
            addCriterion("pkg_remark not in", values, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkBetween(String value1, String value2) {
            addCriterion("pkg_remark between", value1, value2, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgRemarkNotBetween(String value1, String value2) {
            addCriterion("pkg_remark not between", value1, value2, "pkgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkIsNull() {
            addCriterion("img_remark is null");
            return (Criteria) this;
        }

        public Criteria andImgRemarkIsNotNull() {
            addCriterion("img_remark is not null");
            return (Criteria) this;
        }

        public Criteria andImgRemarkEqualTo(String value) {
            addCriterion("img_remark =", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotEqualTo(String value) {
            addCriterion("img_remark <>", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkGreaterThan(String value) {
            addCriterion("img_remark >", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("img_remark >=", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkLessThan(String value) {
            addCriterion("img_remark <", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkLessThanOrEqualTo(String value) {
            addCriterion("img_remark <=", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkLike(String value) {
            addCriterion("img_remark like", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotLike(String value) {
            addCriterion("img_remark not like", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkIn(List<String> values) {
            addCriterion("img_remark in", values, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotIn(List<String> values) {
            addCriterion("img_remark not in", values, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkBetween(String value1, String value2) {
            addCriterion("img_remark between", value1, value2, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotBetween(String value1, String value2) {
            addCriterion("img_remark not between", value1, value2, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkIsNull() {
            addCriterion("pkg_side_img_remark is null");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkIsNotNull() {
            addCriterion("pkg_side_img_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkEqualTo(String value) {
            addCriterion("pkg_side_img_remark =", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkNotEqualTo(String value) {
            addCriterion("pkg_side_img_remark <>", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkGreaterThan(String value) {
            addCriterion("pkg_side_img_remark >", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_side_img_remark >=", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkLessThan(String value) {
            addCriterion("pkg_side_img_remark <", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkLessThanOrEqualTo(String value) {
            addCriterion("pkg_side_img_remark <=", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkLike(String value) {
            addCriterion("pkg_side_img_remark like", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkNotLike(String value) {
            addCriterion("pkg_side_img_remark not like", value, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkIn(List<String> values) {
            addCriterion("pkg_side_img_remark in", values, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkNotIn(List<String> values) {
            addCriterion("pkg_side_img_remark not in", values, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkBetween(String value1, String value2) {
            addCriterion("pkg_side_img_remark between", value1, value2, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgRemarkNotBetween(String value1, String value2) {
            addCriterion("pkg_side_img_remark not between", value1, value2, "pkgSideImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsIsNull() {
            addCriterion("pkg_front_img_urls is null");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsIsNotNull() {
            addCriterion("pkg_front_img_urls is not null");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsEqualTo(String value) {
            addCriterion("pkg_front_img_urls =", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsNotEqualTo(String value) {
            addCriterion("pkg_front_img_urls <>", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsGreaterThan(String value) {
            addCriterion("pkg_front_img_urls >", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_front_img_urls >=", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsLessThan(String value) {
            addCriterion("pkg_front_img_urls <", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsLessThanOrEqualTo(String value) {
            addCriterion("pkg_front_img_urls <=", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsLike(String value) {
            addCriterion("pkg_front_img_urls like", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsNotLike(String value) {
            addCriterion("pkg_front_img_urls not like", value, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsIn(List<String> values) {
            addCriterion("pkg_front_img_urls in", values, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsNotIn(List<String> values) {
            addCriterion("pkg_front_img_urls not in", values, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsBetween(String value1, String value2) {
            addCriterion("pkg_front_img_urls between", value1, value2, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgUrlsNotBetween(String value1, String value2) {
            addCriterion("pkg_front_img_urls not between", value1, value2, "pkgFrontImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsIsNull() {
            addCriterion("pkg_side_img_urls is null");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsIsNotNull() {
            addCriterion("pkg_side_img_urls is not null");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsEqualTo(String value) {
            addCriterion("pkg_side_img_urls =", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsNotEqualTo(String value) {
            addCriterion("pkg_side_img_urls <>", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsGreaterThan(String value) {
            addCriterion("pkg_side_img_urls >", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_side_img_urls >=", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsLessThan(String value) {
            addCriterion("pkg_side_img_urls <", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsLessThanOrEqualTo(String value) {
            addCriterion("pkg_side_img_urls <=", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsLike(String value) {
            addCriterion("pkg_side_img_urls like", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsNotLike(String value) {
            addCriterion("pkg_side_img_urls not like", value, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsIn(List<String> values) {
            addCriterion("pkg_side_img_urls in", values, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsNotIn(List<String> values) {
            addCriterion("pkg_side_img_urls not in", values, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsBetween(String value1, String value2) {
            addCriterion("pkg_side_img_urls between", value1, value2, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgSideImgUrlsNotBetween(String value1, String value2) {
            addCriterion("pkg_side_img_urls not between", value1, value2, "pkgSideImgUrls");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkIsNull() {
            addCriterion("pkg_front_img_remark is null");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkIsNotNull() {
            addCriterion("pkg_front_img_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkEqualTo(String value) {
            addCriterion("pkg_front_img_remark =", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkNotEqualTo(String value) {
            addCriterion("pkg_front_img_remark <>", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkGreaterThan(String value) {
            addCriterion("pkg_front_img_remark >", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pkg_front_img_remark >=", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkLessThan(String value) {
            addCriterion("pkg_front_img_remark <", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkLessThanOrEqualTo(String value) {
            addCriterion("pkg_front_img_remark <=", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkLike(String value) {
            addCriterion("pkg_front_img_remark like", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkNotLike(String value) {
            addCriterion("pkg_front_img_remark not like", value, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkIn(List<String> values) {
            addCriterion("pkg_front_img_remark in", values, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkNotIn(List<String> values) {
            addCriterion("pkg_front_img_remark not in", values, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkBetween(String value1, String value2) {
            addCriterion("pkg_front_img_remark between", value1, value2, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPkgFrontImgRemarkNotBetween(String value1, String value2) {
            addCriterion("pkg_front_img_remark not between", value1, value2, "pkgFrontImgRemark");
            return (Criteria) this;
        }

        public Criteria andPrdFlagIsNull() {
            addCriterion("prd_flag is null");
            return (Criteria) this;
        }

        public Criteria andPrdFlagIsNotNull() {
            addCriterion("prd_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPrdFlagEqualTo(Short value) {
            addCriterion("prd_flag =", value, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagNotEqualTo(Short value) {
            addCriterion("prd_flag <>", value, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagGreaterThan(Short value) {
            addCriterion("prd_flag >", value, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("prd_flag >=", value, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagLessThan(Short value) {
            addCriterion("prd_flag <", value, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagLessThanOrEqualTo(Short value) {
            addCriterion("prd_flag <=", value, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagIn(List<Short> values) {
            addCriterion("prd_flag in", values, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagNotIn(List<Short> values) {
            addCriterion("prd_flag not in", values, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagBetween(Short value1, Short value2) {
            addCriterion("prd_flag between", value1, value2, "prdFlag");
            return (Criteria) this;
        }

        public Criteria andPrdFlagNotBetween(Short value1, Short value2) {
            addCriterion("prd_flag not between", value1, value2, "prdFlag");
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