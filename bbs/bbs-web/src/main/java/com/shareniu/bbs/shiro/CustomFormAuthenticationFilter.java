package com.shareniu.bbs.shiro;

/**
 * Created by zhishuo on 10/28/16.
 */

import com.alibaba.fastjson.JSON;
import com.shareniu.bbs.common.Constant;
import com.shareniu.bbs.domain.User;
import com.shareniu.bbs.service.UserService;
import com.shareniu.bbs.utils.AjaxUtils;
import com.shareniu.bbs.utils.CookieUtils;
import com.shareniu.bbs.utils.IpUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);

    @Autowired
    private UserService userService;
    public static final String DEFAULT_CALLBACK_KEY_ATTRIBUTE_NAME = "callback";
    public static final String SESSION_CALLBACK_KEY = "shiroSessionCallbackKey";

    /**
     * 回调url key
     */
    private String callbackKeyAttribute = DEFAULT_CALLBACK_KEY_ATTRIBUTE_NAME;

    /**
     * 验证码参数名
     */
    public static final String CAPTCHA_PARAM_NAME = "captcha";

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, CAPTCHA_PARAM_NAME);
    }

    /* 创建登陆认证token传值传递给UserRealm的shiro认证
     * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#createToken(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);//获取验证码
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
        token.setRequest(request);
        return token;
    }

    /*
     * 是否允许
     * @param request
     *            ServletRequest
     * @param response
     *            ServletResponse
     * @param mappedValue
     *            mappedValue
     * @return <code>true</code> if request should be allowed access
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        // 当前的用户已经登陆了，但是又在请求登陆页面,只针对同步
        if (subject.isAuthenticated() && isLoginRequest(request, response)) {
            try {
                issueSuccessRedirect(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }


    /**
     * 拒绝访问
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                // 请求登陆页面，检查当前请求是否有callback链接
                String callback = request
                        .getParameter(getCallbackKeyAttribute());
                if (callback != null && callback.trim().length() > 0) {
                    saveCallback(request, response, callback.trim());
                }
                // allow them to see the login page ;)
                return true;
            }
        } else {
            // 非登陆页面请求
            if (AjaxUtils.isAjaxRequest((HttpServletRequest) request)) {
                // 异步请求，返回错误代码，由前端判断并进行登陆页跳转
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                return false;
            } else {
                // 同步请求，重定向到登陆页面
                if (log.isTraceEnabled()) {
                    log.trace("Attempting to access a path which requires authentication.  Forwarding to the "
                            + "Authentication url [" + getLoginUrl() + "]");
                }
                saveCallback(request, response, ((HttpServletRequest)(request)).getRequestURI());
                saveRequestAndRedirectToLogin(request, response);

                return false;
            }
        }
    }

    /**
     * 登录成功
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject, ServletRequest request, ServletResponse response)
            throws Exception {
        // 记录登陆日志
        String successUrl = getSuccessUrl();
        User u = (User)SecurityUtils.getSubject().getPrincipal();
        User user=new User();
        user.setId(u.getId());
        user.setLastLogionIp(IpUtils.getIpAddr((HttpServletRequest) request));
        user.setLastLoginTime(new Date());
        userService.updateUser(user);
//        CookieUtils.addCookie(request, response,Constant.USERNAME_COOKIE_NAME, user.getUsername(), 2592000);
        // 如果当前是ajax登陆
        if (AjaxUtils.isAjaxRequest((HttpServletRequest) request)) {
            // 登陆成功返回，状态码
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString("success"));
        } else {
            // 同步登陆
            WebUtils.issueRedirect(request, response, successUrl);
        }
        return false;
    }

    /**
     * 登录失败
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e, ServletRequest request,
                                     ServletResponse response) {
        this.setFailureAttribute(request, e);
        // 获取当前异常的类名
        String errorMsg="";
        //可以在这里放 错误信息  从这里就可以拿到认证异常了
            if (UnknownAccountException.class.getName().equals(e.getClass().getName())) {
                errorMsg="用户名或密码不正确";
            } else if (IncorrectCredentialsException.class.getName().equals(e.getClass().getName())) {
                errorMsg="用户名或密码不正确";
            }else if(IncorrectCaptchaException.class.getName().equals(e.getClass().getName())){
                errorMsg="验证码不正确";
            }else {
                errorMsg="未知错误";
            }
        if (AjaxUtils.isAjaxRequest((HttpServletRequest) request)) {
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(JSON.toJSONString(errorMsg));
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
            return false;
        } else {
            request.setAttribute(getFailureKeyAttribute(), "fail");
            return true;
        }
    }
    /**
     * 保存回调地址
     *
     * @param request
     *            ServletRequest
     * @param response
     *            ServletResponse
     * @param callback
     *            callback
     */
    private void saveCallback(ServletRequest request, ServletResponse response,
                              String callback) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        session.setAttribute(SESSION_CALLBACK_KEY, callback);
    }

    /**
     * 获取并清理掉回调地址
     *
     * @param request
     *            ServletRequest
     * @param response
     *            ServletResponse
     * @return callback
     */
    private String getAndClearCallback(ServletRequest request,
                                       ServletResponse response) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession(false);
        if (session == null) {
            return null;
        }

        String callback = (String) session.getAttribute(SESSION_CALLBACK_KEY);
        if (callback != null) {
            session.removeAttribute(SESSION_CALLBACK_KEY);
        }
        return callback;
    }
    /**
     * Sets new 回调url key.
     *
     * @param callbackKeyAttribute
     *            New value of 回调url key.
     */
    public void setCallbackKeyAttribute(String callbackKeyAttribute) {
        this.callbackKeyAttribute = callbackKeyAttribute;
    }

    /**
     * Gets 回调url key.
     *
     * @return Value of 回调url key.
     */
    public String getCallbackKeyAttribute() {
        return callbackKeyAttribute;
    }
}
