package com.theboyaply.orangeJuice.config.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.web.domain.SysUser;
import com.theboyaply.orangeJuice.web.service.SysUserService;
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
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectOne(new EntityWrapper<SysUser>()
                .eq("username", username));
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (sysUser == null) {
            throw new UsernameNotFoundException("账号密码错误");
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), grantedAuthorityList);
    }
}
