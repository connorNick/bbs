package com.shareniu.bbs.domain;

import java.util.Date;

public class TopicReply {
    private Integer id;

    private String content;

    private Integer userId;

    private Integer topicId;

    private Date createTime;

    private Integer parentRepayId;

    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getParentRepayId() {
        return parentRepayId;
    }

    public void setParentRepayId(Integer parentRepayId) {
        this.parentRepayId = parentRepayId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}