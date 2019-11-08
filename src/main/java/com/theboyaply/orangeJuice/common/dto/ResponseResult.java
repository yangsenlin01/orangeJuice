package com.theboyaply.orangeJuice.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-7
 * @description
 */

@ApiModel("请求结果封装类")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "结果描述")
    private String message;

    @ApiModelProperty(value = "请求结果")
    private Object object;

    public static ResponseResult ok() {
        return ResponseResult.builder().code(200).build();
    }

    public static ResponseResult ok(Object object) {
        return ResponseResult.builder().code(200).object(object).build();
    }

    public static ResponseResult ok(Integer code, String message) {
        return ResponseResult.builder().code(code).message(message).build();
    }

    public static ResponseResult ok(Integer code, String message, Object object) {
        return ResponseResult.builder().code(code).message(message).object(object).build();
    }
}
