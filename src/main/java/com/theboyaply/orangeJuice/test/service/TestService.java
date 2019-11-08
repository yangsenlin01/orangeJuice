package com.theboyaply.orangeJuice.test.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.theboyaply.orangeJuice.test.domain.Test;
import com.theboyaply.orangeJuice.test.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */

@Service
@Slf4j
public class TestService extends ServiceImpl<TestMapper, Test> {
}
