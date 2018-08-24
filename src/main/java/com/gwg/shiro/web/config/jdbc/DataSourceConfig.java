package com.gwg.shiro.web.config.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * MyBatis基础配置
 * @author Administrator
 *
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig{
	
	/**
	 * 
	 * @Title: 生成一个名字为  dataSource的bean
	 * @Description: 数据源的配置  
	 * @param: @return      
	 * @return: DataSource      
	 * @throws
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}
	
	/**
	 * 生成一个名字为 sqlSessionFactory 的bean
	 * mybatis的sqlSessionFactory配置
	 * @param dataSource
	 */
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	bean.setDataSource(dataSource);
    	bean.setTypeAliasesPackage("com.gwg.shiro.web.model");
    	
    	ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); 
    	try {
			bean.setMapperLocations(resolver.getResources("classpath*:com/gwg/shiro/web/mapper/*.xml"));
		} catch (IOException e) {
			e.printStackTrace();	
		}
    	return bean.getObject();
    }
	
    
 /*   @Bean
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
    	return new SqlSessionTemplate(sqlSessionFactory);
    }
    */
	
	/**
	 * 生成一个名字为mapperScannerConfigurer的bean
	 * mapper接口扫描包
	 */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		configurer.setBasePackage("com.gwg.shiro.web.mapper");
		return configurer;
	}
	
    
    /**
	 * 
	 * @Title: transactionManager   
	 * @Description: 配置事务管理器
	 * @param: @param dataSource
	 * @return: DataSourceTransactionManager      
	 */
/*	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource)
			throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}
*/

}
