package com.theboyaply.orangeJuice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        *//*
         * 1-->>
         * http.csrf();
         * ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
         * registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
         *
         * 2--->>
         * http.requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/rest/**", "/api/**", "/**")
         * .and()
         * .csrf().disable();
         *//*
        http.cors().and().csrf().disable();
    }*/

    @Override
    public void configure(WebSecurity web) {
        // 放开不需要校验的路径
        web.ignoring()
                // /oauth/token予请求
                .antMatchers(HttpMethod.OPTIONS, "/**")
                // 放开错误提示
                .antMatchers("/error/**")
                // 放开swagger2
                .antMatchers("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**")
                // 以下是业务公开请求API
                .antMatchers("/test/**")
                .antMatchers("/fonts/**");
    }
}
