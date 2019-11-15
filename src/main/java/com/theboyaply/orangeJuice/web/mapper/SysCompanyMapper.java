package com.theboyaply.orangeJuice.web.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.theboyaply.orangeJuice.web.domain.SysCompany;

import java.util.List;

/**
 * 系统公司(SysCompany)表数据库访问层
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */
public interface SysCompanyMapper extends BaseMapper<SysCompany> {

    /**
     * 查询公司及其图片
     *
     * @return
     */
    List<SysCompany> listCompanyAndImages();

}