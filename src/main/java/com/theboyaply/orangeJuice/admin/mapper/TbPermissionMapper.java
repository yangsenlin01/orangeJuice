package com.theboyaply.orangeJuice.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.theboyaply.orangeJuice.admin.domain.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */
public interface TbPermissionMapper extends BaseMapper<TbPermission> {

    /**
     * 根据用户ID查询用户权限
     *
     * @param userId
     * @return
     */
    List<TbPermission> selectByUserId(@Param("userId") Long userId);

}
