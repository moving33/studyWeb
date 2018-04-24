package com.j.ch17.spring.transactionTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//아래클래스가 스프링의 설정(xml대체)으로 사용됨을 의미
@Configuration
@ComponentScan
public class AppConfig {
    //DataSource 얻어내는녀석
    /*@Bean
    public DataSource myOracleDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("hr");
        ds.setPassword("hr");
        return ds;
    }*/

    @Bean
    public DataSource h2DataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(org.h2.Driver.class.getName());
        ds.setUrl("jdbc:h2:tcp://localhost/~/test");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }


    //얻어낸 DataSource로 Spring의 PlatformTransactionManager를 구현하는
    // jdbc 기반의 DataSourceTransactionManager 구현객체 생성
    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager
                = new DataSourceTransactionManager();
        transactionManager.setDataSource(h2DataSource());
        return transactionManager;
    }

}
