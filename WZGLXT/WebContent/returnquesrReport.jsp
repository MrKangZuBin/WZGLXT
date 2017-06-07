<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>物品盘点统计表</title>
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
					<form class="form-inline"
						action="selectkucunpandianbaobiao.do" method="post">
						<fieldset>
							<table class="table table-condensed table-hover table-striped" style="background: #edebec; width: 100%">
								
								<tr>
									<td><label>物品代码</label> <input type="text" id=""
										name="itemcode" class="form-control select-lg" value="${map['itemcode']}"/></td>
									<td><label>时间</label> <input type="text" id=""
										name="starttime" class="form-control select-lg"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map['fristTime']}"/></td>
									<td><label>至</label> <input type="text" id=""
										name="endtime" class="form-control select-lg"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map['secondTime']}"/></td>
								</tr>
								<tr>
									<td><label>物品名称</label> <input type="text" id=""
										name="itemname" class="form-control select-lg" value="${map['itemname']}"/></td>
									<td><label>仓库</label> <input type="text" id="" name="warename"
										class="form-control select-lg" value="${map['warename']}" /></td>
									<td  >
										<% if(jurisdiction.contains("30")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>
				<div>
					<table class="table table-condensed table-hover table-striped">
						<thead>
							<tr class="success">
								<th>物品代码</th>
								<th>物品条码</th>
								<th>物品名称</th>
								<th>单位</th>
								<th>系统库存</th>
								<th>盘点库存</th>
								<th>盈亏数</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pr }" var="pr">
								<tr>
									<th scope="row">${pr.itemcode }</th>
									<td>${pr.articlebarcode }</td>
									<td>${pr.chinesename }</td>
									<td>${pr.purchasingunit }</td>
									<td>${pr.currentStock }</td>
									<td>${pr.inventoryInventory }</td>
									<td>${pr.profitLossNumber }</td>
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
										href="${pageContext.request.contextPath }/Inventory/selectkucunpandianbaobiao.do?currpage=1&itemcode=${map['itemcode']}&itemname=${map['itemname']}&starttime=${map['starttime']}&endtime=${map['endtime']}&warename=${map['warename']}">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/Inventory/selectkucunpandianbaobiao.do?currpage=${currpage-1 }&itemcode=${map['itemcode']}&itemname=${map['itemname']}&starttime=${map['starttime']}&endtime=${map['endtime']}&warename=${map['warename']}">上一页</a></li>

									<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
										end="${currpage+2 }" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/Inventory/selectkucunpandianbaobiao.do?currpage=${i }&itemcode=${map['itemcode']}&itemname=${map['itemname']}&starttime=${map['starttime']}&endtime=${map['endtime']}&warename=${map['warename']}"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/Inventory/selectkucunpandianbaobiao.do?currpage=${currpage+1 }&itemcode=${map['itemcode']}&itemname=${map['itemname']}&starttime=${map['starttime']}&endtime=${map['endtime']}&warename=${map['warename']}">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/Inventory/selectkucunpandianbaobiao.do?currpage=${totalpage }&itemcode=${map['itemcode']}&itemname=${map['itemname']}&starttime=${map['starttime']}&endtime=${map['endtime']}&warename=${map['warename']}">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="selectkucunpandianbaobiao.do?itemcode=${map['itemcode']}&itemname=${map['itemname']}&starttime=${map['starttime']}&endtime=${map['endtime']}&warename=${map['warename']}" method="post">

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