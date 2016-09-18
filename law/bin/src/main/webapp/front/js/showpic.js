function previewMultipleImage(file,id) {
	var MAXWIDTH = 100;
	var MAXHEIGHT = 100;
	var div = document.getElementById(id);
	div.innerHTML="";
	if($('#textfield').val()=="" ||file.files.length==0){
		$("#phototals").html("");
	}
	if (file.files && file.files[0]) {
		if(file.files.length>2){
			alert("上传图片不得多于2张...");
			$("#phototals").html("");
			$('#textfield').val("");
			$("#smallpic").html("");
			$("#upfile").val("");
			return;
		}
		
		for(var i=0;i<file.files.length;i++){
			var reader = new FileReader();
			reader.onload = function(evt) {
				div.innerHTML+='<img  id="img"'+i+' src='+ evt.target.result
				+' style="margin:10px 0px 0px 10px;"  width="'+MAXWIDTH+'" height="'+MAXHEIGHT+'"  />';	
			};
			reader.readAsDataURL(file.files[i]);
		}
		$("#div_h4").css("display","none");
		$("#phototals").html("共"+file.files.length+"张图片");
		
		$("#smallpic").css("overflow","scroll");
	} else {
		// 运用IE滤镜获取数据;
		var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
		file.select();// /选定程序
		var src = document.selection.createRange().text;
		div.innerHTML = '<img id=imghead>';
		var img = document.getElementById('imghead');
		img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
		var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
				img.offsetHeight);
		//状态值
		status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
		div.innerHTML = "<div id=divhead style='width:" + rect.width
				+ "px;height:" + rect.height + "px;margin-top:" + rect.top
				+ "px;margin-left:" + rect.left + "px;" + sFilter + src
				+ "\"'></div>";
	
	}
}




//验证新密码格式
var checknewpwd;
function checkzcpwd() {
	if($("#OldUpwd").val()==null){
		alert("请先输入旧密码");
	}
    var pwd = $("#NewUpwd").val();
    var reg = /^([a-zA-Z0-9_-]{6,20})/;
    if (pwd.match(reg)) {
    	checknewpwd=true;
        $("#NewMsg").html("可以使用该密码...").css("color", "#0F0");
    } else {
        $("#NewUpwd").val("");
        $("#NewMsg").html("密码不合格...").css("color", "#F00");
    }
}

var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
+ "wxyz0123456789+/" + "=";		
function encode64(input) {
var output = "";
var chr1, chr2, chr3 = "";
var enc1, enc2, enc3, enc4 = "";
var i = 0;
do {
	chr1 = input.charCodeAt(i++);
	chr2 = input.charCodeAt(i++);
	chr3 = input.charCodeAt(i++);
	enc1 = chr1 >> 2;
	enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
	enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
	enc4 = chr3 & 63;
	if (isNaN(chr2)) {
		enc3 = enc4 = 64;
	} else if (isNaN(chr3)) {
		enc4 = 64;
	}
	output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
			+ keyStr.charAt(enc3) + keyStr.charAt(enc4);
	chr1 = chr2 = chr3 = "";
	enc1 = enc2 = enc3 = enc4 = "";
} while (i < input.length);

return output;
}

var checkpwd;
//验证旧密码是否正确
function checkpwd(upwd){
	var pwd=encode64($("#OldUpwd").val().trim());
	if(pwd==upwd){
		 checkpwd=true;
		 $("#OldMsg").html("密码正确...").css("color", "#0F0");
	}else{
		 $("#OldUpwd").val("");
	     $("#OldMsg").html("密码不正确...").css("color", "#F00");
	}
}

var checkuname;
function checkuname() {
	var usname = $("#uname").val();
	var reg = /^([a-zA-Z0-9\u4E00-\u9FA5_-]{2,12})/;
	if (usname.match(reg)) {
	    $.post("../../userServlet", {
	        op: "checkUsname",
	        usname: usname
	    },
	    function(data) {
	        if (parseInt(data) > 0) {
	        	checkuname=true;
	            $("#checkname").html("该名称可以使用...").css("color", "#0F0");
	        } else {
	            $("#checkname").html("用户名已经存在...").css("color", "#F00");
	        }
	    });
	} else {
	    $("#uname").val("");
	    $("#checkname").html("用户名格式不正确...").css("color", "#F00");
	} 
}


//验证手机
var checktel;
function checkTel() {
    var pwd = $("#NewTel").val();
    var reg = /^([Z0-9_]{11})/;
    if (pwd.match(reg)) {
    	checktel=true;
        $("#TelMsg").html("可以使用该号码...").css("color", "#0F0");
    } else {
        $("#NewTel").val("");
        $("#TelMsg").html("号码不合格...").css("color", "#F00");
    }
}

function save(usid){
	var uname=$.trim($("#uname").val());
	var upwd=encode64($.trim($("#NewUpwd").val()));
	var tel=$.trim($("#NewTel").val());
	
	if(checknewpwd&&checkpwd&&checkuname&&checktel){
		$.ajaxFileUpload({
			url:"../../userServlet?op=updateUser",
			secureuri:false,
			fileElementId:"user_pic",
			dataType:"json",
			data:{uname:uname,upwd:upwd,tel:tel,usid:usid},
			success:function(data,status){
				if(data>0){
					location.href="../load.html";
					$("#NewTel").val("");
				}else{
					alert("信息修改失败");
				}
			},
			error:function(data,status,e){
				alert("信息修改失败"+e,"error");
			}
		});
	}else{
		alert("请确认所有信息已正确填写");
	}
	
}