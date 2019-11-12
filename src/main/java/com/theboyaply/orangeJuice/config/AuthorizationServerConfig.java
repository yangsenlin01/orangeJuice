package com.theboyaply.orangeJuice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret(bCryptPasswordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app")
                .redirectUris("http://www.theboyaply.cn");
    }
}
