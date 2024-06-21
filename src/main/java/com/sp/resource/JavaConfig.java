package com.sp.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JavaConfig {
	
	@Bean
	public DriverManagerDataSource dmds() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
	        dataSource.setUsername("root");
	        dataSource.setPassword("Rooh@#2001");
	        return dataSource;
	}
	@Bean
	public JdbcTemplate jtmp() {
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(dmds());
		return jt;
	}

}
