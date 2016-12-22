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
<jsp:include page="../common/header.jsp"/>
<body id="nv_forum" class="pg_index" onkeydown="if(event.keyCode==27) return false;">

    <div id="wp" class="wp">
        <div class="wp">
            <div class="aacd">
                <div id="pt" class="bm cl">
                </div>
            </div>
        </div>

        <div id="ct" class="wp cl">

            <!--[diy=diy_chart]--><div id="diy_chart" class="area"></div><!--[/diy]-->
            <div class="mn">
                <div class="fl bm">
                    <div class="bm bmw  flg cl">
                        <div class="bm_h cl bkh61">
                            <span class="o">
                            <img id="category_61_img" src="/frontstatic/images/collapsed_no.gif" title="收起/展开" alt="收起/展开" onclick="toggle_collapse('category_61');">
                            </span>
                            <h2><a href="" style="">课程中心</a></h2>
                        </div>

                        <div id="category_61" class="bm_c" style="">
                            <table class="fl_tb" cellpadding="0" cellspacing="0">
                                <tbody>
                                    <tr>
                                        <td class="fl_g" width="19.9%">
                                            <div class="fl_icn_g" style="width: 758px;">
                                                <a href="/topic/list"><img src="/frontstatic/images/common_62_icon.png" alt="" align="left"></a></div>
                                            <dl style="margin-left: 758px;">
                                                <dt><a href="/topic/list">Activiti</a></dt>
                                                <%--<dd><em><i>主题: </i>4</em>, <em><i>帖数: </i>4</em></dd><dd class="zyzy">
                                                <a href="">最后发表: 2016-6-23 11:46</a>
                                            </dd>--%>
                                            </dl>
                                        </td>
                                        <td width="19.9%">&nbsp;</td><td width="19.9%">&nbsp;</td><td width="19.9%">&nbsp;</td></tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
                <div class="wp">
                <!--[diy=diy3]--><div id="diy3" class="area"></div><!--[/diy]-->
            </div>

                <div id="online" class="bm oll">
                    <div class="bm_h">
                        <span class="o"><a href="" title="收起/展开"><img src="/frontstatic/images/collapsed_no.gif" alt="收起/展开"></a></span>
                        <h3>
                            <strong class="biti"><a href="">在线会员</a></strong>
                                <span class="xs1"> <strong>10</strong> 人在线- <strong>0</strong> 会员(<strong>0</strong> 隐身),
                                <strong>10</strong> 位游客- 最高记录是 <strong>356</strong> 于 <strong>2015-7-15</strong>.</span>
                        </h3>
                    </div>
                    <dl id="onlinelist" class="bm_c">
                        <dt class="ptm pbm bbda">
                            <img src="/frontstatic/images/online_admin.gif"> 管理员 &nbsp; &nbsp; &nbsp;
                            <img src="/frontstatic/images/online_supermod.gif"> 超级版主 &nbsp; &nbsp; &nbsp;
                            <img src="/frontstatic/images/online_moderator.gif"> 版主 &nbsp; &nbsp; &nbsp;
                            <img src="/frontstatic/images/online_member.gif"> 会员 &nbsp; &nbsp; &nbsp;
                        </dt>
                        <dd class="ptm pbm">
                            <ul class="cl">
                                <li style="width: auto">当前只有游客或隐身会员在线</li>
                            </ul>
                        </dd>
                    </dl>
                </div>
            </div>

        </div>


        <script>fixed_top_nv();</script>
    </div>
<%--    <link rel="stylesheet" type="text/css" href="images/index.htm">--%>

<jsp:include page="../common/footer.jsp"/>
</div>
<!--bottombg结束-->
</body>
</html>