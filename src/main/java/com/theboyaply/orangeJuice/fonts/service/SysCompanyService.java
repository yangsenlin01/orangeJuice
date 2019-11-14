package com.theboyaply.orangeJuice.fonts.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.fonts.domain.SysCompany;
import com.theboyaply.orangeJuice.fonts.mapper.SysCompanyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * 查询公司及其图片
     *
     * @return
     */
    public List<SysCompany> listCompanyAndImages() {
        return baseMapper.listCompanyAndImages();
    }

}