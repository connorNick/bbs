package com.jzfq.pms.controller;

import com.jzfq.pms.common.JsonResult;
import com.jzfq.pms.common.common.DataTable;
import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.domain.SysRole;
import com.jzfq.pms.interceptor.PageList;
import com.jzfq.pms.service.ISysAuthService;
import com.jzfq.pms.service.ISysRoleService;
import com.jzfq.pms.vo.RootMenu;
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
import java.util.List;

/**
 * 角色controller
 *
 * @author sjzc
 */
@Controller
@RequestMapping("/sysrole")
public class SysRoleController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(SysRoleController.class);
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysAuthService sysAuthService;

    /**
     * 去往角色管理列表
     */
    @RequestMapping("/tolist")
    public ModelAndView tolist(ModelAndView mv){
        mv.setViewName("system/sysrole_list");
        return mv;
    }

    /**
     * 组装角色列表数据
     */
    @RequestMapping(value="/queryTableData",method = RequestMethod.GET)
    @ResponseBody
    public DataTable<SysRole> queryTableData(HttpServletRequest request) {
        PageVo vo =  parametToPageVo(request,SysRole.class);
        PageList<SysRole> list = sysRoleService.queryRoleList(vo);
        DataTable data = resultToDataTable(list);
        return data;
    }


    /**
     * 去往新增-角色
     */
    @RequestMapping("/toadd")
    public ModelAndView toAdd(ModelAndView mv){
        List<RootMenu> list  = sysAuthService.getRootMenuList();
        mv.addObject("list", list);
        mv.setViewName("system/sysrole_add");
        return mv;
    }

    /**
     * 去往编辑-角色
     */
    @RequestMapping("/toedit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id, ModelAndView mv){
        List<RootMenu> list  = sysAuthService.getRootMenuList();
        mv.addObject("list", list);
        mv.addObject("role", sysRoleService.getRoleById(id));
        mv.setViewName("system/sysrole_add");
        return mv;
    }

    /**
     * 添加/编辑-角色
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(SysRole sysRole) {
        if(sysRole.getId() != null && sysRole.getId() > 0){
            sysRoleService.updateRole(sysRole);
        }else{
            sysRoleService.addRole(sysRole);
        }
        return "redirect:/sysrole/tolist";
    }

    /**
     * 删除角色
     */
    @RequestMapping("/del/{id}")
    public @ResponseBody
    JsonResult delUser(@PathVariable Integer id){
        boolean result = sysRoleService.delRole(id);
        if(result){
            return returnSuccess("操作成功！");
        }else{
            return JsonResult.createErrorMsg("操作失败！");
        }
    }
	 

}
