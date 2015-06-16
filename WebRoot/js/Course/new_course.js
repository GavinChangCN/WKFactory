var local = window.location;  
var contextPath = local.pathname.split("/")[1];  
var basePath = local.protocol+"//"+local.host+"/"+contextPath+'/';  
var imgSrc = '' ;
$(function(){
	$.ajaxSettings.async = false ;
	$('#indexBtn').attr( 'class' , '' ) ;
	$('#myAttendBtn').attr( 'class' , '' ) ;
	$('#newCourseBtn').attr( 'class' , 'logo_current' ) ;
	loadSubject() ;
	window.onload=function(){
	    /*第1个参数是加载编辑器div容器，第2个参数是编辑器类型，第3个参数是div容器宽，第4个参数是div容器高*/
		xiuxiu.embedSWF("altContent",5,"100%","99%");
	    //修改为您自己的图片上传接口
		xiuxiu.setUploadURL(basePath+"jsp_upload_form.jsp");
		xiuxiu.setUploadType(2);
		xiuxiu.setUploadDataFieldName("TestFile");
		xiuxiu.onInit = function ()
		{
			xiuxiu.loadPhoto("");
		}	
		xiuxiu.onUploadResponse = function (data)
		{
			imgSrc = decodeURI(data) ;
			imgSrc = imgSrc.replace(/ /, '').replace( /\r/,'' ).replace( /\n/,'' ).replace( /\t/, '') ;
			$('#newPic').attr('src', basePath+imgSrc) ;
			$('#newPic').show() ;
			$('#pic_upbutton').hide() ;
			$('#blockInit').hide() ;
			$('#myModal').hide() ;
		}
	}
});

function loadSubject(){
	$.getJSON( './servlet/ShowAllSubjectsServlet',{
		
	},function(json){
		var temp = '' ;
		if ( json != null ) {
			for( var i=0 ; i < json.length ; i ++ ){
				if ( i == 0 ) {
					temp += '<option value = ' + json[i].ID + ' selected = "selected" >' + json[i].SubjectName + '</option>' ;
				} else {
					temp += '<option value = ' + json[i].ID + '>' + json[i].SubjectName + '</option>' ;					
				}
			}
			$('#subSelect').append( temp ) ;
		}
	}) ;
}

function confirmSaveCourse() {
	var courseName = $('#newCourseName').val() ;
	var subSelect = $('#subSelect').val() ;
	var courseContent = $('#newCourseContent').val() ;
	if( courseName.length < 2 ) {
		alert( '输入的课程名称长度过短，请修改后重新尝试！' ) ;
	} else if ( courseName > 15 ) {
		alert( '输入的课程名称长度过长，请修改后重新尝试！' ) ;
	} else if ( subSelect == '' ){
		alert( '请选择一个学科分类后继续尝试！' ) ;
	} else if ( courseContent.length > 220 ) {
		alert( '输入的课程概述太长，请修改后重新尝试！' ) ;
	} else if ( imgSrc == '' ) {
		alert( '请上传一张课程图层！' ) ;
	} else {
		$.getJSON("./servlet/CreateCourseServlet",{
			UserNum:LoginUserNum,
			CourseName:courseName,
			CourseContent:courseContent,
			SubId:subSelect,
			CoverPicture:imgSrc,
		},function(json){
			if ( json.result == 0 ) {
				alert( "课程创建成功！" ) ;
				location.href = 'jsp/afterNew.jsp?ObjectNum='+json.CourseNum+'&ObjectType=0' ;
			} else if ( json.result == 1 ) {
				alert( "课程创建失败！" ) ;
			}
		});
	}
}

