package com.lingyi.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 咕噜科
 * ClassName: DBConfiguration
 * date: 2022-07-21 23:30
 * Description:
 * version 1.0
 */
@Configuration
public class DBConfiguration {

    @Value("${jdbc.datasource.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.datasource.url}")
    private String url;

    @Value("${jdbc.datasource.username}")
    private String username;

    @Value("${jdbc.datasource.password}")
    private String password;

    @Bean("dataSource")
    public DataSource dataSource () {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setPassword(password);
        druidDataSource.setUsername(username);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        mybatisSqlSessionFactoryBean.setMapperLocations();

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        mybatisSqlSessionFactoryBean.setConfiguration(configuration);
        mybatisSqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return mybatisSqlSessionFactoryBean.getObject();
    }

}
