<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<link rel="stylesheet" type="text/css" href="/frontstatic/css/main.css">
<link rel="stylesheet" type="text/css" href="/frontstatic/css/style.css">
<script type="text/javascript" src="/frontstatic/js/jquery-1.js"></script>
<script src="/frontstatic/js/main.js"></script>
<style type="text/css">
        .header .nav a{}
</style>
<div class="header">
        	<div style="background:#fff;">
                <div class="g-hdt cfix">
                    <h1 class="m-logo"><a href="" class="f-ti" id="toplogo" title="分享牛">hadoop spark redis----</a></h1>
                   
                    <div class="search">
                       <form action="/uisou.html" method="get" id="uiform_search3g" name="uiform_search3g">
                            <b style="height: 0px; top: 0px;" class="search-liaosheji"></b>
                            <input maxlength="50" placeholder="搜索文章." name="uikey" id="form_search_q" type="text">
							<a style="font-size:12px;margin:12px;" onclick="javascript:void()">搜索</a>
                        </form>
                    </div>
                </div>
            </div>    
            <div style="height: auto; top: 0px; left: 0px; position: relative; z-index: 998;" class="navboxbg"> 
               <!-- 当滚动条滚动时加载  style="position:fixed;top:0;" -->
                <div class="navbox">
                      <div id="user_area_menu">
                     
                    <input id="ui_3g_status" value="Off" type="hidden">
                    <div class="register register_pan"><!-- 登录前状态 -->
                        <a class="cd-signin" href="#0">登录</a>
                        <a class="cd-signup" href="#0">注册</a>
<%--                        <a style="margin:0 10px 0 0;" id="loginLayerBtn" href="http://www.ui3g.com/login/">登录</a>
                        <a href="http://www.ui3g.com/register/" id="regLayerBtn">注册</a>--%>
                    </div>
                    
                       </div>
                    <ul class="nav2" id="yohocn_nav" >
                        <li class="" style="font-size:15px;margin:8px;margin-left:40px" >
                            <a title="首页"  class="n_photo"  href="/index">首页</a>
                            
                        </li>
                       <%-- <li class="" style="font-size:15px;margin:8px;">
                            <a title="jquery特效" class="n_photo"  href="">jquery特效</a>
                            
                        </li>
                        <li class="" style="font-size:15px;margin:8px;">
                            <a title="psd素材" class="n_photo"  href="">psd素材</a>
                            
                        </li>
                        <li class="" style="font-size:15px;margin:8px;">
                            <a title="APP设计" class="n_photo"  href="">APP设计</a>
                           
                        </li>--%>
                    </ul> <%--<div style=" float:left; margin-top:3px;">
                        <div data-bd-bind="1482068261477" class="bdsharebuttonbox bdshare-button-style0-16" data-tag="share_1" id="click">
                            <a title="分享到QQ空间" class="bds_qzone" data-cmd="qzone" href="#"></a>
                            <a title="分享到新浪微博" class="bds_tsina" data-cmd="tsina"></a>
                            <a title="分享到百度新首页" class="bds_bdhome" data-cmd="bdhome"></a>
                            <a title="分享到人人网" class="bds_renren" data-cmd="renren"></a>
                            <a title="分享到微信" class="bds_weixin" data-cmd="weixin"></a>
                            <a class="bds_more" data-cmd="more" style="color:#fff;">更多</a>
                            <a title="累计分享170次" class="bds_count" data-cmd="count">170</a>
                        </div>
                    </div>--%>
				<script>
                    window._bd_share_config = {
                        common : {
                            bdText : '',	
                            bdDesc : '',	
                            bdUrl : '', 	
                            bdPic : ''
                        },
                        share : [{
                            "bdSize" : 16
                        }]
                    }
                    with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
                </script>
                </div>
            </div>
        </div>


<div class="cd-user-modal">
    <div class="cd-user-modal-container">
        <ul class="cd-switcher">
            <li><a href="#0" class="">用户登录</a></li>
            <li><a href="#0" class="selected">注册新用户</a></li>
        </ul>

        <div id="cd-login" class=""> <!-- 登录表单 -->
            <form class="cd-form">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="signin-username">用户名</label>
                    <input class="full-width has-padding has-border" id="signin-username" placeholder="输入用户名" type="text">
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signin-password">密码</label>
                    <input class="full-width has-padding has-border" id="signin-password" placeholder="输入密码" type="text">
                </p>

                <p class="fieldset">
                    <input id="remember-me" checked="checked" type="checkbox">
                    <label for="remember-me">记住登录状态</label>
                </p>

                <p class="fieldset">
                    <input class="full-width2" value="登 录" type="submit">
                </p>
            </form>
        </div>

        <div id="cd-signup" class="is-selected"> <!-- 注册表单 -->
            <form class="cd-form">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="signup-username">用户名</label>
                    <input class="full-width has-padding has-border" id="signup-username" placeholder="输入用户名" type="text">
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-email" for="signup-email">邮箱</label>
                    <input class="full-width has-padding has-border" id="signup-email" placeholder="输入mail" type="email">
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">密码</label>
                    <input class="full-width has-padding has-border" id="signup-password" placeholder="输入密码" type="text">
                </p>

                <p class="fieldset">
                    <input id="accept-terms" type="checkbox">
                    <label for="accept-terms">我已阅读并同意 <a href="#0">用户协议</a></label>
                </p>

                <p class="fieldset">
                    <input class="full-width2" value="注册新用户" type="submit">
                </p>
            </form>
        </div>

        <a href="#0" class="cd-close-form">关闭</a>
    </div>
</div>
</div>