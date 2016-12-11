package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.interceptor.PageList;

import java.util.List;

public interface TopicService {

    PageList<Topic> findTopicList(PageVo vo);

    int updateTopic(Topic topic);
    int addTopic(Topic topic);
    Topic getTopicById(Integer id);

    List<Topic> getTopicList();
}
