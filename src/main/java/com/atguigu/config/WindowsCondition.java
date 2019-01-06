package com.atguigu.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Windows ϵͳ
 * @author w1812
 *
 */
public class WindowsCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		System.out.println(env.getProperty("os.name"));
		if(env.getProperty("os.name").equals("Windows 10")){
			return true;
		}
		return false;
	}

}
