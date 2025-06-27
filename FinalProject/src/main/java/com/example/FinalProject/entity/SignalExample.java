package com.example.FinalProject.entity;

import java.util.ArrayList;
import java.util.List;

public class SignalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SignalExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andMxIsNull() {
            addCriterion("mx is null");
            return (Criteria) this;
        }

        public Criteria andMxIsNotNull() {
            addCriterion("mx is not null");
            return (Criteria) this;
        }

        public Criteria andMxEqualTo(Double value) {
            addCriterion("mx =", value, "mx");
            return (Criteria) this;
        }

        public Criteria andMxNotEqualTo(Double value) {
            addCriterion("mx <>", value, "mx");
            return (Criteria) this;
        }

        public Criteria andMxGreaterThan(Double value) {
            addCriterion("mx >", value, "mx");
            return (Criteria) this;
        }

        public Criteria andMxGreaterThanOrEqualTo(Double value) {
            addCriterion("mx >=", value, "mx");
            return (Criteria) this;
        }

        public Criteria andMxLessThan(Double value) {
            addCriterion("mx <", value, "mx");
            return (Criteria) this;
        }

        public Criteria andMxLessThanOrEqualTo(Double value) {
            addCriterion("mx <=", value, "mx");
            return (Criteria) this;
        }

        public Criteria andMxIn(List<Double> values) {
            addCriterion("mx in", values, "mx");
            return (Criteria) this;
        }

        public Criteria andMxNotIn(List<Double> values) {
            addCriterion("mx not in", values, "mx");
            return (Criteria) this;
        }

        public Criteria andMxBetween(Double value1, Double value2) {
            addCriterion("mx between", value1, value2, "mx");
            return (Criteria) this;
        }

        public Criteria andMxNotBetween(Double value1, Double value2) {
            addCriterion("mx not between", value1, value2, "mx");
            return (Criteria) this;
        }

        public Criteria andMiIsNull() {
            addCriterion("mi is null");
            return (Criteria) this;
        }

        public Criteria andMiIsNotNull() {
            addCriterion("mi is not null");
            return (Criteria) this;
        }

        public Criteria andMiEqualTo(Double value) {
            addCriterion("mi =", value, "mi");
            return (Criteria) this;
        }

        public Criteria andMiNotEqualTo(Double value) {
            addCriterion("mi <>", value, "mi");
            return (Criteria) this;
        }

        public Criteria andMiGreaterThan(Double value) {
            addCriterion("mi >", value, "mi");
            return (Criteria) this;
        }

        public Criteria andMiGreaterThanOrEqualTo(Double value) {
            addCriterion("mi >=", value, "mi");
            return (Criteria) this;
        }

        public Criteria andMiLessThan(Double value) {
            addCriterion("mi <", value, "mi");
            return (Criteria) this;
        }

        public Criteria andMiLessThanOrEqualTo(Double value) {
            addCriterion("mi <=", value, "mi");
            return (Criteria) this;
        }

        public Criteria andMiIn(List<Double> values) {
            addCriterion("mi in", values, "mi");
            return (Criteria) this;
        }

        public Criteria andMiNotIn(List<Double> values) {
            addCriterion("mi not in", values, "mi");
            return (Criteria) this;
        }

        public Criteria andMiBetween(Double value1, Double value2) {
            addCriterion("mi between", value1, value2, "mi");
            return (Criteria) this;
        }

        public Criteria andMiNotBetween(Double value1, Double value2) {
            addCriterion("mi not between", value1, value2, "mi");
            return (Criteria) this;
        }

        public Criteria andLxIsNull() {
            addCriterion("lx is null");
            return (Criteria) this;
        }

        public Criteria andLxIsNotNull() {
            addCriterion("lx is not null");
            return (Criteria) this;
        }

        public Criteria andLxEqualTo(Double value) {
            addCriterion("lx =", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotEqualTo(Double value) {
            addCriterion("lx <>", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThan(Double value) {
            addCriterion("lx >", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThanOrEqualTo(Double value) {
            addCriterion("lx >=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThan(Double value) {
            addCriterion("lx <", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThanOrEqualTo(Double value) {
            addCriterion("lx <=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxIn(List<Double> values) {
            addCriterion("lx in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotIn(List<Double> values) {
            addCriterion("lx not in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxBetween(Double value1, Double value2) {
            addCriterion("lx between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotBetween(Double value1, Double value2) {
            addCriterion("lx not between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andLiIsNull() {
            addCriterion("li is null");
            return (Criteria) this;
        }

        public Criteria andLiIsNotNull() {
            addCriterion("li is not null");
            return (Criteria) this;
        }

        public Criteria andLiEqualTo(Double value) {
            addCriterion("li =", value, "li");
            return (Criteria) this;
        }

        public Criteria andLiNotEqualTo(Double value) {
            addCriterion("li <>", value, "li");
            return (Criteria) this;
        }

        public Criteria andLiGreaterThan(Double value) {
            addCriterion("li >", value, "li");
            return (Criteria) this;
        }

        public Criteria andLiGreaterThanOrEqualTo(Double value) {
            addCriterion("li >=", value, "li");
            return (Criteria) this;
        }

        public Criteria andLiLessThan(Double value) {
            addCriterion("li <", value, "li");
            return (Criteria) this;
        }

        public Criteria andLiLessThanOrEqualTo(Double value) {
            addCriterion("li <=", value, "li");
            return (Criteria) this;
        }

        public Criteria andLiIn(List<Double> values) {
            addCriterion("li in", values, "li");
            return (Criteria) this;
        }

        public Criteria andLiNotIn(List<Double> values) {
            addCriterion("li not in", values, "li");
            return (Criteria) this;
        }

        public Criteria andLiBetween(Double value1, Double value2) {
            addCriterion("li between", value1, value2, "li");
            return (Criteria) this;
        }

        public Criteria andLiNotBetween(Double value1, Double value2) {
            addCriterion("li not between", value1, value2, "li");
            return (Criteria) this;
        }
    }

    /**
     */
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