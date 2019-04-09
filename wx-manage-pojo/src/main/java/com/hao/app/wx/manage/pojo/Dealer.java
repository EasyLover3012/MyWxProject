package com.hao.app.wx.manage.pojo;

import java.io.Serializable;

public class Dealer implements Serializable {
	private Integer id;
	private String dealerName;
	private String wxId;
	private String telphone;
	private Integer highlevelid;
	private String address;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	public Integer getHighlevelid() {
		return highlevelid;
	}
	public void setHighlevelid(Integer highlevelid) {
		this.highlevelid = highlevelid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
