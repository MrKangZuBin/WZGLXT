<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="from"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购订单</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	//点击登录class为tc 显示
	function xiangqing(id,itemtype) {
		getjson(id,itemtype);
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
	function getjson(id,itemtype) {
		var iid=$("#iid").val();
		$.ajax({
			url:"${pageContext.request.contextPath }/purchase/selectPurOrderList.do?purchaseorderid="+id+"&itemtype="+itemtype,
			type:"post",
			datatType:"json",
			success:function(data){
				$.each(data.gList,function(i,item){
					$("#purOdernumber").val(item.orderNumber);
					$("#oderstatus").val(item.status);
					$("#createName").val(item.createName);
					$("#createdate").val(timeStamp2String(item.createDate));
					$("#billSource").val(item.billSource);
					$("#posttime").val(timeStamp2String(item.commitTime));
					$("#postname").val(item.commitName);
					$("#slipper").val(item.supplierName);
					$("#cang").val(item.warehouseName);
					$("#des").val(item.speaking);
					$("#beizhu").val(item.remarks);
					$("#lastdate").val(timeStamp2String(item.lastModifiedTime));
					$("#lastName").val(item.lastName);
					$("#Ptype").val(item.materialMaterial);
				if(iid==id){
					var a="<tr align='left' class='warning'><td></td><td>"+item.itemCode+"</td><td>"
					+item.chineseName+"</td><td>"+
					item.articleBarCode+"</td><td>"+
					item.purchaseSpecifications+"</td><td>"+
					item.purchasingUnit+"</td><td>"+item.number+"</td><td>"+
					(item.number)*(item.purchaseSpecifications)+"</td></tr>";
					$("#purtable").append(a);
				}
					});
				}
			});
	}
	function add(){
		getaddjson();
		toaddshow();
	}
	function getaddjson() {
		$.ajax({
			url:"${pageContext.request.contextPath }/purchase/selGroup.do",
			type:"post",
			datatType:"json",
			success:function(data){
				$("#add_Number").val(data.strs);
				$("#itemcode").val(data.itemCode);
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
	function selSupp(){
		$.ajax({
			url:"${pageContext.request.contextPath }/supplier/selSupplier.do?supplierName="+$("#supplierName").val(),
			type:"post",
			datatType:"json",
			success:function(data){
				$("#add_supplierCode").val(data.supplierCode);
				$("#add_contacts").val(data.Contacts);
				$("#add_contactsTelephone").val(data.contactsTelephone);
			}
		});
	}
	function load(){
		var ipid=$("#inpid").val();
		var inpid=$("#inputID").val();
		if(ipid==inpid){
			getaddjson();
			toaddshow();
		}
	}
	function updNum(id){
		var pation=$("#fication"+id).val();
		var number=$("#onumber"+id).val();
		var countNum=pation*number;
		$("#countNum"+id).val(countNum);
	}
	function formSubit(){
		var id=new Array();
		var num=new Array();
		var size=$("#size").val();
		for(var i=1;i<size;i++){
			id[i]=$("#intemID"+i).val();
			num[i]=$("#onumber"+i).val();
		}
		document.getElementById("hid").value="2";
		alert(document.getElementById("hid").value);
		if(document.getElementById("hid").value==2){
			document.frm.action="${pageContext.request.contextPath }/purchase/insert.do?hids="+2+"&id="+id+"&num="+num+"&size="+size; 
			$("#frm").submit();
		}
	}
	function Baocun(){
		var id=new Array();
		var num=new Array();
		var size=$("#size").val();
		for(var i=1;i<size;i++){
			id[i]=$("#intemID"+i).val();
			num[i]=$("#onumber"+i).val();
		}
		alert(id);
		alert(num);
		document.frm.action="${pageContext.request.contextPath }/purchase/insert.do?hids="+1+"&did="+id+"&num="+num+"&size="+size;
		$("#frm").submit();
	}
	function outPut(){
		var exect="";
		var num="";
		var size=$("#size").val();
		for(var i=1;i<size;i++){
			exect+=$("#intemID"+i).val()+",";
			num+=$("#onumber"+i).val()+",";
		}
		window.location.href="${pageContext.request.contextPath }/purchase/selectExect.do?exect="+exect+"&purID="+$("#add_Number").val()+"&num="+num;
	}
</script>
</head>
<style>
	.div1{
		float: left;
		height: 35px;
		background: #F0AD4E;
		width: 100px;
		position:relative;
	}
	.div2{
		margin-top:-25px;
		text-align:center;
		font-size:15px;
	}
	.inputstyle{
		width:100px;
		height:35px;
		opsition:absolute;
		backgroud:red;
		opacity:0; 
	}
</style>
<body onload="load();">
	<% List jurisdiction=(List)session.getAttribute("list");%>
	<div id="gray"></div>
	<div  style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div >
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<input type="hidden" value="${id }" id="inputID">
				<form class="form-inline" action="${pageContext.request.contextPath }/purchase/Mselect.do" method="POST">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>采购单号:</label><input name="orderNumber" type="text"
									class="form-control select-lg" /></td>
								<td colspan="2"><label>订单说明:</label><input type="text" name="speaking"
									class="form-control select-lg" /></td>
								<td><label>状态:</label><select name="status" class="form-control select-lg">
										<option></option>
										<option>--选择状态--</option>
										<option>未提交</option>
										<option>待提交</option>
										<option>已提交</option>
										<option>审核中</option>
										<option>审核成功</option>
								</select></td>
								<td></td>
							</tr>

							<tr align="center">
								<td><label>提交人:</label> <select name="commitName"
									class="form-control select-lg">
										<option></option>
										<option>--选择提交人--</option>
											<c:forEach items="${users }" var="user">
												<option>${user.loginname }</option>
											</c:forEach>
									</select></td>
								<td colspan="2"><label>时间:</label><input type="text" 
									name="createDate" class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>至
									<input type="text" name="commitTime" class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>物料类型:</label><select name="materialMaterial"
									class="form-control select-lg">
										<option></option>
										<option>--选择物料类型--</option>
										<option>IMPA物料</option>
										<option>普通物料</option>
									</select></td>	
								<td></td>
							</tr>		
							<tr align="center">	
								<td><label>供应商代码:</label><input type="text" 
									name="supplierCode" class="form-control select-lg"/></td>
								<td colspan="2"><label>供应商名称:</label><select name="supplierName"
									class="form-control select-lg">
										<option></option>
										<option>--选择供应商名称--</option>
										<c:forEach items="${suppliers }" var="sups">
											<option>${sups.chinesename }</option>
										</c:forEach>
									</select></td>							
								<td><label>大仓:</label><select name="warehouseName"
									class="form-control select-lg">
										<option></option>
										<option>--选择仓库--</option>
										<c:forEach items="${war }" var="wms">
											<option>${wms.warehousename }</option>
										</c:forEach>
									</select></td>
								<td>
									<% if(jurisdiction.contains("56")){ %><button class="btn btn-warning" type="submit" >查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									<% if(jurisdiction.contains("55")){ %><button class="btn btn-warning" type="button" onclick="add();">新增</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>
								</td>
							</tr>
						</table>
					</fieldset>
				</form>

				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<h3>新增采购订单</h3>
					<input type="hidden" value="110" id="inpid"/>
					<form id="frm" name="frm" class="form-inline" action="${pageContext.request.contextPath }/purchase/insert.do" method="post" enctype="multipart/form-data">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>采购订单号 </label> <input type="text" readonly="readonly"
										class="form-control select-lg" id="add_Number" name="ordernumber"/></td>
									<td><label>申请人</label> <input type="text"
										value="${userName }" class="form-control select-lg"
										readonly="readonly" name="createName"/></td>
									<td><label>订单来源:</label><input type="text" name="billsource" class="form-control select-lg"></td>
									<td><label>状态</label><input type="text" value="未提交" name="status"
										class="form-control select-lg"/></td>
								</tr>

								<tr align="center">
									<td><label>订单说明</label> <input type="text"
										class="form-control select-lg" name="speaking"/></td>
									<td><label>大仓:</label><select name="warehouseName"
									class="form-control select-lg">
										<option></option>
										<option>--选择仓库--</option>
										<c:forEach items="${war }" var="wms">
											<option>${wms.warehousename }</option>
										</c:forEach>
									</select></td>
									<td><label>备注</label> <input type="text"
										class="form-control select-lg" name="remarks"/></td>
									<td><label>物料类型:</label><select name="materialMaterial"
									class="form-control select-lg">
										<option></option>
										<option>--选择物料类型--</option>
										<option>IMPA物料</option>
										<option>普通物料</option>
									</select></td>	
								</tr>
								<tr><td><label>供应商名称:</label><select name="supplierName" id="supplierName" onchange="selSupp();"
									class="form-control select-lg">
										<option></option>
										<option>--选择供应商名称--</option>
										<c:forEach items="${suppliers }" var="sups">
											<option value="${sups.chinesename }">${sups.chinesename }</option>
										</c:forEach>
									</select></td>
									<td><label>供应商代码:</label><input type="text" id="add_supplierCode" class="form-control select-lg" disabled="disabled"></td>
									<td><label>供应商联系人:</label><input type="text" id="add_contacts" class="form-control select-lg" disabled="disabled"></td>
									<td><label>供应商联系电话:</label><input type="text" id="add_contactsTelephone" class="form-control select-lg" disabled="disabled"></td>
								</tr>
							</table>
							<table
								class="table table-condensed table-hover table-striped">
								<tr class="warning">
										<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th>物品代码</th>
										<th>物品名称</th>
										<th>物品条码</th>
										<th>规格</th>
										<th>单位</th>
										<th>数量</th>
										<th>总数量</th>
								</tr>
								<c:forEach items="${informations }" var="informations" varStatus="i">
								<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}>
									<td><input type="hidden" id="intemID${(i.index+1) }" value="${informations.inteminformationid }" name="intemInformationID"></td>
									<td>${informations.itemcode }</td>
									<td>${informations.chinesename }</td>
									<td>${informations.articlebarcode }</td>
									<td><input id="fication${(i.index+1)}" type="text" value="${informations.purchasespecifications }" style="width:100px"/></td>
									<td>${informations.purchasingunit }</td>
									<td><input type="text" value="1" name="number" id="onumber${(i.index+1) }" style="width:100px" onchange="updNum('${(i.index+1) }');"/></td>
									<td><input type="text" style="width:100px" id="countNum${(i.index+1) }"/></td>
								</tr>
								</c:forEach>
							</table>
							<table>
							<tr>
								<td>
									<input type="hidden" id="size" value="${size }" name="size"/>
									<button class="btn btn-warning" type="button" onclick="outPut();">导出模板</button>
									<a href="${pageContext.request.contextPath }/iteminfo/seltItem.do"><button class="btn btn-warning" type="button">导入物品</button></a>
								</td>
							</tr>
							<tr>
								<td><label>创建时间</label> <input type="text" name="createdate"
										class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>最后处理人</label> <input type="text" name="lastName" value="${userName }"
										class="form-control select-lg" readonly="readonly"/></td>
								<td><label>最后处理时间</label> <input type="text" name="lastmodifiedtime"
										class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								</tr>
							</table>
							<div align="center">
								<button class="btn btn-warning" type="button" onclick="Baocun();">保存</button>
								<button class="btn btn-warning" type="button" onclick="formSubit();">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbi();">关闭</button>
								<button class="btn btn-warning" type="button">删除</button>
							</div>
						</fieldset>
					</form>				
				</div>
				<div id="caigou" class="popup" style="padding: 20px">
					<div class="top_nav">
						<a class="guanbi" onclick="guanbis();"></a>
					</div>
					<h3>采购订单</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>订单单号 </label> <input type="text"
										id="purOdernumber" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>&nbsp;&nbsp;状态&nbsp;&nbsp;&nbsp;</label><input type="text" id="oderstatus"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>创建人</label> <input type="text"
										id="createName" class="form-control select-lg"
										disabled="disabled" /></td>
								</tr>
								<tr align="center">
									<td><label>单据来源</label> <input type="text" id="billSource"
										class="form-control select-lg" disabled="disabled"/></td>
									<td><label>提交时间</label><input type="text" id="posttime"
										class="form-control select-lg" disabled="disabled"/></td>
									<td><label>提交人</label><input type="text" id="postname"
										class="form-control select-lg" disabled="disabled"/></td>
								</tr>
								<tr align="center">
									<td colspan="2"><label>&nbsp;&nbsp;供应商</label> <input type="text" id="slipper"
										class="form-control" style="width:505px"/></td>
									<td><label>&nbsp;&nbsp;&nbsp;大仓</label> <input type="text" id="cang"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>
								<tr align="center">
									<td colspan="2"><label>&nbsp;&nbsp;说明&nbsp;&nbsp;</label> <input type="text" id="des"
										class="form-control select-lg" style="width:505px"/></td>
									<td><label>物料类型</label><input type="text" id="Ptype"
										class="form-control select-lg" disabled="disabled"/></td>
								</tr>
								<tr align="center">
									<td colspan="3"><label>&nbsp;&nbsp;备注&nbsp;&nbsp;</label> <input type="text" id="beizhu"
										class="form-control select-lg" style="width:805px"/></td>
								</tr>
							</table>
							<div style="overflow: scroll; width: 100%; height: 150px">
								<table id="purtable"
									class="table table-condensed table-hover table-striped">
									<tr class="warning">
										<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th>物品代码</th>
										<th>物品名称</th>
										<th>物品条码</th>
										<th>规格</th>
										<th>单位</th>
										<th>数量</th>
										<th>总数量</th>
									</tr>
								</table>
							</div>
								<table>
									<tr>
										<td colspan="9">
											<button class="btn btn-warning" type="button">编辑</button>
											<button class="btn btn-warning" type="button">删除行</button>
											<button class="btn btn-warning" type="button">导出模板</button>
											<button class="btn btn-warning" type="button" onclick="">导入物品</button>
										</td>
									</tr>
									<tr>
										<td><label>创建时间</label> <input type="text" id="createdate"
											class="form-control select-lg" /></td>
										<td><label>最后处理人</label> <input type="text" id="lastName"
											class="form-control select-lg" /></td>
										<td><label>最后处理时间</label> <input type="text" id="lastdate"
											class="form-control select-lg" /></td>
									</tr>
								</table>
							<div align="center">
								<button id="" class="btn btn-warning" type="button">保存</button>
								<button class="btn btn-warning" type="button" onclick="">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbis();">关闭</button>
								<button class="btn btn-warning" type="button">删除</button>
							</div>
						</fieldset>
					</form>
				</div>
				<br /> <br />
					<table class="table table-condensed table-hover table-striped">
						<thead>
							<tr class="warning">
								<th></th>
								<th></th>
								<th>序号</th>
								<th>采购单号</th>
								<th>采购说明</th>
								<th>品项数</th>
								<th>供应商名称</th>
								<th>物料类型</th>
								<th>状态</th>
								<th>提交时间</th>
								<th>提交人</th>
								<th>仓库</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${gList }" var="group" varStatus="i">
								<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}>
									<td></td>
									<td><input type="hidden" value="${group.purchaseOrderID}" id="iid"></td>
									<td>${i.index+1}</td>
									<td><a href="javascript:xiangqing('${group.purchaseOrderID}','${group.materialMaterial }');">
									${group.orderNumber}</a></td>
									<td>${group.speaking }</td>
									<td>${group.pNumber }</td>
									<td>${group.supplierName }</td>
									<td>${group.materialMaterial }</td>
									<td>${group.status }</td>
									<td><fmt:formatDate value="${group.commitTime }"
											pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td>${group.commitName }</td>
									<td>${group.warehouseName }</td>
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
										href="${pageContext.request.contextPath }/purchase/selectPurchase.do?currpage=1">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/purchase/selectPurchase.do?currpage=${currpage-1 }">上一页</a></li>

									<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
										end="${currpage+2 }" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${i }"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/purchase/selectPurchase.do?currpage=${currpage+1 }">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/purchase/selectPurchase.do?currpage=${totalpage }">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="pur/toaddPur.do" method="post">

									<input type="text" class="form-control" name="currpage"
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"
										value="${currpage }" />
									<button type="submit" class="btn btn-default">跳转</button>
								</form>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
</html>