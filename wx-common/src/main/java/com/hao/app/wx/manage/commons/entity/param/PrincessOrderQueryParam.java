package com.hao.app.wx.manage.commons.entity.param;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;


/**
 * 日志查询对象
 * 
 * @author haoguowei
 *
 */
public class PrincessOrderQueryParam extends QueryParam implements Serializable{

	private static final long serialVersionUID = 4737617179006429526L;

	public PrincessOrderQueryParam(int pageStart, int pageLimit) {
		super(pageStart, pageLimit);
	}

	private Date startTime;
	private Date endTime;
	private Integer shopNameId;
	private String sellCode;
	private String customerPhone;
	private String sortStr;

	
	
	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public Integer getShopNameId() {
		return shopNameId;
	}


	public void setShopNameId(Integer shopNameId) {
		this.shopNameId = shopNameId;
	}


	public String getSellCode() {
		return sellCode;
	}


	public void setSellCode(String sellCode) {
		this.sellCode = sellCode;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getSortStr() {
		return sortStr;
	}


	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}


	@Override
	public String toString() {
		return "PrincessOrderQueryParam{" + "startTime='" +DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss")  + '\'' 
				+ ", endTime='" + DateFormatUtils.format(endTime, "yyyy-MM-dd HH:mm:ss") + '\'' 
				+ ", shopNameId='" + shopNameId.toString() + '\'' 
				+ ", sellCode='" + sellCode + '\'' 
				+ ", customerPhone='" + customerPhone + '\'' 
				+ ", sortStr='" + sortStr + '\'' + '}';
	}
}
