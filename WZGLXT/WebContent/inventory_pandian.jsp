<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>库存查询</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="header_bg">
		<div class="container">
			<div class="header">
				<br />
				<div id="purchaseOrder"></div>
				<br />
				<table class="table table-condensed">
					<thead>
					<tbody>
						<tr class="success" align="center">
							<td>盘点单号<input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td>邮轮<select id="" class="form-control select-lg">
									<option>全部</option>
									<option>IMPA物料</option>
									<option>普通物品</option>
							</select>
							</td>
							<td>时间<input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td>至<input type="text" id=""
								class="form-control select-lg" />
							</td>
							
						</tr>
						<tr class="success" align="center">
							<td>盘点仓库<input type="text" id="" class="form-control select-lg" />
							</td>
							<td>类型<select id="" class="form-control select-lg">
									<option>全部</option>
									<option>IMPA物料</option>
									<option>普通物品</option>
							</select>
							</td>
							<td>状态<select id="" class="form-control select-lg">
									<option>全部</option>
									<option>审核中</option>
									<option>审核成功</option>
							</select></td>
							<td></td>
						</tr>
						<tr class="success">
							<td></td>
							<td colspan="2"><input type="submit" value="查询"
								class="btn btn-block btn-warning" /></td>
							<td></td>
						</tr>
					</tbody>
					<thead>
				</table>
				<button class="btn btn-warning" type="button"><a href="edit_inventory.jsp">新增手工盘点单</a></button>
				<button class="btn btn-warning" type="button"><a href="addgeneralStorage.jsp">删除盘点单</a></button>
				<button class="btn btn-warning" type="button"><a href="addgeneralStorage.jsp">导入盘点数据</a></button>
				<button class="btn btn-warning" type="button"><a href="addgeneralStorage.jsp">导出盘点单</a></button>
				<br />
				<br/>
				<table class="table table-condensed table-hover table-striped">
					<thead>
					<tbody>
						<tr>
							<th>序号</th>
							<th>盘点单号</th>
							<th>盘点说明</th>
							<th>品项数</th>
							<th>邮轮</th>
							<th>盘点仓库</th>
							<th>类型</th>
							<th>状态</th>
							<th>提交时间</th>
							<th>提交人</th>
						</tr>
					<tr class="success">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
							<td>dad</td>
							<td>dad</td>
							<td>dad</td>
							<td>dad</td>
							<td>dad</td>
							<td>dad</td>
						</tr>
					
					</tbody>
					<thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>