<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>My JSP 'change_password.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.6.3.js"></script>
<script language="JavaScript">
var isOldPasswordRight=false;
var isNewPasswordRight=false;
var isNewPasswordRight1=false;

function giveRightMessage(id, msg) {
	$(id)[0].style.color = "black";
	$(id)[0].innerHTML = msg;
}
function giveErrorMessage(id, msg) {
	$(id)[0].style.color = "red";
	$(id)[0].innerHTML = msg;
}


function validateOldPassword() {
	
	var passwordText = $("#oldPassword")[0].value;
	if (passwordText == "") {
		giveErrorMessage("#op", "密码不能为空");
		isOldPasswordRight=false;
		return;
	}
	if (passwordText.length < 6) {
		giveErrorMessage("#op", "密码长度不小于6");
		isOldPasswordRight = false;
		return;
	}
	giveRightMessage("#op", "密码格式正确");
	isOldPasswordRight = true;
}

/**
 * 验证密码是否符合格式
 */
function validateNewPassword() {
	document.getElementById("newPassword1").value = "";
	isPasswordRight1 = false;
	var passwordText = $("#newPassword")[0].value;
	if (passwordText == "") {
		giveErrorMessage("#np", "密码不能为空");
		isNewPasswordRight = false;
		return;
	}
	if (passwordText.length < 6) {
		giveErrorMessage("#np", "密码长度不小于6");
		isNewPasswordRight = false;
		return;
	}
	giveRightMessage("#np", "密码可用");
	isNewPasswordRight = true;
}
function validateNewPassword1() {
	var passwordText = $("#newPassword")[0].value;
	var passwordText1 = $("#newPassword1")[0].value;
	if (isNewPasswordRight) {
		if (passwordText1 == passwordText) {
			giveRightMessage("#np1", "两次输入一样");
			isNewPasswordRight1 = true;
			return;
		} else {
			giveErrorMessage("#np1", "两次输入不一样");
			isNewPasswordRight1 = false;
			return;
		}
	} else {
		giveRightMessage("#np1", "*");
		isNewPasswordRight1=true;
		return;
	}
}

function verify(){
	if(isOldPasswordRight&&isNewPasswordRight&&isNewPasswordRight1){
		return true;
	}else {
		alert("请正确填写表单");
		return false;
	}
	
}
</script>

</head>

<body>
	<h1>修改密码</h1>
	<br />
	<s:actionerror />
	<form action="user/userManager!changePassword"
		onsubmit="return verify();">
		<table>

			<tr>
				<td>原密码</td>
				<td><input type="password" id="oldPassword" name="oldPassword"
					onchange="validateOldPassword()" /></td>
				<td><div id="op">*</div></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="password" id="newPassword" name="newPassword"
					onchange="validateNewPassword()" /></td>
				<td><div id="np">*</div></td>
			</tr>
			<tr>
				<td>确 认:</td>
				<td><input type="password" id="newPassword1"
					name="newPassword1" onchange="validateNewPassword1()" /></td>
				<td><div id="np1">*</div></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" name="提交" /></td>
			</tr>
		</table>
	</form>
	<strong style="cursor:pointer" onclick="history.back()">点击这里返回</strong>
</body>
</html>
