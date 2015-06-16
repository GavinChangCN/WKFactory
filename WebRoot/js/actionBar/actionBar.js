$(function(){
	$.ajaxSettings.async = false ;
	var $newCourse = $('#newCourseBtn') ;
	var $myAttend = $('#myAttendBtn') ;
	var $newMatch = $('#newMatchBtn') ;
	if( LoginUserNum == '' ) {
		$("#UnLoginType").show() ;
		$("#HaveLoginType").hide() ; 
		$myAttend.attr( 'onclick' , '{alert("请您先尝试登录，再继续操作！") ; location.href = "login.jsp" ;}')
	} else {
		$("#HaveLoginType").show() ; 
		$("#UnLoginType").hide() ; 
		$('#loginNick').attr('href','person.jsp?UserNum='+LoginUserNum ); 
		var str = LoginNickName ;
		if( str.length > 5) {
			str = LoginNickName.substring(0,3) ;
			str += ".." ;
		}
		$("#loginNick").text(str);
		switch( LoginUserType ) {
			case 3 : 
				$myAttend.show() ;
				$myAttend.find(a).attr( 'href', 'myAttend.jsp?um='+LoginUserNum ) ;	
				$newCourse.hide() ;
				$newMatch.hide() ;
				break ;
			case 2 :
				$myAttend.hide() ;
				$newCourse.show() ;
				$newMatch.hide() ;
				break ;
			case 1 :
				$myAttend.hide() ;
				$newCourse.hide() ;
				$newMatch.show() ;
				break ;
			case 0 :
				$myAttend.hide() ;
				$newCourse.show() ;
				$newMatch.show() ;
				break ;
		}
	}
	$("#logOutBtn").attr( 'href' , 'index.jsp' ) ;
	$("#loginBtn").attr( 'href' , 'login.jsp') ;

});


function login() {
	location.href = "login.jsp" ;
}
function logOut() {
	$.getJSON('./servlet/logOutServlet',{
	},function(json){
		
	});
	location.href = "index.jsp" ;
}
function myInfomation() {
	location.href = "person.jsp?UserNum="+LoginUserNum ;
}
function signUp() {
	location.href = "login.jsp" ;
}

function confirmSearch() {
	var searchInput = $("#searchInput").val() ;
	location.href = "searchCourse.jsp?unsureCourseName=" + searchInput ;
}

function backToHome() {
	location.href = "index.jsp" ;
}

function listenSearch() {
	if( event.keyCode == 13 ){
		confirmSearch() ;
	}
}