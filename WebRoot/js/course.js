// JavaScript Document
var chapterNum = "" ;
var fid = 0 ;
$(function() {
	$.ajaxSettings.async = false ;
	if ( LoginUserType != 3 ) {
		$('#attendBTN').hide() ;
	}
	showAttendBTN() ;
	$.getJSON('./servlet/QueryCourseByCourseNumServlet',{
		CourseNum:CourseNum,
	},function(json){
		isMyCourse() ;
		$('#c1').text( json.CourseName ) ;
		$('#c2').text( json.CourseName ) ;
		$('#c3').text( json.CourseName ) ;
		$('#c1').attr( 'href' , 'course.jsp?CourseNum=' + CourseNum + '&ListId=0' ) ;
		$('#c2').attr( 'href' , 'course.jsp?CourseNum=' + CourseNum + '&ListId=0' ) ;
		$('#c3').attr( 'href' , 'course.jsp?CourseNum=' + CourseNum + '&ListId=0' ) ;
		$('#content1').text( json.CourseContent ) ;
		$('#period').text( json.Period + '学时' ) ;
		$('#createtime').text( json.Createtime ) ;
		if( json.Period != 0 ){	
			$.getJSON('./servlet/QueryChapterByCourseNumServlet',{
				CourseNum:CourseNum,
			},function(json){
				var temp = '' ;
				var chapterName = '' ;
				var content = '' ;
				var url = '' ;
				for ( var i = 0 ; i < json.length ; i++ ) {
					url = 'course.jsp?CourseNum=' + CourseNum
					+ '&ListId=' + i ;
					var index = i + 1 ;
					temp += '<li>'
						+ '<a href = '+url+' >第'+index+'课时：'+json[i].ChapterName+'</a><br/>'
						+ '<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+json[i].ChapterContent + '</p>'
						+ '<hr color="#eeeeee"/>'
						+ '</li>'
				}
				$('#listChapter').append( temp ) ;
				$.getJSON( './servlet/showChooseChapterServlet',{
					CourseNum:CourseNum,
					ListId:listId,
				},function(json){
					$('#cha1').text( json.ChapterName ) ;
					$('#cha2').text( json.ChapterName ) ;
					$('#cha1').attr( 'href' , 'course.jsp?CourseNum=' + CourseNum + '&ListId=' + listId ) ;
					$('#cha2').attr( 'href' , 'course.jsp?CourseNum=' + CourseNum + '&ListId=' + listId ) ;
					var CuPlayerList = json.ChapterVideo ;
					chapterNum = json.ChapterNum ;
					var so = new SWFObject("CuSunPlayer/CuPlayerMiniV4.swf","CuPlayerV4","1000","560","9","#000000");
					so.addParam("allowfullscreen","true");
					so.addParam("allowscriptaccess","always");
					so.addParam("wmode","opaque");
					so.addParam("quality","high");
					so.addParam("salign","lt");
					so.addVariable("CuPlayerSetFile","CuSunPlayer/CuPlayerSetFile.xml"); //播放器配置文件地址
					so.addVariable("CuPlayerFile", CuPlayerList ); //视频文件地址
					so.addVariable("CuPlayerWidth","1000"); //视频宽度
					so.addVariable("CuPlayerHeight","560"); //视频高度
					so.addVariable("CuPlayerAutoPlay","no"); //是否自动播放
					so.write("CuPlayer");
//				//酷播迷你：官方连播代码示例
//				var CuPlayerList = json.ChapterVideo ;
//				var sp =CuPlayerList.split("|")  
//				var num = sp.length;
//				var video_index = 0;
//				function getNext(pars)
//				{	
//					if(video_index < num-1)
//					{
//						video_index++;
//						so.addVariable("JcScpVideoPath",sp[video_index]);
//						so.write("CuPlayer");	
//					}
//					else
//					{
//						video_index = 0;
//						so.addVariable("JcScpVideoPath",sp[video_index]);
//						so.write("CuPlayer");	
//					}
//				}
//				function changeStream(CuPlayerFile){
//					so.addVariable("JcScpVideoPath",sp[CuPlayerFile]);
//					so.write("CuPlayer");	
//				}
//				
//				CuPlayerFile =sp[video_index];
//				var so = new SWFObject("CuSunPlayer/player.swf","ply","1000","560","9","#000000");
//				so.addParam("allowfullscreen","true");
//				so.addParam("allowscriptaccess","always");
//				so.addParam("wmode","opaque");
//				so.addParam("quality","high");
//				so.addParam("salign","lt");
//				//播放器设置文件-----------------------------
//				so.addVariable("JcScpFile","CuSunPlayer/CuSunV2set.xml");
//				//视频文件及略缩图--------------------------
//				so.addVariable("JcScpVideoPath",CuPlayerFile);
//				so.addVariable("JcScpImg","Images/flashChangfa2.jpg"); 
//				so.addVariable("JcScpSharetitle","标题信息"); 
//				so.write("CuPlayer");
					loadComment();
					ObjectType = 0 ;
					$.getJSON("./servlet/QueryAccessoryByObjectTypeAndNumServlet",{
						ObjectNum:CourseNum,
						ObjectType:ObjectType,
					},function(json){
						var attemp = "" ;
						if( json.length != 0 ){
							var accessoryName = "" ;
							for(var i=0;i<json.length;i=i+1){
								accessoryName = "<a href=./servlet/DownloadServlet?AccessoryAddress="+json[i].AccessoryAddress
								+"&UserNum="+LoginUserNum
								+"&AccessoryID="+json[i].AccessoryID+" style='text-decoration:none;text-align:center'>"
								+ json[i].AccessoryName+"</a>" ;
								attemp += "<li>"
									+ accessoryName 
									+ "</li>" ;
							}
						}else {
							attemp = '本课程无附件！' ;
						}
						$('#courseAccessory').append( attemp ) ;
						ObjectType = 1 ;
						$.getJSON("./servlet/QueryAccessoryByObjectTypeAndNumServlet",{
							ObjectNum:chapterNum,
							ObjectType:ObjectType,
						},function(json){
							var attemp = "" ;
							if( json.length != 0 ){
								var accessoryName = "" ;
								for(var i=0;i<json.length;i=i+1){
									accessoryName = "<a href=./servlet/DownloadServlet?AccessoryAddress="+json[i].AccessoryAddress
									+"&UserNum="+LoginUserNum
									+"&AccessoryID="+json[i].AccessoryID+" style='text-decoration:none;text-align:center'>"
									+ json[i].AccessoryName+"</a>" ;
									attemp += "<li>"
										+ accessoryName 
										+ "</li>" ;
								}
							}else {
								attemp = '本章节无附件！' ;
							}
							$('#chapterAccessory').append( attemp ) ;
						});
					});
				});
			});
		}
	});
	
	$('.dingyue').hover(function(){
		$('#ding2').show();
		$('#ding1').hide();
		},function(){
			$('#ding1').show();
		$('#ding2').hide();
			})
});
function publishComment(){
	var publishCommentContent = $('#publishCommentContent').val() ;
	if( publishCommentContent.length >= 250 ){
		alert('您输入的评论超过了125个文字的上限，请修改后重新发表！')
	} else {
		$.getJSON("./servlet/PublishCommentServlet",{
			CommentContent:publishCommentContent,
			UserNum:LoginUserNum,
			ObjectNum:chapterNum,
			ObjectType:1,
			PID:fid,
		},function(json){
			if( json.result == 0 ) {
				alert("发表评论成功！") ;
				$('#publishCommentContent').val('') ;
				$('#commentBody').empty();
				loadComment() ;
				fid = 0 ;
			}else {
				alert("发表评论失败！") ;
			}
		});		
	} 
}

function loadComment() {
	var ObjectType = 1 ;
	$.getJSON( './servlet/QueryCommentByObjectTypeAndNumServlet',{
		ObjectNum:chapterNum,
		ObjectType:ObjectType,
	},function(json){
		var commentTemp = '' ;
		if( json.length != 0 ){
			for ( var i = 0 ; i < json.length ; i ++ ) {
				var replytemp = '' ;
				replytemp = loadReply( i , json[i].ID ) ;
				commentTemp += 
					'<div class="talk_2_1">' 
						+ '<img src='+json[i].UserPicture+'></img>'
						+ '<div class="talk_center">'
							+ '<em><a>' + json[i].CommentContent + '</a><br /><br /></em>'
							+ '<i><span><a class = "default-uinfo" id="comNick'+ i +'" >' + json[i].NickName + '</a></span>    <a class = "default-uinfo" >发表时间：' + json[i].CommentTime + '</a></i>'
						+ replytemp
					+ '</div>' ;
			}						
		} else {
			commentTemp = '<div style="margin-top: 10px;" align="center" style="-moz-user-select:-moz-none;"  onselectstart="return false;"> <a class = "showCResult"  >您将成为第一个评论者！</a></div>'
		}
		$('#commentBody').append(commentTemp) ;
	});
}

function loadReply( index , commentID ) {
	var all = '' ;
	var replyFunction = 'onclick="reply(' + index + ',' + commentID + ')" ' ;
	$.ajaxSettings.async = false ;
	$.getJSON( './servlet/showReplyServlet',{
		PID:commentID,
	},function(json){
		if( json != null ){
			var replyNum = '<div class="talk_right"><a ' + replyFunction + ' href="javascript:;" class="talk_r_em">' 
				+ json.length 
				+ '</a><a ' + replyFunction + ' href="javascript:;" >点击回复</a><label class="collapseBtn" data-toggle="collapse" href="#collapse' + index + '" aria-expanded="false" aria-controls="collapse'+index+'">展开</label></div>' ;
			var temp = '' ;
			for( var i = 0 ; i < json.length ; i ++ ){
				temp +=
					'<div class="well" style="width:800px ; height:auto ;"><div style="width:700px; margin-bottom:30px; padding-bottom:20px;">'
					+ '<img src="' + json[i].UserPicture + '" width="50" height="50" />'
					+ '<div class="talk_center"><em>'
					+ json[i].CommentContent 
					+ '</em><i><span>' 
					+ json[i].NickName 
					+ '</span>' 
					+ json[i].CommentTime 
					+ '</i></div>'
					+ '</div></div>' ;
			}
			all = '<div class="collapse" id="collapse'+index+'">'
				+ temp + '</div></div>'
				+ replyNum ;
		} else {
			all = '</div><div class="talk_right"><a class="talk_r_em" ' + replyFunction + ' href="javascript:;" >0</a><a ' + replyFunction + ' href="javascript:;" >点击回复</a></div>' ;
		}
	}) ;
	$.ajaxSettings.async = true ;
	return all ;
}

function reply( index , commentId ) {
	fid = commentId ;
	var $comcontent = $('#publishCommentContent') ;
	$comcontent.val( ' 回复 ' + $('#comNick'+index).html() + ' ： ' ) ;
	$comcontent.focus() ;
	javascript:document.getElementsByTagName('BODY')[0].scrollTop=document.getElementsByTagName('BODY')[0].scrollHeight ;
}
function showAttendBTN() {
	if( LoginUserNum == "" ){
		alert('登录可以享受更多精彩内容！') ;
		location.href = 'login.jsp' ;
	} else {
		$.getJSON("./servlet/haveAttendedServlet",{
			UserNum:LoginUserNum,
			CourseNum:CourseNum,
		},function(json){
			if( json.result == 0 ) {
				$('#attendBTN').text('点我订阅') ;
				$('#attendBTN').attr('class' , 'btn btn-info') ;
			} else if (json.result == 1 ) {
				$('#attendBTN').text('取消订阅') ;
				$('#attendBTN').attr('class' , 'btn btn-warning') ;
			}
		});
	}
}
function attendConfirm() {
	if( LoginUserNum == "" ){
		alert('请您先尝试登录，再继续操作！') ;
	} else {
		if( $('#attendBTN').text() == '点我订阅' ) {
			$.getJSON("./servlet/AttendCourseServlet",{
				UserNum:LoginUserNum,
				CourseNum:CourseNum,
			},function(json){
				if( json.result == 0 ) {
					alert( '订阅成功！' ) ;
					location.reload( true ) ;
				} else if (json.result == 1 ) {
					alert( '订阅失败！' ) ;			
				} else if (json.result == 2 ) {
					alert( '您已经订阅过本课程！' ) ;
				}
			});			
		} else if ( $('#attendBTN').text() == '取消订阅' ) {
			$.getJSON("./servlet/DeleteAttendCourseServlet",{
				UserNum:LoginUserNum,
				CourseNum:CourseNum,
			},function(json){
				if( json.result == 0 ) {
					alert( '取消订阅成功！' ) ;
					location.reload( true ) ;
				} else if (json.result == 1 ) {
					alert( '取消订阅失败！' ) ;			
				}
			});	
		}
	}
}

function isMyCourse() {
	$.getJSON("./servlet/isMyCourseServlet",{
		UserNum:LoginUserNum,
		CourseNum:CourseNum,
	},function(json){
		if( json.result == 0 ) {
			$('#addNewBtn').show() ;
		} else if (json.result == 1 ) {		
		}
	});	
}

function addNewBtn() {
	location.href = "jsp/afterNew.jsp?ObjectNum="+CourseNum+"&ObjectType=0" ;
}