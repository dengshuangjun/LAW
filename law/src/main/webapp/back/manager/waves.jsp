<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table id="waves_data"></table>
<script type="text/javascript">
var wavesObj;
wavesObj=$('#waves_data').datagrid({
	url:'backs/getWavesByPage',
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
	columns:[[
		{field:'nid',sortable:true,align:'center',checkbox:true},
		{field:'ntname',title:'所属类型',width:200,align:'center',
			formatter:function(value,rowData,index){
				if(value==''||value==null){
					return "未指定类型";
				}else{
					return value;
				}
	    		
	    	}	
		},
		{field:'partName',title:'所属版块',width:200,align:'center'},
		{field:'title',title:'标题',width:250,align:'center'},
		{field:'ndate',title:'修改时间',width:200,align:'center'},
		{field:'weight',title:'权重',width:100,align:'center'},
		{field:'picpath',title:'图片',width:200,align:'center'},
		{field:'vediopath',title:'视频',width:200,align:'center'},
		{field:'voicepath',title:'音频',width:200,align:'center'},
		{field:'views',title:'浏览次数',width:140,align:'center'},
		{field:'author',title:'作者来源',width:200,align:'center'},
		{field:'flag',title:'非注册人员可见',width:220,align:'center'},
		{field:'news_file',title:'附件名称',width:200,align:'center'},
		{field:'usname',title:'上传者',width:200,align:'center'},
		{field:'status',title:'是否可见',width:160,align:'center'},
		{field:'_operate',title:'操作',width:160,align:'center',
			formatter:function(value,rowData,index){
	    		return "<a href='javascript:newMore("+rowData.nid+")'>详细</a>";
	    	}	
		}  ]]
	});
</script>	