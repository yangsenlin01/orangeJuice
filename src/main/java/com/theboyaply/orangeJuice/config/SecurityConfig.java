package com.theboyaply.orangeJuice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-8
 * @description security配置
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        // spring boot 2.1之后默认需要密码加密，否则验证登录身份时会报错找不到加密方式There is no PasswordEncoder mapped for the id "null"
        return new BCryptPasswordEncoder();
    }

    /**
     * 在内存中创建用户
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("user").password(bCryptPasswordEncoder().encode("123456")).roles("USER");
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
//    }

}
