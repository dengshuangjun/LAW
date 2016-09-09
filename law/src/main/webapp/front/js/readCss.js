/**
 * 每次主页面加载，就读取最新的样式信息
 */
	$.ajax({
		url: "../xml/style.xml",
		dataType: 'xml',
		type: 'GET',
		timeout: 2000,
		error: function(xml)
		{
			//加载xml失败
			if($("#cssLink")!=undefined){
				$("#cssLink").attr("href","css/index.css");
			}
			if($("#footInfo")!=undefined){
				$("#footInfo").html("本网站所刊登的各种新闻、信息和专题专栏资料、均为法律智慧网版权所有、未经协议授权，禁止下载使用！");
			}
			if($("#footPho")!=undefined){
				$("#footPho").html("1234567890");
			}
			if($("#footMail")!=undefined){
				$("#footMail").html("123456789@qq.com");
			}
		},
		success: function(xml)
		{
			$(xml).find("style").each(function(i){
				var indexChangCss = $(this).children("main").text();

				if($("#cssLink")!=undefined){
					$("#cssLink").attr("href",indexChangCss);
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
				});
			});
		}
	});

	//加载友情链接的图片
	$.post("/law/friendUrl/findFriConn",function(data){
		if(data!=null && ""!=data){
			var str="<tr>";
			if(data.length<6){
				for(var i=0,j=data.length;i<j;i++){
					str+="<td><a href='"+data[i].conn_address+"'><img src='../"+data[i].conn_pic+"' title="+data[i].conn_name+"></a></td>"
				}
				str+="</tr><tr>";
			}
			if(data.length>=6){
				for(var i=0;i<5;i++){
					str+="<td><a href='"+data[i].conn_address+"'><img src='../"+data[i].conn_pic+"' title="+data[i].conn_name+"></a></td>"
				}
				str+="</tr><tr>";
				for(var i=5;i<data.length;i++){
					str+="<td><a href='"+data[i].conn_address+"'><img src='../"+data[i].conn_pic+"' title="+data[i].conn_name+"></a></td>";
				}
			}
			str+="</tr>";
			$("#friConnEight").html(str);
		}
	},'json');
