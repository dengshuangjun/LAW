<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>校园动态[详情]</title>
	<meta name="keywords" content="法律智慧网,法律咨询,法律咨询网,法律在线,法律知识,法律援助,律师在线,中国法律,中法网">
	<meta name="description" content="法律智慧网是一家在线法律服务门户网站平台，律师在线解答法律咨询，为您提供一站式、便捷、高效的法律服务！">
	<link rel="shortcut icon" href="../images/logo_ .png">
	<link rel="stylesheet" type="text/css" href="../css/CssReset.css">
	<link rel="stylesheet" type="text/css" href="../css/model.css">
	<link rel="stylesheet" type="text/css" id="devIndexCss">
	<link rel="stylesheet" type="text/css" id="devArtCss">
    <style>
		.content .right span{
			text-align: center;
			font-weight: bold;
			font-size: 22px;
			width: 866px;
			display: block;
			margin: 40px 0 40px 0;
			color: #00F;
			float:left;
		}
		.content .right .right_top .ppp{
			margin:0 50px;
			font-size:16px;
			line-height:25px;
			text-indent:2em;
		}
    </style>
</head>
<body>
	<div id="top">
		<div id="top_page">
			<span>今天是<span id="nowtime"></span></span>
       <ul>
				<li>
				<c:if test="${user.usid!=null&&user.usid!=''}">
						<a>欢迎！！</a>： <a>${user.usname }</a>|
				</c:if> 
				<c:if test="${user.usid==null||user.usid==''}">
						<li><a href="../load.html">登录</a>| <a href="../submit.html">免费注册</a>|
				</c:if> 
					<a href="javascript:void(0)" onclick="userCenter(${user.usid})">会员中心</a>| <a href="###">收藏本站</a>| <a href="###">关于我们</a>
				</li>
			</ul>
    </div>
</div>
<!--E=页面-->
<!--S=logo-->
<div id="logo">
	<div class="img_logo fl"><img src="../images/logo.png"/></div>
	<div class="form fr">
		<form action="" method="get">
			<input type="text" placeholder="请输入关键字..." name="keyword"/>
			<input type="submit" value="检索"/>
		</form>
	</div>
</div>
<!--E=logo-->
<!--S=导航-->
<div id="nav">
 <div class="nav_page">
     <ul>
        <li><a href="../index.jsp">首页</a></li>
        <li><a href="wave.jsp">智慧电波</a>
         <ul class="ull">
             <li><a href="wave.jsp">校园动态</a></li>
             <li><a href="wave2.jsp">社会聚焦</a></li>
             <li><a href="wave3.jsp">新闻调查</a></li>
         </ul>
     </li>
     <li><a href="../art/art.jsp">智慧艺苑</a>
         <ul class="ull">
             <li><a href="../art/art.jsp">法治视频</a></li>
             <li><a href="../art/art2.jsp">法治动漫</a></li>
             <li><a href="../art/art3.jsp">法治摄影</a></li>
             <li><a href="../art/art4.jsp">法治书画</a></li>
             <li><a href="../art/art5.jsp">法治小说</a></li>
         </ul>
     </li>
     <li><a href="../school/people.jsp">智慧私塾</a>
         <ul class="ull">
             <li><a href="../school/people.jsp">法治名人</a></li>
             <li><a href="../school/story.jsp">法治故事</a></li>
             <li><a href="../school/story2.jsp">法治典故</a></li>
             <li><a href="../school/saying.jsp">法治名言</a></li>
             <li><a href="../school/secret.jsp">法治灯谜</a></li>
             <li><a href="../school/words.jsp">法治楹联</a></li>
         </ul>
     </li>
     <li><a href="../wisdom/wisdom.jsp">智慧讲堂</a>
         <ul class="ull">
             <li><a href="../wisdom/wisdom.jsp">法律时评</a></li>
             <li><a href="../wisdom/wisdom2.jsp">以案释法</a></li>
             <li><a href="../wisdom/wisdom3.jsp">名人说法</a></li>
         </ul>
     </li>
     <li><a href="../assis/assis.jsp">智慧助手</a>
         <ul class="ull">
             <li><a href="../assis/assis.jsp">法规检索</a></li>
             <li><a href="../assis/assis2.jsp">法律e点通</a></li>
             <li><a href="../assis/assis3.jsp">法理探索</a></li>
         </ul>
     </li>
     <li><a href="../tieba/tieba.jsp">法律智慧贴吧</a></li>
 </ul>
</div>
</div>
<div class="model">
	<div class="lan">
		<p>您现在正在浏览:智慧电波 >> 校园动态  >>  详情</p>
	</div>
	<div class="content">
		<div class="left">
			<div class="title">
				<p>智慧电波</p>
			</div>
			<div class="classify">
				<ul>
					<li><a href="wave.jsp"  class="wave">校园动态</a></li>
					<li><a href="wave2.jsp">社会聚焦</a></li>
					<li><a href="wave3.jsp">新闻调查</a></li>
				</ul>
                <ul class="ad">
                	<li><img src="../images/ad.png"></li>
                    <li><img src="../images/ad.png"></li>
                    <li><img src="../images/ad.png"></li>
                    <li><img src="../images/ad.png"></li>
                 </ul>
			</div>
		</div>
		<div class="right">
			<div class="right_top">
				<span>${waveContent.title}</span>
           		<div class="ppp">
           			<c:if test="${waveContent.vediopath!=''&&waveContent.vediopath!=null}">
						<video width="600" height="300" controls autoplay>
							<source src="../../${waveContent.vediopath}" type="video/mp4">
							<object data="" width="600" height="300"></object>
						</video>
						<hr />
					</c:if>
					<c:if test="${waveContent.picpath!=null&&waveContent.picpath!=''&&waveContent.picpath!='vedio'}">
						<c:forEach items="${waveContent.picpath.split(',') }" var="item"
							varStatus="s">
							<li><img src="../../${item} " width="600" 
								alt="${waveContent.title}"></li>
						</c:forEach>
					</c:if>
					<p>${waveContent.content}</p>
				</div>
			</div>
			<div class="right_low">
				<div class="right_low_left" id="right_low_left">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;评论区：</p>
					<ul></ul>
				</div>
				<div class="right_low_right">
						<form id="formID">
							<input type="hidden" name="usid" value="${user.usid}"/>
							 <input type="hidden" name="nid" value="${waveContent.nid }"/>
							<textarea  name="mcontent"
								style="width: 260px; height: 100px; margin-left: 20px; margin-top: 20px; resize: none;"></textarea>
							<br /> <label style="margin-left: 20px; margin-top: 20px;">还可以输入150个字</label>
							<c:if test="${user.usid==null||user.usid==''}">
								<button style="margin-left: 180px; margin-top: 20px;" disabled="disabled">请登录后发表评论</button>
							</c:if>
							<c:if test="${user.usid!=null&&user.usid!=''}">
								<input type="button" onclick="javascript:Comment();" style="margin-left: 180px; margin-top: 20px; padding: 3px; background-color:#ffff;" value="发表评论">
							</c:if>
						</form>
					</div>
			</div>
			
		</div>
	</div>
</div>
<div id="link">
	<div class="contact fl">
		<h2>联系我们</h2>
		<ul>
			<li>
				官方微信：<br/>
				<i class="wechat"></i>
			</li>
			<li>
				客服电话：<span><i class="phone"></i>11022020</span><br/>
				官方微博：<a href="###" target="_blank"><i class="weibo"></i></a><br/>
				客服在线：<a href="###" target="_blank"><i class="qq"></i></a>
			</li>
		</ul>
	</div>
	<div class="navigation fl">
		<h2>服务导航</h2>
		<ul>
			<li>
				<span>法律在线</span>
				<a href="">关于我们</a>
				<a href="">团队管理</a>
				<a href="">板块说明</a>
				<a href="">加入我们</a>
			</li>
			<li>
				<span>新手帮助</span>
				<a href="">如何使用</a>
				<a href="">如何使用</a>
				<a href="">如何使用</a>
				<a href="">如何使用</a>
			</li>
			<li>
				<span>新手帮助</span>
				<a href="">如何使用</a>
				<a href="">如何使用</a>
				<a href="">如何使用</a>
				<a href="">如何使用</a>
			</li>
			<li>
				<span>律师加盟</span>
				<a href="">入住流程</a>
				<a href="">入住协议</a>
				<a href="">排名规则</a>
				<a href="">招商合作</a>
			</li>
			<li>
				<span>常见问题</span>
				<a href="">如何服务</a>
				<a href="">注册流程</a>
				<a href="">忘记密码</a>
				<a href="">服务政策</a>
			</li>
		</ul>
	</div>
</div>
<!--E=友情链接-->
<!--S=关于我们-->
<div id="aboutMe">
	<p></p>
	<p>本网站所刊登的各种新闻、信息和专题专栏资料、均为法律智慧网版权所有、未经协议授权，禁止下载使用！ </p>
	<p>业务信箱： 电话：010-110120023　传真：010-63394466</p>
	<p>&copy;版权所有：法律智慧网 www.hnit.com 2012-2015 制作单位：源辰信息有限公司</p>
</div>
	<script src="../js/time.js"></script>
	<script src="../js/jquery-1.9.1.js"></script>
	<script src="../js/waveComment.js"></script>
	<script type="text/javascript" src="../js/readDevCss.js"></script>
</body>
</html>


