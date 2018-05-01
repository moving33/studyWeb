package com.j.spring.configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * MyBatis 설정 빈
 * <p>
 * MapperScan은 spring.examples.module 패키지 이하에서 {@link spring.examples.core.mybatis.Mapper}
 * 애노테이션이 선언된 클래스를 찾아 스프링 빈으로 등록한다.
 */
@Configuration
@PropertySource(value = {"classpath:db/applicationDB.properties"})
public class DataConfig {

    @Autowired
    private Environment env;


    //mybatis 연동
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        System.out.println("dataSource....!!!!!!!");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(ApplicationContext context) throws Exception {
        // InputStream inputStream = Resources.getResourceAsStream(resourceURI);
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //sessionFactoryBean.setConfigLocation(new ClassPathResource(resourceURI));
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setConfigLocation(context.getResource(
                "classpath:db/configuration.xml"
        ));
        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}




