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
function allcheck(){
	
	var number = new Array();
	
	var ht = $("#allcheack").val();
		if(ht=="全选"){
		$("#div input[type='checkbox']").each(function(){//获取特定标签下的特定属性值的特定标签组
//			$(this).attr('checked', 'checked');
			$(this).prop("checked", true);
		});
		$("#allcheack").val("取消");
	}else{
		$("#div input[type='checkbox']").each(function(){
//			$(this).removeAttr('checked');
			$(this).prop("checked", false);
		});
		$("#allcheack").val("全选");
	} 
		
		
	
	
}

function test(){
	var j=0;
	var	obj = document.getElementsByName("returnbox");
	numbers=[];
	for(k in obj){
		
        if(obj[k].checked){
          numbers.push(obj[k].value);
        }
    }
	
	
	$.getJSON('returnRequest/selectExect.do?exect=' + numbers, null,
			function(data) {
				alert(data.status);
					window.location.href = "returnRequest/selectall.do";
			});
}

</script>
</head>
<body>
	<div  style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div >
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<form class="form-inline">
					<fieldset>
						<table align="center" cellspacing="1"
							style="background: #edebec; width: 100%">
							<tr align="center">
								<td><label>申请单号 </label> <input type="text" id=""
									class="form-control select-lg" /></td>
								<td><label>时间</label> <input type="text" id=""
									class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>至</label> <input type="text" id=""
									class="form-control select-lg" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
								<td><label>提交人</label> <select id=""
									class="form-control select-lg">
										<option>请选择提交人</option>
								</select></td>
							</tr>

							<tr align="center">
								<td><label>申请说明</label> <input type="text" id=""
									class="form-control select-lg" /></td>
								<td><label>仓库</label> <input type="text" id=""
									class="form-control select-lg" /></td>
								<td><label>部门</label> <select id=""
									class="form-control select-lg">
										<option>请选择部门</option>
								</select></td>
								<td><input type="radio" id=""
									class="form-control select-lg" checked="checked" />IMPA物料<input
									type="radio" id="" class="form-control select-lg" />普通物料
									<button class="btn btn-warning" type="button" onclick="test();">生成退货单</button></td>
							</tr>
						</table>

					</fieldset>
				</form>
				<br/>
				<div id="div" style="overflow: scroll; width: 100%; height: 350px">
				<table class="table table-condensed table-hover table-striped">
					<thead>
						<tr class="warning">
							<th><input  value="全选" id="allcheack" type="button" onclick="allcheck();"/></th>
							<th>物品编码</th>
							<th>物品名称</th>
							<th>规格</th>
							<th>所属分类</th>
							<th>物料类型</th>
							<th>供应商</th>
							<th>提交时间</th>
							<th>提交人</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rr }" var="rr" varStatus="i">
							<tr id=""
								${(i.index+1)%2==0?"class='error'":"class='success'"} >
								<td><input type="checkbox" name="returnbox" value="${rr.returnrequestid }"/></td>
								<td><c:forEach items="${iif }" var="iifs">
										<c:forEach items="${rr_if }" var="rr_if">
											<c:if
												test="${iifs.inteminformationid==rr_if.iteminformationid }">
												<c:if test="${rr_if.returnrequestid==rr.returnrequestid }">${iifs.itemcode }</c:if>
											</c:if>
										</c:forEach>
									</c:forEach></td>
								<td><c:forEach items="${iif }" var="iifs">
										<c:forEach items="${rr_if }" var="rr_if">
											<c:if
												test="${iifs.inteminformationid==rr_if.iteminformationid }">
												<c:if test="${rr_if.returnrequestid==rr.returnrequestid }">${iifs.chinesename }</c:if>
											</c:if>
										</c:forEach>
									</c:forEach></td>
								<td><c:forEach items="${iif }" var="iifs">
										<c:forEach items="${rr_if }" var="rr_if">
											<c:if
												test="${iifs.inteminformationid==rr_if.iteminformationid }">
												<c:if test="${rr_if.returnrequestid==rr.returnrequestid }">${iifs.purchasespecifications }</c:if>
											</c:if>
										</c:forEach>
									</c:forEach></td>
								<td><c:forEach items="${iif }" var="iifs">
										<c:forEach items="${rr_if }" var="rr_if">
											<c:if
												test="${iifs.inteminformationid==rr_if.iteminformationid }">
												<c:if test="${rr_if.returnrequestid==rr.returnrequestid }">${iifs.category }</c:if>
											</c:if>
										</c:forEach>
									</c:forEach></td>
								<td><c:forEach items="${iif }" var="iifs">
										<c:forEach items="${rr_if }" var="rr_if">
											<c:if test="${rr_if.returnrequestid==rr.returnrequestid }">
												<c:if
													test="${iifs.inteminformationid==rr_if.iteminformationid }">${iifs.materialmaterial }</c:if>
											</c:if>
										</c:forEach>
									</c:forEach></td>
								<td><c:forEach items="${sl }" var="sls">
										<c:if test="${sls.supplierid==rr.companyid }">${sls.chinesename }</c:if>
									</c:forEach></td>
								<td><fmt:formatDate value="${rr.committime }"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
								<td><c:forEach items="${user }" var="us">
										<c:if test="${us.userid==rr.submitterid }">${us.loginname }</c:if>
									</c:forEach></td>
							</tr>
						</c:forEach>
					
					</tbody>
				</table>
					</div>
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-12 column" style="padding-top: 20px" align="left">
							<h5>共${pagecount }条记录 </h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>