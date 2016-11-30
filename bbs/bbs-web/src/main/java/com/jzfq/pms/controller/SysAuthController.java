package com.jzfq.pms.controller;

import com.jzfq.pms.common.JsonResult;
import com.jzfq.pms.common.common.DataTable;
import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.domain.SysAuth;
import com.jzfq.pms.domain.SysRole;
import com.jzfq.pms.domain.SysUser;
import com.jzfq.pms.interceptor.PageList;
import com.jzfq.pms.service.ISysAuthService;
import com.jzfq.pms.service.ISysRoleService;
import org.apache.shiro.SecurityUtils;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 权限controller
 *
 * @author sjzc
 */
@Controller
@RequestMapping("/sysauth")
public class SysAuthController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(SysAuthController.class);
    @Autowired
    private ISysAuthService sysAuthService;

    /**
     * 去往权限管理列表
     */
    @RequestMapping("/tolist")
    public ModelAndView tolist(ModelAndView mv){
        mv.setViewName("system/sysauth_list");
        return mv;
    }

    /**
     * 组装权限列表数据
     */
    @RequestMapping(value="/queryTableData",method = RequestMethod.GET)
    @ResponseBody
    public DataTable<SysAuth> queryTableData(HttpServletRequest request) {
        PageVo vo =  parametToPageVo(request,SysAuth.class);
        PageList<SysAuth> list = sysAuthService.queryAuthList(vo);
        DataTable data = resultToDataTable(list);
        return data;
    }


    /**
     * 去往新增-权限
     */
    @RequestMapping("/toadd/{type}")
    public ModelAndView toAdd(@PathVariable String type, ModelAndView mv){
        List<SysAuth> list = new ArrayList();
        if(type.equals("menu")){
            list = sysAuthService.getRootMenu();
        }else{
            list = sysAuthService.getChildMenu();
        }
        mv.addObject("type", type);
        mv.addObject("list", list);
        mv.setViewName("system/sysauth_add");
        return mv;
    }

    /**
     * 去往编辑-权限
     */
    @RequestMapping("/toedit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id, ModelAndView mv){
        //组装父级资源数据
        SysAuth sysAuth = sysAuthService.getAuthById(id);

        if(sysAuth.getParentId()==0){//顶级菜单
            mv.addObject("parentName", "根级菜单");
        }else{
            SysAuth parentAuth = sysAuthService.getAuthById(sysAuth.getParentId());
            mv.addObject("parentName", parentAuth.getText());

        }

        mv.addObject("type", sysAuth.getIconCls());
        mv.addObject("auth", sysAuth);

        mv.setViewName("system/sysauth_add");
        return mv;
    }

    /**
     * 添加/编辑-权限
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAuth(SysAuth sysRole) {
        if(sysRole.getId() != null && sysRole.getId() > 0){
            sysAuthService.updateAuth(sysRole);
        }else{
            sysAuthService.addAuth(sysRole);
        }
        return "redirect:/sysauth/tolist";
    }

    /**
     * 删除权限
     */
    @RequestMapping("/del/{id}")
    public @ResponseBody JsonResult delAuth(@PathVariable Integer id){
        boolean result = sysAuthService.delAuth(id);
        if(result){
            return returnSuccess("操作成功！");
        }else{
            return JsonResult.createErrorMsg("操作失败！");
        }
    }
	 

}
