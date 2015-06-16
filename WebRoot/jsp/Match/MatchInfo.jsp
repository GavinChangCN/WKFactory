<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String MatchNum = request.getParameter("MatchNum"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Match Infomation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script> 
	<script type="text/javascript" src="js/Match/MatchInfo.js"></script>
    <script type="text/javascript">
      var MatchNum = <%="'"+MatchNum+"'"%> ;
    </script>
    <style type="text/css">
		table tr td{ border-top:#00CCFF solid 1px; text-align:center; }
	</style>
  </head>
  
  <body>
    <div align="center" >
    	<label>Match Information</label>
    </div>
    <table align="center" id = "MatchInfoTable">
    	<tr>
    		<td><label>MatchName:</label></td><td><input id="MatchName" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>MatchContent:</label></td><td><textarea id="MatchContent" readonly="readonly" rows="3" ></textarea></td>
    	</tr>
    	<tr>
    		<td><label>StartTime:</label></td><td><input id="StartTime" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>EndTime:</label></td><td><input id="EndTime" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>Register:</label></td><td><input id="RegistrationNum" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>PublishTime:</label></td><td><input id="PublishTime" type="text" readonly="readonly" ></td>
    	</tr>
    </table>
    <div align="center">
    	<button id = "UpdateButton" onclick="UpdateMatch()" >UpdateMatch</button><button onclick="Back()">Back</button>
    </div>
    <div align="center" id = "AddAwardBody" >
    	
    </div>
    <div align = "center" id="AwardBody">
    
    </div>
    <table align="center" id = "RegisterTable">
    	<tr>
    		<td><label>CourseName</label></td><td>UserNickName</td><td>Poll</td><td>PollNum</td>
    	</tr>
    </table>
  </body>
</html>
