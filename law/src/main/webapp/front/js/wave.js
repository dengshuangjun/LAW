//分页标签
var law_Partid=1001;
$(function(){
	var total=1;
	var urlPath=window.location.pathname;
	var file=urlPath.substring(urlPath.lastIndexOf("/")+1);
	if(file=="wave.jsp"){
		law_Partid=1001;
	}else if(file=="wave2.jsp"){
		law_Partid=1002;
	}else if(file=="wave3.jsp"){
		law_Partid=1003;
	}
	$.post("../../wave/getWaveNewsTotal",{partId:law_Partid},function(data){
		if(data>0){
			if(data==0){
				total=1;
			}else if(data%12==0){
				total=data/12;
			}else{
				total=Math.floor(data/12)+1;
			}
			$(".tcdPageCode").createPage({
		        pageCount:total,
		        current:1,
		        backFn:function(p){
		           var str="";
		           $.post("../../wave/findWaveNewsByPage",{pageNo:p,pageSize:"12",partId : law_Partid},function(data){
		        	   $.each(data,function(index,item){
		   				str+='<li><a href="javascript:newsMore('+item.nid+')">'+item.title+'</a></li>';
		        	   });
		        	   $(".new_left ul").html( $(str) );
		           },"json");
		        }
		    });
		}
	},"json");
})

//查看详细新闻
function newsMore(nid){
	$.post("../../waveNewsServlet",{op:"findWaveContentByNid",nid:nid},function(data){
		if(data){
			window.open("news.jsp?nid="+nid,"_blank");
		}
	});
}