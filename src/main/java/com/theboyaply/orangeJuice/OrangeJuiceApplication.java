package com.theboyaply.orangeJuice;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.MapperFacadeImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */
@SpringBootApplication
@ComponentScan(value = "com.theboyaply.orangeJuice")
@MapperScan("com.theboyaply.orangeJuice.**.mapper")
public class OrangeJuiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeJuiceApplication.class, args);
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 更改spring boot默认的数据源，使用指定的配置(spring.datasource)生成一个新的数据源
        // @Primary：当spring中存在多个相同的bean时，优先使用被@Primary注解的bean
        return DataSourceBuilder.create().build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        // Spring Security 5.0 之前版本的 PasswordEncoder 接口默认实现为 NoOpPasswordEncoder
        // 此时是可以使用明文密码的，
        // 在 5.0 之后默认实现类改为 DelegatingPasswordEncoder 此时密码必须以加密形式存储。
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MapperFacade mapperFacade() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }
}
