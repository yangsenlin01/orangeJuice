package com.theboyaply.orangeJuice.fonts.controller;

import com.theboyaply.orangeJuice.fonts.service.SysCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统公司(SysCompany)表控制层
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */
@RestController
@RequestMapping("/fonts/sysCompany")
public class SysCompanyController {

    @Autowired
    private SysCompanyService sysCompanyService;

}