package com.atguigu.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcess implements BeanPostProcessor{

	/**
	 * �ڳ�ʼ��֮ǰ���� 
	 * bean: ������ǰ��ʵ����bean
	 * beanName: ʵ��������
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization" + bean +" =>" +beanName);
		return bean;
	}

	/**
	 * �ڳ�ʼ��֮�����
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization" + bean +"=> " +beanName);
		return bean;
	}

}
