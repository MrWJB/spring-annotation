package com.atguigu.beans;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@PropertySource(value={"classpath:/db.properties"})
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{
	
	@Value(value="${db.user}")
	private String user;
	private StringValueResolver resolver; 
	
	private String driverClass;

	@Bean
	public Person person(){
		return new Person();
	}
	
	/**
	 * 测试环境
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	@Profile("test")
	@Bean("test")
	public DataSource dataSourceTest(@Value(value = "${db.pwd}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql:/localhost:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	/**
	 * 开发环境
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	@Profile("dev")
	@Bean("dev")
	public DataSource dataSourceDev(@Value(value = "${db.pwd}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql:/localhost:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	
	/**
	 * 生产环境
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	@Profile("prod")
	@Bean("prod")
	public DataSource dataSourceProd(@Value(value = "${db.pwd}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver=resolver;
		this.driverClass=resolver.resolveStringValue("${db.driverClass}");
	}
	
}
