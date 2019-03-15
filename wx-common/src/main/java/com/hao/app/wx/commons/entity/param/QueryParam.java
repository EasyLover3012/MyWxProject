package com.hao.app.wx.commons.entity.param;


import java.io.Serializable;

public class QueryParam implements Serializable{
	
	private int pageStart = 0;
	
	private int pageLimit = 20;
	
	public QueryParam(int pageStart, int pageLimit){
		this.pageStart = pageStart;
		this.pageLimit = pageLimit;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
}

