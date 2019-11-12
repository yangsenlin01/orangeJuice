package com.theboyaply.orangeJuice.admin.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-12
 * @description
 */

@Data
@TableName("tb_role")
public class TbRole {

    @TableId
    private Long id;

    @TableField("parent_id")
    private Long parentId;

    @TableField("name")
    private String name;

    @TableField("enname")
    private String enname;

    @TableField("description")
    private String description;

    @TableField("created")
    private ZonedDateTime created;

    @TableField("updated")
    private ZonedDateTime updated;
}
