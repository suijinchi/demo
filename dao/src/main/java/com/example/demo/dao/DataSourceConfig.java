package com.example.demo.dao;

import java.util.Properties;

import javax.sql.DataSource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @auther suijinchi
 * @description RDS数据源配置
 * @date 2022/3/18
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    protected static final String PACKAGE = "com.example.demo.dao.mapper";

    @Value("${demo.datasource.rds.mybatis.configFile}")
    private String configFile;

    @Value("${demo.datasource.rds.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "datasource", destroyMethod = "", initMethod = "")
    @ConfigurationProperties(prefix = "demo.datasource.rds")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * JdbcTemplate
     */
    @Bean(name = "namedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("datasource") DataSource datasource) {
        return new NamedParameterJdbcTemplate(datasource);
    }

    /**
     * 配置SqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource") DataSource datasource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(datasource);
        sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(configFile));
        sessionFactory.setPlugins(pageInterceptor(datasource));
        return sessionFactory.getObject();
    }

    private PageInterceptor pageInterceptor(DataSource dataSource) {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("datasource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }
}
