package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.beans.Car;
import com.atguigu.config.MainConfigOfLifeCycle;

public class MainTest_LifeCycle {

	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("�����������");
//		Car car = (Car) applicationContext.getBean("car");
//		System.out.println("��ȡbean����");
		applicationContext.close();
	}
}
