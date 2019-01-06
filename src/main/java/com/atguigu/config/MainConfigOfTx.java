package com.atguigu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableTransactionManagement
@Configuration
@PropertySource(value="classpath:/db.properties")
@ComponentScan(basePackages={"com.atguigu"})
public class MainConfigOfTx implements EmbeddedValueResolverAware{
	
	@Value("${db.user}")
	private String user;
	private StringValueResolver resolver;
	private String driverClass;

	@Bean
	public DataSource dataSource(@Value(value="${db.password}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver=resolver;
		this.driverClass=resolver.resolveStringValue("${db.driverClass}");
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){ 
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}
}
