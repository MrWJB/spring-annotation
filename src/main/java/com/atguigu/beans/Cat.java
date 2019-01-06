package com.atguigu.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class Cat implements InitializingBean,DisposableBean{

	public Cat() {
		System.out.println("cat...construct...");
	}



	/**
	 * �������ٺ���� - ��ʵ��
	 * �ֶ�����  - ��ʵ��
	 */
	public void destroy() throws Exception {
		System.out.println("cat ... destroy...");
	}

	/**
	 * ���󴴽��������Ը�ֵ֮�����
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("cat ... afterPropertiesSet...");
	}

}
