<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>库存报损</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	var bool = false;
	var inventorylossid;
	var status;
	var j = 0;
	var lossid = new Array();
	var lossnumber = new Array();
	var lossreason = new Array();
	var lossinid = new Array();

	function notselected() {
		alert("请选中一行数据！");
	};

	function select(id, statu) {
		$("#" + inventorylossid).removeClass("danger");
		inventorylossid = id;
		$("#" + inventorylossid).addClass("danger");
		bool = true;
		status = statu;
	}

	function inventorylosssub(id) {

		var warehouseid = document.getElementById("warehouseid").value;
		var itemname = document.getElementById("itemname").value;
		var inventlossnumber = document.getElementById("inventlossnumber").value;
		var description = document.getElementById("description").value;
		var remark = document.getElementById("remark").value;
		var lossReason = document.getElementById("lossReason").value;

		$.getJSON('insert.do?warehouseid=' + warehouseid
				+ '&itemname=' + itemname + '&inventlossnumber='
				+ inventlossnumber + '&description=' + description + '&remark='
				+ remark + '&userid=' + id + '&lossReason=' + lossReason, null,
				function(data) {
					alert(data.status);
					if (data.status == "该物品不存在,请输入正确的物品.") {
					} else {
						window.location.href = "selectByWhere.do";
					}

				});
	}

	function guanbies() {
		$("#gray").hide();
		$("#addinventoryloss").hide();//查找ID为popup的DIV hide()隐藏
	}

	function addinventoryloss() {
		$("#gray").show();
		$("#addinventoryloss").show();
		tc_center();
	}

	function losssub(userid) {
		window.location.href = "insertmany.do?lossid=" + lossid
				+ "&lossnumber=" + lossnumber + "&lossreason=" + lossreason
				+ "&lossinid=" + lossinid + "&userid=" + userid;
	}

	function getnumber(id) {

		lossnumber[id] = document.getElementById("lossnumber" + id).value;

	}

	function getreason(id) {

		lossreason[id] = document.getElementById("lossreason" + id).value;
	}

	function getjson() {

		$.getJSON('selectone.do?inventorylossid='
				+ inventorylossid, null, function(data) {

			$("#lossnumber").val(data.baosunnumber);
			$("#warehousename").val(data.warehousename);
			$("#status").val(data.status);
			$("#lossdescription").val(data.lossdescription);
			$("#remarks").val(data.remarks);
			$("#createpersonid").val(data.fristname);
			$("#createdate").val(data.fristtime);
			$("#lastmodifiedid").val(data.lastname);
			$("#lastmodifiedtime").val(data.lasttime);

			if (lossid[data.lossid] != data.lossid) {
				j = j + 1;
				lossid[data.lossid] = data.lossid;
				lossnumber[data.lossid] = data.lossnumber;
				lossreason[data.lossid] = data.lossdescription;
				lossinid[data.lossid] = data.lossinid;

				var a = "<tr align='left' class='warning'><td>" + j
						+ "</td><td>" + data.kuwei + "</td><td>" + 15555555
						+ "</td><td>" + data.itemcode + "</td><td>"
						+ data.itemname + "</td><td>" + data.guige
						+ "</td><td>" + data.dangwei + "</td><td>"
						+ data.kucunnumber
						+ "</td><td><input type='text' id='lossnumber"
						+ data.lossid + "' value='" + data.lossnumber
						+ "' onchange='getnumber(" + data.lossid
						+ ")'/></td><td><input type='text' id='lossreason"
						+ data.lossid + "' value='" + data.lossdescription
						+ "' onchange='getreason(" + data.lossid
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
				<form class="form-inline" action="selectByWhere.do"
					method="post">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>报损单号 </label> <input type="text" id=""
									name="lossnumber" class="form-control select-lg" value="${maps['lossnumber'] }"/></td>
								<td><label>报损说明</label> <input type="text" id=""
									name="losssay" class="form-control select-lg" value="${maps['losssay'] }"/></td>
								<td><label>状态</label> <select id="" name="status"
									class="form-control select-lg">
										<option value="">请选择状态</option>
										<option value="未确认" <c:if test="${maps['status']=='未确认'}">selected="selected"</c:if>>未确认</option>
										<option value="已确认" <c:if test="${maps['status']=='已确认'}">selected="selected"</c:if>>已确认</option>
								</select></td>
								<td>
									<% if(jurisdiction.contains("23")){ %><button id="addpurchaseOrder" class="btn btn-warning" type="button" onclick="addinventoryloss();">新增</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>
									<% if(jurisdiction.contains("24")){ %><button class="btn btn-warning" type="button" onclick="edit();">编辑</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">编辑</button><%}%></td>
							</tr>

							<tr align="center">
								<td><label>时间</label> <input type="text" id=""
									name="starttime" class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${maps['starttime'] }"/></td>
								<td><label>至</label> <input type="text" id=""
									name="endtime" class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${maps['endtime'] }"/></td>
								<td><label>报损单位</label> <input type="text" id=""
									name="warename" class="form-control select-lg" value="${maps['warehousename'] }"/></td>
								<td>
									<% if(jurisdiction.contains("22")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
								</td>
							</tr>
						</table>

					</fieldset>
				</form>
				<br />




				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<h3>库存报损</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr class="success">
									<td><label>报损单号</label> <input type="text" id="lossnumber"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>仓库</label> <input type="text"
										id="warehousename" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>状态</label> <input type="text" id="status"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>
								<tr class="success">
									<td><label>报损说明</label> <input type="text"
										id="lossdescription" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>备注</label> <input type="text" id="remarks"
										class="form-control select-lg" disabled="disabled" /></td>
									<td></td>
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
											<th>物品编码</th>
											<th>物品名称</th>
											<th>规格</th>
											<th>单位</th>
											<th>库存数量</th>
											<th>报损数量</th>
											<th>报损原因</th>
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
									<td><label>创建时间</label> <input type="text" id="createdate"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>创建人</label> <input type="text"
										id="createpersonid" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>最后修改时间</label> <input type="text"
										id="lastmodifiedtime" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>最后修改人</label> <input type="text"
										id="lastmodifiedid" class="form-control select-lg"
										disabled="disabled" /></td>
								</tr>
								<tr align="center" background="#FFFF00">
									<td colspan="4">
										<button class="btn btn-warning" type="button"
											onclick="losssub('${userID }');">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbi();">关闭</button>
									</td>
								</tr>

							</table>
						</fieldset>
					</form>
				</div>
				<div id="addinventoryloss" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbies();"></a>
					</div>
					<h3>库存报损添加</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed" style="background: #edebec;">
								<tr>
									<td><label>报损仓库</label></td>
									<td><select id="warehouseid"
										class="form-control select-lg">
											<option></option>
											<c:forEach items="${wm }" var="wm">
												<option value="${wm.warehousemanagementid }">${wm.warehousename }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label>报损物品</label></td>
									<td><input type="text" id="itemname"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>报损数量</label></td>
									<td><input type="text" id="inventlossnumber"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>报损原因</label></td>
									<td><input type="text" id="lossReason"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>报损说明</label></td>
									<td><input type="text" id="description"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>备注</label></td>
									<td><input type="text" id="remark"
										class="form-control select-lg" /></td>
									<td></td>
								</tr>
								<tr align="center">
									<td colspan="2">
										<button class="btn btn-warning" type="button"
											onclick="inventorylosssub('${userID }');">确定</button>
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
							<th>说明</th>
							<th>品项数</th>
							<th>状态</th>
							<th>报损单位</th>
							<th>提交时间</th>
							<th>提交人</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itl }" var="itl" varStatus="i">
							<tr id="${itl.inventorylossid }"
								${(i.index+1)%2==0?"class='error'":"class='success'"}
								onclick="select('${itl.inventorylossid}','${itl.status }');">
								<td>${i.index+1 }</td>
								<td>${itl.lossnumber }</td>
								<td>${itl.lossdescription }</td>
								<td>${itl.numberrs }</td>
								<td>${itl.status }</td>
								<td>${itl.warehousename }</td>
								<td><fmt:formatDate value="${itl.lastModifiedTime }"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
								<td>${itl.loginname }</td>
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
									href="${pageContext.request.contextPath }/InventoryLoss/selectByWhere.do?currpage=1&lossnumber=${maps['lossnumber'] }&losssay=${maps['losssay'] }&status=${maps['status']}&starttime=${maps['starttime'] }&endtime=${maps['endtime'] }&warename=${maps['warehousename'] }">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/InventoryLoss/selectByWhere.do?currpage=${currpage-1 }&lossnumber=${maps['lossnumber'] }&losssay=${maps['losssay'] }&status=${maps['status']}&starttime=${maps['starttime'] }&endtime=${maps['endtime'] }&warename=${maps['warehousename'] }">上一页</a></li>

								<c:forEach begin="${currpage-1>=0?currpage-1:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/InventoryLoss/selectByWhere.do?currpage=${i }&lossnumber=${maps['lossnumber'] }&losssay=${maps['losssay'] }&status=${maps['status']}&starttime=${maps['starttime'] }&endtime=${maps['endtime'] }&warename=${maps['warehousename'] }"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/InventoryLoss/selectByWhere.do?currpage=${currpage+1 }&lossnumber=${maps['lossnumber'] }&losssay=${maps['losssay'] }&status=${maps['status']}&starttime=${maps['starttime'] }&endtime=${maps['endtime'] }&warename=${maps['warehousename'] }">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/InventoryLoss/selectByWhere.do?currpage=${totalpage }&lossnumber=${maps['lossnumber'] }&losssay=${maps['losssay'] }&status=${maps['status']}&starttime=${maps['starttime'] }&endtime=${maps['endtime'] }&warename=${maps['warehousename'] }">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?lossnumber=${maps['lossnumber'] }&losssay=${maps['losssay'] }&status=${maps['status']}&starttime=${maps['starttime'] }&endtime=${maps['endtime'] }&warename=${maps['warehousename'] }" method="post">

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