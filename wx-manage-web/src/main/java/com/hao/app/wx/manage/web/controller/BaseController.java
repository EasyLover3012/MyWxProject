package com.hao.app.wx.manage.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.hao.app.wx.manage.commons.entity.Constants;
import com.hao.app.wx.manage.commons.enums.ResultCodeEnum;
import com.hao.app.wx.manage.pojo.SysMember;
import com.hao.app.wx.manage.service.SysLogsService;





public class BaseController {

	@Autowired
	protected SysLogsService sysLogsService;

	// 管理员角色ID
	private static final int ADMINROLEID = 1;

	// 获取页面分页参数start
	protected static final String START = "start";

	// 获取页面分页参数limit
	protected static final String LIMIT = "limit";

	// 模板文件夹名称
	protected static final String MODELDIR = "exportModel";

	/**
	 * 得到登录用户名
	 * 
	 * @param request
	 * @return
	 */
	public String getCurrentUserName(HttpServletRequest request) {
		SysMember user = getCurrentUser(request);
		return user == null ? "" : user.getName();
	}

	/**
	 *
	 * 得到登录用户
	 * 
	 * @param request
	 * @return
	 */
	public SysMember getCurrentUser(HttpServletRequest request) {
		return (SysMember) request.getSession().getAttribute(Constants.CURRENT_LOGIN_USER);
	}

	/**
	 * 得到系统路径
	 * 
	 * @param request
	 * @return
	 */
	public String getRealpath(HttpServletRequest request) {
		return request.getServletContext().getRealPath("");
	}

	/**
	 * 输出提示
	 * 
	 * @param request
	 */
	public String failResult(HttpServletRequest request, ResultCodeEnum resultCode) {
		if (resultCode != null) {
			request.setAttribute("msg", resultCode.toString());
		}
		return "WEB-INF/error/fail";
	}

	public String failResult(HttpServletRequest request, String errMsg) {
		request.setAttribute("msg", errMsg);
		return "WEB-INF/error/fail";
	}

	/**
	 * 成功后返回提示
	 * 
	 * @param request
	 * @param url
	 * @param title
	 * @return
	 */
	public String successResult(HttpServletRequest request, String title, String url) {
		if (StringUtils.isNotBlank(title)) {
			request.setAttribute("title", title);
		}
		if (StringUtils.isNotBlank(url)) {
			request.setAttribute("url", url);
		}
		return "WEB-INF/error/success";
	}

	/**
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public void writeResponse(HttpServletResponse response, Object obj) throws IOException {
	
		writeResponse(response, new Gson().toJson(obj));
	}

	/**
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public void writeResponse(HttpServletResponse response, String obj) throws IOException {
		response.getWriter().write(obj);
	}

}