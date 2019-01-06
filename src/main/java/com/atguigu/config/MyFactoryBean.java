package com.atguigu.config;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.beans.ColorFactoryBean;

public class MyFactoryBean implements FactoryBean{

	/**
	 * 返回的对象会注入到容器中
	 */
	public Object getObject() throws Exception {
		return new ColorFactoryBean();
	}

	public Class getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSingleton() {
		return true;
	}

}
