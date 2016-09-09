<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#right {
	float: left;
	margin-left: 100px;
	margin-top: 100px;
}

#right legend {
	font-size: 13px;
}

#right table tr td {
	font-size: 16px;
}

#out {
	width: 600px;
	height: 300px;
	position: absolute;
	left: 45%;
	top: 45%;
	margin-left: -200px;
	margin-top: -200px;
	border: 1px;
	align: center;
	float: right;
}

#updateInfo {
	width: 300px;
	height: 150px;
	position: relative;
	left: 50%;
	top: 20%;
	margin-left: -150px;
	margin-top: -30px;
}

#updateInfo table tr {
	height: 30px;
}

.code {
	font-family: serif;
	font-style: italic;
	color: red;
	corder: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}
</style>

<div
	style="padding: 3px 2px; border-bottom: 1px solid #ccc; text-align: center;">修改个人信息</div>

<div id="right">
	<fieldset id="updateinfo">
		<legend>修改须知</legend>
		<table>
			<tr>
				<td>1.密码已经加密，请谨慎修改</td>
			</tr>
			<tr>
				<td>2.生日请正确选择</td>
			</tr>
			<tr>
				<td>3.联系方式请正确填写</td>
			</tr>
			<tr>
				<td>4.邮箱请谨慎修改</td>
			</tr>
			<tr>
				<td>5.个人信息请做好保密工作</td>
			</tr>
		</table>
	</fieldset>
</div>

<div id="out">
	<form id="updateInfo" method="post">
		<table>
			<tr>
				<td>用户id</td>
				<td><span id="usids">${user.usid}</span></td>
			</tr>
			<tr>
				<td>注册日期</td>
				<td><span>${user.register_time}</span></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input id="usname" name="usname" type="text"
					value="${user.usname}" onblur="checkUsname()" /></td>
			</tr>
			<tr id="nameResultOut" style="display: none;">
				<td></td>
				<td><span id="nameResult" style="color: red">&nbsp;</span></td>
			</tr>
			<tr>
				<td>用户性别</td>
				<td><c:if test="${user.usex=='男'}">
						<input type="radio" value="男" name="usex" id="usex"
							checked="checked">男 
					<input type="radio" value="女" name="usex" id="usex">女
				</c:if> <c:if test="${user.usex=='女'}">
						<input type="radio" value="男" name="usex" id="usex">男 
					<input type="radio" value="女" name="usex" checked="checked"
							id="usex">女
				</c:if></td>
			</tr>
			<tr>
				<td>修改密码</td>
				<td><input id="upwd" name="upwd" type="password"><span
					style="margin-left: 18px; font-size: 12px;">*可不填</span></td>
			</tr>
			<tr>
				<td>重复密码</td>
				<td><input id="upwdagain" name="upwd" type="password"
					onblur="checkpwdagain()" /><span
					style="margin-left: 18px; font-size: 12px;">*可不填</span></td>
			</tr>
			<tr id="checkPwdOut" style="display: none;">
				<td></td>
				<td><span id="checkPwd" style="color: red">&nbsp;</span></td>
			</tr>
			<tr>
				<td>用户邮箱</td>
				<td><input id="uemail" name="uemail" type="email"
					value="${user.uemail}" onblur="checkuemail()"></td>
			</tr>
			<tr id="uemailResultOut" style="display: none;">
				<td></td>
				<td><span id="uemailResult" style="color: red">&nbsp;</span></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input id="tel" name="tel" type="tel" value="${user.tel}"></td>
			</tr>
			<tr>
				<td>地区</td>
				<td><input id="area" name="area" type="text"
					value="${user.area}"></input></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input id="birthday" name="birthday" type="text"
					data-options="onSelect:onSelect" class="easyui-datebox"
					value="${user.birthday}" /></td>
			</tr>
			<tr id="birthdayResultOut" style="display: none;">
				<td></td>
				<td><span id="birthdayResult" style="color: red">&nbsp;</span></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input id="input1" type="text" onblur="checkCodeInfo()"
					style="margin-top: 10px;" /><br /> <input type="text"
					id="checkCode" class="code" style="width: 50px; margin-top: 10px;" />
					<a href="javascript:createCode()">看不清楚</a></td>
			</tr>
			<tr id="codeResultOut" style="display: none;">
				<td></td>
				<td><span id="codeResult" style="color: red">&nbsp;</span></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<p style="text-align: center;">
						<input type="button" onclick="updateAdminInfo()" value="确认修改" />
					</p>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	var checkPwd = true;
	var checkBirthday = true;
	var checkEmail = true;
	var checkCodes = true;
	var checkUname=true;

	var code;//在全局  定义验证码

	$(function() {
		createCode();
	});

	function createCode() {
		code = "";
		var codeLength = 4;//验证码的长度
		var checkCodeNode = document.getElementById("checkCode");
		checkCodeNode.value = "";
		var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c',
				'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 60);
			code += selectChar[charIndex];
		}
		if (code.length != codeLength) {
			createCode();
		}
		checkCodeNode.value = code;
	}

	function checkCodeInfo() {
		checkCodes = true;
		$('#codeResultOut').hide();
		var inputCode = document.getElementById("input1").value.toUpperCase();
		var codeToUpperCase = code.toUpperCase();
		if (inputCode.length <= 0) {
			checkCodes = false;
			$('#codeResultOut').show();
			$("#codeResult").html("请输入验证码...").css("color", "#F00");
		} else if (inputCode != codeToUpperCase) {
			checkCodes = false;
			createCode();
			$('#codeResultOut').show();
			$("#codeResult").html("验证码输入错误...").css("color", "#F00");
			$("#input1").val("");
		} else {
			$('#codeResultOut').show();
			$("#codeResult").html("验证码输入正确...").css("color", "#0F0");
		}
	}

	//密码查重 
	function checkpwdagain() {
		checkPwd = true;
		$('#checkPwdOut').hide();
		var newPwd = $("#upwd").val();
		var newPwdagain = $("#upwdagain").val();
		if (newPwd == newPwdagain && newPwd != "" && newPwd != null) {
			$('#checkPwdOut').show();
			$("#checkPwd").html("密码重复确认正确...").css("color", "#0F0");
		} else {
			$('#checkPwdOut').show();
			$("#checkPwd").html("密码不一致请重新输入...").css("color", "#F00");
			$("#upwdagain").val("");
			checkPwd = false;
		}
	}
	
	function checkUsname() {
		checkUname = true;
		$('#nameResultOut').hide();
		var uname = $("#usname").val();
		var usid = $("#usids").text()
		$.post("back/checkUname", {
			uname : uname
		}, function(data) {
			if (usid == data) {
				return;
			}
			if (data > 0) {
				checkUname = false;
				$('#nameResultOut').show();
				$('#nameResult').text("该用户名已被注册...").css("color", "#F00");
				$("#usname").val("");
			}
		});
	}

	

	function onSelect(date) {
		checkBirthday = true;
		$('#birthdayResultOut').hide();
		if (date > new Date()) {
			$('#birthdayResultOut').show();
			$('#birthday').datebox('setValue', '');
			$('#birthdayResult').text('出生日期不能大于今天');
			checkBirthday = false;
		} else {
			$('#birthdayResultOut').hide();
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate()
			$('#birthdayResult').text('您选择的日期为：' + myformatter(date));
		}
	}

	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}

	function checkuemail() {
		checkEmail = true;
		$('#uemailResultOut').hide();
		var uemail = $("#uemail").val();
		var usid = $("#usids").text()
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (uemail.match(reg)) {
			$.post("back/checkUemail", {
				uemail : uemail
			}, function(data) {
				if (usid == data) {
					return;
				}
				if (data > 0) {
					checkEmail = false;
					$('#uemailResultOut').show();
					$('#uemailResult').text("该邮箱已被注册...").css("color", "#F00");
					$("#uemail").val("");
				}
			});
		} else {
			checkEmail = false;
			$('#uemailResultOut').show();
			$('#uemailResult').text("邮箱格式不正确...").css("color", "#F00");
			$("#uemail").val("");
		}
	}
	
	function updateAdminInfo() {
		if (checkPwd && checkBirthday && checkEmail && checkCode && checkUname) {
			var newPwd = $("#upwd").val();
			if (newPwd != null && newPwd != "") {
				$.post("back/updateAdminInfo", {
					usid : $("#usids").text(),
					usname : $("#usname").val(),
					usex : $("#usex").val(),
					upwd : newPwd,
					uemail : $("#uemail").val(),
					tel : $("#tel").val(),
					area : $("#area").val(),
					birthday : $('#birthday').datebox('getValue')
				}, function(data) {
					if (data > 0) {
						$("#input1").val("");
						$.messager.show({
							title : '成功提示',
							msg : '用户信息修改成功',
							timeout : 5000,
							showType : 'slide'
						});
					} else {
						$.messager.alert('错误提示', '用户信息修改失败。。。\n' + e, 'error');
					}
				});
			} else {
				$.post("back/updateAdminInfoWithoutUpwd", {
					usid : $("#usids").text(),
					usname : $("#usname").val(),
					usex : $("#usex").val(),
					uemail : $("#uemail").val(),
					tel : $("#tel").val(),
					area : $("#area").val(),
					birthday : $('#birthday').datebox('getValue')
				}, function(data) {
					if (data > 0) {
						$("#input1").val("");
						$.messager.show({
							title : '成功提示',
							msg : '用户信息修改成功',
							timeout : 5000,
							showType : 'slide'
						});
					} else {
						$.messager.alert('错误提示', '用户信息修改失败。。。\n', 'error');
					}
				});
			}
		} else {
			$.messager.alert('错误提示', '请填写正确修改信息再提交...\n', 'error');
		}
	}
</script>