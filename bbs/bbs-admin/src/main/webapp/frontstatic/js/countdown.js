(function(){
	CountDown = {sendMessage : sendMessage};
	var btn = '';
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    function sendMessage(dom,phone,captcha) {
    	btn = dom;
	    curCount = count;
	    //设置button效果，开始计时
	    $(dom).css("background", "silver").removeAttr("onclick");
	    $(dom).text(curCount + "秒");
	    InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
	    $.post(ctxPath + "/sendMobileCode/" + phone+"-"+captcha,function(data){
	    	if(data.captchaMsg=='0'){
	    		window.clearInterval(InterValObj);
		    	$(btn).css('background','').attr("onclick",function(){
	    			return "refushcode1(this);";
	    		});//启用按钮
		    	$(btn).text("重新发送验证码");
		    	$('#captchaMsg').html("验证码错误，请输入正确的验证码");
		    	refushcodeimg();
	    	}else{
	    		$('#captchaMsg').html("");
	    	}
	    	
	    });
    }
    //timer处理函数
    function SetRemainTime() {
    	if (curCount == 0) {                
    		window.clearInterval(InterValObj);//停止计时器
    		$(btn).css('background','').attr("onclick",function(){
    			return "refushcode1(this);";
    		});//启用按钮
    		$(btn).text("重新发送验证码");
    		code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效    
    	}else {
    		curCount--;
    		$(btn).text(curCount + "秒");
    	}
    }
})();