<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工作台-待采购物资</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	var bool=false;
	//点击登录class为tc 显示
	function xiangqing() {
		getjson();
		toShow();
	}
	function toShow() {
		$("#caigou").show();//查找ID为popup的DIV show()显示#gray
		$("#gray").show();
		tc_center();
	}

	//点击关闭按钮
	$("a.guanbis").click(function() {
		$("#gray").hide();
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
	})
	function guanbis() {
		$("#caigou").hide();//查找ID为popup的DIV hide()隐藏
		$("#gray").hide();
	}
	function timeStamp2String(time){
	    var datetime = new Date();
	    datetime.setTime(time);
	    var year = datetime.getFullYear();
	    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
	    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
	}
	//采购申请单详情
	function getjson() {
		var number = $("#numbers").val()
		$.getJSON('pur/addpur.do?purchaserequisitionid=' + number, null,
			function(data) {
				$("#applicationNo").val(data.applicationNo);
				$("#deptname").val(data.deptname);
				$("#uname").val(data.uName);
				$("#status").val(data.status);
				$("#des").val(data.des);
				$("#getdate").val(data.getdate);
				$("#createdate").val(timeStamp2String(data.createdate));
				$.each(data.frist_iif,function(i,item){
					var a="<tr align='left' class='warning'><td>"+1+"</td><td>"+item.itemcode+"</td><td>"
					+item.chinesename+"</td><td>"+
					item.articlebarcode+"</td><td>"+
					item.purchasespecifications+"</td><td>"+
					0+"</td><td>"+2+"</td><td>"+2+"</td><td>"+
					item.currentstock+"</td></tr>";
					$("#purtable").html(a);
				});
		});
	}
	function add(){
		//getaddjson();
		toaddshow();
	}
	function toaddshow() {
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
	function selected(){
		
	}
</script>
</head>
<body>
	<% List jurisdiction=(List)session.getAttribute("list");%>
	<div id="gray"></div>
	<div  style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div >
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<form class="form-inline" action="${pageContext.request.contextPath }/dcgpur/seldcg.do" method="POST">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>申请单号: </label> <input name="applicationNo" type="text"
									class="form-control select-lg" /></td>
								<td colspan="2"><label>时间:</label> <input type="text" name="createDate"
									class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/><label>至</label> <input
									type="text" name="lastDate" class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>提交人:</label> <select name="commitName"
									class="form-control select-lg">
										<option></option>
										<option>--选择提交人--</option>
										<c:forEach items="${user }" var="users">
											<option>${users.loginname }</option>
										</c:forEach>
								</select></td>
								<td><label>部门:</label> <select name="organizationName"
									class="form-control select-lg">
										<option></option>
										<option>--选择部门--</option>
										<c:forEach items="${org }" var="org">
											<option>${org.organizationname }</option>
										</c:forEach>
								</select></td>
							</tr>

							<tr align="center">
								<td><label>申请说明:</label> <input type="text" name="explains"
									class="form-control select-lg" /></td>
								<td><input type="radio" name="materialMaterial" class="form-control select-lg"
										 value="IMPA物料"/>IMPA物料<input type="radio" name="materialMaterial"
									class="form-control select-lg" value="普通物料"/>普通物料</td>
								<td colspan="2">
									<% if(jurisdiction.contains("54")){ %><button class="btn btn-warning" type="submit" >查询</button><%} else{%><button class="btn btn-warning" type="button" onclick="rootget();">查询</button><%}%>
								</td>
							</tr>
						</table>
					</fieldset>
				</form>

				<div id="popuporder" class="popup" style="padding: 20px">
					<div class="top_nav" id='top_nav'>
						<a class="guanbi" onclick="guanbi();"></a>
					</div>
					<h3>采购申请单</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>采购单号 </label> <input type="text" id="purID"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>申请人</label> <input type="text"
										value="${userName }" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>部门</label> <input type="text" id="deptno"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>状态</label><input type="text" value="未提交"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>

								<tr align="center">
									<td><label>申请说明</label> <input type="text"
										id="purexplains" class="form-control select-lg" /></td>
									<td><label>大仓</label> <input type="text" value="1号仓库"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>备注</label> <input type="text" id="remarks"
										class="form-control select-lg" /></td>
									<td><input type="radio" id="impawuliao"
										class="form-control select-lg" value="IMPA物料"
										checked="checked" disabled="disabled" />IMPA物料<input
										type="radio" id="wuliao" class="form-control select-lg"
										value="普通物品" disabled="disabled" />普通物品</td>
								</tr>
							</table>
							<table class="table table-condensed table-hover table-striped">
								<tr class="warning">
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>物品代码</th>
									<th>物品名称</th>
									<th>物品条码</th>
									<th>规格</th>
									<th>品牌</th>
									<th>单位</th>
									<th>数量</th>
									<th>库存</th>
								</tr>
							</table>
							<table id="caigouleibiao"
								class="table table-condensed table-hover table-striped">
								<tr>
									<td><label>创建时间</label> <input type="text" id=""
										class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
									<td><label>最后处理人</label> <input type="text" id=""
										class="form-control select-lg" /></td>
									<td><label>最后处理时间</label> <input type="text" id=""
										class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								</tr>
								<tr>
									<td align="center" colspan="3">
										<button class="btn btn-warning" type="button">复制</button>
										<button id="" class="btn btn-warning" type="button">保存</button>
										<button class="btn btn-warning" type="button" onclick="">保存并提交</button>
										<button class="btn btn-warning" type="button"
											onclick="guanbi();">关闭</button>
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>
				<div id="caigou" class="popup" style="padding: 20px">
					<div class="top_nav">
						<a class="guanbi" onclick="guanbis();"></a>
					</div>
					<h3>采购申请单</h3>
					<form class="form-inline">
						<fieldset>
							<table>
								<tr align="center">
									<td><label>采购单号 </label> <input type="text"
										id="applicationNo" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>申请人</label> <input type="text"
										id="uname" class="form-control select-lg"
										disabled="disabled" /></td>
									<td><label>部门</label> <input type="text" id="deptname"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>状态</label><input type="text" id="status"
										class="form-control select-lg" disabled="disabled" /></td>
								</tr>

								<tr align="center">
									<td><label>申请说明</label> <input type="text" id="des"
										class="form-control select-lg" /></td>
									<td><label>大仓</label> <input type="text" value="1号仓库"
										class="form-control select-lg" disabled="disabled" /></td>
									<td><label>备注</label> <input type="text" id="beizhu"
										class="form-control select-lg" /></td>
									<td><input type="radio" id="impawuliao"
										class="form-control select-lg" value="IMPA物料"
										checked="checked" disabled="disabled" />IMPA物料<input
										type="radio" id="wuliao" class="form-control select-lg"
										value="普通物品" disabled="disabled" />普通物品</td>
								</tr>
							</table>
							<table class="table table-condensed table-hover table-striped">
								<tr class="warning">
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>物品代码</th>
									<th>物品名称</th>
									<th>物品条码</th>
									<th>规格</th>
									<th>品牌</th>
									<th>单位</th>
									<th>数量</th>
									<th>库存</th>
								</tr>
							</table>
							<div style="overflow: scroll; width: 100%; height: 150px">
								<table id="purtable"
									class="table table-condensed table-hover table-striped">
								</table>
							</div>
								<table>
									<tr>
										<td colspan="9">
											<button class="btn btn-warning" type="button">编辑</button>
											<button id="" class="btn btn-warning" type="button">导出模板</button>
											<button class="btn btn-warning" type="button" onclick="">导入物品</button>
										</td>
									</tr>
									<tr>
										<td><label>创建时间</label> <input type="text" id="createdate"
											class="form-control select-lg" /></td>
										<td><label>最后处理人</label> <input type="text" value="${userName }"
											class="form-control select-lg" /></td>
										<td><label>最后处理时间</label> <input type="text" id="getdate"
											class="form-control select-lg" /></td>
									</tr>
								</table>
							<div align="center">
								<button class="btn btn-warning" type="button">复制</button>
								<button id="" class="btn btn-warning" type="button">保存</button>
								<button class="btn btn-warning" type="button" onclick="">保存并提交</button>
								<button class="btn btn-warning" type="button"
									onclick="guanbis();">关闭</button>
							</div>
						</fieldset>
					</form>
				</div>
				<br /> <br />
				<c:if test="${PurchaseOrderlist!='[]' }">
					<table class="table table-condensed table-hover table-striped">
						<thead>
							<tr class="warning">
								<th><input name="cheackall" type="checkbox" id="cheackall" onclick=CheckAll(this.form) value="checkbox"></th>
								<th>申请单号</th>
								<th>物品编码</th>
								<th>物品名称</th>
								<th>数量</th>
								<th>单位</th>
								<th>规格</th>
								<th>所属类别</th>
								<th>物料类型</th>
								<th>申请时间</th>
								<th>申请人</th>
								<th>所属部门</th>
								<th>所属仓库</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dc }" var="dc" varStatus="i">
								<tr ${(i.index+1)%2==0?"class='error'":"class='success'"}
									onclick="selected()">
									<td><input type="checkbox" name="id" value="${i.index+1 }" id="id${i.index+1 }" onclick="UnCheckAll();"/></td>
									<td>${dc.applicationNo }</td>
									<td>${dc.itemCode }</td>
									<td>${dc.chineseName }</td>
									<td>${dc.number }</td>
									<td>${dc.purchasingUnit }</td>
									<td>${dc.purchaseSpecifications }</td>
									<td>${dc.category }</td>
									<td>${dc.materialMaterial }</td>
									<td><fmt:formatDate value="${dc.createDate  }"
											pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td>${dc.commitName }</td>
									<td>${dc.organizationName }</td>
									<td>${dc.warehouseName }</td>
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
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=1">首页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${currpage-1 }">上一页</a></li>

									<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
										end="${currpage+2 }" step="1" var="i">
										<c:if test="${i>0&&i<=totalpage?'true':'false'}">
											<li><a
												href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${i }"
												${i==currpage?"style='color: red'":"" }>${i}</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${currpage+1 }">下一页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/pur/toaddPur.do?currpage=${totalpage }">尾页</a></li>
								</ul>
							</div>
							<div class="col-md-5 column" style="padding-top: 10px">
								<form class="navbar-form navbar-left" role="search"
									action="${pageContext.request.contextPath }/pur/toaddPur.do" method="post">
									<input type="text" class="form-control" name="currpage"
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"
										value="${currpage }" />
									<button type="submit" class="btn btn-default">跳转</button>
								</form>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${PurchaseOrderlist=='[]' }">
							抱歉暂无数据
						</c:if>
			</div>
		</div>
	</div>
</body>
</html>