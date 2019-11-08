package com.theboyaply.orangeJuice.test.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.theboyaply.orangeJuice.common.dto.ResponseResult;
import com.theboyaply.orangeJuice.config.SwaggerConfig;
import com.theboyaply.orangeJuice.test.domain.Test;
import com.theboyaply.orangeJuice.test.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */

@Api(tags = SwaggerConfig.TEST)
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "根据testName查询")
    @GetMapping("/{testName}")
    public ResponseResult getTestByTestName(@PathVariable("testName") String testName) {
        return ResponseResult.ok(testService.selectList(new EntityWrapper<Test>().eq("test_name", testName)));
    }

    @ApiOperation(value = "查询Test")
    @GetMapping("/list")
    public ResponseResult listTest() {
        List<Test> testList = testService.selectList(new EntityWrapper<Test>());
        return ResponseResult.ok(testList);
    }

    @ApiOperation(value = "分页查询Test")
    @GetMapping("/page")
    public ResponseResult pageTest(int page, int size) {
        Page mybatisPage = new Page(page, size);
        Page<Test> testList = testService.selectPage(mybatisPage);
        return ResponseResult.ok(testList.getRecords());
    }

    @ApiOperation(value = "添加Test")
    @PostMapping("/add")
    public ResponseResult addTest(@RequestBody Test test) {
        testService.insert(test);
        return ResponseResult.ok(test);
    }

}
