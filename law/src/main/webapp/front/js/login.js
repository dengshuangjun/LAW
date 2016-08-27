var checkuname;
var checkpwd;
var checkEmail;
var checkCode;
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


//用户登录
function showlogin(){
	$("#smallpage #uname").val("");
	$("#smallpage #pwd").val("");
	$("#unamep").html("请输入昵称或邮箱").css("color","#CC6666");
	$("#pwdp").html("请输入您的密码").css("color","#CC6666");
	$("#zcpages").hide();
	$("#loginpages").mywin({left:"center",top:"center"});
	$("#uname").select();
	$(".bg").fadeIn("3000","linear");
}

//登陆框隐藏
function hidenloginpage() {
    var text = $("#loginpages").val();
    $("#loginpages").hide();
    $(".bg").hide();
}

//注册显示
function showzc(){
	$("#uname").val("");
	$("#zcpwd").val("");
	$("#zcpwdagain").val("");
	$("#zcemail").val("");
	$("#zccode").val("");
	
	$("#unamep").html("请输入您的昵称或注册邮箱(至少6位)").css("color","#CC6666");
	$("#zcpwdp").html("请输入您的登录密码(至少6位)").css("color","#CC6666");
	$("#zcpwdtwop").html("请重复输入您的登录密码(至少6位)").css("color","#CC6666");
	$("#zcemailp").html("请输入您的邮箱地址").css("color","#CC6666");
	$("#zccodep").html("请输入验证码").css("color","#CC6666");
	$("#loginpages").hide();
	$("#zcpages").mywin({left:"center",top:"center"});$("#player5").hide();$("#setswfembed").hide();
	$(".bg").fadeIn("3000","linear");
	$("#uname").select();
}


//注册框隐藏
function hidenzcpage() {
    var text = $("#zcpages").val();
    $("#zcpages").hide();
    $(".bg").hide();
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
function checkuname() {
    var uname = $("#uname").val();
    var reg = /^([a-zA-Z0-9\u4E00-\u9FA5_-]{2,12})/;
    if (uname.match(reg)) {
    	
        $.post("../UserServlet", {
            op: "checkuname",
            uname: uname
        },
        function(data) {
            if (parseInt(data) <= 0) {
            	checkuname=true;
                $("#unamep").html("该名称可以使用...").css("color", "#0F0");
            } else {
            	checkuname=false;
                $("#checkname").html("用户名已经存在...").css("color", "#F00");
            }
        });
    } else {
        $("#uname").val("");
        $("#checkname").html("用户名格式不正确...").css("color", "#F00");
    }
}

//验证注册密码
function checkzcpwd() {
    var pwd = $("#zcpwd").val();
    var reg = /^([a-zA-Z0-9_-]{6,20})/;
    if (pwd.match(reg)) {
        $("#zcpwdp").html("可以使用该密码...").css("color", "#0F0");
    } else {
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
        $.post("../adminServlet", {
            op: "checkemail",
            zcemail: zcemail
        },
        function(data) {
            if (parseInt(data) <= 0) {
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
        $("#zcemailp").html("邮箱格式不正确...").css("color", "#F00");
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
	    $("#zccodep").html("验证码格式不正确").css("color", "#F00");
	    $("#zccode").val("");
	}
}
//重新获取验证码
function changeVilidateCode(obj){
	var timenow=new Date().getTime();
	obj.src="front/pages/valiCodeImg.jsp?d="+timenow;
}

$.fn.mywin=function(position){
	if (position&&position instanceof Object){
		var positionleft=position.left;
		var positiontop=position.top;

		var currentwin=this;
		var mywidth =currentwin.outerWidth(true);
		var myheight = currentwin.outerHeight(true);

		var left=0;
		var top=0;
		var width=0;
		var height=0;
		var scrollleft=0;
		var scrolltop=0;
	

		function getWinInfo(){
			width=$(window).width();
			height=$(window).height();
			scrollleft=$(window).scrollLeft();
			scrolltop=$(window).scrollTop();
		}

		function calleft(positionleft,scrollleft,width,mywidth){
			if(positionleft!=""&&typeof(positionleft)=="string"){
				if(positionleft=="center"){
					left=scrollleft+(width-mywidth)/2;
				}else if(positionleft=="left"){
					left=scrollleft;
				}else if (positionleft == "right"){
					left=scrollleft+width-mywidth;
				}else{
					left=scrollleft+(width-mywidth)/2;
				}
			}else if(positionleft != ""&&typeof(positionleft)=="number"){
				left=positionleft+scrollleft;
			}else{
				left=0;
			}
			
		}
		
		function caltop(positiontop,scrolltop,height,myheight){
			if(positiontop!=""&&typeof(positiontop)=="string"){
				if(positiontop=="center"){
					top=scrolltop+(height-myheight)/2;
				}else if(positiontop == "top"){
					top=scrolltop;
				}else if(positiontop=="bottom"){
					top = scrolltop+height-myheight;
				}else{
					top=scrolltop+(height-myheight)/2;
				}
			}else if(positiontop!=""&&typeof(positiontop)=="number"){
				top=positiontop+scrolltop;
			}else{
				top=0;
			}
		}

		getWinInfo();
		calleft(positionleft, scrollleft,width,mywidth);
		caltop(positiontop,scrolltop,height,myheight);

		$(window).scroll(function(){
			getWinInfo();
			calleft(positionleft,scrollleft,width,mywidth);
			caltop(positiontop,scrolltop,height,myheight);
			currentwin.css("left",left).css("top",top);
		});

		$(window).resize(function(){
			getWinInfo();
			calleft(positionleft, scrollleft, width, mywidth);
			caltop(positiontop, scrolltop, height, myheight);
			currentwin.animate({left : left,top : top}, 300);
		});
		
		currentwin.css("left",left).css("top", top).fadeIn("slow");
	}
	return this;
}
//创建请求对象
var xmlHttp;
function createXMLHttpRequest(){
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}

//用户登陆
function userlogin(){
	createXMLHttpRequest();
	var uname=$.trim($("#uname").val());
	var pwd=$.trim($("#pwd").val());

		xmlHttp.onreadystatechange=login;
		xmlHttp.open("POST", "../adminServlet?op=userLogin&username="+encodeURI(encodeURI(uname))+"&pwd="+pwd, true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send(null);
	
	
}
//登陆的回调函数
function login(){
	if(xmlHttp.readyState==4){//响应完成
			if(xmlHttp.status==200){//服务器正常
				var data=xmlHttp.responseText;
				if(data!=0){
					$("#bg").css("display","none");
					$("#loginpages").css("display","none");
					$("#top_login_right").html("欢迎您:"+data+"&nbsp;&nbsp;<a href='javascript:zhuxiao()'><font color='#FF0000' size='2'>注销</font></a>");
				}else if(data==0){
					$("#bg").css("display","none");
					$("#loginpages").css("display","none");
					$.messager.alert('警告','用户名或密码错误','error');
				}
			}
	}
}
//用户注册
function userzc(){
	createXMLHttpRequest();
	var uname=$.trim($("#uname").val());
	var zcpwd=$.trim($("#zcpwd").val());
	var zcemail=$.trim($("#zcemail").val());
	var zccode=$.trim($("#zccode").val());
	if(checkuname&&checkpwd&&checkEmail&&checkCode){
		xmlHttp.onreadystatechange=zcUser;
		xmlHttp.open("POST", "../adminServlet?op=zcUser&uname="+encodeURI(encodeURI(uname))+"&zcpwd="+zcpwd+"&zcemail="+zcemail+"&zccode="+zccode, true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send(null);
	}else{
		$("#bg").css("display","none");
		$("#zcpages").css("display","none");
		$.messager.confirm('警告', '请完善注册信息', function(r){
			if (r){
				$("#bg").css("display","block");
				$("#zcpages").css("display","block");
			}
		});
		
	}
	
}
//用户注册的回调函数
function zcUser(){
	if(xmlHttp.readyState==4){//响应完成
		if(xmlHttp.status==200){//服务器正常
			var data=xmlHttp.responseText;
			if(data>0){
				$("#bg").css("display","none");
				$("#zcpages").css("display","none");
				$.messager.confirm('注册成功', '恭喜您，注册成功！！！', function(r){
					if (r){
						location.href="../front/index.jsp";
					}
				});
			}else if(data==-2){
				$("#bg").css("display","none");
				$("#zcpages").css("display","none");
				$.messager.alert('错误提示','注册失败,验证码错误。。。');  
			}else{
				$("#bg").css("display","none");
				$("#zcpages").css("display","none");
				$.messager.alert('错误提示','注册失败,具体原因请咨询管理员。。。');  
			}
		}
	}
}
//邮箱发送注册码
$("#btnSendCode").removeAttr("disabled");//启用按钮
var InterValObj; //timer变量，控制时间
var count = 60; //间隔函数，1秒执行
var curCount;//当前剩余秒数
function getCode(){
		 var zcemail=$("#zcemail").val();
		 if(checkEmail){
			 curCount=count;
		     $("#btnSendCode").attr("disabled", "true");
		     $("#btnSendCode").val(curCount + "s");
		     $.post("../SendEmailCode",{op:"btnSendCode",zcemail:zcemail},function(data){
		    	 if(data>0){
		    	     InterValObj = window.setInterval(SetRemainTime, 1000);
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
        $("#btnSendCode").removeAttr("disabled");//启用按钮
        $.post("../SendEmailCode",{op:"moveCode"},function(data){
	    	 if(data>0){
	    		 $("#btnSendCode").val("重新发送验证码");
	    	 }
	     });
    }else {
        curCount--;
        $("#btnSendCode").val(curCount + "s");
    }
}
function zhuxiao(){
	$.post("../UserServlet",{op:"zhuxiao"},function(data){
		if(data>0){
			location.href="../index.html";
		}
	});
}
