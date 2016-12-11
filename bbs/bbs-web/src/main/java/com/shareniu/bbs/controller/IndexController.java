package com.shareniu.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import com.shareniu.bbs.domain.Topic;
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

	/**
	 * 去往案件管理列表
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv,HttpServletRequest request){
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
