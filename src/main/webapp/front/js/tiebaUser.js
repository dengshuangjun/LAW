// JavaScript Document
function show(myid){
	var showid=$(myid).get(0).getAttribute("id");
	if(showid=="content_wrap_home"){
		$("#content_wrap_collection").css("display","none");
		$("#content_wrap_tie").css("display","none");
		$("#content_wrap_setting").css("display","none");
		
/*		$("#nav_home").css("background-color","#CCC");
		$("#nav_collect").css("background-color","transparent");
		$("#nav_tie").css("background-color","transparent");
		$("#nav_setting").css("background-color","transparent");*/
	}else if(showid=="content_wrap_collection"){
		$("#content_wrap_home").css("display","none");
		$("#content_wrap_tie").css("display","none");
		$("#content_wrap_setting").css("display","none");
		
/*		$("#nav_collect").css("background-color","#CCC");
		$("#nav_home").css("background-color","transparent");
		$("#nav_tie").css("background-color","transparent");
		$("#nav_setting").css("background-color","transparent");*/
	}else if(showid=="content_wrap_tie"){
		$("#content_wrap_collection").css("display","none");
		$("#content_wrap_home").css("display","none");
		$("#content_wrap_setting").css("display","none");
		
/*		$("#nav_tie").css("background-color","#CCC");
		$("#nav_collect").css("background-color","transparent");
		$("#nav_home").css("background-color","transparent");
		$("#nav_setting").css("background-color","transparent");*/
	}else if(showid=="content_wrap_setting"){
		$("#content_wrap_collection").css("display","none");
		$("#content_wrap_tie").css("display","none");
		$("#content_wrap_home").css("display","none");
		
/*		$("#nav_setting").css("background-color","#CCC");
		$("#nav_collect").css("background-color","#f5f7fa");
		$("#nav_tie").css("background-color","#f5f7fa");
		$("#nav_home").css("background-color","#f5f7fa");*/
	}
	$(myid).css("display","block");
	
}