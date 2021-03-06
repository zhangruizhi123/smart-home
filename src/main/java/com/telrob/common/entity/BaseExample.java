package com.telrob.common.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.telrob.common.utils.annotation.Alias;
import com.telrob.common.utils.annotation.Ignore;

public class BaseExample {
	
	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 列名
	 */
	private String column="";
	private  Map<String,String>tableColumn=null;
	
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public BaseExample(Class<?>cls) {
		tableName=getTableName(cls);
		tableColumn=getTableColumn(cls);
		//对列名重命名
		if(tableColumn!=null) {
			Set<String> columnList=tableColumn.keySet();
			int columnNum=columnList.size();
			int index=0;
			for(String key:columnList) {
				String value=tableColumn.get(key);
				column+=value+" as "+key;
				index++;
				if(index<columnNum) {
					column+=",";
				}
			}
		}
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria(tableColumn);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table dev_info_detail
	 * @mbg.generated
	 */
	protected static abstract class GeneratedCriteria {
		protected List<Criterion> criteria;
		
		private Map<String,String> tableColumns;
		protected GeneratedCriteria(Map<String,String>column) {
			tableColumns=column;
			criteria = new ArrayList<Criterion>();
		}
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
			Criterion c=new Criterion(condition, value);
			criteria.add(c);
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andItemIsNull(String column) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" is null");
			return (Criteria) this;
		}

		public Criteria andItemIsNotNull(String column) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" is not null");
			return (Criteria) this;
		}

		public Criteria andItemEqualTo(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" =", value, column);
			return (Criteria) this;
		}

		public Criteria andItemNotEqualTo(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" <>", value, column);
			return (Criteria) this;
		}

		public Criteria andItemGreaterThan(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" >", value, column);
			return (Criteria) this;
		}

		public Criteria andItemGreaterThanOrEqualTo(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" >=", value,column);
			return (Criteria) this;
		}

		public Criteria andItemLessThan(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" <", value, column);
			return (Criteria) this;
		}

		public Criteria andItemLessThanOrEqualTo(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" <=", value, column);
			return (Criteria) this;
		}

		public Criteria andItemLike(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" like", value, column);
			return (Criteria) this;
		}

		public Criteria andItemNotLike(String column,Object value) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" not like", value,column);
			return (Criteria) this;
		}

		public Criteria andItemIn(String column,List<?> values) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" in", values, column);
			return (Criteria) this;
		}

		public Criteria andItemNotIn(String column,List<?> values) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" not in", values, column);
			return (Criteria) this;
		}

		public Criteria andItemBetween(String column,Object value1, Object value2) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" between", value1, value2, column);
			return (Criteria) this;
		}

		public Criteria andItemNotBetween(String column,Object value1, Object value2) {
			String rname=tableColumns.get(column);
			if(rname==null) {
				throw new RuntimeException("column "+column+" is not define!");
			}
			addCriterion(rname+" not between", value1, value2, column);
			return (Criteria) this;
		}
		
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table dev_info_detail
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
     * This class corresponds to the database table dev_info_detail
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
    	
    	protected Criteria(Map<String,String>column) {
    		super(column);
    	}
        protected Criteria() {
            super();
        }
    }
    
	public String getTableName() {
		if("".equals(tableName)) {
			return null;
		}
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumn() {
		if("".equals(column)) {
			return null;
		}
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}
	
	/**
	 * 根据类获取类上注解
	 */
	
	
	public String getTableName(Class<?> cls) {
		Alias ali=cls.getDeclaredAnnotation(Alias.class);
		if(ali!=null) {
			return ali.value();
		}else {
			String name=cls.getSimpleName();
			return convert(name);
		}
	}
	
	public Map<String,String> getTableColumn(Class<?> cls){
		Map<String,String>result=new HashMap<String,String>();
		//获取所有字段
		Field[] fdList=cls.getDeclaredFields();
		if(fdList!=null&&fdList.length>0) {
			for(Field fd:fdList) {
				String name=fd.getName();
				//当是忽略字段时直接跳出
				if(fd.getDeclaredAnnotation(Ignore.class)!=null) {
					continue;
				}
				Alias ali=fd.getDeclaredAnnotation(Alias.class);
				//当注解存在时直接取
				if(ali!=null) {
					result.put(name, ali.value());
				}else {
					//当不存在就使用驼峰转换
					result.put(name, convert(name));
				}
			}
		}
		return result;
	}
	
	/**
	 * 将驼峰命名改成分隔符命名
	 * @param name
	 * @return
	 */
	private String convert(String name) {
		
		if(name!=null&&name.length()>0) {
			StringBuffer buf=new StringBuffer();
			char[]chArray=name.toCharArray();
			for(int i=0;i<chArray.length;i++) {
				char d=chArray[i];
				if(d>='A'&&d<='Z'&&i>0) {
					buf.append("_");
				}
				buf.append(d);
			}
			return buf.toString();
		}
		return null;
	}
	/**
	 * 获取表的字段名
	 * @param name
	 * @return
	 */
	public String getTableColumn(String name) {
		if(tableColumn!=null) {
			return tableColumn.get(name);
		}
		return null;
	}
}