package com.shareniu.bbs.dao;

import com.shareniu.bbs.domain.TopicReply;

public interface TopicReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicReply record);

    int insertSelective(TopicReply record);

    TopicReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicReply record);

    int updateByPrimaryKey(TopicReply record);
}