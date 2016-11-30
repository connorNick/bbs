package com.shareniu.bbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shareniu.bbs.common.JsonResult;
import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.RepayCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shareniu.bbs.common.common.DataTable;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.IRepayCaseService;

@Controller
@RequestMapping("/repay")
public class RepayCaseController extends BaseController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(RepayCaseController.class);

	@Autowired
	private IRepayCaseService repayCaseService;	
	
	/**
	 * 去往案件管理列表
	 */
	@RequestMapping("/tolist")
	public ModelAndView tolist(ModelAndView mv,HttpServletRequest request){
		Integer flowStatus=Integer.valueOf(request.getParameter("flowStatus"));
		Integer caseStatus=Integer.valueOf(request.getParameter("caseStatus"));
		mv.addObject("flowStatus",flowStatus);
		mv.addObject("caseStatus",caseStatus);		
	    mv.setViewName("repaycase/repaycase_list");	
		return mv;
	}

	/**
	 * 组装案件列表数据
	 */
	@RequestMapping(value="/queryTableData",method = RequestMethod.GET)
	@ResponseBody
	public DataTable<RepayCase> queryTableData(HttpServletRequest request) {
		PageVo vo =  parametToPageVo(request,RepayCase.class);
		PageList<RepayCase> list = repayCaseService.findCaseList(vo);
		DataTable data = resultToDataTable(list);
		return data;
	}
	
	/**
	 * 案件分配
	 * @param request
	 * @return
	 */
	@RequestMapping("/allocation")
	public @ResponseBody
	JsonResult allocation(HttpServletRequest request){
		String ids=request.getParameter("uids");
		Integer reminderId=Integer.valueOf(request.getParameter("reminder"));
		Integer flowStatus=Integer.valueOf(request.getParameter("flowStatus"));
		Integer caseStatus=Integer.valueOf(request.getParameter("caseStatus"));
		LOGGER.info("=ids=:"+ids+";催收人："+reminderId+";flowStatus:"+flowStatus+";caseStatus:"+caseStatus);		
		String[] sids=ids.split(",");
		List<Integer> uidsList=new ArrayList<Integer>();
		for(int i=0;i<sids.length;i++){
			uidsList.add(Integer.parseInt(sids[i]));
		}
		//更新分配人和流程状态
		int i=repayCaseService.updateReminderByIds(uidsList,reminderId,flowStatus,caseStatus);
		if(i>0){
			return returnSuccess("分配成功！");
		}else{
			return JsonResult.createErrorMsg("分配失败！");
		}
	}
	
	/**
	 * 案件委外
	 * @param request
	 * @return
	 */
	@RequestMapping("/ourSourcing")
	public @ResponseBody JsonResult ourSourcing(HttpServletRequest request){
		String ids=request.getParameter("uids");
		Integer companyName=Integer.valueOf(request.getParameter("companyName"));
		Integer flowStatus=Integer.valueOf(request.getParameter("flowStatus"));
		Integer caseStatus=Integer.valueOf(request.getParameter("caseStatus"));
		LOGGER.info("=ids=:"+ids+";催收公司："+companyName);
		String[] sids=ids.split(",");
		List<Integer> uidsList=new ArrayList<Integer>();
		for(int i=0;i<sids.length;i++){
			uidsList.add(Integer.parseInt(sids[i]));
		}
		int result=repayCaseService.updateCompanyNameByIds(uidsList,companyName,flowStatus,caseStatus);
		if(result>0){
			return returnSuccess("委外成功！");
		}else{
			return JsonResult.createErrorMsg("委外失败！");
		}
	}
	
	/**
	 * 重置
	 * @param request
	 * @return
	 */
	@RequestMapping("/caseReset")
	public @ResponseBody JsonResult caseReset(HttpServletRequest request){
		String ids=request.getParameter("ids");
		Integer flowStatus=Integer.valueOf(request.getParameter("flowStatus"));
		Integer caseStatus=Integer.valueOf(request.getParameter("caseStatus"));
		List<Integer> uidsList=new ArrayList<Integer>();
		String[] sids=ids.split(",");
		for(int i=0;i<sids.length;i++){
			uidsList.add(Integer.parseInt(sids[i]));
		}
		int result=repayCaseService.updateFlowStatusByIds(uidsList,flowStatus,caseStatus);
		if(result>0){
			return returnSuccess("重置成功！");
		}else{
			return JsonResult.createErrorMsg("重置失败！");
		}
	}
}
