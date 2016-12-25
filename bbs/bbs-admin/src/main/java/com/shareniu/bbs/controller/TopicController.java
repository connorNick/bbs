package com.shareniu.bbs.controller;

import com.shareniu.bbs.common.JsonResult;
import com.shareniu.bbs.common.common.DataTable;
import com.shareniu.bbs.common.common.EnumDirectoryType;
import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.constants.DirctionaryEnum;
import com.shareniu.bbs.domain.Dictionary;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
		vo.getPageable().setPageSize(10);
		PageList<Topic> list = topicService.findTopicList(vo);
		DataTable data = resultToDataTable(list);
		return data;
	}


	/**
	 * 去往新增-字典
	 */
	@RequestMapping("/toadd")
	public ModelAndView toAdd(ModelAndView mv){
		List<Dictionary> list=getDictionaryListByTag(EnumDirectoryType.TECHNIQUE.getCode());
		mv.addObject("list",list);
		mv.setViewName("topic/topic_add");
		return mv;
	}

	/**
	 * 去往新增-字典
	 */
	@RequestMapping("/view")
	public ModelAndView view(ModelAndView mv,@RequestParam("id")Integer id){
		Topic topic=topicService.getTopicById(id);
		mv.addObject("topic", topic);
		mv.setViewName("topic/result");
		return mv;
	}

	/**
	 * 去往编辑-字典
	 */
	@RequestMapping("/toedit/{id}")
	public ModelAndView toEdit(@PathVariable("id")Integer id, ModelAndView mv){
		List<Dictionary> list=getDictionaryListByTag(DirctionaryEnum.TOPIC_CATEGORY.name());
		mv.addObject("list",list);
		mv.addObject("topic", topicService.getTopicById(id));
		mv.setViewName("topic/topic_add");
		return mv;
	}

	/**
	 * 添加/编辑-字典
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request,ModelAndView mv,Topic topic) {
		if(topic.getId() != null && topic.getId() > 0){
			topicService.updateTopic(topic);
		}else{
			topic.setCreateUserId(getUser().getId());
			topicService.addTopic(topic);
		}
		mv.addObject("topic",topic);
		mv.setViewName("topic/result");
		return mv;
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
