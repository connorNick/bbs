package com.shareniu.bbs.common.constants;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public enum DirctionaryEnum {
    TOPIC_CATEGORY("topic_category","主题类型");

    String name;
    String desc;
    DirctionaryEnum(String name,String desc) {
        this.name = name;
        this.desc=desc;
    }

    public static DirctionaryEnum getByOrdinal(int i) {
        DirctionaryEnum[] values = DirctionaryEnum.values();
        for (DirctionaryEnum name : values) {
            if (i == name.ordinal()) {
                return name;
            }
        }
        return null;
    }

    /*public static DirctionaryEnum getByName(String name) {
        DirctionaryEnum[] values = DirctionaryEnum.values();
        for (DirctionaryEnum dic : values) {
            if (StringUtils.equalsIgnoreCase(name, dic.name())) {
                return dic;
            }
        }
        return null;
    }*/
}
