package com.theboyaply.orangeJuice.admin.controller;

import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.fonts.domain.SysCompany;
import com.theboyaply.orangeJuice.fonts.service.SysCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统公司(SysCompany)表控制层
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */

@Api(tags = SwaggerConfig.COMPANY)
@RestController("adminSysCompanyController")
@RequestMapping("/admin/sysCompany")
public class AdminSysCompanyController {

    @Autowired
    private SysCompanyService sysCompanyService;

    @ApiOperation(value = "新增公司")
    @PostMapping
    public ResponseResult addCompany(@ApiParam("公司信息") @RequestBody SysCompany sysCompany) {
        if (sysCompany.getId() != null) {
            return ResponseResult.ok(400, "不能对已存在的公司进行新增");
        }
        if (StringUtils.isEmpty(sysCompany.getCompanyCode())) {
            return ResponseResult.ok(400, "公司编码不能为空");
        }
        if (StringUtils.isEmpty(sysCompany.getCompanyName())) {
            return ResponseResult.ok(400, "公司名称不能为空");
        }
        sysCompanyService.insert(sysCompany);
        return ResponseResult.ok(sysCompany);
    }

}