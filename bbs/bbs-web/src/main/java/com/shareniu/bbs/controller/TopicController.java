package com.shareniu.bbs.controller;

import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private TopicService topicService;
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv,HttpServletRequest request){
		List<Topic> list=topicService.getTopicList();
		mv.addObject("list",list);
		mv.setViewName("/front/list");
		return mv;
	}
	@RequestMapping("/content")
	public ModelAndView content(@RequestParam("id") Integer id,ModelAndView mv,HttpServletRequest request){
		Topic topic=topicService.getTopicById(id);
		mv.addObject("topic",topic);
		mv.setViewName("/front/content");
		return mv;
	}
}
