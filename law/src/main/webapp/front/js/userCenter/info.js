//个人中心的js
var checkUname = true;
var checkTel = true;
var checkNowPwd = true;
var checkConfirmPwd = true;
$(function() {
	var roleId=$("#role_id").val();
	$.post("findRoleName", {
		roleId:roleId
	}, function(data) {
		$("#role_name").html(data);
	});
	
	$(".list-group-item a").bind("click", function() {
		var str = this.innerText;
		if (str.trim() == "基础信息") {
			$("#baseinfo")[0].style.display = "block";
			$("#touxiang")[0].style.display = "none";
			$("#update")[0].style.display = "none";
		} else if (str.trim() == "头像设置") {
			$("#touxiang")[0].style.display = "block";
			$("#baseinfo")[0].style.display = "none";
			$("#update")[0].style.display = "none";
		} else if (str.trim() == "安全设置") {
			$("#update")[0].style.display = "block";
			$("#baseinfo")[0].style.display = "none";
			$("#touxiang")[0].style.display = "none";
		}
	});
});

function checkUsname() {
	checkUname = true;
	$('#usnameResult').hide();
	var uname = $("#usname").val();
	var usid = $("#usid").val();
	$.post("checkUname", {
		uname : uname
	}, function(data) {
		if (usid == data) {
			return;
		}
		if (data > 0) {
			checkUname = false;
			$('#usnameResult').show();
			$('#usnameResult').text("该用户名已被注册...").css("color", "#F00");
			$("#usname").val("");
		}
	});
}

function checkTelInfo(){
	checkTel = true;
	$('#telResult').hide();
	var tel=$("#tel").val();
	var usid = $("#usid").val();
	$.post("checkTel", {
		tel : tel
	}, function(data) {
		if (usid == data) {
			return;
		}
		if (data > 0) {
			checkUname = false;
			$('#telResult').show();
			$('#telResult').text("该电话号码已被注册...").css("color", "#F00");
			$("#tel").val("");
		}
	});
}

function saveBaseInfo(){
	var tel=$("#tel").val();
	var usid = $("#usid").val();
	var uname = $("#usname").val();
	var usex= $("input[type=radio]:checked").val();
	if(checkUname && checkTel){
		$.post("updateBaseInfo", {
			tel : tel,
			usid : usid,
			uname : uname,
			usex : usex
		}, function(data) {
			if (data > 0) {
				$('#updateBaseInfoResult').show();
				$('#updateBaseInfoResult').text("更新成功...").css("color", "#0F0");
			}else{
				alert("对不起，更新失败，请重新再试...");
			}
		});
	}else{
		alert("对不起，请完善你的信息再提交...");
	}
}

function checkNowPwdInfo(){
	checkNowPwd=true;
	var nowPwd=$("#form_currentPassword").val();
	var usid = $("#usid").val();
	$.post("checkNowPwd",{nowPwd:nowPwd,usid:usid},function(data){
		if(data>0){
			$('#checkNowPwdResult').show();
			$('#checkNowPwdResult').text("当前密码输入正确...").css("color", "#0F0");
		}else{
			checkNowPwd=false;
			$('#checkNowPwdResult').show();
			$('#checkNowPwdResult').text("当前密码输入错误...").css("color", "#F00");
		}
	});
}

function checkConfirmPwdInfo(){
	checkConfirmPwd=true;
	var newPwd=$("#form_newPassword").val();
	var confirmNewPwd=$("#form_confirmPassword").val();
	if (newPwd == confirmNewPwd && newPwd != "" && newPwd != null) {
		$('#checkConfirmPwdResult').show();
		$("#checkConfirmPwdResult").text("密码重复确认正确...").css("color", "#0F0");
	} else {
		$('#checkConfirmPwdResult').show();
		$("#checkConfirmPwdResult").text("密码不一致请重新输入...").css("color", "#F00");
		$("#checkConfirmPwdResult").val("");
		checkConfirmPwd = false;
	}
}

function updatePwd(){
	var newPwd=$("#form_newPassword").val();
	var usid = $("#usid").val();
	var nowPwd=$("#form_currentPassword").val();
	var confirmNewPwd=$("#form_confirmPassword").val();
	if(nowPwd == null || nowPwd==''){
		alert("请填写当前密码");
		return;
	}else if(newPwd == null || newPwd == ''){
		alert("请填写新密码");
		return;
	}else if(confirmNewPwd == null || confirmNewPwd == ''){
		alert("请重复新密码");
		return;
	}
	if(checkNowPwd && checkConfirmPwd){
		$.post("updatePwd",{newPwd:newPwd,usid:usid},function(data){
			if(data>0){
				$('#updatePwdResult').show();
				$('#updatePwdResult').text("更新成功...").css("color", "#0F0");
				$('#form_currentPassword').val('');
				$('#form_newPassword').val('');
				$('#form_confirmPassword').val('');
				$('#checkConfirmPwdResult').hide();
				$('#checkNowPwdResult').hide();
			}else{
				alert("对不起，更新失败，请重新再试...");
			}
		})
	}else{
		alert("对不起，请完善你的信息再提交...");
	}
}






