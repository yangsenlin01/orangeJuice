package com.theboyaply.orangeJuice.controller;

import com.theboyaply.orangeJuice.config.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Value("${my.hello}")
    private String name;

    @ApiOperation(value = "say hello")
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello" + name;
    }

}
