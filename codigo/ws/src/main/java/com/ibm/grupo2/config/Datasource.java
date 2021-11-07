package com.ibm.grupo2.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Ana Olvera
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.ibm.grupo2"},
                        transactionManagerRef = "transactionManagerO", entityManagerFactoryRef = "entityManagerFactoryO")
@ComponentScan({"com.ibm.grupo2"})
public class Datasource implements WebMvcConfigurer{
    
    @Autowired
    private Environment env;

    public Datasource() {
        super();
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryO(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceO());
        em.setPackagesToScan(new String[]{"com.ibm.grupo2.model"});
        em.setPersistenceUnitName("supermercadoPU");        
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalPropertiesO());
        return em;
    }
    
    @Bean
    public DataSource dataSourceO() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.mysql.driver.class"));
        dataSource.setUrl(env.getProperty("spring.datasource.mysql.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.mysql.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.mysql.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManagerO(final EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationO() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalPropertiesO() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }
}
