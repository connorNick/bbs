<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>${topic.name}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link type="text/css" href="/frontstatic/css/info.css" rel="stylesheet"/>
<script type="text/javascript" src="/frontstatic/editor/ckeditor/syntaxhighlighter_3.0.83/scripts/shCore.js"></script>
<script type="text/javascript" src="/frontstatic/editor/ckeditor/syntaxhighlighter_3.0.83/scripts/shBrushes.js"></script>
<link type="text/css" rel="Stylesheet" href="/frontstatic/editor/ckeditor/syntaxhighlighter_3.0.83/styles/shCoreDefault.css" />
    <script type="text/javascript" src="/frontstatic/editor/js/jquery-1.3.2.min.js"></script>
<%--<link rel="stylesheet" href="/frontstatic/css/share_style0_16.css"/>--%>
    <jsp:include page="../common/header_style.jsp"/>
    <%@include file="../common/taglib.jsp"%>
    <script type="text/javascript">
        // $(".toolbar").remove();
        SyntaxHighlighter.all();
        SyntaxHighlighter.defaults['toolbar'] = false;
    </script>
</head>

<body><iframe style="display: none;" id="sina_anywhere_iframe"></iframe>
<div id="page">

	<jsp:include page="../common/header.jsp" />


        <div id="site-content">

    <div id="content-wrapper" class="grid-site cfix">


            	<div class="projectblock cfix">

                    <div id="puinfo">
                        <div id="puinfobody">
                            <h3> ${topic.name}</h3><!--标题后台输入最长15个汉字-->
                            <p>
                            	系统分类： <a title="网页设计" href="/topic/list?categoryId=${topic.categoryId}">${topic.categoryName}</a>
                                <span class="ui-icon yy-time"><fmt:formatDate value="${topic.createTime}" pattern="yyyy-MM-dd"/></span>
                                <input name="wangpanlink" id="wangpanlink" value="http://pan.baidu.com/s/1c0xUID6" type="hidden">
                             </p>
                        </div>
                        <span class="fr" id="prenqi"><span>人气</span>${topic.count}</span>
                    </div>
                    <div class="clear"></div>
<%--                    <p id="plicense">亲们该页面内会员们分享的“作品”，版权为才华横溢的原作者们所有滴，不得商业使用！</p>--%>
                    <div id="projectpost">
                    	<ul>

                        	<li class="tupic"><%--<a target="_blank" href=""><img src="/frontstatic/images/271420130926141608_38575.jpg"></a>--%>
                                ${topic.content}
                            </li>
<%--                            <li class="tupic">56个源文件banner设计下载</li>--%>

                        </ul>

			<%--<div class="banquan">

        <dl>
          <dd>
            ================<strong>关于优设记</strong>================<br>
“优设记ui3g.com“是国内最全jquery插件下载 - 高质量网页素材的学习下载平台<br>

<strong>资源微博</strong>：同步网站更新内容，订阅jquery资源 @吐槽优设记，欢迎关注获取网页设计资源、下载顶尖设计素材。

          </dd>
          <dd>
            <span>文章链接： </span><a href="http://www.ui3g.com/design/uiweb-369.html">http://www.ui3g.com/design/uiweb-369.html</a> <span>非特殊说明，本文版权归原作者所有，转载请注明出处</span>
          </dd>

      </dl></div>--%>
                    </div>


               <%--<div id="div_to_down_area" style="opacity:0; top:-500px; width:528px; height:300px" class="showbox1 fixed hide">
    	<div id="popuplai" class="popuplitem fixed-container">
        	<div id="pplhead" style="margin-bottom:18px;">
            	<div class="pplc">PSD56个淘宝内部Banner图片PSD源文件</div>
            </div>
            <div class="pplc">
            	<h2 class="jq">
                    <span>我当前G币余额：</span><soan id="mycost" class="num">0</soan>
                    <span>已下载次数：</span><span class="num">951</span>
                </h2>
                <small>注：购买该插件的用户当日可免费下载 插件作者可永久免费下载</small>
                <div class="ddom">
                    <h2 class="fl">
                      <span>所需G币：</span><span id="needcost" class="num">20</span>
                        <a href="http://www.ui3g.com/score.html" target="_blank"><img class="downwh" src="/frontstatic/images/wh.png"></a>
                    </h2>

                                   <a id="to_download" href="javascript:void(0);"><img src="/frontstatic/images/wpan1.png" title="百度云盘PSD下载" style="width: 220px; height:74px; " width="220" vspace="0" hspace="0" height="40" border="0"></a>

                </div>
                <p class="txt-center">下载提示：由于文件较小，请直接点击下载，不支持迅雷等下载工具。</p>

                <h3 style="display: block;" class="warn">
                    <span>抱歉</span> <a href="http://www.ui3g.com/score.html" target="_balnk">G币</a> <span>不足，你可以通过</span> <a href="http://www.ui3g.com/me/web/" target="_balnk">上传PSD</a> &amp;  <a href="http://www.ui3g.com/me/code/" target="_balnk">jquery</a> <span>或</span> <a href="http://www.ui3g.com/me/pointbuy/" target="_balnk">充值</a> <span>获得G币</span>
                </h3>

                <h3 style="display: none;" class="pass">
                    <span>由于</span> <span class="reason"></span> <span>你可以直接下载，不消耗G币</span>
                </h3>
            </div>
            <button type="button" class="close_layer close_showbg"><img src="/frontstatic/images/btn_close.png" width="24" height="24"></button>
        </div>
</div>--%>


                    <%--<div id="projectfoot">
                    	<div style="overflow:hidden">

                             <a class="plike" id="not_like_info" href="javascript:void();"><span class="ui-icon yy-likew"></span>收 藏 (<span id="like_count" class="likecount">53</span>)</a>

                            <!--<a class="add-to-collection" href="#"><span class="ui-icon yy-addc"></span>转采到收集(<span class="likecount">15</span>)</a> 以后再使用-->
                        </div>
                    </div>--%>
                </div>

                <div class="otherbox cfix">

                	<div class="comments-header" id="comments-header">
            			<!--<h4 class="block-title">我还是很喜欢你，像风走了八千里，不问归期 多一点耐心少一点浮躁有什么新鲜事想告诉大家? 分享有礼<b style="color:red;"> +5G币</b>:(已有<span class="comments-total">73</span> 评论)</h4>-->
                                 <h4 class="block-title">据说认真评论作品的以后都迅速成长为大神了(已有<span class="comments-total">${topic.count}</span> 评论)</h4>
    				</div>
                    <div class="block-content">
                    	<div class="post-comment-block" id="pinglun">

                            <form method="post"  id="repayFrom" action="/topicreply/add.htm">
                                <input type="hidden" name="topicId" value="${topic.id}"/>
                                <input type="hidden" name="parentRepayId" value="0"/>
                                <input type="hidden" name="userId" value="0"/>
                            	<div id="comment-container" class="form-item form-item-textarea ui-front">
                                	<textarea id="comment" cols="60" rows="10" class="form-textarea comment_text ui-autocomplete-input" name="content" autocomplete="off"></textarea>
								</div>

                                <div id="comments-form-submit-container" class="form-item form-item-a">
                                    <div class="form-item form-item-a" id="repayMsg" style="display:none">

                                    </div>
                                    <input id="Btn_comments-form-submit" class="form-button form-button-default" value="发表评论" type="button">
                                </div>

                            </form>

						</div>

                        <div id="comments-list-container">
                        	<ul class="comments-list" id="comments-list">

                                <c:forEach items="${trlist}" varStatus="vs" var="item" >
                                        <li data-id="11470287" class="comment-container cfix user-comment">

                                            <%--头像--%>
                                              <a href="http://www.ui3g.com/sky/ui-18649.html" class="comment-user-image-link fl">
                                                <img src="/frontstatic/images/100_002.jpg" class="comment-user-image js-mini-profile">
                                              </a>


                                              <div class="comment-text-container">
                                                    <div class="comment-user-date-wrap">
                                                          <c:if test="${not empty item.username}">
                                                              <a href="http://www.ui3g.com/sky/ui-18649.html" class="user-name-link bold">
                                                              ${item.username}
                                                              </a>
                                                          </c:if>
                                                          <c:if test="${empty item.username}">
                                                              匿名
                                                          </c:if>
                                                       <span class="comment-date"> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></span>
                                                    </div>
                                                    <div class="comment-text-wrap" id="re_Coment_list_4699">
                                                        <div class="comment-text">
                                                                ${item.content}
                                                             <a class="cm-s5 " dataid="4699" href="javascript:void();">[回复]</a>
                                                         </div>

                                                     </div>
                                                     <!--div以内的所有内容html输出为空-->
                                                     <%--<div class="postreply" id="ToCommnet_4699" style="display:none;">
                                                        <textarea autocomplete="off" class="inputnone" id="comment4699"></textarea>
                                                        <span class="submitwarning" style="display: inline-block;">内容不能少于4个字</span>
                                                        <a class="submitbtn canclbtn" href="javascript:void();" dataid="4699">取消评论</a>
                                                        <input class="submitbtn" id="re_Comment_Submit4699&quot;" dataid="4699" onclick="SubmitCommentsData('4699')" value="确认回复" type="button">

                                                        <div class="clear"></div>
                                                     </div>  --%>
                                              </div>
                                        </li>
                                </c:forEach>



                            	<%--<li data-id="11470287" class="comment-container cfix user-comment">
                                      <a href="http://www.ui3g.com/sky/ui-17585.html" class="comment-user-image-link fl">

                                        <img src="/frontstatic/images/100.jpg" class="comment-user-image js-mini-profile">
                                      </a>
                                      <div class="comment-text-container">
                                            <div class="comment-user-date-wrap">
                                              <a href="http://www.ui3g.com/sky/ui-17585.html" class="user-name-link bold">Yannis</a> <span class="comment-date"> 2016-09-21</span>

                                            </div>
                                            <div class="comment-text-wrap" id="re_Coment_list_4401">
                                                <div class="comment-text">
                                                谢谢
                                                     <a class="cm-s5 " dataid="4401" href="javascript:void();">[回复]</a>
                                                 </div>

                                             </div>
                                             <!--div以内的所有内容html输出为空-->
                                             <div class="postreply" id="ToCommnet_4401" style="display:none;">
                                                 <form method="post"  id="repayFrom" action="/topicreply/add.htm">
                                                     <input type="hidden" name="topicId" value="${topic.id}"/>
                                                     <input type="hidden" name="parentRepayId" value="0"/>
                                                     <input type="hidden" name="userId" value="0"/>
                                                    <textarea autocomplete="off" name="content" class="inputnone" id="comment4401"></textarea>
                                                    <span class="submitwarning" style="display: inline-block;">内容不能少于4个字</span>
                                                    <a class="submitbtn canclbtn" href="javascript:void();" dataid="4401">取消评论</a>
                                                    <input class="submitbtn" id="re_Comment_Submit4401&quot;" dataid="4401" onclick="SubmitCommentsData('4401')" value="确认回复" type="button"/>

                                                 </form>

                                                <div class="clear"></div>
                                             </div>
                                      </div>
                                </li>--%>




                            </ul>
                        </div>
                        <div class="demo customBootstrap">
                            <%--<p id="demo2-text"></p>--%>
                            <ul id="topicPage" class="pagination"></ul>
                        </div>
                          <%--<div id="pages">
                          <a href="http://www.ui3g.com/design/uiweb-369-1.html#pinglun" id="pageactive"> 1</a>
                              <a href="http://www.ui3g.com/design/uiweb-369-2.html#pinglun">2</a>
                              <a href="http://www.ui3g.com/design/uiweb-369-3.html#pinglun">3</a>  <a href="http://www.ui3g.com/design/uiweb-369-4.html#pinglun">4</a>
                              <a href="http://www.ui3g.com/design/uiweb-369-6.html#pinglun">6</a><a href="http://www.ui3g.com/design/uiweb-369-7.html#pinglun">7</a><span>...</span>
                              <a href="http://www.ui3g.com/design/uiweb-369-2.html#pinglun" id="pagenext"><span class="ui-icon ui-ppr"></span></a>
                            </div>--%>

                    </div>
                </div>

            </div>
        </div>



 <jsp:include page="../common/footer.jsp" />




<%--<script src="/frontstatic/js/jquery-1_002.js" type="text/javascript"></script>--%>
<%--<script src="/frontstatic/js/CheckCommon.js" type="text/javascript"></script>
<script src="/frontstatic/js/Helper.js" type="text/javascript"></script>
<script src="/frontstatic/js/ajax_REST-1.js" type="text/javascript"></script>
<script src="/frontstatic/js/js-jiaoben.js" type="text/javascript"></script>--%>
<script type="text/javascript">
    //back to top
$(window).scroll(function(){var scrTop=$(window).scrollTop();var windowTop=$(window).height();if(scrTop<=68){$(".navboxbg").css({top:"0",left:"0",position:"relative","z-index":"998"});$("#showcase-and-discover").css('margin-top','12px');$("#sorts-container").css({position:"relative",top:"0"});$("#o_helper").css('display','none')}else if(scrTop>366){$("#sorts-container").css({position:"fixed",top:"34px"});$(".navboxbg").css({top:"0",left:"0",position:"fixed","z-index":"999"});$("#o_helper").css('display','block')}else{$(".navboxbg").css({top:"0",left:"0",position:"fixed","z-index":"999"});$("#showcase-and-discover").css('margin-top','46px');$("#sorts-container").css({position:"relative",top:"0"});$("#o_helper").css('display','block')}});
//
eval(function(p,a,c,k,e,r){e=String;if('0'.replace(0,e)==0){while(c--)r[e(c)]=k[c];k=[function(e){return r[e]||e}];e=function(){return'[01]'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('$("#sub_advincetous").click(function(){alertMsg("提示信息","想必您有宝贵的意见建议，欢迎加入我们的0群咨询.<1>UI3g优设记0群号：153364618<1>Email邮箱: info@ui3g.com")});',[],2,'QQ|br'.split('|'),0,{}))
</script>
    <script type="text/javascript" src="/frontstatic/jqPaginator/js/jqPaginator.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

            $("#topicPage").jqPaginator({
                totalCounts: ${total},//设置总条数
                visiblePages: 9,//设置最多显示的页码数（例如有100也，当前第1页，则显示1 - 7页）
                currentPage: ${vo.pageable.currentPage},//设置当前的页码
                pageSize:5,//设置每一页的条目数,注意：要么设置totalPages，要么设置totalCounts + pageSize，否则报错；设置了totalCounts和pageSize后，会自动计算出totalPages。
                first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
                prev: '<li class="prev"><a href="javascript:void(0);"><i class="arrow arrow2"><\/i>上一页<\/a><\/li>',
                next: '<li class="next"><a href="javascript:void(0);">下一页<i class="arrow arrow3"><\/i><\/a><\/li>',
                last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
                page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
                onPageChange: function (n,type) {
                    if(type!='init'){
                        window.location.href="/topic/content/${topic.id}.htm?start="+((n-1)*5)+"&length="+5;
                    }
                }
            });

            $("#Btn_comments-form-submit").click(function () {
                            var comment=$("#comment").val();
                            if(comment==''||comment==null){
                                $("#repayMsg").html("请输入内容");
                                $("#repayMsg").attr("style","display:''");
                            }else if(comment.length>500){
                                $("#repayMsg").html("内容长度不能大于500");
                                $("#repayMsg").attr("style","display:''");
                            }else{
                                $("#repayFrom").submit();
                            }
            });
        });

    </script>
    </div>
<%--<script src="/frontstatic/js/homejs-like.js" type="text/javascript"></script>--%>

</body></html>