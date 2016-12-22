<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="height: 100%;" xmlns:wb="http://open.weibo.com/wb" xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>优设记 - 最全jquery插件下载 - 高质量网页素材</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <jsp:include page="../common/header_style.jsp"/>
<%@include file="../common/taglib.jsp"%>
</head>
<body style="height: 100%;"><iframe id="sina_anywhere_iframe" style="display: none;"></iframe>
	<div id="page">
	
	      <jsp:include page="../common/header.jsp"/>
      <jsp:include page="../common/bannar.jsp"/>
	
        <div id="site-content">
            <div id="content-wrapper" class="grid-site cfix">
            	<div class="cfix" id="content-leftbox">
			
                      <c:forEach items="${techlist}" varStatus="i" var="item">
                           <div class="cover-block project-cover cfix"><!--鼠标滑到图片上class="hover"-->
                            <div class="cover-img">
                                <a href="/topic/list?categoryId=${item.id}" class="cover-img-link">
                                    <img title="${item.rmsValue}" class="cover-img-el cover-img-standard"
                                       src="${item.imgUrl}" alt="${item.rmsValue}">
                                </a>
                            &nbsp;</div>
                            <div class="cover-info-stats">
                                <div class="cover-info">
                                  <div class="cover-name">
                                    <a href="/topic/list?categoryId=${item.id}">${item.rmsValue}</a>
                                  </div>
                                  <<%--div class="cover-by-wrap">
                                    <div class="cover-by-link ">by
                                        <a target="_blank" href="" class="text-ellipsis single-owner-link">${item.createUser}</a>
                                    </div>
                                  </div>--%><!-- .cover-by-wrap -->
                                </div><!-- .cover-info -->
                                <div class="cover-stat-fields-wrap">
                                  <%--<div class="cover-stat-wrap">
                                    <span class="stat-value cover-stat-appreciations ui-icon">0</span>
                                    <span class="stat-value hide-phone ui-icon">296</span>
                                    <div class="featured tooltipi-container">
                                        <span class="ui-icon ui-tj"></span>
                                    </div>
                                  </div>--%><!-- .cover-stat-wrap -->

                                  <div class="cover-fields">
                                            <a title="${item.description}" target="_blank" href="/topic/list?categoryId=${item.id}">${item.description}</a>,
                                  </div><!-- .cover-fields -->
                                </div><!-- .cover-info -->
                              </div>
                        </div>
                      </c:forEach>

        

                    <div class="clear"></div>
                    <div id="pages">
                    <a href="http://www.ui3g.com/index-1.html" id="pageactive"> 1</a> 
                    <a href="http://www.ui3g.com/index-2.html">2</a>  
                    <a href="http://www.ui3g.com/index-3.html">3</a>  
                    <a href="http://www.ui3g.com/index-4.html">4</a>  
                    <a href="http://www.ui3g.com/index-5.html">5</a>  
                    <a href="http://www.ui3g.com/index-6.html">6</a>  
                    <a href="http://www.ui3g.com/index-7.html">7</a> <span>...</span> 
                    <a href="http://www.ui3g.com/index-2.html" id="pagenext"><span class="ui-icon ui-ppr"></span></a>
                    </div>
                </div>
                 

      <div class="fl" id="filters">
                	<div class="filter-block hide-wip menu-closed">
                        <div class="list-header discover-sprite-pre">热门领域</div>
                        <ul class="list-links">
                            <c:forEach items="${topiclist}" varStatus="i" var="item">
                                <li><a href="/topic/content/${item.id}.htm" title="${item.name}">${item.name}</a></li>
                            </c:forEach>
<%--                          <li><a href="http://www.ui3g.com/texiao/" title="jquery特效">jquery特效</a></li>
                          <li><a href="http://www.ui3g.com/css3/" title="css3">css3动画</a></li>
                          <li><a href="http://www.ui3g.com/uisou.html?uikey=PSD" title="PSD">PSD</a></li>
                          <li><a href="http://www.ui3g.com/app/" title="移动应用">移动应用</a></li>    --%>
                        </ul>
                     </div>
			<!----><%--<div class="filter-block floor-fixed-panel">
			            <div class="list-header">便民服务</div>
                    	<ul class="floor-nav-list">
                            <li class="nav-phone"><a href="http://www.ui3g.com/examples/triangulator/" target="_blank"><i></i><span>制作多边形图像的网页工具</span></a></li>
                            <li class="nav-computer"><a href="http://www.ui3g.com/ps/index.html" target="_blank"><i></i><span>PS 国外大神攻略修炼手册</span></a></li>
                            <li class="nav-electronics"><a href="http://www.ui3g.com/examples/webfuzhu/demo.html" target="_blank"><i></i><span>代码优化前端辅助工具</span></a></li>
                            <li class="nav-jewelry"><a href="http://www.ui3g.com/examples/BrandColors.html" target="_blank"><i></i><span>世界品牌logo色调集</span></a></li>
                            
                        </ul>
                    </div>--%>
		     <!---->
                     <div class="filter-block hide" style="display: block;">
                          <div class="list-header">相关标签</div>
  			                <div class="cfix" id="object-tags">
                          	<ul class="m-tags">
                                <c:forEach items="${techlist}" varStatus="i" var="item">
                                  <li><a href="/topic/list?categoryId=${item.id}">${item.rmsValue}</a></li>
                                </c:forEach>
                              </ul>
                          </div>
    
                     </div>
		     	
                     
                </div>



                 
            </div>
	    
        </div>
        <div id="links"><span>友情链接：</span><a href="http://www.csdn.com/" target="_blank">csdn</a>
            <a href="http://51cto.com/" target="_blank" rel="nofollow">51cto</a>

 
 
 <jsp:include page="../common/footer.jsp"/>
 
         <div class="wp">
            <div style="display: none;" id="o_helper">
                <div id="o_helper_c">
                    
                </div>
                <span hidefocus="true"><a class="my_scrolltopa" onclick="window.scrollTo('0','0')" title="返回顶部"><b>返回顶部</b></a></span>
<%--                <span><a title="我的关注" class="my_favthread" hidefocus="true" href="http://www.ui3g.com/me/following/" rel="nofollow"><b>我的关注</b></a></span>
                <span><a title="素材需求" class="my_pm" href="http://www.ui3g.com/feedback.html" rel="nofollow" target="_blank"><b>素材需求</b></a></span>--%>
            </div>
            <style>
            #o_helper {visibility: visible; position: fixed; bottom: 85px; display: block; margin-left: 1080px; width: 120px; height: 315px;z-index: 9999;_position: absolute;_top: expression(document.documentElement.clientHeight + document.documentElement.scrollTop - this.offsetHeight + "px"); display:none;}
            #o_helper a { display: block; width: 40px; height: 42px; padding: 3px 5px; line-height: 12px; text-align: center; color: #787878; text-decoration: none; background:#fff url(http://www.ui3g.com/images/scrolltop_new.png) no-repeat 0 0; border: 1px solid #c4c4c4;border-bottom: 0;cursor: pointer;}
            #o_helper span:last-child a{border-bottom: 1px solid #c4c4c4;}
            #o_helper a b { visibility: hidden;}
            #o_helper a span.new {width: 4px;height: 4px;background: url(/frontstatic/images/point_new.png) no-repeat;position: absolute;left: 38px;bottom: 38px;display: block;}
            #o_helper a.my_scrolltopa { background-position: 5px 4px !important;}
            #o_helper a.my_scrolltopa:hover { background-position: -44px 4px !important;}
            #o_helper a.my_favthread { background-position: 5px -45px !important; }
            #o_helper a.my_favthread:hover { background-position: -44px -45px !important;}
            #o_helper a.my_pm { background-position: 5px -96px !important;}
            #o_helper a.my_pm:hover { background-position: -44px -96px !important;}
            
#o_helper_c {
    height: 165px;
    margin-left: -30px;
    position: relative;
    width: 190px;
    z-index: 99999;
}
           .wp{ margin:0 auto; width:1000px;}
            </style>
            <script type="text/javascript">
            jQuery(document).ready(function(){
            window.setTimeout('oshowInfo();', 2000);
            })
            function oshowInfo(falg){
            if(getcookie('o_hideInfo') != 1 || falg ==1){
            jQuery("#o_helper_c .o_info").show();
            setcookie('o_hideInfo', 0, 9000);
            }
            }
            function ohideInfo(){
            jQuery("#o_helper_c .o_info").hide();
            if(getcookie('o_hideInfo') != 1){
            setcookie('o_hideInfo', 1, 900);
            }
            }
            </script>
            <!-- 小O助手 -->
        </div>
<!-- <script src="js/jquery-1_002.js" type="text/javascript"></script> -->
<script src="/frontstatic/js/jquery-1.js" type="text/javascript"></script>
<script src="/frontstatic/js/CheckCommon.js" type="text/javascript"></script>
<script src="/frontstatic/js/Helper.js" type="text/javascript"></script>
<script src="/frontstatic/js/ajax_REST-1.js" type="text/javascript"></script>
<!-- <script src="js/js-jiaoben.js" type="text/javascript"></script> -->
<script type="text/javascript">
	
    //back to top
$(window).scroll(function(){var scrTop=$(window).scrollTop();var windowTop=$(window).height();if(scrTop<=68){$(".navboxbg").css({top:"0",left:"0",position:"relative","z-index":"998"});$("#showcase-and-discover").css('margin-top','12px');$("#sorts-container").css({position:"relative",top:"0"});$("#o_helper").css('display','none')}else if(scrTop>366){$("#sorts-container").css({position:"fixed",top:"34px"});$(".navboxbg").css({top:"0",left:"0",position:"fixed","z-index":"999"});$("#o_helper").css('display','block')}else{$(".navboxbg").css({top:"0",left:"0",position:"fixed","z-index":"999"});$("#showcase-and-discover").css('margin-top','46px');$("#sorts-container").css({position:"relative",top:"0"});$("#o_helper").css('display','block')}});
//
eval(function(p,a,c,k,e,r){e=String;if('0'.replace(0,e)==0){while(c--)r[e(c)]=k[c];k=[function(e){return r[e]||e}];e=function(){return'[01]'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('$("#sub_advincetous").click(function(){alertMsg("提示信息","想必您有宝贵的意见建议，欢迎加入我们的0群咨询.<1>UI3g优设记0群号：153364618<1>Email邮箱: info@ui3g.com")});',[],2,'QQ|br'.split('|'),0,{}))
</script>
    </div>  
    <script type="text/javascript">
        //图片轮滚：star
        $(function () {
            var sWidth = $("#citemss").width(); //获取焦点图的宽度（显示面积）
            var len = $("#citemss ul li").length; //获取焦点图个数
            var index = 0;
            var picTimer;
            showPics(index);
            //以下代码添加数字按钮和按钮后的半透明条，还有上一页、下一页两个按钮
            var btn = "";


            $(".citemslide").append(btn);

            //上一页按钮
            $("#citemss .slideprev").click(function () {
                index -= 1;
                if (index == -1) { index = len - 1; }
                showPics(index);
            });

            //下一页按钮
            $("#citemss .slidenext").click(function () {
                index += 1;
                if (index == len) { index = 0; }
                showPics(index);
            });

            //本例为左右滚动，即所有li元素都是在同一排向左浮动，所以这里需要计算出外围ul元素的宽度
            $("#citemss ul").css("width", sWidth * (len));

            //鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
            $("#citemss").hover(function () {
                clearInterval(picTimer);
            }, function () {
                picTimer = setInterval(function () {
                    showPics(index);
                    index++;
                    if (index == len) { index = 0; }
                }, 4000); //此4000代表自动播放的间隔，单位：毫秒
            }).trigger("mouseleave");

            //显示图片函数，根据接收的index值显示相应的内容
            function showPics(index) { //普通切换
                var nowLeft = -index * sWidth; //根据index值计算ul元素的left值
                $("#citemss ul").stop(true, false).animate({ "left": nowLeft }, 300); //通过animate()调整ul元素滚动到计算出的position
                $(".citemslide .y_right_banner").removeClass("on").eq(index).addClass("on"); //为当前的按钮切换到选中的效果
                $(".citemslide .y_right_banner").stop(true, false).addClass("on").eq(index).stop(true, false).removeClass("on"); //为当前的按钮切换到选中的效果
            }
        });


</script>
	</body>
</html>