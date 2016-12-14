package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.dao.TopicMapper;
import com.shareniu.bbs.dao.TopicReplyMapper;
import com.shareniu.bbs.domain.TopicReply;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.TopicReplyService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@Service
public class TopicReplyServiceImpl implements TopicReplyService{

    @Autowired
    private TopicReplyMapper topicReplyMapper;

    @Autowired
    private TopicMapper topicMapper;
    public int add(TopicReply topicReply) {
        topicReply.setCreateTime(new Date());
        topicMapper.updateCountAddById(topicReply.getTopicId());
        return topicReplyMapper.insert(topicReply);
    }

    public PageList<TopicReply> findTopicReplyList(PageVo vo){
        return topicReplyMapper.findTopicReplyList(vo,vo.getPageable());
    }
}
