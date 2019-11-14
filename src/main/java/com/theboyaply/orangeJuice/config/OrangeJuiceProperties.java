package com.theboyaply.orangeJuice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-14
 * @description
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "oj")
public class OrangeJuiceProperties {

    /**
     * 文件存放路径
     */
    private String filePath;

    /**
     * nginx代理路径
     */
    private String fileUrlPath;

}
