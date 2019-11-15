package com.theboyaply.orangeJuice.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.domain.SysGoods;
import com.theboyaply.orangeJuice.web.service.SysGoodsService;
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
 * 产品表(SysGoods)表控制层
 *
 * @author tba
 * @since 2019-11-15 14:12:35
 */

@Api(tags = SwaggerConfig.GOODS)
@RestController("adminSysGoodsController")
@RequestMapping("/admin/sysGoods")
public class AdminSysGoodsController {

    @Autowired
    private SysGoodsService sysGoodsService;

    @ApiOperation("新增/更新产品")
    @PostMapping
    public ResponseResult insertOrUpdate(@ApiParam("产品名称") @RequestBody SysGoods sysGoods) {
        if (StringUtils.isEmpty(sysGoods.getGoodsName())
                || StringUtils.isEmpty(sysGoods.getGoodsCode())
                || StringUtils.isEmpty(sysGoods.getGoodsTypeCode())) {
            return ResponseResult.ok(400, "产品名称或分类不能为空");
        }
        SysGoods alreadyData = sysGoodsService.selectOne(new EntityWrapper<SysGoods>()
                .eq("goods_code", sysGoods.getGoodsCode()));
        if (alreadyData != null) {
            if (sysGoods.getId() == null || !sysGoods.getId().equals(alreadyData.getId())) {
                return ResponseResult.ok(400, "产品编码重复");
            }
        }
        sysGoodsService.insertOrUpdate(sysGoods);
        return ResponseResult.ok(sysGoods);
    }

}