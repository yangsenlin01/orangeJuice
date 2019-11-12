package com.theboyaply.orangeJuice.admin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.admin.domain.TbPermission;
import com.theboyaply.orangeJuice.admin.mapper.TbPermissionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */

@Service
@Slf4j
public class TbPermissionService extends ServiceImpl<TbPermissionMapper, TbPermission> {

    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    /**
     * 根据用户ID查询用户权限
     *
     * @param userId
     * @return
     */
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
