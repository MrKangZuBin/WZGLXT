<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>领料出库</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	var bool = false;
	var j = 0;
	var status;
	var materiallibraryid;
	var miiid = new Array();
	var minnumber = new Array();
	var countnumber = new Array();
	var status;
	
	function materialLibrarysub(id) {
		var warehouseids = document.getElementById("warehouseids").value;
		var itemnames = document.getElementById("itemnames").value;
		var numbers = document.getElementById("numbers").value;
		var descriptions = document.getElementById("descriptions").value;
		var organizationnames = document.getElementById("organizationnames").value;
		$.getJSON('insert.do?warehouseids=' + warehouseids
				+ '&itemnames=' + itemnames + '&numbers='
				+ numbers + '&descriptions=' + descriptions + '&organizationnames='
				+ organizationnames +'&userid='+id, null,
				function(data) {
					alert(data.status);
					if (data.status == "该物品不存在,请输入正确的物品.") {
					} else {
						window.location.href = "selectByWhere.do";
					}

				});
	}
	
	function notselected() {
		alert("请选中一行数据！");
	};

	function select(id,statu) {
		$("#" + materiallibraryid).removeClass("danger");
		materiallibraryid = id;
		$("#" + materiallibraryid).addClass("danger");
		status=statu
		bool = true;

	}

	function getnumber(id) {
		minnumber[id] = document.getElementById("minnumber" + id).value;

	}

	function miisub() {
		window.location.href = "insertmany.do?minnumber="
				+ minnumber + "&miiid=" + miiid + "&countnumber=" + countnumber;
	}

	function getjson() {

		$.getJSON('selectone.do?materiallibraryid='
				+ materiallibraryid, null, function(data) {
			$("#requisitionnumber").val(data.mlnumber);
			$("#inventorylocationname").val(data.ilname);
			$("#organizationname").val(data.ozname);
			$("#pickingid").val(data.pickingid);
			$("#state").val(data.state);
			$("#description").val(data.description);
			$("#createTime").val(data.fristtime);
			$("#finalProcessingTime").val(data.lasttime);
			$("#createPersonID").val(data.fristname);
			$("#lastPersonID").val(data.lastname);

			if (miiid[data.miiid] != data.miiid) {
				j = j + 1;
				minnumber[data.miiid] = data.minnumber;
				miiid[data.miiid] = data.miiid;
				countnumber[data.miiid] = data.countnumber;
				var a = "<tr align='left' class='warning'><td>" + j
						+ "</td><td>" + data.ilname + "</td><td>" + 15555555
						+ "</td><td>" + data.itemcode + "</td><td>"
						+ data.itemname + "</td><td>" + data.tiaoma
						+ "</td><td>" + data.guige + "</td><td>"
						+ data.materialmaterial + "</td><td>" + data.dangwei
						+ "</td><td>" + data.countnumber
						+ "</td><td><input type='text' id='minnumber"
						+ data.miiid + "' value='" + data.minnumber
						+ "' onchange='getnumber(" + data.miiid
						+ ")'/></td></tr>";
				$("#pcotable").append(a);
			}

		});

	}

	function edit() {
		if (!bool) {
			notselected();
			return false;
		} else {
			if (status == "未确认") {
				getjson();
				applyed();
			} else if (status == "已确认") {
				alert("这条报损数据单已提交,不能够修改了!");
			}
		}

	}
	function guanbies() {
		$("#gray").hide();
		$("#addinventory").hide();//查找ID为popup的DIV hide()隐藏
	}

	function addmiiloss() {
		$("#gray").show();
		$("#addinventory").show();
		tc_center();
	}

	
	//点击登录class为tc 显示
	function applyeds() {

		$("#caigou").show();//查找ID为popup的DIV show()显示#gray
		$("#popuporder").hide();
		tc_center();
	}

	function guanbis() {
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
		$("#popuporder").show();
	}

	//点击登录class为tc 显示
	function applyed(number) {
		$("#gray").show();
		$("#popuporder").show();//查找ID为popup的DIV show()显示#gray
		tc_center();
	}

	//点击关闭按钮
	$("a.guanbi").click(function() {
		$("#gray").hide();
		$("#popuporder").hide();//查找ID为popup的DIV hide()隐藏
	})

	function guanbi() {
		$("#gray").hide();
		$("#popuporder").hide();//查找ID为popup的DIV hide()隐藏
	}

	//等待dom元素加载完毕.
	$(
			function() {
				$(".treebox .level1>a").click(
						function() {
							$(this).addClass('current') //给当前元素添加"current"样式
							.find('i').addClass('down') //小箭头向下样式
							.parent().next().slideDown('slow', 'easeOutQuad') //下一个元素显示
							.parent().siblings().children('a').removeClass(
									'current')//父元素的兄弟元素的子元素去除"current"样式
							.find('i').removeClass('down').parent().next()
									.slideUp('slow', 'easeOutQuad');//隐藏
							return false; //阻止默认时间
						});
			})
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
				<form class="form-inline"
					action="selectByWhere.do" method="post">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>领料单号 </label> <input type="text" id=""
									name="warenumber" class="form-control select-lg"
									value="${maps['warehousenumber'] }" /></td>
								<td><label>说明</label> <input type="text" id=""
									name="waresay" class="form-control select-lg"
									value="${maps['company'] }" /></td>
								<td><label>状态</label> <select id="" name="status"
									class="form-control select-lg">
										<option value="">请选择状态</option>
										<option value="未确认"
											<c:if test="${maps['status']=='未确认'}">selected="selected"</c:if>>未确认</option>
										<option value="已确认"
											<c:if test="${maps['status']=='已确认'}">selected="selected"</c:if>>已确认</option>
								</select></td>
								<td><label>仓库</label> <input type="text" id=""
									name="warehousename" class="form-control select-lg"
									value="${maps['warehousemanagementid'] }" /></td>

							</tr>
							<tr align="center">
								<td><label>时间</label> <input type="text" id=""
									value="${maps['createtime'] }" name="starttime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
								<td><label>至</label> <input type="text" id=""
									value="${maps['finalprocessingtime'] }" name="endtime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
								<td><label>部门</label> <select id="" name="organizationname"
									class="form-control select-lg">
										<option value="">请选择部门</option>
										<c:forEach items="${oz }" var="oz">
											<option value="${oz.organizationid }"
												<c:if test="${maps['organizationName']==oz.organizationid}">selected="selected"</c:if>>${oz.organizationname }</option>
										</c:forEach>
								</select></td>
								<td><label>领料人</label> <select name="subname"
									class="form-control select-lg">
										<option value="">请选择领料人</option>
										<c:forEach items="${user }" var="users">
											<option value="${users.userid }"
												<c:if test="${maps['lastpersonid']==users.userid}">selected="selected"</c:if>>${users.loginname }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td colspan="2"></td>
								<td colspan="2" align="right">
									<% if(jurisdiction.contains("18")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
									<% if(jurisdiction.contains("20")){ %><button class="btn btn-warning" type="button" onclick="edit();">编辑</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">编辑</button><%}%>
									<% if(jurisdiction.contains("19")){ %><button class="btn btn-warning" type="button" onclick="addmiiloss();">新增</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>
								</td>
							</tr>
						</table>
					</fieldset>
				</form>
				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<h3>采购入库单</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr class="success">
									<td><label>领料单号</label> <input type="text"
										id="requisitionnumber" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>仓库</label> <input type="text"
										id="inventorylocationname" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>部门</label> <input type="text"
										id="organizationname" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>领料人</label> <input type="text" id="pickingid"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>
								<tr class="success">
									<td><label>状态</label> <input type="text" id="state"
										class="form-control select-lg" disabled="disabled" /></td>
									<td colspan="3"><label>领料说明</label> <input type="text"
										id="description" class="form-control select-lg"
										disabled="disabled" /></td>
								</tr>
							</table>
							<br />
							<div class="col-md-12 column">
								<div class="row clearfix">

									<table id="pcotable"
										class="table table-condensed table-hover table-striped"
										align="center">

										<tr class="success" align="center">
											<th></th>
											<th>库位</th>
											<th>批次号</th>
											<th>物品代码</th>
											<th>物品名称</th>
											<th>物品条码</th>
											<th>规格</th>
											<th>物料类型</th>
											<th>单位</th>
											<th>库存</th>
											<th>领料数量</th>
										</tr>
									</table>
								</div>
							</div>

						</fieldset>
					</form>

					<br />
					<p>
					<form class="form-inline">
						<fieldset>
							<table class="table">
								<tr class="success" align="center" style="background: #edebec;">
									<td><label>创建时间</label> <input type="text" id="createTime"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>创建人</label> <input type="text"
										id="createPersonID" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>最后修改时间</label> <input type="text"
										id="finalProcessingTime" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>最后修改人</label> <input type="text"
										id="lastPersonID" class="form-control select-lg"
										disabled="disabled" /></td>
								</tr>
								<tr align="center" background="#FFFF00">
									<td colspan="4">
										<button class="btn btn-warning" type="button"
											onclick="miisub();">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbi();">关闭</button>
									</td>
								</tr>

							</table>
						</fieldset>
					</form>
				</div>
				<br />

				<div id="addinventory" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbies();"></a>
					</div>
					<h3>领料出库添加</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed" style="background: #edebec;">
								<tr>
									<td><label>领料仓库</label></td>
									<td><select id="warehouseids"
										class="form-control select-lg">
											<option></option>
											<c:forEach items="${wm }" var="wm">
												<option value="${wm.warehousemanagementid }">${wm.warehousename }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label>领料物品</label></td>
									<td><input type="text" id="itemnames"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>领料部门</label></td>
									<td><select id="organizationnames" class="form-control select-lg">
											<option value="">请选择部门</option>
											<c:forEach items="${oz }" var="oz">
												<option value="${oz.organizationid }"
													<c:if test="${maps['organizationName']==oz.organizationid}">selected="selected"</c:if>>${oz.organizationname }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label>领料说明</label></td>
									<td><input type="text" id="descriptions"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>领料数量</label></td>
									<td><input type="text" id="numbers"
										class="form-control select-lg" /></td>
									<td></td>
								</tr>
								<tr align="center">
									<td colspan="2">
										<button class="btn btn-warning" type="button"
											onclick="materialLibrarysub('${userID }');">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbies();">关闭</button>
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>

				<table class="table table-condensed table-hover table-striped">
					<thead>
						<tr class="warning">
							<th></th>
							<th>单号</th>
							<th>领料说明</th>
							<th>仓库</th>
							<th>品项数</th>
							<th>部门</th>
							<th>领料人</th>
							<th>状态</th>
							<th>领料时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ml }" var="ml" varStatus="i">
							<tr id="${ml.materiallibraryid }"
								${(i.index+1)%2==0?"class='error'":"class='success'"}
								onclick="select('${ml.materiallibraryid}','${ml.state }');">
								<td>${i.index+1 }</td>
								<td>${ml.requisitionnumber }</td>
								<td>${ml.description }</td>
								<td>${ml.inventorylocationname }</td>
								<td>${ml.number }</td>

								<td>${ml.organizationname }</td>
								<td>${ml.loginname }</td>
								<td>${ml.state }</td>
								<td><fmt:formatDate value="${ml.lastprocessingtime }"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-2 column" style="padding-top: 20px">
							<h5>共${pagecount }条记录 &nbsp;当前${currpage }/${totalpage }页&nbsp;</h5>
						</div>
						<div class="col-md-5 column">
							<ul class="pagination">

								<li><a
									href="${pageContext.request.contextPath }/MaterialLibraryID/selectByWhere.do?currpage=1&warenumber=${maps['warehousenumber'] }&waresay=${maps['company'] }&status=${maps['status']}&warehousename=${maps['warehousemanagementid'] }&starttime=${maps['createtime'] }&endtime=${maps['finalprocessingtime'] }&organizationname=${maps['organizationName']}&subname=${maps['lastpersonid']}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/MaterialLibraryID/selectByWhere.do?currpage=${currpage-1 }&warenumber=${maps['warehousenumber'] }&waresay=${maps['company'] }&status=${maps['status']}&warehousename=${maps['warehousemanagementid'] }&starttime=${maps['createtime'] }&endtime=${maps['finalprocessingtime'] }&organizationname=${maps['organizationName']}&subname=${maps['lastpersonid']}">上一页</a></li>

								<c:forEach begin="${currpage-1>=0?currpage-1:'0' }"
									end="${currpage+1 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/MaterialLibraryID/selectByWhere.do?currpage=${i }&warenumber=${maps['warehousenumber'] }&waresay=${maps['company'] }&status=${maps['status']}&warehousename=${maps['warehousemanagementid'] }&starttime=${maps['createtime'] }&endtime=${maps['finalprocessingtime'] }&organizationname=${maps['organizationName']}&subname=${maps['lastpersonid']}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/MaterialLibraryID/selectByWhere.do?currpage=${currpage+1 }&warenumber=${maps['warehousenumber'] }&waresay=${maps['company'] }&status=${maps['status']}&warehousename=${maps['warehousemanagementid'] }&starttime=${maps['createtime'] }&endtime=${maps['finalprocessingtime'] }&organizationname=${maps['organizationName']}&subname=${maps['lastpersonid']}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/MaterialLibraryID/selectByWhere.do?currpage=${totalpage }&warenumber=${maps['warehousenumber'] }&waresay=${maps['company'] }&status=${maps['status']}&warehousename=${maps['warehousemanagementid'] }&starttime=${maps['createtime'] }&endtime=${maps['finalprocessingtime'] }&organizationname=${maps['organizationName']}&subname=${maps['lastpersonid']}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?warenumber=${maps['warehousenumber'] }&waresay=${maps['company'] }&status=${maps['status']}&warehousename=${maps['warehousemanagementid'] }&starttime=${maps['createtime'] }&endtime=${maps['finalprocessingtime'] }&organizationname=${maps['organizationName']}&subname=${maps['lastpersonid']}"
								method="post">

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