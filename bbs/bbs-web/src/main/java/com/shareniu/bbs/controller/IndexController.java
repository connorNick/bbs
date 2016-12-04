package com.shareniu.bbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shareniu.bbs.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(IndexController.class);

	/*@Autowired
	private IndexService repayCaseService;
	*/
	/**
	 * 去往案件管理列表
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv,HttpServletRequest request){
	    mv.setViewName("/front/index");
		System.out.println(10);
		return mv;
	}
}
