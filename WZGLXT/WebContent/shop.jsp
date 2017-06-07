<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-店仓管理</title>
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
	var shopid;
	var bool = false;
	function selected(shopid_o) {
		$("#" + shopid).removeClass("danger");
		shopid = shopid_o;
		bool = true;
		$("#" + shopid).addClass("danger");
	}
	function getaddjson() {
		$.ajax({
			url : "${pageContext.request.contextPath}/shop/selRequest.do",
			type : "post",
			datatType : "json",
			success : function(data) {
				$("#storecode").val(data.code);
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
		$("#updid").val(shopid);
		$("#updform").submit();
	}
	function add() {
		getaddjson();
		$("#subform").attr("action",
				"${pageContext.request.contextPath }/shop/add.do");
		$("#gray").show();
		$("#popup").show();
		center();

	};
	function del() {
		if (!bool) {
			notselected();
			return false;
		}
		$("#delid").val(shopid);
		$("#delform").attr("action",
				"${pageContext.request.contextPath }/shop/delete.do");
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
			action="${pageContext.request.contextPath }/shop/get.do"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" name="updid" id="updid" />
		</form>
		<br>
		<form class="form-horizontal" role="form" id="delform" action="#"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" id="delid" name="shopid">
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
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /><input
				type="hidden" id="createpersonid" name="createpersonid"
				value="${userID }" /> <input type="hidden" id="lastpersonid"
				name="lastpersonid" value="${userID }" />
			<div
				style="width: 100%; padding-top: 6px; padding-bottom: 6px; padding-left: 6px; padding-right: 6px;">
				<table class="table table-hover" style="margin-top: 10px">
					<tr>
						<td><label for="exampleInputEmail1">店仓代码<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 70%" name="storecode" id="storecode"
							readonly="readonly" /></td>
						<td><label for="exampleInputEmail1">店仓名称<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 70%" name="annexname" /></td>
					</tr>
					<tr>
						<td><label for="exampleInputEmail1">联系方式<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 70%" name="companytelephone" /></td>
						<td><label for="exampleInputEmail1">状态<font
								color="red">*</font></label> <select class="form-control select-lg"
							style="width: 80%" name="annexpath">
								<option value="可用">可用</option>
								<option value="不可用">不可用</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><label for="exampleInputEmail1">地址<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 80%" name="address" /></td>
					</tr>
					<tr>
						<td colspan="2"><label for="exampleInputEmail1">备注<font
								color="red">*</font></label> <input class="form-control select-lg"
							type="text" style="width: 80%" name="description" /></td>
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
				<h3 class="b-tittle" style="color: #00ccff">店仓管理</h3>
				<form class="form-inline"
					action="${pageContext.request.contextPath }/shop/paginglist.do">
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputendtime1">店仓代码</label> <input
									class="form-control select-lg" type="text" name="storecode_o"
									value="${storecode }" /></td>
								<td colspan="3"><label for="exampleInputendtime1">店仓名称</label>
									<input class="form-control select-lg" type="text"
									name="annexname_o" value="${annexname }" /></td>
								<td><label for="exampleInputendtime1">状态</label> <select
									name="annexpath_o" class="form-control select-lg">
										<option value="">全部</option>
										<option value="可用" ${annexpath=="可用"?"selected":"" }>可用</option>
										<option value="不可用" ${annexpath=="不可用"?"selected":"" }>不可用</option>
								</select></td>
								<td>
									<button type="submit" class="btn btn-defult btn-info"
										style="vertical-align: bottom;">查询</button>
								</td>
							</tr>
						</thead>
					</table>
				</form>
				<%
					if (jurisdiction.contains("66")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="add()">新增店仓</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">新增店仓</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("65")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="edit()">编辑店仓</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">编辑店仓</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("64")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="del()">删除店仓</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">删除店仓</button>
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
									<th>店仓代码</th>
									<th>店仓名称</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>创建人</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="shop" varStatus="i">

									<tr id="${shop.shopid }"
										${(i.index+1)%2==0?"class='error'":"class='success'"}
										onclick="selected('${shop.shopid }')">
										<td>${i.index+1 }</td>
										<td>${shop.storecode }</td>
										<td>${shop.annexname }</td>
										<td>${shop.annexpath }</td>
										<td><fmt:formatDate value="${shop.createtime }"
												type="date" /></td>
										<td>${shop.createpersonname }</td>
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
												href="${pageContext.request.contextPath }/shop/paginglist.do?currpage=1&&storecode_o=${storecode}&&annexname_o=${annexname }&&annexpath_o=${annexpath}">首页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/shop/paginglist.do?currpage=${currpage-1 }&&storecode_o=${storecode}&&annexname_o=${annexname }&&annexpath_o=${annexpath}">上一页</a></li>

											<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
												end="${currpage+2 }" step="1" var="i">
												<c:if test="${i>0&&i<=totalpage?'true':'false'}">
													<li><a
														href="${pageContext.request.contextPath }/shop/paginglist.do?currpage=${i }&&storecode_o=${storecode}&&annexname_o=${annexname }&&annexpath_o=${annexpath}"
														${i==currpage?"style='color: red'":"" }>${i}</a></li>
												</c:if>
											</c:forEach>
											<li><a
												href="${pageContext.request.contextPath }/shop/paginglist.do?currpage=${currpage+1 }&&storecode_o=${storecode}&&annexname_o=${annexname }&&annexpath_o=${annexpath}">下一页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/shop/paginglist.do?currpage=${totalpage }&&storecode_o=${storecode}&&annexname_o=${annexname }&&annexpath_o=${annexpath}">尾页</a></li>
										</ul>
									</div>
								</td>
								<td width="32%">
									<div style="padding-top: 10px">
										<form class="navbar-form navbar-left" role="search"
											action="${pageContext.request.contextPath }/shop/paginglist.do?storecode_o=${storecode}&&annexname_o=${annexname }&&annexpath_o=${annexpath}"
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