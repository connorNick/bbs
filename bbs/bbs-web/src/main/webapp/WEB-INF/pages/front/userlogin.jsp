<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title></title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" href="css/cssreset.css">
<link rel="stylesheet" type="text/css" href="css/all.css">

<script type="text/javascript" src="js/jquery.js"></script>


<link href="css/main.css" type="text/css" rel="stylesheet">
<link href="css/fix.css" type="text/css" rel="stylesheet">

<link charset="utf-8" type="text/css" href="css/float.css" rel="stylesheet"/>

<body>

<div id="top-head">
	<div class="con">
	<p>欢迎加入超人学院！</p>
		<div class="login">
		<p>
<a href="http://www.crxy.cn/userlogin/1">登录</a>&nbsp;|<a href="http://www.crxy.cn/userlogin/2">注册</a>
		</p></div>
		<p></p>
	</div>
</div>
<div id="header">
	<div>
		<a href="http://www.crxy.cn/" title="超人学院"><img src="images/logo.png" alt="超人学院" height="70px"></a>
	</div>
	<div style="padding:0">
		<ul>
			<li><a href="http://www.crxy.cn/" class="current" id="title1" title="首页"><h2>首页</h2></a></li>
			<li><a href="http://www.crxy.cn/course/course" id="title3" title="高薪课程"><h2>高薪课程</h2></a></li>
			<li><a href="http://www.crxy.cn/teacher" id="title2" title="讲师风采"><h2>讲师风采</h2></a></li>
			<li><a href="http://www.crxy.cn/job" id="title5" title="高薪就业风云榜"><h2>高薪就业风云榜</h2></a></li>
			<li><a href="http://www.crxy.cn/circle" id="title4" title="超人技术联盟"><h2>超人技术联盟</h2></a></li>
			<li><a href="http://bbs.superwu.cn/" title="超人社区" id="title7" target="_blank"><h2>超人社区</h2></a></li>
			<li><a href="http://www.superwu.cn/" title="吴超沉思录" id="title8" target="_blank"><h2>吴超沉思录</h2></a></li>
			<li class="more">
				<a href="http://www.crxy.cn/course" id="title6" title="免费学习资源"><h2>免费学习资源</h2></a>
				<div class="no-nav">
					<ul>
						<li>
							<a href="http://www.crxy.cn/course" title="视频下载"><img src="images/yun.jpg" width="70px"></a>
							<span><a href="http://www.crxy.cn/course" id="title6" title="视频下载"><h1>视频下载</h1></a></span>
						</li>
						<li>
							<a href="#" onclick="toOpenCourse()" title="公开课"><img src="images/ku.jpg" width="70px"></a>
							<span><a href="#" id="title6" title="公开课" onclick="toOpenCourse()"><h1>公开课</h1></a></span>
						</li>
						<li>
							<a href="http://www.crxy.cn/word" title="技术文档"><img src="images/open.jpg" width="70px"></a>
							<span><a href="http://www.crxy.cn/word" title="技术文档" id="title6"><h1>技术文档</h1></a></span>
						</li>
					</ul>
				</div>
			</li>
			<li><a href="http://www.crxy.cn/news" id="title9" title="学院资讯"><h2>学院资讯</h2></a></li>
		</ul>
	</div>
	<!-- <div>
		<span class="search">
			<input type="text" placeholder="搜索您需要的课程">
			<i></i>
		</span>
	</div> -->
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/countdown.js"></script>
<script type="text/javascript">
var from = '0';
var isCanSave = false;
$(function(){
	if(from==1){
		$("#zc").addClass("current");
		$(".zcform").removeClass("cur");
		$(".dlform").addClass("cur");
	 	$("#dl").removeClass("current");
	}else if(from==2){
		$("#dl").addClass("current");
		$(".dlform").removeClass("cur");
		$(".zcform").addClass("cur");
	 	$("#zc").removeClass("current");
	}
	
	$("#zc").click(function(){
    	$("#dl").addClass("current");
		$(".dlform").removeClass("cur");
		$(".zcform").addClass("cur");
	 	$("#zc").removeClass("current");
	 	$("#dlform")[0].reset();
    });
	$("#dl").click(function(){
    	$("#zc").addClass("current");
		$(".zcform").removeClass("cur");
		$(".dlform").addClass("cur");
	 	$("#dl").removeClass("current");
	 	$("#zcform")[0].reset();
    });
 });

function refushcode1(dom){
	var phone = $("input[name='registorVo.phoneno']").val();
	var captcha = $("input[name='registorVo.captcha']").val();
	
	if(captcha==null || captcha==''){
		$('#captchaMsg').html("请输入验证码");
		return false;
	}
	
	var re= /^1\d{10}$/;
	if(!re.test(phone)){
		document.getElementById("phonespantext").innerText="请输入正确的手机号";
	}else{
		var hrefurl="/checkPhone?phone="+phone;
	   	$.post(hrefurl, '', function(data){
	   		if(data.flag==1){
	   			document.getElementById("phonespantext").innerText="此用户已经注册,如有疑问,请联系课程顾问.";
	   		}else{
	   			CountDown.sendMessage(dom,phone,captcha);
	   		}
	   	});
	}
}

function refushcodeimg(){
	var d = new Date();
    document.getElementById("safecode2").src="/img?t="+d.toString(40);
}

function refushcode(index){
    var d = new Date();
    document.getElementById("safecode"+index).src="/img?t="+d.toString(40);
}
function submitDl(){
	$('#dlform').submit();
}
function submitZc(){
	checkPhone();
	checkPsw();
	checkEmail();
	if(isCanSave){
		$('#zcform').submit();
	}else{
		return false;
	}
}
$('body').unbind().bind('keydown',function(event){
	if (event.keyCode==13)
		submit();
});

function checkPhone(){
	var phone = $("input[name='registorVo.phoneno']").val();
	if(phone==""||phone==null){
		document.getElementById("phonespantext").innerText="请输入手机号";
		isCanSave = false;
	}else{
		var re= /^1\d{10}$/;
		if(!re.test(phone)){
			document.getElementById("phonespantext").innerText="请输入正确的手机号";
			isCanSave = false;
		}else{
		 	var hrefurl="/checkPhone?phone="+phone;
		   	$.post(hrefurl, '', function(data){
		   		if(data.flag==1){
		   			document.getElementById("phonespantext").innerText="此用户已经注册,如有疑问,请联系课程顾问.";
		   			isCanSave = false;
		   		}else{
		   			document.getElementById("phonespantext").innerText="";
		   			isCanSave = true;
		   		}
		   	} );
		} 
	}
}
function checkPsw(){
	var psw1 = $("#psw1").val();
	var psw2 = $("#psw2").val();
	if(psw1==null || psw1==''){
		document.getElementById("pswspantext").innerText="请输入密码";
		isCanSave = false;
	}else if(psw1 != psw2){
		document.getElementById("pswspantext").innerText="两次密码输入不一致.";
		isCanSave = false;
	}else{
		document.getElementById("pswspantext").innerText="";
		isCanSave = true;
	}
}

function checkEmail(){
	var email = $("#thisEmail").val();
	if(email == ""){
		document.getElementById("emailspantext").innerText="请输入邮箱";
		isCanSave = false;
	}else{
		if (!email.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
   			document.getElementById("emailspantext").innerText="邮箱格式有误.";
   			isCanSave = false;
		}else{
			var hrefurl="/checkEmail?email="+email;
    	   	$.post(hrefurl, '', function(data){
    	   		if(data.flag==0){
    	   			document.getElementById("emailspantext").innerText="";
    	   			isCanSave = true;
    	   		}else{
    	   			document.getElementById("emailspantext").innerText="邮箱已存在.";
    	   			isCanSave = false;
    	   		}
    	   	}); 
		}
	} 
}

function click_(num){
	if(num==1){
		document.getElementById("phonespantext").innerText="";
	}else if(num==2){
		document.getElementById("emailspantext").innerText="";
	}else if(num==3){
		document.getElementById("pswspantext").innerText="";
	}
}
</script>
<div id="loginForm">
     <div id="login">
         <h2>
             <span id="dl" class="dl1">登录<span style="display: none; width: 0px; height: 0px;" id="transmark"></span></span>
             <span id="zc" class="zc1 current">注册</span>
         </h2>
         <form id="dlform" class="dlform index1 cur" action="/login/1" method="post">
	         <div class="dl">
	             <p> 
	                 <input name="loginVo.username" placeholder="手机号" type="text">
	             </p>
					 <div class="jg"></div>
	             <p> 
	                <input placeholder="默认邮箱/密码" name="loginVo.password" value="" onblur="refushcode(1);" type="password">
	             </p>
	    			<div class="jg"></div>
	             <p>
	                <input style="width:180px;" name="loginVo.captcha" placeholder="验证码" type="text"> <span class="yzk"><img src="images/img.jpg" alt="点击刷新" style="width: 100px;margin-left:25px;" id="safecode1" onclick="refushcode(1);"></span>
					<!-- <b onclick="refushcode(1);">看不清？换一张</b> -->
				    </p><div class="jg"></div>
	             <p></p>
	             	<button onclick="submitDl">登录</button>
	             <p class="last">
	                 <a href="#">找回密码 </a>
	                 | <span>还没有注册帐号？</span>
	                 <a href="http://www.crxy.cn/userlogin/2">立即注册</a>
	             </p>
	        </div>
         </form>
         <form id="zcform" class="zcform index1" action="/register/2" method="post">
	         <div class="zc">
	             <p>
	                <input name="registorVo.phoneno" onclick="click_(1);" onblur="checkPhone()" placeholder="手机号" type="text">
			      	</p><div id="phonespantext" class="jg"><!--  --></div>
	             <p></p>
	             <p>
	                 <input id="thisEmail" name="registorVo.email" onclick="click_(2);" onblur="checkEmail();" placeholder="邮箱" type="text">
			      	 </p><div class="jg" id="emailspantext"><!--  --></div>
	             <p></p>
	             <p>
	                <input id="psw1" name="registorVo.password" value="" placeholder="密码" type="password">
			      	<!-- <span style="color: red">*</span> -->
			        </p><div class="jg"><!--  --></div>
	             <p></p>
	             <p>
	                 <input id="psw2" onclick="click_(3);" onblur="checkPsw()" name="registorVo.password2" value="" placeholder="再次输入密码" type="password">
       				 </p><div class="jg" id="pswspantext"><!--  --></div>
	             <p></p>
	              <p>
	                 <input style="width:180px;" name="registorVo.captcha" onclick="refushcode(2);" class="sole" placeholder="验证码" type="text"> <span class="yzk"><img src="images/img.jpg" alt="点击刷新" style="margin-left: 25px;width: 100px;" id="safecode2" onclick="refushcode(2);"></span>
				     </p><div class="jg" id="captchaMsg"></div>
	             <p></p>
	              <p>
	                <input style="width:180px;" name="registorVo.messagecode" placeholder="短信验证码" type="text"><span onclick="refushcode1(this);" class="fs">发送短信验证码</span>
			        </p><div class="jg"><!--  --></div>
	             <p></p>
	             <button onclick="submitZc()">注 册</button>
	         </div> 
   		</form>
	    <!-- <div class="qw">
	          <div class="line"></div>
	          <a href="#" class="qq"></a>
	          <a href="wx" class="wx"></a>
	      </div> -->
 	</div>
</div>

<div id="footer">
	<div class="foot-top">
		<div class="list">
			<b>关于我们</b>
			<p><a href="http://www.crxy.cn/aboutUs">学院简介</a></p>
		</div>
		<div class="list">
			<b>学习资源</b>
			<p><a href="http://www.crxy.cn/course" id="title3">免费视频</a></p>
			<p><a href="http://www.crxy.cn/word" id="title6">免费资料</a></p>
		</div>
		<div class="list">
			<b>报名攻略</b>
			<p><a href="http://www.crxy.cn/payment">报名流程</a></p>
			<p><a href="http://www.crxy.cn/payment">学习流程</a></p>
			<p><a href="http://www.crxy.cn/payment">缴费流程</a></p>
		</div>
		<ul class="qq">
			<li>
				<img src="images/zeng.jpg" title="hadoop大数据培训课程曾老师" width="120px">
				<p>曾老师</p>
				<p>158 9986 0308</p>
			</li>
			<li>
				<img src="images/zhang.jpg" title="hadoop大数据培训课程张老师" width="120px">
				<p>张老师</p>
				<p>187 9279 5810</p>
			</li>
		</ul>
	</div>
	<div class="foot-bottom">
		<div>
			<a href="http://www.crxy.cn/" title="超人学院"><img src="images/logo.png" alt="" width="150px"></a>
			<p><span>京ICP备13032771号-21</span> 
			<span>友情连接：<a href="http://www.cbdio.com/">大数据新闻</a></span><br> 
			<span>学院地址：北京市昌平区天通苑西三区天通伟业写字楼3楼315室</span></p>
		</div>
	</div>
	<div class="wei"><a href="#" class="b"></a><a href="#" class="x"> <i></i></a></div>
</div>


</div>
</body><!-- 百度统计 -->
</html>