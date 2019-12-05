package com.theboyaply.orangeJuice.web.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.web.domain.SysPermission;
import com.theboyaply.orangeJuice.web.mapper.SysPermissionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 权限表(SysPermission)表服务
 *
 * @author tba
 * @since 2019-12-05 21:55:16
 */

@Service
@Slf4j
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission> {
}