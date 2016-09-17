
$(function() {
	$(".tcdPageCode").createPage({
		pageCount : 6,
		current : 1,
		backFn : function(pageNum) {
			console.info(pageNum);
		}
	});
});

function shownew(id) {
	location.href = 'new.jsp';
}