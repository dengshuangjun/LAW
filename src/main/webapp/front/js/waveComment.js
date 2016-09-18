$(function() {
	findLawMark();
});
function findLawMark() {
	$.post("../../waveNewsServlet", {
		op : "getLawMark",
		nid : GetQueryString("nid")
	}, function(data) {
		var str = "";
		$.each(data, function(index, item) {
			str += "<li><b>" + item.usname + "</b>:" + item.mcontent + "</li>";

		});
		$("#right_low_left ul").html($(str));
	}, "json");
}
// 获取地址栏参数
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
// 点击评论
function Comment() {
	$.post("../../waveNewsServlet", {
		op : "Comment",
		params : (toJsonStr($("#formID").serialize()))
	}, function(data) {
		if (data) {
			findLawMark();
			$("#formID textarea").val("");
		}
	});
}
function toJsonStr(str) {
	return str = "{\"" + str.replace(/=/g, "\":\"").replace(/&/g, "\",\"")
			+ "\"}";
}