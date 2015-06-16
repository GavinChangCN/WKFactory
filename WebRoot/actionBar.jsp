<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String LoginUserNum = "" ;
	String LoginNickName = "" ;
	Integer LoginUserType = 3 ;
	try {
		LoginUserNum = session.getAttribute( "UserNum" ).toString() ;
		LoginNickName = session.getAttribute( "NickName" ).toString() ;
		LoginUserType = Integer.parseInt( session.getAttribute("UserType").toString() ) ;
	}catch(Exception e) {
		e.printStackTrace() ;
		System.out.println("用户还没有登录！") ;
		LoginUserNum = "" ;
		LoginNickName = "" ;
		LoginUserType = 3 ;
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>导航栏主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/actionBar.css" type="text/css" rel="stylesheet" />
	<script src = "js/actionBar/actionBar.js" type = "text/javascript"></script>
	<script type="text/javascript">
		var LoginUserNum = <%="'"+LoginUserNum+"'"%> ;
		var LoginNickName = <%="'"+LoginNickName+"'"%> ;
		var LoginUserType = <%=LoginUserType%> ;
	</script>
  </head>
  
  <body>
    <div class="logo">
		<div class="logo_left">
    		<img class = "im1" src="img/index_1.jpg" onclick = "backToHome()" />
    		<img class = "im2" src="img/index_2.jpg" onclick = "backToHome()" />
    	</div>
    	<div class="logo_right">
    		<ul id = "logo_right_type">
        		<li id = "MyTool">
        			<span><a id = "indexBtn" class="logo_current" href="index.jsp">首页</a></span>
        			<span id = "myAttendBtn" ><a href="#">我的订阅</a></span>
        			<span id = "newCourseBtn" style = "display:none" ><a href="new_course.jsp">新建课程</a></span>
        		</li>
            	<li class="logo_li">
            		<input id = "searchInput" class="logo_text" onkeydown="listenSearch()" type="text" placeholder="搜课程" />
            		<input onclick = "confirmSearch()" class="logo_button"  type="button" />
            	</li>
            	<li id = "HaveLoginType" class="logo_li2" style="display: none" >
            		<a id = "loginNick" onclick = "myInfomation()" href = "javascript:;" >个人</a>
            		<a id = "logOutBtn" onclick = "logOut()" href = "#" >注销</a>
            	</li>
            	<li id = "UnLoginType" class="logo_li2">
            		<a onclick = "login()" id = "loginBtn" href = "login.jsp" >登录</a>
            		<a onclick = "signUp()" href = "login.jsp" >注册</a>
            	</li>
       	 	</ul>
    	</div>
	</div>
	<div class="hr"></div>
  </body>
</html>
