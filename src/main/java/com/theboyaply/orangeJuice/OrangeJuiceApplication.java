package com.theboyaply.orangeJuice;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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

    /**
     * 自定义序列化，调用接口返回结果时，将Long类型转为String类型，避免精度丢失
     * (Swagger显示Long类型会丢失后两位精度，即后两位数字被0替换)
     *
     * @return
     */
    @Bean("jackson2ObjectMapperBuilderCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Jackson2ObjectMapperBuilderCustomizer customizer = jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance)
                .serializerByType(Long.TYPE, ToStringSerializer.instance);
        return customizer;
    }

    /**
     * 配置全局跨域放行
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource baseSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 支持安全证书
        corsConfiguration.setAllowCredentials(true);
        // 允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("*");
        // 预检请求的有效期/秒
        corsConfiguration.setMaxAge(3600L);
        // 匹配放行接口(这里放行所有接口)
        baseSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(baseSource);
    }
}
