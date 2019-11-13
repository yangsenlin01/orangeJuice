package com.theboyaply.orangeJuice.admin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.admin.domain.SysUser;
import com.theboyaply.orangeJuice.admin.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */

@Service
@Slf4j
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {
}
