package com.telrob.common.mapper;

import java.util.List;

import com.telrob.common.entity.BaseExample;
import com.telrob.common.entity.BaseExample.Criteria;
import com.telrob.common.entity.BaseExample.Criterion;

public class SelectBySqlParam {
	public String selectSqlWidthParam(BaseExample baseExample) throws Exception {
		String sql="select ";
		//是否去重
		if(baseExample.isDistinct()) {
			sql+=" distinct ";
		}
		if(baseExample.getColumn()!=null) {
			sql+=baseExample.getColumn()+ " from ";
		}else {
			sql+=" * from ";
		}
		
		if(baseExample.getTableName()!=null) {
			sql +=  baseExample.getTableName();
		}else {
			throw new Exception("Table name cannot be empty");
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
}
