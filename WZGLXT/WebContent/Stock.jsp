<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>库存查询</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		List jurisdiction = (List) session.getAttribute("list");
	%>
	<div id="gray"></div>
	<div  style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div >
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<form class="form-inline" method="post" action="selectByWhere.do">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>物品代码 </label> <input type="text" id="" name="itemcode"
									class="form-control select-lg" value="${maps['itemcode'] }"/></td>
								<td><label>物料类型</label> <select id="" name="materialmaterial"
									class="form-control select-lg">
										<option value="">请选择状态</option>
										<option value="IMPA物料"  <c:if test="${maps['materialmaterial']=='IMPA物料'}">selected="selected"</c:if>>IMPA物料</option>
										<option value="普通物料" <c:if test="${maps['materialmaterial']=='普通物料'}">selected="selected"</c:if>>普通物料</option>
								</select></td>
								<td><label>所属分类</label> <input type="text" id="" name="category"
									class="form-control select-lg" value="${maps['category'] }"/></td>
								<td><label>物料属性</label> <select id="" name="itemProperties"
									class="form-control select-lg">
										<option value="">请选择</option>
										<option value="可销售" <c:if test="${maps['itemProperties']=='可销售'}">selected="selected"</c:if>>可销售</option>
										<option value="不可销售" <c:if test="${maps['itemProperties']=='不可销售'}">selected="selected"</c:if>>不可销售</option>
								</select></td>
							</tr>

							<tr align="center">
								<td><label>物品名称</label> <input type="text" id="" name="itemname"
									class="form-control select-lg" value="${maps['itemname'] }"/></td>
								<td><label>批次号码</label> <input type="text" id="" name="itemcodes"
									class="form-control select-lg" value="${maps['itemcodes'] }"/></td>
								<td><% if(jurisdiction.contains("21")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%></td>
								<td></td>
							</tr>


						</table>

					</fieldset>
				</form>
				<br/>
				
				
				
						<div class="col-md-12 column">
							<div class="row clearfix">
									<table class="table table-condensed table-hover table-striped">
										<tr class="warning">
											<th></th>
											<th>物品代码</th>
											<th>物品名称</th>
											<th>物品条码</th>
											<th>所属分类</th>
											<th>库位</th>
											<th>库存</th>
											<th>实际库存</th>
											<th>单位</th>
										</tr>
											<c:forEach items="${iif }" var="iif" varStatus="i">
												<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}>
													<td>${i.index+1 }</td>
													<td>${iif.itemcode }</td>
													<td>${iif.chinesename }</td>
													<td>${iif.articlebarcode }</td>
													<td>${iif.category }</td>
													<td>${iif.inventorylocationname }</td>
													<td>${iif.maxstock }</td>
													<td>${iif.currentstock }</td>
													<td>${iif.salesunit }</td>
												</tr>
											</c:forEach>
										</table>
										
									</div>
								</div>
								
				<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-2 column" style="padding-top: 20px">
								<h5>共${pagecount }条记录 &nbsp;当前${currpage }/${totalpage }页&nbsp;</h5>
							</div>
							<div class="col-md-5 column">
								<ul class="pagination">

									<li><a
										href="${pageContext.request.contextPath }/Stock/selectByWhere.do?currpage=1&itemcode=${maps['itemcode'] }&materialmaterial=${maps['materialmaterial']}&category=${maps['category'] }&itemProperties=${maps['itemProperties']}&itemname=${maps['itemname'] }">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/Stock/selectByWhere.do?currpage=${currpage-1 }&itemcode=${maps['itemcode'] }&materialmaterial=${maps['materialmaterial']}&category=${maps['category'] }&itemProperties=${maps['itemProperties']}&itemname=${maps['itemname'] }&itemcodes=${maps['itemcodes']}">上一页</a></li>

									<c:forEach begin="${currpage-1>=0?currpage-1:'0' }"
										end="${currpage+1}" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/Stock/selectByWhere.do?currpage=${i }&itemcode=${maps['itemcode'] }&materialmaterial=${maps['materialmaterial']}&category=${maps['category'] }&itemProperties=${maps['itemProperties']}&itemname=${maps['itemname'] }&itemcodes=${maps['itemcodes']}"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/Stock/selectByWhere.do?currpage=${currpage+1 }&itemcode=${maps['itemcode'] }&materialmaterial=${maps['materialmaterial']}&category=${maps['category'] }&itemProperties=${maps['itemProperties']}&itemname=${maps['itemname'] }&itemcodes=${maps['itemcodes']}">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/Stock/selectByWhere.do?currpage=${totalpage }&itemcode=${maps['itemcode'] }&materialmaterial=${maps['materialmaterial']}&category=${maps['category'] }&itemProperties=${maps['itemProperties']}&itemname=${maps['itemname'] }&itemcodes=${maps['itemcodes']}">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="selectByWhere.do?itemcode=${maps['itemcode'] }&materialmaterial=${maps['materialmaterial']}&category=${maps['category'] }&itemProperties=${maps['itemProperties']}&itemname=${maps['itemname'] }&itemcodes=${maps['itemcodes']}" method="post">

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