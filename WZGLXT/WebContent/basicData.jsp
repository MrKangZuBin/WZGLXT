<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-物品管理</title>
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
<script type="text/javascript">
	var inteminformationid;
	var itemcode;
	var articlebarcode;
	var chinesename;
	var chineseabbreviation;
	var englishname;
	var englishabbreviation;
	var category;
	var materialmaterial;
	var brand;
	var validity;
	var description;
	var itemstatus;
	var picture;
	var itemproperties;
	var deficitratio;
	var salesspecifications;
	var salesunit;
	var purchasespecifications;
	var purchasingunit;
	var placeoforigin;
	var maxstock;
	var minstock;
	var currentstock;
	var latestprice;
	var proposalprice;
	var createdate;
	var lastprocessingtime;
	var createpersonid;
	var lastpersonid;
	var createpersonname;
	var lastpersonname;
	var bool=false;
	function selected(inteminformationid_o,itemcode_o,articlebarcode_o,chinesename_o,chineseabbreviation_o,
			 englishname_o,englishabbreviation_o,category_o, materialmaterial_o,brand_o,validity_o,description_o,
			 itemstatus_o,picture_o, itemproperties_o,deficitratio_o, salesspecifications_o, salesunit_o,
			 purchasespecifications_o, purchasingunit_o, placeoforigin_o, maxstock_o, minstock_o,
			 currentstock_o,latestprice_o,proposalprice_o,createdate_o,lastprocessingtime_o,
			 createpersonid_o,lastpersonid_o,createpersonname_o,lastpersonname_o){
		$("#"+inteminformationid).removeClass("danger");
		inteminformationid=inteminformationid_o;
		itemcode=itemcode_o;
		articlebarcode=articlebarcode_o;
		chinesename=chinesename_o;
		chineseabbreviation=chineseabbreviation_o;
		englishname=englishname_o;
		englishabbreviation=englishabbreviation_o;
		category=category_o;
		materialmaterial=materialmaterial_o;
		brand=brand_o;
		validity=validity_o;
		description=description_o;
		itemstatus=itemstatus_o;
		picture=picture_o;
		itemproperties=itemproperties_o;
		deficitratio=deficitratio_o;
		salesspecifications=salesspecifications_o;
		salesunit=salesunit_o;
		purchasespecifications=purchasespecifications_o;
		purchasingunit=purchasingunit_o;
		placeoforigin=placeoforigin_o; 
		maxstock=maxstock_o; 
		minstock=minstock_o;
		currentstock=currentstock_o;
		latestprice=latestprice_o;
		proposalprice=proposalprice_o;
		createdate=createdate_o;
		lastprocessingtime=lastprocessingtime_o;
		createpersonid=createpersonid_o;
		lastpersonid=lastpersonid_o;
		createpersonname=createpersonname_o;
		lastpersonname=lastpersonname_o;
		bool=true;
		//$("#"+categoryid).attr("class", "info");
		$("#"+inteminformationid).addClass("danger");
	}
	function getaddjson() {
		$.ajax({
			url:"${pageContext.request.contextPath}/iteminfo/selRequest.do",
			type:"post",
			datatType:"json",
			success:function(data){
				$("#itemcode").val(data.code);
			}
		});
	}
	function notselected() {
		alert("请选中一行数据！");
	};
	function add() {
		
		$(':text').val("");
		$("select").val("");
		$("#imgfont").hide();
		$("#picture").hide();
		getaddjson();
		$("#tabledv").hide();
		$("#trid").hide();
		$("#subform").attr("action","${pageContext.request.contextPath }/iteminfo/add.do");
		applyed();
	};
	function edit() {
		if(!bool){
			notselected();
			return false;
		}
		$("#tabledv").show();
		$("#trid").show();
		$("#imgfont").show();
		$("#picture").show();
		$("#inteminformationid").val(inteminformationid);
		$("#itemcode").val(itemcode);
		$("#articlebarcode").val(articlebarcode);
		$("#chinesename").val(chinesename);
		$("#chineseabbreviation").val(chineseabbreviation);
		$("#englishname").val(englishname);
		$("#englishabbreviation").val(englishabbreviation);
		$("#category").val(category);
		$("#materialmaterial").val(materialmaterial);
		$("#brand").val(brand);
		$("#validity").val(validity.replace(/\D/g,''));
		$("#validityselect").val(validity.replace(/\d+/g,''));
		$("#description").val(description);
		$("#itemstatus").val(itemstatus);
		$("#picture").attr("src","/usr/local/files"+picture);
		$("#itemproperties").val(itemproperties);
		$("#deficitratio").val(deficitratio);
		$("#salesspecifications").val(salesspecifications);
		$("#salesunit").val(salesunit);
		$("#purchasespecifications").val(purchasespecifications);
		$("#purchasingunit").val(purchasingunit);
		$("#placeoforigin").val(placeoforigin);
		$("#maxstock").val(maxstock);
		$("#minstock").val(minstock);
		$("#currentstock").text(currentstock);
		$("#latestprice").text(latestprice);
		$("#proposalprice").text(proposalprice);
		$("#createdate").text(createdate);
		$("#lastprocessingtime").text(lastprocessingtime);
		$("#createpersonid").val(createpersonid);
		//$("#lastpersonid").val(lastpersonid);
		$("#createpersonname").text(createpersonname);
		$("#lastpersonname").text(lastpersonname);
		$("#subform").attr("action","${pageContext.request.contextPath }/iteminfo/update.do");
		
		applyed();
	};
	function del() {
		if(!bool){
			notselected();
			return false;
		}
		$("#delid").val(inteminformationid);
		$("#delform").attr("action","${pageContext.request.contextPath }/iteminfo/delete.do");
		$("#gray").show();
		$("#popupdel").show();
		tc_center();
	};
	function hidedel() {
		$("#gray").hide();
		$("#popupdel").hide();
	}
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
	function center(){
		var _top=($(window).height()-$("#popup").height())/2;
		var _left=($(window).width()-$("#popup").width())/2;
		$("#popup").css({top:_top,left:_left});
	}
	function checkfile(target) {
		var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
		var fileSize = 0;
		if (isIE && !target.files) {
			var filePath = target.value;
			var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
			var file = fileSystem.GetFile(filePath);
			fileSize = file.Size;
		} else {
			fileSize = target.files[0].size;
		}
		var size = fileSize / 1024;
		if (size > 1024) {
			alert("图片不能大于1M,请重新选择！");
			$("#protocoenclosurefile").after($("#protocoenclosurefile").clone().val(""));   
			$("#protocoenclosurefile").remove(); 
		}
		filepath=target.value;
		var extStart=filepath.lastIndexOf(".");
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		if(ext!=".BMP"&&ext!=".PNG"&&ext!=".GIF"&&ext!=".JPG"&&ext!=".JPEG"){
		alert("图片限于png,gif,jpeg,jpg格式");
			$("#protocoenclosurefile").after($("#protocoenclosurefile").clone().val(""));   
			$("#protocoenclosurefile").remove();
		}
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
		<br>
		<form class="form-horizontal" role="form" id="delform" action="#"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" name="itemcode_o" value="${itemcode }" /> <input
				type="hidden" name="itemname_o" value="${itemname }" /> <input
				type="hidden" name="itemstatus_o" value="${itemstatus }" /> <input
				type="hidden" name="itemmaterial_o" value="${itemmaterial }" /> <input
				type="hidden" id="delid" name="inteminformationid">
			<center>
				<input style="padding-left: 30px; padding-right: 30px" type="button"
					class="btn btn-info" onclick="hidedel()" value="取消"> <input
					style="padding-left: 30px; padding-right: 30px" type="submit"
					class="btn btn-danger" value="确认" />
			</center>
		</form>
	</div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<h3 class="b-tittle" style="color: #00ccff">物品管理</h3>
				<div class="popup" id="popup"
					style="width: 90%; padding-bottom: 30px; padding-left: 30px; padding-right: 30px;">
					<div class="top_nav" id='top_nav' style="padding-top: 20px;">
						<span>物料新增/编辑 </span><a class="guanbi" onclick="hide();"></a><br>
					</div>
					<br>
					<form class="form-inline" role="form" id="subform" action="#"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="currpage" value="${currpage }" /> <input
							type="hidden" name="inteminformationid" id="inteminformationid" />
						<input type="hidden" name="itemcode_o" value="${itemcode }" /> <input
							type="hidden" name="itemname_o" value="${itemname }" /> <input
							type="hidden" name="itemstatus_o" value="${itemstatus }" /> <input
							type="hidden" name="itemmaterial_o" value="${itemmaterial }" />
						<input type="hidden" id="createpersonid" name="createpersonid"
							value="${userID }" /> <input type="hidden" id="lastpersonid"
							name="lastpersonid" value="${userID }" />
						<div style="width: 100%; height: 400px; overflow: auto;">
							<table class="table table-condensed" style="background: #edebec;">
								<thead>
									<tr>
										<td><label for="exampleInputEmail1">物料编码<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="itemcode" id="itemcode"
											readonly="readonly" /></td>
										<td><label for="exampleInputEmail1">中文名称<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="chinesename"
											id="chinesename" /></td>
										<td><label for="exampleInputEmail1">英文名称</label> <input
											class="form-control select-lg" type="text" style="width: 70%"
											name="englishname" id="englishname" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">物品条码<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="articlebarcode"
											id="articlebarcode" /></td>
										<td><label for="exampleInputEmail1">中文简称</label> <input
											class="form-control select-lg" type="text" style="width: 70%"
											name="chineseabbreviation" id="chineseabbreviation" /></td>
										<td><label for="exampleInputEmail1">英文简称</label> <input
											class="form-control select-lg" type="text" style="width: 70%"
											name="englishabbreviation" id="englishabbreviation" /></td>
									</tr>
								</thead>
							</table>
							<table class="table table-condensed" style="background: #edebec;">
								<thead>
									<tr>
										<td colspan="3"><strong
											style="color: #828282; font-size: 16px;">基本信息 </strong></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">类&#12288;&#12288;别<font
												color="red">*</font></label> <select class="form-control select-lg"
											style="width: 70%" name="category" id="category">
												<option value="">不限</option>
												<c:forEach items="${categorylist }" var="category">
													<option value="${category.categoryname}">${category.categoryname}</option>
												</c:forEach>
										</select></td>
										<td><label for="exampleInputEmail1">状态<font
												color="red">*</font></label> <select class="form-control select-lg"
											style="width: 70%" name="itemstatus" id="itemstatus">
												<option value="可用">可用</option>
												<option value="不可用">不可用</option>
										</select></td>
										<td rowspan="2"><div class="row clearfix">
												<div class="col-md-6 column">
													<label for="exampleInputEmail1">图片&#12288;</label> <img
														id="picture" width="80px" height="80px" />
												</div>
												<div class="col-md-6 column">
													<input type="file" name="protocoenclosurename"
														id="protocoenclosurefile" onchange="checkfile(this);" />
													<font color="red" id="imgfont">选择的图片将覆盖原先图片，请谨慎选择！</font>
												</div>
											</div></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">销售规格<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" id="salesspecifications"
											name="salesspecifications" /></td>
										<td><label for="exampleInputEmail1">单位<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" id="salesunit"
											name="salesunit" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">采购规格<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" id="purchasespecifications"
											name="purchasespecifications" /></td>
										<td><label for="exampleInputEmail1">单位<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" id="purchasingunit"
											name="purchasingunit" /></td>
										<td><label for="exampleInputEmail1">物品类型<font
												color="red">*</font></label> <select class="form-control select-lg"
											style="width: 70%" name="materialmaterial"
											id="materialmaterial">
												<option value="IMPA物料">IMPA物料</option>
												<option value="普通物料">普通物料</option>
										</select></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">品&#12288;&#12288;牌</label>
											<input class="form-control select-lg" type="text"
											style="width: 70%" id="brand" name="brand" /></td>
										<td><label for="exampleInputEmail1">产地</label> <input
											class="form-control select-lg" type="text" style="width: 70%"
											id="placeoforigin" name="placeoforigin" /></td>
										<td><label for="exampleInputEmail1">&#12288;&#12288;属性</label>
											<select class="form-control select-lg" style="width: 70%"
											id="itemproperties" name="itemproperties">
												<option value="可销售">可销售</option>
												<option value="不可销售">不可销售</option>
										</select></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">&#12288;有效期</label> <input
											class="form-control select-lg" type="text" style="width: 50%"
											id="validity" name="validity"
											onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <select
											class="form-control select-lg" style="width: 20%"
											name="validityunit" id="validityselect">
												<option value="年">年</option>
												<option value="月">月</option>
												<option value="日">日</option>
										</select></td>
										<td colspan="2"><label for="exampleInputEmail1">备注</label>
											<input class="form-control select-lg" type="text"
											style="width: 70%" id="description" name="description" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">库存上限<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" id="maxstock" name="maxstock" /></td>
										<td><label for="exampleInputEmail1">库存下限<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" id="minstock" name="minstock" /></td>
										<td width="30%"></td>
									</tr>
									<tr id="trid">
										<td><label for="exampleInputEmail1">当前库存&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="currentstock"></font></td>
										<td><label for="exampleInputEmail1">最近进价&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="latestprice"></font></td>
										<td><label for="exampleInputEmail1">建议零售价&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="proposalprice"></font></td>
									</tr>
								</thead>
							</table>

							<!-- 库存信息、采购销售信息 -->

							<table class="table table-condensed" style="background: #edebec;"
								id="tabledv">
								<thead>
									<tr align="center">
										<td><label for="exampleInputEmail1">创建时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797" id="createdate"></font></td>
										<td><label for="exampleInputEmail1">最后修改时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="lastprocessingtime"></font></td>
										<td width="30%"></td>
									</tr>
									<tr align="center">
										<td><label for="exampleInputEmail1">&#12288;创建人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="createpersonname"></font></td>
										<td><label for="exampleInputEmail1">最后修改人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="lastpersonname"></font></td>
										<td width="30%"></td>
									</tr>
								</thead>
							</table>
						</div>
						<center>
							<input style="padding-left: 30px; padding-right: 30px"
								type="button" class="btn btn-info" onclick="hide()" value="取消">
							<input style="padding-left: 30px; padding-right: 30px"
								type="submit" class="btn btn-warning" value="保存" />
						</center>

					</form>
				</div>
				<form class="form-search"
					action="${pageContext.request.contextPath }/iteminfo/paginglist.do">
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputEmail1">物品编码</label> <input
									class="form-control select-lg" type="text" name="itemcode_o"
									value="${itemcode }" /></td>
								<td><label for="exampleInputEmail1">物品名称</label> <input
									class="form-control select-lg" type="text" name="itemname_o"
									value="${itemname }" /></td>
								<td><label for="exampleInputEmail1">状态</label> <select
									name="itemstatus_o" class="form-control select-lg">
										<option value="">全部</option>
										<option value="可用" ${itemstatus=="可用"?"selected":"" }>可用</option>
										<option value="不可用" ${itemstatus=="不可用"?"selected":"" }>不可用</option>
								</select></td>
								<td><label for="exampleInputEmail1">类型</label> <select
									name="itemmaterial_o" class="form-control select-lg">
										<option value="">全部</option>
										<option value="IMPA物料"
											${itemmaterial=="IMPA物料"?"selected":"" }>IMPA物料</option>
										<option value="普通物料" ${itemmaterial=="普通物料"?"selected":"" }>普通物料</option>
								</select></td>
								<td>
									<button type="submit" class="btn btn-defult btn-info"
										style="margin-top: 25px">查询</button>
								</td>
							</tr>
						</thead>
					</table>
				</form>
				<%
					if (jurisdiction.contains("32")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="add()">新增物料</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">新增物料</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("34")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="edit()">编辑物料</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">编辑物料</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("33")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="del()">删除物料</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">删除物料</button>
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
									<th>物品编码</th>
									<th>物品名称</th>
									<th>英文名称</th>
									<th>物品条码</th>
									<th>状态</th>
									<th>类型</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="iteminfo" varStatus="i">

									<tr id="${iteminfo.inteminformationid }"
										${(i.index+1)%2==0?"class='error'":"class='success'"}
										onclick="selected('${iteminfo.inteminformationid }','${iteminfo.itemcode }','${iteminfo.articlebarcode }','${iteminfo.chinesename }','${iteminfo.chineseabbreviation }',
								'${iteminfo.englishname }','${iteminfo.englishabbreviation }','${iteminfo.category }','${iteminfo.materialmaterial }','${iteminfo.brand }','${iteminfo.validity }','${iteminfo.description }','${iteminfo.itemstatus }','${iteminfo.picture }',
								'${iteminfo.itemproperties }','${iteminfo.deficitratio }','${iteminfo.salesspecifications }','${iteminfo.salesunit }','${iteminfo.purchasespecifications }','${iteminfo.purchasingunit }',
								'${iteminfo.placeoforigin }','${iteminfo.maxstock }','${iteminfo.minstock }','${iteminfo.currentstock }','${iteminfo.latestprice }','${iteminfo.proposalprice }',
								'<fmt:formatDate value="${iteminfo.createdate }"
												type="both"/>',
								'<fmt:formatDate value="${iteminfo.lastprocessingtime }"
												type="both"/>',
								'${iteminfo.createpersonid }','${iteminfo.lastpersonid }','${iteminfo.createpersonname }','${iteminfo.lastpersonname }')">
										<td>${i.index+1 }</td>
										<td>${iteminfo.itemcode }</td>
										<td>${iteminfo.chinesename }</td>
										<td>${iteminfo.englishname }</td>
										<td>${iteminfo.articlebarcode }</td>
										<td>${iteminfo.itemstatus }</td>
										<td>${iteminfo.materialmaterial }</td>
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
												href="${pageContext.request.contextPath }/iteminfo/paginglist.do?currpage=1&&itemcode_o=${itemcode}&&itemname_o=${itemname}&&itemstatus_o=${itemstatus}&&itemmaterial_o=${itemmaterial}">首页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/iteminfo/paginglist.do?currpage=${currpage-1 }&&itemcode_o=${itemcode}&&itemname_o=${itemname}&&itemstatus_o=${itemstatus}&&itemmaterial_o=${itemmaterial}">上一页</a></li>

											<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
												end="${currpage+2 }" step="1" var="i">
												<c:if test="${i>0&&i<=totalpage?'true':'false'}">
													<li><a
														href="${pageContext.request.contextPath }/iteminfo/paginglist.do?currpage=${i }&&itemcode_o=${itemcode}&&itemname_o=${itemname}&&itemstatus_o=${itemstatus}&&itemmaterial_o=${itemmaterial}"
														${i==currpage?"style='color: red'":"" }>${i}</a></li>
												</c:if>
											</c:forEach>
											<li><a
												href="${pageContext.request.contextPath }/iteminfo/paginglist.do?currpage=${currpage+1 }&&itemcode_o=${itemcode}&&itemname_o=${itemname}&&itemstatus_o=${itemstatus}&&itemmaterial_o=${itemmaterial}">下一页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/iteminfo/paginglist.do?currpage=${totalpage }&&itemcode_o=${itemcode}&&itemname_o=${itemname}&&itemstatus_o=${itemstatus}&&itemmaterial_o=${itemmaterial}">尾页</a></li>
										</ul>
									</div>
								</td>
								<td width="32%">
									<div style="padding-top: 10px">
										<form class="navbar-form navbar-left" role="search"
											action="${pageContext.request.contextPath }/iteminfo/paginglist.do?itemcode_o=${itemcode}&&itemname_o=${itemname}&&itemstatus_o=${itemstatus}&&itemmaterial_o=${itemmaterial}"
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