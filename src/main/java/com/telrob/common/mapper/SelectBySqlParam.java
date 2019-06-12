package com.telrob.common.mapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.telrob.common.entity.BaseExample;
import com.telrob.common.entity.BaseExample.Criteria;
import com.telrob.common.entity.BaseExample.Criterion;
import com.telrob.common.utils.annotation.Alias;
import com.telrob.common.utils.annotation.Ignore;

public class SelectBySqlParam <Entity>{
	public String selectSqlWidthParam(BaseExample baseExample,Class<Entity> cls) throws Exception {
		String sql="select ";
		//是否去重
		if(baseExample.isDistinct()) {
			sql+=" distinct ";
		}
		if(baseExample.getColumn()!=null) {
			sql+=baseExample.getColumn()+ " from ";
		}else {
			String column="";
			Map<String,String>colMap=getTableColumn(cls);
			Set<String>keyList=colMap.keySet();
			int size=keyList.size();
			int i=0;
			for(String key:keyList) {
				String val=colMap.get(key);
				column+=val+" as "+key;
				if(i<size-1) {
					column+=",";
				}else {
					column+=" ";
				}
				i++;
			}
			sql+=column+" from ";
		}
		
		if(baseExample.getTableName()!=null) {
			sql +=  baseExample.getTableName();
		}else {
			String tabName=getTableName(cls);
			baseExample.setTableName(tabName);
			sql +=  tabName;
		}
		List<Criteria> criteriaList=baseExample.getOredCriteria();
		if(criteriaList!=null&&criteriaList.size()>0) {
			//当存在时候就有条件
			sql+=" where ";
			String orSQL="";
			for(int i=0;i<criteriaList.size();i++) {
				Criteria criteria=criteriaList.get(i);
				if(i==0) {
					orSQL+=" ( ";
				}else {
					orSQL+=" OR ( ";
				}
				//下面的语句需要用or隔开
				List<Criterion> criterionList=criteria.getAllCriteria();
				if(criterionList!=null&&criterionList.size()>0) {
					//下面语句需要用and分割
					String andSQL="";
					//AND();
					for(int j=0;j<criterionList.size();j++) {
						
						Criterion criterion=criterionList.get(j);
						if(j==0) {
							andSQL+=" ( ";
						}else {
							andSQL+=" AND ( ";
						}
						if(criterion.isNoValue()) {
							andSQL+=criterion.getCondition();
						}
						
						if(criterion.isSingleValue()) {
							andSQL+=criterion.getCondition()+" #{oredCriteria["+i+"].criteria["+j+"].value}";
						}
						
						if(criterion.isBetweenValue()) {
							andSQL+=criterion.getCondition()+" #{oredCriteria["+i+"].criteria["+j+"].value} and #{oredCriteria["+i+"].criteria["+j+"].secondValue}";
						}
						if(criterion.isListValue()) {
							String condition= criterion.getCondition();
							andSQL+=condition +" ( ";
							List<Object> valList=(List<Object>)criterion.getValue();
							String listStr="";
							for(int k=0;k<valList.size();k++) {
								listStr+="#{oredCriteria["+i+"].criteria["+j+"].value["+k+"]} ,";
							}
							
							andSQL+=listStr.substring(0, listStr.length()-1);
							
							andSQL+=" ) ";
						}
						
						andSQL+=" ) ";
					}
					
					orSQL+=andSQL;
				}
				//分割符
				orSQL+=" ) ";
			}
			
			sql+=orSQL;
		}
		
		if(baseExample.getOrderByClause()!=null&&!baseExample.getOrderByClause().equals("")) {
			sql+= "order by "+baseExample.getOrderByClause();
		}
		return sql;
	}
	
	/**
	 * 根据类获取类上注解
	 */
	
	
	public String getTableName(Class<Entity> cls) {
		Alias ali=cls.getDeclaredAnnotation(Alias.class);
		if(ali!=null) {
			return ali.value();
		}else {
			String name=cls.getSimpleName();
			return convert(name);
		}
	}
	
	public Map<String,String> getTableColumn(Class<Entity> cls){
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
}
