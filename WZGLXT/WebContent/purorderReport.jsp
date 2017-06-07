<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>物品采购统计表</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<%
		List jurisdiction = (List) session.getAttribute("list");
	%>
	<div  style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div >
				<br />
				<div id="purchaseOrder">
				<form class="form-inline" action="wupingcaigoubaobiao.do"
					method="post">
					<fieldset>
					<table class="table table-condensed table-hover table-striped" style="background: #edebec; width: 100%">
						<tr>
								<td><label>时间</label> <input type="text" id=""
									name="starttime" class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map['fristTime']}"/></td>
								<td><label>至</label> <input type="text" id=""
									name="endtime" class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map['secondTime']}"/></td>
								<td><label>状态</label>
									<select name="status" class="form-control select-lg">
										<option></option>
										<option value="未提交"  <c:if test="${map['status'=='未提交']}">selected="selected"</c:if>>未提交</option>
										<option value="已提交" <c:if test="${map['status'=='已提交']}">selected="selected"</c:if>>已提交</option>
									</select>
									</td>
								<td>
									<% if(jurisdiction.contains("28")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
								</td>
						</tr>
					</table>
				</fieldset>
				</form>
				</div>
				<div >
					<c:forEach items="${pco }" var="pco">
					<table class="table table-condensed table-hover table-striped"  border="2px">
						<thead>
							<tr class="success">
								<th>单号</th>
								<th colspan="2">采购说明</th>
								<th colspan="2">采购金额</th>
								<th colspan="2">采购状态</th>
							</tr>
						</thead>
						<thead>
							<tr>
								<td>${pco.ordernumber}</td>
								<td colspan="2">${pco.remarks }</td>
								<td colspan="2">${pco.money}</td>
								<td colspan="2">${pco.status }</td>
							</tr>
						</thead>
						<thead>
							<tr class="success">
								<th>物品代码</th>
								<th>物品条码</th>
								<th >物品名称</th>
								<th >规格</th>
								<th >单位</th>
								<th >采购数量</th>
								<th >入库数量</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pco.pur }" var="pur" >
							<tr>
								<th scope="row">${pur.itemcode }</th>
								<td>${pur.articlebarcode }</td>
								<td>${pur.chinesename }</td>
								<td>1*${pur.purchasespecifications }</td>
								<td>${pur.purchasingunit }</td>
								<td>${pur.number }</td>
								<td>${pur.rknumber}</td>
							</tr>
							</c:forEach>
					</table>
					</c:forEach>
					<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-2 column" style="padding-top: 20px">
							<h5>共${pagecount }条记录 &nbsp;当前${currpage }/${totalpage }页&nbsp;</h5>
						</div>
						<div class="col-md-5 column">
							<ul class="pagination">

								<li><a
									href="${pageContext.request.contextPath }/purchasrOrders/wupingcaigoubaobiao.do?currpage=1&itemcode=${map['itemcode']}&status=${map['status']}&starttime=${map['starttime']}&endtime=${map['endtime']}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/purchasrOrders/wupingcaigoubaobiao.do?currpage=${currpage-1 }&itemcode=${map['itemcode']}&status=${map['status']}&starttime=${map['starttime']}&endtime=${map['endtime']}">上一页</a></li>

								<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/purchasrOrders/wupingcaigoubaobiao.do?currpage=${i }&itemcode=${map['itemcode']}&status=${map['status']}&starttime=${map['starttime']}&endtime=${map['endtime']}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/purchasrOrders/wupingcaigoubaobiao.do?currpage=${currpage+1 }&itemcode=${map['itemcode']}&status=${map['status']}&starttime=${map['starttime']}&endtime=${map['endtime']}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/purchasrOrders/wupingcaigoubaobiao.do?currpage=${totalpage }&itemcode=${map['itemcode']}&status=${map['status']}&starttime=${map['starttime']}&endtime=${map['endtime']}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="wupingcaigoubaobiao.do?itemcode=${map['itemcode']}&status=${map['status']}&starttime=${map['starttime']}&endtime=${map['endtime']}" method="post">

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