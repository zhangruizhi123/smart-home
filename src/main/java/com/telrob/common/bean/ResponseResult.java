package com.telrob.common.bean;

import java.io.Serializable;

public class ResponseResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final int SUCCESS = 0;
	private int code;
	private String message;
	
	private Integer start;
	private Integer length;
	private Integer draw;
	
	private Long iTotalDisplayRecords;
	private Long iTotalRecords;
	
	private Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static int getSuccess() {
		return SUCCESS;
	}
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	
}
