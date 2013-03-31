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

<title>My JSP 'return_book.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/borrow.js"></script>
	<script type="text/javascript" src="js/jquery-1.6.3.js"></script>
</head>

<body>
	<h1>归还图书</h1>
	<br />
	<table>
		<tr>
			<td><input type="text" name="id" id="id"/>
			</td>
			<td><input type="button" name="search" value="搜索" onclick="searchbook()"/>
			</td>
		</tr>
		<tr>
			<td>类型:</td>
			<td><input type="radio" name="type" value="userId" checked="checked" />还书人<input
				type="radio" name="type" value="bookId" />图书编号</td>
		</tr>
	</table>
	<table id="books">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>作者</th>
			<th>借书日期</th>
			<th>是否超期</th>
			<th>操作</th>
		</tr>
	</table>
</body>
</html>
