package com.example.demo.druid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfiguration {

	@Value("${spring.datasource.druid.url}")
	private String connectionUrl;
	@Value("${spring.datasource.druid.name}")
	private String name;
	@Value("${spring.datasource.druid.username}")
	private String username;
	@Value("${spring.datasource.druid.password}")
	private String password;
	@Value("${spring.datasource.druid.initial-size}")
	private Integer initialSize;
	@Value("${spring.datasource.druid.minIdle}")
	private Integer minIdle;
	@Value("${spring.datasource.druid.maxActive}")
	private Integer maxActive;
	@Value("${spring.datasource.druid.maxWait}")
	private Integer maxWait;
	@Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
	private Integer timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;
	@Value("${spring.datasource.druid.validationQuery}")
	private String validationQuery;
	@Value("${spring.datasource.druid.testWhileIdle}")
	private Boolean testWhileIdle;
	@Value("${spring.datasource.druid.testOnBorrow}")
	private Boolean testOnBorrow;
	@Value("${spring.datasource.druid.testOnReturn}")
	private Boolean testOnReturn;
	@Value("${spring.datasource.druid.poolPreparedStatements}")
	private Boolean poolPreparedStatements;
	@Value("${spring.datasource.druid.max-pool-prepared-statement-per-connection-size}")
	private Integer maxPoolPreparedStatementPerConnectionSize;
	@Value("${spring.datasource.druid.filters}")
	private String filters;

	@Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
	public DruidDataSource initDataSource() {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dds.setName(name);
		dds.setUrl(connectionUrl);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setInitialSize(initialSize);
		dds.setMinIdle(minIdle);
		dds.setMaxActive(maxActive);
		dds.setMaxWait(maxWait);
		dds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dds.setValidationQuery(validationQuery);
		dds.setTestWhileIdle(testWhileIdle);
		dds.setTestOnBorrow(testOnBorrow);
		dds.setTestOnReturn(testOnReturn);
		dds.setPoolPreparedStatements(poolPreparedStatements);
		dds.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			dds.setFilters(filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dds;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");
		// servletRegistrationBean.addInitParameter("loginUsername",loginUsername);
		// servletRegistrationBean.addInitParameter("loginPassword",loginPassword);
		return servletRegistrationBean;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

}
