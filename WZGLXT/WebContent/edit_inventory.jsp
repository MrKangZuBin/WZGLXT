<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>普通入库-普通入库单</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="header_bg">
		<div class="container">
			<div class="header">
				<br />
				<div id="purchaseOrder">
					<h3 align="right" class="b-tittle">
						<button class="btn btn-warning" type="button">新增</button>
						<button class="btn btn-warning" type="button">复制</button>
						<button class="btn btn-warning" type="button">保存</button>
						<button class="btn btn-warning" type="button">删除</button>
						<button class="btn btn-warning" type="button">提交</button>
						<button class="btn btn-warning" type="button">驳回</button>
						<button class="btn btn-warning" type="button">作废</button>
					</h3>
				</div>
				<br />
				<table class="table table-condensed">
					<thead>
					<tbody>
						<tr class="success" align="center">
							<td>盘点单号 <input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td>邮轮 <select id="" class="form-control select-lg">
							</select>
							</td>
							<td>盘点仓库<select id="" class="form-control select-lg">
							</select>
							</td>
							<td>类型<select id="" class="form-control select-lg">
									<option>请选择</option>
									<option>IMPA物料</option>
									<option>普通物品</option>
							</select>
							</td>
						</tr>
						<tr class="success" align="center">
							<td colspan="2">说明<input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td>状态<select id="" class="form-control select-lg">
							</select>
							</td>
							<td></td>
						</tr>
					</tbody>
					<thead>
				</table>
				<br /> <br />
				<table class="table table-condensed table-hover table-striped">
					<thead>
					<tbody>
						<tr>
							<th>序号</th>
							<th>物品编码</th>
							<th>物品名称</th>
							<th>物品条码</th>
							<th>类别</th>
							<th>规格</th>
							<th>单位</th>
							<th>系统库存</th>
							<th>盘点库存</th>
							<th>盈亏数量</th>
						</tr>

						<tr class="success">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
							<td>dad</td>
							<td>dad</td>
							<td>50</td>
							<td>50</td>
							<td><input type="text" id="" class="form-control select-lg" /></td>
							<td>45</td>
						</tr>

					</tbody>
					<thead>
				</table>
				<!-- 				<h3 align="right" class="b-tittle"> -->
				<!-- 					<button class="btn btn-warning" type="button"><a href="editgeneralStorage.jsp">编辑</a></button> -->
				<!-- 					<button class="btn btn-warning" type="button">导入物品</button> -->
				<!-- 				</h3> -->
				<br /> <br />
				<table class="table table-condensed">
					<thead>
					<tbody>
						<tr class="success" align="center">
							<td>创建时间 <input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td>最后修改时间 <input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td colspan="2"></td>
						</tr>
						<tr class="success" align="center">
							<td>创建人<input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td>最后修改人<input type="text" id=""
								class="form-control select-lg" />
							</td>
							<td colspan="2"></td>
						</tr>
					</tbody>
					<thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>