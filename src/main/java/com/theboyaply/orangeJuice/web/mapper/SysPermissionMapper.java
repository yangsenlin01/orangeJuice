package com.theboyaply.orangeJuice.web.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.theboyaply.orangeJuice.web.domain.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限表(SysPermission)表数据库访问层
 *
 * @author tba
 * @since 2019-12-05 21:55:16
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据用户ID查询用户权限
     *
     * @param userId
     * @return
     */
    List<SysPermission> selectPermissionByUserId(@Param("userId") Long userId);

}