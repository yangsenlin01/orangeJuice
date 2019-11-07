package com.theboyaply.orangeJuice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final String TEST = "TEST";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/test/*"))
                .build().apiInfo(apiInfo())
                .tags(new Tag(TEST, "测试Tag"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "橙汁广告",
                "Spring Boot 项目集成 Swagger 实例文档",
                "API V1.0",
                "Terms of service",
                new Contact("Contact", "", ""),
                "license", "", Collections.emptyList());
    }
}
