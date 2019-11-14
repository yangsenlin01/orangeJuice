package com.theboyaply.orangeJuice.admin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.admin.domain.SysFile;
import com.theboyaply.orangeJuice.admin.mapper.SysFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 系统文件(SysFile)表服务
 *
 * @author tba
 * @since 2019-11-14 17:40:32
 */

@Service
@Slf4j
public class SysFileService extends ServiceImpl<SysFileMapper, SysFile> {
}