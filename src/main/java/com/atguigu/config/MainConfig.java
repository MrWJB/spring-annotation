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
	 * single:单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
	 * 			以后每次获取就是直接从容器（map.get()）中拿，
	 * prototype:多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象；
	 * request：同一次请求创建一个实例
	 * session: 同一个session创建一个实例
	 * @return
	 */
	@Scope(value="prototype")
	/**
	 * 懒加载
	 * 	单实例bean:默认在容器启动的时候创建对象；
	 * 	懒加载：容器启动不会创建对象。第一次使用（获取）Bean创建对象，并初始化；
	 * @return
	 */
	@Lazy
	@Bean(value="person")
	public Person person(){
		return new Person("李四",23);
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
