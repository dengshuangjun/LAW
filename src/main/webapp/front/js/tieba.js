// 分类模块
var pageSize;
var pageNum;
var jumpId;
function jumpAllTie(typeid) {
	jumpId=typeid;
	$.post("../../TiebaServlet", {
		op : "jumpAllTie",
		pageNum : 1,
		typeid : typeid,
		pageSize : 8
	}, function(data) {
		if (data > 0) {
			location.href = 'alltie.jsp';
		}
	});
}
