package com.atguigu.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter{

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		//获取当前类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前类的资源信息
		Resource resource = metadataReader.getResource();
		//获取当前类的名称
		String className = annotationMetadata.getClassName();
//		System.out.println(className);
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}
