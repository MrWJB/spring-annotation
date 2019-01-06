package com.atguigu.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.beans.MainConfigOfProfile;

public class MainTest_Profile {

	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		System.out.println("����������ɣ�");
		//���ü����
		applicationContext.getEnvironment().setActiveProfiles("test");
		//ע����������
		applicationContext.register(MainConfigOfProfile.class);
		//����ˢ��
		applicationContext.refresh();

		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String names : beanNamesForType) {
			System.out.println(names);
		}
		
		applicationContext.close();
		System.out.println("��������");
	}
}
