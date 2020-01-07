package org.rudty.dbconnection.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
@EnableJpaRepositories(
        basePackages= "org.rudty.dbconnection.repository2",
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager2")
public class DatabaseConfig2 {

    @Bean(name="datasourceProperties2")
    @ConfigurationProperties(prefix = "org.rudtyz.db2.datasource")
    public DataSourceProperties datasourceProperties2() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource2() {
        // 사용은 하고 있지 않지만 예제의 도움을 위해서
        // 출력만 합니다
        System.out.println(datasourceProperties2().getUsername());
        System.out.println(datasourceProperties2().getUrl());
        System.out.println(datasourceProperties2().getDriverClassName());

        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb2")
                .build();
    }

    @Bean(name = "entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        return entityManagerFactoryBuilder.dataSource(dataSource2())
                .packages("org.rudty.dbconnection.entity2")
                .persistenceUnit("2")
                .build();
    }

    @Bean(name = "transactionManager2")
    PlatformTransactionManager transactionManager2(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory2(entityManagerFactoryBuilder).getObject());
        transactionManagerCustomizers.ifAvailable((customizers) -> customizers.customize(transactionManager));
        return transactionManager;
    }
}
