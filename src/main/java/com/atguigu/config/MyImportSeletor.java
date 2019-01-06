package com.atguigu.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义importSelect 方法
 * @author w1812
 *
 */
public class MyImportSeletor implements ImportSelector {

	/**
	 * AnnotationMetadata: 当前标注了@Import注解类的所有注解信息
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.atguigu.beans.Yellow","com.atguigu.beans.Blue"};
	}

}
