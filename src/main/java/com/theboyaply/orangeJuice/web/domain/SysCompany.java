package com.theboyaply.orangeJuice.web.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统公司(SysCompany)实体类
 *
 * @author tba
 * @since 2019-11-14 10:08:15
 */
@Data
@TableName(value = "sys_company")
@ApiModel("系统公司")
public class SysCompany {

    @ApiModelProperty(value = "主键ID")
    @TableField("id")
    @TableId
    private Long id;

    @ApiModelProperty(value = "公司编码")
    @TableField("company_code")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    @TableField("company_name")
    private String companyName;

    @ApiModelProperty(value = "公司简介")
    @TableField("company_desc")
    private String companyDesc;

    @ApiModelProperty(value = "公司地点")
    @TableField("company_area")
    private String companyArea;

    @ApiModelProperty(value = "图片地址")
    @TableField(exist = false)
    private String companyImage;

}