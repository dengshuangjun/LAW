<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>
<link rel="shortcut icon" href="images/logo_ .png">
<link type="text/css" href="css/index.css" rel="stylesheet" />
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/offcanvas.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/theme.css" rel="stylesheet">
<link href="css/photo.css" rel="stylesheet">
<link href="css/sim-prev-anim_photo.css" rel="stylesheet">
<script src="js/jquery-1.9.1.js" charset="utf-8"></script>
<script src="js/tiebaUser.js" charset="utf-8"></script>
<script src="js/time.js"></script>
<script src="js/showpic.js"></script>
<script src="js/ajaxfileupload.js"></script>

</head>
<style>
* {
	margin: 0 auto;
	padding: 0;
}

li {
	list-style: none;
}

li a {
	text-decoration: none;
}

.content {
	width: 1000px;
	height: 1330px;
	font-family: "华文楷体";
	background-color: #FFF;
	border: 1px solid #CCC;
}
</style>
<body>
	<div id="top">
		<div id="top_page">
			<span style="">今天是<span id="nowtime"></span></span>
			<ul>
				<li><a href="load.html">登录</a>| <a href="submit.html">注册</a>| <a
					href="javascript:void(0)" onclick="userCenter()">会员中心</a>| <a
					href="###">收藏本站</a>| <a href="###">关于我们</a></li>
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
				<li><a href="art.jsp">智慧艺苑</a>
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
				<li><a href="tieba.jsp">法律智慧贴吧</a></li>
			</ul>
		</div>
	</div>
	<div id="con_bg">
		<div class="content" style="height: 950px;">
			<div id="posite">
				<span>您现在所在的位置>><a href="tieba.jsp">法律智慧贴吧</a>>>贴吧用户中心
				</span>
			</div>
			<div id="top_img">
				<img src="images/pic_1.jpg" width="1000px" height="200px" />
			</div>
			<div class="col-xs-12 col-sm-9" style="margin-left: 155px;">
				<div class="alert alert-success">
					<strong><h3>基本资料</h3></strong> 你可以在这里修改个人信息哦~
				</div>
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title" style="display: inline;">基本资料</h3>
					</div>
					<div class="panel-body">
						<ul class="list-group">
							<li class="list-group-item"><strong>头像修改：</strong>
								<div id="pic">
											<img src="images/man.png" class="img-thumbnail" alt="头像"
												width="100px" height="100px;" id="NewPic">
								</div>
								<span
								style="display: inline; margin-left: 500px; margin-bottom: 50px;"><input
									type="file" id="user_pic" accept="image/*"
									onchange="previewMultipleImage(this,'user_pic')"
									multiple="multiple" name="picpath" /></span></li>
							<li class="list-group-item"><strong>用户名：</strong><input
								type="text" placeholder="用户名" onblur="checkuname()"
								style="width: 200px; border: #999 solid 1px; border-radius: 3px;"
								value="${userCenter.usname }" id="uname"> <span
								id="checkname"></span></li>
							<li class="list-group-item"><strong>旧密码：</strong><input
								type="password" placeholder="旧密码"
								style="width: 200px; border: #999 solid 1px; border-radius: 3px;"
								onblur="checkpwd('${userCenter.upwd}')" id="OldUpwd"> <span
								id="OldMsg"></span></li>

							<li class="list-group-item"><strong>新密码：</strong><input
								type="password" placeholder="新密码"
								style="width: 200px; border: #999 solid 1px; border-radius: 3px;"
								id="NewUpwd" onblur="checkzcpwd()"> <span id="NewMsg"></span>
							</li>
							<li class="list-group-item"><strong>联系方式：</strong><input
								type="text" placeholder="手机" onblur="checkTel()"
								style="width: 200px; border: #999 solid 1px; border-radius: 3px;"
								value="${userCenter.tel }" id="NewTel"> <span
								id="TelMsg"></span></li>
							<p style="text-align: center; margin: 20px auto;">
								<button type="button" class="btn btn-success"
									onclick="save(${userCenter.usid })">保存更改</button>
							</p>
						</ul>
					</div>
					<!--content结束-->
				</div>
			</div>
		</div>
	</div>
	<!--bg_con结束-->
	<div class="content_footer">
		<span>友情链接</span>
		<table>
			<tr>
				<td><a
					href="http://cctv.cntv.cn/lm/falvjiangtang/shenghuobanguanwang/"><img
						src="images/table_class.jpg" title="法律讲堂"></a></td>
				<td><a href="http://www.moj.gov.cn/"><img
						src="images/table_sf.jpg" title="中华人民共和国司法部"></a></td>
				<td><a href="http://www.chinacourt.org/index.shtml"><img
						src="images/table_fy.jpg" title="中国法院网"></a></td>
				<td><a href="http://www.legalinfo.gov.cn/"><img
						src="images/table_pf.jpg" title="普法网"></a></td>
				<td><a href="http://www.people.com.cn/"><img
						src="images/table_people.jpg" title="人民网"></a></td>
			</tr>
			<tr>
				<td><a href="http://www.jcrb.com/"><img
						src="images/table_zy.jpg" title="正义网"></a></td>
				<td><a href="http://english.china.com/"><img
						src="images/table_zh.jpg" title="中华网"></a></td>
				<td><a href="http://www.news.cn/"><img
						src="images/table_xh.jpg" title="新华网"></a></td>
				<td><a href="http://www.scio.gov.cn/"><img
						src="images/table_ol.jpg" title="国务院办公室"></a></td>
				<td><a href="http://www.sdbgw.com.cn/"><img
						src="images/table_time.jpg" title="时代报告"></a></td>
			</tr>
		</table>
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
		<p>本网站所刊登的各种新闻、信息和专题专栏资料、均为法律智慧网版权所有、未经协议授权，禁止下载使用！</p>
		<p>业务信箱： 电话：010-110120023 传真：010-63394466</p>
		<p>&copy;版权所有：法律智慧网 www.hnit.com 2012-2015 制作单位：源辰信息有限公司</p>
	</div>
</body>
<script type="text/javascript">
	function showMenu(id) {
		document.getElementById(id).style.display = "block";
	}

	function hideMenu(id) {
		document.getElementById(id).style.display = "none";
	}
	
	
</script>
</html>

