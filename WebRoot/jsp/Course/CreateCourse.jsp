<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String LoginUserNum = "" ;
	try {
		LoginUserNum = session.getAttribute( "UserNum" ).toString() ;
	}catch(Exception e) {
		e.printStackTrace() ;
		System.out.println("用户还没有登录！") ;
		LoginUserNum = null ;
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>创建课程界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/Course/CreateCourse.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var LoginUserNum = <%="'"+LoginUserNum+"'"%> ;
	</script>

  </head>
  
  <body>
    <div align="center">
    	<label>Please Input Your Course Infomation</label>
    </div>
    <table align="center">
    	<tr>
    		<td><label>Course Name:</label></td><td><input  id = "CourseName" type = "text" ></input> </td>
    	</tr>
    	<tr>
    		<td><label>Course Content:</label></td><td><textarea id = "CourseContent" rows="3"></textarea></td>
    	</tr>
    	<tr>
    		<td><label>Subject Id:</label></td><td><input  id = "SubjectId" type = "text" ></input> </td>
    	</tr>
    </table>
    <div align="center">
    	<button onclick="CreateConfirm()">Confirm</button><button onclick="Cancel()">Cancel</button>
    </div>
  </body>
</html>
