package org.rudty.dbconnection.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        basePackages= "org.rudty.dbconnection.repository2",
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager2")
public class DatabaseConfig2 {

    @Bean
    public DataSource dataSource2() {
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
