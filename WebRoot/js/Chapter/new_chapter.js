$(function() {
	$.ajaxSettings.async = false ;
	$('#indexBtn').attr( 'class' , '' ) ;
	$('#myAttendBtn').attr( 'class' , '' ) ;
	$('#newCourseBtn').attr( 'class' , 'logo_current' ) ;
	$.getJSON('./servlet/QueryCourseByCourseNumServlet',{
		CourseNum:CourseNum,
	},function(json){
		var Plength = json.Period ;
		var $listSelect = $('#listSelect') ;
		var listtemp = '' ;
		for ( var i = 0 ; i < Plength ; i ++ ) {
			var indextemp = i + 1 ;
			listtemp = '<option value = ' + i + '>第' + indextemp + '章</option>' + listtemp ;
		}
		$listSelect.append( listtemp ) ;
		$('#newListIndex').attr( 'value', Plength ) ;
	});
	$("#uploadify").uploadify({  
        'auto'           : false,  
        'swf'            : 'js/uploadify/uploadify.swf',  
        'uploader'       : '../../servlet/UploadVideoServlet',
        'queueID'        : 'fileQueue', 
        'folder'         : 'ChapterVideo',
        'cancelImg'      : 'js/uploadify/uploadify-cancel.png',
        'queueSizeLimit' : 1,  
        'fileTypeDesc'   : '只支持flv和mp4格式的视频',  
        'fileTypeExts'   : '*.flv;*.mp4',
        'multi'          : false,  
        'buttonText'     : '本地文件',
		'onUploadSuccess' : function(file, data, response) {
			$('#videoName').val(file.name) ;
			$('#videoAddress').val('Chaptervideo/' + data) ;
			$('#blockInit').hide() ;
			$('#myModal').hide() ;
		},
        'onUploadError' : function(file, errorCode, errorMsg, errorString) {
    		alert('The file ' + file.name + ' could not be uploaded: ' + errorString);
   		},
	});
});

function confirmSaveChapter() {
	var chapterName = $('#newChapterName').val() ;
	var listSelect = $('#listSelect').val() ;
	var chapterContent = $('#newChapterContent').val() ;
	var fileName = $('#videoName').val() ;
	var fileAddress = $('#videoAddress').val() ;
	if( chapterName.length < 2 ) {
		alert( '输入的章节名称长度过短，请修改后重新尝试！' ) ;
	} else if ( chapterName > 25 ) {
		alert( '输入的章节名称长度过长，请修改后重新尝试！' ) ;
	} else if ( listSelect == '' ){
		alert( '请选择一个章节排序后继续尝试！' ) ;
	} else if ( chapterContent.length > 220 ) {
		alert( '输入的章节概述太长，请修改后重新尝试！' ) ;
	} else if ( fileAddress == '' ) {
		alert( '请上传章节视频！' ) ;
	} else {
		$.getJSON("./servlet/AddChapterServlet",{
			UserNum:LoginUserNum,
			CourseNum:CourseNum,
			ChapterContent:chapterContent,
			ChapterName:chapterName,
			ListID:listSelect,
			VideoName:fileName,
			VideoAddress:fileAddress,
		},function(json){
			if ( json.result == 0 ) {
				alert( "章节发布成功！" ) ;
				location.href = 'jsp/afterNew.jsp?ObjectNum='+json.ChapterNum+'&ObjectType=1' ;
			} else if ( json.result == 1 ) {
				alert( "章节发布失败！" ) ;
			}
		});
	}
}