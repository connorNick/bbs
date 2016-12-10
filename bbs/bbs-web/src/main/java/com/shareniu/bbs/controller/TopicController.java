package com.shareniu.bbs.controller;

import com.shareniu.bbs.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TopicController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private TopicService topicService;
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv,HttpServletRequest request){
		mv.setViewName("/front/list");
		System.out.println(10);
		return mv;
	}
	@RequestMapping("/content")
	public ModelAndView content(ModelAndView mv,HttpServletRequest request){
		mv.setViewName("/front/content");
		System.out.println(10);
		return mv;
	}
}
