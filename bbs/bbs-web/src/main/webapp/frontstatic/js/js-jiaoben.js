/*samantuotuo-2014*/
var _moving;
function TipsAutoScroll() {
    $("#sonewsbody").find("ul:first").animate({
        marginTop: "-120px"
    }, 1000, function () {
        $(this).css({ marginTop: "-80px" }).find("li:first").appendTo(this);
    });
}
function TipsScrollDown() {
    $("#sonewsbody").find("ul:first").animate({
        marginTop: "-40px"
    }, 1000, function () {
        $(this).css({ marginTop: "-80px" }).find("li:first").before($(this).find("li:last"));
       
    });
}
$(document).ready(function () {
    $("#btnui_search3g").click(function () {
        if ($.trim($("#form_search_q").val()) == "") {
            alertMsg("提示信息", "拜托给点提示呗，好让小弟为您sousou."); return;
        }
        $("#uiform_search3g").submit();
});


    $("#ScrollTipUp,#ScrollTipDown").hover(
  function () {
      clearInterval(_moving);
  },
  function () {
     _moving = setInterval('TipsAutoScroll()', 3000);
  }
);
    _moving=setInterval('TipsAutoScroll()', 3000);
});



function CheckLogined()
{
    if ($("#ui_3g_status").val() == "Off") {
        ShowLoginBox();
        return false;
    }
    return true;
}

function ShowLoginBox() {
    var canver_Html="";
    canver_Html="<div id=\"div_back_canver\" class=\"blocking-div hide\"></div>";
    var Login_html="";
    Login_html+="<div  id=\"login-showbox\" class=\"popuplitem\">";
    Login_html+="    <div id=\"pplhead\">";
    Login_html+="        <div class=\"pplc\"><img width=\"92\" height=\"34\" alt=\"UI3g\" src=\"/images/ui3g2.png\">请登入</div>";
    Login_html+="    </div>";
    Login_html+="    <div id=\"ulpanel\" style=\"margin:-30px auto 0\" class=\"cfix\">";
    Login_html+="                <p id=\"ul-s4\">邮箱登录<span style=\"display: none\" class=\"submitwarning\">邮箱格式不正确</span></p>";
    Login_html += "                <p><input id=\"txt_account\" type=\"text\" placeholder=\"邮箱\" name=\"email\" class=\"inputtxt2\" autocomplete=\"off\" value=\"\"></p>";
    Login_html += "          <p><input id=\"txt_password\" type=\"password\" class=\"inputtxt2\" name=\"password\" autocomplete=\"off\" placeholder=\"密码\"></p>";
    Login_html += "            <div id=\"ul-s5\"><input type=\"button\" id=\"sendlogin\" value=\"登录\"><div><input type=\"checkbox\" value=\"1\" id=\"uiauto_login2\"><label for=\"bcdl\">保持登录</label></div><a id=\"ul-s6\" href=\"/findpwd/\">忘记密码 ? </a></div>";
    Login_html+="    </div>";
    Login_html+="    <div id=\"ulline\" style=\" float:none\"></div>";
    Login_html+="    <div class=\"layer_body\">";
    Login_html+="      <ul class=\"login_list\">";
    Login_html += "        <li class=\"phone\"><a class=\"_btn_login_phone\" href=\"/weibologin/\">用新浪微博登入</a></li>";
    Login_html += "        <li class=\"email\"><a class=\"_btn_login_email\" href=\"/qqlogin/\">用QQ号码登入</a></li>";
    Login_html+="      </ul>";
    Login_html+="      <div class=\"sign_id\">";
    Login_html+="        还没有账号？";
    Login_html += "        <a class=\"_link_guide_signup\" href=\"/login/\">立即註冊</a>";
    Login_html+="      </div>";
    Login_html+="    </div>";
    Login_html+="    <button type=\"button\" class=\"close_layer\"><img width=\"24\" height=\"24\" src=\"/images/btn_close.png\"></button>";
    Login_html += "</div>";
    if ($("#div_back_canver").length == 0) {
        $("body").append(canver_Html);
    }
    if ($("#login-showbox").length == 0) {
        $("body").append(Login_html);
    }
    $('#login-showbox').stop().animate({ top: 80, opacity: 1 }, 400);
    $(".blocking-div").stop().fadeTo(400, 0.8, function () { $(".blocking-div").css("display", "block") });
    $('button.close_layer,.blocking-div').click(function (event) {
        CloseLoginBox();
    });
    $("#sendlogin").click(function () {
        BoxSubmitData();
    });
}

function CloseLoginBox() {
    $('#login-showbox').stop().animate({ top: -550, opacity: 0 }, 400);
    $(".blocking-div").stop().fadeTo(400, 0, function () { $(".blocking-div").css("display", "none") });
}


function AppendLikeHtml() {
    var canver_Html = "";
    canver_Html = "<div id=\"div_back_canver\" class=\"blocking-div hide\"></div>";
    var Like_Html = "";
    Like_Html += "<div class=\"fixed\" id=\"popuplike\" style=\"opacity:0\">";
    Like_Html += "   <div class=\"popuplitem fixed-container\" id=\"popuplai\">";
    Like_Html += "       <div id=\"pplhead\">";
    Like_Html += "           <div class=\"pplc\">喜欢的分类</div>";
    Like_Html += "       </div>";
    Like_Html += "       <div class=\"pplc\">";
    Like_Html += "           <div id=\"pplcimg\" style=\"background-image: url(" + $("#productCover").val() + "); background-size: 115px 90px;\"></div>";
    Like_Html += "           <div id=\"pplcr\">";
    Like_Html += "              <div id=\"pplselect\">";
    Like_Html += "                   <div id=\"pplselectlabel\"><span  id=\"pplselectlabeltxt\">未分类</span><span class=\"ui-icon ui-soi\" id=\"down_morelistcate\"></span></div>";
    Like_Html += "                   <div id=\"pplselectcontent\">";
    Like_Html += "                       <ul>";
    Like_Html += "                       </ul>";
    Like_Html += "                       <div class=\"clear\"></div>";
    Like_Html += "                   </div>";
    Like_Html += "               </div>";
    Like_Html += "               <div id=\"pplacat\">";
    Like_Html += "                   <div id=\"pplainput\"><input id=\"txt_newCheats\" autocomplete=\"off\" placeholder=\"创建新的分类\" value=\"\"></div>";
    Like_Html += "                   <span id=\"addcatbtn\">添加</span>";
    Like_Html += "               </div>";
    Like_Html += "           </div>";
    Like_Html += "           <div class=\"clear\"></div>";
    Like_Html += "           <span id=\"postbtn\">确定</span>";
    Like_Html += "       </div>";
    Like_Html += "       <button class=\"close_layer\" type=\"button\"><img width=\"24\" height=\"24\" src=\"/images/btn_close.png\"></button>";
    Like_Html += "   </div>";
    Like_Html += "</div>";

   
    if ($("#div_back_canver").length == 0) {
        $("body").append(canver_Html);
    }
    if ($("#popuplike").length == 0) {
        $("body").append(Like_Html);
        $('#pplselectlabel').click(function (event) {
            $('#pplselectcontent').slideToggle();
        });
        $('button.close_layer,.blocking-div').click(function (event) {
            CloseLikeBox();
        });
        $('#pplselectcontent ul li').live('click', function () {
            $('#pplselectcontent ul li a').removeClass("active");
            $(this).find("a").addClass("active");
            $('#pplselectlabeltxt').text($(this).text());
            $('#pplselectcontent').slideToggle();
        });
        $('#addcatbtn').click(function (event) {
            $('#pplselectcontent ul li a').removeClass("active");
            var txt_newCheats = $('#txt_newCheats').val();
            if (txt_newCheats != "") {
                $('#pplselectlabeltxt').text(txt_newCheats);
                $('#pplselectcontent ul').append("<li><a data-value=\"0\" class=\"active\">" + txt_newCheats + "</a></li>");
                $('#txt_newCheats').val("");
            }
        });
        $('#postbtn').click(function (event) {
            LikeLoadData();
        });
        $.post("/services/Cheats/", { "func": "getCheats" },
   function (data) {
       $("#pplselectcontent ul").html(data.listhtml);
   }, "json");
        
        
    }
  
}

function Open_Like_Box() {
    AppendLikeHtml();
    $('#popuplike').stop().animate({ top: 80, opacity: 1 }, 400);
    $(".blocking-div").stop().fadeTo(400, 0.8, function () { $(".blocking-div").css("display", "block") });
};

function CloseLikeBox() {
    $('#popuplike').stop().animate({ top: -550, opacity: 0 }, 400);
    $(".blocking-div").stop().fadeTo(400, 0, function () { $(".blocking-div").css("display", "none") });
}
//打开指定的DIV
function Open_showdiv_Box(div_id) {
    if ($(".showbox_bg").length > 0)
    {
        $(".showbox_bg").remove();
    }
    $("body").append('<div  class="blocking-div hide showbox_bg"></div>');
    $('#' + div_id).stop().animate({ top: 180, opacity: 1 }, 400).show();
    $(".showbox_bg").stop().fadeTo(400, 0.6, function () { $(".showbox_bg").css("display", "block") });

    $(".close_showbg").unbind("click");
    $('button.close_showbg,.showbox_bg').click(function (event) {
        $('#' + div_id).stop().animate({ top: -550, opacity: 0}, 400).hide();
        $(".showbox_bg").stop().fadeTo(400, 0, function () { $(".showbox_bg").css("display", "none") });
    });
};




function BoxSubmitData() {
    var txt_account = $("#txt_account").val();
    var txt_password = $("#txt_password").val();
    var uiauto_login = $("#uiauto_login2").val();
    //<span class="submitwarning" style="display: inline-block;">sdfg</span>
    $(".submitwarning").hide();
    if (txt_account == "") {
        $(".submitwarning").show();
        $(".submitwarning").text("亮出您的身份来");
        return;

    }
    if (!checkMail(txt_account)) {
        $(".submitwarning").show();
        $(".submitwarning").text("身份识别有误");
         return;
    }
    if (txt_password == "") {
        $(".submitwarning").show();
        $(".submitwarning").text("通行密码");
         return;
    }
    if (!checkPwd(txt_password)) {
        $(".submitwarning").show();
        $(".submitwarning").text("通行密码Wrong");
       return;
    }


    var jsontext = { account: txt_account, password: txt_password, uiauto_login: uiauto_login };
    ajax_json_postV1("/services/login/", jsontext, 20000, true, BoxSuccessFn, BoxErrorFn, BoxBeforeSend);
}

function BoxSuccessFn(data) {
    switch (data.result) {
        case "0": $("#sendlogin").val("登录");
            $('#sendlogin').removeAttr("disabled"); alert("用户名或密码不正确"); break;
        case "1": $("#sendlogin").val("欢迎"); $("#user_area_menu").html(data.userarea); CloseLoginBox(); break;
        case "2": $("#sendlogin").val("登录"); alertMsg("提示信息", "对不起，您的随机密码已过期，请重新找回密码"); break;
        case "3": $("#sendlogin").val("欢迎"); location.href = "/me/pwd/"; break;
        case "4": $("#sendlogin").val("登录"); alertMsg("提示信息", "对不起,您还没有激活,请前往您绑定的邮箱激活账号."); break;
        case "-1": $("#sendlogin").val("登录");
            $('#sendlogin').removeAttr("disabled"); alert("验证超时，网络状态不佳哦"); break;
    }

}
function BoxBeforeSend() {
    $("#sendlogin").val("……");
    $('#sendlogin').attr('disabled', "true"); //添加disabled属性
    // $('#button').removeAttr("disabled"); 移除disabled属性 
}

function BoxErrorFn() {
    // alertMsg("提示信息", "停留时间过长，可点此<a href=\"/\">刷新 »</a>重试");
}
//




$("#yohocn_nav li").hover(function(){
				$(this).addClass("current")
			},function(){
				$(this).removeClass("current")
			});

//
var menuSlideON;//下拉菜单开关
function Menuhide(){
$('#UserMenubox').fadeOut(300,function(){$('#UserMenubox').css('display','none')});
}

$(document).ready(function(){
//$('#UserMenubox,#user_panel').mouseover(function(){
//clearTimeout(menuSlideON);
//if($('#UserMenubox').css('display')=='none'){
//$('#UserMenubox').fadeIn(300,function(){$('#UserMenubox').css('display','block');});
//}
//});

//$('#UserMenubox,#user_panel').mouseout(function(){
//menuSlideON = setTimeout("Menuhide()",500);
//});

$('#UserMenubox,#user_panel').live('mouseover', function () {
    clearTimeout(menuSlideON);
    if ($('#UserMenubox').css('display') == 'none') {
        $('#UserMenubox').fadeIn(300, function () { $('#UserMenubox').css('display', 'block'); });
    }
});

$('#UserMenubox,#user_panel').live('mouseout', function () {
    menuSlideON = setTimeout("Menuhide()", 500);
});


});
//
var menuSlideON2;//下拉菜单开关
function Menuhide2(){
$('#publish_nav').fadeOut(300,function(){$('#publish_nav').css('display','none')});
}

$(document).ready(function(){
$('#publish_nav,#yohocn_publish').mouseover(function(){
clearTimeout(menuSlideON2);
if($('#publish_nav').css('display')=='none'){
$('#publish_nav').fadeIn(300,function(){$('#publish_nav').css('display','block');});
}
});
$('#publish_nav,#yohocn_publish').mouseout(function(){
menuSlideON2 = setTimeout("Menuhide2()",500);
});
});
//
$(".banner_img").hide();$(".banner_img:eq(0)").show();play();function cycle(step)
{var next=cur+step;if(next<0)
{next=total-1;}
else if(next>total-1)
{next=0;}
var cur_img=$(".banner_img:eq("+cur+")");var next_img=$(".banner_img:eq("+next+")");cur_img.css({"z-index":"2"});next_img.css({"z-index":"1"});next_img.show();cur_img.fadeOut(500);cur=next;var cur_con=$(".banner_img:eq("+cur+") .banner_con")};


$(".slideprev").click(prev);$(".slidenext").click(next);$(".y_ibanner").hover(function()
{window.clearTimeout(flag);stop=true;},function()
{stop=false;play();});showorhide();function showorhide()
{if($(document.body).width()>=1330&&$(document.body).width()<1390&&!stopForever)
{$(".y_right_banner").width(150).show();$(".y_left_banner").width(170).show();$(".y_left_banner").css("left","-170px");}
else if($(document.body).width()<1330&&!stopForever)
{$(".y_left_banner,.y_right_banner").hide();}
else
{ $(".y_left_banner,.y_right_banner").show(); $(".y_left_banner").css("left", "-210px"); $(".y_left_banner,.y_right_banner").width(190); }
}




