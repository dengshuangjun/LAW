<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<base href="/law/" />
<link rel="shortcut icon" href="back/images/logo_.png">
<script type="text/javascript" src="back/js/jquery-1.9.1.min.js"></script>
<meta charset="UTF-8">
<title>error404</title>
</head>
<body>
	<img alt="错误提示" src="back/images/404.jpg" width="500px" height="300px;"><span>剩余<b id="timeOut">10</b>秒钟跳转到主页...如果不跳转请点击<a href="front/index.jsp">首页</a></span>
</body>
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
		location.href="front/index.jsp";
	}
}
</script>
</html>