package com.theboyaply.orangeJuice.web.controller;

import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.web.service.SysGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-15
 * @description
 */

@Api(tags = SwaggerConfig.GOODS)
@RestController("fontsSysGoodsController")
@RequestMapping("/fonts/sysGoods")
public class FontsSysGoodsController {

    @Autowired
    private SysGoodsService sysGoodsService;

    @ApiOperation("查询产品")
    @GetMapping
    public ResponseResult listGoods(@ApiParam("产品名称") @RequestParam(value = "goodsName", required = false) String goodsName,
                                    @ApiParam("产品描述") @RequestParam(value = "goodsDesc", required = false) String goodsDesc,
                                    @ApiParam("产品类型") @RequestParam(value = "goodsTypeCode", required = false) String goodsTypeCode) {
        return ResponseResult.ok(sysGoodsService.listGoods(goodsName, goodsDesc, goodsTypeCode));
    }

}
