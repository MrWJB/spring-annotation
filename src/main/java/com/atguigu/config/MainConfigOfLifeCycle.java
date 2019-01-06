package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.atguigu.beans.Car;

@Configuration
@ComponentScan(basePackages={"com.atguigu.beans"})
public class MainConfigOfLifeCycle {

	/**
	 * 默认时单实例bean
	 * @return
	 */
	@Bean(initMethod="init",destroyMethod="destroy")
	public Car car(){
		return new Car();
	}
	
	
}
