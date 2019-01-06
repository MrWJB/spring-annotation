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
	 * 容器销毁后调用 - 单实例
	 * 手动销毁  - 多实例
	 */
	public void destroy() throws Exception {
		System.out.println("cat ... destroy...");
	}

	/**
	 * 对象创建并给属性赋值之后调用
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("cat ... afterPropertiesSet...");
	}

}
