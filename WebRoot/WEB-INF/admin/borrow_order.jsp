<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'borrow_order.jsp' starting page</title>
                             
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/return.js"></script>
	<script type="text/javascript" src="js/jquery-1.6.3.js"></script>
  </head>
  
  <body>
    <h1>订单处理</h1>
    <br />
	<table>
		<tr>
		<td>借书人:   </td>
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
			<td><input type="button" value="查询订单" onclick="getOrders()"/></td>
			<td><input type="button" value="全部借阅" onclick="borrowAll()"/></td>
		</tr>
	</table>
	<table id="orders">
		<tr>
		<th>编号</th>
		<th>书名</th>
		<th>作者</th>
		<th>类型</th>
		<th>预定日期</th>
		<th>截止日期</th>
		<th>价格</th>
		<th>出版社</th>
		<th>操作</th>		
		</tr>
	</table>
  </body>
</html>
