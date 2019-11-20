package com.theboyaply.orangeJuice.web.controller;

import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.domain.SysCompany;
import com.theboyaply.orangeJuice.web.service.SysCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统公司(SysCompany)表控制层
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */

@CrossOrigin
@Api(tags = SwaggerConfig.COMPANY)
@RestController("adminSysCompanyController")
@RequestMapping("/admin/sysCompany")
public class AdminSysCompanyController {

    @Autowired
    private SysCompanyService sysCompanyService;

    @ApiOperation(value = "更改公司信息")
    @PostMapping
    public ResponseResult updateCompany(@ApiParam("公司信息") @RequestBody SysCompany sysCompany) {
        if (sysCompany.getId() == null) {
            return ResponseResult.ok(400, "ID不能为空");
        }
        if (StringUtils.isEmpty(sysCompany.getCompanyCode())) {
            return ResponseResult.ok(400, "公司编码不能为空");
        }
        if (StringUtils.isEmpty(sysCompany.getCompanyName())) {
            return ResponseResult.ok(400, "公司名称不能为空");
        }
        if (sysCompanyService.selectById(sysCompany.getId()) == null) {
            return ResponseResult.ok(400, "未根据ID找到值");
        }
        sysCompanyService.updateById(sysCompany);
        return ResponseResult.ok(sysCompany);
    }

}