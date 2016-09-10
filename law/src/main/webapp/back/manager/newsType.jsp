<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="Type_data"></table>
<script type="text/javascript">
var TypeObj;
var Type_editRowIng=undefined;
var Type_editRowStatus=undefined;
var editRowValue='Y';
var typeStatus;//区分是添加还是更新
TypeObj=$('#Type_data').datagrid({
	url:'backs/getTypeByPage',
	fitColumns:true,
	fit:true,
	striped:true,
	loadMsg:"正在加载中...",
	pagination:true,
	pageNumber:1,
	pageSize:10,
	pageList:[2,4,6,8,10],
	remoteSort:false,
	sortName:'usid',
	columns:[[  
	           {field:'ntid',sortable:true,align:'center',checkbox:true}, 
	           {field:'ntname',title:'类型名',width:200,align:'center',editor:{type:"text",options:{requires:true}}},  
	           {field:'status',title:'是否可用',width:60,align:'center',
	        	   formatter: function(value,row,index){
		        		  var valueStr= '<select id="userstate'+row.ntid+'" class="easyui-combobox" name="userstate" style="width:40px;"  disabled="none"  onchange="setvalue(this.value)">';
							if(value=='N'){
								valueStr+='<option value="N">否</option><option value="Y">是</option></select>';
							}else{
								valueStr+='<option value="Y">是</option><option value="N">否</option></select>';
							}
							return valueStr;
						}      
	           },
	           {field:'usid',title:'上次修改者id',width:200,align:'center'},
	           {field:'usname',title:'上次修改者',width:200,align:'center'},
	           {field:'note',title:'备注信息',width:400,align:'center',editor:{type:"text",options:{requires:true}}}
	   ]],
        toolbar:[{
        	text:'添加',
          	iconCls:"icon-add",
          	handler:function(){
          		append();
          		typeStatus="add";
      		}
        },{
        	text:'修改',
          	iconCls:"icon-edit",
          	handler:function(){
          		var rows=TypeObj.datagrid("getSelections");//获取选中的行
          		if(rows.length>1||rows.length<=0){
    				$.messager.alert('提示','您只能一次对一行数据进行修改...','error');
          		}else{
          			typeStatus="update";
          			$('#userstate'+rows[0].ntid).removeAttr('disabled');//下拉能被修改
          			var index= TypeObj.datagrid("getRowIndex",rows[0]);
          			TypeObj.datagrid("beginEdit",index);
          			Type_editRowIng=index;
          		}
      		}
        },{
        	text:'删除',
          	iconCls:"icon-remove",
          	handler:function(){
          		var rows=TypeObj.datagrid("getSelections");
          		if(rows!=undefined){
          			$.messager.confirm('信息确认','您确定要删除选定的数据吗?', function(r){
          				if (r){
          					var nids="";
							for(var i=0;i<rows.length-1;i++){
								nids+=rows[i].ntid+",";
							}
							nids+=rows[rows.length-1].ntid;
							$.post("backs/delTypes",{ntid:nids},function(data){
								if(data){
									$.messager.show({
										title:'成功提示',
										msg:'删除成功',
										timeout:2000,
										showType:'slide'
									});
									rows=null;
									TypeObj.datagrid("reload");//刷新表格
								}else{
									$.messager.alert('失败提示','删除失败','error');
								}
							});
          				}
          			});


          		}else{
          			return;
          		}
      		}
        },{
        	text:'撤销',
          	iconCls:"icon-cancel",
          	handler:function(){
          		removeit();
      		}
        },{
        	text:'保存',
          	iconCls:"icon-add",
          	handler:function(){
        		typeSave();
          	}
        }],

});
function append(){
	if (Type_editRowIng==undefined){
		$('#Type_data').datagrid('appendRow',{status:'Y'});
		Type_editRowIng = $('#Type_data').datagrid('getRows').length-1;
		$('#Type_data').datagrid('selectRow', Type_editRowIng)
				.datagrid('beginEdit', Type_editRowIng);
		
	}else{
		$.messager.alert('错误','一次只能编辑一行...','error');


	}
}
function removeit(){
	if (Type_editRowIng == undefined){return}
	$('#Type_data').datagrid('cancelEdit', Type_editRowIng)
			.datagrid('deleteRow', Type_editRowIng);
	Type_editRowIng = undefined;
}
//选择是否的时候设定值
function setvalue(b){
	editRowValue=b;
}
function typeSave(){
	$('#Type_data').datagrid('acceptChanges');
		var rows=TypeObj.datagrid("getSelections");
		if(typeStatus=="add"){
			rows[0].usid=$("#usid").val();
			if(rows[0].ntname==undefined||rows[0].ntname==''){
				$('#Type_data').datagrid('selectRow', Type_editRowIng)
			.datagrid('beginEdit', Type_editRowIng);
				$.messager.alert('错误','类型名不能为空','error');
			}else{
				$.post("backs/addTypes",rows[0],function(data){
		  			if(data){
		  				$('#Type_data').datagrid('reload');
		  				Type_editRowIng=undefined;
		  			}
	  			},"json");
			}
		}else{
			rows[0].usid=$("#usid").val();
			rows[0].status=editRowValue;
			if(rows[0].ntname==undefined||rows[0].ntname==''){
				$('#Type_data').datagrid('selectRow', Type_editRowIng)
			.datagrid('beginEdit', Type_editRowIng);
				$.messager.alert('错误','类型名不能为空','error');
			}else{
				console.info(rows);
				$.post("backs/updateType",rows[0],function(data){
		  			if(data){
		  				$('#Type_data').datagrid('reload');
		  				Type_editRowIng=undefined;
		  			}
	  			},"json");
			}
		}
		
}
</script>