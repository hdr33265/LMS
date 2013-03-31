var isUsernameRight = false;
var isPasswordRight = false;
var isPasswordRight1 = false;
var isMailRight = false;
var isQuestionRight = false;
var isCellphoneRight = true;
var isAnswerRight = false;
var isBirthDayRight = false;

var isGradeRight = false;
var isDepartmentRight = false;
var isMajorRight = false;
var isClbummRight = false;
var isNumRight = false;

function giveRightMessage(id, msg) {
	$(id)[0].style.color = "black";
	$(id)[0].innerHTML = msg;
}
function giveErrorMessage(id, msg) {
	$(id)[0].style.color = "red";
	$(id)[0].innerHTML = msg;
}

/**
 * 验证用户名是否正确
 */
function validateUsername() {
	var usernameText = $("#username")[0].value;
	if (usernameText == "") {
		giveErrorMessage("#tuser", "用户名不能为空");
		isUsernameRight = false;
		return;
	}
	if (usernameText.length < 6) {
		giveErrorMessage("#tuser", "长度不少于6");
		isUsernameRight = false;
		return;
	}
	var pattern = /^[a-zA-Z_]([\S]{5,})$/;
	if (pattern.test(usernameText) == false) {
		giveErrorMessage("#tuser", "首字符为字母或下划线");
		isUsernameRight = false;
		return;
	}
	$.ajax({
		url : "register!validateUserIsExists",
		type : "post",
		data : "uname=" + usernameText,
		dataType : "json",
		success : function(data) {
			if (data) {
				giveErrorMessage("#tuser", "用户名已存在");
				isUsernameRight = false;
			} else {
				giveRightMessage("#tuser", "用户名可用");
				isUsernameRight = true;
			}
		}
	});
}
/**
 * 验证密码是否符合格式
 */
function validatePassword() {
	document.getElementById("password1").value = "";
	isPasswordRight1 = false;
	var passwordText = $("#password")[0].value;
	if (passwordText == "") {
		giveErrorMessage("#tpwd", "密码不能为空");
		isPasswordRight = false;
		return;
	}
	if (passwordText.length < 6) {
		giveErrorMessage("#tpwd", "密码长度不小于6");
		isPasswordRight = false;
		return;
	}
	giveRightMessage("#tpwd", "密码可用");
	isPasswordRight = true;
}
function validatePassword1() {
	var passwordText = $("#password")[0].value;
	var passwordText1 = $("#password1")[0].value;
	if (isPasswordRight) {
		if (passwordText1 == passwordText) {
			giveRightMessage("#tpwd1", "两次输入一样");
			isPasswordRight1 = true;
			return;
		} else {
			giveErrorMessage("#tpwd1", "两次输入不一样");
			isPasswordRight1 = false;
			return;
		}
	} else {
		giveRightMessage("#tpwd1", "*");
		return;
	}
}
/**
 * 验证邮箱是否正确
 */
function validateMail() {
	var pattern = /^([0-9a-zA-Z]+[_\.0-9a-zA-Z-]*)@([a-zA-Z0-9-]+[\.])+([a-zA-Z]{2,3})$/;
	var mailText = $("#mail")[0].value;
	if (pattern.test(mailText)) {
		giveRightMessage("#tmail", "邮箱合法");
		isMailRight = true;
		return;
	} else {
		giveErrorMessage("#tmail", "请输入正确的邮箱");
		isMailRight = false;
		return;
	}
}
/**
 * 验证密码问题是否为空
 */
function validateQuestion() {
	var questionText = $("#question")[0].value;
	if (questionText == "") {
		giveErrorMessage("#tqst", "密码问题不能为空");
		isQuestionRight = false;
		return;
	} else {
		giveRightMessage("#tqst", "密码问题可用");
		isQuestionRight = true;
	}
}
/**
 * 验证密码答案是否为空
 */
function validateAnswer() {
	var questionText = $("#answer")[0].value;
	if (questionText == "") {
		giveErrorMessage("#tasw", "密码答案不能为空");
		isAnswerRight = false;
		return;
	} else {
		giveRightMessage("#tasw", "密码答案可用");
		isAnswerRight = true;
	}
}

function validateCellphone() {
	var cellphoneText = $("#cellphone")[0].value;
	if (cellphoneText == "") {
		giveRightMessage("#tcel", "");
		isCellphoneRight = true;
	} else {
		var pattern = /^1[3458]\d{9}$/;
		if (pattern.test(cellphoneText)) {
			giveRightMessage("#tcel", "手机号可用");
			isCellphoneRight = true;
		} else {
			giveErrorMessage("#tcel", "请输入正确的手机号");
			isCellphoneRight = false;
		}
	}
}

/**
 * 对select插入一个选项
 * 
 * @param se
 * @param optionName
 */
function insertOption(se, optionValue, optionName) {
	// se.append("<option value='"+optionValue+"'>"+optionName+"</option>");
	// var op = new Option();
	// op.value = optionValue;
	// op.setAttribute("value", optionValue)
	// op.text = optionName;
	// se.add(op);
	var op = new Option(optionName, optionValue);
	// op.value = optionValue;
	// op.setAttribute("value", optionValue)
	// op.text = optionName;
	se.add(op);
}

function selectGradeChange() {
	var grade = $("#selectGrade")[0].value;
	if (grade != -1) {
		isGradeRight = true;
	} else {
		var major = $("#selectMajor").find("option:selected").val();
		if (major == "教师") {
			isGradeRight = true;
		} else {
			isGradeRight = false;
		}
	}

}
/**
 * ajax请求majors名
 */
function selectDepartmentChange() {
	$("#selectMajor").children().eq(0).siblings().remove();
	$("#selectClbumm").children().eq(0).siblings().remove();
	isMajorRight = false;
	isClbummRight = false;
	isNumRight = false;
	var sd = $("#selectDepartment")[0];
	var id = sd.value;
	if (id != -1) {
		isDepartmentRight = true;
		$.post("register!getMajorsByDepartmentId", {
			"departmentId" : id
		}, function(data) {
			var sm = document.getElementById("selectMajor");
			$.each(data, function(i, major) {
				insertOption(sm, major.majorId, major.majorName);
			});
		}, "json");
	} else {
		isDepartmentRight = false;

	}
}

/**
 * ajax请求clbumms名
 */
function selectMajorChange() {
	$("#selectClbumm").children().eq(0).siblings().remove();
	var id = $("#selectMajor")[0].value;
	if (id == -1) {
		isMajorRight = false;
	} else {
		var temp = $("#selectMajor").find("option:selected").val();
		if (temp == "教师") {
			$("#selectClbumm").hide();
			$("#num").hide();
			$("#ban").hide();
			isGradeRight = true;
			isMajorRight = true;
			isClbummRight = true;
			isNumRight = true;
		} else {
			$("#selectClbumm").show();
			$("#num").show();
			$("#ban").show();
			isMajorRight = true;
			$.ajax({
				url : "register!getClbummsByMajorId",
				type : "POST",
				dataType : "json",
				data : {
					majorId : id
				},
				success : function(data) {
					var sc = document.getElementById("selectClbumm");
					$.each(data, function(i, clbumm) {
						insertOption(sc, clbumm.clbummId, clbumm.clbummNum);
					});
				}
			});
		}
	}
}
function selectClbummChange() {
	var majorText = $("#selectMajor").find("option:selected").val();
	if (majorText = "教师") {
		isClbummRight = true;
		return;
	}
	var clbummText = $("#selectClbumm").find("option:selected").val();
	if (clbummText == "选择班级") {
		isClbummRight = false;
	} else {
		isClbummRight = true;
	}
}
function validateNum() {
	var numText = $("#num")[0].value;
	var pattern = /^(0[1-9])|([1-9]\d)$/g;
	if (pattern.test(numText)) {
		isNumRight = true;
	} else {
		alert("学号必须是一位或两个的数字");
		// $("#num")[0].text="学号必须是一位或两个的数字";
		isNumRight = false;
	}
}

/**
 * ajax请求对应月份的天数
 */
function selectBirthDayChange() {
	var yearText = $("#year").find("option:selected").val();
	var monthText = $("#month").find("option:selected").val();
	$("#day").children().eq(0).siblings().remove();
	if (yearText == "选择年") {
		isBirthDayRight = false;
		return;
	}
	if (monthText == "选择月") {
		isBirthDayRight = false;
		return;
	}
	$.ajax({
		url : "register!getBirthDays",
		type : "post",
		data : {
			birthYear : yearText,
			birthMonth : monthText
		},
		dataType : "json",
		success : function(json) {
			var sm = document.getElementById("day");
			$.each(json, function(i, value) {
				insertOption(sm, value, value);
			});
		}
	});
}
/**
 * 
 */
function selectDayChange() {
	var dayText = $("#day").find("option:selected").val();
	if (dayText == "选择日") {
		isBirthDayRight = false;
	} else {
		isBirthDayRight = true;
	}
}
/**
 * 验证整个表单数据是否合格
 */
function validate() {
	if (isUsernameRight == false) {
		alert("用户名不符合规范");
		document.getElementById("username").focus();
		return false;
	}
	if (isPasswordRight == false) {
		alert("密码不符合规范");
		return false;
	}
	if (isPasswordRight1 == false) {
		alert("两次密码不一样");
		return false;
	}
	if (isMailRight == false) {
		alert("邮箱不符合规范");
		return false;
	}
	if (isQuestionRight == false) {
		alert("密码问题不能为空");
		return false;
	}
	if (isAnswerRight == false) {
		alert("密码答案不能为空");
		return false;
	}
	if (isBirthDayRight == false) {
		alert("请选择您的生日");
		return false;
	}
	if(isGradeRight==false){
		alert("请选择您的年级");
	}
	if (isDepartmentRight == false) {
		alert("请选择学院");
		return false;
	}
	if (isMajorRight == false) {
		alert("请选择专业");
		return false;
	}
	if (isClbummRight == false) {
		alert("请选择班级");
		return false;
	}
	if (isNumRight == false) {
		alert("请输入正确的学号");
		return false;
	}
	return true;
}
