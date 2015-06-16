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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
	<link href="css/index.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script> 
	<script src="js/index.js" type="text/javascript"></script>
	<script type="text/javascript">
		var LoginUserNum = <%="'"+LoginUserNum+"'"%> ;
		var LoginNickName = <%="'"+LoginNickName+"'"%> ;
		var LoginUserType = <%=LoginUserType%> ;
	</script>
</head>

<body>
	<jsp:include page="actionBar.jsp"/>
	<div class="subject">
		<div class="subject_1">
        	<div class="subject_left">
            	<em><a id = "s0" href = "#">第一学科分类</a>
            		<ul id="subject_ul0">
                	</ul>
                </em>
            	<em><a id = "s1" href = "#">第二学科分类</a>
            		<ul id="subject_ul1">
                	</ul>
            	</em>
            	<em><a id = "s2" href = "#">第三学科分类</a>
	            	<ul id="subject_ul2">
	                </ul>
            	</em>
            	<em><a id = "s3" href = "#">第四学科分类</a>
            		<ul id="subject_ul3">
                	</ul>
            	</em>
            	<em><a id = "s4" href = "#">第五学科分类</a>
            		<ul id="subject_ul4">
                	</ul>
            	</em>
            	<em style="border-bottom:0;"><a id = "s5" href = "#">第六学科分类</a>
            		<ul id="subject_ul5">
                	</ul>
            	</em>
        	</div>
        	<div class="subject_right">
        		<div class="flash" id="flash">
					<a id="flash_left" class="flash_left" href="javascript:void(0)" style="display:none;">左</a>
					<ul class="flash_img">
    					<li class="flash_imgCur"><a href="course.jsp?CourseNum=A86OVAHH43SKS9YXE2PR&ListId=0" target="_blank"><img src="img/index_22.png" alt="图1" /></a></li>
       					<li style="opacity:0;filter:alpha(opacity=0);"><a href="course.jsp?CourseNum=A86OVAHH43SKS9YXE2SR&ListId=0" target="_blank"><img src="img/index_23.png" alt="图2" /></a></li>
        				<li style="opacity:0;filter:alpha(opacity=0);"><a href="course.jsp?CourseNum=A86ASKHH43SKS9YXE2SR&ListId=0" target="_blank"><img src="img/index_22.png" alt="图3" /></a></li>
        				<li style="opacity:0;filter:alpha(opacity=0);"><a href="course.jsp?CourseNum=C35JGU9YKQ6Q3J3K8O5K&ListId=0" target="_blank"><img src="img/index_23.png" alt="图2" /></a></li>
    				</ul>
    				<a id="flash_right" class="flash_right" href="javascript:void(0)" style="display:none;">右</a>
    				<div class="flash_btn">
    					<span class="flash_btnCur">1</span>
        				<span>2</span>
        				<span>3</span>
        				<span>4</span>
    				</div>
				</div>
			</div>
    	</div>
	</div>
<div class="main">
	<div class="main_1">
    	<a id="a1" class="main_1_current" href="index.jsp">所有课程</a><a id="a2" href="javascript:;">第一学科</a><a id="a3" href="javascript:;">第二学科</a><a id="a4" href="javascript:;">第三学科</a><a id="a5" href="javascript:;">第四学科</a><a id="a6" href="javascript:;">第五学科</a>
    </div>
    <div class="main_2">
        <div id = "am1" class="main_21" style="display:none;">
            <ul class="ul1" id = "ul1" >
            </ul>
        </div>
        <div id = "am2" class="main_22" style="display:none;">
            <ul class="ul1" id = "ul2">
            </ul>
        </div>
        <div id = "am3" class="main_23" style="display:none;">
            <ul class="ul1" id = "ul3">
            </ul>
        </div>
        <div id = "am4" class="main_24" style="display:none;">
            <ul class="ul1" id = "ul4">
            </ul>
        </div>
        <div id = "am5" class="main_25" style="display:none;">
            <ul class="ul1" id = "ul5">
            </ul>
        </div>
        <div id = "am6" class="main_26" style="display:none;">
            <ul class="ul1" id = "ul6">
            </ul>
        </div>
    </div>
</div>

<script src="js/js.js" type="text/javascript" language="javascript"></script>

</body>
</html>
