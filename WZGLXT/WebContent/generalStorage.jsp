<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>普通入库</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript" language="javascript" src="jquery.js"></script>
<script type="text/javascript">
	var bool = false;
	var generalstorageid;
	var nownumber = new Array();
	var nowid = new Array();
	var j = 0;
	function notselected() {
		alert("请选中一行数据！");
	};

	function inventorylosssub(id) {

		var warehouseid = document.getElementById("warehouseid").value;
		var itemname = document.getElementById("itemname").value;
		var number = document.getElementById("number").value;
		var description = document.getElementById("description").value;
		var lossReason = document.getElementById("lossReason").value;

		$.getJSON('insert.do?warehouseid=' + warehouseid + '&itemname='
				+ itemname + '&number=' + number + '&description='
				+ description + '&userid=' + id + '&lossReason=' + lossReason,
				null, function(data) {
					alert(data.status);
					if (data.status == "该物品不存在,请输入正确的物品.") {
					} else {
						window.location.href = "selectByWhere.do";
					}

				});
	}

	function Purchasing(id) {
		nownumber[id] = document.getElementById("nownumber" + id).value;
	}

	function select(id) {
		$("#" + generalstorageid).removeClass("danger");
		generalstorageid = id;
		$("#" + generalstorageid).addClass("danger");
		bool = true;

	}

	function getjson() {

		$.getJSON('selectone.do?generalstorageid=' + generalstorageid, null,
				function(data) {
					$("#warehouseNumber").val(data.warenumber);
					$("#buyerID").val(data.buyerid);
					$("#warehouseName").val(data.warehouse);
					$("#company").val(data.companytelephone);
					$("#createTime").val(data.createtime);
					$("#finalProcessingTime").val(data.lasttime);
					$("#createPersonID").val(data.createpreson);
					$("#lastPersonID").val(data.lastpreson);
					$("#wuliao").val(data.wuliao);

				});

	}

	function edit() {

		if (!bool) {
			notselected();
			return false;
		} else {
			getjson();
			applyed();
		}

	}

	//点击登录class为tc 显示
	function getgeneral() {

		$("#addgeneral").show();//查找ID为popup的DIV show()显示#gray
		$("#gray").show();
		tc_center();
	}

	function guanbis() {
		$("#addgeneral").hide();//查找ID为popup的DIV show()显示#gray
		$("#gray").hide();
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
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<form class="form-inline" action="selectByWhere.do" method="post">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>入库单号 </label> <input type="text"
									name="warenumber" class="form-control select-lg"
									value="${map['warehousenumber']}" /></td>
								<td><label>时间</label> <input type="text" name="starttime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
									value="${map['createtime']}" /></td>
								<td><label>至</label> <input type="text" name="endtime"
									class="form-control select-lg"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
									value="${map['finalprocessingtime']}" /></td>
								<td><label>提交人</label> <select name="subname"
									class="form-control select-lg">
										<option></option>
										<c:forEach items="${user }" var="users">
											<option value="${users.userid }"
												<c:if test="${map['lastpersonid']==users.userid }">selected="selected"</c:if>>${users.loginname }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr align="center">
								<td><label>仓库</label> <input type="text"
									name="warehousename" class="form-control select-lg"
									value="${map['warehousemanagementid']}" /></td>
								<td><label>入库说明</label> <input type="text" name="waresay"
									class="form-control select-lg" value="${map['company']}" /></td>
								<td><input type="radio" name="wuliao"
									class="form-control select-lg" value="IMPA物料"
									<c:if test="${map['materialmaterial']=='IMPA物料'}">checked="checked"</c:if> />IMPA物料<input
									type="radio" name="wuliao" class="form-control select-lg"
									value="普通物料"
									<c:if test="${map['materialmaterial']=='普通物料'}">checked="checked"</c:if> />普通物料</td>
								<td>
								<% if(jurisdiction.contains("12")){ %><button class="btn btn-warning" type="submit" >查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
								<% if(jurisdiction.contains("13")){ %><button id="addpurchaseOrder" class="btn btn-warning"type="button" onclick="getgeneral();">新增</button><%}else{%><button class="btn btn-warning" type="button" onclick="rootget();">新增</button><%}%>	
								<% if(jurisdiction.contains("14")){ %><button class="btn btn-warning" type="button" onclick="edit();">编辑</button><%}else{%><button class="btn btn-warning" type="button" onclick="rootget();">编辑</button><%}%>	
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
					<h3>普通入库单</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed table-hover table-striped">
								<tr>
									<td><label>入库单号</label> <input type="text"
										id="warehouseNumber" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>采购人</label> <input type="text" id="buyerID"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>仓库</label> <input type="text"
										id="warehouseName" class="form-control select-lg"
										disabled="disabled" /></td>


								</tr>
								<tr>
									<td><label>入库说明</label> <input type="text" id="company"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>物料类型</label> <input type="text" id="wuliao"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>创建时间</label> <input type="text" id="createTime"
										class="form-control select-lg" disabled="disabled" /></td>

								</tr>
								<tr>
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
									<td colspan="3">
										<button class="btn btn-warning" type="button"
											onclick="guanbi();">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbi();">关闭</button>
									</td>
								</tr>

							</table>
						</fieldset>
					</form>
					<a class="guanbi"></a>
				</div>

				<div id="addgeneral" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbis();"></a>
					</div>
					<h3>普通入库添加</h3>
					<form class="form-inline">
						<fieldset>
							<table class="table table-condensed" style="background: #edebec;">
								<tr>
									<th>入库仓库</th>
									<td><select id="warehouseid"
										class="form-control select-lg">
											<option></option>
											<c:forEach items="${wm }" var="wm">
												<option value="${wm.warehousemanagementid }">${wm.warehousename }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><label>入库物品</label></td>
									<td><input type="text" id="itemname"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>入库数量</label></td>
									<td><input type="text" id="number"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>入库原因</label></td>
									<td><input type="text" id="lossReason"
										class="form-control select-lg" /></td>
								</tr>
								<tr>
									<td><label>备注</label></td>
									<td><input type="text" id="description"
										class="form-control select-lg" /></td>
								</tr>
								<tr align="center" background="#FFFF00">
									<td colspan="2">
										<button class="btn btn-warning" type="button"
											onclick="inventorylosssub('${userID }');">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbis();">关闭</button>
									</td>
								</tr>

							</table>
						</fieldset>
					</form>
					<a class="guanbis"></a>
				</div>

				<table class="table table-condensed table-hover table-striped">
					<thead>
						<tr class="warning">
							<th>序号</th>
							<th>入库单号</th>
							<th>入库说明</th>
							<th>仓库</th>
							<th>入库数量</th>
							<th>物料类型</th>
							<th>提交时间</th>
							<th>提交人</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${gsp }" var="gsp" varStatus="i">
							<tr id="${gsp.generalstorageid }"
								${(i.index+1)%2==0?"class='error'":"class='success'"}
								onclick="select('${gsp.generalstorageid}');">
								<td>${i.index+1 }</td>
								<td>${gsp.warehousenumber }</td>
								<td>${gsp.storageinstructions }</td>
								<td>${gsp.warehousename }</td>
								<td>${gsp.storagequantity }</td>
								<td>${gsp.materialmaterial }</td>

								<td><fmt:formatDate value="${gsp.lastmodifiedtime }"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
								<td><c:forEach items="${user }" var="us">
										<c:if test="${us.userid==gsp.lastmodifiedid }">${us.loginname }</c:if>
									</c:forEach></td>
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
									href="${pageContext.request.contextPath }/generalStorage/selectByWhere.do?currpage=1&warenumber=${map['warehousenumber']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/generalStorage/selectByWhere.do?currpage=${currpage-1 }&warenumber=${map['warehousenumber']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">上一页</a></li>

								<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/generalStorage/selectByWhere.do?currpage=${i }&warenumber=${map['warehousenumber']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/generalStorage/selectByWhere.do?currpage=${currpage+1 }&warenumber=${map['warehousenumber']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/generalStorage/selectByWhere.do?currpage=${totalpage }&warenumber=${map['warehousenumber']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?warenumber=${map['warehousenumber']}&starttime=${map['createtime']}&endtime=${map['finalprocessingtime']}&subname=${map['lastpersonid']}&warehousename=${map['warehousemanagementid']}&waresay=${map['company']}&wuliao=${map['materialmaterial']}"
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