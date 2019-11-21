package com.theboyaply.orangeJuice.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.domain.SysGoodsType;
import com.theboyaply.orangeJuice.web.service.SysGoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-15
 * @description
 */

@Api(tags = SwaggerConfig.GOODS_TYPE)
@RestController("fontsSysGoodsTypeController")
@RequestMapping("/fonts/sysGoodsType")
public class FontsSysGoodsTypeController {

    @Autowired
    private SysGoodsTypeService sysGoodsTypeService;

    @ApiOperation("获取所有分类")
    @GetMapping
    public ResponseResult listGoodsType(@ApiParam("分类编码") @RequestParam(value = "typeCode", required = false) String typeCode,
                                        @ApiParam("分类名称") @RequestParam(value = "typeName", required = false) String typeName) {
        List<SysGoodsType> sysGoodsTypeList = sysGoodsTypeService.selectList(new EntityWrapper<SysGoodsType>()
                .like(StringUtils.isNotEmpty(typeCode), "type_code", typeCode)
                .like(StringUtils.isNotEmpty(typeName), "type_name", typeName));
        return ResponseResult.ok(sysGoodsTypeList);
    }

}
