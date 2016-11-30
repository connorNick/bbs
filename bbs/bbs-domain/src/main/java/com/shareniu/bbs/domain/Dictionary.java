package com.shareniu.bbs.domain;

import java.util.Date;

public class Dictionary {
    private Integer id;

    private String type;

    private String rmsKey;

    private String rmsValue;

    private String description;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Byte delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRmsKey() {
        return rmsKey;
    }

    public void setRmsKey(String rmsKey) {
        this.rmsKey = rmsKey == null ? null : rmsKey.trim();
    }

    public String getRmsValue() {
        return rmsValue;
    }

    public void setRmsValue(String rmsValue) {
        this.rmsValue = rmsValue == null ? null : rmsValue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}