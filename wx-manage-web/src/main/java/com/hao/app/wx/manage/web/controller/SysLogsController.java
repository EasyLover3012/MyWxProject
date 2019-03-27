package com.hao.app.wx.manage.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hao.app.wx.manage.commons.entity.Page;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.SysLogs;



/**
 * 系统日志
 * 
 * @author haoguowei
 *
 */
@Controller
@RequestMapping
public class SysLogsController extends BaseController {

	@RequestMapping("/initLog.do")
	public String initLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "jsp/log";
	}

	@RequestMapping("/searchLogs.do")
	public void searchLogs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int start = NumberUtils.toInt(request.getParameter(START));
		int limit = NumberUtils.toInt(request.getParameter(LIMIT), Page.LIMIT);

		JsonResult<SysLogs> result = sysLogsService.searchLogs(name, start, limit);
		writeResponse(response, result);
	}

}
