/**
 * 这里写的是一些超链接的点击跳转事件,其中的请求是获取相关内容的总条数
 */
var pagesize=8;
$(function(){
	$.post("../../RuleServlet",{op:"getTotalBGBZ"},function(data){
		if(data==0){
			total=1;
		}else if(data%pagesize==0){
			total=data/pagesize;
		}else{
			total=Math.floor(data/pagesize)+1;
		}
		$(".tcdPageCode").createPage({
		    pageCount:total,
		    current:1,
		    backFn:function(pageNum){
		    	var str="";
		    	var i=0;
		       $.post("../../RuleServlet",{op:"findAllRuleByPage",page:pageNum,rows:pagesize},function(data){
		    	   $.each(data.rows,function(index,item){
		    		   str+='<li class="top_div"><div class="main_div"><span class="main_span">'+item.rn +'</span></div><div class="main_con"><p>'+item.content+'</p></div></li>';
		    	   });
		    	   $("#top_list").html( $(str) );
		       },"json");
		    }
		});
	});
	
});

