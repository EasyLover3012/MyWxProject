package org.wx.manage.service;

import org.wx.manage.pojo.SysLogs;

import com.wx.commons.entity.result.JsonResult;



public interface SysLogsService {
	/**
	 * 分页查询日志记录
	 * @param name
	 * @param start
	 * @param limit
	 * @return
	 */
	JsonResult<SysLogs> searchLogs(String name, int start, int limit);

	/**
	 * 写日志
	 * @param user
	 * @param string
	 */
	void writeLog(String user, String string);
}
