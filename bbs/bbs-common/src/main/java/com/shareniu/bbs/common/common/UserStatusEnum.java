package com.shareniu.bbs.common.common;

import org.apache.commons.lang.StringUtils;

/**
 * 案件状态
 *
 */
public enum UserStatusEnum {

    NORMAL("正常"),

	FREEZE("冻结");

	String userStatus;

	UserStatusEnum(String userStatus) {
		this.userStatus = userStatus;
	}
	

	public static UserStatusEnum getByOrdinal(int i) {
		UserStatusEnum[] values = UserStatusEnum.values();
		for (UserStatusEnum userStatus : values) {
			if (i == userStatus.ordinal()) {
				return userStatus;
			}
		}
		return null;
	}
	public static UserStatusEnum getByName(String name) {
		UserStatusEnum[] values = UserStatusEnum.values();
		for (UserStatusEnum userStatus : values) {
			if (StringUtils.equalsIgnoreCase(name, userStatus.name())) {
				return userStatus;
			}
		}
		return null;
	}
}


