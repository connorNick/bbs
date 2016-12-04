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
    <jsp:include page="../common/header.jsp"/>
    <%@include file="../common/taglib.jsp"%>
    <!-- ================== END BASE CSS STYLE ================== -->
</head>

<body id="nv_forum" class="pg_index" onkeydown="if(event.keyCode==27) return false;">
<div id="append_parent">
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 449.5px; display: none;" class="tip tip_4" id="tip_0.16655432910266077_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>处理es red问题shell脚本错误</strong><br>最近更新：2016-10-26<br>查看/回复: 115/0</div>
    </div><div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 368.5px; display: none;" class="tip tip_4" id="tip_0.034163663124954335_menu">
    <div class="tip_horn"></div><div class="tip_c">标题: <strong>请问通过java测试hdfs的连通性时，如何设置超时时间？</strong><br>最近更新：2016-11-1<br>查看/回复: 140/1</div>
</div><div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 365.5px; display: none;" class="tip tip_4" id="tip_0.19173133064536196_menu">
    <div class="tip_horn"></div><div class="tip_c">标题: <strong>Spark 的 KafkaUtils 报错</strong><br>最近更新：2016-11-1<br>查看/回复: 101/0</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 428.5px; display: none;" class="tip tip_4" id="tip_0.5823742943790714_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>客户端和hbase的链接</strong><br>最近更新：2016-10-29<br>查看/回复: 82/0</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 470.5px; display: none;" class="tip tip_4" id="tip_0.2455378347169609_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>Hadoop启动时失败，报SSH错误</strong><br>最近更新：2016-10-26<br>查看/回复: 104/0</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 512.5px; display: none;" class="tip tip_4" id="tip_0.41014482460481205_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>一个source,多个channel的应用场景</strong><br>最近更新：2016-10-20<br>查看/回复: 76/2</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 326.5px; display: none;" class="tip tip_4" id="tip_0.07655592165376257_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>在一个项目中同时使用两个不同的hbase集群数据</strong><br>最近更新：2016-11-2<br>查看/回复: 102/0</div>
    </div><div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 323.5px; display: none;" class="tip tip_4" id="tip_0.5095883084164405_menu">
    <div class="tip_horn"></div><div class="tip_c">标题: <strong>maven 无法下载jar包</strong><br>最近更新：2016-11-24<br>查看/回复: 61/1</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 407.5px; display: none;" class="tip tip_4" id="tip_0.6003506318680952_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>hadoop提交作业时间长</strong><br>最近更新：2016-10-31<br>查看/回复: 114/1</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 405px; top: 491.5px; display: none;" class="tip tip_4" id="tip_0.6579186560285887_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>对1T数据进行全局排序的方法？</strong><br>最近更新：2016-10-21<br>查看/回复: 139/1</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 694.5px; top: 305.5px; display: none;" class="tip tip_4" id="tip_0.11694089858690115_menu">
        <div class="tip_horn"></div><div class="tip_c">标题: <strong>请问通过java测试hdfs的连通性时，如何设置超时时间？</strong><br>最近更新：2016-11-1<br>查看/回复: 140/1</div></div>
    <div initialized="true" style="position: absolute; z-index: 501; left: 984px; top: 323.5px; display: none;" class="tip tip_4" id="tip_0.9126386436712595_menu"><div class="tip_horn"></div><div class="tip_c">标题: <strong>一个统计百分比的问题</strong><br>最近更新：2016-10-18<br>查看/回复: 151/3</div></div><div initialized="true" style="position: absolute; z-index: 501; left: 984px; top: 326.5px; display: none;" class="tip tip_4" id="tip_0.21930753940321623_menu"><div class="tip_horn"></div><div class="tip_c">标题: <strong>sqoop import或者export语法输入错误时，报错日志怎么配置？</strong><br>最近更新：2016-7-24<br>查看/回复: 298/4</div></div></div><div id="ajaxwaitid"></div>





<div id="qmenu_menu" class="p_pop blk" style="display: none;">
    <div class="ptm pbw hm">
        请 <a href="javascript:;" class="xi2" onclick="lsSubmit()"><strong>登录</strong></a> 后使用快捷导航<br>没有帐号？<a href="http://bbs.superwu.cn/member.php?mod=crxyregister" class="xi2 xw1">立即注册</a>
    </div>
</div><div class="bottombg">
    <!-- topnav -->
    <div id="wp_toptb" class="cl">

        <div class="wp cl">

            <div class="z">

                <a href="javascript:;" onclick="setHomepage('http://bbs.superwu.cn/');">设为首页</a>
                <span class="pipe">|</span><a href="http://bbs.superwu.cn/" onclick="addFavorite(this.href, '超人学院Hadoop,Hadoop,吴超,Hadoop网络培训,hadoop网络学院,最好hadoop培训机构,Hadoop远程培训,Hadoop免费视频下载,Hadoop学院,吴超Hadoop视频,大数据,云计算');return false;">收藏本站</a>





            </div>


            <div class="y">


                <div class="z"></div>
                <a href="http://bbs.superwu.cn/member.php?mod=logging&amp;action=login&amp;referer=" onclick="showWindow('login', this.href);return false;" title="登录">登录</a>

                <span class="wi_tpipe">|</span>

                <a href="http://bbs.superwu.cn/member.php?mod=crxyregister" title="立即注册">立即注册</a>

                <span class="wi_tpipe">|</span>

                <a href="javascript:;" onclick="showWindow('login', 'member.php?mod=logging&amp;action=login&amp;viewlostpw=1')" title="找回密码">找回密码</a>






            </div>


        </div>

    </div>


    <!--切换风格-->

    <div id="wist_menu" class="wi_pop" style="display: none;">

        <ul class="wi_skin cl">

            <li onclick="extstyle('')" title="时尚酷黑"><i></i></li>


        </ul>

    </div>

    <!-- /topnav -->
    <div id="hd"><div class="wp">
        <div class="hdc cl">

            <h2><a href="http://bbs.superwu.cn/" title="">
                <img src="/frontstatic/images/logo.png" alt="" border="0"></a></h2><div id="scbar" class="cl">

            <div id="bdcs"><div class="bdcs-container"><meta http-equiv="x-ua-compatible" content="IE=9">   <!-- 嵌入式 -->  <div class="bdcs-main bdcs-clearfix" id="default-searchbox">
                <div class="bdcs-search bdcs-clearfix" id="bdcs-search-inline">
                    <form action="http://zhannei.baidu.com/cse/search" method="get" target="_blank" class="bdcs-search-form" autocomplete="off" id="bdcs-search-form">
                        <input name="s" value="16872436162361829430" type="hidden">
                        <input name="entry" value="1" type="hidden">
                        <input style="height: 28px; line-height: 28px;" autocomplete="off" name="q" class="bdcs-search-form-input" id="bdcs-search-form-input" placeholder="请输入关键词" type="text">              <input class="bdcs-search-form-submit " id="bdcs-search-form-submit" value="搜索" type="submit">                       </form>      </div>                <div style="top: 107px; left: 974px; width: 247px;" class="bdcs-search-sug" id="bdcs-search-sug">              <ul class="bdcs-search-sug-list" id="bdcs-search-sug-list"></ul>          </div>                     <div class="bdcs-hot" id="bdcs-hot">               </div>       </div>                           </div></div>
        </div>


        </div>




    </div>


        <div style="" id="wi_wrap">
            <div id="nv">
                <ul>
                    <li class="xnv_1" id="mn_N25a2"><a href="http://www.crxy.cn/" hidefocus="true" title="超人学院官网">超人学院<span>超人学院官网</span></a></li>
                    <li class="xnv_2 a xnv_a2" id="mn_forum"><a href="http://bbs.superwu.cn/forum.php" hidefocus="true" title="BBS">论坛首页<span>BBS</span></a></li>
                    <li class="xnv_3" id="mn_P2"><a href="http://bbs.superwu.cn/portal.php?mod=list&amp;catid=2" hidefocus="true">课程中心</a></li>
                    <li class="xnv_4" id="mn_P7"><a href="http://bbs.superwu.cn/portal.php?mod=list&amp;catid=7" hidefocus="true">开班信息</a></li>
                    <li class="xnv_5" id="mn_P8"><a href="http://bbs.superwu.cn/portal.php?mod=list&amp;catid=8" hidefocus="true">就业资讯</a></li>
                    <li class="xnv_6" id="mn_N1e0b"><a href="http://www.superwu.cn/" hidefocus="true" target="_blank">沉思录</a></li>
                    <li class="xnv_7" id="mn_P6"><a href="http://bbs.superwu.cn/portal.php?mod=list&amp;catid=6" hidefocus="true">资源下载</a></li>




                </ul>
                <script src="js/nv.js" type="text/javascript"></script>
            </div>
        </div>

        <div class="p_pop h_pop" id="mn_userapp_menu" style="display: none"></div><div id="mu" class="cl">
        </div></div>






    <div id="wp" class="wp">

        <link rel="stylesheet" type="text/css" href="css/index.css">

        <!--[diy=diy1]--><div id="diy1" class="area"></div><!--[/diy]-->





        <style id="diy_style" type="text/css"></style>

        <div class="wp">
            <div class="aacd">
                <div id="pt" class="bm cl">
                    <div class="z">
                        <a href="http://bbs.superwu.cn/" class="nvhm" title="首页">
                            计算</a><em>›</em><a href="http://bbs.superwu.cn/forum.php">论坛首页</a></div>
                    <div class="z"></div>
                </div>
                <!--[diy=diyt]--><div id="diyt" class="area"></div><!--[/diy]-->
            </div>
        </div>

        <div id="ct" class="wp cl">
            <div id="chart" class="bm bw0 cl">
                <p class="chart z">今日: <em>0</em><span class="pipe">|</span>昨日: <em>0</em><span class="pipe">|</span>帖子: <em>4669</em><span class="pipe"><!--|</span>会员: <em>2604</em>-->
</span></p><div class="y">
                <a href="http://bbs.superwu.cn/forum.php?mod=guide&amp;view=new" title="最新回复" class="xi2">最新回复</a></div>
            </div>
            <!--[diy=diy_chart]--><div id="diy_chart" class="area"></div><!--[/diy]-->
            <div class="mn">

                <!-- index four grid -->
                <div class="fl bm">
                    <div class="bm bmw cl">
                        <div id="category_grid" class="bm_c">
                            <table cellpadding="0" cellspacing="0"><tbody><tr>
                                <td class="category_l1" valign="top">
                                    <div class="newimgbox">
                                        <h4><span class="tit_newimg"></span>最新图片</h4>
                                        <div class="module cl slidebox_grid" style="width:218px">
                                            <div class="slideouter" id="outer_0.12876052152033934" style="cursor:pointer;position:absolute;width:216px;height:198px;border:1px solid #C2D5E3"></div>

                                            <table style="cursor:pointer;width:218px;height:200px;table-layout:fixed;overflow:hidden;background:#F2F2F2;text-align:center" cellpadding="0" cellspacing="0"><tbody>
                                            <tr><td style="padding:0" id="slide_0.12876052152033934" valign="middle"><img title="CDH修改Hive元数据库为mysql报错 ..." src="/frontstatic/161934zstnnljtcrhcxlur.png" height="200" width="645"></td></tr></tbody></table><div id="switch_0.12876052152033934" style="position:absolute;margin-left:1px;margin-top:-18px">
                                            <div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_1_0.12876052152033934">1</div><div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(194, 213, 227);" id="switch_2_0.12876052152033934">2</div>
                                            <div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_3_0.12876052152033934">3</div><div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_4_0.12876052152033934">4</div>
                                            <div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_5_0.12876052152033934">5</div><div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_6_0.12876052152033934">6</div>
                                            <div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_7_0.12876052152033934">7</div><div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_8_0.12876052152033934">8</div>
                                            <div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_9_0.12876052152033934">9</div><div class="slideswitch" style="opacity: 0.7; float: left; cursor: pointer; width: 17px; height: 17px; overflow: hidden; font-weight: bold; text-align: center; font-size: 9px; color: rgb(68, 68, 68); border-right: 1px solid rgb(194, 213, 227); border-top: 1px solid rgb(194, 213, 227); background-color: rgb(242, 242, 242);" id="switch_10_0.12876052152033934">10</div></div>
                                        </div>
                                    </div>
                                </td>
                                <td class="category_l2" valign="top">
                                    <div class="subjectbox">
                                        <h4><span class="tit_subject"></span>最新主题</h4>
                                        <ul class="category_newlist">
                                            <li><a initialized="true" id="tip_0.5095883084164405" href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=2054&amp;extra=" tip="标题: &lt;strong&gt;maven 无法下载jar包&lt;/strong&gt;&lt;br/&gt;最近更新：2016-11-24&lt;br/&gt;查看/回复: 61/1" onmouseover="showTip(this)" target="_blank">maven 无法下载jar包</a></li>

                                            <li><a initialized="true" id="tip_0.19173133064536196" href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=2052&amp;extra=" tip="标题: &lt;strong&gt;Spark 的 KafkaUtils 报错&lt;/strong&gt;&lt;br/&gt;最近更新：2016-11-1&lt;br/&gt;查看/回复: 101/0" onmouseover="showTip(this)" target="_blank">Spark 的 KafkaUtils 报错</a></li>







                                        </ul>
                                    </div>
                                </td>
                                <td class="category_l3" valign="top">
                                    <div class="replaybox">
                                        <h4><span class="tit_replay"></span>最新回复</h4>
                                        <ul class="category_newlist">
                                            <li><a initialized="true" id="tip_0.11694089858690115" href="http://bbs.superwu.cn/forum.php?mod=redirect&amp;tid=2051&amp;goto=lastpost#lastpost" tip="标题: &lt;strong&gt;请问通过java测试hdfs的连通性时，如何设置超时时间？&lt;/strong&gt;&lt;br/&gt;最近更新：2016-11-1&lt;br/&gt;查看/回复: 140/1" onmouseover="showTip(this)" target="_blank">请问通过java测试hdfs的连通性时 ...</a></li>
                                            <li><a href="http://bbs.superwu.cn/forum.php?mod=redirect&amp;tid=2054&amp;goto=lastpost#lastpost" tip="标题: &lt;strong&gt;maven 无法下载jar包&lt;/strong&gt;&lt;br/&gt;最近更新：2016-11-24&lt;br/&gt;查看/回复: 61/1" onmouseover="showTip(this)" target="_blank">maven 无法下载jar包</a></li>








                                        </ul>
                                    </div>
                                </td>
                                <td class="category_l3" valign="top">
                                    <div class="hottiebox">
                                        <h4><span class="tit_hottie"></span>热帖<span style="display: none; width: 0px; height: 0px;" id="transmark"></span></h4>
                                        <ul class="category_newlist">
                                            <li><a initialized="true" id="tip_0.9126386436712595" href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=2041&amp;extra=" tip="标题: &lt;strong&gt;一个统计百分比的问题&lt;/strong&gt;&lt;br/&gt;最近更新：2016-10-18&lt;br/&gt;查看/回复: 151/3" onmouseover="showTip(this)" target="_blank">一个统计百分比的问题</a></li>
                                            <li><a initialized="true" id="tip_0.21930753940321623" href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=1968&amp;extra=" tip="标题: &lt;strong&gt;sqoop import或者export语法输入错误时，报错日志怎么配置？&lt;/strong&gt;&lt;br/&gt;最近更新：2016-7-24&lt;br/&gt;查看/回复: 298/4" onmouseover="showTip(this)" target="_blank">sqoop import或者export语法输入 ...</a></li>








                                        </ul>
                                    </div>
                                </td>
                            </tr></tbody></table>
                        </div>
                    </div>
                </div>
                <!-- index four grid end -->






                <div class="fl bm">
                    <div class="bm bmw  flg cl">
                        <div class="bm_h cl bkh61">

<span class="o">
<img id="category_61_img" src="/frontstatic/images/collapsed_no.gif" title="收起/展开" alt="收起/展开" onclick="toggle_collapse('category_61');">
</span>
                            <h2><a href="http://bbs.superwu.cn/forum.php?gid=61" style="">课程中心</a></h2>
                        </div>
                        <div id="category_61" class="bm_c" style="">
                            <table class="fl_tb" cellpadding="0" cellspacing="0">
                                <tbody><tr><td class="fl_g" width="19.9%">
                                    <div class="fl_icn_g" style="width: 758px;">
                                        <a href="http://bbs.superwu.cn/forum.php?mod=forumdisplay&amp;fid=62"><img src="/frontstatic/images/common_62_icon.png" alt="" align="left"></a></div>
                                    <dl style="margin-left: 758px;">
                                        <dt><a href="http://bbs.superwu.cn/forum.php?mod=forumdisplay&amp;fid=62">免费公开课</a></dt>
                                        <dd><em><i>主题: </i>4</em>, <em><i>帖数: </i>4</em></dd><dd class="zyzy">
                                        <a href="http://bbs.superwu.cn/forum.php?mod=redirect&amp;tid=1924&amp;goto=lastpost#lastpost">最后发表: 2016-6-23 11:46</a>
                                    </dd>
                                    </dl>
                                </td>
                                    <td class="fl_g" width="19.9%">
                                        <div class="fl_icn_g" style="width: 550px;">
                                            <a href="http://bbs.superwu.cn/forum.php?mod=forumdisplay&amp;fid=63"><img src="/frontstatic/images/common_63_icon.jpg" alt="" align="left"></a></div>
                                        <dl style="margin-left: 550px;">
                                            <dt><a href="http://bbs.superwu.cn/forum.php?mod=forumdisplay&amp;fid=63">高薪课程</a></dt>
                                            <dd><em><i>主题: </i>8</em>, <em><i>帖数: </i>14</em></dd><dd class="zyzy">
                                            <a href="http://bbs.superwu.cn/forum.php?mod=redirect&amp;tid=1618&amp;goto=lastpost#lastpost">最后发表: 2016-6-1 17:25</a>
                                        </dd>
                                        </dl>
                                    </td>
                                    <td width="19.9%">&nbsp;</td><td width="19.9%">&nbsp;</td><td width="19.9%">&nbsp;</td></tr>
                                </tbody></table>
                        </div>
                    </div>
                </div><div class="wp">
                <!--[diy=diy3]--><div id="diy3" class="area"></div><!--[/diy]-->
            </div>

                <div id="online" class="bm oll">
                    <div class="bm_h">
                        <span class="o"><a href="http://bbs.superwu.cn/forum.php?showoldetails=no#online" title="收起/展开"><img src="/frontstatic/images/collapsed_no.gif" alt="收起/展开"></a></span>
                        <h3>
                            <strong class="biti"><a href="http://bbs.superwu.cn/home.php?mod=space&amp;do=friend&amp;view=online&amp;type=member">在线会员</a></strong>
<span class="xs1"> <strong>10</strong> 人在线
- <strong>0</strong> 会员(<strong>0</strong> 隐身),
<strong>10</strong> 位游客
- 最高记录是 <strong>356</strong> 于 <strong>2015-7-15</strong>.</span>
                        </h3>
                    </div>
                    <dl id="onlinelist" class="bm_c">
                        <dt class="ptm pbm bbda"><img src="/frontstatic/images/online_admin.gif"> 管理员 &nbsp; &nbsp; &nbsp; <img src="/frontstatic/images/online_supermod.gif"> 超级版主 &nbsp; &nbsp; &nbsp; <img src="/frontstatic/images/online_moderator.gif"> 版主 &nbsp; &nbsp; &nbsp; <img src="/frontstatic/images/online_member.gif"> 会员 &nbsp; &nbsp; &nbsp; </dt>
                        <dd class="ptm pbm">
                            <ul class="cl">
                                <li style="width: auto">当前只有游客或隐身会员在线</li>
                            </ul>
                        </dd>
                    </dl>
                </div>


                <div class="bm lk">
                    <div id="category_lk" class="bm_c ptm">
                        <ul class="m mbn cl"><li class="lk_logo mbm bbda cl"><img src="/frontstatic/images/S03253260.png" alt="Apache Hadoop" border="0"><div class="lk_content z"><h5><a href="http://zh.wikipedia.org/wiki/Hadoop" target="_blank">Apache Hadoop</a></h5><p>Apache Hadoop在维基百科中的概述</p></div></li><li class="lk_logo mbm bbda cl">
                            <img src="/frontstatic/images/hadoop-logo.jpg" alt="Hadoop官方" border="0"><div class="lk_content z"><h5><a href="http://hadoop.apache.org/" target="_blank">Hadoop官方</a></h5>
                            <p>开发和运行处理大规模数据的软件平台</p></div></li><li class="lk_logo mbm bbda cl"><img src="/frontstatic/images/yarn_architecture.gif" alt="Yarn" border="0">
                            <div class="lk_content z"><h5><a href="http://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/YARN.html" target="_blank">Yarn</a></h5>
                                <p>更快、更强—解析Hadoop新一代MapReduce框架 Yarn</p></div></li><li class="lk_logo mbm bbda cl"><img src="/frontstatic/images/hbase_logo.png" alt="HBase" border="0">
                            <div class="lk_content z"><h5><a href="http://hbase.apache.org/" target="_blank">HBase</a></h5><p>分布式的、面向列的开源数据库</p></div></li>
                            <li class="lk_logo mbm bbda cl"><img src="/frontstatic/images/hive_logo_medium.jpg" alt="Hive" border="0"><div class="lk_content z">
                                <h5><a href="http://hive.apache.org/" target="_blank">Hive</a></h5><p>基于Hadoop的数据仓库工具</p></div></li><li class="lk_logo mbm bbda cl">
                                <img src="/frontstatic/images/favicon.ico" alt="Mahout" border="0"><div class="lk_content z"><h5><a href="http://mahout.apache.org/" target="_blank">Mahout</a></h5>
                                <p>可扩展的机器学习领域经典算法的实现</p></div></li><li class="lk_logo mbm bbda cl">
                                <img src="/frontstatic/images/zookeeper_small.gif" alt="ZooKeeper" border="0"><div class="lk_content z"><h5>
                                <a href="http://zookeeper.apache.org/" target="_blank">ZooKeeper</a></h5><p>针对大型分布式系统的可靠协调系统</p></div></li></ul>
                        <ul class="x mbm cl">
                            <li><a href="http://www.iteblog.com/" target="_blank" title="过往记忆">过往记忆</a></li></ul>
                    </div>
                </div>

            </div>

        </div>
        <script>fixed_top_nv();</script>
    </div>
<%--    <link rel="stylesheet" type="text/css" href="images/index.htm">--%>

    <div class="bm_c" style="display: none" id="focus_0">
        <dl class="xld cl bbda">
            <dt><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=24&amp;extra=page%3D1" class="xi2" target="_blank">超人学院学员8k * 15薪+ 项目奖金</a></dt>
            <dd>超人学院的一个学员，找到了hadoop工作，做交通视频图片的分析监控的，薪资待遇是：8k * 15薪 + 项目奖金。</dd>
        </dl>
        <p class="ptn cl"><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=24&amp;extra=page%3D1" class="xi2 y" target="_blank">查看 »</a></p>
    </div>
    <div class="bm_c" style="display: none" id="focus_1">
        <dl class="xld cl bbda">
            <dt><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=2&amp;extra=page%3D1" class="xi2" target="_blank">hadoop精华之MapReduce公开课</a></dt>
            <dd>目前，IT领域最火的是大数据和云计算。hadoop是大数据处理的事实标准，包括HDFS和MapReduce。大数据的价值就是通过计算被利用，从而体现出来的。因此MapReduce才是hadoop最核心、最有价值的部分。</dd>
        </dl>
        <p class="ptn cl"><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=2&amp;extra=page%3D1" class="xi2 y" target="_blank">查看 »</a></p>
    </div>
    <div class="bm_c" style="display: none" id="focus_2">
        <dl class="xld cl bbda">
            <dt><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=36&amp;extra=page%3D1" class="xi2" target="_blank">hadoop工作经验分享（1）——— 邮箱数据分析</a></dt>
            <dd>2月11日，非常荣幸邀请到超人学院的一位学员给我们分享他的hadoop工作经验，还有视频哦，精彩不容错过，赶紧来瞧一瞧吧！</dd>
        </dl>
        <p class="ptn cl"><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=36&amp;extra=page%3D1" class="xi2 y" target="_blank">查看 »</a></p>
    </div>
    <div class="bm_c" style="display: none" id="focus_3">
        <dl class="xld cl bbda">
            <dt><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=33&amp;extra=page%3D1" class="xi2" target="_blank">视频价值=1w!不信？来瞧瞧吧 </a></dt>
            <dd>超人学院有一学员通过教学视频的学习，找到了月薪10k的hadoop工作。给力吧，也希望你好好学习，早日找到理想的工作。</dd>
        </dl>
        <p class="ptn cl"><a href="http://bbs.superwu.cn/forum.php?mod=viewthread&amp;tid=33&amp;extra=page%3D1" class="xi2 y" target="_blank">查看 »</a></p>
    </div>


<jsp:include page="../common/footer.jsp"/>
</div>
<!--bottombg结束-->
</body>
</html>