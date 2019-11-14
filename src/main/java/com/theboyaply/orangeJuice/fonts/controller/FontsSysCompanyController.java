package com.theboyaply.orangeJuice.fonts.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.fonts.domain.SysCompany;
import com.theboyaply.orangeJuice.fonts.service.SysCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统公司(SysCompany)表控制层
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */
@Api(tags = SwaggerConfig.COMPANY)
@RestController("fontsSysCompanyController")
@RequestMapping("/fonts/sysCompany")
public class FontsSysCompanyController {

    @Autowired
    private SysCompanyService sysCompanyService;

    @ApiOperation("获取公司信息")
    @GetMapping
    public ResponseResult getCompany() {
        List<SysCompany> sysCompanies = sysCompanyService.selectList(new EntityWrapper<>());
        if (sysCompanies.size() > 0) {
            return ResponseResult.ok(sysCompanies.get(0));
        } else {
            return ResponseResult.ok(new ArrayList<>());
        }
    }

}