package com.shareniu.bbs.common.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 邮件类型
 *
 * Created by wzy on 2015/4/28.
 */
public enum EnumEmailType {
    TEXT(1, "文本邮件"),
    HTML(2, "html邮件");

    /**
     * 编码
     */
    private int code;

    /**
     * 值
     */
    private String lebel;

    EnumEmailType(int code, String label) {
        this.code = code;
        this.lebel = label;
    }

    /**
     * 比较
     *
     * @param code 编码
     * @return boolean
     */
    public boolean compare(int code) {
        return this.code == code;
    }


    /**
     * Gets 编码.
     *
     * @return Value of 编码.
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets 值.
     *
     * @return Value of 值.
     */
    public String getLebel() {
        return lebel;
    }

    /**
     * Sets new 编码.
     *
     * @param code New value of 编码.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Sets new 值.
     *
     * @param lebel New value of 值.
     */
    public void setLebel(String lebel) {
        this.lebel = lebel;
    }

    private static final Map<Integer, String> enumDataMap = new HashMap<Integer, String>();

    public static Map<Integer, String> toMap() {
        if (enumDataMap.size() == 0 && values().length > 0) {
            for (EnumEmailType attrValType : values()) {
                enumDataMap.put(attrValType.getCode(), attrValType.getLebel());
            }
        }

        return enumDataMap;
    }
}