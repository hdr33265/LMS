<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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

<title>My JSP 'user_info.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table>
		<caption>个人信息</caption>
		<tr>
			<td>用户名：</td>
			<td><s:property value="userInfo.userName" /></td>
		</tr>
		<tr>
			<td>邮箱：</td>
			<td><s:property value="userInfo.mail" /></td>
		</tr>
		<tr>
			<td>手机号：</td>
			<td><s:property value="userInfo.cellphone" /></td>
		</tr>
		<tr>
			<td>学院：</td>
			<td><s:property value="userInfo.department" /></td>
		</tr>
		<tr>
			<td>已借数量：</td>
			<td><s:property value="userInfo.count" /></td>
		</tr>
		<s:if test="userInfo.major=='教师'">
			<tr>
				<td>身份：</td>
				<td>教师</td>
			</tr>
		</s:if>
		<s:else>
			<tr>
				<td>身份：</td>
				<td>学生：</td>
			</tr>
			<tr>
				<td>年级：</td>
				<td><s:property value="userInfo.grade" /></td>
			</tr>
			<tr>
				<td>专业：</td>
				<td><s:property value="userInfo.major" /></td>
			</tr>

			<tr>
				<td>班级：</td>
				<td><s:property value="userInfo.clbumm" /></td>
			</tr>

			<tr>
				<td>学号：</td>
				<td><s:property value="userInfo.num" /></td>
			</tr>
		</s:else>
	</table>
	<strong style="cursor:pointer" onclick="history.back()">点击这里返回</strong>
</body>
</html>
