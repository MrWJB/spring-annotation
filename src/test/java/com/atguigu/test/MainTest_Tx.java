package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfigOfTx;
import com.atguigu.service.BookService;

public class MainTest_Tx {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfTx.class);
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.insert();
		
	}

}
