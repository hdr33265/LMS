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

<title>My JSP 'user_order_book.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/jquery-1.6.3.js"></script>

<style type="text/css">
.oddrow {
	background: #ddd;
}

body {
	background-color: #7BF284;
	width: 600px;
	margin: 0 auto;
}
</style>
</head>

<body>
	<h1>预定图书</h1>
	<br />
	<strong>搜索图书</strong>
	<br />
	<label>普通搜索:</label>
	<input type="text" name="queryString" id="queryString" />
	<input type="button" value="搜索" id="commonSearcher"
		onclick="commonSearch()" />
	<table id="list">
		<tr>
			<th>序号</th>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>总数</th>
			<th>可用数</th>
			<th>类别</th>
			<th>价格</th>
			<th>语种</th>
			<th>详情</th>
		</tr>
	</table>
</body>
</html>
