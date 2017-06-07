<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-店仓资料</title>
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
<jsp:include page="header.jsp"></jsp:include>
</head>
<script type="text/javascript">
	function removeitem(id) { //,itemcode,chinesename,articlebarcode,purchasespecifications,purchasingunit,purchaseprice){
		$("#" + id).remove();
		$("#table_sitem").append(
				"<input type='hidden' name='delitemidarray' value='"+id+"'/>");
		//$("#table_item").prepend("<tr id='item"+id+"'> <td>"+itemcode+"</td> <td>"+chinesename+"</td> <td>"+articlebarcode+"</td> <td>"+purchasespecifications+"</td> <td>"+purchasingunit+"</td> <td></td> </tr>");
	}

	function additem(inteminformationid, itemcode, chinesename, articlebarcode,
			maxstock, minstock, proposalprice, latestprice) {
		$("#item" + inteminformationid).remove();
		$("#table_sitem")
				.prepend(
						"<tr id='add"+inteminformationid+"'> <td>"
								+ itemcode
								+ "</td> <td>"
								+ chinesename
								+ "</td> <td>"
								+ articlebarcode
								+ "</td> <td>"
								+ maxstock
								+ "</td> <td>"
								+ minstock
								+ "</td> <td>"
								+ proposalprice
								+ "</td> <td>"
								+ latestprice
								+ "</td> <td><input type='hidden' name='iteminfopurchasepriceid_add' value='"+inteminformationid+"' /></td> </tr>");
	}

	function add(id) {
		applyed();
	}
	function hide() {
		$("#gray").hide();
		$("#popup").hide();
	}
	function applyed() {
		$("#gray").show();
		$("#popup").show();
		tc_center();
	}
</script>
<body>
	<div id="gray"></div>
	<div class="popup" id="popup"
		style="width: 90%; padding-bottom: 30px; padding-left: 30px; padding-right: 30px;">
		<div class="top_nav" id='top_nav' style="padding-top: 20px;">
			<span>物料新增/编辑 </span><a class="guanbi" onclick="hide();"></a><br>
		</div>
		<br>
		<div
			style="width: 100%; height: 400px; overflow: auto; background-color: #ffffff; padding-top: 6px; padding-bottom: 6px; padding-left: 6px; padding-right: 6px;">
			<table class="table table-hover" style="margin-top: 10px">
				<thead>
					<tr class="info">
						<th>物品代码</th>
						<th>物品名称</th>
						<th>物品条码</th>
						<th>库存上限</th>
						<th>库存下限</th>
						<th>零售价</th>
						<th>最低售价</th>
					</tr>
				</thead>
				<tbody>
					<%!int exitId = 1;%>
					<c:forEach items="${iteminfolist}" var="iteminfo">
						<c:set var="exitId" value="1"></c:set>
						<c:forEach items="${s_iteminfolist }" var="s_iteminfo">
							<c:if
								test="${iteminfo.inteminformationid==s_iteminfo.iteminformationid }">
								<c:set var="exitId" value="0"></c:set>
							</c:if>
						</c:forEach>
						<c:if test="${exitId==1 }">
							<tr id="item${iteminfo.inteminformationid }">
								<td>${iteminfo.itemcode }</td>
								<td>${iteminfo.chinesename }</td>
								<td>${iteminfo.articlebarcode }</td>
								<td>${iteminfo.maxstock }</td>
								<td>${iteminfo.minstock }</td>
								<td>${iteminfo.proposalprice }</td>
								<td>${iteminfo.latestprice }</td>
								<td><a title="保存后生效"
									onclick="additem('${iteminfo.inteminformationid }','${iteminfo.itemcode }','${iteminfo.chinesename }','${iteminfo.articlebarcode }','${iteminfo.maxstock }','${iteminfo.minstock }','${iteminfo.proposalprice }','${iteminfo.latestprice }');"
									style="cursor: pointer;">添加</a></td>
							</tr>
							<c:set var="exitId" value="0"></c:set>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<h3 class="b-tittle" style="color: #00ccff">店仓资料</h3>
				<form class="form-inline"
					action="${pageContext.request.contextPath }/shop/update.do">
					<div align="right">
						<input type="hidden" name="shopid" value="${shop.shopid }" /> <input
							type="hidden" name="currpage" value="${currpage }" /> <input
							type="hidden" name="lastpersonid" value="${userID}" />
						<button type="button" class="btn btn-defult btn-warning"
							onclick="add()">新增</button>
						<button type="submit" class="btn btn-defult btn-warning">保存</button>
					</div>
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputendtime1">店仓代码</label> <input
									class="form-control select-lg" type="text" readonly="readonly"
									value="${shop.storecode }" /></td>

								<td><label for="exampleInputendtime1">店仓名称<font
										color="red">*</font></label> <input class="form-control select-lg"
									type="text" value="${shop.annexname }" /></td>
								<td><label for="exampleInputendtime1">状态<font
										color="red">*</font></label> <select name="annexpath"
									class="form-control select-lg">
										<option value="可用" ${annexpath=="可用"?"selected":"" }>可用</option>
										<option value="不可用" ${annexpath=="不可用"?"selected":"" }>不可用</option>
								</select></td>
							</tr>
							<tr>
								<td><label for="exampleInputendtime1">联系方式<font
										color="red">*</font></label> <input class="form-control select-lg"
									type="text" name="companytelephone"
									value="${shop.companytelephone }" /></td>
								<td><label for="exampleInputendtime1">地址</label> <input
									class="form-control select-lg" type="text" name="address"
									value="${shop.address }" /></td>
								<td><label for="exampleInputendtime1">备注</label> <input
									class="form-control select-lg" type="text" name="description"
									style="width: 80%" value="${shop.description }" /></td>

							</tr>
						</thead>
					</table>

					<c:choose>
						<c:when test="${list!='[]'}">
							<div style="overflow-y: auto; width: 100%; height: 200px">
								<table class="table table-hover" style="margin-top: 10px"
									id="table_sitem">
									<thead>
										<tr class="info">
											<th>物品代码</th>
											<th>物品名称</th>
											<th>物品条码</th>
											<th>库存上限</th>
											<th>库存下限</th>
											<th>零售价</th>
											<th>最低售价</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${s_iteminfolist}" var="s_iteminfo"
											varStatus="i">

											<tr id="${s_iteminfo.id }"
												${(i.index+1)%2==0?"class='error'":"class='success'"}>
												<td>${s_iteminfo.itemcode }</td>
												<td>${s_iteminfo.chinesename }</td>
												<td>${s_iteminfo.articlebarcode }</td>
												<td>${s_iteminfo.maxstock }</td>
												<td>${s_iteminfo.minstock }</td>
												<td>${s_iteminfo.proposalprice }</td>
												<td>${s_iteminfo.latestprice }</td>
												<td><a title="保存后生效"
													onclick="removeitem('${s_iteminfo.id }');"
													style="cursor: pointer;">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<br>
							<table class="table table-condensed" style="background: #edebec;">
								<thead>
									<tr align="center">
										<td><label for="exampleInputEmail1">创建时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"><fmt:formatDate
													value="${shop.createtime }" type="date" /></font></td>
										<td><label for="exampleInputEmail1">最后修改时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"><fmt:formatDate
													value="${shop.finalprocessingtime }" type="date" /></font></td>
										<td width="30%"></td>
									</tr>
									<tr align="center">
										<td><label for="exampleInputEmail1">&#12288;创建人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797">${shop.createpersonname }</font></td>
										<td><label for="exampleInputEmail1">最后修改人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797">${shop.lastpersonname }</font></td>
										<td width="30%"></td>
									</tr>
								</thead>
							</table>
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
				</form>
			</div>
		</div>
	</div>
</body>
</html>