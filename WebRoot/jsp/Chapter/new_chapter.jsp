<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String CourseNum = request.getParameter("CourseNum"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>附件</title>
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<link rel="stylesheet" type="text/css" href="css/new_game.css" />
	<link rel="stylesheet" type="text/css" href="js/uploadify/uploadify.css" />
	<link rel="stylesheet" type="text/css" href="css/modal.css" />
	<script type="text/javascript" src="js/Chapter/new_chapter.js"></script>
	<script type="text/javascript" src="js/uploadify/jquery.uploadify.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
    <script type="text/javascript">
      var CourseNum = <%="'"+CourseNum+"'"%> ;
    </script>

</head>

<body>
	<jsp:include page="../../actionBar.jsp"/>
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
				<div class="modal-footer">
        			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      			</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal fade -->
<div class="subject">
	<label><em>章节名称：</em><input id = "newChapterName" class="subject_text2" type="text" /></label>
    <label>
    	<em>章节排序：</em>
    	<select id = "listSelect" class = "SelectL" >
    		<option id = "newListIndex" value=0 selected="selected">新的章节</option>
    	</select>
    </label>
    <label>
    	<em>章节概述：</em>
		<div class="lable_right">
        	<div class="face">
            	<input style = "display:none ;" class="label_button" type="button" />
                <textarea id = "newChapterContent"></textarea>
            </div>
        </div>
    </label>
    <div align = "center" style = "display: none ;" >
    	<input id = "videoName" type = "text" readonly="readonly" />
    	<input id = "videoAddress" type = "text" readonly="readonly" />
    </div>
	<div class="subject_3">
		<input type="button" class = "btn btn-primary" value="上传视频" data-toggle="modal" data-target="#myModal" />
	</div>

    <div class="pic_button">
    	<input class="submitBTN" onclick="confirmSaveChapter()" type="button" value="" />
    </div>
</div>
</body>
</html>
