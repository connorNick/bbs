package com.shareniu.bbs.common.common;

import org.apache.commons.lang.StringUtils;

/**
 * 案件状态
 *
 */
public enum RedisMessageTypeEnum {

    SMS("短信验证码"),

	EMAIL("邮箱验证码");


	String type;

	RedisMessageTypeEnum(String type) {
		this.type = type;
	}
	

	public static RedisMessageTypeEnum getByOrdinal(int i) {
		RedisMessageTypeEnum[] values = RedisMessageTypeEnum.values();
		for (RedisMessageTypeEnum type : values) {
			if (i == type.ordinal()) {
				return type;
			}
		}
		return null;
	}
	public static RedisMessageTypeEnum getByName(String name) {
		RedisMessageTypeEnum[] values = RedisMessageTypeEnum.values();
		for (RedisMessageTypeEnum type : values) {
			if (StringUtils.equalsIgnoreCase(name, type.name())) {
				return type;
			}
		}
		return null;
	}
}


