package com.shareniu.bbs.controller;

import com.shareniu.bbs.common.JsonResult;
import com.shareniu.bbs.common.common.DataTable;
import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.Dictionary;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.IDictionaryService;
import com.shareniu.bbs.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private TopicService topicService;
	
	/**
	 * 去往案件管理列表
	 */
	@RequestMapping("/tolist")
	public ModelAndView tolist(ModelAndView mv){
		mv.setViewName("topic/topic_list");
		return mv;
	}

	/**
	 * 组装案件列表数据
	 */
	@RequestMapping(value="/queryTableData",method = RequestMethod.GET)
	@ResponseBody
	public DataTable<Topic> queryTableData(HttpServletRequest request) {
		PageVo vo =  parametToPageVo(request);
		PageList<Topic> list = topicService.findTopicList(vo);
		DataTable data = resultToDataTable(list);
		return data;
	}


	/**
	 * 去往新增-字典
	 */
	@RequestMapping("/toadd")
	public ModelAndView toAdd(ModelAndView mv){
		mv.setViewName("topic/topic_add");
		return mv;
	}

	/**
	 * 去往编辑-字典
	 */
	@RequestMapping("/toedit/{id}")
	public ModelAndView toEdit(@PathVariable Integer id, ModelAndView mv){
		//mv.addObject("dictionary", topicService.getDictionaryById(id));
		mv.setViewName("topic/topic_add");
		return mv;
	}

	/**
	 * 添加/编辑-字典
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(Dictionary d) {
		if(d.getId() != null && d.getId() > 0){
			//topicService.updateDictionary(d);
		}else{
			//topicService.addDictionary(d);
		}
		return "redirect:/topic/tolist";
	}

	/**
	 * 删除字典
	 */
	@RequestMapping("/del/{id}")
	public @ResponseBody
	JsonResult delUser(@PathVariable Integer id){
		/*boolean result = null;//dictionaryService.delDictionary(id);
		if(result){
			return returnSuccess("操作成功！");
		}else{
			return JsonResult.createErrorMsg("操作失败！");
		}*/
		return null;
	}


}
