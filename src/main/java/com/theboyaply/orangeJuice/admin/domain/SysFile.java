package com.theboyaply.orangeJuice.admin.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.theboyaply.orangeJuice.admin.enums.BizTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 系统文件(SysFile)实体类
 *
 * @author tba
 * @since 2019-11-14 17:40:32
 */
@Data
@TableName(value = "sys_file")
@ApiModel("系统文件")
public class SysFile {

    @TableField("id")
    @TableId
    private Long id;

    @ApiModelProperty(value = "业务ID")
    @TableField("biz_id")
    private Long bizId;

    @ApiModelProperty(value = "业务类型")
    @TableField("biz_type")
    private BizTypeEnum bizType;

    @ApiModelProperty(value = "文件名")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "文件访问路径")
    @TableField("file_url")
    private String fileUrl;

    @ApiModelProperty(value = "文件存放路径")
    @TableField("file_path")
    private String filePath;

    @ApiModelProperty(value = "文件类型(后缀)")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty(value = "上传时间")
    @TableField("created_date")
    private ZonedDateTime createdDate;

}