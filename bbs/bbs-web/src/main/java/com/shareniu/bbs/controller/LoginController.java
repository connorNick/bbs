package com.shareniu.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shareniu.bbs.common.Constant;
import com.shareniu.bbs.common.JsonResult;
import com.shareniu.bbs.domain.User;
import com.shareniu.bbs.service.UserService;
import com.shareniu.bbs.shiro.CaptchaUsernamePasswordToken;
import com.shareniu.bbs.shiro.PasswordHelper;
import com.shareniu.bbs.utils.CookieUtils;
import com.shareniu.bbs.utils.MyWebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shareniu.bbs.shiro.IncorrectCaptchaException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by zhishuo on 10/27/16.
 */
@Controller
public class LoginController extends BaseController{


    @Autowired
    private DefaultWebSessionManager sessionManager;

    public static final String CAPTCHA_PARAM_NAME = "captcha";

    @Autowired
    private UserService userService;
    /**
     * 登出 跳转到主页面
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        if (!subject.isAuthenticated()) {
            MyWebUtils.removeCookie(request, response,
                    Constant.USERNAME_COOKIE_NAME);
        }
        return "redirect:/index";
    }

    /**
     *
     */
    @RequestMapping("/dologin")
    public @ResponseBody JsonResult dologin(HttpServletRequest request, HttpServletResponse response,Model mode) {
        String loginFailure = (String) request.getAttribute("shiroLoginFailure");
        JsonResult loginMessage=new JsonResult();
        //可以在这里放 错误信息  从这里就可以拿到认证异常了
        if (loginFailure != null) {
          if (UnknownAccountException.class.getName().equals(loginFailure)) {
        	  loginMessage.setMsg("用户名或密码不正确");        	  
          } else if (IncorrectCredentialsException.class.getName().equals(loginFailure)) {
        	  loginMessage.setMsg("用户名或密码不正确");
          }else if(IncorrectCaptchaException.class.getName().equals(loginFailure)){
        	  loginMessage.setMsg("验证码不正确");
          }else {
        	  loginMessage.setMsg("未知错误");
          }
       }
        return loginMessage;
    }
    /**
     *
     */
    @RequestMapping("register")
    public@ResponseBody String register(User user, HttpServletRequest request, HttpServletResponse response) {
        user = PasswordHelper.encryptPassword(user);
        user.setLastLogionIp(getIpAddr(request));
        String captcha=request.getParameter("captcha");
        String password=request.getParameter("password");
        String code=WebUtils.getCleanParam(request, CAPTCHA_PARAM_NAME);
        if(captcha==null&&!captcha.equals(code)){
                return "验证码错误";
        }
        User user2=userService.getUserByEmail(user.getEmail());
        if(user2!=null){
            return "邮箱已被使用";
        }
        User user3=userService.getUserByUserName(user.getUsername());
        if(user3!=null){
            return "用户名已存在";
        }
        int i=userService.save(user);
        if(i>0){
            UsernamePasswordToken token = new CaptchaUsernamePasswordToken(user.getUsername(),
                    password,true,null,captcha);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            return "success";
        }
        return "fail";
    }
}
