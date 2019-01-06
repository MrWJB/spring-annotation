package com.atguigu.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcess implements BeanPostProcessor{

	/**
	 * 在初始化之前调用 
	 * bean: 创建当前的实例的bean
	 * beanName: 实例的名称
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization" + bean +" =>" +beanName);
		return bean;
	}

	/**
	 * 在初始化之后调用
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization" + bean +"=> " +beanName);
		return bean;
	}

}
