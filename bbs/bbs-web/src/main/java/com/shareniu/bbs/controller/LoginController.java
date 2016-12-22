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
    public String dologin(HttpServletRequest request, HttpServletResponse response,Model mode) {
        String loginFailure = (String) request.getAttribute("shiroLoginFailure");
        JsonResult loginMessage=new JsonResult();
        User user=new User();
        //可以在这里放 错误信息  从这里就可以拿到认证异常了
        if (loginFailure != null) {
        	 String username = WebUtils.getCleanParam(request,"username");
             String password = WebUtils.getCleanParam(request,"password");
             user.setUsername(username);
             user.setPassword(password);
             mode.addAttribute("user",user);
          if (UnknownAccountException.class.getName().equals(loginFailure)) {  
        	  loginMessage.setMsg("用户名或密码不正确");        	  
        	  mode.addAttribute("loginNameMessage", loginMessage);
        	  return "forward:/userlogin";
          } else if (IncorrectCredentialsException.class.getName().equals(loginFailure)) {                    
        	  loginMessage.setMsg("用户名或密码不正确");
        	  mode.addAttribute("loginPwdMessage", loginMessage);
        	  return "forward:/userlogin";
          }else if(IncorrectCaptchaException.class.getName().equals(loginFailure)){  
        	  loginMessage.setMsg("验证码不正确");
        	  mode.addAttribute("loginCodeMessage", loginMessage);
        	  return "forward:/userlogin";
          }else {  
        	  loginMessage.setMsg("未知错误");
        	  mode.addAttribute("loginMessage",loginMessage);
        	  return "forward:/userlogin";
          }         
       }
       if(isAuthenticated()){
            user.setId(getUser().getId());
            user.setLastLogionIp(getIpAddr(request));
            user.setLastLoginTime(new Date());
            userService.updateUser(user);
           CookieUtils.addCookie(request, response,
                   Constant.USERNAME_COOKIE_NAME, user.getUsername(), 2592000);
       }
        return "redirect:/index";
    }
    /**
     *
     */
    @RequestMapping("register")
    public String register(User user, HttpServletRequest request, HttpServletResponse response) {
        user.setUsername(user.getEmail());
        user = PasswordHelper.encryptPassword(user);
        user.setLastLogionIp(getIpAddr(request));
        String captcha=request.getParameter("captcha");
        String password=request.getParameter("password");
        int i=userService.save(user);
        if(i>0){
            UsernamePasswordToken token = new CaptchaUsernamePasswordToken(user.getUsername(),
                    password,true,null,captcha);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            CookieUtils.addCookie(request, response,
                    Constant.USERNAME_COOKIE_NAME, user.getUsername(), 2592000);
        }
        return "redirect:/index";
    }

    @RequestMapping("checkEmail")
    public@ResponseBody String checkEmail(String email){
        User user=userService.getUserByEmail(email);
        if(user!=null){
            return "fail";//存在
        }
        return "success";//不存在
    }
    @RequestMapping("checkCode")
    public@ResponseBody String checkCode(@RequestParam("captcha") String code, HttpServletRequest request){
        String captcha=WebUtils.getCleanParam(request, CAPTCHA_PARAM_NAME);
        if(captcha!=null&&captcha.equals(code)){
            return "success";
        }
        return "fail";
    }
}
