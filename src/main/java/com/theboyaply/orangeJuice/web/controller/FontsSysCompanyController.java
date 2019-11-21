package com.theboyaply.orangeJuice.web.controller;

import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.service.SysCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("获取公司及其图片")
    @GetMapping
    public ResponseResult listCompanyAndImages() {
        return ResponseResult.ok(sysCompanyService.listCompanyAndImages());
    }

}