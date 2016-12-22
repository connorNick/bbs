//code design learns  



    $(function () {
        //回复按钮显示回复文本框
        $("#comments-list .cm-s5").click(function () {
            var Id = $(this).attr("dataid");
            $("#ToCommnet_" + Id).show();
        });

        $("#comments-list .canclbtn").click(function () {
            var Id = $(this).attr("dataid");
            $("#ToCommnet_" + Id).hide();
        });


        $("#Btn_comments-form-submit").click(function () {
            var logined = CheckLogined();
            if (logined) {
                    SubmitCommentsData("");
            }
          
        });
        //下载资源
        $("#to_download").click(function () {
            var logined = CheckLogined();
            if (logined) {
               // var message = "下载秘籍将损耗+" + $(".organge").text() + "内力值";
               // if (confirm(message)) {
                    DownLoadData();
                //}
            }
        });

        $("#nodownwanpan").click(function () {
            var logined = CheckLogined();
            if (logined) {
                window.open($("#wangpanlink").val());
               // $("#downwanpan").attr("href", $("#wangpanlink").val());
            }
        });

        $("#set_like_info").click(function () {
            Open_Like_Box();
        });
        $("#not_like_info").click(function () {
            var logined = CheckLogined();
            if (logined) {
                Open_Like_Box();
            }
           // alertMsg("提示信息", "少侠，您还未进入江湖");
        });


    });


//弹出框下载
    function goto_down_forme() {
        var logined = CheckLogined();
        if (logined) {
            Open_showdiv_Box('div_to_down_area');
        }

    }

 


/////////////////////////////////////////////////////////////////////////////////
function LikeLoadData() {
    var infoId = $("#infoId").val();
    var InfoType = $("#InfoType").val();
    var productCover = $("#productCover").val();
    var InfoTitle = $("#puinfobody h3").text();
    var Info_UserID = $("#Info_UserID").val();
    var save_type = $("#save_type").val();
    var ProductsCheats = $("#pplselectlabeltxt").text();
   var info_likecount = $("#info_likecount").val();

    var jsontext = { infoId: infoId, productCover: productCover, InfoType: InfoType, InfoTitle: InfoTitle, Info_UserID: Info_UserID, save_type: save_type, ProductsCheats: ProductsCheats, info_likecount: info_likecount };
    ajax_json_postV1("/services/like/", jsontext, 20000, true, LikeLoadData_SuccessFn, LikeLoadData_BeforeSend, LikeData_ErrorFn);
}


function LikeLoadData_SuccessFn(data) {
    //$("#Btn_comments-form-submit").removeAttr("disabled"); $("#Btn_comments-form-submit").val("发表评论");
    switch (data.message) {
        case "error": alertMsg("提示信息", "收藏不成功哦，用万能的刷新之后重试呗"); break;
        case "success": CloseLikeBox(); $("#like_count").text(parseInt($("#like_count").text()) + 1);
            //$("#comments-list").prepend(data.Content);
            break;
        case "haslike": alertMsg("提示信息", "您已经喜欢过了，小的建议您去下载学习哦"); break;
        case "timeout": alertMsg("提示信息", "哥,貌似您还没登录哦"); ToLogin(); break;
    }
}
function LikeLoadData_BeforeSend() {

}

function LikeData_ErrorFn() {
    // alertMsg("提示信息", "停留时间过长，可点此<a href=\"/\">刷新 »</a>重试");
}

//////////////////////////////////////////////////////////////////////////////////
function DownLoadData() {
    var infoId = $("#infoId").val();
    var jsontext = { infoId: infoId};
    ajax_json_postV1("/services/download/", jsontext, 20000, false, DownLoadData_SuccessFn, DownLoadData_ErrorFn, DownLoadData_BeforeSend);
}


function DownLoadData_SuccessFn(data) {
    //$("#Btn_comments-form-submit").removeAttr("disabled"); $("#Btn_comments-form-submit").val("发表评论");
    switch (data.message) {
        case "error": alertMsg("提示信息", "不知道什么原因未能下载，用万能的“刷新”重试呗"); break;
        case "success": download(data.loadpath); break;
        case "wanpan": 
            //var $tempForm = $('<form method="get" target="_blank" action="' + data.loadpath + '"></form>');
            //$("body").append($tempForm);
            //$tempForm.submit(); $tempForm.remove(); 
             window.open(data.loadpath);
             break;
        case "point": alertMsg("提示信息", "施主的修为不够，G币不足，试试去上传分享素材赚取G币<br>Tips:1 个人主页签到+20 40 60<br> Tips:2 评论收藏作品各+5<br>Tips:3 上传作品+20 下载返G币 <br> Tips:4 每天登录一次+5"); break;
        case "timeout": alertMsg("提示信息", "哥,貌似您还么登录哦"); ToLogin(); break;
    }
}
function DownLoadData_BeforeSend() {

}

function DownLoadData_ErrorFn() {
    // alertMsg("提示信息", "停留时间过长，可点此<a href=\"/\">刷新 »</a>重试");
}

function SubmitCommentsData(ParentID) {

    var user_comment =$.trim($("#comment" + ParentID).val());
    var infoId = $("#infoId").val();
    var InfoType = $("#InfoType").val();
    var InfoTitle = $("#Info_Title").val();
    var Info_UserID = $("#Info_UserID").val();
    if (user_comment.length ==0) {
        alertMsg("提示信息", "哥，给点面子多少写点内容吧");
        return;
    }
    if (user_comment.length > 500) {
        alertMsg("提示信息", "哥，您的点评太长，楼主看着累啊.");
        return;
    }
    var jsontext = { infoId: infoId, InfoType: InfoType, user_comment: user_comment, ParentID: ParentID, InfoTitle: InfoTitle, Info_UserID: Info_UserID };
    if (ParentID != "") {
        $("#re_Comment_Submit" + ParentID).attr("disabled", "disabled");
        $("#re_Comment_Submit" + ParentID).val("正在提交点评…");
        ajax_json_postV1("/services/tocomment/", jsontext, 30000, true, ReComments_SuccessFn, Comments_ErrorFn, ReComments_BeforeSend);
    }
    else {
        ajax_json_postV1("/services/tocomment/", jsontext, 30000, true, Comments_SuccessFn, Comments_ErrorFn, Comments_BeforeSend);
    }
}

function Comments_SuccessFn(data) {
    $("#Btn_comments-form-submit").removeAttr("disabled"); $("#Btn_comments-form-submit").val("发表评论");
    switch (data.message) {
        case "notallow": alertMsg("提示信息", "貌似您评论的有点频繁啊，拜托用心给个好评论呗."); break;
        case "error": alertMsg("提示信息", "哥,您的点评失败了,请补全信息,如再次提交失败可用万能的“刷新”重试."); break;
        case "success": alertMsg("提示信息", "评论成功,离大神又进一步了，希望对您有所帮助");
            $("#comments-list").prepend(data.Content);
            break;
        case "success2": $("#comments-list").prepend(data.Content); break;
        case "timeout": alertMsg("提示信息", "哥,貌似您还么登录哦"); ToLogin(); break;
    }
}
function ReComments_SuccessFn(data) {

    $(".submitbtn").removeAttr("disabled"); $(".submitbtn").val("确认回复");
    switch (data.message) {
        case "notallow": alertMsg("提示信息", "貌似您评论的有点频繁啊，拜托用心给个好评论呗."); break;
        case "error": alertMsg("提示信息", "哥,您的点评失败了,请补全信息,如再次提交失败可用万能的“刷新”重试."); break;
        case "success": alertMsg("提示信息", "评论成功，离大神又进一步了,希望对您有所帮助");
            $("#re_Coment_list_" + data.ComID).append(data.Content);
            break;
        case "success2": $("#re_Coment_list_" + data.ComID).append(data.Content); break;
        case "timeout": alertMsg("提示信息", "哥,貌似您还么登录哦"); ToLogin(); break;
    }
}
function Comments_BeforeSend() {
    $("#Btn_comments-form-submit").attr("disabled", "disabled");
    $("#Btn_comments-form-submit").val("正在提交点评…");
}

function ReComments_BeforeSend() {

}

function Comments_ErrorFn() {
    // alertMsg("提示信息", "停留时间过长，可点此<a href=\"/\">刷新 »</a>重试");
}

function download(filepath) {
    var form = $("<form>"); //定义一个form表单
    form.attr("style", "display:none");
    form.attr("target", "");
    form.attr("method", "post");
    form.attr("action", "/download.html");
    var input1 = $("<input>");
    input1.attr("type", "hidden");
    input1.attr("name", "exportData");
    input1.attr("value", filepath);
    $("body").append(form); //将表单放置在web中
    form.append(input1);

    form.submit(); //表单提交 
}


	function weiboShare(){
 var select_pics="";
    var img_count = $("#projectpost img").length;
    for (var i = 0; i < img_count; i++) {
        var cur_src=$("#projectpost img").eq(i).attr("src");
        if (cur_src!="/images/baiduwanpanicon.png") {
       
            if (cur_src.indexOf("http://")==-1) {
                cur_src="http://www.ui3g.com" +cur_src;
            }
            if ((img_count > 1 && i == 0) || i == (img_count - 1)) {
                select_pics += cur_src; break;
            }
            else {
                select_pics += cur_src+",";
            }
        }
    }
     var wb_shareBtn = document.getElementById("shareBtn"),
          wb_url = document.URL, //获取当前页面地址，也可自定义例：wb_url = "http://www.ui3g.com"
          wb_appkey = "1935333839",
          wb_title = "",
          wb_ralateUid = "1740316050",
          wb_pic = select_pics,
          wb_language = "zh_cn";
 
          wb_shareBtn.setAttribute("href","http://service.weibo.com/share/share.php?url="+wb_url+"&appkey="+wb_appkey+"&title="+wb_title+"&pic="+wb_pic+"&ralateUid="+wb_ralateUid+"&language="+wb_language+"");
}
weiboShare()

function qqShare(){
      var select_pics="";
    var img_count = $("#projectpost img").length;
    for (var i = 0; i < img_count; i++) {
        var cur_src=$("#projectpost img").eq(i).attr("src");
        if (cur_src!="/images/baiduwanpanicon.png") {
       
            if (cur_src.indexOf("http://")==-1) {
                cur_src="http://www.ui3g.com" +cur_src;
            }
            if ((img_count > 5 && i == 5) || i == (img_count - 1)) {
                select_pics += encodeURIComponent(cur_src); break;
            }
            else {
                select_pics += encodeURIComponent(cur_src)+"|";
            }
        }
    }
     var qq_shareBtn = document.getElementById("shareBtnq")
          qq_url = document.URL, //获取当前页面地址，也可自定义例：wb_url = "http://www.ui3g.com"
          qq_appkey = "36492a26a143afe40e2fe07b300dd4e0",
          qq_title = document.title,
          wb_ralateUid = "1740316050",
          qq_pic =select_pics;
 
          qq_shareBtn.setAttribute("href","http://share.v.t.qq.com/index.php?c=share&a=index&url="+qq_url+"&title="+qq_title+"&pic="+qq_pic+"&appkey="+qq_appkey+"");
}
qqShare()
