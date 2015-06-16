function CreateConfirm() {
	var CourseName = $("#CourseName").val() ;
	var CourseContent = $("#CourseContent").val() ;
	var SubjectId = $("#SubjectId").val() ;
	if( CourseName.length == 0 ){
		alert("课程名称不能为空！") ;
	} else if( CourseContent.length == 0 ) {
		alert("课程概述不能为空！") ;
	} else {
		$.getJSON("./servlet/CreateCourseServlet",{
			UserNum:LoginUserNum,
			CourseName:CourseName,
			CourseContent:CourseContent,
			SubId:SubjectId,
		},function(json){
			if ( json.result == 0 ) {
				alert( "课程创建成功！" ) ;
				$("#body").load("jsp/UserType/Teacher.jsp") ;
			} else if ( json.result == 1 ) {
				alert( "课程创建失败！" ) ;
			}
		});
	}
}
function Cancel() {
		window.history.back() ;
}