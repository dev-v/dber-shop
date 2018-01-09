package com.dber.shop.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dber.base.mybatis.plugin.pagination.PaginationInterceptor;
import com.dber.base.util.DBUtil;
import com.dber.base.util.JdbcPoolConfig;

/**
 * <li>文件名称: ShopService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("com.dber.shop.service")
@MapperScan(basePackages = { "com.dber.shop.mapper" })
public class ShopServiceConfig {
	@Bean
	@ConfigurationProperties(prefix = "dber.shop.service.mysql")
	public JdbcPoolConfig shopJdbcPoolConfig() {
		return new JdbcPoolConfig();
	}

	@Bean
	public DataSource shopDataSource() {
		DataSource shopDataSource = DBUtil.dataSource(shopJdbcPoolConfig());
		return shopDataSource;
	}

	@Bean
	public DataSourceTransactionManager shopTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(shopDataSource());
		return transactionManager;
	}

	@Bean
	public org.apache.ibatis.session.Configuration shopMybatisConfiguration() {
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.getTypeAliasRegistry().registerAliases("com.dber.shop.api.entity");
		return configuration;
	}

	@Bean
	public SqlSessionFactoryBean shopSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean shopSqlSessionFactoryBean = new SqlSessionFactoryBean();

		shopSqlSessionFactoryBean.setDataSource(shopDataSource());

		shopSqlSessionFactoryBean.setConfiguration(shopMybatisConfiguration());

		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		shopSqlSessionFactoryBean
				.setMapperLocations(resourceResolver.getResources("classpath*:/mapper/*_mapper.xml"));

		Interceptor[] interceptors = { PaginationInterceptor.getInstance() };
		shopSqlSessionFactoryBean.setPlugins(interceptors);

		return shopSqlSessionFactoryBean;
	}
}
