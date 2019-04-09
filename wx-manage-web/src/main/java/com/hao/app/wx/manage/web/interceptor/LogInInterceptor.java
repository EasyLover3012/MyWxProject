package com.hao.app.wx.manage.web.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hao.app.wx.manage.commons.entity.Constants;
import com.hao.app.wx.manage.commons.entity.result.JsonResultAjax;
import com.hao.app.wx.manage.pojo.SysMember;

public class LogInInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LogInInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SysMember currentUser = (SysMember) request.getSession().getAttribute(Constants.CURRENT_LOGIN_USER);
		//return true;
		if(currentUser != null && StringUtils.isNotBlank(currentUser.getName())){
			return true;
		}
		logger.info("Not Login!");
		
		if (!(request.getHeader("accept").contains("application/json") 
				|| (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").contains("XMLHttpRequest") ))) {
			response.sendRedirect("login.jsp"); 
			return false;
		}else{
			//json错误请求处理
			JsonResultAjax result = new JsonResultAjax(false, "请先登录！");
			String json = new Gson().toJson(result);
			PrintWriter pw = response.getWriter();
			pw.write(json);
			pw.flush();
			
			return false;
		}
	}

}
