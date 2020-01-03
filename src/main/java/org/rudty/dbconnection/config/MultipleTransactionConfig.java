package org.rudty.dbconnection.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class MultipleTransactionConfig {
    @Bean(name = "transactionManager1And2")
    public ChainedTransactionManager transactionManager(
            @Qualifier("transactionManager1")
            PlatformTransactionManager transactionManager1,

            @Qualifier("transactionManager2")
            PlatformTransactionManager transactionManager2) {

        return new ChainedTransactionManager(transactionManager1, transactionManager2);
    }

}
