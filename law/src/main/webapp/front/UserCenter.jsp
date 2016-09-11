<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>法律智慧网</title>
<meta name="keywords"
	content="法律智慧网,法律咨询,法律咨询网,法律在线,法律知识,法律援助,律师在线,中国法律,中法网">
<meta name="description"
	content="法律智慧网是一家在线法律服务门户网站平台，律师在线解答法律咨询，为您提供一站式、便捷、高效的法律服务！">
<link rel="shortcut icon" href="images/logo_ .png">
<link rel="stylesheet" type="text/css" href="css/CssReset.css">
<link rel="stylesheet" type="text/css" id="cssLink">
<link rel="stylesheet" type="text/css" href="css/userCenter/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/userCenter/howzhi.css">
<link rel="stylesheet" type="text/css" href="css/userCenter/main.css">
<script type="text/javascript" src="js/jquery-1.9.1.js" ></script>
<script type="text/javascript" src="js/readCss.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/userCenter/top.js"></script>
<script type="text/javascript" src="js/userCenter/info.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<style type="text/css">
#profile-save-btn {
	margin-top: 20px;
	margin-left: 10px;
}

#unload {
	background: #15c288 none repeat scroll 0 0;
	border: 1px solid #15c288;
	color: #fff !important;
}

.form-group {
	margin-top: 14px;
	margin-left: 35px;
}

.sidenav .list-group .list-group-item{
	height:50px;
}

.showInfo{
	margin-top:7px;
	border:1px solid blue;
	border-radius:3px;
}

.showInfos{
	margin-left:20px;
}
</style>
</head>
<body>
	<!--S=页面-->
	<div id="top">
		<div id="top_page">
			<span>今天是<span id="nowtime"></span></span>
			<ul>
				<li>
				<c:if test="${fuser.usid!=null&&fuser.usid!=''}">
						<a>欢迎您</a>: <a>${fuser.usname }</a>|
						<button onclick="zhuxiao()">注销</button>|
				</c:if> 
				<c:if test="${fuser.usid==null||fuser.usid==''}">
						<li><a href="load.html">登录</a>| <a href="submit.html">免费注册</a>|
				</c:if> 
					<a href="UserCenter.jsp">会员中心</a>| <a href="###">收藏本站</a>| <a href="###">关于我们</a>
				</li>
			</ul>
		</div>
	</div>
	<!--E=页面-->
	<!--S=logo-->
	<div id="logo">
		<div class="img_logo fl">
			<img src="images/logo.png" />
		</div>
		<div class="form fr">
			<form action="" method="get">
				<input type="text" placeholder="请输入关键字..." name="keyword" /> <input
					type="submit" value="检索" />
			</form>
		</div>
	</div>
	<!--E=logo-->
	<!--S=导航-->
	<div id="nav">
		<div class="nav_page">
			<ul>
				<li><a href="index.jsp">首页</a></li>
				<li><a href="wave/wave.jsp">智慧电波</a>
					<ul class="ull">
						<li><a href="wave/wave.jsp">校园动态</a></li>
						<li><a href="wave/wave2.jsp">社会聚焦</a></li>
						<li><a href="wave/wave3.jsp">新闻调查</a></li>
					</ul></li>
				<li><a href="art/art.jsp">智慧艺苑</a>
					<ul class="ull">
						<li><a href="art/art.jsp">法治视频</a></li>
						<li><a href="art/art2.jsp">法治动漫</a></li>
						<li><a href="art/art3.jsp">法治摄影</a></li>
						<li><a href="art/art4.jsp">法治书画</a></li>
						<li><a href="art/art5.jsp">法治小说</a></li>
					</ul></li>
				<li><a href="school/people.jsp">智慧私塾</a>
					<ul class="ull">
						<li><a href="school/people.jsp">法治名人</a></li>
						<li><a href="school/story.jsp">法治故事</a></li>
						<li><a href="school/story2.jsp">法治典故</a></li>
						<li><a href="school/saying.jsp">法治名言</a></li>
						<li><a href="school/secret.jsp">法治灯谜</a></li>
						<li><a href="school/words.jsp">法治楹联</a></li>
					</ul></li>
				<li><a href="wisdom/wisdom.jsp">智慧讲堂</a>
					<ul class="ull">
						<li><a href="wisdom/wisdom.jsp">法律时评</a></li>
						<li><a href="wisdom/wisdom2.jsp">以案释法</a></li>
						<li><a href="wisdom/wisdom3.jsp">名人说法</a></li>
					</ul></li>
				<li><a href="assis/assis.jsp">智慧助手</a>
					<ul class="ull">
						<li><a href="assis/assis.jsp">法规检索</a></li>
						<li><a href="assis/assis2.jsp">法律e点通</a></li>
						<li><a href="assis/assis3.jsp">法理探索</a></li>
					</ul></li>
				<li><a href="tieba/tieba.jsp">法律智慧贴吧</a></li>
			</ul>
		</div>
	</div>
	
	<div class="container" id="content-container" style="min-height:200px;">
	<c:if test="${fuser.usid==0||fuser.usid==null}">
		
		<p style="margin: 40px auto; font-size: 30px;">您还没有登陆,剩余<b id="timeOut">10</b>秒钟跳转到登陆页面...如果不跳转请点击<a href="load.html" style="font-size: 30px;color: navy;">登陆</a></p>
		<script type="text/javascript">
		var time=10;
		var InterValObj;
		$(function(){
			InterValObj=window.setInterval(timeIng, 1000);
		});
		function timeIng(){
			if(time>0){
				time=time-1;
				$("#timeOut").html(time);
			}else{
		        window.clearInterval(InterValObj);//停止计时器
				location.href="load.html";
			}
		}
	</script>
	</c:if>
	<c:if test="${fuser.usid!=0&&fuser.usid!=null}">
		<div class="row">
			<div class="col-md-3">
				<div class="sidenav">
					<ul class="list-group">
						<li class="list-group-heading"  style="height:50px;font-size:20px;line-height:50px;margin-left:15px;">个人设置</li>

						<li class="list-group-item"><a href="javascript:void(0)"
							id="cc"><i class="glyphicon glyphicon-user"></i> 基础信息</a></li>
						<li class="list-group-item "><a href="javascript:void(0)"><i
								class="glyphicon glyphicon-picture"></i> 头像设置</a></li>
						<li class="list-group-item "><a href="javascript:void(0)"><i
								class="glyphicon glyphicon-lock"></i> 安全设置</a></li>
						<li class="list-group-item "><a href="javascript:void(0)"><i
								class="glyphicon glyphicon-envelope"></i> 邮箱设置</a></li>
					</ul>
				</div>
			</div>
			<!--  --------------基础信息-------------------------------------------------------------------- -->
			<div class="col-md-9" id="baseinfo" style="display: block;">
				<div id="info"></div>
				<div class="panel panel-default panel-col">
					<div class="panel-heading">基础信息</div>
					<div class="panel-body">

						<form id="user-profile-form" class="form-horizontal" method="post"
							novalidate="novalidate" data-widget-cid="widget-0" style="margin-left:300px;">
							<input id="usid" type="hidden" value="${fuser.usid}" />
							<div class="form-group">
								<label class="col-md-2 control-label">昵称</label>
								<input id="usname" class="showInfo" type="text" name="usname" value="${fuser.usname }" onblur="checkUsname()"/>
								<span id="usnameResult" style="display:none;"></span>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label">性别</label>
								<div class="col-md-7 controls radios">
									<div id="profile_gender">
										<c:choose>
											<c:when test="${fuser.usex=='男' }">
												<input type="radio" name="usex" name="gender"
													required="required" value="男" checked="checked">
												<label for="profile_gender_0" class="required">男</label>
												<input type="radio" name="usex" name="gender"
													required="required" value="女">
												<label for="profile_gender_1" class="required">女</label>
											</c:when>
											<c:otherwise>
												<input type="radio" name="usex" name="gender"
													required="required" value="男">
												<label for="profile_gender_0" class="required">男</label>
												<input type="radio" name="usex" name="gender"
													required="required" value="女" checked="checked">
												<label for="profile_gender_1" class="required">女</label>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="showInfos">本站角色</label>
								<input id="role_id" type="hidden" value="${fuser.role_id}" />
								<span id="role_name" class="showInfos"></span>
							</div>

							<div class="form-group">
								<label class="showInfos">账号状态</label>
								<c:if test="${fuser.law_user_status=='Y' }">
									<span class="showInfos">可用</span>
								</c:if>
								<c:if test="${fuser.law_user_status=='N' }">
									<span class="showInfos">不可用</span>
								</c:if>
							</div>
							
							<div class="form-group">
								<label class="showInfos">状态说明</label>
								<c:choose>
									<c:when test="${not empty fuser.law_user_status_explain }">
										<span class="showInfos">${fuser.law_user_status_explain }</span>
									</c:when>
									<c:otherwise>
										<span class="showInfos">正常使用</span>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="introdution">电话</label>
								<input id="tel" class="showInfo" type="text" name="tel" value="${fuser.tel }" onblur="checkTelInfo()"/>
								<span id="telResult" style="display:none;"></span>
							</div>
							<div class="row">
								<div class="col-md-7 col-md-offset-2">
									<button id="profile-save-btn" data-submiting-text="正在保存"
										type="button" class="btn btn-primary" onclick="saveBaseInfo()">保存</button>
									<span id="updateBaseInfoResult" style="display:none;"></span>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
			<!--  --------------基础信息-------------------------------------------------------------------- -->

			<!--  --------------更换头像-------------------------------------------------------------------- -->
			<div class="col-md-9" id="touxiang" style="display: none">
				<div class="panel panel-default panel-col">
					<div class="panel-heading">头像</div>
					<div class="panel-body">

						<form id="settings-avatar-form" class="form-horizontal"
							method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<div class="col-md-2 control-label">
									<b>当前头像</b>
								</div>
								<div class="controls col-md-8 controls" id="showimg">
									<c:choose>
										<c:when test="${not empty fuser.picpath }">
											<img id="imgPrc" src="../${fuser.picpath }"
												style="width: 200px; height: 180px;">
										</c:when>
										<c:otherwise>
											<img id="imgPrc" src="images/avatar.png"
												style="width: 200px; height: 180px;">
										</c:otherwise>
									</c:choose>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-2 control-label"></div>
								<div class="controls col-md-8 controls">
									<p class="help-block">
										你可以上传JPG、GIF或PNG格式的文件，文件大小不能超过<strong>2M</strong>。
									</p>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-2 control-label"></div>
								<div class="controls col-md-8 controls">
									<div id="updateImg">
										<input type="file" name="imageFile" id="imageFile"
											style="border: none;" onchange="preImg(this.id)">
									</div>
									<button id="profile-save-btn" data-submiting-text="正在保存"
										type="button" class="btn btn-primary" onclick="savePicInfo()">保存</button>
									<button class="btn btn-primary" type="button"
										id="profile-edit-btn"
										style="margin-top: 20px; margin-left: 10px;" onclick="dropPicInfo()">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

			<!--  --------------更改头像------------------------------------------------------------------- -->

			<!--  --------------安全设置------------------------------------------------------------------ -->
			<div class="col-md-9" id="update" style="display: none;">

				<div class="panel panel-default panel-col">
					<div class="panel-heading">安全设置</div>
					<div class="panel-body">
						<ul class="breadcrumb">
							<li><a href="http://www.howzhi.com/settings/security">安全设置</a></li>
							<li class="active">登录密码修改</li>
						</ul>
						<form data-widget-cid="widget-0" novalidate="novalidate"
							id="settings-password-form" class="form-horizontal" method="post">
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="form_currentPassword" class="required">当前密码</label>
								</div>

								<div class="controls col-md-8 controls">
									<input data-explain="" data-widget-cid="widget-1"
										id="form_currentPassword" name="upwd"
										required="required" class="form-control" type="password" onblur="checkNowPwdInfo()">
									<span id="checkNowPwdResult" style="display:none;"></span>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="form_newPassword" class="required">新密码</label>
								</div>
								<div class="controls col-md-8 controls">
									<input data-explain="" data-widget-cid="widget-2"
										id="form_newPassword" name="form[newPassword]"
										required="required" class="form-control" type="password">
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="form_confirmPassword" class="required">确认密码</label>
								</div>
								<div class="controls col-md-8 controls">
									<input data-explain="" data-widget-cid="widget-3"
										id="form_confirmPassword" name="form[confirmPassword]"
										required="required" class="form-control" type="password"  onblur="checkConfirmPwdInfo()">
									<span id="checkConfirmPwdResult" style="display:none;"></span>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-2 control-label"></div>
								<div class="controls col-md-8 controls">
									<input id="form__token" name="form[_token]"
										value="e9ebfb386adef9aa744408549e5c164aeca9f16d" type="hidden">
									<button id="password-save-btn4" data-submiting-text="正在保存"
										type="button" class="btn btn-primary" onclick="updatePwd()">提交</button>
									<span id="updatePwdResult" style="display:none;"></span>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
			<!--  --------------安全设置------------------------------------------------------------------ -->
		</div>
		</c:if>
	</div>

	<!--E=内容-->
	<!--S=友情链接-->
	<div id="link">
		<div class="contact fl">
			<h2>联系我们</h2>
			<ul>
				<li>官方微信：<br /> <i class="wechat"></i>
				</li>
				<li>客服电话：<span><i class="phone"></i>11022020</span><br />
					官方微博：<a href="###" target="_blank"><i class="weibo"></i></a><br />
					客服在线：<a href="###" target="_blank"><i class="qq"></i></a>
				</li>
			</ul>
		</div>
		<div class="navigation fl">
			<h2>服务导航</h2>
			<ul>
				<li><span>法律在线</span> <a href="">关于我们</a> <a href="">团队管理</a> <a
					href="">板块说明</a> <a href="">加入我们</a></li>
				<li><span>新手帮助</span> <a href="">如何使用</a> <a href="">如何使用</a> <a
					href="">如何使用</a> <a href="">如何使用</a></li>
				<li><span>新手帮助</span> <a href="">如何使用</a> <a href="">如何使用</a> <a
					href="">如何使用</a> <a href="">如何使用</a></li>
				<li><span>律师加盟</span> <a href="">入住流程</a> <a href="">入住协议</a> <a
					href="">排名规则</a> <a href="">招商合作</a></li>
				<li><span>常见问题</span> <a href="">如何服务</a> <a href="">注册流程</a> <a
					href="">忘记密码</a> <a href="">服务政策</a></li>
			</ul>
		</div>
	</div>
	<!--E=友情链接-->
	<!--S=关于我们-->
	<div id="aboutMe">
		<p></p>
		<p id="footInfo"></p>
		<p>业务信箱：电话： <span id="footPho"> </span>&nbsp;&nbsp;邮箱：<span id="footMail"></span></p>
		<p>&copy;版权所有：法律智慧网 www.hnit.com 2012-2015&nbsp;&nbsp; 制作单位：源辰信息有限公司</p>
	</div>
	<!--E=关于我们-->
	<script src="js/time.js" type="text/javascript"></script>
	
</body>
</html>
