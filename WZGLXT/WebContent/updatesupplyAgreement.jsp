<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-供货协议详情</title>
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
<script
	src="${pageContext.request.contextPath }/My97DatePickers/WdatePicker.js"></script>
</head>
<script type="text/javascript">
	function removeitem(id) { //,itemcode,chinesename,articlebarcode,purchasespecifications,purchasingunit,purchaseprice){
		$("#" + id).remove();
		$("#table_sitem").append(
				"<input type='hidden' name='delitemidarray' value='"+id+"'/>");
		//$("#table_item").prepend("<tr id='item"+id+"'> <td>"+itemcode+"</td> <td>"+chinesename+"</td> <td>"+articlebarcode+"</td> <td>"+purchasespecifications+"</td> <td>"+purchasingunit+"</td> <td></td> </tr>");
	}

	function additem(inteminformationid, itemcode, chinesename, articlebarcode,
			purchasespecifications, purchasingunit) {
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
								+ purchasespecifications
								+ "</td> <td>"
								+ purchasingunit
								+ "</td><td><input type='text' name='s_iteminfopurchaseprice_add'/> <input type='hidden' name='iteminfopurchasepriceid_add' value='"+inteminformationid+"' /></td> <td></td> </tr>");
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
	function checkfile(target) {
		var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
		var fileSize = 0;
		if (isIE && !target.files) {
			var filePath = target.value;
			var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
			var file = fileSystem.GetFile(filePath);
			fileSize = file.Size;
		} else {
			fileSize = target.files[0].size;
		}
		var size = fileSize / 1024;
		if (size > 5120) {
			alert("附件不能大于5M,请重新选择！");
			$("#protocoenclosurefile").after($("#protocoenclosurefile").clone().val(""));   
			$("#protocoenclosurefile").remove(); 
		}

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
						<th>采购规格</th>
						<th>单位</th>
						<th>操作</th>
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
								<td>${iteminfo.purchasespecifications }</td>
								<td>${iteminfo.purchasingunit }</td>
								<td><a title="保存后生效"
									onclick="additem('${iteminfo.inteminformationid }','${iteminfo.itemcode }','${iteminfo.chinesename }','${iteminfo.articlebarcode }','${iteminfo.purchasespecifications }','${iteminfo.purchasingunit }');"
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
				<h3 class="b-tittle" style="color: #00ccff">供货协议详情</h3>
				<form class="form-inline" enctype="multipart/form-data" method="post"
					action="${pageContext.request.contextPath }/supplyagreement/update.do">
					<div align="right">
						<input type="hidden" name="supplyagreementid"
							value="${supplyagreement.supplyagreementid }" /> <input
							type="hidden" name="currpage" value="${currpage }" /> <input
							type="hidden" name="lastpersonid" value="${userID}" />
						<button type="button" class="btn btn-defult btn-warning"
							onclick="add()">新增</button>
						<button type="submit" class="btn btn-defult btn-warning">保存</button>
					</div>
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputendtime1">协议代码</label> <input
									class="form-control select-lg" type="text" readonly="readonly"
									value="${supplyagreement.protocolcode }" /></td>

								<td><label for="exampleInputendtime1">供应商</label> <input
									class="form-control select-lg" type="text" readonly="readonly"
									<c:forEach
											items="${supplierlist }" var="supplier">
											<c:if
												test="${supplyagreement.supplierid==supplier.supplierid }">value="${supplier.suppliercode }"</c:if>
										</c:forEach> />
									<input class="form-control select-lg" type="text"
									readonly="readonly"
									<c:forEach
											items="${supplierlist }" var="supplier">
											<c:if
												test="${supplyagreement.supplierid==supplier.supplierid }">value="${supplier.chinesename }"</c:if>
										</c:forEach> />
								</td>
							</tr>
							<tr>
								<td><label for="exampleInputendtime1">协议说明</label> <input
									class="form-control select-lg" type="text"
									name="protocolexplain"
									value="${supplyagreement.protocolexplain }" /></td>

								<td><label for="exampleInputendtime1">协议生效时间</label> <input
									class="form-control select-lg" type="text" style="width: 150px"
									name="starttimestr"
									value="<fmt:formatDate value="${supplyagreement.starttime }"
												type="date" />"
									readonly="readonly" class="Wdate"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /><label
									for="exampleInputendtime1">至&#12288;</label><input
									class="form-control select-lg" type="text" style="width: 150px"
									name="endtimestr"
									value="<fmt:formatDate value="${supplyagreement.endtime }"
												type="date" />"
									readonly="readonly" class="Wdate"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
							</tr>
						</thead>
					</table>

					<c:choose>
						<c:when test="${list!='[]'}">
							<div style="overflow-y: auto; width: 100%; max-height: 260px;">
								<table class="table table-hover" style="margin-top: 10px"
									id="table_sitem">
									<thead>
										<tr class="info">
											<th>物品代码</th>
											<th>物品名称</th>
											<th>物品条码</th>
											<th>采购规格</th>
											<th>单位</th>
											<th>采购单价</th>
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
												<td>${s_iteminfo.purchasespecifications }</td>
												<td>${s_iteminfo.purchasingunit }</td>
												<td><input type="text" name="s_iteminfopurchaseprice"
													value="${s_iteminfo.purchaseprice }" /> <input
													type="hidden" name="s_iteminfopurchasepriceid"
													value="${s_iteminfo.id }" /></td>
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
										<td>${supplyagreement.protocoenclosure }<a
											href="${pageContext.request.contextPath }/supplyagreement/fileDownload.do?filename=${supplyagreement.protocoenclosure }"
											class="btn btn-defult btn-success">下载附件</a></td>
										<td align="right"><input type="file"
											name="protocoenclosurename" id="protocoenclosurefile"
											onchange="checkfile(this);" /></td>
										<td width="40%" align="left"><font color="red">注：上传的附件会把原先的附件覆盖，请谨慎选择！</font></td>
									</tr>
									<tr align="center">
										<td><label for="exampleInputEmail1">创建时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"><fmt:formatDate
													value="${supplyagreement.createdate }" type="date" /></font></td>
										<td><label for="exampleInputEmail1">最后修改时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"><fmt:formatDate
													value="${supplyagreement.lastprocessingtime }" type="date" /></font></td>
										<td width="30%"></td>
									</tr>
									<tr align="center">
										<td><label for="exampleInputEmail1">&#12288;创建人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797">${supplyagreement.createpersonname }</font></td>
										<td><label for="exampleInputEmail1">最后修改人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797">${supplyagreement.lastpersonname }</font></td>
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