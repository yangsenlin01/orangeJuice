package com.theboyaply.orangeJuice.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-8
 * @description
 */

@Configuration
public class LiquibaseConfig {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db.liquibase/master.xml");
        liquibase.setContexts("development,test,production");
        liquibase.setShouldRun(true);
        return liquibase;
    }

}
