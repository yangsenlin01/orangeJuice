package com.theboyaply.orangeJuice.web.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.web.domain.SysGoods;
import com.theboyaply.orangeJuice.web.mapper.SysGoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品表(SysGoods)表服务
 *
 * @author tba
 * @since 2019-11-15 14:12:35
 */

@Service
@Slf4j
public class SysGoodsService extends ServiceImpl<SysGoodsMapper, SysGoods> {

    /**
     * 查询产品
     *
     * @param goodsName     产品名称
     * @param goodsDesc     产品描述
     * @param goodsTypeCode 产品类型
     * @return
     */
    public List<SysGoods> listGoods(String goodsName, String goodsDesc, String goodsTypeCode) {
        return baseMapper.listGoods(goodsName, goodsDesc, goodsTypeCode);
    }
}