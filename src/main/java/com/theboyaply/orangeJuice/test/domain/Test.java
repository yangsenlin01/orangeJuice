package com.theboyaply.orangeJuice.test.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */

@ApiModel(value = "测试对象")
@Data
@TableName("test")
public class Test {

    @TableId
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "测试名称")
    @TableField("test_name")
    private String testName;

    @ApiModelProperty(value = "测试数字")
    @TableField("test_number")
    private Integer testNumber;

    @ApiModelProperty(value = "测试日期")
    @TableField("test_date")
    private ZonedDateTime testDate;

}
