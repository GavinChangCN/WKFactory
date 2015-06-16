// 上传附件
$(function(){
	$.ajaxSettings.async = false ;
	$('#indexBtn').attr( 'class' , '' ) ;
	$('#myAttendBtn').attr( 'class' , '' ) ;
	$('#newCourseBtn').attr( 'class' , 'logo_current' ) ;
	if( ObjectType == 0 ) {
		$('#newChapterBtn').show() ;
	} else {
		$('#newChapterBtn').hide() ;
	}
	$("#uploadify").uploadify({  
        'auto'           : false,  
        'swf'            : 'js/uploadify/uploadify.swf',  
        'uploader'       : '../servlet/UploadServlet', 
        'queueID'        : 'fileQueue',  
        'folder'         : 'Accessory',
        'queueSizeLimit' : 1,  
        'cancelImg'      : 'js/uploadify/uploadify-cancel.png',
        'fileTypeDesc'   : 'doc.ppt.pdf.xls',  
        'fileTypeExts'   : '*.doc;*.ppt;*.pdf;*.xls',  
        'multi'          : false,  
        'buttonText'     : '本地文件',
		'onUploadSuccess': function(file, data, response) {
			$('#fileName').val(file.name) ;
			$('#fileAddress').val( 'Accessory/' + data ) ;
			saveAccessory( fileName , fileAddress ) ;
		},
        'onUploadError' : function(file, errorCode, errorMsg, errorString) {
    		alert('The file ' + file.name + ' could not be uploaded: ' + errorString);
   		},
	});
});

function saveAccessory() {
	var fileName = $('#fileName').val() ;
	var fileAddress = $('#fileAddress').val() ;
	$.getJSON('./servlet/saveAccessoryServlet',{
			UserNum:LoginUserNum,
			ObjectNum:ObjectNum,
			ObjectType:ObjectType,
			FileName:fileName,
			FileAddress:fileAddress,
	},function(json){
		if ( json.result == 0 ) {			
			$('#blockInit').hide() ;
			$('#myModal').hide() ;
			alert('上传附件成功！') ;
		}
		if( json.result == 1 ) {
			alert('上传附件失败！') ;
		}
	});
}

function loadnewChapter() {
	location.href = "jsp/Chapter/new_chapter.jsp?CourseNum=" + ObjectNum ;
}