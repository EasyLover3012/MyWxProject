package com.hao.app.wx.manage.pojo;

import java.io.Serializable;
import java.util.Date;

public class PrincessOrder implements Serializable {
	 
	 private Integer id;
	 private Date orderTime;
	 private Integer shopNameId;
	 private String shopName;
	 private String customer;
	 private String customerPhone;
	 private String customerAddress;
	 private String buyThings;
	 private String sellCode;
	 private String remark;
	 private Integer profit;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getShopNameId() {
		return shopNameId;
	}
	public void setShopNameId(Integer shopNameId) {
		this.shopNameId = shopNameId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getBuyThings() {
		return buyThings;
	}
	public void setBuyThings(String buyThings) {
		this.buyThings = buyThings;
	}
	public String getSellCode() {
		return sellCode;
	}
	public void setSellCode(String sellCode) {
		this.sellCode = sellCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getProfit() {
		return profit;
	}
	public void setProfit(Integer profit) {
		this.profit = profit;
	}
	 
	 
	 
}
