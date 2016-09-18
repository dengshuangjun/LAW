//分页标签
$(function(){
	$(".tcdPageCode").createPage({
        pageCount:6,
        current:1,
        backFn:function(p){
        	console.info(p);
        }
    });

})
