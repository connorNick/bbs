package com.shareniu.bbs.dao;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.TopicReply;
import com.shareniu.bbs.interceptor.PageList;
import org.apache.ibatis.annotations.Param;

public interface TopicReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicReply record);

    int insertSelective(TopicReply record);

    TopicReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicReply record);

    int updateByPrimaryKey(TopicReply record);

    PageList<TopicReply> findTopicReplyList(@Param("vo") PageVo vo, Pageable pageable);
}