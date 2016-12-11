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
 <%--   <jsp:include page="../common/header_style.jsp"/>--%>
    <%@include file="../common/taglib.jsp"%>
    <link rel="stylesheet" type="text/css" href="/frontstatic/css/style_2_common.css">
    <link rel="stylesheet" type="text/css" href="/frontstatic/css/style_2_forum_viewthread.css">
    <!-- ================== END BASE CSS STYLE ================== -->
</head>
<jsp:include page="../common/header.jsp"/>
<body id="nv_forum" class="pg_viewthread" onkeydown="if(event.keyCode==27) return false;">


<div class="bottombg">



    <!-- /topnav -->

    <div id="wp" class="wp">


        <div class="wp bgcc">
            <div class="aacd">
                <div id="pt" class="bm cl">
                    <div class="z">
                        <a href="" class="nvhm" title="首页">a</a>
                        <a href="" style="margin-left:5px;">首页</a><em>›</em>
                        <a href="">论坛首页</a> <em>›</em> <a href="">互动活动
                    </a> <em>›</em> <a href="">最新活动</a> <em>›
                    </em> <a href="">${topic.name}</a>
                    </div>
                </div>

                <!--[diy=diynavtop]--><div id="diynavtop" class="area"></div><!--[/diy]-->
            </div>
        </div>


        <div id="ct" class="wp cl">
            <div id="pgta" class="pgs mbm cl ">
                <div class="pgt"></div>
                    <span class="y pgb" id="visitedforums" onmouseover="">
                    <a href="">返回列表</a></span>
                <div class="fatie">
                    <a id="newspecial" onmouseover="" onclick=""
                       href="javascript:;" title="发新帖">发新帖</a></div></div>



            <div id="postlist" class="pl bm">
                <table class="aabbdd" cellpadding="0" cellspacing="0">
                    <tbody><tr>
                        <td class="pls ptn pbn sdad">
                            <div class="hm ptn">
                                <span class="xg1">查看:</span> <span class="xi1">695</span><span class="pipe">|</span><span class="xg1">回复:</span>
                                <span class="xi1">0</span>
                            </div>
                        </td>
                        <td class="plc ptm pbn vwthd sdad">
                            <div class="y">
                                <a href="" title="打印" target="_blank"><img src="/frontstatic/images/print.png" alt="打印" class="vm"></a>
                                <a href="" title="上一主题"><img src="/frontstatic/images/thread-prev.png" alt="上一主题" class="vm"></a>
                                <a href="" title="下一主题"><img src="/frontstatic/images/thread-next.png" alt="下一主题" class="vm"></a>
                            </div>
                            <h1 class="ts">
                                <span id="thread_subject"> ${topic.name}</span>
                            </h1>
<span class="xg1">
<a href="" onclick="">[复制链接]</a>
</span>
                        </td>
                    </tr>
                    </tbody></table>


                <table class="ad" cellpadding="0" cellspacing="0">
                    <tbody><tr>
                        <td class="pls">
                        </td>
                        <td class="plc">
                        </td>
                    </tr>
                    </tbody></table><div class="postaaa posta0" id="post_4714"><table id="pid4714" class="plhin" summary="pid4714" cellpadding="0" cellspacing="0">
                <tbody><tr>
                    <td class="pls" rowspan="2">
                        <div id="favatar4714" class="pls favatar">
                            <a name="lastpost"></a><div class="pi">
                            <div class="authi"><a href="" target="_blank" class="xw1">请完善昵称 </a>
                            </div>
                        </div>
                            <div class="p_pop blk bui card_gender_0" id="userinfo4714" style="display: none; margin-top: -11px;">
                                <div class="m z">
                                    <div id="userinfo4714_ma"></div>
                                </div>
                                <div class="i y">
                                    <div>
                                        <strong><a href="" target="_blank" class="xi2"></a></strong>
                                        <em>当前离线</em>
                                    </div><dl class="cl">
                                    <dt>积分</dt><dd><a href="" target="_blank" class="xi2">5410</a></dd>
                                </dl><div class="imicn">
                                    <a href="" target="_blank" title="查看详细资料"><img src="/frontstatic/images/userinfo.gif" alt="查看详细资料"></a>
                                </div>
                                    <div id="avatarfeed"><span id="threadsortswait"></span></div>
                                </div>
                            </div>
                            <div>
                                <div class="avatar" onmouseover="showauthor(this, 'userinfo4714')"><a href="" class="avtm" target="_blank">
                                    <img src="/frontstatic/images/avatar.jpg"></a></div>
                            </div>
                            <div class="tns xg2"><table cellpadding="0" cellspacing="0"><tbody><tr><th><p>
                                <a href="" class="xi2">645</a></p>主题</th><th>
                                <p><a href="" class="xi2">650</a></p>帖子</th><td><p><a href="" class="xi2">5410</a></p>积分</td></tr></tbody></table></div>

                            <p><em><a href="" target="_blank">管理员</a></em></p>


                            <p><span><img src="/frontstatic/images/star_level3.gif" alt="Rank: 9"><img src="/frontstatic/images/star_level3.gif" alt="Rank: 9">
                                <img src="/frontstatic/images/star_level1.gif" alt="Rank: 9"></span></p>
                            <dl class="pil cl">
                                <dt>积分</dt><dd><a href="" target="_blank" class="xi2">5410</a></dd>
                            </dl>

                            <dl class="pil cl"></dl><ul class="xl xl2 o cl">
                            <li class="pm2"><a href="" onclick="showWindow('sendpm', this.href);" title="发消息" class="xi2">发消息</a></li>
                        </ul>
                        </div>
                    </td>

                    <td class="plc">
                        <div class="pi">
                            <div id="fj" class="y">
                                <label class="z">电梯直达</label>
                                <input class="px p_fre z" size="2"  onkeydown="" title="跳转到指定楼层" type="text">
                                <a href="javascript:;" id="fj_btn" class="z" title="跳转到指定楼层">
                                    <img src="/frontstatic/images/fj_btn.png" alt="跳转到指定楼层" class="vm"></a>
                            </div>
                            <strong>
                                <a href="" id="postnum4714" onclick="setCopy(this.href, '帖子地址复制成功');return false;">
                                    楼主</a>
                            </strong>
                            <div class="pti">
                                <div class="pdbt">
                                </div>
                                <div class="authi">
                                    <img class="authicn vm" id="authicon4714" src="/frontstatic/images/online_admin.gif">
                                    <em id="authorposton4714">发表于 2016-7-5 11:09:23</em>
                                    <span class="pipe">|</span>
                                    <a href="" rel="nofollow">只看该作者</a>
                                    <span class="none"><img src="/frontstatic/images/arw_r.gif" class="vm" alt="回帖奖励"></span>
                                    <span class="pipe show">|</span><a href="" class="show">倒序浏览</a>
                                    <span class="pipe show">|</span><a href="javascript:;" onclick="readmode($('thread_subject').innerHTML, 4714);" class="show">阅读模式</a>
                                </div>
                            </div>
                        </div><div class="pct"><div class="pcb">

                        <div class="t_fsz">
                            <table cellpadding="0" cellspacing="0"><tbody><tr><td class="t_f" id="postmessage_4714">
                                <br>
                                <div><font color="#333333"><font face="arial, 微软雅黑,">&nbsp; &nbsp;
                                    <p style="line-height:30px;text-indent:2em;text-align:left">为


                                ${topic.content}
                                </p>
                                    <p style="line-height:30px;text-indent:2em;text-align:center"></p><p style="line-height:30px;text-indent:2em;text-align:center"></p>
                                    <p style="line-height:30px;text-indent:2em;text-align:center"></p><p style="line-height:30px;text-indent:2em;text-align:center"><br>
                                </p></font></font></div><br>
                                <div align="center"><strong><font face="宋体"><font size="7"><font color="#ff0000"><br>
                                </font></font></font></strong></div><br>
                                <br>
                            </td></tr></tbody></table>

                            <div class="ptg mbm mtn">
                                <a title="超人" href="" target="_blank">超人</a></div>
                            <div class="modact"><a href="" title="帖子模式" onclick="showWindow('viewthreadmod', this.href)">
                                本主题由 System 于 2016-8-4 12:01 解除限时高亮</a></div><div class="attach_nopermission attach_tips">
                            <div>
                                <h3><strong>本帖子中包含更多资源</strong></h3>
                                <p>您需要 <a href="" onclick="showWindow('login', this.href);return false;">登录</a> 才可以下载或查看，没有帐号？
                                    <a href="" title="注册帐号">立即注册</a> </p>
                            </div>
                            <span class="atips_close" onclick="this.parentNode.style.display='none'">x</span>
                        </div>

                        </div>
                        <div id="comment_4714" class="cm">
                        </div>

                        <div id="post_rate_div_4714"></div>

                        <div id="relate_subject"></div>
                    </div>
                    </div>

                    </td></tr>
                <tr><td class="plc plm">
                    <div id="p_btn" class="mtw mbm hm cl">

                        <a href="" id="k_favorite" onclick="" onmouseover="this.title = $('favoritenumber').innerHTML + ' 人收藏'" title="收藏本帖"><i>
                            <img src="/frontstatic/images/fav.gif" alt="收藏">收藏<span id="favoritenumber" style="display:none">0</span></i></a>
                    </div>
                    <div class="mtw mbw">
                        <h3 class="pbm mbm bbda">相关帖子</h3>
                        <ul class="xl xl2 cl"><li>• <a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=949" title="超人学院第九期大数据高薪就业班招生了" target="_blank">超人学院第九期大数据高薪就业班招生了</a></li>
                            <li>• <a href="" title="超人学院年薪过50W的学员获得超人学院奖励" target="_blank">超人学院年薪过50W的学员获得超人学院奖励</a></li>
                            <li>• <a href="" title="超人学院平均就业薪资新鲜出炉" target="_blank">超人学院平均就业薪资新鲜出炉</a></li>
                            <li>• <a href="" title="超人学院第七期就业学员展示" target="_blank">超人学院第七期就业学员展示</a></li>
                            <li>• <a href="" title="超人学院就业捷报" target="_blank">超人学院就业捷报</a></li>
                            <li>• <a href="" title="超人学院第十期火爆招生中" target="_blank">超人学院第十期火爆招生中</a></li>
                            <li>• <a href="" title="超人学院携手中关村大数据产业联盟" target="_blank">超人学院携手中关村大数据产业联盟</a></li>
                            <li>• <a href="" title="超人学院面授精英班第四期" target="_blank">超人学院面授精英班第四期</a></li>
                            <li>• <a href="" title="首届超人杯博客分享大赛圆满结束了" target="_blank">首届超人杯博客分享大赛圆满结束了</a></li>
                            <li>• <a href="" title="超人学院免费公开课重磅来袭！！" target="_blank">超人学院免费公开课重磅来袭！！</a></li>
                        </ul>
                    </div>
                </td>
                </tr>
                <tr id="_postposition4714"></tr>
                <tr>
                    <td class="pls"></td>
                    <td class="plc" style="overflow:visible;">
                        <div class="po hin">
                            <div class="pob cl">
                                <em>
                                    <a class="fastre" href="" onclick="showWindow('reply', this.href)">回复</a>
                                </em>

                                <p>
                                    <a style="display: none;" href="javascript:;" id="mgc_post_4714" onmouseover="showMenu(this.id)" class="showmenu"></a>
                                    <a href="javascript:;" onclick="">举报</a>
                                </p>

                                <ul id="mgc_post_4714_menu" class="p_pop mgcmn" style="display: none;">
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr class="ad">
                    <td class="pls">
                    </td>
                    <td class="plc">
                    </td>
                </tr>
                </tbody></table>
            </div>

                <div id="postlistreply" class="pl"><div id="post_new" class="viewthread_table" style="display: none"></div></div>
            </div>


            <form method="post" autocomplete="off" name="modactions" id="modactions">
                <input name="formhash" value="755d8bc8" type="hidden">
                <input name="optgroup" type="hidden">
                <input name="operation" type="hidden">
                <input name="listextra" value="page%3D1" type="hidden">
                <input name="page" value="1" type="hidden">
            </form>



            <div class="pgs mtm mbm cl" id="pgtb">
                <span class="pgb y" id="visitedforumstmp" onmouseover="$('visitedforums').id = 'visitedforumstmp';this.id = 'visitedforums';showMenu({'ctrlid':this.id,'pos':'21'})"><a href="http://bbs.superwu.cn/forum.php?mod=forumdisplay&amp;fid=92&amp;page=1">返回列表</a></span>
                <div class="fatie"><a id="newspecialtmp" onmouseover="$('newspecial').id = 'newspecialtmp';this.id = 'newspecial';showMenu({'ctrlid':this.id})" onclick="showWindow('newthread', 'forum.php?mod=post&amp;action=newthread&amp;fid=92')" href="javascript:;" title="发新帖">发新帖</a></div>
            </div>



            <div id="f_pst" class="pl bm bmw">
                <form method="post" autocomplete="off" id="fastpostform" action="" onsubmit="return fastpostvalidate(this)">
                    <table cellpadding="0" cellspacing="0">
                        <tbody><tr>
                            <td class="pls">
                            </td>
                            <td class="plc">

                                <span id="fastpostreturn"></span>


                                <div class="cl">
                                    <div id="fastsmiliesdiv" class="y"><div id="fastsmiliesdiv_data"><div id="fastsmilies"></div></div></div><div class="hasfsl" id="fastposteditor">
                                    <div class="tedt mtn">
                                        <div class="bar">
<span class="y">
<a href="" onclick="return switchAdvanceMode(this.href)">高级模式</a>
</span><script src="/frontstatic/images/seditor.js" type="text/javascript"></script>
                                            <div class="fpd">
                                                <a href="javascript:;" title="文字加粗" class="fbld">B</a>
                                                <a href="javascript:;" title="设置文字颜色" class="fclr" id="fastpostforecolor">Color</a>
                                                <a id="fastpostimg" href="javascript:;" title="图片" class="fmg">Image</a>
                                                <a id="fastposturl" href="javascript:;" title="添加链接" class="flnk">Link</a>
                                                <a id="fastpostquote" href="javascript:;" title="引用" class="fqt">Quote</a>
                                                <a id="fastpostcode" href="javascript:;" title="代码" class="fcd">Code</a>
                                                <a href="javascript:;" class="fsml" id="fastpostsml">Smilies</a>
                                            </div></div>
                                        <div class="area">
                                            <div class="pt hm">
                                                您需要登录后才可以回帖 <a href="" onclick="showWindow('login', this.href)" class="xi2">登录</a> |
                                                <a href="" class="xi2">立即注册</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                <div id="seccheck_fastpost">
                                </div>


                                <input name="formhash" value="755d8bc8" type="hidden">
                                <input name="usesig" value="" type="hidden">
                                <input name="subject" value="  " type="hidden">
                                <p class="ptm pnpost">
                                    <a href="" class="y" target="_blank">本版积分规则</a>
                                    <button type="button" onclick="" onmouseover="" name="replysubmit" id="fastpostsubmit" class="pn pnc vm" value="replysubmit" tabindex="5"><strong>发表回复</strong></button>
                                    <label for="fastpostrefresh"><input id="fastpostrefresh" class="pc" type="checkbox">回帖后跳转到最后一页</label>
                                    <script type="text/javascript">if(getcookie('fastpostrefresh') == 1) {$('fastpostrefresh').checked=true;}</script>
                                </p>
                            </td>
                        </tr>
                        </tbody></table>
                </form>
            </div>

            <div id="visitedforums_menu" class="p_pop blk cl" style="display: none;">
                <table cellpadding="0" cellspacing="0">
                    <tbody><tr>
                        <td id="v_forums">
                            <h3 class="mbn pbn bbda xg1">浏览过的版块</h3>
                            <ul class="xl xl1">
                                <li><a href="">高薪课程</a></li><li>
                                <a href="">Hadoop</a></li><li>
                                <a href="">大数据行业资讯</a></li></ul>
                        </td>
                    </tr>
                    </tbody></table>
            </div>
        </div>

    </div>

</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>