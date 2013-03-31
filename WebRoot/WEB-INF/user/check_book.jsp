<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_check_book.jsp' starting page</title>
    
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
  	你所借阅的图书情况如下：<s:debug/><br/>
  	<table border="1px">
  	<tr>
  		<th>书名</th>
  		<th>作者</th>
  		<th>借阅日期</th>
  		<th>截止日期</th>
  		<th>出版社</th>
  		<th>类别</th>
  		<th>价格</th>
  		<th>详情</th>
  	</tr>
  	<s:iterator value="recordList" id="record">
  	<tr>
  		<td><s:property value="name"/></td>
  		<td><s:property value="author"/></td>
  		<td><s:property value="borrowDate"/></td>
  		<td><s:property value="deadline"/></td>
  		<td><s:property value="press"/></td>
  		<td><s:property value="bookClass"/></td>
  		<td><s:property value="price"/></td>
  		<td><a href="user/bookDetail?bookId=<s:property value="id"/>">点击此处查看详情</a></td>
  	</tr>
  	</s:iterator>
  	</table>
  	
  </body>
</html>
