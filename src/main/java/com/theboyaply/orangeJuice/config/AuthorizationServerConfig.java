package com.theboyaply.orangeJuice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description 开启认证服务器
 * 获取token
 * 1、浏览器访问http://localhost:8080/oauth/authorize?client_id=client&response_type=code并授权，拿到授权码
 * 2、post方式访问http://localhost:8080/oauth/token?grant_type=authorization_code&code=mg5p7Q&client_id=client
 * 其中参数为：
 * grant_type=authorization_code // 授权码方式获取token
 * client_id=client // 认证服务器分配的client_id
 * code=mg5p7Q  // 步骤1获取到的code
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public TokenStore tokenStore() {
        // token交给jdbc管理
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        // client交给jdbc管理->oauth_client_details表
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 在内存中管理client
        /* clients.inMemory()
                .withClient("client")
                .secret(bCryptPasswordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app")
                .redirectUris("http://www.theboyaply.cn");*/
        // 交给jdbc管理client
        clients.withClientDetails(jdbcClientDetails());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // token交给jdbc管理
        endpoints.tokenStore(tokenStore());
    }
}
