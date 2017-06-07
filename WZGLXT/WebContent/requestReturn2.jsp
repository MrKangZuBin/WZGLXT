<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工作台-退货处理</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body onload="load();">
	<% List jurisdiction=(List)session.getAttribute("list");%>
	<div id="gray"></div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<input type="hidden" value="${id }" id="inputID">
				<form class="form-inline"
					action="${pageContext.request.contextPath }/return/selByCriteria.do"
					method="POST">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>退货单号: </label> <input name="applicationNo"
									type="text" class="form-control select-lg" /></td>
								<td colspan="2"><label>时间:</label> <input type="text"
									name="createDate" class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /><label>至</label>
									<input type="text" name="lastModifiedTime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
								<td><label>提交人:</label> <select name="commitName"
									class="form-control select-lg">
										<option></option>
										<option>--选择提交人--</option>
										<c:forEach items="${user }" var="user">
											<option>${user.loginname }</option>
										</c:forEach>
								</select></td>
								<td><label>状态:</label> <select name="status"
									class="form-control select-lg">
										<option></option>
										<option>--选择状态--</option>
										<option>未提交</option>
										<option>待提交</option>
										<option>已提交</option>
										<option>审核中</option>
										<option>审核通过</option>
								</select></td>
							</tr>

							<tr align="center">
								<td><label>退货说明:</label> <input type="text"
									name="returnPolicy" class="form-control select-lg" /></td>
								<td><input type="radio" name="materialMaterial"
									class="form-control select-lg" value="IMPA物料" />IMPA物料<input
									type="radio" name="materialMaterial"
									class="form-control select-lg" value="普通物料" />普通物料</td>
								<td colspan="2">
									<% if(jurisdiction.contains("62")){ %><button class="btn btn-warning" type="submit" >查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									<% if(jurisdiction.contains("59")){ %><button class="btn btn-warning" type="button" onclick="add();">新增</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>
								</td>
							</tr>
						</table>
					</fieldset>
				</form>

				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<input type="hidden" value="110" id="inpid"/>
					<h3>退货申请单</h3>
					<form id="frm" name="frm" class="form-inline" action="${pageContext.request.contextPath }/return/insert.do" method="post">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>退货单号 </label> <input type="text" id="returnID"
										class="form-control select-lg" readonly="readonly" name="applicationno"/></td>
									<td><label>创建人</label> <input type="text"
										class="form-control select-lg"readonly="readonly"
										value="${userName }" name="createName"/></td>
									<td><label>状态</label><input type="text" value="未提交"
										class="form-control select-lg" readonly="readonly" name="status"/></td>
								</tr>

								<tr align="center">
									<td><label>退货说明</label> <input type="text"
										class="form-control select-lg" name="returnpolicy"/></td>
									<td><label>大仓</label> <select name="warehouseName"
									class="form-control select-lg">
										<option></option>
										<option>--选择仓库--</option>
										<c:forEach items="${war }" var="wms">
											<option>${wms.warehousename }</option>
										</c:forEach>
									</select></td>
									<td><label>备注</label> <input type="text"
										class="form-control select-lg" name="remarks"/></td>
									<td><input type="radio" class="form-control select-lg"
										name="materialMaterial" />IMPA物料 <input type="radio"
										class="form-control select-lg" name="materialMaterial" />普通物品</td>
								</tr>
							</table>
							<table id="caigouleibiao" class="table table-condensed table-hover table-striped">
								<tr class="warning">
									<th></th>
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
									<td><input id="fication${(i.index+1) }" type="text" value="${informations.purchasespecifications }" style="width:100px"/></td>
									<td>${informations.purchasingunit }</td>
									<td><input type="text" name="number" id="onumber${(i.index+1) }" style="width:100px" onchange="updNum('${(i.index+1) }');"/></td>
									<td><input type="text" style="width:100px" id="countNum${(i.index+1) }"/></td>
								</tr>
								</c:forEach>
							<tr>
							</table>
							<table>
							<tr>
								<td>
									<input type="hidden" id="size" value="${size }" name="size"/>
									<button class="btn btn-warning" type="button" onclick="outPut();">导出模板</button>
									<a href="${pageContext.request.contextPath }/iteminfo/addItem.do"><button
										class="btn btn-warning" type="button">导入物品</button></a>
								</td>
							</tr>
							<tr>
								<td><label>创建时间</label> <input type="text" id=""
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="createdate"/></td>
								<td><label>最后处理人</label> <input type="text"
									value="${userName }" class="form-control select-lg" name="lastUpdateName"/></td>
								<td><label>最后处理时间</label> <input type="text" id=""
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="lastmodifiedtime"/></td>
							</tr>
							</table>
							<div>
								<button class="btn btn-warning" type="button" onclick="Baocun();">保存</button>
								<button class="btn btn-warning" type="button" onclick="formSubit();">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbis();">关闭</button>
								<button class="btn btn-warning" type="submit">删除</button>
							</div>
						</fieldset>
					</form>
				</div>
				<div id="caigou" class="popup" style="padding: 20px">
					<div class="top_nav">
						<a class="guanbi" onclick="guanbis();"></a>
					</div>
					<h3>退货申请单</h3>
					<form class="form-inline" method="POST">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>退货单号 </label><input type="hidden"
										id="returnRequestID" /> <input type="text" id="applicationNo"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>创建人</label> <input type="text" id="uname"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>状态&nbsp;&nbsp;&nbsp;&nbsp;</label><input
										type="text" id="status" class="form-control select-lg"
										disabled="disabled" /></td>
								</tr>

								<tr align="center">
									<td><label>提交时间</label> <input type="text" id="commitTime"
										class="form-control select-lg" /></td>
									<td><label>大仓&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
										type="text" id="cangK" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>提交人</label> <input type="text" id="commitName"
										class="form-control select-lg" /></td>
								</tr>
								<tr align="center">
									<td colspan="2"><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明&nbsp;&nbsp;&nbsp;</label>
										<input type="text" id="des" class="form-control select-lg"
										style="width: 500px" /></td>
									<td><input type="radio" id="impawuliao"
										class="form-control select-lg" value="IMPA物料"
										checked="checked" disabled="disabled" />IMPA物料<input
										type="radio" id="wuliao" class="form-control select-lg"
										value="普通物品" disabled="disabled" />普通物品</td>
								</tr>
								<tr align="center">
									<td colspan="3"><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注&nbsp;&nbsp;&nbsp;</label>
										<input type="text" id="beizhu" value="未备注"
										class="form-control select-lg" style="width: 780px" /></td>
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
										<button class="btn btn-warning" type="button">导出模板</button>
										<button class="btn btn-warning" type="button">删除行</button>
										<button class="btn btn-warning" type="button" onclick="">导入物品</button>
									</td>
								</tr>
								<tr>
									<td><label>创建时间</label> <input type="text" id="createdate"
										class="form-control select-lg" /></td>
									<td><label>最后处理人</label> <input type="text"
										id="lastgetName" class="form-control select-lg" /></td>
									<td><label>最后处理时间</label><input type="text" id="getdate"
										class="form-control select-lg" /></td>
								</tr>
							</table>
							<div align="center">
								<button class="btn btn-warning" type="button" onclick="subs();">保存</button>
								<button class="btn btn-warning" type="button"
									onclick="subupd();">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbis();">关闭</button>
								<button class="btn btn-warning" type="submit">删除</button>
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
								<th>退货单号</th>
								<th>退货说明</th>
								<th>品项数</th>
								<th>物料类型</th>
								<th>状态</th>
								<th>提交时间</th>
								<th>提交人</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${rp }" var="rp" varStatus="i">
								<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}>
									<td><input type="hidden" value="${rp.returnRequestID }" id="iid"></td>
									<td>${i.index+1 }</td>
									<td><a
										href="javascript:xiangqing('${rp.returnRequestID }','${rp.materialMaterial }');">${rp.applicationNo }</a></td>
									<td>${rp.returnPolicy }</td>
									<td>${rp.pNumber }</td>
									<td>${rp.materialMaterial }</td>
									<td>${rp.status }</td>
									<td><fmt:formatDate value="${rp.commitTime  }"
											pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td>${rp.commitName }</td>
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
										href="${pageContext.request.contextPath }/return/returnRequest.do?currpage=1">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/return/returnRequest.do?currpage=${currpage-1 }">上一页</a></li>

									<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
										end="${currpage+2 }" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/return/returnRequest.do?currpage=${i }"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/return/returnRequest.do?currpage=${currpage+1 }">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/return/returnRequest.do?currpage=${totalpage }">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="${pageContext.request.contextPath }/return/returnRequest.do"
									method="post">

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
<script type="text/javascript">
	//点击登录class为tc 显示
	function xiangqing(id,itemType) {
		getjson(id,itemType);
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
	//退货申请单详情
	function getjson(id,itemType) {
		$.ajax({
			url:"${pageContext.request.contextPath}/return/selectById.do?returnRequestID="+id+"&itemType="+itemType,
			type:"post",
			datatType:"json",
			success:function(data){
			$.each(data.rp,function(i,item){
				$("#returnRequestID").val(item.returnRequestID);
				$("#applicationNo").val(item.applicationNo);
				$("#uname").val(item.createName);
				$("#status").val(item.status);
				$("#cangK").val(item.warehouseName);
				$("#commitTime").val(timeStamp2String(item.commitTime));
				$("#commitName").val(item.commitName);
				$("#des").val(item.returnPolicy);
				$("#createdate").val(timeStamp2String(item.createDate));
				$("#lastgetName").val(item.lastUpdateName);
				$("#getdate").val(timeStamp2String(item.lastModifiedTime));
				if(item.materialMaterial=="普通物料"){
					$("#pwuliao").attr("checked",true);
				}
				if(item.materialMaterial=="IMPA物料"){
					$("#wuliao").attr("checked",true);
				}
				if(iid==id){
					a="<tr align='left' class='warning'><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>"+item.itemcode+"</td><td>"
					+item.chineseName+"</td><td>"+
					item.articlebarcode+"</td><td>"+
					item.purchasespecifications+"</td><td>"+
					item.purchasingunit+"</td><td><input type='text' value='"+item.number+"'></td><td>"+(item.number)*(item.purchasespecifications)+"</td></tr>";
					$("#purtable").append(a);
				}
				});
			}
		});
	}
	function add(){
		getaddjson();
		toaddshow();
		confirm();
	}
	function confirm(){
		alert("添加物品");
		window.location.href="${pageContext.request.contextPath }/iteminfo/selrItem.do";
	}
	function getaddjson() {
		$.ajax({
			url:"${pageContext.request.contextPath}/return/selRequest.do",
			type:"post",
			datatType:"json",
			success:function(data){
				$("#returnID").val(data.strs);
				$("#itemcode").val(data.itemCode);
			}
		});
	}
	function toaddshow() {
		$("#gray").show();
		$("#popuporder").show();//查找ID为popup的DIV show()显示#gray
		tc_center();
	}
	function load(){
		var ipid=$("#inpid").val();
		var inpid=$("#inputID").val();
		if(ipid==inpid){
			getaddjson();
			toaddshow();
		}
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
	function subs(){
		window.location.href="${pageContext.request.contextPath }/return/updStatus.do?returnRequestID="+$("#returnRequestID").val();
	}
	function subupd(){
		window.location.href="${pageContext.request.contextPath }/return/submitStatus.do?returnRequestID="+$("#returnRequestID").val();
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
			document.frm.action="${pageContext.request.contextPath }/return/insert.do?hids="+2+"&did="+id+"&num="+num+"&size="+size; 
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
		document.frm.action="${pageContext.request.contextPath }/return/insert.do?hids="+1+"&did="+id+"&num="+num+"&size="+size;
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
		window.location.href="${pageContext.request.contextPath }/return/selectExect.do?exect="+exect+"&purID="+$("#returnID").val()+"&num="+num;
	}
</script>
</html>