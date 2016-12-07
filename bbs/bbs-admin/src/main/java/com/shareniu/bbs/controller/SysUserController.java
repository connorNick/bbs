package com.shareniu.bbs.controller;

import com.shareniu.bbs.common.JsonResult;
import com.shareniu.bbs.domain.SysRole;
import com.shareniu.bbs.domain.SysUser;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.ISysRoleService;
import com.shareniu.bbs.service.ISysUserService;
import com.shareniu.bbs.shiro.PasswordHelper;
import com.shareniu.bbs.common.common.DataTable;
import com.shareniu.bbs.common.common.PageVo;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhishuo on 9/27/16.
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger("SysUserController");

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;


    /**
     * 去往用户管理列表
     */
    @RequestMapping("/tolist")
    public ModelAndView tolist(ModelAndView mv){
        mv.setViewName("system/sysuser_list");
        return mv;
    }

    /**
     * 组装用户列表数据
     */
    @RequestMapping(value="/queryTableData",method = RequestMethod.GET)
    @ResponseBody
    public DataTable<SysUser> queryTableData(HttpServletRequest request) {
        PageVo vo =  parametToPageVo(request);
        PageList<SysUser> list = sysUserService.findUserList(vo);
        DataTable data = resultToDataTable(list);
        return data;

    }

    /**
     * 去往新增-用户
     */
    @RequestMapping("/toadd")
    public ModelAndView toAdd(ModelAndView mv){
        List<SysRole> list = sysRoleService.queryAllRoleList();
        mv.addObject("list", list);
        mv.setViewName("system/sysuser_add");
        return mv;
    }

    /**
     * 去往编辑-用户
     */
    @RequestMapping("/toedit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id, ModelAndView mv){
        List<SysRole> list = sysRoleService.queryAllRoleList();
        mv.addObject("list", list);
        mv.addObject("user", sysUserService.getUserById(id));
        mv.setViewName("system/sysuser_add");
        return mv;
    }

    /**
     * 添加/编辑-用户
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(SysUser user) {
        SysUser u = PasswordHelper.encryptPassword(user);
        if(user.getId() != null && user.getId() > 0){
            sysUserService.updateUser(u);
        }else{
            sysUserService.addUser(u);
        }
        return "redirect:/sysuser/tolist";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/del/{id}")
    public @ResponseBody
    JsonResult delUser(@PathVariable Integer id){
        boolean result = sysUserService.delUser(id);
    	if(result){
    		return returnSuccess("操作成功！");
    	}else{
    		return JsonResult.createErrorMsg("操作失败！");
    	}
    }

    /**
     * 验证新增账号是否已经注册
     */
    @RequestMapping("/only/{userName}")
    public @ResponseBody JsonResult onlyUser(@PathVariable String userName){
        SysUser user = sysUserService.getUserByUserName(userName);
        if(user==null){
            return returnSuccess("账号还没注册");
        }else{
            return JsonResult.createErrorMsg("账号已经注册");
        }
    }

    /**
     * 修改登录密码  oldpassword  password
     */
    @RequestMapping(value = "/modifyPassword")
    public String modifyPassword(@RequestParam (value = "newPassword",required = true) String newPassword) {
        SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
        log.info("user----------->"+user.getUsername());
        if(user == null){//如果session过期了，此时user为null
            return "redirect:/index";
        }
        user.setPassword(newPassword);
        SysUser u = PasswordHelper.encryptPassword(user);
        sysUserService.modifyPassword(user, u);
        //清空缓存
        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }

    public static void  main(String[] strings){
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("admin");
        SysUser u = PasswordHelper.encryptPassword(user);
        log.info(u.getUsername()+" "+u.getPassword()+ " "+ u.getSalt() + " "+u.getCredentialsSalt());
    }


} 
