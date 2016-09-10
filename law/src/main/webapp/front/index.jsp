<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>法律智慧网</title>
<meta name="keywords"
	content="法律智慧网,法律咨询,法律咨询网,法律在线,法律知识,法律援助,律师在线,中国法律,中法网">
<meta name="description"
	content="法律智慧网是一家在线法律服务门户网站平台，律师在线解答法律咨询，为您提供一站式、便捷、高效的法律服务！">
<link rel="shortcut icon" href="images/logo_ .png">
<link rel="stylesheet" type="text/css" href="css/CssReset.css">
<link rel="stylesheet" type="text/css" id="cssLink">
<script src="js/jquery-1.9.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/readCss.js"></script>
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
				<li><a href="#">首页</a></li>
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
	<!--E=导航-->
	<!--S=内容-->
	<div id="content">
		<div class="content_top">
			<i id="pic" class="pic"></i>
			<ul id="scroll_number">
				<li onMouseOver="show(1)" onMouseOut="start()"></li>
				<li onMouseOver="show(2)" onMouseOut="start()"></li>
				<li onMouseOver="show(3)" onMouseOut="start()"></li>
				<li onMouseOver="show(4)" onMouseOut="start()"></li>
				<li onMouseOver="show(5)" onMouseOut="start()"></li>
			</ul>
		</div>
		<div class="information">
			<div class="th">法律资讯</div>


			<div class="information_left fl">
				<div>
					<span>校园动态</span> <span class="fr"><a href="###">更多</a></span>
				</div>
				<ul class="falv">
					<li><a href="###"><img src="images/schoolDynamic.jpg"
							width="130px" height="80px" style="margin: 10px;"></a> <span
						class="span1"><a href="#">生活设施不安全致害学生的侵...</a></span> <span
						class="span2">&nbsp;裁判要旨：校园伤害案件涉及到未成年人、监护人、学校等多方主体，如何确定这类案件的...<a
							href="#">[详情]</a></span></li>
				</ul>
				<ul class="info">
					<li><a href="#">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="#">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="#">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="#">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="#">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
				</ul>
			</div>
			<div class="information_left fl test">
				<div>
					<span>社会聚焦</span> <span class="fr"><a href="###">更多</a></span>
				</div>
				<ul class="falv">
					<li><a href="###"><img src="images/societyFocus.jpg"
							width="130px" height="80px" style="margin: 10px;"></a> <span
						class="span1"><a href="#">生活设施不安全致害学生的侵...</a></span> <span
						class="span2">&nbsp;裁判要旨：校园伤害案件涉及到未成年人、监护人、学校等多方主体，如何确定这类案件的...<a
							href="#">[详情]</a></span></li>
				</ul>
				<ul class="info">
					<li><a href="javascript:newsMore(1156)">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="javascript:newsMore(1156)">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="javascript:newsMore(1156)">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
					<li><a href="javascript:newsMore(1156)">生活设施不安全致害学生的侵...</a><span>2016-08-15</span></li>
				</ul>
			</div>
			<div class="information_left fl">
				<div>
					<span>法治小说</span> <span class="fr"><a href="###">更多</a></span>
				</div>
				<ul class="falv">
					<li><a href="###"><img src="images/falv.png" width="130px"
							height="80px" style="margin: 10px;"></a> <span class="span1"><a
							href="javascript:showMore(1117)">法制视频测试4</a></span> <span class="span2">&nbsp;
							的萨芬斯蒂芬v的萨芬斯蒂芬v的萨芬斯蒂芬v的萨芬斯蒂芬v的萨芬斯蒂芬v的萨...<a
							href="javascript:showMore(1117)">[详情]</a>
					</span></li>
				</ul>
				<ul class="info">
					<li><a href="javascript:showMore(1120)">法制视频测试4</a><span>2016-08-11</span></li>
					<li><a href="javascript:showMore(1120)">法制视频测试4</a><span>2016-08-11</span></li>
					<li><a href="javascript:showMore(1120)">法制视频测试4</a><span>2016-08-11</span></li>
					<li><a href="javascript:showMore(1120)">法制视频测试4</a><span>2016-08-11</span></li>
				</ul>
			</div>
		</div>
		<img src="images/middle.png">
		<div class="content_mid">
			<div class="left">
				<span>法治名言</span>
				<ol>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>
					<li style="font-size: 15px;">裁判要旨：校园伤害案件涉及...</li>
					<hr>

				</ol>
			</div>
			<div class="right">
				<span>法治时评</span>
				<table cellspacing="20">
					<tr>
						<td><img src="images/news.png"></td>
						<td rowspan="2"><a href="javascript:shownew(1166)"><b>生活设施不安全致害学生的侵权案件</b></a>
							<a href="javascript:shownew(1166)" class="a">裁判要旨：校园伤害案件涉及到未成年人、监护人、学校等多方主体，如何确定这类案件的诉讼主体与赔偿主体，如何确定赔偿义务人之间的责任比例及承担责任的方式，如何确定合理损失的范围尤其是被告预先垫付情况下原告合理损失的确认等都是审理此类案件的焦点难点问题<i>[查看详细]</i>
						</a></td>
					</tr>
				</table>
				<div class="ulleft">
					<ul>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
					</ul>
				</div>
				<div class="ulmain">
					<ul>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
					</ul>
				</div>
				<div class="ulright">
					<ul>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
						<li><a href="javascript:shownew(1189)">生活设施不安全致害学生的侵权案件</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="content_footer">
			<span>友情链接</span>
			<table id="friConnEight">
<%-- 				<c:if test="${friEightConns} != null">
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
						<td><a href="http://www.jcrb.com/"><img  ${item.conn_pic }
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
				</c:if> --%>
			</table>
		</div>
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
	<script src="js/radio.js" type="text/javascript"></script>
	<script src="js/time.js" type="text/javascript"></script>

</body>
</html>
