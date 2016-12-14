package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.TopicReply;
import com.shareniu.bbs.interceptor.PageList;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public interface TopicReplyService {
    int add(TopicReply topicReply);
    PageList<TopicReply> findTopicReplyList(PageVo vo);
}
