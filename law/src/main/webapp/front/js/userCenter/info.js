//学习中心的js
$(function() {
	var userid = $("input[name='userid']").val();
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
			/*$.post("userinfo/selectTouxiang", {"_method" : "POST",userid :userid},function(data){
				if(data){
					var st ="";
					st = data.photo;
					if(st.indexOf("avatar") > 0 ){
						$("#imgPrc").attr('src',"images/avatar.png");
					}else{
						$("#imgPrc").attr('src',"/touxiangPic/"+data.photo);
					}
					
					
				}
			});*/
		} else if (str.trim() == "安全设置") {
			$("#update")[0].style.display = "block";
			$("#baseinfo")[0].style.display = "none";
			$("#touxiang")[0].style.display = "none";
		}
	});
	
	$('#password-save-btn4').bind("click", function(){
		var curpwd = $('#form_currentPassword').val();
		var newpwd = $('#form_newPassword').val();
		var conpwd = $('#form_confirmPassword').val();
		if(curpwd!=null&newpwd!=null&conpwd!=null){
			$.post("userinfo/editpwd", {"_method" : "POST",userid :userid,curpwd:curpwd,newpwd:newpwd,conpwd:conpwd},function(data){
				if(data==1){
					alert("当前密码输入错误!!!");
				}else if(data==2){
					alert("确认密码输入错误!!!");
				}else{
					alert("修改密码成功!!!");
					$('#form_currentPassword').val("");
					$('#form_newPassword').val("");
					$('#form_confirmPassword').val("");
				}
			});
		}
	});
	
	$('.form-control').bind("blur",function(){
		var str = $(this).val();
		if(str ==""){
			var st = $(this).next().text();
			$(this).next().css('display', 'block');
			$(this).next().css('color', 'red');
			$(this).parent().prev().css('color', '#A94442');
			$(this).css('border-color', '#F03D7B');
		}
	});
	$('.form-control').bind("focus",function(){
		var str = $(this).val();
		$(this).next().css('display', 'none');
		$(this).parent().prev().css('color', '#333333');
		$(this).css('border-color', '#E1E1E1');
	});
	
	
	$('#profile-edit-btn').bind("click", function(){
		var str='<img id="imgPrc" src="images/avatar.png" style="width:200px;height:180px;">';
		var str2='<input type="file" accept="image/*" class="webuploader-element-invisible" name="file" id="unload" style="border: none;"onchange="preImg(this.id);">';
		$('#showimg').html('').append($(str));
		$('#updateImg').html('').append($(str2));
	});
	
	
	$('#profile-save-btn3').bind("click", function(){
		var oldpwd = $('oldpwd').val();
		var newpwd = $('newold').val();
		alert("dgagih");
	});
	
	
	
});

function save(id) {
	var usign = $("#profile_signature").val();
	var introdution = $("#profile_about").val();
	var gender = $("input[name='gender']:checked").val();

	$.post("userinfo/save", {
		"_method" : "POST",
		userid : id,
		gender : gender,
		usign : usign,
		introdution : introdution
	}, function(data) {
		var str = "";
		if (data == 1) {
			str = '<div class="alert alert-success">基础信息保存成功。</div>';
			alert("修改成功!!!");
		}
		$('#info').append($(str));
	}, 'json');
}

function preImg(sourceId, targetId) {  
    if (typeof FileReader === 'undefined') {  
        alert('Your browser does not support FileReader...');  
        return;  
    }  
    var reader = new FileReader();  
  
    reader.onload = function(e) {  
        var img = document.getElementById("imgPrc");  
        img.src = this.result;  
    }  
    reader.readAsDataURL(document.getElementById(sourceId).files[0]);  
}  




