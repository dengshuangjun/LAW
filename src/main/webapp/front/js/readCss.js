/**
 * 每次主页面加载，就读取最新的样式信息
 */
	$.post("/law/theme/readCurrCss",function(data){
		if(data!=null){
			if($("#cssLink")!=undefined){
				$("#cssLink").attr("href",data.main);
			}
		}else{
			if($("#cssLink")!=undefined){
				$("#cssLink").attr("href","css/index.css");
			}
		}
		//解析尾部信息
		$.post("/law/footer/findCurrFooter",function(data){
			if(data!=null){
				if($("#footInfo")!=undefined){
					$("#footInfo").html(data.info);
				}
				if($("#footPho")!=undefined){
					$("#footPho").html(data.phone);
				}
				if($("#footMail")!=undefined){
					$("#footMail").html(data.email);
				}
			}else{
				if($("#footInfo")!=undefined){
					$("#footInfo").html("本网站所刊登的各种新闻、信息和专题专栏资料、均为法律智慧网版权所有、未经协议授权，禁止下载使用！");
				}
				if($("#footPho")!=undefined){
					$("#footPho").html("1234567890");
				}
				if($("#footMail")!=undefined){
					$("#footMail").html("123456789@qq.com");
				}
			}
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
		},"json");
	},"json");
	