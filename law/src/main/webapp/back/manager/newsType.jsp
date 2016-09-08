<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="Type_data"></table>
<script type="text/javascript">
var TypeObj;//æ´ä¸ªtableå¯¹è±¡
var Type_editRowIng=undefined;//æ­£å¨è¢«ç¼è¾çè¡
var Type_editRowStatus;//è¢«ç¼è¾è¡çç¶æ
userObj=$('#Type_data').datagrid({
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
	           {field:'ntname',title:'类型名',width:200,align:'center'},  
	           {field:'status',title:'是否可用¨',width:60,align:'center',
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
	           {field:'usid',title:'上次修改者id¨',width:200,align:'center'},
	           {field:'usname',title:'上次修改者¨',width:200,align:'center'},
	           {field:'note',title:'备注信息¨',width:400,align:'center'}
	           ]]
	
});
</script>