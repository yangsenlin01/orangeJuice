package com.theboyaply.orangeJuice.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */

@Data
@ApiModel("系统用户")
public class UserDTO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮件")
    private String email;

}
