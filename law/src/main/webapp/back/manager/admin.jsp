<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#out {
	width: 600px;
	height: 300px;
	position: absolute;
	left: 45%;
	top: 48%;
	margin-left: -200px;
	margin-top: -200px;
	border: 1px;
	align: center;
}

#updateInfo {
	width: 300px;
	height: 150px;
	position: relative;
	left: 50%;
	top: 40%;
	margin-left: -150px;
	margin-top: -30px;
}

#updateInfo table tr {
	height: 30px;
}
</style>

<div
	style="padding: 3px 2px; border-bottom: 1px solid #ccc; text-align: center;">修改个人信息</div>
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
					value="${user.usname}"></input></td>
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
				<td>用户密码</td>
				<td><input id="upwd" name="upwd" type="password"
					value="${user.upwd}"></td>
			</tr>
			<tr>
				<td>用户邮箱</td>
				<td><input id="uemail" name="uemail" type="email"
					value="${user.uemail}"></td>
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
					class="easyui-datebox" value="${user.birthday}" /></td>
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

<script>
	function updateAdminInfo(){
		 $.post("back/updateAdminInfo",
				{usid:$("#usids").text(),usname:$("#usname").val(),
				usex:$("#usex").val(),upwd:$("#upwd").val(),
				uemail:$("#uemail").val(),tel:$("#tel").val(),
				area:$("#area").val(),birthday:$('#birthday').datebox('getValue')}
		 		,function(data){
		 			if(data>0){
		 				alert("恭喜你，信息修改成功...");
		 			}else{
		 				alert("不好意思，信息修改失败，请重新再试...");
		 			}
		 		}); 
	}
</script>