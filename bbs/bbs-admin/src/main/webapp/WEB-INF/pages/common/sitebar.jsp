
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="sidebar" class="sidebar">
    <!-- begin sidebar scrollbar -->
    <div data-scrollbar="true" data-height="100%">
        <!-- begin sidebar nav -->
        <ul class="nav">
            <li class="nav-header">Navigation</li>
            <li class="has-sub">
                <a href="javascript:;">
                    <b class="caret pull-right"></b>
                    <i class="fa fa-pie-chart"></i>
                    <span>报表</span>
                </a>
                <ul class="sub-menu">
                    <li class="active"><a href="index.jsp">报表查询</a></li>
                    <li><a href="finance">查询</a></li>
                </ul>
            </li>

            <%--</shiro:hasRole>--%>

              <li class="has-sub">
                <a href="javascript:;">
                    <b class="caret pull-right"></b>
                    <i class="fa fa-laptop"></i>
                    <span>主题管理</span>
                </a>
                <ul class="sub-menu">
                     <li><a href="/topic/tolist">主题列表</a></li>
                </ul>
              </li>
            <li class="has-sub">
                <a href="javascript:;">
                    <b class="caret pull-right"></b>
                    <i class="fa fa-laptop"></i>
                    <span>帖文管理</span>
                </a>
                <ul class="sub-menu">
                    <li><a href="/repay/tolist?flowStatus=0&caseStatus=0">贴文列表</a></li>
                </ul>
            </li>
            <li class="has-sub">
                <a href="javascript:;">
                    <b class="caret pull-right"></b>
                    <i class="fa fa-laptop"></i>
                    <span>用户管理</span>
                </a>
                <ul class="sub-menu">
                    <li><a href="/repay/tolist?flowStatus=0&caseStatus=0">用户列表</a></li>
                </ul>
            </li>

            <li class="has-sub">
                <a href="javascript:;">
                    <b class="caret pull-right"></b>
                    <i class="fa fa-laptop"></i>
                    <span>系统配置</span>
                </a>
                <ul class="sub-menu">
                    <li><a href="/sysdic/tolist">数据字典</a></li>
                </ul>
            </li>
            <%--<shiro:hasRole name="超级管理员">--%>
            <li class="has-sub">
                <a href="javascript:;">
                    <b class="caret pull-right"></b>
                    <i class="fa fa-laptop"></i>
                    <span>系统管理</span>
                </a>

                <ul class="sub-menu">
                    <li class="active"><a href="/sysuser/tolist">用户管理</a></li>
                    <li><a href="/sysrole/tolist">角色管理</a></li>
                    <li><a href="/sysauth/tolist">资源管理</a></li>
                </ul>
            </li>
            <!-- begin sidebar minify button -->
            <li><a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li>
            <!-- end sidebar minify button -->
        </ul>
        <!-- end sidebar nav -->
    </div>
    <!-- end sidebar scrollbar -->
</div>
