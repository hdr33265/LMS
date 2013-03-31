var isUsernameRight = false;
var isPasswordRight = false;
var isCaptchaRight = false;

function ajaxForName(data) {
	// alert(data);
	if (data) {
		ut.style.color = "black";
		ut.innerHTML = "用户名可用";
		isUsernameRight = true;
	} else {
		ut.style.color = "red";
		ut.innerHTML = "用户名不存在";
		isUsernameRight = false;
	}
}

function validateUsername() {
	var ut = document.getElementById("ut");
	var usernameText = $("#username")[0].value;
	if (usernameText == "") {
		isUsernameRight = false;
		ut.innerHTML = "*"
		return;
	}
	if (usernameText.length < 6) {
		isUsernameRight = false;
		ut.style.color = "red";
		ut.innerHTML = "用户名不少6位";
		return;
	}
	var pattern = /^[a-zA-Z_]([\S]{5,})$/;
	if (pattern.test(usernameText) == false) {
		isUsernameRight = false;
		ut.style.color = "red";
		ut.innerHTML = "首字符为字母或下划线";
		return;
	}
	var identify = "";
	var identifies = document.getElementsByName("identity");
	for ( var i = 0; i < identifies.length; i++) {
		if (identifies[i].checked) {
			identify = identifies[i].value;
			break;
		}

	}

	if (identify == "user") {
		$.ajax({
			url : "register!validateUserIsExists",
			type : "post",
			data : "uname=" + usernameText,
			dataType : "json",
			success : ajaxForName
		});
	} else if (identify == "admin") {

		$.post("admin/adminManager!validateAdminIsExists", {
			adminName : usernameText
		}, ajaxForName, "json");
	}
}

function validatePassword() {
	var passwordText = $("#password")[0].value;
	if (passwordText == "") {
		isPasswordRight = false;
		return;
	}
	if (passwordText.length < 6) {
		isPasswordRight = false;
		return;
	}
	isPasswordRight = true;
}

function valify() {

//	alert("我擦");
//	return false;
	 if (isUsernameRight == false) {
		alert("用户名不存在");
		return false;
	}
	if (isPasswordRight == false) {
		alert("密码不符合规范");
		return false;
	}
	if (isCaptchaRight == false) {
		alert("验证码错误");
		return false;
	}
	return true;
}

function validateCaptcha() {
	var captcha = document.getElementById("captcha");

	var flag = false;
	if (captcha.value == "") {
		captcha.focus();
	} else {
		var captchaString = captcha.value;
		$.post("captchaImage!validateCode", {
			captcha : captchaString
		}, function(data) {
			if (data) {
				isCaptchaRight = true;
			} else {
				isCaptchaRight = false;
			}
		}, "json");
	}
	return flag;
}