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
				
				//查找尾部信息
				$(xml).find("footer").each(function(i){
					var info = $(this).children("info").text();
					var phone = $(this).children("phone").text();
					var email = $(this).children("email").text();

					if($("#footInfo")!=undefined){
						$("#footInfo").html(info);
					}
					if($("#footPho")!=undefined){
						$("#footPho").html(phone);
					}
					if($("#footMail")!=undefined){
						$("#footMail").html(email);
					}
					//加载友情链接的图片
					$.post("/law/friendUrl/findFriConn",function(data){
						if(data!=null && ""!=data){
							var str="<tr>";
							for(var i=0;i<(data.length-4);i++){
								str+="<td><a href="+data[i].conn_address+"><img src='../../"+data[i].conn_pic+"' title="+data[i].conn_name+"></a></td>"
							}
							str+="</tr><tr>";
							for(var i=4;i<data.length;i++){
								str+="<td><a href="+data[i].conn_address+"><img src='../../"+data[i].conn_pic+"' title="+data[i].conn_name+"></a></td>";
							}
							str+="</tr>";
							$("#friConnEight").html(str);
						}
					},'json');
				});
			});
		}
	});
});
