package com.theboyaply.orangeJuice.web.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.web.domain.SysGoodsType;
import com.theboyaply.orangeJuice.web.mapper.SysGoodsTypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 产品分类表(SysGoodsType)表服务
 *
 * @author tba
 * @since 2019-11-15 14:12:56
 */

@Service
@Slf4j
public class SysGoodsTypeService extends ServiceImpl<SysGoodsTypeMapper, SysGoodsType> {
}