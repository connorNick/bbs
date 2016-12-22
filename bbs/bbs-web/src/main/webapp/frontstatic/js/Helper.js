//判断浏览器
function getOs() {
    var OsObject = "";
    if (navigator.userAgent.indexOf("MSIE") > 0) {
        return "MSIE";
    }
    if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
        return "Firefox";
    }
    if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
        return "Safari";
    }
    if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
        return "Camino";
    }
    if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
        return "Gecko";
    }
}
//某年某月有多少天
function getDaysInMonth(year, month) {
    month = parseInt(month, 10) + 1;
    var temp = new Date(year + "/" + month + "/0");
    return temp.getDate();
}




//加法运算
function accAdd(arg1, arg2) {
    var r1, r2, m;
    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
    m = Math.pow(10, Math.max(r1, r2))
    return (arg1 * m + arg2 * m) / m
}
//减法运算
function Subtr(arg1, arg2) {
    var r1, r2, m, n;
    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
    m = Math.pow(10, Math.max(r1, r2));
    //last modify by deeka
    //动态控制精度长度
    n = (r1 >= r2) ? r1 : r2;
    return ((arg1 * m - arg2 * m) / m).toFixed(n);
}
//除法运算
function accDiv(arg1, arg2) {
    var t1 = 0, t2 = 0, r1, r2;
    try { t1 = arg1.toString().split(".")[1].length } catch (e) { }
    try { t2 = arg2.toString().split(".")[1].length } catch (e) { }
    with (Math) {
        r1 = Number(arg1.toString().replace(".", ""))
        r2 = Number(arg2.toString().replace(".", ""))
        return (r1 / r2) * pow(10, t2 - t1);
    }
}

//乘法运算
function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try { m += s1.split(".")[1].length } catch (e) { }
    try { m += s2.split(".")[1].length } catch (e) { }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}


//页面高宽
function getBrowserHeight() {
    if ($.browser.msie) {
        return document.compatMode == "CSS1Compat" ? document.documentElement.scrollHeight :
                  document.body.scrollHeight;
    } else {
        return document.body.scrollHeight;
    }
}


function pageHeight() {
    if ($.browser.msie) {
        return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight :
        document.body.clientHeight;
    } else {
        return self.innerHeight;
    }
};

function pageWidth() {
    if ($.browser.msie) {
        return document.compatMode == "CSS1Compat" ? document.documentElement.clientWidth :
        document.body.clientWidth;
    } else {
        return self.innerWidth;
    }
};


//把层放在可视页面的中间参数为层的id
function centerPopup(DivName) {
    //获取系统变量 
    var windowWidth = pageWidth();
    var popupWidth = $("#" + DivName + "").width();
    //居中设置     
    $("#" + DivName + "").css({ "position": "absolute", "left": windowWidth / 2 - popupWidth / 2 });
    //高度定位
    var menuYloc = $("#" + DivName + "").offset().top;
    var offsetTop = menuYloc + $(window).scrollTop() + "px";
    $("#" + DivName + "").animate({ top: offsetTop }, { duration: 0, queue: false });
}
//把层放在可视页面的中间参数为层的id 水平垂直居中
function centerVerPopup(DivName) {
    //获取系统变量 
    var windowWidth = pageWidth();
    var popupWidth = $("#" + DivName + "").width();
    //居中设置     
    $("#" + DivName + "").css({ "position": "absolute", "left": windowWidth / 2 - popupWidth / 2 });
    //高度定位
    var menuYloc = $(window).height() / 2 - $("#" + DivName + "").height();
    var offsetTop = menuYloc + $(window).scrollTop() + "px";
    $("#" + DivName + "").animate({ top: offsetTop }, { duration: 0, queue: false });
}



//去除空格
String.prototype.Trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.LTrim = function () {
    return this.replace(/(^\s*)/g, "");
}
String.prototype.RTrim = function () {
    return this.replace(/(\s*$)/g, "");
}

//鼠标定位
function getPosLeft(obj) {
    var l = obj.offsetLeft;
    while (obj = obj.offsetParent) {
        l += obj.offsetLeft;
    }

    return l;
}

function getPosTop(obj) {
    var l = obj.offsetTop;
    while (obj = obj.offsetParent) {
        l += obj.offsetTop;
    }
    return l;
}

// 字符验证
function checkStr(str, maxlength) {
    var error = "";
    if (str.length == 0) {
        error = "不能为空";
    } else if (str.length > maxlength) {
        error = "超过最大字数限制(" + maxlength + ")"
    }
    return error;
}
//
function getBox(el) {
    var left, right, top, bottom, width, height;
    var offset1 = el.offset();
    left = offset1.left;
    top = offset1.top;



    right = left + el.offsetWidth;
    bottom = top + el.offsetHeight;

    return {
        left: left,
        right: right,
        top: top,
        bottom: bottom,
        width: el.width(),
        height: el.height()
    };
}

function copyLayout(from, to) {
    var box = getBox(from);
    to.css({
        left: box.left + "px",
        top: box.top + "px",
        height: box.height + "px",
        width: box.width + "px"
    });

}

function LayoutFn(from, to, LeftStr, TopStr) {
    var left, top;
    var OffsetStr = from.offset();
    left = OffsetStr.left;
    top = OffsetStr.top;

    to.css({
        left: left + LeftStr + "px",
        top: top + TopStr + "px"
    });

}

//////////删除提示
function BtDeleteClick() {
    if (confirm("你确定要删除此条信息？")) {
        return true;
    }
    else {
        return false;
    }
}

function BtDeleteClick_V1() {
    if (confirm("你确定要删除此条信息？如果删除，则相应的附件也会被删除！")) {
        return true;
    }
    else {
        return false;
    }
}

function BtTruncateClick() {
    if (confirm("你确定要清空信息?")) {
        return true;
    }
    else {
        return false;
    }
}

//////////控制内容页的高度显示
$(function () {
    var pageheight = pageHeight();
    //内容
});


//////固定表格第一行////////////////////////
//根据屏幕文档宽度动态获取单元格的宽度
function GetTdWidth(TitleFixed, LeftTrFixed, TdIndex) {
    if ($(".fr_list  table tr.title").offset() != null) {
        /////////////////////////固定第一行 表头///////////////////////////////
        if (TitleFixed) {
            var FixdTdHeight = 31;
            var ArrWidth = new Array();
            var DocumentWidth = $(document).width();
            var ObjArr = $(".fr_list table tr:eq(0)").find("td");
            for (var i = 0; i < ObjArr.length; i++) {
                var TdWidth = $(".fr_list table tr:eq(0)").find("td").eq(i).width();
                var TempHeight = $(".fr_list table tr:eq(0)").find("td").eq(i).height();
                if (TempHeight > FixdTdHeight) {
                    FixdTdHeight = TempHeight;
                }
                ArrWidth[i] = TdWidth;
            }
            var Trhtml = $(".fr_list table tr:eq(0)").html();
            if ($(".YH_divfixed").length==0) {
                $("body").append("<div class=\"YH_divfixed\"><table> <tr class=\"fixtitle\">" + Trhtml + "</tr></table></div>");
            }
            else {
                $(".YH_divfixed").html("<table> <tr class=\"fixtitle\">" + Trhtml + "</tr></table>");
            }
            if ($(".YH_divfixed").length > 0) {
                var BgColor = $(".fr_list table tr:eq(0)").css('background-color');
                var Trwidth = $(".fr_list table").innerWidth();
                var ObjArr = $(".YH_divfixed table tr:eq(0)").find("td");
                $(".YH_divfixed table tr:eq(0)").css("background-color", BgColor);
                $(".YH_divfixed table").css("width", Trwidth);
                for (var i = 0; i < ObjArr.length; i++) {
                    $(ObjArr[i]).css("width", ArrWidth[i]);
                    $(ObjArr[i]).css("height", FixdTdHeight);
                }
            }
        }
       // alert("adfas");
        ///////////////////固定第一列///////////////////////////////
        if (LeftTrFixed) {
            var Arr_Height = new Array();
            var Tr_Arr = $(".fr_list table tr");
            var table = "<table>";
            var RowSpan = 0;
            var CurIndex = 0;
            var TDIndex = 0;
            for (var i = 0; i < Tr_Arr.length; i++) {
                var TD_Html = Tr_Arr.eq(i).find("td").eq(TdIndex).html();
                var RowSpan1 = Tr_Arr.eq(i).find("td").eq(TdIndex).attr("rowspan");
                //alert(RowSpan1);
                if (RowSpan1 != undefined && CurIndex == 0) {
                    RowSpan = parseInt(RowSpan1);
                    table += "<tr class=\"fixtitle\"><td>" + TD_Html + "</td></tr>";
                   // alert(navigator.appVersion);
                    if (/MSIE 7.0/ig.test(navigator.appVersion)) {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height() + 1;
                    }
                    else if (/MSIE 8.0/ig.test(navigator.appVersion)) {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height() + 1;
                       // alert(Arr_Height[TDIndex]);
                    } else if (/Chrome/ig.test(navigator.appVersion)) {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height() + 1;
                    }
                    else {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height();
                    }
                    TDIndex++;
                    CurIndex++;
                }
                if (RowSpan1 == undefined && CurIndex == 0) {
                    table += "<tr class=\"fixtitle\"><td>" + TD_Html + "</td></tr>";
                    if (/MSIE 7.0/ig.test(navigator.appVersion)) {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height() + 1;
                    } else if (/MSIE 8.0/ig.test(navigator.appVersion)) {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height() + 1;
                    } else if (/Chrome/ig.test(navigator.appVersion)) {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height() + 1;
                    }
                    else {
                        Arr_Height[TDIndex] = Tr_Arr.eq(i).find("td").eq(TdIndex).height();
                    }
                    TDIndex++;
                }
                if (CurIndex != RowSpan) {
                    CurIndex++;
                }
                else {
                    CurIndex = 0;
                    RowSpan = 0;
                }

            }
            table += "</table>";
           
            if ($(".YH_FirstTrfixed").length==0) {

                $("body").append("<div class=\"YH_FirstTrfixed\">" + table + "</div>");
            }
            else {
                $(".YH_FirstTrfixed").html(table);
            }
            if ($(".YH_FirstTrfixed").length > 0) {
                var TD_Width = $(".fr_list table tr:eq(0)").find("td").eq(TdIndex).width();
                var table_Width = $(".fr_list table tr:eq(0)").find("td").eq(TdIndex).innerWidth();
                var TD_Arr = $(".YH_FirstTrfixed table tr td");
                $(".YH_FirstTrfixed table").css("width", table_Width);
                for (var i = 0; i < TD_Arr.length; i++) {
                    $(TD_Arr[i]).css("width", TD_Width);
                    $(TD_Arr[i]).css("height", Arr_Height[i]);
                }
                //alert($(".YH_FirstTrfixed").html());
            }
        }
     ///////////////////////结束//////////////////////////////////////

    }
}
//根据屏幕文档宽度动态获取单元格的宽度
function SetTwoRow() {
    var FixdTdHeight = 31;
    var ArrWidth = new Array();
    var DocumentWidth = $(document).width();
    if ($(".YH_divfixed").length==0) {
        var Trhtml = "";
        for (var row = 0; row < 2; row++) {
            if (row == 0) {
                Trhtml += "<tr class=\"fixtitle\">" + $(".fr_list table tr:eq(" + row + ")").html() + "</tr>";
            }
            else {
                Trhtml += "<tr class=\"fixtitle\">" + $(".fr_list table tr:eq(" + row + ")").html() + "</tr>";
            }
        }
        $("body").append("<div class=\"YH_divfixed\"><table>" + Trhtml + "</table></div>");
    }

    for (var j = 0; j < 2; j++) {
        var ObjArr = $(".fr_list table tr:eq(" + j + ")").find("td");
        for (var i = 0; i < ObjArr.length; i++) {
            var TdWidth =  $(".fr_list table tr:eq(" + j + ")").find("td").eq(i).width();
            var TempHeight = $(".fr_list table tr:eq(" + j + ")").find("td").eq(i).height();
            if (TempHeight > FixdTdHeight) {
                FixdTdHeight = TempHeight;
            }
            ArrWidth[i] = TdWidth;
        }
        if ($(".YH_divfixed").length >0) {
            //var BgColor = $(".fr_list table tr:eq(" + j + ")").css('background-color');
            var Trwidth = $(".fr_list table tr:eq(" + j + ")").width();
            var ObjArr = $(".YH_divfixed table tr:eq(" + j + ")").find("td");
            // $(".YH_divfixed table tr:eq(" + j + ")").css("background-color", BgColor);
            $(".YH_divfixed table").css("width", Trwidth);
            for (var i = 0; i < ObjArr.length; i++) {
                $(ObjArr[i]).css("width", ArrWidth[i]);
                $(ObjArr[i]).css("height", FixdTdHeight);
            }
        }

    }

}
function FixTable() {
    var top = $(document).scrollTop();
    var left = $(document).scrollLeft();
    var OriTop = $(".fr_list  table tr.title").offset().top;
    if (/MSIE 7.0/ig.test(navigator.appVersion)) {
        OriTop = $(".fr_list  table tr.title").offset().top;
    } else if (/Chrome/ig.test(navigator.appVersion)) {
        OriTop = $(".fr_list  table tr.title").offset().top + 1;
    }
    else {
        OriTop = $(".fr_list  table tr.title").offset().top;
    }
    var OriLeft = $(".fr_list  table tr.title").offset().left 
    var FirstTdWidth=$(".fr_list table tr:eq(0)").find("td").eq(0).width();
    //alert(OriLeft);
    if (top > OriTop) {
        if ($(".YH_divfixed").length > 0) {
            $(".YH_divfixed").css({ "top": top})
            $(".YH_divfixed").show();
        }
    }
    else {
        if ($(".YH_divfixed").length > 0) {
            $(".YH_divfixed").hide();
        }
    }

    if (left > (OriLeft + FirstTdWidth)) {
        if ($(".YH_FirstTrfixed").length > 0) {
            $(".YH_FirstTrfixed").css({ "left": left - OriLeft, "top": OriTop })
            $(".YH_FirstTrfixed").show();
        }
    }
    else {
        if ($(".YH_FirstTrfixed").length > 0) {
            $(".YH_FirstTrfixed").hide();
        }
    }



}



var my_index = 1;
/*加载数据提示信息框*/
function ProToolTip(type) {
    if (type == "load") {
        my_index = $.layer({
            area: ['auto', 'auto'],
            title: false,
            closeBtn: false,
            dialog: { msg: '正在加载数据，请稍后...', type: 11 }
        });
    }
    else if (type == "error") {
        layer.close(my_index);
        $.layer({
            closeBtn: false,
            shadeClose: true,
            area: ['auto', 'auto'],
            title: false,
            dialog: { msg: '加载数据有误，请重试！', type: 3 }
        });
    }
    else if (type == "notice") {
        layer.close(my_index);
        $.layer({
            closeBtn: false,
            shadeClose: true,
            area: ['auto', 'auto'],
            title: false,
            dialog: { msg: '没有相关数据，请尝试其它搜索条件！', type: 8 }
        });
    }
    else if (type == "hide") {
        layer.close(my_index);
    }
}
function TKNoticeInfo(msgs) {
   var  my_index=$.layer({
        closeBtn: false,
        shadeClose: true,
        area: ['auto', 'auto'],
        title: false,
        dialog: { msg: msgs, type: 8 }
    });
    return my_index;

}

function TRRowColorChang(TrID) {
/////////////////单击锁定行颜色
    $(TrID).click(function () {
        $(TrID).css({"backgroundColor":"#FFF","color":"#000"});
        $(this).css({ "backgroundColor": "#cfdbeb", "color": "#000" });
     }
    );
    //////鼠标移上行变色////////////
     $(TrID).hover(
      function () {
          $(this).css({ "backgroundColor": "#f79e2b", "color": "#FFF" });
      },
      function () {
          if ($(this).css("backgroundColor") != "rgb(207, 219, 235)" && $(this).css("backgroundColor") != "#cfdbeb") {
              $(this).css({ "backgroundColor": "#FFF", "color": "#000" });
          }
      }
    );
}

//内容随滚动条滚动
//function htmlScroll() {
//    var top = document.body.scrollTop || document.documentElement.scrollTop;
//    if (elFix.data_top < top) {
//        elFix.style.position = 'fixed';
//        elFix.style.top = 0;
//        elFix.style.left = elFix.data_left;
//    }
//    else {
//        elFix.style.position = 'static';
//    }
//}

//function htmlPosition(obj) {
//    var o = obj;
//    var t = o.offsetTop;
//    var l = o.offsetLeft;
//    while (o = o.offsetParent) {
//        t += o.offsetTop;
//        l += o.offsetLeft;
//    }
//    obj.data_top = t;
//    obj.data_left = l;
//}

//var oldHtmlWidth = document.documentElement.offsetWidth;
//window.onresize = function () {
//    var newHtmlWidth = document.documentElement.offsetWidth;
//    if (oldHtmlWidth == newHtmlWidth) {
//        return;
//    }
//    oldHtmlWidth = newHtmlWidth;
//    elFix.style.position = 'static';
//    htmlPosition(elFix);
//    htmlScroll();
//}
//window.onscroll = htmlScroll;

function Close_Alert() {
    if ($("#DIV_alertMsg").length > 0) {
        $("#DIV_alertMsg").hide();
        $(".b-canvas").hide();
        
    }
}


//弹出提示框 title为标题，msgstr为提示信息
function alertMsg(title, msgStr,location) {
    var canver_Html = "<div id=\"divalert_back_canver\" class=\"alertblocking-div hide\" style=\"z-index: 1338;\"></div>";
    var Msg_html = "";
    Msg_html += "<div class=\"popuplitem\" id=\"uialertmsg_area\" style=\"top: 80px; opacity: 1;z-index: 1448;\"> ";
    Msg_html += "<div id=\"uialertmsg_areahead\">";
    Msg_html+="<div class=\"pplc\">";
    Msg_html += "<img width=\"92\" height=\"34\" src=\"/images/ui3g2.png\" alt=\"UI3g\">萌萌哒消息</div></div>";
    if (location != undefined) {
        Msg_html += "<div id=\"alertlayer_body\" class=\"alertlayer_body\">" + msgStr + " <span style=\"padding-left:20px\">正在跳转(1.5秒)...</span></div>";
    }
    else {
        Msg_html += "<div id=\"alertlayer_body\" class=\"alertlayer_body\">" + msgStr + "</div>";
    }
    Msg_html+=" <button id=\"close_alertdiv\" class=\"close_layer\" type=\"button\"><img width=\"24\" height=\"24\" src=\"/images/btn_close.png\"></button>";
    Msg_html+="</div>";
	
	if ($("#divalert_back_canver").length == 0) {
        $("body").append(canver_Html);
    }
    if ($("#uialertmsg_area").length > 0) {
        $("#alertlayer_body").html(msgStr);
        //$("#DIV_alertMsg").remove();
        //$(".b-canvas").remove();
    }
    else {
        $("body").append(Msg_html);
        if (location == undefined) {
            $('#close_alertdiv,#divalert_back_canver').click(function (event) {
                $('#uialertmsg_area').stop().animate({ top: -550, opacity: 0 }, 400);
                $("#divalert_back_canver").stop().fadeTo(400, 0, function () { $("#divalert_back_canver").css("display", "none") });
            });
        }
    }
    

    $('#uialertmsg_area').stop().animate({ top: 180, opacity: 1 }, 0);
    $("#divalert_back_canver").stop().fadeTo(0, 0.5, function () { $("#divalert_back_canver").css("display", "block") });

    if (location != undefined) {
        setTimeout("location.href='"+location+"'",1500);
    }


     //$(".b-canvas").css("opacity", "0");
    // centerVerPopup("DIV_alertMsg");





    //alert(msgStr);
//    var width, height;
//    if ($(document).height() > $(window).height()) {
//        height = $(document).height();
//    }
//    else {
//        height = $(window).height();
//    }
//    if ($(document).width() > $(window).width()) {
//        width = $(document).width();
//    }
//    else {
//        width = $(window).width();
//    }

//var Msg_html=" <div id=\"DIV_alertMsg\" class=\"b-panel b-dialog box-shadow4 bdr-rnd-3 offlinelist-dialog \" style=\"display: block; left: 367.5px; top: 6.5px;\">";
//       Msg_html+="<div class=\"dlg-hd b-rlv\">";
//       Msg_html += "<a class=\"dlg-cnr dlg-cnr-r\" id=\"_disk_id_15\" title=\"关闭\" href=\"javascript:Close_Alert();\"></a>";
//       Msg_html += "<h3><em></em>" + title + "</h3>";
//       Msg_html+="</div>";
//       Msg_html+="<div class=\"dlg-bd clearfix\">";
//       Msg_html+="<div class=\"b-bdr-1 clearfix\" id=\"OfflineListContainer\">";
//       Msg_html += "<div id=\"msgListOffline\" style=\"\" class=\"message-list-offline\">" + msgStr + "</div>";
//       Msg_html+="</div>";
//       Msg_html+="</div>";
//       Msg_html += "</div>";
//       Msg_html += "<div class=\"b-panel b-canvas\" style=\"left: 0px; top: 0px; width: " + width + "px; height: "+height+"px; display: block;\"></div>";

}



var jPrintArea = function (el) {
    PageSetup_Null();
    var iframe = document.createElement('IFRAME');
    var doc = null;
    $(iframe).attr('style', 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;');
    document.body.appendChild(iframe);
    doc = iframe.contentWindow.document;
    var links = window.document.getElementsByTagName('link');
    for (var i = 0; i < links.length; i++)
        if (links[i].rel.toLowerCase() == 'stylesheet')
            doc.write('<link type="text/css" rel="stylesheet" href="' + links[i].href + '"></link>');
    doc.write('<div class="' + $(el).attr("class") + '">' + $(el).html() + '</div>');
    doc.close();
    iframe.contentWindow.focus();
    iframe.contentWindow.print();
}
var HKEY_Root, HKEY_Path, HKEY_Key;
HKEY_Root = "HKEY_CURRENT_USER";
HKEY_Path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
//设置网页打印的页眉页脚为空
function PageSetup_Null() {
    try {
        var Wsh = new ActiveXObject("WScript.Shell");
        HKEY_Key = "header";
        Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");
        HKEY_Key = "footer";
        Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");
    }
    catch (e)
{ }

} 