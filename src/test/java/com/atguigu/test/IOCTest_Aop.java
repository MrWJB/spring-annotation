package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfigOfAop;

public class IOCTest_Aop {

	@Test
	public void test() {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		MathCalculator calculator = (MathCalculator) applicationContext.getBean("mathCalculator");
		int result = calculator.div(10, 0);
		System.out.println(result);
		applicationContext.close();
	}
}
