package com.jzfq.pms.enums;

/**
 * 支付方式枚举
 *
 * create by gw
 */
public enum RoleEnum {

	SUPER_ADMIN(1,"超级管理员"),
	ADMIN(2,"管理员");

	private int key;

	private String desc;

	private RoleEnum(int key, String desc){
		this.setKey(key);
		this.setDesc(desc);
	}
	
	public static RoleEnum getRoleEnumByKey(int key){
		for(RoleEnum bt : values()){
			if(bt.getKey() == key)
				return bt;
		}
		return null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
