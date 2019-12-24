package org.rudty.dbconnection.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig3 {

    @Bean
    public DataSource dataSource3() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:~/db3")
                .build();
    }

    @Bean("datasource3jdbctemplate")
    JdbcTemplate datasource3jdbctemplate() {
        return new JdbcTemplate(dataSource3());
    }
}
