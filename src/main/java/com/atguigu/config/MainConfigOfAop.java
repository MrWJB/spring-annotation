package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;

/**
 * 测试aop主配置类
 * @author w1812
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

	//业务逻辑类加入容器中
	@Bean("mathCalculator")
	public MathCalculator calculator(){
		return new MathCalculator();
	}

	//切面类加入到容器中
	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
	
}
