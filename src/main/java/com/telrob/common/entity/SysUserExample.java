package com.telrob.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public SysUserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_user
	 * @mbg.generated
	 */
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

		public Criteria andRoleIdIsNull() {
			addCriterion("role_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("role_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(Integer value) {
			addCriterion("role_id =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(Integer value) {
			addCriterion("role_id <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(Integer value) {
			addCriterion("role_id >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("role_id >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(Integer value) {
			addCriterion("role_id <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
			addCriterion("role_id <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<Integer> values) {
			addCriterion("role_id in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<Integer> values) {
			addCriterion("role_id not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(Integer value1, Integer value2) {
			addCriterion("role_id between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("role_id not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andNickIsNull() {
			addCriterion("nick is null");
			return (Criteria) this;
		}

		public Criteria andNickIsNotNull() {
			addCriterion("nick is not null");
			return (Criteria) this;
		}

		public Criteria andNickEqualTo(String value) {
			addCriterion("nick =", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickNotEqualTo(String value) {
			addCriterion("nick <>", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickGreaterThan(String value) {
			addCriterion("nick >", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickGreaterThanOrEqualTo(String value) {
			addCriterion("nick >=", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickLessThan(String value) {
			addCriterion("nick <", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickLessThanOrEqualTo(String value) {
			addCriterion("nick <=", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickLike(String value) {
			addCriterion("nick like", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickNotLike(String value) {
			addCriterion("nick not like", value, "nick");
			return (Criteria) this;
		}

		public Criteria andNickIn(List<String> values) {
			addCriterion("nick in", values, "nick");
			return (Criteria) this;
		}

		public Criteria andNickNotIn(List<String> values) {
			addCriterion("nick not in", values, "nick");
			return (Criteria) this;
		}

		public Criteria andNickBetween(String value1, String value2) {
			addCriterion("nick between", value1, value2, "nick");
			return (Criteria) this;
		}

		public Criteria andNickNotBetween(String value1, String value2) {
			addCriterion("nick not between", value1, value2, "nick");
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

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPhotoPathIsNull() {
			addCriterion("photo_path is null");
			return (Criteria) this;
		}

		public Criteria andPhotoPathIsNotNull() {
			addCriterion("photo_path is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoPathEqualTo(String value) {
			addCriterion("photo_path =", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotEqualTo(String value) {
			addCriterion("photo_path <>", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathGreaterThan(String value) {
			addCriterion("photo_path >", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathGreaterThanOrEqualTo(String value) {
			addCriterion("photo_path >=", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathLessThan(String value) {
			addCriterion("photo_path <", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathLessThanOrEqualTo(String value) {
			addCriterion("photo_path <=", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathLike(String value) {
			addCriterion("photo_path like", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotLike(String value) {
			addCriterion("photo_path not like", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathIn(List<String> values) {
			addCriterion("photo_path in", values, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotIn(List<String> values) {
			addCriterion("photo_path not in", values, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathBetween(String value1, String value2) {
			addCriterion("photo_path between", value1, value2, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotBetween(String value1, String value2) {
			addCriterion("photo_path not between", value1, value2, "photoPath");
			return (Criteria) this;
		}

		public Criteria andModityTimeIsNull() {
			addCriterion("modity_time is null");
			return (Criteria) this;
		}

		public Criteria andModityTimeIsNotNull() {
			addCriterion("modity_time is not null");
			return (Criteria) this;
		}

		public Criteria andModityTimeEqualTo(Date value) {
			addCriterion("modity_time =", value, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeNotEqualTo(Date value) {
			addCriterion("modity_time <>", value, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeGreaterThan(Date value) {
			addCriterion("modity_time >", value, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("modity_time >=", value, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeLessThan(Date value) {
			addCriterion("modity_time <", value, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeLessThanOrEqualTo(Date value) {
			addCriterion("modity_time <=", value, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeIn(List<Date> values) {
			addCriterion("modity_time in", values, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeNotIn(List<Date> values) {
			addCriterion("modity_time not in", values, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeBetween(Date value1, Date value2) {
			addCriterion("modity_time between", value1, value2, "modityTime");
			return (Criteria) this;
		}

		public Criteria andModityTimeNotBetween(Date value1, Date value2) {
			addCriterion("modity_time not between", value1, value2, "modityTime");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andCTimeIsNull() {
			addCriterion("c_time is null");
			return (Criteria) this;
		}

		public Criteria andCTimeIsNotNull() {
			addCriterion("c_time is not null");
			return (Criteria) this;
		}

		public Criteria andCTimeEqualTo(Date value) {
			addCriterion("c_time =", value, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeNotEqualTo(Date value) {
			addCriterion("c_time <>", value, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeGreaterThan(Date value) {
			addCriterion("c_time >", value, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("c_time >=", value, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeLessThan(Date value) {
			addCriterion("c_time <", value, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeLessThanOrEqualTo(Date value) {
			addCriterion("c_time <=", value, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeIn(List<Date> values) {
			addCriterion("c_time in", values, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeNotIn(List<Date> values) {
			addCriterion("c_time not in", values, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeBetween(Date value1, Date value2) {
			addCriterion("c_time between", value1, value2, "cTime");
			return (Criteria) this;
		}

		public Criteria andCTimeNotBetween(Date value1, Date value2) {
			addCriterion("c_time not between", value1, value2, "cTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_user
	 * @mbg.generated
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_user
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}