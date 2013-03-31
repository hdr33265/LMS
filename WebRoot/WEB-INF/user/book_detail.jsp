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

<title>My JSP 'book_detail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">


</head>

<body>

	<br />
	<table>
		<caption>图书详情如下</caption>
		<tr>
			<th width="100px">属性</th>
			<th>值</th>
		</tr>
		<tr>
			<td>书名:</td>
			<td><s:property value="bookDetail.name" /></td>
		</tr>
		<tr>
			<td>作者:</td>
			<td><s:property value="bookDetail.author" /></td>
		</tr>
		<tr>
			<td>类型:</td>
			<td><s:property value="bookDetail.bookClass" /></td>
		</tr>
		<tr>
			<td>出版社:</td>
			<td><s:property value="bookDetail.press" /></td>
		</tr>
		<tr>
			<td>价格:</td>
			<td><s:property value="bookDetail.price" /></td>
		</tr>
		<tr>
			<td>状态:</td>
			<td><s:property value="bookDetail.state" /></td>
		</tr>
		<tr>
			<td>语种:</td>
			<td><s:property value="bookDetail.lang" /></td>
		</tr>
		<tr>
			<td>描述:</td>
			<td><s:property value="bookDetail.description" /></td>
		</tr>
	</table>
<strong style="cursor:pointer" onclick="history.back()">点击这里返回</strong></body>
</html>
