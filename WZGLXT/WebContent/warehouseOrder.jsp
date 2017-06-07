<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购入库</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	var bool = false;
	var purchaseordereid;
	var purchaseorderid;
	var nownumber = new Array();
	var nowid = new Array();
	function notselected() {
		alert("请选中一行数据！");
	};

	function select(id) {
		$("#" + purchaseordereid).removeClass("danger");
		purchaseordereid = id;
		$("#" + purchaseordereid).addClass("danger");
		bool = true;

	}

	function Purchasing(id) {
		nownumber[id] = document.getElementById("nownumber" + id).value;
	}

	function caigoudingdan(obj) {
		$("#" + obj).html("");
		purchaseorderid = obj;
		$.getJSON('../purchasrOrders/selectone.do?purchaseorderid='
				+ purchaseorderid, null, function(data) {
			$.each(data.pur_iif, function(i, item) {
				nowid[item.id] = item.id;
				nownumber[item.id] = item.number;

				var a = "<tr align='left' class='warning'><td>"
						+ "<select id='wareid'><c:forEach items='${wm}' var='wm'><option value='${wm.warehousemanagementid}'>${wm.warehousename}</option></c:forEach></select></td><td>" + item.articleBarCode + "</td><td>"
						+ item.itemcode + "</td><td>" + item.chinesename
						+ "</td><td>" + 1 * item.purchaseSpecifications
						+ "</td><td>" + item.purchasingUnit + "</td><td>"
						+ item.latestPrice + "</td><td>" + item.number
						+ "</td><td><input type='text' id='nownumber" + item.id
						+ "' value='" + item.number + "' onchange='Purchasing("
						+ item.id + ")'/></td></tr>";
				$("#pcotable").append(a);

			});

			guanbis();
		});

	}

	function queding(id) {
		var company = document.getElementById("company").value;
		var reaks = document.getElementById("reaks").value;
		var wareid = document.getElementById("wareid").value;
		window.location.href = "../purchasrOrders/insertmany.do?nowid=" + nowid
				+ "&nownumber=" + nownumber + "&userid=" + id + "&company="
				+ company + "&reaks=" + reaks+ "&wareid=" + wareid;

	}

	function edit() {

		if (!bool) {
			notselected();
			return false;
		} else {
			getjson();
			applyed();
		}

	}

	//点击登录class为tc 显示
	function applyeds() {

		$("#caigou").show();//查找ID为popup的DIV show()显示#gray
		$("#popuporder").hide();
		tc_center();
	}

	function guanbis() {
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
		$("#popuporder").show();
	}

	//点击登录class为tc 显示
	function applyed(number) {
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

	//等待dom元素加载完毕.
	$(
			function() {
				$(".treebox .level1>a").click(
						function() {
							$(this).addClass('current') //给当前元素添加"current"样式
							.find('i').addClass('down') //小箭头向下样式
							.parent().next().slideDown('slow', 'easeOutQuad') //下一个元素显示
							.parent().siblings().children('a').removeClass(
									'current')//父元素的兄弟元素的子元素去除"current"样式
							.find('i').removeClass('down').parent().next()
									.slideUp('slow', 'easeOutQuad');//隐藏
							return false; //阻止默认时间
						});
			})
</script>
</head>
<body>
	<% List jurisdiction=(List)session.getAttribute("list");%>
	<div id="gray"></div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<form class="form-inline" action="selectByWhere.do" method="post">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>入库单号 </label> <input type="text"
									name="warenumber" class="form-control select-lg"
									value="${map['warehousenumber']}" /></td>
								<td><label>供应商代码</label> <input type="text"
									name="suppliercode" class="form-control select-lg"
									value="${map['suppliercode']}" /></td>
								<td><label>供应商名称</label> <input type="text"
									name="suppliername" class="form-control select-lg"
									value="${map['chinesename']}" /></td>
								<td><label>状态</label> <select name="status"
									class="form-control select-lg">
										<option></option>
										<option value="已确认"
											<c:if test="${map['companyTelephone']=='已确认'}">selected="selected"</c:if>>已确认</option>
										<option value="未确认"
											<c:if test="${map['companyTelephone']=='未确认'}">selected="selected"</c:if>>未确认</option>
								</select></td>
							</tr>

							<tr align="center">
								<td><label>采购单号</label> <input type="text"
									name="caigounumber" class="form-control select-lg"
									value="${map['address']}" /></td>
								<td><label>时间</label> <input type="text" name="starttime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
									value="${map['createtime']}" /></td>
								<td><label>至</label> <input type="text" name="endtime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
									value="${map['finalprocessingtime']}" /></td>
								<td><label>提交人</label> <select name="subname"
									class="form-control select-lg">
										<option></option>
										<c:forEach items="${user }" var="users">
											<option value="${users.userid }"
												<c:if test="${map['lastpersonid']==users.userid }">selected="selected"</c:if>>${users.loginname }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr align="center">
								<td><label>仓库</label> <input type="text"
									name="warehousename" class="form-control select-lg"
									value="${map['warehousemanagementid']}" /></td>
								<td><label>入库说明</label> <input type="text" name="waresay"
									class="form-control select-lg" value="${map['company']}" /></td>
								<td><input type="radio" name="wuliao"
									class="form-control select-lg" value="IMPA物料"
									<c:if test="${map['materialmaterial']=='IMPA物料'}">checked="checked"</c:if> />IMPA物料<input
									type="radio" id="wuliao" name="wuliao"
									class="form-control select-lg" value="普通物料"
									<c:if test="${map['materialmaterial']=='普通物料'}">checked="checked"</c:if> />普通物料</td>
								<td>
									<% if(jurisdiction.contains("11")){ %><button class="btn btn-warning" type="submit" >查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									<% if(jurisdiction.contains("10")){ %><button class="btn btn-warning" type="button" onclick="applyed();">新增</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>
								</td>
							</tr>
						</table>

					</fieldset>
				</form>
				<br />




				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<h3>采购入库单</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed table-hover table-striped"
								style="background: #edebec;">
								<tr>
									<td><label>入库说明</label> <input type="text" id="company"
										class="form-control select-lg" /></td>
									<td><label>备注</label> <input type="text" id="reaks"
										class="form-control select-lg" /></td>
									<td><label>采购人</label> <input type="text" id="buyerID"
										class="form-control select-lg" disabled="disabled"
										value="${userName}" /></td>
								</tr>
							</table>
							</fieldset>
							<fieldset>
								<div class="col-md-12 column" align="left">
									<div class="row clearfix">
										<table id="pcotable"
											class="table table-condensed table-hover table-striped"
											width="400px">
											<tr class="success" align="center">
												<th>入库仓库</th>
												<th>批次号</th>
												<th>物品编码</th>
												<th>物品名称</th>
												<th>规格</th>
												<th>单位</th>
												<th>进价</th>
												<th>采购数量</th>
												<th>入库数量</th>
											</tr>
										</table>
										<p align="center">
											<button class="btn btn-warning" type="button"
												onclick="applyeds();">选择物品</button>
											<button class="btn btn-warning" type="button"
												onclick="queding('${userID}');">提交</button>
											<button class="btn btn-warning" type="button"
												onclick="guanbi();">关闭</button>
										</p>
									</div>
								</div>
							</fieldset>
					</form>
					<br />
					<p>
						<a class="guanbi"></a>
				</div>

				<div id="caigou" class="popup" style="padding: 20px">
					<div class="top_nav">
						<a class="guanbi" onclick="guanbis();"></a>
					</div>
					<h3>采购订单列表</h3>
					<form class="form-inline">
						<fieldset>
							<div style="overflow: scroll; width: 100%; height: 250px">
								<table id="caigouleibiao"
									class="table table-condensed table-hover table-striped">
									<tr class="warning">
										<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th>单号</th>
										<th>采购说明</th>
										<th>品项数</th>
										<th>状态</th>
										<th>提交时间</th>
										<th>提交人</th>
									</tr>
									<c:forEach items="${pco }" var="pco" varStatus="i">
										<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}
											id="${pco.purchaseorderid }">
											<td><a
												href="javascript:caigoudingdan('${pco.purchaseorderid }');">选择</a></td>
											<td>${pco.ordernumber }</td>
											<td>${pco.remarks }</td>
											<td><c:forEach items="${pco_iif }" var="pco_iif">
													<c:if
														test="${pco.purchaseorderid==pco_iif.purchaseorderid }">${pco_iif.number }</c:if>
												</c:forEach></td>
											<td>${pco.status }</td>
											<td><fmt:formatDate value="${pco.createdate }"
													pattern="yyyy-MM-dd hh:mm:ss" /></td>
											<td><c:forEach items="${user }" var="user">
													<c:if test="${pco.submitterid==user.userid }">${user.loginname }</c:if>
												</c:forEach></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</fieldset>
					</form>

				</div>

				<table class="table table-condensed table-hover table-striped">
					<tr class="warning" align="center">
						<th align="center">序号</th>
						<th align="center">入库单号</th>
						<th align="center">采购单号</th>
						<th align="center">入库说明</th>
						<th align="center">供应商代码</th>
						<th align="center">供应商</th>
						<th align="center">仓库</th>
						<th align="center">品项数</th>
						<th align="center">状态</th>
						<th align="center">物料类型</th>
						<th align="center">提交时间</th>
						<th align="center">提交人</th>
					</tr>
					<c:forEach items="${who }" var="who" varStatus="i">
						<tr id="${who.purchaseordereid }"
							${(i.index+1)%2==0?"class='error'":"class='success'"}
							onclick="select('${who.purchaseordereid}');">
							<td align="center">${i.index+1 }</td>
							<td align="center">${who.warehousenumber }</td>
							<td align="center">${who.address }</td>
							<td align="center">${who.company }</td>
							<td align="center">${who.suppliercode }</td>
							<td align="center">${who.chinesename }</td>
							<td align="center">${who.warehousename }</td>
							<td align="center">${who.number }</td>
							<td align="center">${who.companytelephone }</td>
							<td align="center">${who.materialmaterial }</td>
							<td align="center"><fmt:formatDate
									value="${who.finalprocessingtime }"
									pattern="yyyy-MM-dd hh:mm:ss" /></td>
							<td align="center"><c:forEach items="${user }" var="us">
									<c:if test="${us.userid==who.lastpersonid }">${us.loginname }</c:if>
								</c:forEach></td>
						</tr>
					</c:forEach>
				</table>
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-2 column" style="padding-top: 20px">
							<h5>共${pagecount }条记录 &nbsp;当前${currpage }/${totalpage }页&nbsp;</h5>
						</div>
						<div class="col-md-5 column">
							<ul class="pagination">

								<li><a
									href="${pageContext.request.contextPath }/WarehouseOrder/selectByWhere.do?currpage=1&warenumber=${map['warehousenumber']}&suppliercode=${map['suppliercode']}&suppliername=${map['chinesename']}&status=${map['status']}&caigounumber=${map['address']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/WarehouseOrder/selectByWhere.do?currpage=${currpage-1 }&warenumber=${map['warehousenumber']}&suppliercode=${map['suppliercode']}&suppliername=${map['chinesename']}&status=${map['status']}&caigounumber=${map['address']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">上一页</a></li>

								<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/WarehouseOrder/selectByWhere.do?currpage=${i }&warenumber=${map['warehousenumber']}&suppliercode=${map['suppliercode']}&suppliername=${map['chinesename']}&status=${map['status']}&caigounumber=${map['address']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/WarehouseOrder/selectByWhere.do?currpage=${currpage+1 }&warenumber=${map['warehousenumber']}&suppliercode=${map['suppliercode']}&suppliername=${map['chinesename']}&status=${map['status']}&caigounumber=${map['address']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/WarehouseOrder/selectByWhere.do?currpage=${totalpage }&warenumber=${map['warehousenumber']}&suppliercode=${map['suppliercode']}&suppliername=${map['chinesename']}&status=${map['status']}&caigounumber=${map['address']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?warenumber=${map['warehousenumber']}&suppliercode=${map['suppliercode']}&suppliername=${map['chinesename']}&status=${map['status']}&caigounumber=${map['address']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}"
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
			</div>
		</div>
	</div>
</body>
</html>