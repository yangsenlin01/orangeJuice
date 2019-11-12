package com.theboyaply.orangeJuice.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.admin.domain.TbUser;
import com.theboyaply.orangeJuice.admin.dto.UserDTO;
import com.theboyaply.orangeJuice.admin.service.TbUserService;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
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

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private MapperFacade mapperFacade;

    @GetMapping
    public ResponseResult listUser() {
        List<TbUser> tbUserList = tbUserService.selectList(new EntityWrapper<>());
        return ResponseResult.ok(mapperFacade.mapAsList(tbUserList, UserDTO.class));
    }
}
