package com.theboyaply.orangeJuice.web.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 产品表(SysGoods)实体类
 *
 * @author tba
 * @since 2019-11-15 14:12:35
 */
@Data
@TableName(value = "sys_goods")
@ApiModel("产品表")
public class SysGoods {

    @TableId
    @TableField("id")
    private Long id;

    @ApiModelProperty(value = "产品名称")
    @TableField("goods_name")
    private String goodsName;

    @ApiModelProperty(value = "产品编码")
    @TableField("goods_code")
    private String goodsCode;

    @ApiModelProperty(value = "产品类型")
    @TableField("goods_type_code")
    private String goodsTypeCode;

    @ApiModelProperty(value = "产品描述")
    @TableField("goods_desc")
    private String goodsDesc;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_date")
    private ZonedDateTime createdDate;

    @ApiModelProperty(value = "产品图片")
    @TableField(exist = false)
    private String goodsImages;

}