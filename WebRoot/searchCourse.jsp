<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String unsureCourseName = "" ;
	Integer listId = 0 ;
	try {
		unsureCourseName = request.getParameter( "unsureCourseName" ) ;
	}catch(Exception e) {
		e.printStackTrace() ;
		System.out.println("用户还没有登录！") ;
		unsureCourseName = null ;
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索课程结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/index.css" type="text/css" rel="stylesheet" />
	<link href="css/course.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery.js"></script> 
	<script src="js/Course/searchCourse.js" type="text/javascript"></script>
	<script type="text/javascript">
		var unsureCourseName = <%="'"+unsureCourseName+"'"%> ;
	</script>
  </head>
  
  <body>
  	<jsp:include page="actionBar.jsp"/>
    <div class="talk">
		<div class="talk_1">
    		搜索结果
    	</div>
    </div>
    <div align = "center" id = "withoutResult" style="position:fixd;">
    </div>
    <div class="main">
    	<div class="main_2">
        	<div class="main_21">
            	<ul class="ul1" id = "ul1" >
            	</ul>
        	</div>
    	</div>
    </div>

  </body>
</html>
