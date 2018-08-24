package com.gwg.shiro.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResultVo<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer recordCount = 0;
	
	private List<T> items;

	public PageResultVo(Integer recordCount) {
		this.recordCount = recordCount;
	}
	
	public PageResultVo(Integer recordCount, List<T> items) {
		this.recordCount = recordCount;
		this.items = items;
	}



	public PageResultVo() {
		super();
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getItems() {
		return items == null? new ArrayList<T>(): items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
}
