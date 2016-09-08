<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/law/">
<meta charset="UTF-8">
<title>法律网站_后台管理系统</title>
<link rel="shortcut icon" href="back/images/logo_.png">
<link rel="stylesheet" type="text/css" href="back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="back/css/icon.css">
<link rel="stylesheet" type="text/css" href="back/css/demo.css">
<link rel="stylesheet" type="text/css" href="back/css/theme.css">
<link rel="stylesheet" type="text/css" href="back/css/mainFivePic.css">
<script type="text/javascript" src="back/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="back/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="back/js/theme.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.js"> </script>
<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="back/js/showpic.js"></script>
<script type="text/javascript" src="back/js/showfivepic.js"></script>
<script type="text/javascript" src="back/js/ajaxfileupload.js"></script>
<style type="text/css">
	#userPhoto img{
	width: 80px;
	height:100px;
	}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding-left: 10px">
		<img src="back/images/logo_.png" height="60px;" width="60px;"
			style="display: inline-block; float: left;" /> <span
			style="line-height: 60px; height: 60px; text-align: center; display: inline; float: left; font-size: 25px; padding-left: 20px;">法律智慧网_后台管理系统</span>
		<div
			style="height: 60px; float: right; padding: 0 20px; min-width: 200px;">
			<span style="font-size: 20px; line-height: 60px;">欢迎您:${user.usname}！！！</span>
		</div>
	</div>

	<div data-options="region:'west',split:true,title:'菜单'"
		style="width: 170px;">
		<div class="easyui-accordion" style="width: 100%; height: 100%;">
			<div title="数据字典" data-options="iconCls:'icon-ok'"
				style="overflow: auto; padding-left: 10px;">
				<ul class="easyui-tree">
					<li>主题换肤</li>
					<li>页脚信息</li>
					<li>友情链接</li>
					<li>主页大图</li>
					<li>关于我们</li>
				</ul>
			</div><div title="法律类型 " data-options="iconCls:'icon-ok'"
				style="padding-left: 10px;">
				<ul class="easyui-tree">
					<li>法律类型</li>
				</ul>
			</div>
			<div title="模块管理" data-options="iconCls:'icon-ok'"
				style="padding-left: 10px;">
				<ul class="easyui-tree">
					<li>智慧电波</li>
					<li>智慧艺苑</li>
					<li>智慧私塾</li>
					<li>智慧讲堂</li>
					<li>智慧助手</li>
				</ul>
			</div>
			<div title="用户管理" data-options="iconCls:'icon-ok'"
				style="padding-left: 10px;">
				<ul class="easyui-tree">
					<li>普通用户管理</li>
					<li>管理员管理</li>
				</ul>
			</div>
			<div title="留言管理" data-options="iconCls:'icon-ok'"
				style="padding-left: 10px;">
				<ul class="easyui-tree">
					<li>留言回复</li>
					<li>评论审核</li>
				</ul>
			</div>
			<div title="" selected></div>
		</div>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'帮助信息'"
		style="width: 100px; padding: 10px;"></div>
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">
		<p style="text-align: center;">&copy;版权所有：法律智慧网 2016 制作单位：源辰信息有限公司</p>
	</div>
	<div data-options="region:'center',title:'操作'">
		<div id="center_content" class="easyui-tabs" data-options="fit:true">
			<!-- 树具体内容的显示区域 -->
		</div>
	</div>
	<script type="text/javascript" src="back/js/index.js"></script>
</body>
</html>
