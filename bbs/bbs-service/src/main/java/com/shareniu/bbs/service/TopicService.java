package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.domain.User;
import com.shareniu.bbs.interceptor.PageList;

public interface TopicService {

    PageList<Topic> findTopicList(PageVo vo);
}
