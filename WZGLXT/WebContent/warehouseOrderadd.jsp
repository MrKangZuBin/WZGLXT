<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript" language="javascript" src="jquery.js"></script>
<script type="text/javascript">
	//点击登录class为tc 显示
	function applyeds() {
		$("#gray").show();
		$("#caigou").show();//查找ID为popup的DIV show()显示#gray
		tc_center();
	}

	function guanbis() {
		$("#gray").hide();
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
	}
	
	function caigoudingdan(obj) {
		$("#"+obj).html("");
		purchaseorderid = obj;
		$.getJSON('../purchasrOrders/selectone.do?purchaseorderid='
				+ purchaseorderid, null, function(data) {
			$.each(data.pur_iif, function(i, item) {
				nowid[item.id] = item.id;
				nownumber[item.id] = item.number;

				var a = "<tr align='left' class='warning'><td>" + 11
						+ "</td><td>" + item.articleBarCode + "</td><td>"
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
</script>
<body>
	<div id="gray"></div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<br />
				<div id="purchaseOrder"></div>
				<form class="form-inline">
					<fieldset>
						<table class="table table-condensed table-hover table-striped"
							style="background: #edebec;">
							<tr>
								<td><label>入库单号</label> <input type="text"
									id="warehouseNumber" class="form-control select-lg"
									disabled="disabled" /></td>
								<td><label>供应商名称</label> <input type="text" id="supplierID"
									class="form-control select-lg" disabled="disabled" /></td>
								<td><label>仓库</label> <input type="text" id="warehouseName"
									class="form-control select-lg" disabled="disabled" /></td>
								<td><label>状态</label> <input type="text" id="status"
									class="form-control select-lg" disabled="disabled" /></td>
							</tr>
							<tr>
								<td><label>采购订单</label> <input type="text" id="address"
									class="form-control select-lg" disabled="disabled" /></td>
								<td><label>入库说明</label> <input type="text" id="company"
									class="form-control select-lg" disabled="disabled" /></td>
								<td><label>备注</label> <input type="text" id=""
									class="form-control select-lg" disabled="disabled" /></td>
								<td><label>采购人</label> <input type="text" id="buyerID"
									class="form-control select-lg" disabled="disabled" /></td>
							</tr>
						</table>
						<br />
						<div class="col-md-12 column" align="left">
							<div class="row clearfix">
								<table id="pcotable"
									class="table table-condensed table-hover table-striped">
									<tr class="success" align="center">
										<th>库位</th>
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
								<button class="btn btn-warning" type="button"
									onclick="applyeds();">编辑</button>
							</div>
						</div>
					</fieldset>
				</form>

				<br />
				<p>
				<form class="form-inline">
					<fieldset>
						<table class="table table-condensed table-hover table-striped">
							<tr align="center" style="background: #edebec;">
								<td><label>创建时间</label> <input type="text" id="createTime"
									class="form-control select-lg" disabled="disabled" /></td>
								<td><label>创建人</label> <input type="text"
									id="createPersonID" class="form-control select-lg"
									disabled="disabled" /></td>
								<td><label>最后修改时间</label> <input type="text"
									id="finalProcessingTime" class="form-control select-lg"
									disabled="disabled" /></td>
								<td><label>最后修改人</label> <input type="text"
									id="lastPersonID" class="form-control select-lg"
									disabled="disabled" /></td>
							</tr>
							<tr align="center" background="#FFFF00">
								<td colspan="4">
									<button class="btn btn-warning" type="button"
										onclick="queding('${userID}');">确定</button>
									<button class="btn btn-warning" type="button"
										onclick="guanbi();">关闭</button>
								</td>
							</tr>

						</table>
					</fieldset>
				</form>
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
										<tr ${(i.index+1)%2==0?"class='error'":"class='success'"} id="${pco.purchaseorderid }">
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
			</div>
		</div>
	</div>
</body>
</html>