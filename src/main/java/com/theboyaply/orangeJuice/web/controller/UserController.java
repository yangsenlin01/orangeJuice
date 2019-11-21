package com.theboyaply.orangeJuice.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.domain.SysUser;
import com.theboyaply.orangeJuice.web.dto.UserDTO;
import com.theboyaply.orangeJuice.web.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */

@Api(tags = SwaggerConfig.ADMIN_USER)
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MapperFacade mapperFacade;

    @GetMapping
    @ApiOperation(value = "查询所有用户")
    public ResponseResult listUser() {
        List<SysUser> sysUserList = sysUserService.selectList(new EntityWrapper<>());
        return ResponseResult.ok(mapperFacade.mapAsList(sysUserList, UserDTO.class));
    }

}
