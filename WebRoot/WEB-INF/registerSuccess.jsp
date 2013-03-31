<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'registerSuccess.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<SCRIPT LANGUAGE="JavaScript">
<!--
	var time = 4; //时间,秒 

	function Redirect() {
		window.location = "login";
	}
	var i = 0;
	function dis() {
		document.all.s.innerHTML = (time - i) + "";
		i++;
	}
	timer = setInterval('dis()', 1000);//显示时间 
	timer = setTimeout('Redirect()', time * 1000); //跳转
//-->
</SCRIPT>

</head>

<body>
	注册成功，
	<span id="s">5</span>秒后跳转到登陆界面
	<br> 马上跳转？点击
	<a href="login">这里</a>
</body>
</html>
