package com.atguigu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.beans.Person;
import com.atguigu.config.MainConfig;

/**
 * 使用注解的方式
 * @author w1812
 */
public class MainAnnTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = context.getBean(Person.class);
		System.out.println(person);
		
	}

}
