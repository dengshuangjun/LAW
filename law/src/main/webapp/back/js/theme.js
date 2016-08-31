function changeCss(color){
	$.post("theme/changeCss?color=" + color,function(data){
		if(data){
			$.messager.show({title:'成功提示',msg:"前台样式修改成功!!!",timeout:2000,showType:'slide'});
		}
	});
	
	
}