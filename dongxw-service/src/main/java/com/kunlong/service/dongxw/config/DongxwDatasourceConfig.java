package com.kunlong.service.dongxw.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.kunlong.service.dongxw.consts.DongxwConsts;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.mybatis.hbatis.spring.HbatisSqlSessionDaoSupport;
// location =“classpath：/ properties / $ {spring.profiles .active：test} /some.properties“/>

@Configuration( "dongxwDatasourceConfig" )
//@PropertySource({"classpath:/datasource/datasource-${spring.profiles.active}.properties"})
//@PropertySource({"classpath:/datasource/datasource-dev.properties"})
public class DongxwDatasourceConfig extends DongxwConsts {

	@Qualifier("dongxwDataSource")
	@Bean(name = "dongxwDataSource")
	//@Bean(name = "primaryDataSource", destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource.dongxw")
	public DataSource primaryDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}

	@Bean(name = "dongxwSqlSessionFactory")
	@Primary
	public SqlSessionFactory primarySqlSessionFactory(@Qualifier("dongxwDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		List<Resource> resList = new ArrayList<Resource>();
		for(String location:MYBATIS_MAPPER_LOCATIONS) {
			resList.addAll(Arrays.asList(resolver.getResources(location)));
			
		}
		bean.setMapperLocations(resList.toArray(new Resource[0]));
		
		SqlSessionFactory sessionFactory = bean.getObject();
		sessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
		//HbatisSqlSessionDaoSupport.setHbatisSessionFactory(sessionFactory);
		return sessionFactory;
	}


	@Bean(name = "dongxwMapperScannerConfigurer")
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("dongxwSqlSessionFactory");
		mapperScannerConfigurer.setBasePackage(MYBATIS_BASE_PACKAGE);

		return mapperScannerConfigurer;
	}

	@Bean(name = "dongxwTransactionManager")
	@Primary
	public DataSourceTransactionManager primaryTransactionManager(
			@Qualifier("dongxwDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}