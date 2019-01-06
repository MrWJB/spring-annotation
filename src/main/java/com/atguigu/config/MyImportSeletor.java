package com.atguigu.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * �Զ���importSelect ����
 * @author w1812
 *
 */
public class MyImportSeletor implements ImportSelector {

	/**
	 * AnnotationMetadata: ��ǰ��ע��@Importע���������ע����Ϣ
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.atguigu.beans.Yellow","com.atguigu.beans.Blue"};
	}

}
