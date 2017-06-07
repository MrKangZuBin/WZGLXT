<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购申请</title>
<jsp:include page="./header.jsp"></jsp:include>
<script type="text/javascript">
	var ids=new Array();
	//点击登录class为tc 显示
	function xiangqing(id) {
		getjson(id);
		toShow();
	}
	function toShow() {
		$("#caigou").show();//查找ID为popup的DIV show()显示#gray
		$("#gray").show();
		tc_center();
	}

	//点击关闭按钮
	$("a.guanbis").click(function() {
		$("#gray").hide();
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
	})
	function guanbis() {
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
		$("#gray").hide();
	}
	function timeStamp2String(time){
	    var datetime = new Date();
	    datetime.setTime(time);
	    var year = datetime.getFullYear();
	    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
	    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
	}
	//采购申请单详情
	function getjson(id) {
		var iid=$("#numbers").val();
		$.ajax({
			url:"${pageContext.request.contextPath }/pur/addpur.do?purchaserequisitionid="+id,
			type:"post",
			datatType:"json",
			success:function(data){
				$.each(data.pur,function(i,item){
				$("#purchaserequisitionid").val(item.purchaseRequisitionID);
				$("#applicationNo").val(item.applicationNo);
				$("#deptname").val(item.organizationName);
				$("#uname").val(item.commitName);
				$("#status").val(item.status);
				$("#des").val(item.explains);
				$("#getdate").val(timeStamp2String(item.lastProcessingTime));
				$("#createdate").val(timeStamp2String(item.createdate));
				$("#Ckname").val(item.warehouseName);
				$("#beizhu").val(item.remarks);
				$("#lastName").val(item.lastName);
				if(item.materialMaterial=="普通物料"){
					$("#pwuliao").attr("checked",true);
				}
				if(item.materialMaterial=="IMPA物料"){
					$("#wuliao").attr("checked",true);
				}
				if(iid==id){
					var a="<tr align='left' class='warning'><td></td><td>"+item.itemCode+"</td><td>"
					+item.chineseName+"</td><td>"+
					item.articleBarCode+"</td><td>"+
					item.purchaseSpecifications+"</td><td>"+
					item.purchasingUnit+"</td><td>"+item.number+"</td><td>"+
					item.currentStock+"</td></tr>";
					$("#purtable").append(a);
				}	
			});
		}
	});
}
	function outPut(){
		var exect="";
		var num="";
		var size=$("#size").val();
		for(var i=1;i<size;i++){
			exect+=$("#intemID"+i).val()+",";
			num+=$("#num"+i).val()+",";
		}
		window.location.href="${pageContext.request.contextPath }/pur/selectExect.do?exect="+exect+"&purID="+$("#purID").val()+"&num="+num;
	}
	function add(userID){
		getaddjson(userID);
		toaddshow();
	}
	function getaddjson(userID) {
		$.ajax({
			url:"${pageContext.request.contextPath }/pur/selpurchase.do?userID="+userID,
			type:"post",
			datatType:"json",
			success:function(data){
				$("#purID").val(data.strs);
				$("#oname").val(data.orgName);
				$.each(data.wmList,function(i,item){
					var option="<option>"+item.warehousename+"</option>";
					$("#wname").append(option);
				});
			}
		});
	}
	function toaddshow() {
		$("#gray").show();
		$("#popuporder").show();//查找ID为popup的DIV show()显示#gray
		tc_center();
	}

	//点击关闭按钮
	$("a.guanbi").click(function() {
		$("#gray").hide();
		$("#popuporder").hide();//查找ID为popup的DIV hide()隐藏
	})

	function guanbi() {
		$("#gray").hide();
		$("#popuporder").hide();//查找ID为popup的DIV hide()隐藏
	}
	function save(){
		window.location.href="${pageContext.request.contextPath }/pur/updStatus.do?purchaserequisitionid="+$("#purchaserequisitionid").val();
	}
	function submitSave(){
		window.location.href="${pageContext.request.contextPath }/pur/submitStatus.do?purchaserequisitionid="+$("#purchaserequisitionid").val();
	}
	function load(userID){
		var ipid=$("#inpid").val();
		var inpid=$("#inputID").val();
		if(ipid==inpid){
			getaddjson(userID);
			toaddshow();
		}
	}
	function formSubit(){
		var id=new Array();
		var num=new Array();
		var size=$("#size").val();
		for(var i=1;i<size;i++){
			id[i]=$("#intemID"+i).val();
			num[i]=$("#num"+i).val();
		}
		document.getElementById("hid").value="2";
		alert(document.getElementById("hid").value);
		if(document.getElementById("hid").value==2){
			document.frm.action="${pageContext.request.contextPath }/pur/insert.do?hids="+2+"&id="+id+"&number="+num+"&size="+size; 
			$("#frm").submit();
		}
	}
	function Baocun(){
		var id=new Array();
		var num=new Array();
		var size=$("#size").val();
		for(var i=1;i<size;i++){
			id[i]=$("#intemID"+i).val();
			num[i]=$("#num"+i).val();
		}
		document.frm.action="${pageContext.request.contextPath }/pur/insert.do?hids="+1+"&id="+id+"&num="+num+"&size="+size;
		$("#frm").submit();
	}
</script>
</head>
<style>
	.checkbox {
		 width: 30px;
		 height: 55px;
		 padding: 0 5px 0 0;
	}
</style>
<body onload="load('${userID}');">
	<% List jurisdiction=(List)session.getAttribute("list");%>
	<div id="gray"></div>
	<div  style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div >
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<input type="hidden" value="${id }" id="inputID">
				<form class="form-inline" action="${pageContext.request.contextPath }/pur/fselectpur.do" method="POST">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>申请单号: </label> <input name="applicationNo" type="text"
									class="form-control select-lg" /></td>
								<td colspan="2"><label>时间:</label> <input type="text" name="createdate"
									class="form-control select-lg"  /><label>至</label> <input
									type="text" name="lastDate" class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>提交人:</label> <select name="commitName"
									class="form-control select-lg">
										<option></option>
										<option>--选择提交人--</option>
										<c:forEach items="${user }" var="users">
											<option>${users.loginname }</option>
										</c:forEach>
								</select></td>
								<td><label>部门:</label> <select name="organizationName"
									class="form-control select-lg">
										<option></option>
										<option>--选择部门--</option>
										<c:forEach items="${org }" var="org">
											<option>${org.organizationname }</option>
										</c:forEach>
								</select></td>
							</tr>

							<tr align="center">
								<td><label>采购说明:</label> <input type="text" name="explains"
									class="form-control select-lg" /></td>
								<td><label>状态:</label> <select name="status"
									class="form-control select-lg">
										<option></option>
										<option>--选择状态--</option>
										<option>未提交</option>
										<option>待提交</option>
										<option>已提交</option>
										<option>审核中</option>
										<option>审核通过</option>
								</select> <input type="radio" name="materialMaterial" class="form-control select-lg"
										 value="IMPA物料"/>IMPA物料<input type="radio" name="materialMaterial"
									class="form-control select-lg" value="普通物料"/>普通物料</td>
								<td colspan="2">
									<% if(jurisdiction.contains("50")){ %><button class="btn btn-warning" type="submit" >查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									<% if(jurisdiction.contains("51")){ %><button id="addpurchaseRequisition" class="btn btn-warning" type="button" onclick="add('${userID}');">新增</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>
								</td>
							</tr>
						</table>
					</fieldset>
				</form>

				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<h3>采购申请单</h3>
					<form id="frm" name="frm" class="form-inline" method="post" action="">
						<input type="hidden" value="0" id="hid"/>
						<fieldset>
							<table>
								<tr align="center">
									<td><label>采购单号 </label><input type="text" id="purID" name="applicationNo"
										class="form-control select-lg"  /></td>
									<td><label>申请人</label> <input type="text" name="commitName"
										value="${userName }" class="form-control select-lg"
										readonly="readonly" /></td>
									<td><label>部门</label> <input type="text" id="oname" name="organizationName"
										class="form-control select-lg" readonly="readonly" /></td>
									<td><label>状态</label><input type="text" value="未提交" name="status"
										class="form-control select-lg" readonly="readonly" /></td>
								</tr>

								<tr align="center">
									<td><label>申请说明</label> <input type="text" name="explains"
										id="purexplains" class="form-control select-lg" /></td>
									<td><label>大仓</label> <select id="wname" name="warehouseName"
									class="form-control select-lg"></select></td>
									<td><label>备注</label> <input type="text" id="remarks"
										class="form-control select-lg" name="remarks"/></td>
									<td><input type="radio" name="materialMaterial"
										class="form-control select-lg" value="IMPA物料"
										checked="checked"  />IMPA物料<input
										type="radio" class="form-control select-lg"
										value="普通物品" name="materialMaterial"/>普通物品</td>
								</tr>
							</table>
							<table class="table table-condensed table-hover table-striped">
								<tr class="warning">
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>物品代码</th>
									<th>物品名称</th>
									<th>物品条码</th>
									<th>规格</th>
									<th>单位</th>
									<th>数量</th>
									<th>库存</th>
								</tr>
								<c:forEach items="${informations }" var="informations" varStatus="i">
								<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}>
									<td><input type="hidden" id="intemID${(i.index+1) }" value="${informations.inteminformationid }" name="intemInformationID"></td>
									<td>${informations.itemcode }</td>
									<td>${informations.chinesename }</td>
									<td>${informations.articlebarcode }</td>
									<td>${informations.purchasespecifications }</td>
									<td>${informations.purchasingunit }</td>
									<td><input type="text" value="0" name="num" id="num${(i.index+1) }"></td>
									<td>${informations.currentstock }</td>
								</tr>
								</c:forEach>
							</table>
							<div align="left">
								<input type="hidden" id="size" value="${size }" name="size"/>
								<button class="btn btn-warning" type="button" onclick="outPut();">导出模板</button>
								<a href="${pageContext.request.contextPath }/iteminfo/selItem.do"><button class="btn btn-warning" type="button">导入物品</button></a>
							</div>
							<div>
								<label>创建时间</label><input type="text" name="createdate"
									class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
								<label>最后处理人</label> <input type="text" name="lastName"
									class="form-control select-lg" />
								<label>最后处理时间</label> <input type="text" name="lastDate"
									class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
							</div>
							<div align="center">
								<button class="btn btn-warning" type="button" onclick="Baocun();">保存</button>
								<button class="btn btn-warning" type="button" onclick="formSubit();">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbis();">关闭</button>
							</div>
						</fieldset>
					</form>
				</div>
				<div id="caigou" class="popup" style="padding: 20px">
					<div class="top_nav">
						<a class="guanbi" onclick="guanbis();"></a>
					</div>
					<input type="hidden" value="110" id="inpid"/>
					<h3>采购申请单</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>采购单号 </label><input type="hidden" id="purchaserequisitionid"> <input type="text"
										id="applicationNo" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>申请人</label> <input type="text"
										id="uname" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>部门</label> <input type="text" id="deptname"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>状态</label><input type="text" id="status"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>

								<tr align="center">
									<td><label>申请说明</label> <input type="text" id="des"
										class="form-control select-lg" /></td>
									<td><label>大仓</label> <input type="text" id="Ckname"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>备注</label> <input type="text" id="beizhu"
										class="form-control select-lg" /></td>
									<td><input type="radio" id="wuliao" 
										class="form-control select-lg" value="IMPA物料"/>IMPA物料<input
										type="radio" id="pwuliao" class="form-control select-lg"
										value="普通物料"/>普通物料</td>
								</tr>
							</table>
							<div style="overflow: scroll; width: 100%; height: 150px">
							<table id="purtable" class="table table-condensed table-hover table-striped">
								<tr class="warning">
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>物品代码</th>
									<th>物品名称</th>
									<th>物品条码</th>
									<th>规格</th>
									<th>单位</th>
									<th>数量</th>
									<th>库存</th>
								</tr>
							</table>
							</div>
							<div align="left">
								<button class="btn btn-warning" type="button">导出模板</button>
								<a href="${pageContext.request.contextPath }/"><button class="btn btn-warning" type="button">导入物品</button></a>
							</div>
							<div>
								<label>创建时间</label><input type="text" id="createdate"
									class="form-control select-lg" />
								<label>最后处理人</label> <input type="text" id="lastName"
									class="form-control select-lg" />
								<label>最后处理时间</label> <input type="text" id="getdate"
									class="form-control select-lg" />
							</div>
							<div align="center">
								<button class="btn btn-warning" type="button">复制</button>
								<button class="btn btn-warning" type="button" onclick="save();">保存</button>
								<button class="btn btn-warning" type="button" onclick="submitSave();">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbis();">关闭</button>
							</div>
						</fieldset>
					</form>
				</div>
				<br /> <br />
				<c:if test="${PurchaseOrderlist!='[]' }">
					<table class="table table-condensed table-hover table-striped">
						<thead>
							<tr class="warning">
								<th></th>
								<th></th>
								<th>申请单号</th>
								<th>申请说明</th>
								<th>品项数</th>
								<th>物料类型</th>
								<th>状态</th>
								<th>提交时间</th>
								<th>提交人</th>
								<th>部门</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pr }" var="pr" varStatus="i">
								<tr id="${pr.purchaseRequisitionID }"
									${(i.index+1)%2==0?"class='error'":"class='success'"}
									onclick="select('${pr.purchaseRequisitionID}');">
									<td></td>
									<td><input type="hidden" id="numbers"
										value="${pr.purchaseRequisitionID}" /></td>
									<td><a href="javascript:xiangqing('${pr.purchaseRequisitionID}');">${pr.applicationNo}</a></td>
									<td>${pr.explains }</td>
									<td>${pr.pNumber }</td>
									<td>${pr.materialMaterial }</td>
									<td>${pr.status }</td>
									<td><fmt:formatDate value="${pr.lastProcessingTime }"
											pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td>
										${pr.commitName }
									</td>
									<td>${pr.organizationName }</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-2 column" style="padding-top: 20px">
								<h5>共${pagecount }条记录 &nbsp;当前${currpage }/${totalpage }页&nbsp;</h5>
							</div>
							<div class="col-md-5 column">
								<ul class="pagination">

									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=1">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${currpage-1 }">上一页</a></li>

									<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
										end="${currpage+2 }" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${i }"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${currpage+1 }">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${totalpage }">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="${pageContext.request.contextPath }/pur/toaddPur.do" method="post">

									<input type="text" class="form-control" name="currpage"
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"
										value="${currpage }" />
									<button type="submit" class="btn btn-default">跳转</button>
								</form>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${PurchaseOrderlist=='[]' }">
							抱歉暂无数据
						</c:if>
			</div>
		</div>
	</div>
</body>
</html>