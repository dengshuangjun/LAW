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
	fitColumns:true,
	columns:[[  
	           {field:'ntid',sortable:true,align:'center',checkbox:true}, 
	           {field:'ntname',title:'类型名',align:'center'},  
	           {field:'status',title:'状态¨',align:'center'},
	           {field:'usid',title:'上次修改者id¨',align:'center'},
	           {field:'usname',title:'上次修改者¨',align:'center'}
	           ]]
	
});
</script>