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
	function guanbies() {
		$("#gray").hide();
		$("#adduser").hide();//查找ID为popup的DIV hide()隐藏
	}

	function adduser() {
		$("#gray").show();
		$("#adduser").show();
		tc_center();
	}

	function addusersub(id) {
		var loginname = document.getElementById("loginnames").value;
		var password = document.getElementById("password").value;
		var passwords = document.getElementById("passwords").value;

		if (password == passwords) {
			$.getJSON('adduser.do?loginnames=' + loginname + "&password="
					+ password, null, function(data) {
				alert(data.status);
				window.location.href = "selectByWhere.do";
			});
		} else {
			alert("请输入两次正确的密码.");
		}

	}

	function delectuser(id) {
		$.getJSON('delectuser.do?id=' + id, null, function(data) {
			alert(data.status);
			window.location.href = "selectByWhere.do";
		});
	}

	function updateuser(id, status) {
		$.getJSON('updateuser.do?userid=' + id + "&status=" + status, null,
				function(data) {
					alert(data.status);
					window.location.href = "selectByWhere.do";
				});

	}

	function userroot(id) {
		window.location.href = "userroot.do?id=" + id;
	}

	function getrole(id) {
		$("#" + id).hide();
		$("#hidetd" + id).show();
	}
	
	function updaterole(id) {
		
		var rolename=document.getElementById("rolename"+id).value;
		$.getJSON('updateuserrole.do?userid=' + id + "&roleid=" + rolename, null,
				function(data) {
					alert(data.status);
					window.location.href = "selectByWhere.do";
				});
		
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
				<form class="form-inline" action="selectByWhere.do" method="post">
					<fieldset>
						<table class="table table-condensed table-hover table-striped">
							<tr>
								<td></td>
								<td></td>
								<td><label>用户名</label> <input type="text" id="loginname"
									name="loginname" class="form-control select-lg"
									value="${loginname}" />
									<button class="btn btn-warning" type="submit">查询</button>
									<button class="btn btn-warning" type="button"
										onclick="adduser();">添加用户</button></td>

								<td colspan="3"></td>
							</tr>
						</table>
					</fieldset>
				</form>
				<table class="table table-condensed table-hover table-striped">
					<thead>
						<tr class="info">
							<th>序号</th>
							<th>用户名称</th>
							<th>权限状态</th>
							<th>用户角色</th>
							<th>功能 操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${user }" var="user" varStatus="i">
							<tr>
								<td>${i.index+1 }</td>
								<td>${user.loginname }</td>
								<td>${user.status }</td>
								<td style="display: none;" id="hidetd${user.userid }"><select
									id='rolename${user.userid }' onchange="updaterole('${user.userid }');"><c:forEach items="${role }" var='role'>
											<option value="${role.roleid }"
												<c:if test="${user.roleid==role.roleid }">selected="selected"</c:if>>${role.rolename }</option>
										</c:forEach></select></td>
								<td id="${user.userid }">${user.rolename }</td>
								<td>
									<button id="but" class="btn btn-warning" onclick="getrole('${user.userid }');">角色编辑</button>
									<button class="btn btn-warning" type="button"
										onclick="delectuser('${user.userid }');">删除</button> <c:if
										test="${user.status=='关闭' }">
										<button class="btn btn-warning" type="button"
											onclick="updateuser('${user.userid }','启用');">启用</button>
									</c:if> <c:if test="${user.status=='启用' }">
										<button class="btn btn-warning" type="button"
											onclick="updateuser('${user.userid }','关闭');">关闭</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="adduser" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbies();"></a>
					</div>
					<h3>用户添加</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed" style="background: #edebec;">
								<tr>
									<td><label>用户名称</label></td>
									<td><input type="text" id="loginnames"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>用户密码</label></td>
									<td><input type="text" id="password"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>确认密码</label></td>
									<td><input type="text" id="passwords"
										class="form-control select-lg" /></td>
								</tr>
								<tr align="center">
									<td colspan="2">
										<button class="btn btn-warning" type="button"
											onclick="addusersub('${userID }');">确定</button>
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
									href="${pageContext.request.contextPath }/user/selectByWhere.do?currpage=1&loginname=${loginname}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/user/selectByWhere.do?currpage=${currpage-1 }&loginname=${loginname}">上一页</a></li>

								<c:forEach begin="${currpage-1>=0?currpage-1:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/user/selectByWhere.do?currpage=${i }&loginname=${loginname}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/user/selectByWhere.do?currpage=${currpage+1 }&loginname=${loginname}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/user/selectByWhere.do?currpage=${totalpage }&loginname=${loginname}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?loginname=${loginname}" method="post">

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