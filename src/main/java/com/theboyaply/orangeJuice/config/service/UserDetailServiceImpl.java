package com.theboyaply.orangeJuice.config.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.admin.domain.TbUser;
import com.theboyaply.orangeJuice.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description 自定义用户类，用于实现身份认证
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.selectOne(new EntityWrapper<TbUser>()
                .eq("username", username));
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (tbUser == null) {
            throw new UsernameNotFoundException("账号密码错误");
        }
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorityList);
    }
}
