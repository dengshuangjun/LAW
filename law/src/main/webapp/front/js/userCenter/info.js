//个人中心的js
var checkUname = true;
var checkTel = true;
var checkNowPwd = true;
var checkConfirmPwd = true;
var checkEmail = true;
var checkCode=true;
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
			$("#mail")[0].style.display = "none";
		} else if (str.trim() == "头像设置") {
			$("#touxiang")[0].style.display = "block";
			$("#baseinfo")[0].style.display = "none";
			$("#update")[0].style.display = "none";
			$("#mail")[0].style.display = "none";
		} else if (str.trim() == "安全设置") {
			$("#update")[0].style.display = "block";
			$("#baseinfo")[0].style.display = "none";
			$("#touxiang")[0].style.display = "none";
			$("#mail")[0].style.display = "none";
		}  else if (str.trim() == "邮箱设置") {
			$("#mail")[0].style.display = "block";
			$("#update")[0].style.display = "none";
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

function preImg(sourceId) {  
	if (typeof FileReader === 'undefined') {  
		alert('对不起，您的浏览器不适合文件上传，请更换浏览器再试...');  
		return;  
	}  
	var reader = new FileReader();  

	reader.onload = function(e) {  
		var img = document.getElementById("imgPrc");  
		img.src = this.result;  
	}  
	reader.readAsDataURL(document.getElementById(sourceId).files[0]);  
} 

function dropPicInfo(){
	var str='<img id="imgPrc" src="images/avatar.png" style="width:200px;height:180px;">';
	var str2='<input type="file" accept="image/*" class="webuploader-element-invisible" name="file" id="unload" style="border: none;"onchange="preImg(this.id);">';
	$('#showimg').html('').append($(str));
	$('#updateImg').html('').append($(str2));
}

function savePicInfo(){
	var usid = $("#usid").val();
	$.ajaxFileUpload({
		url:"updatePic",//发送的处理类地址
		secureuri:false,
		fileElementId:"imageFile",//图片文件的id
		dataType:"json",//数据类型
		data:{
			usid:usid
		},//发送的json数据
		success:function(data){//成功的回调函数
			if(data==1){
				alert("头像更新成功...");
			}else if(data==2){
				alert('添加头像失败，请重新再试...');
			}else if(data==3){
				alert('添加头像失败，请重新再试...');
			}
		},
		error:function(data){//失败的回调函数
			alert('添加头像失败，请重新再试...');
		}
	});
}

function checkNewEmail(){
	checkEmail = true;
	$('#checkEmail').hide();
	var uemail = $("#newEmail").val();
	var usid = $("#usids").text();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if (uemail!=null && uemail!='' && uemail.match(reg)) {
		$.post("checkNewEmail", {
			uemail : uemail
		}, function(data) {
			if (usid == data) {
				return;
			}
			if (data > 0) {
				checkEmail = false;
				$('#checkEmail').show();
				$('#checkEmail').text("该邮箱已被注册...").css("color", "#F00");
				$("#newEmail").val("");
			}
		});
	} else {
		checkEmail = false;
		$('#checkEmail').show();
		$('#checkEmail').text("邮箱格式不正确...").css("color", "#F00");
		$("#newEmail").val("");
	}
}

$("#checkNewCode").removeAttr("disabled");//启用按钮
var InterValObj; //timer变量，控制时间
var count = 120; //间隔函数，1秒执行
var curCount;//当前剩余秒数
function getCode(){
	var uemail = $("#newEmail").val();
	if(uemail==null || uemail==''){
		alert("请填写您要修改的邮箱信息...");
		return;
	}else{
		if(checkEmail){
			curCount=count;
			$("#checkNewCode").attr("disabled", "true");//点击获取验证码之后使按钮不启用
			$.post("SendUpdateEmailCode",{uemail:uemail},function(data){
				if(data>0){
					$("#showTime").val(curCount + "s");
					InterValObj = window.setInterval(SetRemainTime, 1000);
				}else{
					alert("邮件验证失败，请重新再试...");
				}
			});
		}else{
			alert("邮件格式不正确，请重新再试...");
		}
	}
}

function SetRemainTime(){
	if (curCount == 0) {                
		window.clearInterval(InterValObj);//停止计时器
		$("#checkNewCode").removeAttr("disabled");//启用按钮
		$.post("moveEmailCode",function(data){
			if(data>0){
				checkCode=false;
				$("#showTime").html("验证码超时...").css("color", "#F00");
				$("#checkNewCode").val("重新发送验证码");
			}
		});
	}else {
		curCount--;
		$("#checkNewCode").val(curCount + "s");
	}
}

function StopRemainTime(){
	window.clearInterval(InterValObj);//停止计时器
	$("#checkNewCode").removeAttr("disabled");//启用按钮
	$.post("moveEmailCode",function(data){
		if(data>0){
			checkCode=false;
			$("#checkNewCode").val("获取验证码");
		}
	});
}

function checkCodeInfo(){
	var code=$.trim($("#newCode").val());//获取到验证码
	var reg = /^([a-zA-Z0-9_-])/;
	if(code.match(reg)){
		checkCode=true;
	}else{
		checkCode=false;
		$("#checkNewCode").html("验证码格式不正确").css("color", "#F00");
		$("#newCode").val("");
	}
}


function updateNewEmail(){
	var uemail = $("#newEmail").val();
	var usid = $("#currentUser").val();
	var code = $.trim($("#newCode").val());;
	if(checkCode){
		alert(uemail);
		alert(usid);
		alert(code);
		$.post("updateNewEmail",{uemail:uemail,usid:usid,code:code},function(data){
			if(data==0){
				alert("验证码输入错误，请重新再试...");
			}else if(data==1){
				StopRemainTime();
				$('#updateNewEmailResult').text("更新邮箱成功").css("color", "#0F0");
				$('#updateNewEmailResult').show();
				$('#currentEmail').html(uemail);
				$("#newCode").val("");
			}else if(data==2){
				alert("更新错误，请重新再试...");
			}else{
				alert("更新错误，请重新再试...");
			}
		})
	}
}




