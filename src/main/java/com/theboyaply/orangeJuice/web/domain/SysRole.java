package com.theboyaply.orangeJuice.web.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 角色表(SysRole)实体类
 *
 * @author tba
 * @since 2019-12-05 21:55:32
 */
@Data
@TableName(value = "sys_role")
@ApiModel("角色表")
public class SysRole {

    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "父角色")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "角色名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "角色英文名称")
    @TableField("enname")
    private String enname;

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