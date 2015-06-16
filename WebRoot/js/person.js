// JavaScript Document
var local = window.location;  
var contextPath = local.pathname.split("/")[1];  
var basePath = local.protocol+"//"+local.host+"/"+contextPath+'/';
var $em1 = $('#em1') ;
var $em2 = $('#em2') ;
var $em3 = $('#em3') ;
var $ul1 = $('#ul1') ;
var $ul2 = $('#ul2') ;
var $ul3 = $('#ul3') ;
$(function() {
	$.ajaxSettings.async = false ;
	isMine() ;
	whatUserType() ;
	var userPic = '' ;
	window.onload=function(){
	    /*第1个参数是加载编辑器div容器，第2个参数是编辑器类型，第3个参数是div容器宽，第4个参数是div容器高*/
		xiuxiu.embedSWF("altContent",5,"100%","99%");
	    //修改为您自己的图片上传接口
		xiuxiu.setUploadURL(basePath+"userPic_upload_form.jsp");
		xiuxiu.setUploadType(2);
		xiuxiu.setUploadDataFieldName("TestFile");
		xiuxiu.onInit = function ()
		{
			xiuxiu.loadPhoto("");
		}	
		xiuxiu.onUploadResponse = function (data)
		{
			userPic = decodeURI(data) ;
			userPic = userPic.replace(/ /, '').replace( /\r/,'' ).replace( /\n/,'' ).replace( /\t/, '') ;
			alert( '用户头像地址：' + userPic ) ;
			$('#fileAddress').val(userPic) ;
			updateUserPic( userPic ) ;
			$('#blockInit').hide() ;
			$('#myModal').hide() ;
		}
	};
	$.getJSON("./servlet/QueryUserInfoServlet",{
		UserNum:TUserNum,
	},function(json){
		$('#emUserPicture').attr( 'src' , json.UserPicture ) ;
		$('#emNickName').text(json.NickName) ;
	});
	$('#geren').click(function(){
		$(this).addClass('subject_current');
		$('#Settings').removeClass('subject_current');
		$('#person_Logout').removeClass('subject_current');
		$('.right1').show();
		$('.right2').hide();
		})
	$('#Settings').click(function(){
		$(this).addClass('subject_current');
		$('#geren').removeClass('subject_current');
		$('#person_Logout').removeClass('subject_current');
		$('.right2').show();
		$('.right1').hide();
		})
	/*$('#person_Logout').click(function(){
		$(this).addClass('subject_current');
		$('#geren').removeClass('subject_current');
		$('#Settings').removeClass('subject_current');		
		})*/
	
    $em1.click(function(){
		$(this).addClass('em_current');
		$em2.removeClass('em_current');
		$em3.removeClass('em_current');
		$ul1.show();
		$ul2.hide();
		$ul3.hide() ;
		})
	$em2.click(function(){
		$(this).addClass('em_current');
		$em1.removeClass('em_current');
		$em2.removeClass('em_current');
		$ul2.show();
		$ul1.hide();
		$ul3.hide() ;
		})
	$em3.click(function(){
		$(this).addClass('em_current');
		$em2.removeClass('em_current');
		$em1.removeClass('em_current');
		$ul3.show() ;
		$ul1.hide();
		$ul2.hide();
		})
	$('#person_Logout').on('click', function(){
		$(this).addClass('subject_current');
		$('#geren').removeClass('subject_current');
		$('#Settings').removeClass('subject_current');
					 $.layer({
						 title: '一键注销',
						area: ['200px','100px'],
						btn: ['确定注销','取消'],
						dialog: {
							btns: 2,                    
							type: 4,
							btn: ['确定注销','取消']
						}
						
						
					});
						
				})
});

/**
 * 判断是否查看个人中心用户为本人
 */
function isMine() {
	if( LoginUserNum != TUserNum ){
		$('#Settings').hide() ;
		$('#person_Logout').hide() ;
	}
}

function whatUserType() {
	switch( LoginUserType ) {
		case 0:
			showMyCourses() ;
			showMyMatchs() ;
			$em1.hide() ;
			$em2.show() ;
			$em3.show() ;
			$ul1.hide() ;
			$ul2.show() ;
			$ul3.hide() ;
			$em2.addClass('em_current') ;
			break ;
		case 1:
			showMyMatchs() ;
			$em1.hide() ;
			$em2.hide() ;
			$em3.show() ;
			$ul1.hide() ;
			$ul2.hide() ;
			$ul3.show() ;
			$em3.addClass('em_current') ;
			break ;
		case 2:
			showMyCourses() ;
			$em1.hide() ;
			$em2.show() ;
			$em3.hide() ;
			$ul1.hide() ;
			$ul2.show() ;
			$ul3.hide() ;
			$em2.addClass('em_current') ;
			break ;
		case 3:
			showMyAttend() ;
			$em1.show() ;
			$em2.hide() ;
			$em3.hide() ;
			$ul1.show() ;
			$ul2.hide() ;
			$ul3.hide() ;
			$em1.addClass('em_current') ;
			break ;
	}
}
/**
 * 更新用户头像
 */
function updateUserPic( userPic ) {
	alert('更新方法获得的头像数据:' + userPic ) ;
	if( UserPic = '' ) {
		alert( '请先上传头像才尝试更新！') ;
	} else {
		$.getJSON( './servlet/updateUserPicServlet',{
			UserNum:TUserNum,
			UserPic:userPic,
		},function(json){
			if ( json.result == 0 ) {
				alert( '更新头像成功！' ) ;
				location.href = 'person.jsp?UserNum='+TUserNum ;
			} else if ( json.result == 1 ) {
				alert( '更新头像失败！' ) ;
			}
		}) ;
	}
}

function logOut() {
	$.ajaxSettings.async = false ;
	$.getJSON('./servlet/logOutServlet',{
	},function(json){
		
	});
	$.ajaxSettings.async = true ;
	location.href = "index.jsp" ;
}

/**
 * 遍历我的订阅
 */
function showMyAttend() {
	$.getJSON("./servlet/ShowMyAttendsServlet",{
		UserNum:TUserNum,
	},function(json){
		var temp = '' ;
		if( json == null ) {
			var showResult = '<div align="center"><p class = "showResult" >您未订阅过任何课程！</p></div>' ;
			$ul1.append(showResult) ;
		} else {
			for(var i = 0 ; i < json.length ; i ++ ){
				var url = 'course.jsp?CourseNum='+json[i].CourseNum
				+ '&ListId=0' ;
				var content = json[i].CourseContent ;
				if( content.length >= 20) {
					content = content.substring(0,16) ;
					content += "..." ;
				}
				var subject = json[i].SubjectName ;
				if ( subject.length >= 5 ) {
					subject = subject.substring(0,3) ;
					subject += ".." ;
				}
				var cname = json[i].CourseName ;
				if ( cname.length >= 20 ) {
					cname = cname.substring(0, 16) ;
					cname += "..." ;
				}
				var period = json[i].Period ;
				if( period != 0 ){
					temp += '<li>'   
						+ '<a href='+url+'><img src = "'+json[i].CoverPicture+'" width="230" height="130"/></a>'
						+ '<a class ="main_1_a1" href="#">'+cname+'</a>'
						+ '<p>'+content+'</p>'
						+ '<em><i class = "i1" >' + period + ' 章节</i>'
						+ '<i style="display:none;" class = "i3" >' + json[i].AudienceNum + '人观看</i>'
						+ '<i style="display:none;" class = "i2">' + subject + '</i>'
						+ '<i class="i3" ><a ><img href=' + url + ' src = "img/index_15.jpg" width="21" height="21" /></a></i>'
						+ '</em>'
						+ '<img class = "img" src = "img/index_16.png" width = "50" height = "50" /> '
						+ '</li>' ;
				}
			}
		}
		$ul1.append( temp ) ;
	});
}

/**
 * 显示我创建的课程
 */
function showMyCourses(){
	$.getJSON("./servlet/QueryCourseByUserNumServlet",{
		UserNum:TUserNum,
	},function(json){
		var ctemp = '' ;
		if( json == null ) {
			var showResult = '<div align="center"><p class = "showResult" >您未创建过任何课程！</p></div>' ;
			$ul2.append(showResult) ;
		} else {
			for(var i = 0 ; i < json.length ; i ++ ){
				var url = 'course.jsp?CourseNum='+json[i].CourseNum
				+ '&ListId=0' ;
				var content = json[i].CourseContent ;
				if( content.length >= 20) {
					content = content.substring(0,16) ;
					content += "..." ;
				}
				var subject = json[i].SubjectName ;
				if ( subject.length >= 5 ) {
					subject = subject.substring(0,3) ;
					subject += ".." ;
				}
				var cname = json[i].CourseName ;
				if ( cname.length >= 20 ) {
					cname = cname.substring(0, 16) ;
					cname += "..." ;
				}
				var period = json[i].Period ;
				if( period != 0 ){
					ctemp += '<li>'   
						+ '<a href='+url+'><img src = "'+json[i].CoverPicture+'" width="230" height="130"/></a>'
						+ '<a class ="main_1_a1" href="#">'+cname+'</a>'
						+ '<p>'+content+'</p>'
						+ '<em><i class = "i1" >' + period + ' 章节</i>'
						+ '<i style="display:none;" class = "i3" >' + json[i].AudienceNum + '人观看</i>'
						+ '<i style="display:none;" class = "i2">' + subject + '</i>'
						+ '<i class="i3" ><a ><img href=' + url + ' src = "img/index_15.jpg" width="21" height="21" /></a></i>'
						+ '</em>'
						+ '<img class = "img" src = "img/index_16.png" width = "50" height = "50" /> '
						+ '</li>' ;
				}
			}
		}
		$ul2.append( ctemp ) ;
	});
}

/**
 * 展示我的比赛
 */
function showMyMatchs() {
	$.getJSON("./servlet/QueryMatchByUserNumServlet",{
		UserNum:TUserNum,
	},function(json){
		var mtemp = '' ;
		if( json == null ) {
			var showResult = '<div align="center"><p class = "showResult" >您未创建过任何比赛！</p></div>' ;
			$ul3.append(showResult) ;
		} else {
			for(var i = 0 ; i < json.length ; i ++ ){
				var url = 'match.jsp?MatchNum='+json[i].MatchNum ;
				var content = json[i].MatchContent ;
				if( content.length >= 20) {
					content = content.substring(0,16) ;
					content += "..." ;
				}
				var mname = json[i].MatchName ;
				if ( mname.length >= 20 ) {
					mname = mname.substring(0, 16) ;
					mname += "..." ;
				}
				mtemp += '<li>'   
					+ '<a href='+url+'><img src = "'+json[i].CoverPicture+'" width="230" height="130"/></a>'
					+ '<a class ="main_1_a1" href="#">'+mname+'</a>'
					+ '<p>'+content+'</p>'
					+ '<em><i class = "i1" >' + json[i].RegistrationNum + ' 参赛课程</i></em>'
					+ '<img class = "img" src = "img/index_16.png" width = "50" height = "50" /> '
					+ '</li>' ;
			}
		}
		$ul3.append( mtemp ) ;
	});
}