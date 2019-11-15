package com.theboyaply.orangeJuice.web.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.theboyaply.orangeJuice.web.domain.SysGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品表(SysGoods)表数据库访问层
 *
 * @author tba
 * @since 2019-11-15 14:12:35
 */
public interface SysGoodsMapper extends BaseMapper<SysGoods> {

    /**
     * 查询指定分类的产品
     *
     * @param goodsName     产品名称
     * @param goodsDesc     产品描述
     * @param goodsTypeCode 分类Code
     * @return
     */
    List<SysGoods> listGoods(@Param("goodsName") String goodsName,
                             @Param("goodsDesc") String goodsDesc,
                             @Param("goodsTypeCode") String goodsTypeCode);
}