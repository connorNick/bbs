<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh">
<!--<![endif]-->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<head>
	<meta charset="utf-8" />
	<title>主页面</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- ================== BEGIN BASE CSS STYLE ================== -->
	<jsp:include page="../common/header_style.jsp"/>

	<%@include file="../common/taglib.jsp"%>
	<!-- ================== END BASE CSS STYLE ================== -->
</head>

<body>

<jsp:include page="../common/header.jsp"/>

<script type="text/javascript" src="/frontstatic/js/jquery.js"></script>

<script type="text/javascript" src="/frontstatic/js/countdown.js"></script>
<script type="text/javascript" src="/frontstatic/js/login.js"></script>

<div id="loginForm">
     <div id="login">
         <h2>
             <span id="dl" class="dl1 current">登录</span>
             <span id="zc" class="zc1">注册<span style="display: none; width: 0px; height: 0px;" id="transmark"></span></span>
         </h2>
         <form id="dlform" class="dlform index1 cur" action="/dologin" method="post">
	         <div class="dl">
	             <p> 
	                 <input name="username" placeholder="账号" type="text">
	             </p>
					 <div class="jg">${loginNameMessage.msg}</div>
	             <p> 
	                <input placeholder="默认邮箱/密码" name="password" value="" type="password">
	             </p>
	    			<div class="jg">${loginPwdMessage.msg}</div>
	             <p>
	                <input style="width:180px;" name="captcha" placeholder="验证码" type="text"> <span class="yzk">
				 <img style="width: 100px;margin-left:25px;"  src="./Kaptcha.jpg" class="form-group" alt="点击更换" id="kaptchaImage"/>
				 </span>
					<!-- <b onclick="refushcode(1);">看不清？换一张</b> -->
				    </p>
				 <div class="jg">${loginCodeMessage.msg}</div>
	             <p></p>
	             	<button onclick="submitDl">登录</button>
	             <p class="last">
	                 <a href="#">找回密码 </a>
	                 | <span>还没有注册帐号？</span>
	                 <a href="/userlogin/2">立即注册</a>
	             </p>
	        </div>
         </form>

         <form id="zcform" class="zcform index1" action="/register" method="post">
	         <div class="zc">
	             <p>
	                 <input id="thisEmail" name="email" onclick="click_(2);" onblur="checkEmail();" placeholder="邮箱" type="text">
			     </p>
				 <div class="jg" id="emailspantext"></div>
	             <p></p>
	             <p>
	                <input id="psw1" name="password" value="" placeholder="密码" type="password">
			     </p>
				 <div class="jg"><!--  --></div>
	             <p></p>
	             <p>
	                 <input id="psw2" onclick="click_(3);" onblur="checkPsw()" name="password2" value="" placeholder="再次输入密码" type="password">
       				 </p>
				 <div class="jg" id="pswspantext"><!--  --></div>
	             <p></p>

	              <p>
					  <input style="width:180px;" id="thisCaptcha" onclick="click_(1);"   onblur="checkCaptcha()" name="captcha" placeholder="验证码" type="text"> <span class="yzk"></span>
				 		<img style="width: 100px;margin-left:25px;"  src="./Kaptcha.jpg" class="form-group" alt="点击更换" id="kaptchaImage"/>
				  </p><div class="jg" id="captchaMsg"></div>

				 <p></p>
	             <button onclick="submitZc()">注 册</button>
	         </div> 
   		</form>
	</div>
</div>
<script>

</script>
<jsp:include page="../common/footer.jsp"/>


</div>
</body><!-- 百度统计 -->
</html>