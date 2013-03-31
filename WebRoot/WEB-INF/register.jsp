<%@ page language="java"
	import="java.util.*,studio.hdr.lms.util.DateHelper"
	pageEncoding="utf-8"%>
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

<title>注册页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="style/register.css">

<script type="text/javascript" src="js/reg.js"></script>
<script type="text/javascript" src="js/jquery-1.6.3.js"></script>
</head>

<body>
	<h1 align="center">注册</h1>
	<form id="reg" name="reg" method="post" action="register!register" onsubmit="return validate();">
		<table width="534" border="0" cellspacing="5" height="383"
			style="width: 598px;">
			<tr>
				<td width="157" nowrap="nowrap"><div align="right">用户名：</div></td>
				<td width="234"><input type="text" id="username"
					name="username" onchange="validateUsername()" /></td>
				<td width="212"><div id="tuser">*</div>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><div align="right">密码：</div></td>
				<td><input type="password" id="password" name="password"
					onchange="validatePassword()" />
				</td>
				<td><div id="tpwd">*</div>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><div align="right">密码确认：</div></td>
				<td><input type="password" name="password1" id="password1"
					onchange="validatePassword1()" /></td>
				<td><div id="tpwd1">*</div>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><div align="right">电子邮箱：</div></td>
				<td><input type="text" name="mail" id="mail"
					onchange="validateMail()" /></td>
				<td><div id="tmail">*</div>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><div align="right">联系电话：</div></td>
				<td><input type="text" name="cellphone" id="cellphone"  onchange="validateCellphone()"/></td>
				<td><div id="tcel"></div></td>
			</tr>
			<tr>
				<td valign="top" align="right">密保问题：<br></td>
				<td valign="top"><input type="text" name="question"
					id="question" onchange="validateQuestion()"></td>
				<td valign="top"><div id="tqst">*</div></td>
			</tr>
			<tr>
				<td valign="top" align="right">密保答案：<br></td>
				<td valign="top"><input type="text" name="answer" id="answer" onchange="validateAnswer()">
				</td>
				<td valign="top"><div id="tasw">*</div></td>
			</tr>
			<tr>
				<td nowrap="nowrap"><div align="right">性别：</div></td>
				<td colspan="2"><input name="sex" type="radio" value="男"
					checked="checked" /> 男 <input type="radio" name="sex" value="女" />
					女</td>
			</tr>
			<tr>
				<td nowrap="nowrap"><div align="right">专业班级：</div></td>
				<td colspan="2"><select name="grade" id="selectGrade" onchange="selectGradeChange()">
						<option value="-1">选择年级</option>
						<s:iterator value="grades" id="grade">
							<option value=<s:property value="grade" />>
								<s:property value="grade" />
							</option>
						</s:iterator>
				</select> <label>级</label> <select name="department" id="selectDepartment"
					onchange="selectDepartmentChange()">
						<option value="-1">选择院系</option>
						<s:iterator value="departments" id="department">
							<option value=<s:property value="departmentId"/>>
								<s:property value="departmentName" />
							</option>
						</s:iterator>
				</select> <label>学院</label> <select name="major" id="selectMajor"
					onchange="selectMajorChange()">
						<option value="-1">选择专业</option>
				</select> <label>专业</label> <select name="clbumm" id="selectClbumm" onchange="selectClbummChange()">
						<option value="-1">选择班级</option>
				</select> <label id="ban">班</label> <input type="text" name="num" id="num" onchange="validateNum()" />
				</td>

			</tr>
			<tr>
				<td><div align="right">出生年月：</div></td>
				<td colspan="2"><select name="year" class="zc_sel" id="year" onchange="selectBirthDayChange()">
						<option>选择年</option>
						<s:iterator value="birthYears" id="year" >
							<option>
								<s:property value="year" />
							</option>
						</s:iterator>
				</select> <label>年</label> <select name="month" class="zc_sel" id="month" onchange="selectBirthDayChange()">
						<option>选择月</option>
						<s:iterator value="months" id="month">
							<option>
								<s:property value="month" />
							</option>
						</s:iterator>
				</select> <label>月</label> <select name="day" class="zc_sel" id="day" onchange="selectDayChange()">
						<option>选择日</option>
				</select> <label>日</label></td>
			</tr>
			<tr>
				<td colspan="3"><div align="center">
						<input type="submit" name="Submit" value="提交"  />
					</div></td>
			</tr>
		</table>
	</form>
</body>
</html>
