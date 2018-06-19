package com.bestgo.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UtiIUserExample implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UtiIUserExample() {
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
		
		public Criteria andSalesManCodeIsNull() {
            addCriterion("SalesManCode is null");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeIsNotNull() {
            addCriterion("SalesManCode is not null");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeEqualTo(String value) {
            addCriterion("SalesManCode =", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeNotEqualTo(String value) {
            addCriterion("SalesManCode <>", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeGreaterThan(String value) {
            addCriterion("SalesManCode >", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SalesManCode >=", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeLessThan(String value) {
            addCriterion("SalesManCode <", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeLessThanOrEqualTo(String value) {
            addCriterion("SalesManCode <=", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeLike(String value) {
            addCriterion("SalesManCode like", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeNotLike(String value) {
            addCriterion("SalesManCode not like", value, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeIn(List<String> values) {
            addCriterion("SalesManCode in", values, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeNotIn(List<String> values) {
            addCriterion("SalesManCode not in", values, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeBetween(String value1, String value2) {
            addCriterion("SalesManCode between", value1, value2, "salesManCode");
            return (Criteria) this;
        }

        public Criteria andSalesManCodeNotBetween(String value1, String value2) {
            addCriterion("SalesManCode not between", value1, value2, "salesManCode");
            return (Criteria) this;
        }
		
		public Criteria andSalesManNameIsNull() {
            addCriterion("SalesManName is null");
            return (Criteria) this;
        }

        public Criteria andSalesManNameIsNotNull() {
            addCriterion("SalesManName is not null");
            return (Criteria) this;
        }

        public Criteria andSalesManNameEqualTo(String value) {
            addCriterion("SalesManName =", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameNotEqualTo(String value) {
            addCriterion("SalesManName <>", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameGreaterThan(String value) {
            addCriterion("SalesManName >", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameGreaterThanOrEqualTo(String value) {
            addCriterion("SalesManName >=", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameLessThan(String value) {
            addCriterion("SalesManName <", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameLessThanOrEqualTo(String value) {
            addCriterion("SalesManName <=", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameLike(String value) {
            addCriterion("SalesManName like", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameNotLike(String value) {
            addCriterion("SalesManName not like", value, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameIn(List<String> values) {
            addCriterion("SalesManName in", values, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameNotIn(List<String> values) {
            addCriterion("SalesManName not in", values, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameBetween(String value1, String value2) {
            addCriterion("SalesManName between", value1, value2, "salesManName");
            return (Criteria) this;
        }

        public Criteria andSalesManNameNotBetween(String value1, String value2) {
            addCriterion("SalesManName not between", value1, value2, "salesManName");
            return (Criteria) this;
        }
		
		public Criteria andUserTypeIsNull() {
            addCriterion("UserType is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("UserType is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("UserType =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("UserType <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("UserType >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("UserType >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("UserType <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("UserType <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("UserType like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("UserType not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("UserType in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("UserType not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("UserType between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("UserType not between", value1, value2, "userType");
            return (Criteria) this;
        }
		
		public Criteria andUserSortIsNull() {
            addCriterion("UserSort is null");
            return (Criteria) this;
        }

        public Criteria andUserSortIsNotNull() {
            addCriterion("UserSort is not null");
            return (Criteria) this;
        }

        public Criteria andUserSortEqualTo(String value) {
            addCriterion("UserSort =", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortNotEqualTo(String value) {
            addCriterion("UserSort <>", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortGreaterThan(String value) {
            addCriterion("UserSort >", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortGreaterThanOrEqualTo(String value) {
            addCriterion("UserSort >=", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortLessThan(String value) {
            addCriterion("UserSort <", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortLessThanOrEqualTo(String value) {
            addCriterion("UserSort <=", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortLike(String value) {
            addCriterion("UserSort like", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortNotLike(String value) {
            addCriterion("UserSort not like", value, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortIn(List<String> values) {
            addCriterion("UserSort in", values, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortNotIn(List<String> values) {
            addCriterion("UserSort not in", values, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortBetween(String value1, String value2) {
            addCriterion("UserSort between", value1, value2, "userSort");
            return (Criteria) this;
        }

        public Criteria andUserSortNotBetween(String value1, String value2) {
            addCriterion("UserSort not between", value1, value2, "userSort");
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
		
		public Criteria andNewUserCodeIsNull() {
            addCriterion("NewUserCode is null");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeIsNotNull() {
            addCriterion("NewUserCode is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeEqualTo(String value) {
            addCriterion("NewUserCode =", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeNotEqualTo(String value) {
            addCriterion("NewUserCode <>", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeGreaterThan(String value) {
            addCriterion("NewUserCode >", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("NewUserCode >=", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeLessThan(String value) {
            addCriterion("NewUserCode <", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeLessThanOrEqualTo(String value) {
            addCriterion("NewUserCode <=", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeLike(String value) {
            addCriterion("NewUserCode like", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeNotLike(String value) {
            addCriterion("NewUserCode not like", value, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeIn(List<String> values) {
            addCriterion("NewUserCode in", values, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeNotIn(List<String> values) {
            addCriterion("NewUserCode not in", values, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeBetween(String value1, String value2) {
            addCriterion("NewUserCode between", value1, value2, "newUserCode");
            return (Criteria) this;
        }

        public Criteria andNewUserCodeNotBetween(String value1, String value2) {
            addCriterion("NewUserCode not between", value1, value2, "newUserCode");
            return (Criteria) this;
        }
		
		public Criteria andOldUserCodeIsNull() {
            addCriterion("OldUserCode is null");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeIsNotNull() {
            addCriterion("OldUserCode is not null");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeEqualTo(String value) {
            addCriterion("OldUserCode =", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeNotEqualTo(String value) {
            addCriterion("OldUserCode <>", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeGreaterThan(String value) {
            addCriterion("OldUserCode >", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OldUserCode >=", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeLessThan(String value) {
            addCriterion("OldUserCode <", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeLessThanOrEqualTo(String value) {
            addCriterion("OldUserCode <=", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeLike(String value) {
            addCriterion("OldUserCode like", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeNotLike(String value) {
            addCriterion("OldUserCode not like", value, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeIn(List<String> values) {
            addCriterion("OldUserCode in", values, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeNotIn(List<String> values) {
            addCriterion("OldUserCode not in", values, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeBetween(String value1, String value2) {
            addCriterion("OldUserCode between", value1, value2, "oldUserCode");
            return (Criteria) this;
        }

        public Criteria andOldUserCodeNotBetween(String value1, String value2) {
            addCriterion("OldUserCode not between", value1, value2, "oldUserCode");
            return (Criteria) this;
        }
		
		public Criteria andCrossUserFlagIsNull() {
            addCriterion("CrossUserFlag is null");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagIsNotNull() {
            addCriterion("CrossUserFlag is not null");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagEqualTo(String value) {
            addCriterion("CrossUserFlag =", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagNotEqualTo(String value) {
            addCriterion("CrossUserFlag <>", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagGreaterThan(String value) {
            addCriterion("CrossUserFlag >", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CrossUserFlag >=", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagLessThan(String value) {
            addCriterion("CrossUserFlag <", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagLessThanOrEqualTo(String value) {
            addCriterion("CrossUserFlag <=", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagLike(String value) {
            addCriterion("CrossUserFlag like", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagNotLike(String value) {
            addCriterion("CrossUserFlag not like", value, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagIn(List<String> values) {
            addCriterion("CrossUserFlag in", values, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagNotIn(List<String> values) {
            addCriterion("CrossUserFlag not in", values, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagBetween(String value1, String value2) {
            addCriterion("CrossUserFlag between", value1, value2, "crossUserFlag");
            return (Criteria) this;
        }

        public Criteria andCrossUserFlagNotBetween(String value1, String value2) {
            addCriterion("CrossUserFlag not between", value1, value2, "crossUserFlag");
            return (Criteria) this;
        }
		
		public Criteria andRoamingTypeIsNull() {
            addCriterion("RoamingType is null");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeIsNotNull() {
            addCriterion("RoamingType is not null");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeEqualTo(String value) {
            addCriterion("RoamingType =", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeNotEqualTo(String value) {
            addCriterion("RoamingType <>", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeGreaterThan(String value) {
            addCriterion("RoamingType >", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RoamingType >=", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeLessThan(String value) {
            addCriterion("RoamingType <", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeLessThanOrEqualTo(String value) {
            addCriterion("RoamingType <=", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeLike(String value) {
            addCriterion("RoamingType like", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeNotLike(String value) {
            addCriterion("RoamingType not like", value, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeIn(List<String> values) {
            addCriterion("RoamingType in", values, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeNotIn(List<String> values) {
            addCriterion("RoamingType not in", values, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeBetween(String value1, String value2) {
            addCriterion("RoamingType between", value1, value2, "roamingType");
            return (Criteria) this;
        }

        public Criteria andRoamingTypeNotBetween(String value1, String value2) {
            addCriterion("RoamingType not between", value1, value2, "roamingType");
            return (Criteria) this;
        }
		
		public Criteria andRoamingStatusIsNull() {
            addCriterion("RoamingStatus is null");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusIsNotNull() {
            addCriterion("RoamingStatus is not null");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusEqualTo(String value) {
            addCriterion("RoamingStatus =", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusNotEqualTo(String value) {
            addCriterion("RoamingStatus <>", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusGreaterThan(String value) {
            addCriterion("RoamingStatus >", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RoamingStatus >=", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusLessThan(String value) {
            addCriterion("RoamingStatus <", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusLessThanOrEqualTo(String value) {
            addCriterion("RoamingStatus <=", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusLike(String value) {
            addCriterion("RoamingStatus like", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusNotLike(String value) {
            addCriterion("RoamingStatus not like", value, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusIn(List<String> values) {
            addCriterion("RoamingStatus in", values, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusNotIn(List<String> values) {
            addCriterion("RoamingStatus not in", values, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusBetween(String value1, String value2) {
            addCriterion("RoamingStatus between", value1, value2, "roamingStatus");
            return (Criteria) this;
        }

        public Criteria andRoamingStatusNotBetween(String value1, String value2) {
            addCriterion("RoamingStatus not between", value1, value2, "roamingStatus");
            return (Criteria) this;
        }
		
		public Criteria andRoamComCodeIsNull() {
            addCriterion("RoamComCode is null");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeIsNotNull() {
            addCriterion("RoamComCode is not null");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeEqualTo(String value) {
            addCriterion("RoamComCode =", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeNotEqualTo(String value) {
            addCriterion("RoamComCode <>", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeGreaterThan(String value) {
            addCriterion("RoamComCode >", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RoamComCode >=", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeLessThan(String value) {
            addCriterion("RoamComCode <", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeLessThanOrEqualTo(String value) {
            addCriterion("RoamComCode <=", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeLike(String value) {
            addCriterion("RoamComCode like", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeNotLike(String value) {
            addCriterion("RoamComCode not like", value, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeIn(List<String> values) {
            addCriterion("RoamComCode in", values, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeNotIn(List<String> values) {
            addCriterion("RoamComCode not in", values, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeBetween(String value1, String value2) {
            addCriterion("RoamComCode between", value1, value2, "roamComCode");
            return (Criteria) this;
        }

        public Criteria andRoamComCodeNotBetween(String value1, String value2) {
            addCriterion("RoamComCode not between", value1, value2, "roamComCode");
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
		
		public Criteria andAuditStatusIsNull() {
            addCriterion("AuditStatus is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("AuditStatus is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("AuditStatus =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("AuditStatus <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("AuditStatus >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AuditStatus >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("AuditStatus <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("AuditStatus <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("AuditStatus like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("AuditStatus not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("AuditStatus in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("AuditStatus not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("AuditStatus between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("AuditStatus not between", value1, value2, "auditStatus");
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

		public Criteria andUserLevelIsNull() {
			addCriterion("userLevel is null");
			return (Criteria) this;
		}

		public Criteria andUserLevelIsNotNull() {
			addCriterion("userLevel is not null");

			return (Criteria) this;
		}

		public Criteria andUserLevelEqualTo(String value) {
			addCriterion("userLevel =", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotEqualTo(String value) {
			addCriterion("userLevel <>", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelGreaterThan(String value) {
			addCriterion("userLevel >", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelGreaterThanOrEqualTo(String value) {
			addCriterion("userLevel >=", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLessThan(String value) {
			addCriterion("userLevel <", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLessThanOrEqualTo(String value) {
			addCriterion("userLevel <=", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLike(String value) {
			addCriterion("userLevel like", "%" + value + "%", "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotLike(String value) {
			addCriterion("userLevel not like", "%" + value + "%", "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelIn(List<String> values) {
			addCriterion("userLevel in", values, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotIn(List<String> values) {
			addCriterion("userLevel not in", values, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelBetween(String value1, String value2) {
			addCriterion("userLevel between", value1, value2, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotBetween(String value1, String value2) {
			addCriterion("userLevel not between", value1, value2, "userLevel");
			return (Criteria) this;
		}

		public Criteria andJobTitleIsNull() {
			addCriterion("jobTitle is null");
			return (Criteria) this;
		}

		public Criteria andJobTitleIsNotNull() {
			addCriterion("jobTitle is not null");

			return (Criteria) this;
		}

		public Criteria andJobTitleEqualTo(String value) {
			addCriterion("jobTitle =", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotEqualTo(String value) {
			addCriterion("jobTitle <>", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleGreaterThan(String value) {
			addCriterion("jobTitle >", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleGreaterThanOrEqualTo(String value) {
			addCriterion("jobTitle >=", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleLessThan(String value) {
			addCriterion("jobTitle <", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleLessThanOrEqualTo(String value) {
			addCriterion("jobTitle <=", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleLike(String value) {
			addCriterion("jobTitle like", "%" + value + "%", "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotLike(String value) {
			addCriterion("jobTitle not like", "%" + value + "%", "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleIn(List<String> values) {
			addCriterion("jobTitle in", values, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotIn(List<String> values) {
			addCriterion("jobTitle not in", values, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleBetween(String value1, String value2) {
			addCriterion("jobTitle between", value1, value2, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotBetween(String value1, String value2) {
			addCriterion("jobTitle not between", value1, value2, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andDepartmentIsNull() {
			addCriterion("department is null");
			return (Criteria) this;
		}

		public Criteria andDepartmentIsNotNull() {
			addCriterion("department is not null");

			return (Criteria) this;
		}

		public Criteria andDepartmentEqualTo(String value) {
			addCriterion("department =", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotEqualTo(String value) {
			addCriterion("department <>", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentGreaterThan(String value) {
			addCriterion("department >", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
			addCriterion("department >=", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentLessThan(String value) {
			addCriterion("department <", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentLessThanOrEqualTo(String value) {
			addCriterion("department <=", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentLike(String value) {
			addCriterion("department like", "%" + value + "%", "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotLike(String value) {
			addCriterion("department not like", "%" + value + "%", "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentIn(List<String> values) {
			addCriterion("department in", values, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotIn(List<String> values) {
			addCriterion("department not in", values, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentBetween(String value1, String value2) {
			addCriterion("department between", value1, value2, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotBetween(String value1, String value2) {
			addCriterion("department not between", value1, value2, "department");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelIsNull() {
			addCriterion("businessLevel is null");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelIsNotNull() {
			addCriterion("businessLevel is not null");

			return (Criteria) this;
		}

		public Criteria andBusinessLevelEqualTo(String value) {
			addCriterion("businessLevel =", value, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelNotEqualTo(String value) {
			addCriterion("businessLevel <>", value, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelGreaterThan(String value) {
			addCriterion("businessLevel >", value, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelGreaterThanOrEqualTo(String value) {
			addCriterion("businessLevel >=", value, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelLessThan(String value) {
			addCriterion("businessLevel <", value, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelLessThanOrEqualTo(String value) {
			addCriterion("businessLevel <=", value, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelLike(String value) {
			addCriterion("businessLevel like", "%" + value + "%", "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelNotLike(String value) {
			addCriterion("businessLevel not like", "%" + value + "%", "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelIn(List<String> values) {
			addCriterion("businessLevel in", values, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelNotIn(List<String> values) {
			addCriterion("businessLevel not in", values, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelBetween(String value1, String value2) {
			addCriterion("businessLevel between", value1, value2, "businessLevel");
			return (Criteria) this;
		}

		public Criteria andBusinessLevelNotBetween(String value1, String value2) {
			addCriterion("businessLevel not between", value1, value2, "businessLevel");
			return (Criteria) this;
		}
		public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
      
      return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", "%"+value+"%", "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", "%"+value+"%", "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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