package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.Person;
import com.atguigu.config.MainConfig;

public class IOCTest {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfig.class);
	
	@Test
	public void testImport(){
//		printBeanNames(context); 
		Object bean = context.getBean("&colorFactoryBean");
		System.out.println(bean.getClass());
	}
	
	public void printBeanNames(AnnotationConfigApplicationContext context){
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			
			System.out.println(name);
		}
	}

	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfig.class);
		String[] definitionNames = context.getBeanDefinitionNames();
		for (String def : definitionNames) {
			System.out.println(def);
		}
	}
	
	
	@Test
	public void testForXml(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		String[] definitionNames = context.getBeanDefinitionNames();
//		for (String dfn : definitionNames) {
//			System.out.println(dfn);
//		}
		
	}
	
	
	@Test
	public void test02(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfig.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("----------------------------------------------------");
		String[] type = context.getBeanNamesForType(Person.class);
		for (String ty : type) {
			System.out.println(ty);
		}
	}
	
}
