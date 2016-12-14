package com.shareniu.bbs.controller;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.domain.TopicReply;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.TopicReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@Controller
@RequestMapping("/topicreply")
public class TopicReplyController extends BaseController{
    private static final Logger LOGGER= LoggerFactory.getLogger(TopicReplyController.class);

    @Autowired
    private TopicReplyService topicReplyService;
    @RequestMapping("/add.htm")
    public String add(TopicReply topicReply,ModelAndView mv,HttpServletRequest request){
         if(getUser()!=null){
             topicReply.setUserId(getUser().getId());
         }
        topicReply.setIp(request.getRemoteAddr());
        topicReplyService.add(topicReply);
        return "redirect:/topic/content/"+topicReply.getTopicId()+".htm";
    }
}
