package com.shareniu.bbs.common.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 邮件类型
 *
 * Created by wzy on 2015/4/28.
 */
public enum EnumDirectoryType {
    TECHNIQUE("technique_category","技术类型列表"),
    TOPIC("topic_category", "发表类型");

    private String code;
    private String desc;

    EnumDirectoryType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static final Map<String, String> enumDataMap = new HashMap<String, String>();

    public static Map<String, String> toMap() {
        if (enumDataMap.size() == 0 && values().length > 0) {
            for (EnumDirectoryType attrValType : values()) {
                enumDataMap.put(attrValType.getCode(), attrValType.getDesc());
            }
        }
        return enumDataMap;
    }
}