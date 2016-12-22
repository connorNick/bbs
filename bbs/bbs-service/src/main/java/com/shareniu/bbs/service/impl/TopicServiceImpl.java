package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.dao.TopicMapper;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.CategoryService;
import com.shareniu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klaus on 9/27/16.
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;
    public PageList<Topic> findTopicList(PageVo vo){
        return topicMapper.findTopicList(vo,vo.getPageable());
    }
    public int updateTopic(Topic topic){
        return topicMapper.updateByPrimaryKeySelective(topic);
    }
    public int addTopic(Topic topic){
        return topicMapper.insert(topic);
    }
   public Topic getTopicById(Integer id){
        return topicMapper.selectByPrimaryKey(id);
    }
    public List<Topic> getTopicList(){
        return topicMapper.getTopicList();
    }

    public List<Topic> getTopFiveTopicList(){
        return topicMapper.getTopFiveTopicList();
    }
}
