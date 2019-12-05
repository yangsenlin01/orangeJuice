package com.theboyaply.orangeJuice.web.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.web.domain.SysRole;
import com.theboyaply.orangeJuice.web.mapper.SysRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 角色表(SysRole)表服务
 *
 * @author tba
 * @since 2019-12-05 21:55:32
 */

@Service
@Slf4j
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {
}