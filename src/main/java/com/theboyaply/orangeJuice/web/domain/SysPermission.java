package com.theboyaply.orangeJuice.web.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 权限表(SysPermission)实体类
 *
 * @author tba
 * @since 2019-12-05 21:55:16
 */
@Data
@TableName(value = "sys_permission")
@ApiModel("权限表")
public class SysPermission {

    @TableId
    private Long id;

    @ApiModelProperty(value = "父权限")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "权限名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "权限英文名称")
    @TableField("enname")
    private String enname;

    @ApiModelProperty(value = "授权路径")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "备注")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_date")
    private ZonedDateTime createdDate;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updated_date")
    private ZonedDateTime updatedDate;

}