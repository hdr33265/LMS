<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
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
  <s:debug></s:debug>
  <h1>用户列表</h1>
 
  	<s:property value="#action.str"/>

  <table width="200" border="1">
    <tr>
      <th scope="col">用户名</th>
      <th scope="col">邮箱</th>
      <th scope="col">性别</th>
      <th scope="col">手机号</th>
    </tr>
     <s:iterator value="#request.userList" id="user">
    <tr>
      <td><s:property value="#user.userName"/><br></td>
      <td><s:property value="#user.userMail"/><br></td>
      <td><s:property value="#user.userSex"/><br></td>
      <td><s:property value="#user.userMobilphone"/><br></td>
    </tr>
      </s:iterator>
  </table>
  </body>
</html>
