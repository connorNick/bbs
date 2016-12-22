package com.shareniu.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import com.shareniu.bbs.common.common.EnumDirectoryType;
import com.shareniu.bbs.domain.Dictionary;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.service.IDictionaryService;
import com.shareniu.bbs.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private IDictionaryService iDictionaryService;

	@Autowired
	private TopicService topicService;
	/**
	 * 去往案件管理列表
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv,HttpServletRequest request){
		List<Dictionary> list=iDictionaryService.getDictionaryListByType(EnumDirectoryType.TECHNIQUE.getCode());
		List<Topic> topiclist=topicService.getTopFiveTopicList();
		mv.addObject("techlist",list);
		mv.addObject("topiclist",topiclist);
		mv.setViewName("/front/index");
		return mv;
	}
	@RequestMapping("/userlogin")
	public ModelAndView userlogin(ModelAndView mv,HttpServletRequest request){
		mv.setViewName("/front/userlogin");
		System.out.println(10);
		return mv;
	}
}
