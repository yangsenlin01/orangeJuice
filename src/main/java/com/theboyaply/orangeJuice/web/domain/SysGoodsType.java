package com.theboyaply.orangeJuice.web.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 产品分类表(SysGoodsType)实体类
 *
 * @author tba
 * @since 2019-11-15 14:12:56
 */
@Data
@TableName(value = "sys_goods_type")
@ApiModel("产品分类表")
public class SysGoodsType {

    @TableId
    @TableField("id")
    private Long id;

    @ApiModelProperty(value = "分类编码")
    @TableField("type_code")
    private String typeCode;

    @ApiModelProperty(value = "分类名称")
    @TableField("type_name")
    private String typeName;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_date")
    private ZonedDateTime createdDate;

}