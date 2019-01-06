package com.atguigu.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void insertSql(){
		String sql = "INSERT INTO person (name,age) VALUES(?,?)";
		String username = UUID.randomUUID().toString().substring(0, 5);
		jdbcTemplate.update(sql, username,19);
//		int res=10/0;
		System.out.println("插入数据成功！");
	}
	
}
