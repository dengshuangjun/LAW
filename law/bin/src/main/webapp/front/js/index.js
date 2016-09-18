/**
 * 这里写的是一些超链接的点击跳转事件,其中的请求是获取相关内容的总条数
 */
$(function() {
	$(".tcdPageCode").createPage({
		pageCount : 6,
		current : 1,
		backFn : function(pageNum) {
			console.info(pageNum);
		}
	});
});
