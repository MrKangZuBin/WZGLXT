<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购审批</title>
</head>
<body>
	<div class="x-body">
		<div style="width:48%;float:left">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">已审批</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>任务</th>
                        <th>详情</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="comm1">
                        <td>待我操作采购申请 <input type="hidden" id="id" value="${userID }"></td>
                    </tr>
					<tr id="comm2">
                        <td>待我操作的采购订单</td>
                    </tr>
					<tr id="comm3">
                        <td>待我操作的退货申请</td>
                    </tr>
					<tr id="comm4">
                        <td>待我操作的出库</td>
                    </tr>
                </tbody>
            </table>
			</div>
			<div style="width:48%;float:right">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">已办任务</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>已办任务</th>
                        <th>详情</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="comm5">
                        <td>已办的申请</td>
                    </tr>
                    <tr id="comm6">
                        <td>待我操作的采购订单</td>
                    </tr>
                    <tr id="comm7">
                        <td>待我操作的退货申请</td>
                    </tr>
                    <tr id="comm8">
                        <td>待我操作的出库</td>
                    </tr>
                </tbody>
            </table>
			</div>
			<div style="width:48%;float:left">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">我的单据</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>我的单据</th>
                        <th>详情</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="comm9">
                        <td>我的申请</td>
                    </tr>
					<tr id="comm10">
                        <td>我的采购订单</td>
                    </tr>
					<tr id="comm11">
                        <td>我的退货申请</td>
                    </tr>
					<tr id="comm12">
                        <td>我的出库</td>
                    </tr>
                </tbody>
            </table>
			</div>
			<div style="width:48%;float:right">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">我的报损单</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>我的未通过单</th>
                        <th>详情</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="comm13">
                        <td>采购申请未通过单</td>
                    </tr>
                    <tr id="comm14">
                        <td>采购未通过订单</td>
                    </tr>
                    <tr id="comm15">
                        <td>退货申请未通过单</td>
                    </tr>
                    <tr id="comm16">
                        <td>出库未通单</td>
                    </tr>
                </tbody>
            </table>
			</div>
			<div style="width:48%;float:left">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">库存预警</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>物品代码</th>
                        <th>物品名称</th>
						<th>物品条码</th>
						<th>预警类型</th>
                    </tr>
                </thead>
				
                <tbody>
                    <tr>
                        <td>92</td>
                        <td>92</td>
						<td>92</td>
						<td>92</td>
                    </tr>
                    <tr>
                        <td>92</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
					<tr>
                        <td>待我操作的采购订单</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
					<tr>
                        <td>待我操作的退货申请</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
					<tr>
                        <td>待我操作的出库</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
                </tbody>
            </table>
			</div>
			<div style="width:48%;float:right">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">点仓预警</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>物品代码</th>
                        <th>物品名称</th>
						<th>物品条码</th>
						<th>预警类型</th>
                    </tr>
                </thead>
				
                <tbody>
                    <tr>
                        <td>92</td>
                        <td>92</td>
						<td>92</td>
						<td>92</td>
                    </tr>
                    <tr>
                        <td>92</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
					<tr>
                        <td>待我操作的采购订单</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
					<tr>
                        <td>待我操作的退货申请</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
					<tr>
                        <td>待我操作的出库</td>
                        <td>0</td>
						<td>92</td>
						<td>92</td>
                    </tr>
                </tbody>
            </table>
			</div>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th colspan="2" scope="col">服务器信息</th>
                    </tr>
                </thead>
            </table>
        </div>
        <div class="layui-footer footer footer-demo">
            <div class="layui-main">
                <p>Copyright ©2017 物资管理系统 All Rights Reserved.</p>
                <p>本后台系统由X前端框架提供前端技术支持</p>
            </div>
        </div>
</body>
</html>