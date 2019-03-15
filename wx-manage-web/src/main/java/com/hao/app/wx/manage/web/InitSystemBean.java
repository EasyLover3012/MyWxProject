package com.hao.app.wx.manage.web;

import java.util.Set;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;



/**
 * 系统启动加载
 *
 * @author yanwei
 * @since 1.0.0
 */
public class InitSystemBean implements InitializingBean, ServletContextAware {

	private final Logger logger = LoggerFactory.getLogger(InitSystemBean.class);



	@Override
	public void setServletContext(ServletContext servletContext) {
	
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
