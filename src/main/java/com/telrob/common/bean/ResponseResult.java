package com.telrob.common.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

public class ResponseResult implements Serializable {
	
	public static interface NoPage{};
	public static interface Page extends NoPage{};
	
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
	
	@JsonView(NoPage.class)
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	@JsonView(NoPage.class)
	public String getMessage() {
		return message;
	}
	
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonView(NoPage.class)
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static int getSuccess() {
		return SUCCESS;
	}
	@JsonView(Page.class)
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	@JsonView(Page.class)
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	@JsonView(Page.class)
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	@JsonView(Page.class)
	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	@JsonView(Page.class)
	public Long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	
}
