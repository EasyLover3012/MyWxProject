package com.hao.app.wx.manage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class mvcController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
