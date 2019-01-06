package com.atguigu.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * linuxϵͳ
 * @author w1812
 *
 */
public class LinuxCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		String name = env.getProperty("os.name");
		if("linux".equals(name)){
			return true;
		}
		return false;
	}

}
