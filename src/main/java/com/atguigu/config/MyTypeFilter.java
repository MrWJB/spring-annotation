package com.atguigu.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter{

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		//��ȡ��ǰ���ע����Ϣ
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//��ȡ��ǰ�����Դ��Ϣ
		Resource resource = metadataReader.getResource();
		//��ȡ��ǰ�������
		String className = annotationMetadata.getClassName();
//		System.out.println(className);
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}
