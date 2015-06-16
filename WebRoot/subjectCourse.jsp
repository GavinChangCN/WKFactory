<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String SubName = "" ;
	Integer listId = 0 ;
	try {
		SubName = request.getParameter( "SubName" ) ;
	}catch(Exception e) {
		e.printStackTrace() ;
		System.out.println("还没有选择学科！") ;
		SubName = null ;
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>本学科所有课程</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/index.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script> 
	<script src="js/Course/subjectCourse.js" type="text/javascript"></script>
	<script type="text/javascript">
		var SubName = <%="'"+SubName+"'"%> ;
	</script>
  </head>
  
  <body>
  	<jsp:include page="actionBar.jsp"/>
    <div class="talk">
		<div class="talk_1" id = "subjectItself">
    		本学科所有课程
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

	<script src="js/js.js" type="text/javascript" language="javascript"></script>
  </body>
</html>
