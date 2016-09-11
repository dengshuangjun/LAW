<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table id="waves_data"></table>
<div id="waves_data_add" data-options="iconCls:'icon-add',modal:true,closed:true,fit:true">
	在这里显示增加内容的信息

</div>  
<div id="waves_bar" style="padding:5px;height:auto">
		<div>
			按日期搜索从：<input class="easyui-datebox" style="width:100px">
			到: <input class="easyui-datebox" style="width:100px">
			所属版块: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value=''>全部</option>
				<option value="1001">校园动态</option>
				<option value="1002">社会聚焦</option>
				<option value="1003">新闻调查</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			<div style="float: right; margin-right: 20px;">
			<a href="javascript:void(0)" onclick="addWavsNews()" class="easyui-linkbutton"  iconCls="icon-add">添加</a>
			<a href="javascript:void(0)" onclick="delWaves()" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
		</div>
		</div>
		
	</div>
<script type="text/javascript">
var partid="1001,1002,1003";
var wavesObj;
wavesObj=$('#waves_data').datagrid({
	url:'backs/getWavesByPage',
	queryParams: {
		partid: partid
	},
	fitColumns:true,
	fit:true,
	striped:true,
	loadMsg:"正在加载中...",
	pagination:true,
	pageNumber:1,
	pageSize:10,
	pageList:[10,20,30,40,50],
	remoteSort:false,
	sortName:'weight',
	toolbar:"#waves_bar",
	columns:[[
		{field:'nid',sortable:true,align:'center',checkbox:true},
		{field:'ntname',title:'所属类型',width:200,align:'center',
			formatter:function(value,rowData,index){
				if(value==''||value==undefined){
					return "未指定类型";
				}else{
					return value;
				}
	    	}	
		},
		{field:'partName',title:'所属版块',width:180,align:'center'},
		{field:'title',title:'标题',width:250,align:'center'},
		{field:'ndate',title:'修改时间',width:400,align:'center'},
		{field:'weight',title:'文章权重',width:300,align:'center',sortable:true,
			formatter: function(value,row,index){
				var str="";
				str+=value+"<a href='javascript:setWavesWeight("+row.nid+",1,"+row.weight+","+row.partid+")' style='margin-left:4px;'>置顶</a>"+
				"<a href='javascript:setWavesWeight("+row.nid+",2,"+row.weight+","+row.partid+")' style='margin-left:4px;'>上移</a>"+
				"<a href='javascript:setWavesWeight("+row.nid+",3,"+row.weight+","+row.partid+")' style='margin-left:4px;'>下移</a>"
				return str; 
			}	
		},
		{field:'picpath',title:'图片数量',width:180,align:'center',
			formatter: function(value,row,index){
				if (value!=undefined&&value!=""){
					var str="";
					var pics=value.split(",");
					return pics.length;
				} else {
					return 0;
				}
			}	
		},
		{field:'vediopath',title:'视频数量',width:180,align:'center',
			formatter: function(value,row,index){
				if (value!=undefined&&value!=""){
					var str="";
					var pics=value.split(",");
					return pics.length;
				} else {
					return 0;
				}
			}	
		},
		{field:'voicepath',title:'音频数量',width:180,align:'center',
			formatter: function(value,row,index){
				if (value!=undefined&&value!=""){
					var str="";
					var pics=value.split(",");
					return pics.length;
				} else {
					return 0;
				}
			}	
		},
		{field:'views',title:'浏览次数',width:140,align:'center'},
		{field:'author',title:'作者来源',width:200,align:'center'},
		{field:'flag',title:'非注册可见',width:200,align:'center',
			formatter:function(value,rowData,index){
	    		if(value=='Y'){
	    			return "是";
	    		}
	    		return "否";
	    	}	
		},
		{field:'news_file',title:'有无附件',width:200,align:'center',
			formatter:function(value,rowData,index){
	    		if(value!=undefined&&value!=""){
	    			return "有";
	    		}
	    		return "无";
	    	}	
		},
		{field:'usname',title:'上传者',width:200,align:'center'},
		{field:'status',title:'是否可见',width:160,align:'center',
			formatter:function(value,rowData,index){
	    		if(value=='Y'){
	    			return "是";
	    		}
	    		return "否";
	    	}		
		},
		{field:'_operate',title:'操作',width:160,align:'center',
			formatter:function(value,rowData,index){
	    		return "<a href='javascript:newMore("+rowData.nid+")'>详细</a>";
	    	}	
		}  ]]

	
	});
function addWavsNews(){
		$('#waves_data_add').dialog({title:"添加",closed:false,modal:true,});
}
function setWavesWeight(nid,val,weight,partid){
	if(val==1){//置顶
		$.post("backs/setTop",{nid:nid,weight:weight,partid:partid},function(data){
			messageHandel("置顶",data);
		},"json");
	}else if(val==2){//上移
		$.post("backs/setUp",{nid:nid,weight:weight,partid:partid},function(data){
			messageHandel("上移",data);
		},"json");
	}else{//下移
		if(weight==0){
			$.messager.alert('提示信息','亲,权重最低为0..','info');
			return;
		}
		$.post("backs/setDown",{nid:nid},function(data){
			messageHandel("下移",data);
		},"json");
	}
}

function searchWavesAuto(){
	alert("a");
} 
function messageHandel(action,data){
	if(data==1){
		$.messager.show({
			title:'成功提示',
			msg:'权重'+action+'成功',
			timeout:3000,
			showType:'slide'
		});
		$('#waves_data').datagrid('reload');
	}else if(data==2){
		$.messager.alert('温馨提示','所属版块'+action+'已到最佳','info');
	}else{
		$.messager.alert('错误提示','操作失败...','error');
	}
}
function delWaves(){
	var rows=wavesObj.datagrid("getSelections");
		if(rows!=undefined&&rows!=''){
			$.messager.confirm('信息确认','您确定要删除选定的数据吗?', function(r){
				if (r){
					var nids="";
				for(var i=0;i<rows.length-1;i++){
					nids+=rows[i].nid+",";
				}
				nids+=rows[rows.length-1].nid;
				$.post("backs/delNews",{nids:nids},function(data){
					if(data){
						$.messager.show({
							title:'成功提示',
							msg:'删除成功',
							timeout:2000,
							showType:'slide'
						});
						rows=undefined;
						wavesObj.datagrid("reload");//刷新表格
					}else{
						$.messager.alert('失败提示','删除失败','error');
					}
				});
				}
			});
		}else{
			$.messager.alert('温馨提示','请选择要删除的数据...','info');
		}
	}
</script>	