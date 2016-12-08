package com.rest.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by ezequ on 12/3/2016.
 */

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:eagleDB.properties"})
public class HibernateConfig {

    @Autowired
    private Environment environment;


    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
        properties.put("practica.show_sql",environment.getRequiredProperty("practica.show_sql"));
        properties.put("practica.format_sql",environment.getRequiredProperty("practica.format_sql"));

        return properties;
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("practica.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("practica.url"));
        dataSource.setUsername(environment.getRequiredProperty("practica.username"));
        dataSource.setPassword(environment.getRequiredProperty("practica.pass"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"com.rest.model"});
        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
