
$("#UpdateButton").val("UpdateMatch") ;
$(function(){
	$.getJSON("./servlet/QueryMatchByMatchNumServlet",{
		MatchNum:MatchNum,
	},function(json){
		alert(json.MatchName) ;
		$("#MatchName").val(json.MatchName) ;
		$("#MatchContent").val(json.MatchContent) ;
		$("#StartTime").val(json.StartTime) ;
		$("#EndTime").val(json.EndTime) ;
		$("#RegistrationNum").val(json.RegistrationNum) ;
		$("#PublishTime").val(json.PublishTime) ;
		var $r = $("#RegisterTable") ;
		$.getJSON("./servlet/QueryRegisterByMatchNumServlet",{
			MatchNum:MatchNum,
		},function(json){
			if(json.length!=0){
				var rtemp = "" ;
				for(var i=0 ; i<json.length ; i++ ){
					rtemp+="<tr><td>"
						+ json[i].CourseName + "</td><td>"
						+ json[i].NickName + "</td><td>"
						+ json[i].Poll + "</td><td>"
						+ json[i].PollNum + "</td>"
						+ "</tr>" ;
				}
				$r.append( rtemp ) ;			
			}
			$("#AddAwardBody").load( "jsp/Award/AddAward.jsp?MatchNum="+MatchNum ) ;
			setInterval(function() {
				$("#AwardBody").load( "jsp/Award/ShowMyAward.jsp?MatchNum="+MatchNum ) ;
			}, 5000 ) ;
		});
	});
});
function UpdateMatch() {
	var MatchName = "" ;
	var MatchContent = "" ;
	var StartTime = "" ;
	var EndTime = "" ;
	if( $("#UpdateButton").val() == "UpdateMatch" ){
		$("#MatchName").removeAttr('readOnly') ;
		$("#MatchContent").removeAttr('readOnly') ;
		$("#StartTime").removeAttr('readOnly') ;
		$("#EndTime").removeAttr('readOnly') ;
		$("#UpdateButton").html("Confirm") ;
		$("#UpdateButton").val("Confirm") ;
		MatchName = $("#MatchName").val() ;
		MatchContent = $("#MatchContent").val() ;
		StartTime = $("#StartTime").val() ;
		EndTime = $("#EndTime").val() ;
	} else if ( $("#UpdateButton").val() == "Confirm" ) {
		if( $("#MatchName").val() == MatchName &&
				$("#MatchContent").val() == MatchContent &&
				$("#StartTime").val() == StartTime &&
				$("#EndTime").val() == EndTime ) {
			MatchName = $("#MatchName").val() ;
			MatchContent = $("#MatchContent").val() ;
			StartTime = $("#StartTime").val() ;
			EndTime = $("#EndTime").val() ;
			$.getJSON("./servlet/UpdateMatchServlet",{
				MatchNum:MatchNum,
				MatchName:MatchName,
				MatchContent:MatchContent,
				StartTime:StartTime,
				EndTime:EndTime,
			},function(json) {
				if ( json.result == 0 ) {
					alert( "比赛修改成功！" ) ;
					location.reload(false) ;
				} else if ( json.result == 1 ) {
					alert( "比赛修改失败！" ) ;
				}
			});			
		} else {
			alert("您没有做任何修改！") ;
		}
		$("#UpdateButton").html("UpdateMatch") ;
		$("#MatchName").attr("readonly",true) ;
		$("#MatchContent").attr("readonly",true) ;
		$("#StartTime").attr("readonly",true) ;
		$("#EndTime").attr("readonly",true) ;
		$("#UpdateButton").val("UpdateMatch") ;
	}
}

function Back() {
	window.history.back() ;
}

