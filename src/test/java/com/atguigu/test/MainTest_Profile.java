package com.atguigu.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.beans.MainConfigOfProfile;

public class MainTest_Profile {

	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		System.out.println("容器创建完成！");
		//设置激活环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		//注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//启动刷新
		applicationContext.refresh();

		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String names : beanNamesForType) {
			System.out.println(names);
		}
		
		applicationContext.close();
		System.out.println("容器销毁");
	}
}
