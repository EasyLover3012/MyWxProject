package com.hao.app.wx.commons.entity.result;

import java.io.Serializable;
import java.util.List;

public class JsonResult<T> implements Serializable {
	// 总记录数
		private int total;

		// 结果集
		private List<T> resultList;

		public JsonResult(int total, List<T> resultList) {
			this.total = total;
			this.resultList = resultList;
		}

		public JsonResult() {

		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public List<T> getResultList() {
			return resultList;
		}

		public void setResultList(List<T> resultList) {
			this.resultList = resultList;
		}
}
