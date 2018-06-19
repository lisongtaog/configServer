package com.bestgo.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 账户表-UtiIAccount  数据查询对象
 */
public class UtiIAccountExample implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UtiIAccountExample() {
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
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }		
		public Criteria andAccCodeIsNull() {
            addCriterion("AccCode is null");
            return (Criteria) this;
        }

        public Criteria andAccCodeIsNotNull() {
            addCriterion("AccCode is not null");
            return (Criteria) this;
        }

        public Criteria andAccCodeEqualTo(String value) {
            addCriterion("AccCode =", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotEqualTo(String value) {
            addCriterion("AccCode <>", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeGreaterThan(String value) {
            addCriterion("AccCode >", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AccCode >=", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeLessThan(String value) {
            addCriterion("AccCode <", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeLessThanOrEqualTo(String value) {
            addCriterion("AccCode <=", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeLike(String value) {
            addCriterion("AccCode like", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotLike(String value) {
            addCriterion("AccCode not like", value, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeIn(List<String> values) {
            addCriterion("AccCode in", values, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotIn(List<String> values) {
            addCriterion("AccCode not in", values, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeBetween(String value1, String value2) {
            addCriterion("AccCode between", value1, value2, "accCode");
            return (Criteria) this;
        }

        public Criteria andAccCodeNotBetween(String value1, String value2) {
            addCriterion("AccCode not between", value1, value2, "accCode");
            return (Criteria) this;
        }
		
		public Criteria andSvrCodeIsNull() {
            addCriterion("SvrCode is null");
            return (Criteria) this;
        }

        public Criteria andSvrCodeIsNotNull() {
            addCriterion("SvrCode is not null");
            return (Criteria) this;
        }

        public Criteria andSvrCodeEqualTo(String value) {
            addCriterion("SvrCode =", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeNotEqualTo(String value) {
            addCriterion("SvrCode <>", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeGreaterThan(String value) {
            addCriterion("SvrCode >", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SvrCode >=", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeLessThan(String value) {
            addCriterion("SvrCode <", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeLessThanOrEqualTo(String value) {
            addCriterion("SvrCode <=", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeLike(String value) {
            addCriterion("SvrCode like", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeNotLike(String value) {
            addCriterion("SvrCode not like", value, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeIn(List<String> values) {
            addCriterion("SvrCode in", values, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeNotIn(List<String> values) {
            addCriterion("SvrCode not in", values, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeBetween(String value1, String value2) {
            addCriterion("SvrCode between", value1, value2, "svrCode");
            return (Criteria) this;
        }

        public Criteria andSvrCodeNotBetween(String value1, String value2) {
            addCriterion("SvrCode not between", value1, value2, "svrCode");
            return (Criteria) this;
        }
		
		public Criteria andAccNameIsNull() {
            addCriterion("AccName is null");
            return (Criteria) this;
        }

        public Criteria andAccNameIsNotNull() {
            addCriterion("AccName is not null");
            return (Criteria) this;
        }

        public Criteria andAccNameEqualTo(String value) {
            addCriterion("AccName =", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotEqualTo(String value) {
            addCriterion("AccName <>", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameGreaterThan(String value) {
            addCriterion("AccName >", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameGreaterThanOrEqualTo(String value) {
            addCriterion("AccName >=", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameLessThan(String value) {
            addCriterion("AccName <", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameLessThanOrEqualTo(String value) {
            addCriterion("AccName <=", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameLike(String value) {
            addCriterion("AccName like", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotLike(String value) {
            addCriterion("AccName not like", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameIn(List<String> values) {
            addCriterion("AccName in", values, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotIn(List<String> values) {
            addCriterion("AccName not in", values, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameBetween(String value1, String value2) {
            addCriterion("AccName between", value1, value2, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotBetween(String value1, String value2) {
            addCriterion("AccName not between", value1, value2, "accName");
            return (Criteria) this;
        }
		
		public Criteria andPassWordIsNull() {
            addCriterion("PassWord is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("PassWord is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("PassWord =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("PassWord <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("PassWord >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("PassWord >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("PassWord <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("PassWord <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("PassWord like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("PassWord not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("PassWord in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("PassWord not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("PassWord between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("PassWord not between", value1, value2, "passWord");
            return (Criteria) this;
        }
		
		public Criteria andUserCodeIsNull() {
            addCriterion("UserCode is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("UserCode is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("UserCode =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("UserCode <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("UserCode >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UserCode >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("UserCode <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("UserCode <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("UserCode like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("UserCode not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("UserCode in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("UserCode not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("UserCode between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("UserCode not between", value1, value2, "userCode");
            return (Criteria) this;
        }
		
		public Criteria andComCodeIsNull() {
            addCriterion("ComCode is null");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNotNull() {
            addCriterion("ComCode is not null");
            return (Criteria) this;
        }

        public Criteria andComCodeEqualTo(String value) {
            addCriterion("ComCode =", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotEqualTo(String value) {
            addCriterion("ComCode <>", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThan(String value) {
            addCriterion("ComCode >", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ComCode >=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThan(String value) {
            addCriterion("ComCode <", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThanOrEqualTo(String value) {
            addCriterion("ComCode <=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLike(String value) {
            addCriterion("ComCode like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotLike(String value) {
            addCriterion("ComCode not like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeIn(List<String> values) {
            addCriterion("ComCode in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotIn(List<String> values) {
            addCriterion("ComCode not in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeBetween(String value1, String value2) {
            addCriterion("ComCode between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotBetween(String value1, String value2) {
            addCriterion("ComCode not between", value1, value2, "comCode");
            return (Criteria) this;
        }
		
		public Criteria andUserNameIsNull() {
            addCriterion("UserName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("UserName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("UserName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("UserName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("UserName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("UserName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("UserName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("UserName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("UserName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("UserName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("UserName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("UserName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("UserName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("UserName not between", value1, value2, "userName");
            return (Criteria) this;
        }
		
		public Criteria andFAccCodeIsNull() {
            addCriterion("FAccCode is null");
            return (Criteria) this;
        }

        public Criteria andFAccCodeIsNotNull() {
            addCriterion("FAccCode is not null");
            return (Criteria) this;
        }

        public Criteria andFAccCodeEqualTo(String value) {
            addCriterion("FAccCode =", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeNotEqualTo(String value) {
            addCriterion("FAccCode <>", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeGreaterThan(String value) {
            addCriterion("FAccCode >", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FAccCode >=", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeLessThan(String value) {
            addCriterion("FAccCode <", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeLessThanOrEqualTo(String value) {
            addCriterion("FAccCode <=", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeLike(String value) {
            addCriterion("FAccCode like", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeNotLike(String value) {
            addCriterion("FAccCode not like", value, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeIn(List<String> values) {
            addCriterion("FAccCode in", values, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeNotIn(List<String> values) {
            addCriterion("FAccCode not in", values, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeBetween(String value1, String value2) {
            addCriterion("FAccCode between", value1, value2, "fAccCode");
            return (Criteria) this;
        }

        public Criteria andFAccCodeNotBetween(String value1, String value2) {
            addCriterion("FAccCode not between", value1, value2, "fAccCode");
            return (Criteria) this;
        }
		
		public Criteria andSvrNameIsNull() {
            addCriterion("SvrName is null");
            return (Criteria) this;
        }

        public Criteria andSvrNameIsNotNull() {
            addCriterion("SvrName is not null");
            return (Criteria) this;
        }

        public Criteria andSvrNameEqualTo(String value) {
            addCriterion("SvrName =", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameNotEqualTo(String value) {
            addCriterion("SvrName <>", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameGreaterThan(String value) {
            addCriterion("SvrName >", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameGreaterThanOrEqualTo(String value) {
            addCriterion("SvrName >=", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameLessThan(String value) {
            addCriterion("SvrName <", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameLessThanOrEqualTo(String value) {
            addCriterion("SvrName <=", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameLike(String value) {
            addCriterion("SvrName like", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameNotLike(String value) {
            addCriterion("SvrName not like", value, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameIn(List<String> values) {
            addCriterion("SvrName in", values, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameNotIn(List<String> values) {
            addCriterion("SvrName not in", values, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameBetween(String value1, String value2) {
            addCriterion("SvrName between", value1, value2, "svrName");
            return (Criteria) this;
        }

        public Criteria andSvrNameNotBetween(String value1, String value2) {
            addCriterion("SvrName not between", value1, value2, "svrName");
            return (Criteria) this;
        }
		
		public Criteria andValidStatusIsNull() {
            addCriterion("ValidStatus is null");
            return (Criteria) this;
        }

        public Criteria andValidStatusIsNotNull() {
            addCriterion("ValidStatus is not null");
            return (Criteria) this;
        }

        public Criteria andValidStatusEqualTo(String value) {
            addCriterion("ValidStatus =", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotEqualTo(String value) {
            addCriterion("ValidStatus <>", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusGreaterThan(String value) {
            addCriterion("ValidStatus >", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ValidStatus >=", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLessThan(String value) {
            addCriterion("ValidStatus <", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLessThanOrEqualTo(String value) {
            addCriterion("ValidStatus <=", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLike(String value) {
            addCriterion("ValidStatus like", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotLike(String value) {
            addCriterion("ValidStatus not like", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusIn(List<String> values) {
            addCriterion("ValidStatus in", values, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotIn(List<String> values) {
            addCriterion("ValidStatus not in", values, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusBetween(String value1, String value2) {
            addCriterion("ValidStatus between", value1, value2, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotBetween(String value1, String value2) {
            addCriterion("ValidStatus not between", value1, value2, "validStatus");
            return (Criteria) this;
        }
		
		public Criteria andValidEndDateIsNull() {
            addCriterion("ValidEndDate is null");
            return (Criteria) this;
        }

        public Criteria andValidEndDateIsNotNull() {
            addCriterion("ValidEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andValidEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("ValidEndDate =", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ValidEndDate <>", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ValidEndDate >", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ValidEndDate >=", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateLessThan(Date value) {
            addCriterionForJDBCDate("ValidEndDate <", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ValidEndDate <=", value, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("ValidEndDate in", values, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ValidEndDate not in", values, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ValidEndDate between", value1, value2, "validEndDate");
            return (Criteria) this;
        }

        public Criteria andValidEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ValidEndDate not between", value1, value2, "validEndDate");
            return (Criteria) this;
        }		
		
		public Criteria andCreateDateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CreateDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }		
		
		public Criteria andUpdateDateIsNull() {
            addCriterion("UpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateDate =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateDate <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("UpdateDate >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateDate >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("UpdateDate <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateDate <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("UpdateDate in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("UpdateDate not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UpdateDate between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UpdateDate not between", value1, value2, "updateDate");
            return (Criteria) this;
        }		
		
		public Criteria andCreatorCodeIsNull() {
            addCriterion("CreatorCode is null");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIsNotNull() {
            addCriterion("CreatorCode is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeEqualTo(String value) {
            addCriterion("CreatorCode =", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotEqualTo(String value) {
            addCriterion("CreatorCode <>", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThan(String value) {
            addCriterion("CreatorCode >", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CreatorCode >=", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThan(String value) {
            addCriterion("CreatorCode <", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThanOrEqualTo(String value) {
            addCriterion("CreatorCode <=", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLike(String value) {
            addCriterion("CreatorCode like", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotLike(String value) {
            addCriterion("CreatorCode not like", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIn(List<String> values) {
            addCriterion("CreatorCode in", values, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotIn(List<String> values) {
            addCriterion("CreatorCode not in", values, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeBetween(String value1, String value2) {
            addCriterion("CreatorCode between", value1, value2, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotBetween(String value1, String value2) {
            addCriterion("CreatorCode not between", value1, value2, "creatorCode");
            return (Criteria) this;
        }
		
		public Criteria andUpdaterCodeIsNull() {
            addCriterion("UpdaterCode is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeIsNotNull() {
            addCriterion("UpdaterCode is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeEqualTo(String value) {
            addCriterion("UpdaterCode =", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeNotEqualTo(String value) {
            addCriterion("UpdaterCode <>", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeGreaterThan(String value) {
            addCriterion("UpdaterCode >", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UpdaterCode >=", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeLessThan(String value) {
            addCriterion("UpdaterCode <", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeLessThanOrEqualTo(String value) {
            addCriterion("UpdaterCode <=", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeLike(String value) {
            addCriterion("UpdaterCode like", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeNotLike(String value) {
            addCriterion("UpdaterCode not like", value, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeIn(List<String> values) {
            addCriterion("UpdaterCode in", values, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeNotIn(List<String> values) {
            addCriterion("UpdaterCode not in", values, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeBetween(String value1, String value2) {
            addCriterion("UpdaterCode between", value1, value2, "updaterCode");
            return (Criteria) this;
        }

        public Criteria andUpdaterCodeNotBetween(String value1, String value2) {
            addCriterion("UpdaterCode not between", value1, value2, "updaterCode");
            return (Criteria) this;
        }
		
		public Criteria andLoginPowerFlagIsNull() {
            addCriterion("LoginPowerFlag is null");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagIsNotNull() {
            addCriterion("LoginPowerFlag is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagEqualTo(String value) {
            addCriterion("LoginPowerFlag =", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagNotEqualTo(String value) {
            addCriterion("LoginPowerFlag <>", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagGreaterThan(String value) {
            addCriterion("LoginPowerFlag >", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagGreaterThanOrEqualTo(String value) {
            addCriterion("LoginPowerFlag >=", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagLessThan(String value) {
            addCriterion("LoginPowerFlag <", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagLessThanOrEqualTo(String value) {
            addCriterion("LoginPowerFlag <=", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagLike(String value) {
            addCriterion("LoginPowerFlag like", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagNotLike(String value) {
            addCriterion("LoginPowerFlag not like", value, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagIn(List<String> values) {
            addCriterion("LoginPowerFlag in", values, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagNotIn(List<String> values) {
            addCriterion("LoginPowerFlag not in", values, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagBetween(String value1, String value2) {
            addCriterion("LoginPowerFlag between", value1, value2, "loginPowerFlag");
            return (Criteria) this;
        }

        public Criteria andLoginPowerFlagNotBetween(String value1, String value2) {
            addCriterion("LoginPowerFlag not between", value1, value2, "loginPowerFlag");
            return (Criteria) this;
        }
		
		public Criteria andFlagIsNull() {
            addCriterion("Flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("Flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("Flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("Flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("Flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("Flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("Flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("Flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("Flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("Flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("Flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("Flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("Flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("Flag not between", value1, value2, "flag");
            return (Criteria) this;
        }
		
		public Criteria andPasswdSetDateIsNull() {
            addCriterion("PasswdSetDate is null");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateIsNotNull() {
            addCriterion("PasswdSetDate is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdSetDate =", value, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdSetDate <>", value, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PasswdSetDate >", value, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdSetDate >=", value, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateLessThan(Date value) {
            addCriterionForJDBCDate("PasswdSetDate <", value, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdSetDate <=", value, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateIn(List<Date> values) {
            addCriterionForJDBCDate("PasswdSetDate in", values, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PasswdSetDate not in", values, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PasswdSetDate between", value1, value2, "passwdSetDate");
            return (Criteria) this;
        }

        public Criteria andPasswdSetDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PasswdSetDate not between", value1, value2, "passwdSetDate");
            return (Criteria) this;
        }		
		
		public Criteria andPasswdExpireDateIsNull() {
            addCriterion("PasswdExpireDate is null");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateIsNotNull() {
            addCriterion("PasswdExpireDate is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdExpireDate =", value, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdExpireDate <>", value, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PasswdExpireDate >", value, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdExpireDate >=", value, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateLessThan(Date value) {
            addCriterionForJDBCDate("PasswdExpireDate <", value, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PasswdExpireDate <=", value, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateIn(List<Date> values) {
            addCriterionForJDBCDate("PasswdExpireDate in", values, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PasswdExpireDate not in", values, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PasswdExpireDate between", value1, value2, "passwdExpireDate");
            return (Criteria) this;
        }

        public Criteria andPasswdExpireDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PasswdExpireDate not between", value1, value2, "passwdExpireDate");
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