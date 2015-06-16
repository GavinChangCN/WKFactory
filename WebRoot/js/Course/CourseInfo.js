var SubId = "" ;
var CourseType = "" ;
$("#UpdateButton").val("UpdateCourse") ;
$(function(){
	$.getJSON("./servlet/QueryCourseByCourseNumServlet",{
		CourseNum:CourseNum,
	},function(json){
		$("#CourseName").val(json.CourseName) ;
		$("#CourseContent").val(json.CourseContent) ;
		$("#SubjectName").val(json.SubjectName) ;
		$("#AudienceNum").val(json.AudienceNum) ;
		$("#SubscriptionNum").val(json.SubscriptionNum) ;
		$("#Createtime").val(json.Createtime) ;
		CourseNum = json.CourseNum ;
		SubId = json.SubId ;
		CourseType = json.CourseType ;
		
		
			if(	setTimeout(function(){$("#ChapterBody").load( "jsp/Chapter/ShowCoursesChapter.jsp?CourseNum="+CourseNum+"&UserNum="+LoginUserNum )}
			, 1500 ) ){
				if( setTimeout(function(){$("#CommentBody").load( "jsp/Comment/ShowComment.jsp?ObjectType="+0+"&ObjectNum="+CourseNum )}
				, 3500 ) ) {
					if(setTimeout(function(){$("#DownloadAccessoryBody").load( "jsp/Accessory/ShowAccessory.jsp?ObjectType="+0+"&ObjectNum="+CourseNum+"&UserNum="+LoginUserNum )}
							, 5500 ) ){
					}
				}
			}
		setInterval(function(){$("#CommentBody").load( "jsp/Comment/ShowComment.jsp?ObjectType=0"+"&ObjectNum="+CourseNum )}
		, 15000 ) ;
	});
});
function UpdateCourse() {
	var CourseName = "" ;
	var CourseContent = "" ;
	if( $("#UpdateButton").val() == "UpdateCourse" ){
		$("#CourseName").removeAttr('readOnly') ;
		$("#CourseContent").removeAttr('readOnly') ;
		$("#UpdateButton").html("Confirm") ;
		$("#UpdateButton").val("Confirm") ;
		CourseName = $("#CourseName").val() ;
		CourseContent = $("#CourseContent").val() ;
	} else if ( $("#UpdateButton").val() == "Confirm" ) {
		if( $("#CourseName") == CourseName &&
			$("#CourseContent") == CourseContent ){
			alert("您没有做任何修改！");
		}else {
			CourseName = $("#CourseName").val() ;
			CourseContent = $("#CourseContent").val() ;
			$.getJSON("./servlet/UpdateCourseServlet",{
				CourseNum:CourseNum,
				CourseName:CourseName,
				CourseContent:CourseContent,
				SubId:SubId,
			},function(json) {
				if ( json.result == 0 ) {
					alert( "课程修改成功！" ) ;
					location.reload(false) ;
				} else if ( json.result == 1 ) {
					alert( "课程修改失败！" ) ;
				}			
			});		
		}
		$("#UpdateButton").html("UpdateCourse") ;
		$("#CourseName").attr("readonly",true) ;
		$("#CourseContent").attr("readonly",true) ;
		$("#UpdateButton").val("UpdateCourse") ;
	}
}
function ChangeUpload() {
	location.href = "jsp/Accessory/UploadAccessory.jsp?ObjectType=0"+"&ObjectNum="+CourseNum+"&UserNum="+LoginUserNum ;
}
function Back(){
	window.history.back() ;
}
function PublishComment() {
	var MyCommentContent = $("#MyCommentContent").val() ;
	$.getJSON("./servlet/PublishCommentServlet",{
		CommentContent:MyCommentContent,
		UserNum:LoginUserNum,
		ObjectNum:CourseNum,
		ObjectType:0,
	},function(json){
		if( json.result == 0 ) {
			alert("发表评论成功！") ;
			$("#MyCommentContent").val("") ;
		}else {
			alert("发表评论失败！") ;
		}
	});
}
