package org.rudty.dbconnection.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableConfigurationProperties
@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = "org.rudty.dbconnection.repository1",
        entityManagerFactoryRef = "entityManagerFactory1",
        transactionManagerRef = "transactionManager1")
public class DatabaseConfig1 {

    @Bean(name="datasourceProperties1")
    @Primary
    @ConfigurationProperties(prefix = "org.rudtyz.db1.datasource")
    public DataSourceProperties datasourceProperties1() {
        // application.properties 에서 값의 할당은
        // new 로 생성된 순간이 아니라 반환 후 프레임워크에서 할당됩니다.
        // 여기에서 추가로 값을 사용하지 마세요
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource1() {
        DataSourceProperties prop = datasourceProperties1();
        return prop
                .initializeDataSourceBuilder()
                .build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(
            DataSource dataSource1,
            EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        return entityManagerFactoryBuilder.dataSource(dataSource1)
                .packages("org.rudty.dbconnection.entity1")
                .build();
    }

    @Primary
    @Bean
    PlatformTransactionManager transactionManager1(
            LocalContainerEntityManagerFactoryBean entityManagerFactory1,
            ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory1.getObject());
        transactionManagerCustomizers.ifAvailable((customizers) -> customizers.customize(transactionManager));
        return transactionManager;
    }
}
