<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert name="jurisdictionid" title here</title>
<jsp:include page="header.jsp"></jsp:include>
<script name="jurisdictionid" type="text/javascript">
	function allcheck() {

		var number = new Array();
		var ht = $("#allcheack").val();
		if (ht == "全选") {
			$("#div input[type='checkbox']").each(function() {//获取特定标签下的特定属性值的特定标签组
				//			$(this).attr('checked', 'checked');
				$(this).prop("checked", true);
			});
			var boxs = document.getElementsByName("jurisdictionid");
			var str = "";
			for (var i = 0; i < boxs.length; i++) {
				if (boxs[i].checked) {
					str += boxs[i].value + ",";
				}
			}
			document.getElementById("idlist").value = str;
			$("#allcheack").val("取消");
		} else {
			$("#div input[type='checkbox']").each(function() {
				//			$(this).removeAttr('checked');
				$(this).prop("checked", false);
			});
			document.getElementById("idlist").value = "";
			$("#allcheack").val("全选");
		}

	}

	function Uncheckall() {
		var boxs = document.getElementsByName("jurisdictionid");
		var str = "";
		for (var i = 0; i < boxs.length; i++) {
			if (boxs[i].checked) {
				str += boxs[i].value + ",";
			}
		}
		document.getElementById("idlist").value = str;
	}

	function role_update() {
		var roleid = document.getElementById("roleid").value;
		var idlist = document.getElementById("idlist").value;
		window.location.href = "updateroots.do?roleid=" + roleid + "&idlist="
				+ idlist;
	}
</script>
</head>
<body>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div id="div">
				<form action="updateroots.do" method="post">
					<table class="table table-condensed table-hover table-striped">
						<tr style="color: white;">
							<td align="right"><input class="btn btn-warning" value="全选"
								id="allcheack" type="button" onclick="allcheck();" /></td>
							<td align="left"><button class="btn btn-warning"
									type="button" onclick="role_update();">确定</button> <input
								type="hidden" value="${roleid }" name="roleid" id="roleid" /> <input
								type="hidden" value="" name="idlist" id="idlist" /></td>
						</tr>
					</table>
				</form>

				<form action="updateroots.do" method="post">
					<table class="table table-condensed table-hover table-striped"
						bgcolor="blue" align="center">
						<tr>
							<th><p style="color: red;">采购入库</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="10" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==10 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购入库新增</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="11" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==11 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购入库查询</th>
							<th></th>
						</tr>
						<tr>
							<th><p style="color: red;">普通入库</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="12" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==12 }">checked</c:if></c:forEach> /></th>
							<th align="center">普通入库查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="14" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==14 }">checked</c:if></c:forEach> /></th>
							<th align="center">普通入库编辑</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="13" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==13 }">checked</c:if></c:forEach> /></th>
							<th align="center">普通入库添加</th>
						</tr>
						<tr>
							<th><p style="color: red;">退货出库</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="15" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==15 }">checked</c:if></c:forEach> /></th>
							<th align="center">待退货管理</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="16" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==16 }">checked</c:if></c:forEach> /></th>
							<th align="center">退货出库查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="17" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==17 }">checked</c:if></c:forEach> /></th>
							<th align="center">退货出库编辑</th>
						</tr>
						<tr>
							<th><p style="color: red;">领用出库</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="19" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==19 }">checked</c:if></c:forEach> /></th>
							<th align="center">领用出库添加</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="18" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==18 }">checked</c:if></c:forEach> /></th>
							<th align="center">领用出库查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="20" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==20 }">checked</c:if></c:forEach> /></th>
							<th align="center">领用出库编辑</th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">库存查询.报损</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="21" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==21 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存查询查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="22" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==22 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存报损查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="24" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==24 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存报损编辑</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="23" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==23}">checked</c:if></c:forEach> /></th>
							<th align="center">库存报损添加</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th><p style="color: red;">库存盘点</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="25" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==25 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存盘点查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="27" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==27 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存盘点编辑</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="26" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==26 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存盘点新增</th>
						</tr>
						<tr>
							<th><p style="color: red;">统计报表</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="28" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==28 }">checked</c:if></c:forEach> /></th>
							<th align="center">物品采购统计查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="29" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==29 }">checked</c:if></c:forEach> /></th>
							<th align="center">物品入库统计查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="30" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==30 }">checked</c:if></c:forEach> /></th>
							<th align="center">物品盘点统计查询</th>
						</tr>
						<tr>
							<th><p style="color: red;">用户.角色</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="75" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==75 }">checked</c:if></c:forEach> /></th>
							<th align="center">用户管理</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="76" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==76 }">checked</c:if></c:forEach> /></th>
							<th align="center">角色管理</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="77" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==77 }">checked</c:if></c:forEach> /></th>
							<th align="center">权限管理</th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;" >物品管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="31" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==31 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询物品</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="32" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==32 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增物品</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="33" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==33 }">checked</c:if></c:forEach> /></th>
							<th align="center">删除物品</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="34" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==34 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改物品</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">物品分类</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="36" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==36 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询物品分类</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="35" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==35 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增物品分类</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="37" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==37 }">checked</c:if></c:forEach> /></th>
							<th align="center">删除物品分类</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="38" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==38 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改物品分类</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">供应商管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="40" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==40 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询供应商</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="39" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==39 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增供应商</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="41" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==41}">checked</c:if></c:forEach> /></th>
							<th align="center">删除供应商</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="42" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==42 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改供应商</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr >
							<th rowspan="2"><p style="color: red;">供货协议管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="44" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==44 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询供货协议</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="43" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==43 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增供货协议</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="45" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==45 }">checked</c:if></c:forEach> /></th>
							<th align="center">删除供货协议</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="46" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==46 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改供货协议</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">店仓管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="63" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==63 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询店仓</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="66" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==66 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增店仓</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="64" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==64 }">checked</c:if></c:forEach> /></th>
							<th align="center">删除店仓</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="65" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==65 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改店仓</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr >
							<th ><p style="color: red;">预警管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="82" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==51 }">checked</c:if></c:forEach> /></th>
							<th align="center">库存预警</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="81" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==50 }">checked</c:if></c:forEach> /></th>
							<th align="center">店仓预警</th>
						</tr>
						<tr >
							<th rowspan="2"><p style="color: red;">仓库管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="67" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==63 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询仓库</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="78" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==78 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增仓库</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="68" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==68 }">checked</c:if></c:forEach> /></th>
							<th align="center">删除仓库</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="69" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==69 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改仓库</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">库位管理</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="71" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==71 }">checked</c:if></c:forEach> /></th>
							<th align="center">查询库位</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="70" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==70 }">checked</c:if></c:forEach> /></th>
							<th align="center">新增库位</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="72" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==72 }">checked</c:if></c:forEach> /></th>
							<th align="center">删除库位</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="73" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==73 }">checked</c:if></c:forEach> /></th>
							<th align="center">修改库位</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr >
							<th rowspan="2"><p style="color: red;">采购申请</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="51" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==51 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购申请新增</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="50" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==50 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购申请查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="52" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==52 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购申请删除</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="53" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==53 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购申请修改</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">采购订单</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="54" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==54 }">checked</c:if></c:forEach> /></th>
							<th align="center">待采购物资查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="55" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==55 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购订单新增</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="57" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==57 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购订单删除</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="56" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==56 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购订单查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="58" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==58 }">checked</c:if></c:forEach> /></th>
							<th align="center">采购订单修改</th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th rowspan="2"><p style="color: red;">退货申请</p></th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="62" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==62 }">checked</c:if></c:forEach> /></th>
							<th align="center">退货申请查询</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="59" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==59 }">checked</c:if></c:forEach> /></th>
							<th align="center">退货申请新增</th>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="60" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==60 }">checked</c:if></c:forEach> /></th>
							<th align="center">退货申请删除</th>
						</tr>
						<tr>
							<th align="center"><input name="jurisdictionid"
								type="checkbox" value="61" onclick="Uncheckall()"
								<c:forEach items="${jurisdiction}" var="jurisdiction"><c:if test="${jurisdiction.jurisdictionid==61 }">checked</c:if></c:forEach> /></th>
							<th align="center">退货申请修改</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>