<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String CourseNum = "" ;
	Integer listId = 0 ;
	try {
		CourseNum = request.getParameter( "CourseNum" ) ;
		listId = Integer.parseInt( request.getParameter( "ListId" ).toString() ) ;
	}catch(Exception e) {
		e.printStackTrace() ;
		CourseNum = "" ;
		listId = 0 ;
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>课程</title>
	<link href="css/course.css" type="text/css" rel="stylesheet" />
	<link href="css/modal.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script> 
	<script type="text/javascript" src="js/course.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="layer/layer.min.js"></script>
	<script type="text/javascript">
		var CourseNum = <%="'"+CourseNum+"'"%> ;
		var listId = <%="'"+listId+"'"%> ;
	</script>
	<script type="text/javascript">
		<!--
		function getLight(pars)
		{	
			//alert("播放器模式参数值："+string+"");
			if(pars == "open")
			{
				close_light(this);
			}
			else
			{
				close_light(this);
			}
		}
		
		//兼容性
		function thisMovie(movieName) {
		    if (navigator.appName.indexOf("Microsoft") != -1) {
		        return window[movieName]
		    }
		    else {
		        return document[movieName]
		    }
		}
		//-->
	</script> 
</head>

<body>
	<jsp:include page="actionBar.jsp"/>
	<div class="play">
		<div class="play_top">
    		<a href="#">首页</a> > <a id = "c1" href="#">CourseName</a> > <a id = "cha1" href="#">ChapterName</a>
    	</div>
    <div class="play_1">
    	<a id = "cha2">ChapterName</a>
    </div>
	<DIV class="close_light_bg" id="close_light_bg"></DIV>
	<!--myplayer/begin-->
	<div id="myplayer">
		  <!--酷播迷你 CuPlayerMiniV3.0 代码开始-->
		  <script type="text/javascript" src="Images/swfobject.js"></script>
		  <div class="video" id="CuPlayer"> <strong>本课程还没有上传视频，或您的Flash Player版本过低，请<a href="http://www.CuPlayer.com/" >点此进行播放器升级</a>！</strong> </div>
	</div>
</div>
<div class="subject">
	<div class="subject_left">
    	<div id = "c2" class="subject_l_1">
        	CourseName
        </div>
        <div class="subject_l_2">
        	<a id = "period">3课时，16分钟</a>&nbsp&nbsp&nbsp<a id = "createtime">2015-05-20</a>
        </div>
        <div class = "btn-group">
        	<button id = "attendBTN" type = "button" class = "btn btn-info" onclick = "attendConfirm()" style = " padding:0 ; text-align:center; width: 67px ; height: 30px ; font-size:10px ;" >点我订阅</button>
        	<button id = "addNewBtn" type = "button" class = "btn btn-primary" onclick = "addNewBtn()" style =" padding:0 ; text-align:center; display:none ; width: 67px ; height: 30px ;font-size:10px ;" >添加内容</button>
        </div>
        <p id = "content1">
        	课程背景：<br />
            CourseName基础是用来记录测
            量过程中遇到的实际细节问题，
            由于日志信息太多导致不方便查
            看有效日志而影响了正常的开发
            调试工作，所以学会对日志进行
            分类查看非常重要。
        </p>
        <ul id = "courseAccessory">
        	<li>课程附件：</li>
        </ul>
        <ul id = "chapterAccessory">
        	<li>章节附件：</li>
        </ul>
    </div>
    <div class="subject_right">
    	<div class="subject_r_1">
        	<em><a id = "c3">CourseName</a></em>
        </div>
        <ul id = "listChapter">
        </ul>
    </div>
</div>
<div class="talk">
	<div class="talk_1">
    	讨论区
    </div>
    <div id = "commentBody" class="talk_2">
    </div>
    <div align = "center">
    	<textarea id = "publishCommentContent" onfocus="if(value=='请输入您要评论的内容。'){value=''; style.color='#000000';}"
   		 onblur="if (value ==''){style.color='#979797';value='请输入您要评论的内容。'}">请输入您要评论的内容。</textarea>
   	</div>
    <button class = "commentBTN" onclick = "publishComment()">发表评论</button>
</div>

</body>
</html>