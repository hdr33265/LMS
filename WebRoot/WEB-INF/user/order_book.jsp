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

<title>My JSP 'order_book.jsp' starting page</title>

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
	<h1>预定图书</h1>

	<table>
		<tr>
			<td width="100px">书名:</td>
			<td><s:property value="bookInfo.name" />
			</td>
		</tr>
		<tr>
			<td>作者:</td>
			<td><s:property value="bookInfo.author" />
			</td>
		</tr>
		<tr>
			<td>类型:</td>
			<td><s:property value="bookInfo.bookClass" />
			</td>
		</tr>
		<tr>
			<td>出版社:</td>
			<td><s:property value="bookInfo.press" />
			</td>
		</tr>
		<tr>
			<td>价格:</td>
			<td><s:property value="bookInfo.price" />
			</td>
		</tr>
		<tr>
			<td>总数:</td>
			<td><s:property value="bookInfo.count" />
			</td>
		</tr>
		<tr>
			<td>描述:</td>
			<td><s:property value="bookInfo.description" />
			</td>
		</tr>
	</table>
	<hr/>
	<table border="1">
		<caption>
			<strong>图书详情列表</strong>
		</caption>
		<tr>
			<th>图书编号</th>
			<th>状态</th>
			<th>被借总次数</th>
			<th>借书人/上一次借书人</th>
			<th>操作</th>
		</tr>
		<s:iterator value="bookDetails" id="book">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="state" /></td>
				<td><s:property value="borrowCount" /></td>
				<td><s:property value="borrower" /></td>
				<td><s:if test="state=='available'">
						<a href="user/orderBook!order?bookId=<s:property value="id" />">预定</a>
					</s:if> <s:else>
			无
			</s:else>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
