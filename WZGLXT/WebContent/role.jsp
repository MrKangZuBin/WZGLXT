<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>待退货物资</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	function allcheck() {

		var number = new Array();

		var ht = $("#allcheack").val();
		if (ht == "全选") {
			$("#div input[type='checkbox']").each(function() {//获取特定标签下的特定属性值的特定标签组
				//			$(this).attr('checked', 'checked');
				$(this).prop("checked", true);
			});
			$("#allcheack").val("取消");
		} else {
			$("#div input[type='checkbox']").each(function() {
				//			$(this).removeAttr('checked');
				$(this).prop("checked", false);
			});
			$("#allcheack").val("全选");
		}

	}

	function guanbies() {
		$("#gray").hide();
		$("#addrole").hide();//查找ID为popup的DIV hide()隐藏
	}

	function addrole() {
		$("#gray").show();
		$("#addrole").show();
		tc_center();
	}

	function addRottsub(id) {
		var rolename = document.getElementById("rolenames").value;

		$.getJSON('addrole.do?rolenames=' + rolename, null, function(data) {
			alert(data.status);
			window.location.href = "selectByWhere.do";
		});
	}

	function delectrole(id) {
		$.getJSON('delectrole.do?id=' + id, null, function(data) {
			alert(data.status);
				window.location.href = "selectByWhere.do";
		});
	}

	function updaterole(id, status) {
		$.getJSON('updaterole.do?roleid=' + id+"&status="+status, null, function(data) {
			alert(data.status);
			window.location.href = "selectByWhere.do";
		});

	}
	
	function updaterole_jm(id) {
		window.location.href = "../Jurisdiction/selectJurisdiction.do?roleid="+ id;
	}
</script>
</head>
<body>
	<div id="gray"></div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<form class="form-inline" action="selectByWhere.do"
					method="post">
					<fieldset>
						<table class="table table-condensed table-hover table-striped">
							<tr>
								<td></td>
								<td></td>
								<td><label>角色名称</label> <input type="text" id="rolename"
									name="rolename" class="form-control select-lg"
									value="${rolename}" />
									<button class="btn btn-warning" type="submit">查询</button>
									<button class="btn btn-warning" type="button"
										onclick="addrole();">添加角色</button></td>
									
								<td colspan="3"></td>
							</tr>
						</table>
					</fieldset>
				</form>
				<table class="table table-condensed table-hover table-striped">
					<thead>
						<tr class="info">
							<th>序号</th>
							<th>角色id</th>
							<th>角色名称</th>
							<th>角色状态</th>
							<th>操作 功能</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${role }" var="role" varStatus="i">
							<tr>
								<td>${i.index+1 }</td>
								<td>${role.roleid }</td>
								<td>${role.rolename }</td>
								<td>${role.status }</td>
								<td><button class="btn btn-warning" type="button" onclick="delectrole('${role.roleid }');">删除</button> 
										<c:if test="${role.status=='关闭' }">
										<button class="btn btn-warning" type="button" onclick="updaterole('${role.roleid }','启用');">启用</button>
										</c:if>
										<c:if test="${role.status=='启用' }">
										<button class="btn btn-warning" type="button" onclick="updaterole('${role.roleid }','关闭');">关闭</button>
										</c:if>
										<button class="btn btn-warning" type="button" onclick="updaterole_jm('${role.roleid }');">管理角色权限</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="addrole" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbies();"></a>
					</div>
					<h3>角色添加</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed" style="background: #edebec;">
								<tr>
									<td><label>角色名称</label></td>
									<td><input type="text" id="rolenames"
										class="form-control select-lg" /></td>
								</tr>
								<tr align="center">
									<td colspan="2">
										<button class="btn btn-warning" type="button"
											onclick="addRottsub('${userID }');">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbies();">关闭</button>
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-2 column" style="padding-top: 20px">
							<h5>共${pagecount }条记录 &nbsp;第${currpage }/${totalpage }页&nbsp;</h5>
						</div>
						<div class="col-md-5 column">
							<ul class="pagination">

								<li><a
									href="${pageContext.request.contextPath }/role/selectByWhere.do?currpage=1&rolename=${rolename}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/role/selectByWhere.do?currpage=${currpage-1 }&rolename=${rolename}">上一页</a></li>

								<c:forEach begin="${currpage-1>=0?currpage-1:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/role/selectByWhere.do?currpage=${i }&rolename=${rolename}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/role/selectByWhere.do?currpage=${currpage+1 }&rolename=${rolename}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/role/selectByWhere.do?currpage=${totalpage }&rolename=${rolename}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?rolename=${rolename}" method="post">

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