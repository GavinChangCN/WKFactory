<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String ObjectNum = request.getParameter("ObjectNum");%>
<%Integer ObjectType = Integer.parseInt(request.getParameter("ObjectType"));%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>PublishComment</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script> 
	<script type="text/javascript" src="js/Comment/PublishComment.js"></script>
    <script type="text/javascript">
      var ObjectNum = <%="'"+ObjectNum+"'"%> ;
      var ObjectType = <%="'"+ObjectType+"'"%> ;
    </script>
  </head>
  
  <body>
    <div align = "center">
    	<h1>Edit Your Comment</h1>
    </div>
  </body>
</html>
