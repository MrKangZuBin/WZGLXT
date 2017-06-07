<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>库存预警</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--web-fonts-->
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700'
	rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<script
	src="${pageContext.request.contextPath }/My97DatePickers/WdatePicker.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<h3 class="b-tittle" style="color: #00ccff">库存预警</h3>
				<form class="form-inline"
					action="${pageContext.request.contextPath }/iteminfo/inventoryIteminfo.do">
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputendtime1">物品代码</label> <input
									class="form-control select-lg" type="text" name="itemcode_o"
									value="${itemcode}" /></td>
								<td colspan="3"><label for="exampleInputendtime1">物品名称</label>
									<input class="form-control select-lg" type="text"
									name="itemname_o" value="${itemname}" /></td>
								<td><label for="exampleInputendtime1">预警类型</label> <select
									name="warningtype_o" class="form-control select-lg">
										<option value="">选择预警类型</option>
										<option value="库存不足" ${warningtype=="库存不足"?"selected":""}>库存不足</option>
										<option value="库存过多" ${warningtype=="库存过多"?"selected":""}>库存过多</option>
								</select></td>
								<td><label for="exampleInputendtime1">物料类型</label> <select
									name="itemmaterial_o" class="form-control select-lg">
										<option value="">选择物料类型</option>
										<option value="普通物料" ${itemmaterial=="普通物料"?"selected":""}>普通物料</option>
										<option value="IMPA物料"
											${itemmaterial=="IMPA物料"?"selected":""}>IMPA物料</option>
								</select></td>
								<td>
									<button type="submit" class="btn btn-defult btn-info"
										style="vertical-align: bottom;">查询</button>
								</td>
							</tr>
						</thead>
					</table>
				</form>
				<c:choose>
					<c:when test="${list!='[]'}">
						<div style="overflow-y: auto; width: 100%; height: 360px">
							<table class="table table-hover table-bordered "
								style="margin-top: 10px">
								<thead>
									<tr class="info">
										<th>序号</th>
										<th>物品代码</th>
										<th>物品名称</th>
										<th>物品条码</th>
										<th>物料类型</th>
										<th>库存上限</th>
										<th>库存下限</th>
										<th>当前库存</th>
										<th>预警类型</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="inventoryIteminfo"
										varStatus="i">
										<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}>
											<td>${i.index+1}</td>
											<td>${inventoryIteminfo.itemcode}</td>
											<td>${inventoryIteminfo.chinesename}</td>
											<td>${inventoryIteminfo.articlebarcode}</td>
											<td>${inventoryIteminfo.materialmaterial}</td>
											<td>${inventoryIteminfo.maxstock}</td>
											<td>${inventoryIteminfo.minstock}</td>
											<td>${inventoryIteminfo.currentstock}</td>
											<td><font
												${inventoryIteminfo.warningtype=="库存过多"?"color='green'":"color='red'"}>${inventoryIteminfo.warningtype}</font>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
					<c:otherwise>
						<br>
						<br>
						<br>
						<div class="container-fluid">
							<div class="row-fluid">
								<div class="span12">
									<div class="alert alert-info">
										<h3 align="center">抱歉，暂无数据！</h3>
									</div>
								</div>
							</div>
						</div>

					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>