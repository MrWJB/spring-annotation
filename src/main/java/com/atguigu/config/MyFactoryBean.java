package com.atguigu.config;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.beans.ColorFactoryBean;

public class MyFactoryBean implements FactoryBean{

	/**
	 * ���صĶ����ע�뵽������
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
