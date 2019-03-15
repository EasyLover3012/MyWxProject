package com.hao.app.wx.manage.service.impl;

import org.springframework.stereotype.Service;

import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.SysLogs;
import com.hao.app.wx.manage.service.SysLogsService;

@Service
public class SysLogsServiceImpl implements SysLogsService {

	@Override
	public JsonResult<SysLogs> searchLogs(String name, int start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeLog(String user, String string) {
		// TODO Auto-generated method stub

	}

}
