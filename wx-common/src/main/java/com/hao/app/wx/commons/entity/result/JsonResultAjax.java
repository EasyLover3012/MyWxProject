package com.hao.app.wx.commons.entity.result;

import java.io.Serializable;

public class JsonResultAjax implements Serializable {


	//结果是否正确
	private boolean success;

	//结果提示语
	private String resultTipMsg;
	
	//返回业务操作数据
	private Object data;

	public JsonResultAjax() {

	}

	public JsonResultAjax(boolean success) {
		this.success = success;
	}
	
	public JsonResultAjax(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}
	
	public JsonResultAjax(boolean success, String resultTipMsg) {
		this.success = success;
		this.resultTipMsg = resultTipMsg;
	}
	
	public JsonResultAjax(boolean success, String resultTipMsg, Object data) {
		this.success = success;
		this.resultTipMsg = resultTipMsg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultTipMsg() {
		return resultTipMsg;
	}

	public void setResultTipMsg(String resultTipMsg) {
		this.resultTipMsg = resultTipMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResultAjax [success=" + success + ", resultTipMsg=" + resultTipMsg + ", data=" + data + "]";
	}
	
}
