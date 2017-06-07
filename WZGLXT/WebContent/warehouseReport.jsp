<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物品入库统计表</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<%
		List jurisdiction = (List) session.getAttribute("list");
	%>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<br />
				<div id="purchaseOrder">
					<form class="form-inline" action="selectcaigourukubaobiao.do"
						method="post">
						<fieldset>
							<table class="table table-condensed table-hover table-striped"
								style="background: #edebec; width: 100%">
								<tr>
									<td><label>物品代码</label> <input type="text" id=""
										name="itemcode" class="form-control select-lg"
										value="${maps['itemcode']}" /></td>
									<td><label>时间</label> <input type="text" id=""
										name="starttime" class="form-control select-lg"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										value="${maps['fristTime']}" /></td>
									<td><label>至</label> <input type="text" id=""
										name="endtime" class="form-control select-lg"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										value="${maps['secondTime']}" /></td>
								</tr>
								<tr>

									<td><label>物品名称</label> <input type="text" id=""
										name="itemname" class="form-control select-lg"
										value="${maps['itemname']}" /></td>
									<td><input type="radio" id="" name="rukuleixing"
										class="form-control select-lg" value="pt"
										<c:if test="${maps['rukuleixing']=='pt'}">checked="checked"</c:if> />
										普通入库<input type="radio" id="" name="rukuleixing"
										class="form-control select-lg" value="cg"
										<c:if test="${maps['rukuleixing']=='cg'}">checked="checked"</c:if> />采购入库</td>
									<td>
										<% if(jurisdiction.contains("29")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>
				<div>
					<c:if test="${ids==2 }">
						<table class="table table-condensed table-hover table-striped">
							<thead>
								<tr class="success">
									<th>物品代码</th>
									<th>物品条码</th>
									<th>物品名称</th>
									<th>供应商名称</th>
									<th>规格</th>
									<th>单位</th>
									<th>采购数量</th>
									<th>入库数量</th>
									<th>仓库</th>
									<th>库位</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${wor }" var="wor">
									<tr>
										<th scope="row">${wor.itemcode }</th>
										<td>${wor.articlebarcode }</td>
										<td>${wor.chinesename }</td>
										<td>${wor.suppname }</td>
										<td>1*${wor.purchasespecifications }</td>
										<td>${wor.purchasingunit }</td>
										<td>${wor.number }</td>
										<td>${wor.rknumber}</td>
										<td>${wor.warehousename }</td>
										<td>${wor.inventorylocationname}</td>
									</tr>
								</c:forEach>
						</table>
					</c:if>
					<c:if test="${ids==1 }">
						<table class="table table-condensed table-hover table-striped">
							<thead>
								<tr class="success">
									<th>物品代码</th>
									<th>物品条码</th>
									<th>物品名称</th>
									<th>规格</th>
									<th>单位</th>
									<th>入库数量</th>
									<th>仓库</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${gor }" var="gor">
									<tr>
										<th scope="row">${gor.itemcode }</th>
										<td>${gor.articlebarcode }</td>
										<td>${gor.chinesename }</td>
										<td>1*${gor.purchasespecifications }</td>
										<td>${gor.purchasingunit }</td>
										<td>${gor.rknumber}</td>
										<td>${gor.warehousename }</td>
									</tr>
								</c:forEach>
						</table>
					</c:if>
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-2 column" style="padding-top: 20px">
								<h5>共${pagecount }条记录 &nbsp;当前${currpage }/${totalpage }页&nbsp;</h5>
							</div>
							<div class="col-md-5 column">
								<ul class="pagination">

									<li><a
										href="${pageContext.request.contextPath }/WarehouseOrder/selectcaigourukubaobiao.do?currpage=1&itemcode=${maps['itemcode']}&itemname=${maps['itemname']}&starttime=${maps['starttime']}&endtime=${maps['endtime']}&rukuleixing=${maps['rukuleixing']}">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/WarehouseOrder/selectcaigourukubaobiao.do?currpage=${currpage-1 }&itemcode=${maps['itemcode']}&itemname=${maps['itemname']}&starttime=${maps['starttime']}&endtime=${maps['endtime']}&rukuleixing=${maps['rukuleixing']}">上一页</a></li>

									<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
										end="${currpage+2 }" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/WarehouseOrder/selectcaigourukubaobiao.do?currpage=${i }&itemcode=${maps['itemcode']}&itemname=${maps['itemname']}&starttime=${maps['starttime']}&endtime=${maps['endtime']}&rukuleixing=${maps['rukuleixing']}"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/WarehouseOrder/selectcaigourukubaobiao.do?currpage=${currpage+1 }&itemcode=${maps['itemcode']}&itemname=${maps['itemname']}&starttime=${maps['starttime']}&endtime=${maps['endtime']}&rukuleixing=${maps['rukuleixing']}">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/WarehouseOrder/selectcaigourukubaobiao.do?currpage=${totalpage }&itemcode=${maps['itemcode']}&itemname=${maps['itemname']}&starttime=${maps['starttime']}&endtime=${maps['endtime']}&rukuleixing=${maps['rukuleixing']}">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="selectcaigourukubaobiao.do?itemcode=${maps['itemcode']}&itemname=${maps['itemname']}&starttime=${maps['starttime']}&endtime=${maps['endtime']}&rukuleixing=${maps['rukuleixing']}"
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
	</div>
</body>
</html>