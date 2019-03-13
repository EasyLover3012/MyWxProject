package com.hao.app.wx.manage.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController extends BaseController {

	/**
	 * 进入主页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initMain.do")
	public String initMain(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "main";
	}
}

