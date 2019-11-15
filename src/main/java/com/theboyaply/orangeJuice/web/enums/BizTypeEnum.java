package com.theboyaply.orangeJuice.web.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-14
 * @description 业务类型
 */

public enum BizTypeEnum implements IEnum {

    /**
     * 公司
     */
    COMPANY("company", "公司");

    /**
     * 业务类型
     */
    private String type;

    /**
     * 类型描述
     */
    private String desc;

    BizTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    @JsonValue
    public String getDesc() {
        return desc;
    }

    @Override
    public Serializable getValue() {
        return this.type;
    }
}
