package com.hao.app.wx.manage.commons.entity.param;

import java.io.Serializable;


/**
 * 日志查询对象
 * 
 * @author haoguowei
 *
 */
public class ContractQueryParam extends QueryParam implements Serializable{

	private static final long serialVersionUID = 4737617179006429526L;

	public ContractQueryParam(int pageStart, int pageLimit) {
		super(pageStart, pageLimit);
	}

	private String contractNo;
	private String proNo;
	private String partName;
	private String sortStr;


	public String getSortStr() {
		return sortStr;
	}


	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getContractNo() {
		return contractNo;
	}


	public String getProNo() {
		return proNo;
	}


	public void setProNo(String proNo) {
		this.proNo = proNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}


	@Override
	public String toString() {
		return "ContractQueryParam{" + "contractNo='" + contractNo + '\'' + ", proNo='" + proNo + '\'' + ", partName='" + partName + '\'' + ", sortStr='" + sortStr + '\'' + '}';
	}
}
