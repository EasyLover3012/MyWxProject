package com.hao.app.wx.manage.web;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.hao.app.wx.commons.utils.PropertiesUtils;


public class CustomPropertyConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		PropertiesUtils.setProperties(props);
	}

}
