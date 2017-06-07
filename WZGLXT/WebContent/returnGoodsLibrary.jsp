<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>退货出库</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	var bool = false;
	var returngoodslibraryid;
	var j = 0;
	var returnnumber = new Array();
	var returninid = new Array();
	var status;
	function notselected() {
		alert("请选中一行数据！");
	};

	function select(id,statu) {
		$("#" + returngoodslibraryid).removeClass("danger");
		returngoodslibraryid = id;
		$("#" + returngoodslibraryid).addClass("danger");
		status=statu
		bool = true;

	}

	function getnumber(id) {

		returnnumber[id] = document.getElementById("returnnumber" + id).value;

	}

	function returnsub() {
		window.location.href = "insertmany.do?returninid="
				+ returninid + "&returnnumber=" + returnnumber;
	}

	function getjson() {

		$.getJSON('selectone.do?returngoodslibraryid='
				+ returngoodslibraryid, null, function(data) {
			$("#returnNumber").val(data.rglnumber);
			$("#supplierCode").val(data.slbug);
			$("#supplierAbbreviation").val(data.slchianname);
			$("#applicationNo").val(data.rrnumber);
			$("#loginname").val(data.username);
			$("#status").val(data.status);
			$("#libraryDescription").val(data.libraryDescription);
			$("#remarks").val(data.remarks);
			$("#createTime").val(data.fristtime);
			$("#finalProcessingTime").val(data.lasttime);
			$("#createPersonID").val(data.fristname);
			$("#lastPersonID").val(data.lastname);

			if (returninid[data.returninid] != returngoodslibraryid) {
				j = j + 1;
				returnnumber[data.returninid] = data.returnnumber;
				returninid[data.returninid] = data.returninid;

				var a = "<tr align='left' class='warning'><td>" + j
						+ "</td><td>" + data.kuwei + "</td><td>" + 15555555
						+ "</td><td>" + data.itemcode + "</td><td>"
						+ data.itemname + "</td><td>" + data.guige
						+ "</td><td>" + data.dangwei
						+ "</td><td><input type='text' id='returnnumber"
						+ data.returninid + "' value='" + data.returnnumber
						+ "' onchange='getnumber(" + data.returninid
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
				alert("这条退货查询数据单已提交,不能够修改了!");
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
								<td><label>退货单号 </label> <input type="text" id=""
									name="warenumber" class="form-control select-lg" value="${maps['warehousenumber']}"/></td>
								<td><label>退货说明</label> <input type="text" id=""
									name="waresay" class="form-control select-lg" value="${maps['company']}"/></td>

								<td><label>供应商代码</label> <input type="text" id=""
									name="suppliercode" class="form-control select-lg" value="${maps['suppliercode']}"/></td>
								<td><label>状态</label> <select name="status"
									class="form-control select-lg">
										<option value="">请选择状态</option>
										<option value="已确认"  <c:if test="${maps['companyTelephone']=='已确认'}">selected="selected"</c:if>>已确认</option>
										<option value="未确认" <c:if test="${maps['companyTelephone']=='未确认'}">selected="selected"</c:if>>未确认</option>
								</select></td>
							</tr>
							<tr align="center">
								<td><label>供应商名称</label> <input type="text" id=""
									name="suppliername" class="form-control select-lg" value="${maps['chinesename']}"/></td>
								<td><label>时间</label> <input type="text" id="" value="${maps['createtime']}"
									 name="starttime" class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>至</label> <input type="text" id="" value="${maps['finalprocessingtime']}"
									name="endtime" class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><% if(jurisdiction.contains("16")){ %><button class="btn btn-warning" type="button" onclick="edit();">编辑</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">编辑</button><%}%>
									<% if(jurisdiction.contains("17")){ %><button class="btn btn-warning" type="submit">查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
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
					<h3>采购入库单</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr style="background: #edebec;">
									<td><label>退货单号</label> <input type="text"
										id="returnNumber" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>供应商代码</label> <input type="text"
										id="supplierCode" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>供应商名称</label> <input type="text"
										id="supplierAbbreviation" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>退货申请单号</label> <input type="text"
										id="applicationNo" class="form-control select-lg"
										disabled="disabled" /></td>
								</tr>
								<tr style="background: #edebec;">
									<td><label>提交人</label> <input type="text" id="loginname"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>状态</label> <input type="text" id="status"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>出库说明</label> <input type="text"
										id="libraryDescription" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>备注</label> <input type="text" id="remarks"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>
							</table>
							<br />
							<div class="col-md-12 column">
								<div class="row clearfix">
									<table id="pcotable"
										class="table table-condensed table-hover table-striped"
										align="center" style="background: #edebec;">
										<tr class="success" align="center">
											<th></th>
											<th>库位</th>
											<th>批次号</th>
											<th>物品编码</th>
											<th>物品名称</th>
											<th>规格</th>
											<th>单位</th>
											<th>退货数量</th>
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
								<tr align="center" style="background: #edebec;">
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
											onclick="returnsub();">确定</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbi();">关闭</button>
									</td>
								</tr>

							</table>
						</fieldset>
					</form>
				</div>
				</div>
				<table class="table table-condensed table-hover table-striped">
						<tr class="warning">
							<th></th>
							<th>单号</th>
							<th>退货说明</th>
							<th>供应商代码</th>
							<th>供应商名称</th>
							<th>品项数</th>
							<th>状态</th>
							<th>提交时间</th>
							<th>提交人</th>
						</tr>
						<c:forEach items="${rgl }" var="rgl" varStatus="i">
							<tr id="${rgl.returngoodslibraryid }"
								${(i.index+1)%2==0?"class='error'":"class='success'"}
								onclick="select('${rgl.returngoodslibraryid}','${rgl.status }');">
								<td>${i.index+1 }</td>
								<td>${rgl.returnnumber }</td>
								<td>${rgl.librarydescription }</td>
								<td>${rgl.suppliercode }</td>
								<td>${rgl.chinesename }</td>

								<td>${rgl.returnquantity }</td>
								<td>${rgl.status }</td>
								<td><fmt:formatDate value="${rgl.lastmodifiedtime }"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
								<td><c:forEach items="${user }" var="us">
										<c:if test="${us.userid==rgl.lastmodifiedid }">${us.loginname }</c:if>
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
									href="${pageContext.request.contextPath }/returnGoodsLibrary/selectByWhere.do?currpage=1&warenumber=${maps['warehousenumber']}&waresay=${maps['company']}&suppliercode=${maps['suppliercode']}&status=${maps['companyTelephone']}&suppliername=${maps['chinesename']}&starttime=${maps['finalprocessingtime']}&endtime=${maps['finalprocessingtime']}">首页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/returnGoodsLibrary/selectByWhere.do?currpage=${currpage-1 }&warenumber=${maps['warehousenumber']}&waresay=${maps['company']}&suppliercode=${maps['suppliercode']}&status=${maps['companyTelephone']}&suppliername=${maps['chinesename']}&starttime=${maps['finalprocessingtime']}&endtime=${maps['finalprocessingtime']}">上一页</a></li>

								<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
									end="${currpage+2 }" step="1" var="i">
									<c:if test="${i>0&&i<=totalpage?'true':'false'}">
										<li><a
											href="${pageContext.request.contextPath }/returnGoodsLibrary/selectByWhere.do?currpage=${i }&warenumber=${maps['warehousenumber']}&waresay=${maps['company']}&suppliercode=${maps['suppliercode']}&status=${maps['companyTelephone']}&suppliername=${maps['chinesename']}&starttime=${maps['finalprocessingtime']}&endtime=${maps['finalprocessingtime']}"
											${i==currpage?"style='color: red'":"" }>${i}</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/returnGoodsLibrary/selectByWhere.do?currpage=${currpage+1 }&warenumber=${maps['warehousenumber']}&waresay=${maps['company']}&suppliercode=${maps['suppliercode']}&status=${maps['companyTelephone']}&suppliername=${maps['chinesename']}&starttime=${maps['finalprocessingtime']}&endtime=${maps['finalprocessingtime']}">下一页</a></li>
								<li><a
									href="${pageContext.request.contextPath }/returnGoodsLibrary/selectByWhere.do?currpage=${totalpage }&warenumber=${maps['warehousenumber']}&waresay=${maps['company']}&suppliercode=${maps['suppliercode']}&status=${maps['companyTelephone']}&suppliername=${maps['chinesename']}&starttime=${maps['finalprocessingtime']}&endtime=${maps['finalprocessingtime']}">尾页</a></li>
							</ul>
						</div>
						<div class="col-md-5 column" style="padding-top: 10px">
							<form class="navbar-form navbar-left" role="search"
								action="selectByWhere.do?warenumber=${maps['warehousenumber']}&waresay=${maps['company']}&suppliercode=${maps['suppliercode']}&status=${maps['companyTelephone']}&suppliername=${maps['chinesename']}&starttime=${maps['finalprocessingtime']}&endtime=${maps['finalprocessingtime']}" method="post">

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