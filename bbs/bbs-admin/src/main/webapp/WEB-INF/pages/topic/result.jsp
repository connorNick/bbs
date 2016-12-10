<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="/static/plugins/editor/ckeditor/syntaxhighlighter_3.0.83/scripts/shCore.js"></script>
    <script type="text/javascript" src="/static/plugins/editor/ckeditor/syntaxhighlighter_3.0.83/scripts/shBrushes.js"></script>
    <link type="text/css" rel="Stylesheet" href="/static/plugins/editor/ckeditor/syntaxhighlighter_3.0.83/styles/shCoreDefault.css" />
    <script type="text/javascript" src="/static/plugins/editor/js/jquery-1.3.2.min.js"></script>
      <%@include file="../common/taglib.jsp"%>
 <script type="text/javascript">        
// $(".toolbar").remove();
 SyntaxHighlighter.all();
SyntaxHighlighter.defaults['toolbar'] = false;
 </script>
  </head>
  <body>
${topic.content}

  </body>
</html>
