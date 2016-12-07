<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
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
<body>
<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<!-- begin #page-container -->
<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
    <jsp:include page="../common/top.jsp"/>

    <!-- begin #sidebar -->
    <jsp:include page="../common/sitebar.jsp"/>
    <div class="sidebar-bg"></div>
    <!-- end #sidebar -->

    <!-- begin #content -->
    <div id="content" class="content">
        <!-- begin breadcrumb -->
        <ol class="breadcrumb pull-right">
            <li><a href="javascript:;">Home</a></li>
            <li><a href="javascript:;">Tables</a></li>
            <li class="active">Managed Tables</li>
        </ol>
        <!-- end breadcrumb -->
        <!-- begin page-header -->
        <h1 class="page-header"> 在很久很久以前 <small>......</small></h1>
        <!-- end page-header -->

        <!-- begin row -->
        <div class="row">
            <!-- begin col-12 -->
            <div class="col-md-12">
                <!-- begin panel -->
                <div class="panel panel-inverse">
                    <div class="panel-heading">
                        <c:choose>
                            <c:when test="${dictionary.id!=null}">
                                <h3 class="panel-title">编辑</h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="panel-title">新增</h3>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="panel-body">

                        <form role="form" action="/sysdic/add" method="post" data-parsley-validate="true">
                            <input type="hidden" class="form-control" name="id" value="${dictionary.id}">

                            <div class="form-group">
                                <label for="name">类型</label>
                                <select id="categoryid">
                                    <option value="1"></option>
                                    <option value="2"></option>
                                    <option value="3"></option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>主题</label>
                                <input type="text" class="form-control input-lg" name="name" value="${dictionary.rmsKey}" placeholder="请输入键"  data-parsley-required="true" data-parsley-required-message="键不能为空">
                            </div>

                            <div class="form-group">
                                <label>内容</label>
                                <input type="text" class="form-control input-lg" name="content" value="${dictionary.rmsValue}" placeholder="请输入值"  data-parsley-required="true" data-parsley-required-message="值不能为空">
                            </div>

                            <button type="submit" class="btn btn-primary m-r-5 m-b-5">提交</button>

                        </form>

                    </div>
                </div>
                <!-- end panel -->
            </div>
            <!-- end col-12 -->
        </div>
        <!-- end row -->
    </div>
    <!-- end #content -->

    <!-- begin scroll to top btn -->
    <a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
    <!-- end scroll to top btn -->
</div>
<!-- end page container -->
<jsp:include page="../common/footer.jsp"/>


<!-- ================== END PAGE LEVEL JS ================== -->

<script>
    $(document).ready(function() {
        App.init();
        Dashboard.init();
    });
</script>

</body>
</html>
