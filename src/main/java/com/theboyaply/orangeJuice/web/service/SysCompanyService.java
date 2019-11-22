package com.theboyaply.orangeJuice.web.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.theboyaply.orangeJuice.web.domain.SysCompany;
import com.theboyaply.orangeJuice.web.domain.SysFile;
import com.theboyaply.orangeJuice.web.enums.BizTypeEnum;
import com.theboyaply.orangeJuice.web.mapper.SysCompanyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统公司(SysCompany)表服务
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */

@Service
@Slf4j
public class SysCompanyService extends ServiceImpl<SysCompanyMapper, SysCompany> {

    @Autowired
    private SysFileService sysFileService;

    /**
     * 查询公司及其图片
     *
     * @return
     */
    public List<SysCompany> listCompanyAndImages() {
        List<SysCompany> sysCompanyList = baseMapper.listCompanyAndImages();
        boolean querySysFileFlag = false;
        SysFile sysFile = null;
        if (CollectionUtils.isNotEmpty(sysCompanyList)) {
            for (SysCompany sysCompany : sysCompanyList) {
                if (StringUtils.isEmpty(sysCompany.getCompanyImage())) {
                    if (!querySysFileFlag) {
                        querySysFileFlag = true;
                        sysFile = sysFileService.selectOne(new EntityWrapper<SysFile>()
                                .eq("biz_id", 1)
                                .eq("biz_type", BizTypeEnum.COMPANY.getType()));
                    }
                    if (sysFile != null) {
                        sysCompany.setCompanyImage(sysFile.getFileUrl());
                    }
                }
            }
        }
        return sysCompanyList;
    }

}