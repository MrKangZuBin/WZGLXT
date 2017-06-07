<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-供货协议</title>
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
<script type="text/javascript">
	var supplyagreementid;
	var bool = false;
	function selected(supplyagreementid_o) {
		$("#" + supplyagreementid).removeClass("danger");
		supplyagreementid = supplyagreementid_o;
		bool = true;
		//$("#"+protocostatusid).attr("class", "info");
		$("#" + supplyagreementid).addClass("danger");
	}
	function getaddjson() {
		$
				.ajax({
					url : "${pageContext.request.contextPath}/supplyagreement/selRequest.do",
					type : "post",
					datatType : "json",
					success : function(data) {
						$("#protocolcode").val(data.code);
					}
				});
	}
	function notselected() {
		alert("请选中一行数据！");
	};
	function edit() {
		if (!bool) {
			notselected();
			return false;
		}
		$("#updid").val(supplyagreementid);
		$("#updform").submit();
	}
	function add() {
		getaddjson();
		$("#subform").attr("action",
				"${pageContext.request.contextPath }/supplyagreement/add.do");
		$("#gray").show();
		$("#popup").show();
		center();

	};
	function del() {
		if (!bool) {
			notselected();
			return false;
		}
		$("#delid").val(supplyagreementid);
		$("#delform")
				.attr("action",
						"${pageContext.request.contextPath }/supplyagreement/delete.do");
		$("#gray").show();
		$("#popupdel").show();
		tc_center();
	};
	function hidedel() {
		$("#gray").hide();
		$("#popupdel").hide();
	}
	function hide() {
		$("#gray").hide();
		$("#popup").hide();
	}
	function center() {
		var _top = ($(window).height() - $("#popup").height()) / 2;
		var _left = ($(window).width() - $("#popup").width()) / 2;
		$("#popup").css({
			top : _top,
			left : _left
		});
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
			$("#protocoenclosurefile").after(
					$("#protocoenclosurefile").clone().val(""));
			$("#protocoenclosurefile").remove();
		}

	}
</script>

</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<%
		List jurisdiction = (List) session.getAttribute("list");
	%>
	<div id="gray"></div>
	<div class="popup" id="popupdel" style="padding: 50px;">
		<center>
			<h2 style="color: #979797">确认删除？</h2>
			<br>
			<h5 style="color: #ff3300">此操作不可恢复，是否继续？</h5>
		</center>
		<form class="form-horizontal" role="form" id="updform"
			action="${pageContext.request.contextPath }/supplyagreement/get.do"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" name="updid" id="updid" />
		</form>
		<br>
		<form class="form-horizontal" role="form" id="delform" action="#"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" id="delid" name="supplyagreementid">
			<center>
				<input style="padding-left: 30px; padding-right: 30px" type="button"
					class="btn btn-info" onclick="hidedel()" value="取消"> <input
					style="padding-left: 30px; padding-right: 30px" type="submit"
					class="btn btn-danger" value="确认" />
			</center>
		</form>
	</div>
	<div class="popup" id="popup"
		style="width: 60%; padding-bottom: 30px; padding-left: 30px; padding-right: 30px;">
		<div class="top_nav" id='top_nav' style="padding-top: 20px;">
			<span>新增 </span><a class="guanbi" onclick="hide();"></a><br>
		</div>
		<br>
		<form class="form-inline" role="form" id="subform" action="#"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="currpage" value="${currpage }" /><input
				type="hidden" id="createpersonid" name="createpersonid"
				value="${userID }" /> <input type="hidden" id="lastpersonid"
				name="lastpersonid" value="${userID }" />
			<div
				style="width: 100%; padding-top: 6px; padding-bottom: 6px; padding-left: 6px; padding-right: 6px;">
				<table class="table table-hover" style="margin-top: 10px">
					<tr>
						<td><label for="exampleInputEmail1">协议代码<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 70%" name="protocolcode"
							id="protocolcode" readonly="readonly" /></td>
						<td><label for="exampleInputEmail1">供应商<font
								color="red">*</font></label> <select class="form-control select-lg"
							style="width: 70%" name="supplierid">
								<c:forEach items="${supplierlist }" var="supplier">
									<option value="${supplier.supplierid}">${supplier.chinesename}</option>
								</c:forEach>
						</select></td>

					</tr>
					<tr>
						<td colspan="2"><label for="exampleInputEmail1">协议说明<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 80%" name="protocolexplain" /></td>
					</tr>
					<tr>
						<td><label for="exampleInputEmail1">协议状态<font
								color="red">*</font></label> <select class="form-control select-lg"
							style="width: 70%" name="protocostatus">
								<option value="可用">可用</option>
								<option value="不可用">不可用</option>
						</select></td>
						<td><label for="exampleInputEmail1">协议附件</label><input
							type="file" name="protocoenclosurename" id="protocoenclosurefile"
							onchange="checkfile(this);" /></td>
					</tr>
					<tr>

						<td><label for="exampleInputEmail1">生效时间<font
								color="red">*</font></label><input class="form-control select-lg"
							type="text" style="width: 30%" name="starttimestr"
							readonly="readonly" class="Wdate"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /><label
							for="exampleInputEmail1">至</label><input
							class="form-control select-lg" type="text" style="width: 30%"
							name="endtimestr" readonly="readonly" class="Wdate"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
					</tr>
				</table>
			</div>
			<center>
				<input style="padding-left: 30px; padding-right: 30px" type="button"
					class="btn btn-info" onclick="hide()" value="取消"> <input
					style="padding-left: 30px; padding-right: 30px" type="submit"
					class="btn btn-warning" value="保存" />
			</center>

		</form>
	</div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<h3 class="b-tittle" style="color: #00ccff">供货协议</h3>
				<form class="form-inline"
					action="${pageContext.request.contextPath }/supplyagreement/paginglist.do">
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputendtime1">协议代码</label> <input
									class="form-control select-lg" type="text"
									name="protocolcode_o" value="${protocolcode }" /></td>
								<td colspan="3"><label for="exampleInputendtime1">协议说明</label>
									<input class="form-control select-lg" type="text"
									style="width: 70%" name="protocolexplain_o"
									value="${protocolexplain }" /></td>
							</tr>
							<tr>
								<td><label for="exampleInputendtime1">供应商代码</label> <input
									class="form-control select-lg" type="text"
									name="suppliercode_o" value="${suppliercode }" /></td>

								<td><label for="exampleInputendtime1">状态</label> <select
									name="protocostatus_o" class="form-control select-lg">
										<option value="">全部</option>
										<option value="可用" ${protocostatus=="可用"?"selected":"" }>可用</option>
										<option value="不可用" ${protocostatus=="不可用"?"selected":"" }>不可用</option>
								</select></td>
								<td colspan="2"><label for="exampleInputendtime1">供应商名称</label>
									<input class="form-control select-lg" type="text"
									name="suppliername_o" value="${suppliername }"
									style="width: 70%" /></td>
							</tr>
							<tr>
								<td><label for="exampleInputendtime1">协议开始时间</label> <input
									class="form-control select-lg" type="text" style="width: 60%"
									name="starttime_o1"
									value="${starttime1 }"
									readonly="readonly" class="Wdate"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>

								<td><label for="exampleInputendtime1">至&#12288;</label><input
									class="form-control select-lg" type="text" style="width: 70%"
									name="starttime_o2"
									value="${starttime2 }"
									readonly="readonly" class="Wdate"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
								<td><label for="exampleInputendtime1">协议结束时间 </label> <input
									class="form-control select-lg" type="text" style="width: 60%"
									name="endtime_o1"
									value="${endtime1 }"
									readonly="readonly" class="Wdate"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
								<td><label for="exampleInputendtime1">至&#12288; </label> <input
									class="form-control select-lg" type="text" style="width: 70%"
									name="endtime_o2"
									value="${endtime2 }"
									readonly="readonly" class="Wdate"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
								<td rowspan="3">
									<button type="submit" class="btn btn-defult btn-info"
										style="vertical-align: bottom;">查询</button>
								</td>
							</tr>
						</thead>
					</table>
				</form>
				<%
					if (jurisdiction.contains("43")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="add()">新增协议</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">新增协议</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("46")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="edit()">编辑协议</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">编辑协议</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("45")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="del()">删除协议</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">删除协议</button>
				<%
					}
				%>
				<c:choose>
					<c:when test="${list!='[]'}">
						<table class="table table-hover table-bordered"
							style="margin-top: 10px">
							<thead>
								<tr class="info">
									<th>序号</th>
									<th>协议代码</th>
									<th>协议说明</th>
									<th>协议生效时间</th>
									<th>供应商代码</th>
									<th>供应商名称</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="supplyagreement" varStatus="i">

									<tr id="${supplyagreement.supplyagreementid }"
										${(i.index+1)%2==0?"class='error'":"class='success'"}
										onclick="selected('${supplyagreement.supplyagreementid }')">
										<td>${i.index+1 }</td>
										<td>${supplyagreement.protocolcode }</td>
										<td>${supplyagreement.protocolexplain }</td>

										<td><fmt:formatDate value="${supplyagreement.starttime }"
												type="date" />- <fmt:formatDate
												value="${supplyagreement.endtime }" type="date" /></td>
										<td><c:forEach items="${supplierlist }" var="supplier">
												<c:if
													test="${supplyagreement.supplierid==supplier.supplierid }">${supplier.suppliercode }</c:if>
											</c:forEach></td>
										<td><c:forEach items="${supplierlist }" var="supplier">
												<c:if
													test="${supplyagreement.supplierid==supplier.supplierid }">${supplier.chinesename }</c:if>
											</c:forEach></td>
										<td>${supplyagreement.protocostatus }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<table width="100%">
							<tr>
								<td width="18%">
									<div style="padding-top: 20px">
										<h6>
											共<strong style="color: #b93d00">${rowcount }</strong>条记录
											&nbsp;当前<strong style="color: #b93d00">${currpage }/${totalpage }</strong>页&nbsp;
										</h6>
									</div>
								</td>
								<td width="50%">
									<div>
										<ul class="pagination">
											<li><a
												href="${pageContext.request.contextPath }/supplyagreement/paginglist.do?currpage=1&&protocolcode_o=${protocolcode}&&protocolexplain_o=${protocolexplain}&&suppliercode_o=${suppliercode}&&protocostatus_o=${protocostatus}&&suppliername_o=${suppliername}&&starttime_o1=${starttime1}&&starttime_o2=${starttime2}&&endtime_o1=${endtime1}&&endtime_o2=${endtime2}">首页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/supplyagreement/paginglist.do?currpage=${currpage-1 }&&protocolcode_o=${protocolcode}&&protocolexplain_o=${protocolexplain}&&suppliercode_o=${suppliercode}&&protocostatus_o=${protocostatus}&&suppliername_o=${suppliername}&&starttime_o1=${starttime1}&&starttime_o2=${starttime2}&&endtime_o1=${endtime1}&&endtime_o2=${endtime2}">上一页</a></li>

											<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
												end="${currpage+2 }" step="1" var="i">
												<c:if test="${i>0&&i<=totalpage?'true':'false'}">
													<li><a
														href="${pageContext.request.contextPath }/supplyagreement/paginglist.do?currpage=${i }&&protocolcode_o=${protocolcode}&&protocolexplain_o=${protocolexplain}&&suppliercode_o=${suppliercode}&&protocostatus_o=${protocostatus}&&suppliername_o=${suppliername}&&starttime_o1=${starttime1}&&starttime_o2=${starttime2}&&endtime_o1=${endtime1}&&endtime_o2=${endtime2}"
														${i==currpage?"style='color: red'":"" }>${i}</a></li>
												</c:if>
											</c:forEach>
											<li><a
												href="${pageContext.request.contextPath }/supplyagreement/paginglist.do?currpage=${currpage+1 }&&protocolcode_o=${protocolcode}&&protocolexplain_o=${protocolexplain}&&suppliercode_o=${suppliercode}&&protocostatus_o=${protocostatus}&&suppliername_o=${suppliername}&&starttime_o1=${starttime1}&&starttime_o2=${starttime2}&&endtime_o1=${endtime1}&&endtime_o2=${endtime2}">下一页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/supplyagreement/paginglist.do?currpage=${totalpage }&&protocolcode_o=${protocolcode}&&protocolexplain_o=${protocolexplain}&&suppliercode_o=${suppliercode}&&protocostatus_o=${protocostatus}&&suppliername_o=${suppliername}&&starttime_o1=${starttime1}&&starttime_o2=${starttime2}&&endtime_o1=${endtime1}&&endtime_o2=${endtime2}">尾页</a></li>
										</ul>
									</div>
								</td>
								<td width="32%">
									<div style="padding-top: 10px">
										<form class="navbar-form navbar-left" role="search"
											action="${pageContext.request.contextPath }/supplyagreement/paginglist.do?protocolcode_o=${protocolcode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}"
											method="post">
											<input type="text" class="form-control" name="currpage"
												onkeyup="this.value=this.value.replace(/\D/g,'')"
												onafterpaste="this.value=this.value.replace(/\D/g,'')" />
											<button type="submit" class="btn btn-default">跳转</button>
										</form>
									</div>
								</td>
							</tr>
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
			</div>
		</div>
	</div>
</body>
</html>