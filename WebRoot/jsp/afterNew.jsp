<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String ObjectNum = request.getParameter("ObjectNum"); %>
<%Integer ObjectType = Integer.parseInt( request.getParameter("ObjectType") ) ; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>请选择其余功能</title>

	<script type="text/javascript" src="js/jquery-2.1.4.js"></script> 
	<link rel="stylesheet" type="text/css" href="css/modal.css" />
	<link rel="stylesheet" type="text/css" href="js/uploadify/uploadify.css" />
	<script type="text/javascript" src="js/uploadify/jquery.uploadify.js"></script>
	<script type="text/javascript" src="js/afterNew.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
    <script type="text/javascript">
      var ObjectNum = <%="'"+ObjectNum+"'"%> ;
      var ObjectType = <%=ObjectType%> ;
    </script>
  </head>
  
  <body>
  <jsp:include page="../actionBar.jsp"/>
  <div id="myModal" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true" style = "left:32%; width:600px; ">
		<div class="modal-dialog">
      		<div class="modal-content">
				<div class="modal-header">
            		<button id = "modalClose" type="button" class="close" 
              			 data-dismiss="modal" aria-hidden="true">
                  		&times;
            		</button>
            		<h4 class="modal-title" id="myModalLabel">
              			 上传附件
            		</h4>
            	</div>
				<div class = "modal-body">
					<div align = "center" style = "margin-top:230px ;" >
						<div id="fileQueue"></div>  
    					<input type="file" name="uploadify" id="uploadify" />  
    					<div class="btn-group btn-group-sm" role="group"> 
    						<button type="button" class="btn btn-primary" onclick="javascript:$('#uploadify').uploadify('upload')">开始上传</button>   
    						<button type="button" class="btn btn-danger" onclick="javascript:$('#uploadify').uplaodify('cancel','*')">取消上传</button>  
   						</div>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal fade -->
    <div id = "moreOption" class="btn-group  btn-group-lg" role="group" align="center" style = "margin: 20% auto ;  " >
			<button style = "width: 200px ; font-family: '微软雅黑' ;" type="button" class = "btn btn-lg btn-info" id = "newChapterBtn" onclick = "loadnewChapter()">新建章节</button>
 			<button style = "width: 200px ; font-family: '微软雅黑' ;" type = "button" class = "btn btn-lg btn-primary" data-toggle="modal" data-target="#myModal" >上传附件</button>
	</div>
	<div style = "display: none ;">
    	<a>附件名称：</a><input id = "fileName" type = "text" readonly="readonly" />
    	<a>附件地址：</a><input id = "fileAddress" type = "text" readonly="readonly" />
    </div>
  </body>
</html>
