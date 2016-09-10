	
$(function(){
	$(".nav-hover").bind("mouseover",function(){
		$(".dropdown-menu")[0].style.display = "block";
		});
	$(".nav-hover").bind("mouseout",function(){
		$(".dropdown-menu")[0].style.display = "none";
		});
	$(".choose").bind("mouseover",function(){
		$("#text-center")[0].style.display = "block";
		});
	$(".choose").bind("mouseout",function(){
		$("#text-center")[0].style.display = "none";
		});
	$("#text-center").bind("mouseover",function(){
		$("#text-center")[0].style.display = "block";
		});
	$("#text-center").bind("mouseout",function(){
		$("#text-center")[0].style.display = "none";
		});
		
	$("#text-center li").bind("click",function(){
		var str = this.innerHTML;
		var st = str + '<i style="color:#999;font-size:11px;margin-left:5px" class="glyphicon glyphicon-chevron-down"></i>';
		$(".choose").text("");
		$(".choose").append(st);
	});

	
});
