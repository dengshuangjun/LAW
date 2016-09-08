<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>法治名言</title>
	<meta name="keywords" content="法律智慧网,法律咨询,法律咨询网,法律在线,法律知识,法律援助,律师在线,中国法律,中法网">
	<meta name="description" content="法律智慧网是一家在线法律服务门户网站平台，律师在线解答法律咨询，为您提供一站式、便捷、高效的法律服务！">
	<link rel="shortcut icon" href="../images/logo_ .png">
	<link rel="stylesheet" type="text/css" href="../css/CssReset.css">
	<link rel="stylesheet" type="text/css" href="../css/model.css">
	<link rel="stylesheet" type="text/css" href="../css/pageCode.css"/>
	<link rel="stylesheet" type="text/css" id="devIndexCss">
	<link rel="stylesheet" type="text/css" id="devArtCss">
	<script src="../js/time.js"></script>
</head>

<body>
	<div id="top">
		<div id="top_page">
			<span style="">今天是<span id="nowtime"></span></span>
			<ul>
			<li><a href="../load.html">登录</a>| <a href="../submit.html">注册</a>| <a
					href="javascript:void(0)" onclick="userCenter()">会员中心</a>| <a
					href="###">收藏本站</a>| <a href="###">关于我们</a></li>
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
        <li><a href="../wave/wave.jsp">智慧电波</a>
         <ul class="ull">
             <li><a href="../wave/wave.jsp">校园动态</a></li>
             <li><a href="../wave/wave2.jsp">社会聚焦</a></li>
             <li><a href="../wave/wave3.jsp">新闻调查</a></li>
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
     <li><a href="people.jsp">智慧私塾</a>
         <ul class="ull">
             <li><a href="people.jsp">法治名人</a></li>
             <li><a href="story.jsp">法治故事</a></li>
             <li><a href="story2.jsp">法治典故</a></li>
             <li><a href="saying.jsp">法治名言</a></li>
             <li><a href="secret.jsp">法治灯谜</a></li>
             <li><a href="words.jsp">法治楹联</a></li>
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
			<p>您现在正在浏览:智慧私塾 > 法治名言</p>
		</div>
		<div class="content">
			<div class="left">
				<div class="title">
					<p>智慧私塾</p>
				</div>
				<div class="classify">
					<ul>
						<li><a href="people.jsp">法治名人</a></li>
						<li><a href="story.jsp">法治故事</a></li>
						<li><a href="story2.jsp">法治典故</a></li>
						<li class="target"><a href="saying.jsp">法治名言</a></li>
						<li><a href="secret.jsp">法治灯谜</a></li>
						<li><a href="words.jsp">法治楹联</a></li>
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
				<div class="head"></div>
				<div class="newstory">
					<span>法治名言</span>
					<ul id="newsContent">
						
						<li><p>法律解释者都希望在法律中寻获其时代问题的答案。</p><b>——拉伦茨</b>
						</li>
						<li><p>立法者三句修改的话，全部藏书就会变成废纸。</p><b>——基希曼</b>
						</li>
						<li><p>法律的真理知识，来自于立法者的教养。</p><b>——黑格尔</b>
						</li>
						<li><p>解释法律系法律学之开端，并为其基础，系一项科学性工作，但又为一种艺术。</p><b>——萨维尼</b>
						</li>
						<li><p>法律是人类为了共同利益，由人类智慧遵循人类经验所做出的最后成果。</p><b>——强森</b>
						</li>
						<li><p>法治意味着，政府除非实施众所周知的规则，否则不得对个人实施强制。</p><b>——哈耶克</b>
						</li>
						<li><p>没有信仰的法律将退化成为僵死的教条，而没有法律的信仰将蜕变成为狂信。</p><b>——伯尔曼</b>
						</li>
						<li><p>法治概念的最高层次是一种信念，相信一切法律的基础，应该是对于人的价值的尊重。</p><b>　——陈弘毅</b>
						</li>
						<li><p>法律职业的社会地位是一个民族文明的标志。<p><b>——费尔德</b>
						</li>
						<li><p>尽量大可能把关于他们的意志的知识散布在人民中间，这就是立法机关的义务。</p><b>——边沁</b></li>
						
					</ul>
				</div>
					<div class="tcdPageCode"></div>
			</div>
		</div>
	</div>
	<div class="content_footer">
	<span>友情链接</span>
	<table id="friConnEight"></table>
</div>
<!--E=内容-->
<!--S=友情链接-->
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
	<p id="footInfo"></p>
	<p>业务信箱：电话： <span id="footPho"> </span>&nbsp;&nbsp;邮箱：<span id="footMail"></span></p>
	<p>&copy;版权所有：法律智慧网 www.hnit.com 2012-2015&nbsp;&nbsp; 制作单位：源辰信息有限公司</p>
</div>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery.page.js"></script>
<script src="../js/schoolindex.js"></script>
<script type="text/javascript" src="../js/readDevCss.js"></script>
</body>
</html>