<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择物品</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<style>
	.checkbox {
		 width: 30px;
		 height: 55px;
		 padding: 0 5px 0 0;
	}
	.btn{
		width:150px;
		height:35px;
		bgcolor:
	}
</style>
<body >
	<div class="header_bg">
		<div class="container">
			<div class="header">
	<div>选择物品</div>
	<form class="form-inline" action="${pageContext.request.contextPath }/iteminfo/select.do" method="post">
		<fieldset>
			<table>
				<tr align="center">
					<td><label>物品代码 ：</label> <input type="text" 
										class="form-control select-lg" name="itemcode"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><label>物品名称：</label> <input type="text"
										 class="form-control select-lg" name="chinesename"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="checkbox" class="checkbox" name="supllier" checked="checked"/> 供应商的供货范围</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><button class="btn btn-warning" type="submit">搜索</button></td>
				</tr>
			</table>
		</fieldset>
	</form>	
	<ul>
		<li>物品分类</li>
	</ul>
	<form name="batchoperation" method="Post" action="" id="batchoperation">
	<table class="table table-condensed table-hover table-striped" id="removeItam">
		<thead>
			<tr class="warning">
				<th><input name="cheackall" type="checkbox" id="cheackall" onclick=CheckAll(this.form) value="checkbox"> </th>
				<th>物品代码</th>
				<th>物品名称</th>
				<th>物品条码</th>
				<th>类别名称</th>
				<th>零售价</th>
				<th>最低售价</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${itemList }" var="item" varStatus="i">
				<tr class='success' id="tr${(i.index+1)}">
					<td><input type="checkbox" name="id" value="${(i.index+1)}" id="id${(i.index+1)}" onclick="UnCheckAll();"/></td>
					<td>${item.itemcode }</td>
					<td>${item.chinesename }</td>
					<td>${item.articlebarcode }</td>
					<td>${item.category	 }</td>
					<td>${item.proposalprice }</td>
					<td>${item.latestprice }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div align="center">
			<a title="保存后生效"><button class="btn btn-warning" type="button" onclick="addItem();">添加</button></a>
			<a title="删除自动移到上面"><button class="btn btn-warning" type="button" onclick="delItem();">删除</button></a>
		</div>
	<input name="idlist1" type="hidden" id="idlist1" value="" />
	<input name="idlist" type="hidden" id="idlist" value="" />
	</form>
	<form name="batchoperation" action="" id="batchoperation">	
		<table class="table table-condensed table-hover table-striped" id="addItem">
			<thead>
				<tr class="warning">
					<th><input type="checkbox" id="delall" onclick=ToCheckAll(this.form) value="checkbox"></th>
					<th>物品代码</th>
					<th>物品名称</th>
					<th>物品条码</th>
					<th>类别名称</th>
					<th>零售价</th>
					<th>最低售价</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<div align="center"><button class="btn btn-warning" type="button" onclick="queDing();">确定</button></div>
	</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function queDing(){
		var table = document.getElementById("addItem");
		var strlist="";
		for(var i=1;i<table.rows.length;i++){ 
            strlist+=table.rows[i].cells[1].innerHTML+",";
        }  
		javascript:window.location.href="${pageContext.request.contextPath }/purchase/addedPur.do?id="+110+"&strlist="+strlist;
	}
	function UnCheckAll(){
	    var boxs=document.getElementsByName("id");
		var str="";
		for (var i= 0; i< boxs.length; i++) {
			if(boxs[i].checked){
	            str+=boxs[i].value+",";
	         }   
		}
		document.getElementById("idlist").value=str;
	}
	
	function CheckAll(form){
		for (var i=0;i<form.elements.length;i++){
		    var e = form.elements[i];
			if (e.Name != "cheackall"){
			  	e.checked = form.cheackall.checked;
			}
		}
		var boxs=document.getElementsByName("id");
		var str="";
		for ( var i= 0; i< boxs.length; i++) {
			if(boxs[i].checked){
	            str+=boxs[i].value+",";
	         }   
		}
		document.getElementById("idlist").value=str;
	}
	
	function ToCheckAll(form){
		for (var i=0;i<form.elements.length;i++){
		    var e = form.elements[i];
			if (e.Name != "delall"){
			  	e.checked = form.delall.checked;
			}
		}
		var boxs=document.getElementsByName("id");
		var str="";
		for ( var i= 0; i< boxs.length; i++) {
			if(boxs[i].checked){
	            str+=boxs[i].value+",";
	         }   
		}
		document.getElementById("idlist1").value=str;
	}
	
	function addItem(){
		var idlist = document.getElementById("idlist").value;
		var arraylist = new Array(); 
		arraylist=idlist.split(",");
		var leng = arraylist.length-1;
		for (var i = 0; i < leng; i++) {
			if(parseInt(arraylist[i])==parseInt($("#id"+arraylist[i]).val())){
				//debugger;
				var tr = $('#tr'+arraylist[i]).html();
				$("#addItem tbody").prepend("<tr class='success' id='tr'>"+tr+"</tr>");
			}
		}
	}
	function delItem(){
		var idlist1 = document.getElementById("idlist1").value;
		var arraylist = new Array();
		arraylist=idlist1.split(",");
		var leng = arraylist.length-1;
		for (var i = 0; i < leng; i++) {
			if(parseInt(arraylist[i])==parseInt($("#id"+arraylist[i]).val())){
				//debugger;
				var tr = $('#tr'+arraylist[i]).html();
				$('#tr').remove();
			}
		}
	}
</script>
</html>