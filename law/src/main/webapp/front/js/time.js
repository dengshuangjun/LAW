window.onload=function(){
	var enabled = 0; today = new Date();
	var day;
	var date;
	if(today.getDay()==0) day = " 星期日"
	if(today.getDay()==1) day = " 星期一"
	if(today.getDay()==2) day = " 星期二"
	if(today.getDay()==3) day = " 星期三"
	if(today.getDay()==4) day = " 星期四"
	if(today.getDay()==5) day = " 星期五"
	if(today.getDay()==6) day = " 星期六"
	date = (today.getFullYear()) + "年" + (today.getMonth() + 1 ) + "月" + today.getDate() + "日" + day +"";
	document.getElementById('nowtime').innerHTML=date;
}

function userCenter(usid){
	if(usid!=null){
		$.post("../../userServlet", {
			op : "findUserById",
			usid : usid
		}, function(data) {
			if (data) {
				location.href="../tieba/tiebaUser.jsp";
			}
		});
	}else{
		alert("请先登陆!");
	}
}
function zhuxiao(){
	$.post("/law/front/zhuxiao",function(data){
		 location.reload() ;
	},"json");
}
/*
function aboutUs(usid){
	if(usid!=null){
		$.post("", {
			op : "findUserById",
			usid : usid
		}, function(data) {
			if (data) {
				location.href="aboutUs.jsp";
			}
		});
	}else{
	$.post("", {
			op : "findUserById",
			usid : usid
		}, 
		location.href="submit.html？纷纷";
	}
}*/
