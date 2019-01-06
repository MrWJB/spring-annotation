package com.atguigu.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.beans.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition beanDefination=new RootBeanDefinition(RainBow.class);
		if(registry.containsBeanDefinition("com.atguigu.beans.Color")){
			registry.registerBeanDefinition("rainRow", beanDefination);
		}
	}

}
