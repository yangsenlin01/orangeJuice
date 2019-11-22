package com.theboyaply.orangeJuice.web.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.theboyaply.orangeJuice.web.domain.SysFile;
import com.theboyaply.orangeJuice.web.domain.SysGoods;
import com.theboyaply.orangeJuice.web.enums.BizTypeEnum;
import com.theboyaply.orangeJuice.web.mapper.SysGoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysFileService sysFileService;

    /**
     * 查询产品
     *
     * @param goodsName     产品名称
     * @param goodsDesc     产品描述
     * @param goodsTypeCode 产品类型
     * @return
     */
    public List<SysGoods> listGoods(String goodsName, String goodsDesc, String goodsTypeCode) {
        List<SysGoods> sysGoodsList = baseMapper.listGoods(goodsName, goodsDesc, goodsTypeCode);
        boolean querySysFileFlag = false;
        SysFile sysFile = null;
        if (CollectionUtils.isNotEmpty(sysGoodsList)) {
            for (SysGoods sysGoods : sysGoodsList) {
                if (StringUtils.isEmpty(sysGoods.getGoodsImages())) {
                    if (!querySysFileFlag) {
                        querySysFileFlag = true;
                        sysFile = sysFileService.selectOne(new EntityWrapper<SysFile>()
                                .eq("biz_id", 1)
                                .eq("biz_type", BizTypeEnum.GOODS.getType()));
                    }
                    if (sysFile != null) {
                        sysGoods.setGoodsImages(sysFile.getFileUrl());
                    }
                }
            }
        }
        return sysGoodsList;
    }
}