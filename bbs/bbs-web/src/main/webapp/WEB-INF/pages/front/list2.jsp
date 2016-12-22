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
<%--
    <jsp:include page="../common/header_style.jsp"/>
--%>

  <link href="/frontstatic/css/all.css" rel="stylesheet" />
  <link href="/frontstatic/css/style.css" rel="stylesheet" />
  <link href="/frontstatic/css/style_2_common.css" rel="stylesheet" />

  <link href="/frontstatic/css/style_2_forum_forumdisplay.css" rel="stylesheet" />
  <link href="/frontstatic/css/style_2_forum_viewthread.css" rel="stylesheet" />
  <link href="/frontstatic/css/index.css" rel="stylesheet" />
  <link href="/frontstatic/css/main.css" rel="stylesheet" />
  <link href="/frontstatic/css/cssreset.css" rel="stylesheet" />
  <link href="/frontstatic/css/fix.css" rel="stylesheet" />
  <link href="/frontstatic/css/float.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="/frontstatic/paging/css/paging.css">
  <%@include file="../common/taglib.jsp"%>
  <style type="text/css">
     </style>
  <!-- ================== END BASE CSS STYLE ================== -->
</head>
<jsp:include page="../common/header.jsp"/>
<body id="nv_forum" class="pg_forumdisplay" onkeydown="if(event.keyCode==27) return false;">

<div class="bottombg">
  <!-- topnav -->

  <div id="wist_menu" class="wi_pop" style="display: none;">
    <ul class="wi_skin cl"></ul>
  </div><!-- /topnav -->

  <div id="wp" class="wp">
    <div id="diynavtop" class="area"></div><!--[/diy]-->

    <div class="boardnav">

        <div id="ct" class="wp cl ct2">
        <div class="mn">
          <div class="orde">
            <div class="bm bml pbn">
              <div class="bm_h cl">
                <%--<h1 class="xs2"><a href="">Hadoop</a>
                    <span class="xs1 xw0 i">今日: <strong class="xi1">0</strong><span class="pipe">|</span>主题:
                    <strong class="xi1">242</strong><span class="pipe">|</span>排名:
                    <strong class="xi1" title="上次排名:40">40</strong><b class="ico_increase"></b></span></h1>--%>
              </div>
            </div>

            <div class="drag">
              <!--[diy=diy4]-->

              <div id="diy4" class="area"></div><!--[/diy]-->
            </div>
          </div>

          <div class="cenbor">
            <div id="pgt" class="bm bw0 pgs cl">
              <span id="fd_page_top"></span>
                <%--<span class="pgb y"><a href="">返回</a></span> <a href="javascript:;" id="newspecial"  onmouseover="" onclick="" title="发新帖">发布新帖</a>--%>
            </div>

            <div id="threadlist" class="tl bm bmw">
              <div class="th">
                <table cellpadding="0" cellspacing="0">
                  <tbody>
                  <tr>
                    <th colspan="2">
                      <div class="tf">
                        <span id="atarget" onclick="setatarget(1)" class="y" title="在新窗口中打开帖子">新窗</span>
                        <a id="filter_special" href="javascript:;" class="showmenu xi2 a2" onclick=
                                "showMenu(this.id)">主题</a>
                      </div>
                    </th>
                  </tr>
                  </tbody>
                </table>
              </div>

              <div class="bm_c">
                <script type="text/javascript">
                  //<![CDATA[
                  var lasttime = 1480765658;var listcolspan= '5';
                  //]]>
                </script>

                <div id="forumnew" style="display:none"></div>
                <form method="post" autocomplete="off" name="moderate" id="moderate" action="">
                  <table summary="forum_70" id="threadlisttableid" cellpadding="0" cellspacing="0" border="0">

                    <c:forEach items="${list}" varStatus="i" var="item">
                        <tbody>
                        <tr>
                          <td class="icn">
                            <a href="" title="新窗口打开" target="_blank"><img src="/frontstatic/images/folder_common.gif" /></a>
                          </td>
                          <th class="common">
                            <a id="toux" href="/topic/content/${item.id}.htm" target="_blank" title="" class=""><img src="/frontstatic/images/avatar_004.gif" /></a>
                            <p id="xinx"><cite><a href="/topic/content/${item.id}.htm" class="xi2">回复:${item.count}</a> <span class="pipe">|</span></cite> </p>
                          </th>
                          <th align="left" colspan="4"><p><a href="/topic/content/${item.id}.htm" onclick="" class="s xst">${item.name}</a></p></th>
                          <td class="by"><em><span><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/> 发布</span></em></td>
                        </tr>
                        </tbody>
                    </c:forEach>
                  </table>

                  <!-- end of table "forum_G[fid]" branch 1/3 -->
                </form>
              </div>
             <div class="bm bw0 pgs cl" id="pgda">
               <div id="pageTool"></div>
              </div>
            </div>

            <div id="filter_special_menu" class="p_pop" style="display:none" >
              <ul>
                <li>
                  <a href="">全部主题</a>
                </li>
                <li>
                  <a href="">投票</a>
                </li>
              </ul>
            </div>

            <div id="filter_reward_menu" class="p_pop" style="display:none" change="">
              <ul>
                <li>
                  <a href="">全部悬赏</a>
                </li>
                <li>
                  <a href="">
                    进行中</a>
                </li>
              </ul>
            </div>


            <!--[diy=diyfastposttop]-->

            <div id="diyfastposttop" class="area"></div><!--[/diy]-->
            <!--[diy=diyforumdisplaybottom]-->

            <div id="diyforumdisplaybottom" class="area"></div><!--[/diy]-->
          </div>

          <div id="f_pst" class="bm">
            <div class="bm_h">
              <h2>快速发帖</h2>
            </div>

            <div class="bm_c">
              <form method="post" autocomplete="off" id="fastpostform" action="" onsubmit="return fastpostvalidate(this)">
                <div id="fastpostreturn" style="margin:-5px 0 5px"></div>
                <div class="pbt cl">
                  <input id="subject" name="subject" class="px" onkeyup="" tabindex="11" style="width: 25em" type="text" />
                    <span>还可输入 <strong id="checklen">80</strong> 个字符</span>
                </div>
                <div class="cl">
                  <div id="fastsmiliesdiv" class="y">
                    <div id="fastsmiliesdiv_data">
                      <div id="fastsmilies"></div>
                    </div>
                  </div>

                  <div class="hasfsl" id="fastposteditor">
                    <div class="tedt">
                      <div class="bar">
                          <span class="y"><a href=""
                                             onclick="switchAdvanceMode(this.href);doane(event);">高级模式</a></span>
                        <div class="fpd">
                          <a href="javascript:;" title="文字加粗" class="fbld">B</a>
                            <a href="javascript:;" title="设置文字颜色" class="fclr" id="fastpostforecolor">Color</a>
                            <a id="fastpostimg" href="javascript:;" title="图片" class="fmg">Image</a>
                            <a id="fastposturl" href="javascript:;" title="添加链接" class="flnk">Link</a>
                            <a id="fastpostquote" href="javascript:;" title="引用" class="fqt">Quote</a>
                            <a id="fastpostcode" href="javascript:;" title="代码" class="fcd">Code</a>
                            <a href="javascript:;" class="fsml" id="fastpostsml">Smilies</a>
                        </div>
                      </div>

                      <div class="area">
                        <div class="pt hm">
                          <%--您需要登录后才可以发帖 <a href="" onclick="" class="xi2">登录</a> |
                          <a href="" class="xi2">立即注册</a>--%>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div id="seccheck_fastpost"></div><input name="formhash" value="755d8bc8" type="hidden" />
                    <input name="usesig"  value="" type="hidden" />
                </div>

                <p class="ptm pnpost"><%--<a href="" class="y" target="_blank">本版积分规则</a>--%>
                   <%-- <button type="submit" onmouseover="" name="topicsubmit" id="fastpostsubmit" value="topicsubmit" tabindex="13" class="pn pnc">
                        <strong>发表帖子</strong></button>--%></p>
              </form>
            </div>
          </div>
        </div>

        <div class="sd">
          <div class="bm">
            <div class="bm_h">
              <h2>所属分类: 互动问答</h2>
            </div>

            <div class="bm_c">
              <ul class="xl xl2 cl">
                <%--<li>
                  <a href="">Hadoop</a>
                </li>
                <li>
                  <a href="">sqoop</a>
                </li>
                <li>
                  <a href="">elasticsearch</a>
                </li>
                <li>
                  <a href="">Python</a>
                </li>--%>
              </ul>
            </div>
          </div>



        </div>
      </div>
    </div>

  </div>

    <jsp:include page="../common/footer.jsp"/>
</div>

<div id="pageToolbar"></div>
<script type="text/javascript" src="/frontstatic/paging/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="/frontstatic/paging/js/query.js"></script>
<script type="text/javascript" src="/frontstatic/paging/js/paging.js"></script>
<script>
  $('#pageTool').Paging({pagesize:10,count:${total},current:${vo.pageable.currentPage},callback:function(page,size,count){
   // alert('当前第 ' +page +'页,每页 '+size+'条,总页数：'+count+'页');
     window.location.href="/content/${topic.id}.htm?start="+((page-1)*size)+"&length="+size;
  }});
</script>
</body>
</html>
