package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.atguigu.beans.Color;
import com.atguigu.beans.ColorFactoryBean;
import com.atguigu.beans.Person;

@Configuration
//@ComponentScan(value={"com.atguigu"},
//		excludeFilters={
//		@Filter(type=FilterType.ANNOTATION,classes={Controller.class,Service.class})
//})
@ComponentScan(value={"com.atguigu"},
includeFilters={
//@Filter(type=FilterType.ANNOTATION,classes={Controller.class,Service.class}),
@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
},useDefaultFilters=false)
@Import(value={Color.class,MyImportSeletor.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
	/**
	 * single:��ʵ���ģ�Ĭ��ֵ����ioc������������÷�����������ŵ�ioc�����С�
	 * 			�Ժ�ÿ�λ�ȡ����ֱ�Ӵ�������map.get()�����ã�
	 * prototype:��ʵ���ģ�ioc��������������ȥ���÷�������������������С�ÿ�λ�ȡ��ʱ��Ż���÷�����������
	 * request��ͬһ�����󴴽�һ��ʵ��
	 * session: ͬһ��session����һ��ʵ��
	 * @return
	 */
	@Scope(value="prototype")
	/**
	 * ������
	 * 	��ʵ��bean:Ĭ��������������ʱ�򴴽�����
	 * 	�����أ������������ᴴ�����󡣵�һ��ʹ�ã���ȡ��Bean�������󣬲���ʼ����
	 * @return
	 */
	@Lazy
	@Bean(value="person")
	public Person person(){
		return new Person("����",23);
	}
	
	@Conditional({WindowsCondition.class})
	@Bean("bile")
	public Person person01(){
		return new Person("bile", 63);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 48);
	}
	
	
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}

}	
