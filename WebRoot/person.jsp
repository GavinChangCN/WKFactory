<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String TUserNum = "" ;
	try {
		TUserNum = request.getParameter( "UserNum" ).toString() ;
	}catch(Exception e) {
		e.printStackTrace() ;
		TUserNum = null ;
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人中心</title>
	<link href="css/person.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/modal.css" />
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="js/person.js" ></script>
	<script type="text/javascript" src="http://open.web.meitu.com/sources/xiuxiu.js" ></script>
	<script type="text/javascript">
		var TUserNum = <%="'"+TUserNum+"'"%> ;
	</script>
</head>

<body>
	<jsp:include page="actionBar.jsp"/>
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
      		<div class="modal-content">
				<div class="modal-header">
            		<button id = "modalClose" type="button" class="close" 
              			 data-dismiss="modal" aria-hidden="true">
                  		&times;
            		</button>
            		<h4 class="modal-title" id="myModalLabel">
              			 上传个人头像
            		</h4>
            	</div>
				<div class = "modal-body">
					<div id="altContent">
						<h1>美图秀秀</h1>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal fade -->
<div class="subject">
	<div class="subject_left">
    	<div class="subject_1">
        	<img id = "emUserPicture" src="img/course_29.png" />
            <em><a id = "emNickName" >NickName</a><br /><input data-toggle="modal" data-target="#myModal" type="button" /></em>
        </div>
        <ul class="subject_2">
        	<li id="geren" class="subject_current"><a href="javascript:">个人中心</a></li><li data-toggle="modal" data-target="#myModal" id="Settings"><a href="javascript:;" >头像设置</a></li><li id="person_Logout" onclick = "logOut()" ><a  href="javascript:;">一键注销</a></li>
        </ul>	
    </div>
    <div class="subject_right right1">
    	<div class="subject_r_1">
        	<em id="em1" class="em_current">我的订阅</em><em id="em2" style="display:none;" >我的课程</em><em id="em3" style="display:none;">我的比赛</em>
        </div>
    	<ul id="ul1">
        </ul>
        <ul id="ul2" style="display:none;">
        </ul>
        <ul id="ul3" style="display:none;">
        </ul>
    </div>
    <div style = "display: none ;">
    	<a>头像地址：</a><input id = "fileAddress" type = "text" readonly="readonly" />
    </div>
</div>
</body>
</html>
