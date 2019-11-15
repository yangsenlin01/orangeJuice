package com.theboyaply.orangeJuice.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.domain.SysGoodsType;
import com.theboyaply.orangeJuice.web.service.SysGoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品分类表(SysGoodsType)表控制层
 *
 * @author tba
 * @since 2019-11-15 14:12:56
 */

@Api(tags = SwaggerConfig.GOODS_TYPE)
@RestController("adminSysGoodsTypeController")
@RequestMapping("/admin/sysGoodsType")
public class AdminSysGoodsTypeController {

    @Autowired
    private SysGoodsTypeService sysGoodsTypeService;

    @ApiOperation("新增/更新分类")
    @PostMapping
    public ResponseResult insertOrUpdate(@RequestBody SysGoodsType sysGoodsType) {
        if (StringUtils.isEmpty(sysGoodsType.getTypeCode())
                || StringUtils.isEmpty(sysGoodsType.getTypeName())) {
            return ResponseResult.ok(400, "分类编码或名称不能为空");
        }
        SysGoodsType alreadyData = sysGoodsTypeService.selectOne(new EntityWrapper<SysGoodsType>()
                .eq("type_code", sysGoodsType.getTypeCode()));
        if (alreadyData != null) {
            if (sysGoodsType.getId() == null || !sysGoodsType.getId().equals(alreadyData.getId())) {
                return ResponseResult.ok(400, "分类编码重复");
            }
        }
        sysGoodsTypeService.insertOrUpdate(sysGoodsType);
        return ResponseResult.ok(sysGoodsType);
    }
}