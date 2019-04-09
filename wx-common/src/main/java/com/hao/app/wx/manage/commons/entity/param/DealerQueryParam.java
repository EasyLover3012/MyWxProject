package com.hao.app.wx.manage.commons.entity.param;

import java.io.Serializable;


/**
 * 日志查询对象
 * 
 * @author haoguowei
 *
 */
public class DealerQueryParam extends QueryParam implements Serializable{

	private static final long serialVersionUID = 4737617179006429526L;

	public DealerQueryParam(int pageStart, int pageLimit) {
		super(pageStart, pageLimit);
	}

	private String dealerName;
	private String sortStr;
	
	
	public String getSortStr() {
		return sortStr;
	}



	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}



	public String getDealerName() {
		return dealerName;
	}



	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}



	@Override
	public String toString() {
		return "DealerQueryParam{" + "dealerName='" + dealerName + '\''  + ", sortStr='" + sortStr + '\'' + '}';
	}
}
