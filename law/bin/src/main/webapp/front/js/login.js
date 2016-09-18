var checkuname=false;
var checkpwd=false;
var checkEmail=false;
var checkCode=false;
//设为首页
function SetHome(obj,url){
	try{
		obj.style.behavior='url(#default#homepage)';
		obj.setHomePage(url);
	}catch(e){
		if(window.netscape){
			try{
				netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			}catch(e){
				alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入about:config并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
			}
		}else{
			alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+url+"】设置为首页。");
		}
	}
}

//点击收藏
function AddFavorite(title,url){
	try{
		window.external.addFavorite(url,title);
	}catch(e){
		try{window.sidebar.addPanel(title,url,"");
		}catch(e){
			alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
		}
	}
}




//登陆用户名验证
function checkloginuname() {
    var uname = $("#uname").val();
    if ("" == uname || uname == null) {
        $("#unamep").html("用户名不能为空...").css("color", "#F00");
    } else {
        $("#unamep").html("用户名格式正确...").css("color", "#0F0");
    }
}

//登陆密码验证
function checkloginpwd() {
    var pwd = $("#pwd").val();
    if ("" == pwd || pwd == null) {
        $("#pwdp").html("您的密码不能为空...").css("color", "#F00");
    } else {
        $("#pwdp").html("密码格式正确...").css("color", "#0F0");
    }
}

//验证注册用户名
function checkzcuname() {
    var uname = $("#zcuname").val();
    var reg = /^([a-zA-Z0-9\u4E00-\u9FA5_-]{2,12})/;
    if (uname.match(reg)) {
    	
        $.post("/law/front/usnameCheck", {
            uname:uname
        },
        function(data) {
            if (data.result <= 0) {
            	checkuname=true;
                $("#checkname").html("该名称可以使用...").css("color", "#0F0");
            } else {
            	checkuname=false;
                $("#checkname").html("用户名已经存在...").css("color", "#F00");
            }
        },"json");
    } else {
    	checkuname=false;
        $("#uname").val("");
        $("#checkname").html("用户名格式不正确...").css("color", "#F00");
    }
}

//验证注册密码
function checkzcpwd() {
    var pwd = $("#zcpwd").val();
    var reg = /^([a-zA-Z0-9_-]{6,20})/;
    if (pwd.match(reg)) {
    	checkpwd=true;
        $("#zcpwdp").html("可以使用该密码...").css("color", "#0F0");
    } else {
    	checkpwd=false;
        $("#zcpwd").val("");
        $("#zcpwdp").html("密码不合格...").css("color", "#F00");
    }
}

//验证重复密码

function checkzcpwdagain() {
    var pwdagain = $("#zcpwdagain").val();
    var pwd = $("#zcpwd").val();
    if (pwdagain == pwd && pwd != "" && pwd != null) {
    	checkpwd=true;
        $("#zcpwdtwop").html("密码重复确认正确...").css("color", "#0F0");
    } else {
        $("#zcpwdtwop").html("密码不一致请重新输入...").css("color", "#F00");
        $("#zcpwdagain").val("");
        checkpwd=false;
    }
}

//验证邮箱

function checkzcemail() {
    var zcemail = $("#zcemail").val();
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    if (zcemail.match(reg)) {
        $.post("/law/front/checkEmail", {
            zcemail: zcemail
        },
        function(data) {
            if (data.result <= 0) {
            	checkEmail=true;
                $("#zcemailp").html("该邮箱可以使用...").css("color", "#0F0");
            } else {
            	checkEmail=false;
                $("#zcemailp").html("该邮箱已被注册...").css("color", "#F00");
                $("#zcemail").val("");
            }
        });
    } else {
    	checkEmail=false;
        $("#zcemailp").html("邮箱格式不合法...").css("color", "#F00");
        $("#zcemail").val("");
    }
}
//验证码验证
function checkzccode(){
	var zccode=$.trim($("#zccode").val());//获取到验证码
	var reg = /^([a-zA-Z0-9_-])/;
	if(zccode.match(reg)){
		checkCode=true;
		 $("#zccodep").html("验证码格式正确").css("color", "#0F0");
	}else{
		checkCode=false;
	    $("#zccodep").html("验证码格式不正确").css("color", "#F00");
	    $("#zccode").val("");
	}
}

//邮箱发送注册码
$("#check").removeAttr("disabled");//启用按钮
var InterValObj; //timer变量，控制时间
var count = 120; //间隔函数，1秒执行
var curCount;//当前剩余秒数
function getCode(){
		 var zcemail=$("#zcemail").val();
		 if(checkEmail){
			 curCount=count;
		     $.post("/law/front/SendEmailCode",{zcemail:zcemail},function(data){
		    	 if(data>0){
		    		 $("#check").attr("disabled", "true");
				     $("#check").val(curCount + "s");
		    	     InterValObj = window.setInterval(SetRemainTime, 1000);
		    	 }else{
		    		 $("#bg").css("display","none");
					 $("#zcpages").css("display","none");
					 $.messager.alert('错误提示','发送失败...','info',function(){
						 $("#bg").css("display","block");
						 $("#zcpages").css("display","block");
					 });
		    	 }
		     });
		 }else{
			 $("#bg").css("display","none");
			 $("#zcpages").css("display","none");
			 $.messager.alert('错误提示','您输入的邮箱不合法','info',function(){
				 $("#bg").css("display","block");
				 $("#zcpages").css("display","block");
			 });
		 }
}
function SetRemainTime(){
	if (curCount == 0) {                
        window.clearInterval(InterValObj);//停止计时器
        $("#check").removeAttr("disabled");//启用按钮
        $.post("/law/front/moveEmailCode",function(data){
	    	 if(data>0){
	    		 checkCode=false;
	    		 $("#zccodep").html("验证码超时...").css("color", "#F00");
	    		 $("#check").val("重新发送验证码");
	    	 }
	     });
    }else {
        curCount--;
        $("#check").val(curCount + "s");
    }
}
function zhuxiao(){
	$.post("../UserServlet",{op:"zhuxiao"},function(data){
		if(data>0){
			location.href="../index.html";
		}
	});
}

//设为首页
//表单信息提交状态
function status(){
	if(checkuname&&checkpwd&&checkEmail&&checkCode){
		return true;
	}else{
		 $("#bg").css("display","none");
		 $("#zcpages").css("display","none");
		 $.messager.alert('错误提示','您输入的注册信息有误','info',function(){
			 $("#bg").css("display","block");
			 $("#zcpages").css("display","block");
		 });
		return false;
	}
}