package com.telrob.common.bean;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.telrob.common.entity.BaseExample;

/**
 * 多条件查询
 * @author telrob
 *
 */
public class RequestParams implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Or> or;
	
	public List<Or> getOr() {
		return or;
	}

	public void setOr(List<Or> or) {
		this.or = or;
	}

	public static class Or{
		private List<And>and;

		public List<And> getAnd() {
			return and;
		}

		public void setAnd(List<And> and) {
			this.and = and;
		}
	}
	
	public static class And{
		private String name;
		private String opt;
		private Object value;
		private Object value2;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getOpt() {
			return opt;
		}
		public void setOpt(String opt) {
			this.opt = opt;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public Object getValue2() {
			return value2;
		}
		public void setValue2(Object value2) {
			this.value2 = value2;
		}
	}
	
	public BaseExample getExample(Class<?>cls) {
		BaseExample baseExample=new BaseExample(cls);
		if(or!=null&&or.size()>0) {
			for(int i=0;i<or.size();i++) {
				Or orTemp=or.get(i);
				List<And> andList=orTemp.getAnd();
				if(andList!=null&&andList.size()>0) {
					BaseExample.Criteria tempCriteria=baseExample.createCriteria();
					for(And and:andList) {
						String name=and.getName();
						String option = and.getOpt();
						Object value=and.getValue();
						Object value2=and.getValue2();
						if(name==null||"".equals(name)) {
							throw new RuntimeException("column name not null!");
						}
						if(and.getOpt()==null||"".equals(option)) {
							throw new RuntimeException("column option not null!");
						}
						if(option.equals("is null")) {
							tempCriteria.andItemIsNull(name);
						}else if(option.equals("is not null")) {
							tempCriteria.andItemIsNotNull(name);
						}else if(option.equals("=")) {
							tempCriteria.andItemEqualTo(name, and.getValue());
						}else if(option.equals("<>")||option.equals("!=")) {
							tempCriteria.andItemNotEqualTo(name,value);
						}else if(option.equals(">")) {
							tempCriteria.andItemGreaterThan(name, value);
						}else if(option.equals(">=")) {
							tempCriteria.andItemGreaterThanOrEqualTo(name, value);
						}else if(option.equals("<")) {
							tempCriteria.andItemLessThan(name, value);
						}else if(option.equals("<=")) {
							tempCriteria.andItemLessThanOrEqualTo(name, value);
						}else if(option.equals("like")) {
							tempCriteria.andItemLike(name, value);
						}else if(option.equals("not like")) {
							tempCriteria.andItemNotLike(name, value);
						}else if(option.equals("in")) {
							tempCriteria.andItemIn(name, (List)value);
						}else if(option.equals("not in")) {
							tempCriteria.andItemNotIn(name, (List)value);
						}else if(option.equals("between")) {
							tempCriteria.andItemBetween(name, value, value2);
						}else if(option.equals("not between")) {
							tempCriteria.andItemNotBetween(name, value, value2);
						}
					}
					if(i>0) {
						baseExample.or(tempCriteria);
					}
				}
			}
		}
		return baseExample;
	}

}
