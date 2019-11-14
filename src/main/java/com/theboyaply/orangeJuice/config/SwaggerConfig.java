package com.theboyaply.orangeJuice.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


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
    public static final String COMMON = "COMMON";
    public static final String ADMIN_USER = "ADMIN_USER";
    public static final String COMPANY = "COMPANY";

    private static final Predicate<RequestHandler> TEST_SELECTOR = RequestHandlerSelectors.basePackage("com.theboyaply.orangeJuice.test.controller");
    private static final Predicate<RequestHandler> ADMIN_SELECTOR = RequestHandlerSelectors.basePackage("com.theboyaply.orangeJuice.admin.controller");
    private static final Predicate<RequestHandler> FONTS_SELECTOR = RequestHandlerSelectors.basePackage("com.theboyaply.orangeJuice.fonts.controller");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 需要扫描的api的controller包
                // .apis(RequestHandlerSelectors.any())
                .apis(Predicates.or(TEST_SELECTOR, FONTS_SELECTOR, ADMIN_SELECTOR))
                // 需要扫描api的请求路径
                // .paths(PathSelectors.ant("/test/*"))
                .paths(PathSelectors.any())
                .build()
                // 开启swagger全局授权，即出现一个全局授权按钮
                .securitySchemes(securitySchemes())
                // 配置全局授权影响的路径
                .securityContexts(securityContexts())
                .apiInfo(apiInfo())
                .tags(new Tag(TEST, "测试Tag"))
                .tags(new Tag(COMMON, "通用Controller"))
                .tags(new Tag(ADMIN_USER, "系统用户"))
                .tags(new Tag(COMPANY, "系统公司"));
    }

    /**
     * 全局授权请求时带的参数
     * 如果不使用全局参数传token，可以使用这个注解，单独添加在接口方法上。
     *     @ApiImplicitParams({
     *         @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", required = false)
     *     })
     *
     * @return
     */
    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        // 需要受全局授权参数影响的路径。即，这个路径下的请求才会自动添加授权参数
                        //.forPaths(PathSelectors.regex("^(?!test).*$"))
                        .forPaths(PathSelectors.ant("/admin/**"))
                        .build()
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }

    /**
     * swagger描述信息
     *
     * @return
     */
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
