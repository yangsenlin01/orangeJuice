package com.theboyaply.orangeJuice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */
@SpringBootApplication
@ComponentScan(value = "com.theboyaply.orangeJuice")
@MapperScan("com.theboyaply.orangeJuice.**.mapper")
public class OrangeJuiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeJuiceApplication.class, args);
    }

}
