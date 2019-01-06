package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;

/**
 * ����aop��������
 * @author w1812
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

	//ҵ���߼������������
	@Bean("mathCalculator")
	public MathCalculator calculator(){
		return new MathCalculator();
	}

	//��������뵽������
	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
	
}
