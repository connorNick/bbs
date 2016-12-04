package com.shareniu.bbs.domain;

import java.util.Date;

public class TopicReply {
    private Integer id;

    private String count;

    private Integer userId;

    private Integer topicId;

    private Date createTime;

    private Integer parentRepayId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
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
}