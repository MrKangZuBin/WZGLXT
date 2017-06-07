<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-物品分类</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Nuevo Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="applijegleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath }/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css"
	integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js"
	integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK"
	crossorigin="anonymous"></script>
<!-- start menu -->
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="${pageContext.request.contextPath }/js/menu_jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/simpleCart.min.js">
	
</script>
<!--web-fonts-->
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700'
	rel='stylesheet' type='text/css'>

<script type="text/javascript">
	var categoryid;
	var categorycode;
	var categoryname;
	var categorydesc;
	var categoryfid;
	var categorysid;
	var categorytime;
	var categorypsonid;
	var categorypson;
	var bool=false;
	function selected(cateid,catecode,catename,catedesc,catefid,catesid,catetime,catepsonid,catepson){
		$("#"+categoryid).removeClass("danger");
		categoryid=cateid;
		categorycode=catecode;
		categoryname=catename;
		categorydesc=catedesc;
		categoryfid=catefid;
		categorysid=catesid;
		categorytime=catetime;
		categorypsonid=catepsonid;
		categorypson=catepson;
		bool=true;
		//$("#"+categoryid).attr("class", "info");
		$("#"+categoryid).addClass("danger");
	}
	function getaddjson() {
		$.ajax({
			url:"${pageContext.request.contextPath}/category/selRequest.do",
			type:"post",
			datatType:"json",
			success:function(data){
				$("#categorycode").val(data.code);
			}
		});
	}
	function siblingadd() {
		$(':text').val("");
		getaddjson();
		$("#categorytimedv").hide();
		$("#categorypsondv").hide();
		$("#categoryfid").val(categoryfid);
		$("#categorysid").val(categorysid);
		$("#subform").attr("action","${pageContext.request.contextPath }/category/add.do");
		applyed();
	};
	function notselected() {
			alert("请选中一行数据！");
	};
	function nextadd() {
		if(!bool){
			notselected();
			return false;
		}
		$(':text').val("");
		getaddjson();
		$("#categorytimedv").hide();
		$("#categorypsondv").hide();
		$("#categoryfid").val(categoryid);
		$("#categorysid").val(categorysid);
		$("#subform").attr("action","${pageContext.request.contextPath }/category/add.do");
		
		applyed();
	};
	function edit() {
		if(!bool){
			notselected();
			return false;
		}
		$("#categorytimedv").show();
		$("#categorypsondv").show();
		$("#categoryid").val(categoryid);
		$("#categorycode").val(categorycode);
		$("#categoryname").val(categoryname);
		$("#categorydesc").val(categorydesc);
		$("#categorytime").text(categorytime);
		$("#categorypsonid").val(categorypsonid);
		$("#categorypson").text(categorypson);
		$("#subform").attr("action","${pageContext.request.contextPath }/category/update.do");
		
		applyed();
	};
	function del() {
		if(!bool){
			notselected();
			return false;
		}
		$("#delcategoryid").val(categoryid);
		$("#delform").attr("action","${pageContext.request.contextPath }/category/delete.do");
		$("#gray").show();
		$("#popupdel").show();
		tc_center();
	};
	function applyed() {
		$("#gray").show();
		$("#popup").show();//查找ID为popup的DIV show()显示#gray
		center();
	};
	//点击关闭按钮
	function hide() {
		$("#gray").hide();
		$("#popup").hide();//查找ID为popup的DIV hide()隐藏
	}
	function hidedel() {
		$("#gray").hide();
		$("#popupdel").hide();
	}
	function center(){
		var _top=($(window).height()-$("#popup").height())/2;
		var _left=($(window).width()-$("#popup").width())/2;
		$("#popup").css({top:_top,left:_left});
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
			<h5 style="color: #ff3300">
				此操作将会删除此数据以及<br>其下级所有数据，是否继续？
			</h5>
		</center>
		<br>
		<form class="form-horizontal" role="form" id="delform" action="#"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }"> <input
				type="hidden" name="categoryfid" value="${firstid }"> <input
				type="hidden" id="delcategoryid" name="categoryid">
			<center>
				<input style="padding-left: 30px; padding-right: 30px" type="button"
					class="btn btn-info" onclick="hidedel()" value="取消"> <input
					style="padding-left: 30px; padding-right: 30px" type="submit"
					class="btn btn-danger" value="确认" />
			</center>
		</form>
	</div>
	<div class="popup" id="popup" style="padding-bottom: 35px;">
		<div class="top_nav" id='top_nav'
			style="padding-top: 20px; width: 500px">
			<span>类别新增/编辑 </span><a class="guanbi" onclick="hide();"></a><br>
		</div>
		<br>
		<form class="form-horizontal" role="form" id="subform" action="#"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" name="categoryfid" value="${firstid }" /> <input
				type="hidden" id="categoryid" name="categoryid" /> <input
				type="hidden" id="categoryfid" name="firstid" /> <input
				type="hidden" id="categorysid" name="secondid" /> <input
				type="hidden" id="categorypsonid" name="createpersonid"
				value="${userID }" />
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">类别编码</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="categorycode"
						name="categorycode" readonly="readonly" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">类别名称</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="categoryname"
						name="categoryname" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</label>
				<div class="col-sm-7">
					<textarea class="form-control" rows="2" cols="20" id="categorydesc"
						name="description"></textarea>
				</div>
			</div>
			<div class="form-group" id="categorypsondv">
				<label for="inputPassword3" class="col-sm-3 control-label">创建人</label>
				<div class="col-sm-7">
					<h4 style="color: #979797" id="categorypson"></h4>
				</div>
			</div>
			<div class="form-group" id="categorytimedv">
				<label for="inputPassword3" class="col-sm-3 control-label">创建时间</label>
				<div class="col-sm-7">
					<h4 style="color: #979797" id="categorytime"></h4>
				</div>
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
				<h3 class="b-tittle" style="color: #00ccff">物品分类</h3>
				<%
					if (jurisdiction.contains("35")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="siblingadd()">同级新增</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button"
					onclick="rootget();">同级新增</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("35")) {
				%><button id="nextadd" type="button"
					class="btn btn-defult btn-warning"
					onclick="if(${secondid!=3?'true':'false' }){nextadd();}else{alert('已是最低级');};">下级新增</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button"
					onclick="rootget();">下级新增</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("38")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="edit()">编辑</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button"
					onclick="rootget();">编辑</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("37")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="del()">删除</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button"
					onclick="rootget();">删除</button>
				<%
					}
				%>
				<button type="button" class="btn btn-defult btn-info"
					onclick="if(${secondid==2?'true':'false' }){javascript:window.location.href='${pageContext.request.contextPath }/category/paginglist.do?categoryid=${firstid}&&currpage=${fcurrpage }'}else if(${secondid==3?'true':'false' }){javascript:window.location.href='${pageContext.request.contextPath }/category/paginglist.do?categoryid=${firstid}&&currpage=${scurrpage }'}else{alert('已经是最高级 了')}">返回上一级</button>
				<c:choose>
					<c:when test="${list!='[]'}">
						<table class="table table-hover table-bordered"
							style="margin-top: 10px">
							<thead>
								<tr class="info">
									<th>序号</th>
									<th>类别编码</th>
									<th>类别名称</th>
									<th>创建时间</th>
									<th>创建人</th>
									<th>备注</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="category" varStatus="i">
									<tr id="${category.categoryid }"
										${(i.index+1)%2==0?"class='error'":"class='success'"}
										onclick="selected('${category.categoryid }','${category.categorycode }','${category.categoryname }','${category.description }','${category.firstid }','${category.secondid }','<fmt:formatDate value="${category.createtime }"
												type="both"/>','${category.createpersonid }','${category.name }')">
										<td>${i.index+1 }</td>
										<td>${category.categorycode }</td>
										<td
											title="${category.secondid==1||category.secondid==2?'点击进入下一级':'无更多数据' }"
											style="cursor: pointer;"
											onclick="if(${category.secondid==1?'true':'false' }){javascript:window.location.href='${pageContext.request.contextPath }/category/paginglist.do?ffirstid=${category.categoryid}&&fcurrpage=${currpage }'}else if(${category.secondid==2?'true':'false' }){javascript:window.location.href='${pageContext.request.contextPath }/category/paginglist.do?ffirstid=${category.categoryid}&&scurrpage=${currpage }'}">${category.categoryname }</td>
										<td><fmt:formatDate value="${category.createtime }"
												type="both" /></td>
										<td>${category.name }</td>
										<td>${category.description }</td>
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
												href="${pageContext.request.contextPath }/category/paginglist.do?currpage=1&&firstid=${firstid}">首页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/category/paginglist.do?currpage=${currpage-1 }&&firstid=${firstid}">上一页</a></li>

											<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
												end="${currpage+2 }" step="1" var="i">
												<c:if test="${i>0&&i<=totalpage?'true':'false'}">
													<li><a
														href="${pageContext.request.contextPath }/category/paginglist.do?currpage=${i }&&firstid=${firstid}"
														${i==currpage?"style='color: red'":"" }>${i}</a></li>
												</c:if>
											</c:forEach>
											<li><a
												href="${pageContext.request.contextPath }/category/paginglist.do?currpage=${currpage+1 }&&firstid=${firstid}">下一页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/category/paginglist.do?currpage=${totalpage }&&firstid=${firstid}">尾页</a></li>
										</ul>
									</div>
								</td>
								<td width="32%">
									<div style="padding-top: 10px">
										<form class="navbar-form navbar-left" role="search"
											action="${pageContext.request.contextPath }/category/paginglist.do?firstid=${firstid}"
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