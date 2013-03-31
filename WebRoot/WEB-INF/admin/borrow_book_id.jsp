<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'right.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.6.3.js"></script>
<script type="text/javascript" src="js/borrow.js"></script>
</head>

<body>
	<h1>借阅图书</h1>
	<br />
	<table>
		<tr>
			<td>借书人:</td>
			<td><input type="text" id="borrower" name="borrower" />
			</td>
			<td>
				<span>用户名</span><input checked type="radio" name="usertype"
				value="name" />
				<span>编号</span><input  type="radio"
				name="usertype" value="id" />
				<span>学号</span><input 
				type="radio" name="usertype" value="num" />
			</td>
		</tr>
		<tr>
			<td>图书编号:</td>
			<td colspan="2"><input type="text" name="id0" /></td>
		</tr>
		<tr>
			<td>图书编号:</td>
			<td colspan="2"><input type="text" name="id1" /></td>
		</tr>
		<tr>
			<td>图书编号:</td>
			<td colspan="2"><input type="text" name="id2" /></td>
		</tr>
		<tr>
			<td>图书编号:</td>
			<td colspan="2"><input type="text" name="id3" /></td>
		</tr>
		<tr>
			<td>图书编号:</td>
			<td colspan="2"><input type="text" name="id4" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="button" value="借阅" onclick="借阅"/>
			</td>
		</tr>
	</table>
</body>
</html>
