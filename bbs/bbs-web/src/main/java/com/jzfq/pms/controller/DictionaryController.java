package com.jzfq.pms.controller;

import com.jzfq.pms.common.JsonResult;
import com.jzfq.pms.common.common.DataTable;
import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.domain.Dictionary;
import com.jzfq.pms.domain.RepayCase;
import com.jzfq.pms.domain.SysRole;
import com.jzfq.pms.interceptor.PageList;
import com.jzfq.pms.service.IDictionaryService;
import com.jzfq.pms.service.IRepayCaseService;
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
@RequestMapping("/sysdic")
public class DictionaryController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(DictionaryController.class);

	@Autowired
	private IDictionaryService dictionaryService;
	
	/**
	 * 去往案件管理列表
	 */
	@RequestMapping("/tolist")
	public ModelAndView tolist(ModelAndView mv){
		mv.setViewName("sysconfig/sysdic_list");
		return mv;
	}

	/**
	 * 组装案件列表数据
	 */
	@RequestMapping(value="/queryTableData",method = RequestMethod.GET)
	@ResponseBody
	public DataTable<Dictionary> queryTableData(HttpServletRequest request) {
		PageVo vo =  parametToPageVo(request,Dictionary.class);
		PageList<Dictionary> list = dictionaryService.findDictionaryList(vo);
		DataTable data = resultToDataTable(list);
		return data;
	}


	/**
	 * 去往新增-字典
	 */
	@RequestMapping("/toadd")
	public ModelAndView toAdd(ModelAndView mv){
		mv.setViewName("sysconfig/sysdic_add");
		return mv;
	}

	/**
	 * 去往编辑-字典
	 */
	@RequestMapping("/toedit/{id}")
	public ModelAndView toEdit(@PathVariable Integer id, ModelAndView mv){
		mv.addObject("dictionary", dictionaryService.getDictionaryById(id));
		mv.setViewName("sysconfig/sysdic_add");
		return mv;
	}

	/**
	 * 添加/编辑-字典
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(Dictionary d) {
		if(d.getId() != null && d.getId() > 0){
			dictionaryService.updateDictionary(d);
		}else{
			dictionaryService.addDictionary(d);
		}
		return "redirect:/sysconfig/tolist";
	}

	/**
	 * 删除字典
	 */
	@RequestMapping("/del/{id}")
	public @ResponseBody
	JsonResult delUser(@PathVariable Integer id){
		boolean result = dictionaryService.delDictionary(id);
		if(result){
			return returnSuccess("操作成功！");
		}else{
			return JsonResult.createErrorMsg("操作失败！");
		}
	}


}
