$(function() {
	$('#center_content').tabs('add',{  
	    title:'欢迎界面',  
	    href:'back/manager/welcome.html'
	});  
	
	$('.easyui-tree').tree({
		onClick: function(node){
			var text=node.text.trim();
			var tabs=$('#center_content');
			if(text=='主题换肤'){
				if(tabs.tabs('exists','主题换肤')){
					tabs.tabs('select',"主题换肤");
				}else{
					$('#center_content').tabs('add',{  
					    title:'主题换肤',  
					    closable:true, 
					    href:'back/manager/theme.html'
					});
				}
				
			}else if(text=='页脚信息'){
				if(tabs.tabs('exists','页脚信息')){
					tabs.tabs('select',"页脚信息");
				}else{
					$('#center_content').tabs('add',{  
					    title:'页脚信息',  
					    closable:true, 
					    href:'back/manager/footInfo.html'
					});
				}
				
			}else if(text=='友情链接'){
				if(tabs.tabs('exists','友情链接')){
					tabs.tabs('select',"友情链接");
				}else{
					$('#center_content').tabs('add',{  
					    title:'友情链接',  
					    closable:true, 
					    href:'back/manager/friendURL.html'
					});
				}
				
			}else if(text=='主页大图'){
				if(tabs.tabs('exists','主页大图')){
					tabs.tabs('select',"主页大图");
				}else{
					$('#center_content').tabs('add',{  
					    title:'主页大图',  
					    closable:true, 
					    href:'back/manager/mainPic.html'
					});
				}
				
			}else if(text=='关于我们'){
				if(tabs.tabs('exists','关于我们')){
					tabs.tabs('select',"关于我们");
				}else{
					$('#center_content').tabs('add',{  
					    title:'关于我们',  
					    closable:true, 
					    href:'back/manager/about.html'
					});
				}
				
			}else if(text=='智慧电波'){
				if(tabs.tabs('exists','智慧电波')){
					tabs.tabs('select',"智慧电波");
				}else{
					$('#center_content').tabs('add',{  
					    title:'智慧电波',  
					    closable:true, 
					    href:'back/manager/waves.html'
					});
				}
				
			}else if(text=='智慧艺苑'){
				if(tabs.tabs('exists','智慧艺苑')){
					tabs.tabs('select',"智慧艺苑");
				}else{
					$('#center_content').tabs('add',{  
					    title:'智慧艺苑',  
					    closable:true, 
					    href:'back/manager/art.html'
					});
				}
				
			}else if(text=='智慧私塾'){
				if(tabs.tabs('exists','智慧私塾')){
					tabs.tabs('select',"智慧私塾");
				}else{
					$('#center_content').tabs('add',{  
					    title:'智慧私塾',  
					    closable:true, 
					    href:'back/manager/privateSchool.html'
					});
				}
				
			}else if(text=='智慧讲堂'){
				if(tabs.tabs('exists','智慧讲堂')){
					tabs.tabs('select',"智慧讲堂");
				}else{
					$('#center_content').tabs('add',{  
					    title:'智慧讲堂',  
					    closable:true, 
					    href:'back/manager/classroom.html'
					});
				}
				
			}else if(text=='智慧助手'){
				if(tabs.tabs('exists','智慧助手')){
					tabs.tabs('select',"智慧助手");
				}else{
					$('#center_content').tabs('add',{  
					    title:'智慧助手',  
					    closable:true, 
					    href:'back/manager/help.html'
					});
				}
				
			}else if(text=='普通用户管理'){
				if(tabs.tabs('exists','普通用户管理')){
					tabs.tabs('select',"普通用户管理");
				}else{
					$('#center_content').tabs('add',{  
					    title:'普通用户管理',  
					    closable:true, 
					    href:'back/manager/generalUser.html'
					});
				}
				
			}else if(text=='管理员管理'){
				if(tabs.tabs('exists','管理员管理')){
					tabs.tabs('select',"管理员管理");
				}else{
					$('#center_content').tabs('add',{  
					    title:'管理员管理',  
					    closable:true, 
					    href:'back/manager/admin.jsp'
					});
				}
				
			}else if(text=='留言展示'){
				if(tabs.tabs('exists','留言展示')){
					tabs.tabs('select',"留言展示");
				}else{
					$('#center_content').tabs('add',{  
					    title:'留言展示',  
					    closable:true, 
					    href:'back/manager/message.html'
					});
				}
				
			}else if(text=='评论审核'){
				if(tabs.tabs('exists','评论审核')){
					tabs.tabs('select',"评论审核");
				}else{
					$('#center_content').tabs('add',{  
					    title:'评论审核',  
					    closable:true, 
					    href:'back/manager/reviewAudit.html'
					});
				}
				
			}else if(text=='法律类型'){
				if(tabs.tabs('exists','法律类型')){
					tabs.tabs('select',"法律类型");
				}else{
					$('#center_content').tabs('add',{  
					    title:'法律类型',  
					    closable:true, 
					    href:'back/manager/newsType.jsp'
					});
				}
				
			}
		}
	});
});
function backLoginOut(usid){
	$.post("back/backLoginOut",{usid:usid},function(data){
		if(data){
			location.href="/law/back/login";
		}
	},"json");
}