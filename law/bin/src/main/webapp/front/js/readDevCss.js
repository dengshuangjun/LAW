/**
 * 
 * 每次子页面加载，就读取最新的样式信息
 */
/*$(function() {

});*/

$(document).ready(function() {
	$.ajax({
		url: "../../xml/style.xml",
		dataType: 'xml',
		type: 'GET',
		timeout: 2000,
		error: function(xml)
		{
			alert("加载XML 文件出错！");
		},
		success: function(xml)
		{
			$(xml).find("style").each(function(i){
				var devIndexCss = $(this).children("devMain").text();
				var devArtCss = $(this).children("dev").text();

				if($("#devIndexCss")!=undefined){
					$("#devIndexCss").attr("href",devIndexCss);
				}
				if($("#devArtCss")!=undefined){
					$("#devArtCss").attr("href",devArtCss);
				}
			});
		}
	});
});
