<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>
            工作台
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
        <script src="./js/jquery-1.11.1.min.js"></script>
    </head>
    <script type="text/javascript">
	$(document).ready(function(){
    	$.ajax({
        		url:"${pageContext.request.contextPath }/comm/common.do?id="+$("#id").val(),
	        	type:"post",
				datatType:"json",
				success:function(data){
					var a="<td>"+data.number+"</td>"
					$("#comm1").append(a);
					var b="<td>"+data.purnumber+"</td>"
					$("#comm2").append(b);
					var c="<td>"+data.renumber+"</td>"
					$("#comm3").append(c);
					var d="<td>"+data.mnumber+"</td>"
					$("#comm4").append(d);
					
					var e="<td>"+data.gotnumber+"</td>"
					$("#comm5").append(e);
					var f="<td>"+data.gotrenumber+"</td>"
					$("#comm6").append(f);
					var g="<td>"+data.gotpurnumber+"</td>"
					$("#comm7").append(g);
					var h="<td>"+data.gotmnumber+"</td>"
					$("#comm8").append(h);
					
					var i="<td>"+data.notnumber+"</td>"
					$("#comm9").append(i);
					var j="<td>"+data.notrenumber+"</td>"
					$("#comm10").append(j);
					var k="<td>"+data.notpurnumber+"</td>"
					$("#comm11").append(k);
					var l="<td>"+data.notmnumber+"</td>"
					$("#comm12").append(l);
					
					var m="<td>"+data.dnotnumber+"</td>"
					$("#comm13").append(m);
					var n="<td>"+data.dnotrenumber+"</td>"
					$("#comm14").append(n);
					var o="<td>"+data.dnotpurnumber+"</td>"
					$("#comm15").append(o);
					var p="<td>"+data.dnotmnumber+"</td>"
					$("#comm16").append(p);
				}
        	});
        });
    </script>
    <body>
     <div class="x-body">
        <blockquote class="layui-elem-quote">
                欢迎来到物资管理后台系统！<span class="f-14">v1.0</span>
            </blockquote>                      
			<div style="width:48%;float:left">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">未办业务</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>未办任务</th>
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
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-admin.js"></script>
        <script type="text/javascript">
//         var _hmt = _hmt || [];
//         (function() {
//           var hm = document.createElement("script");
//           hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
//           var s = document.getElementsByTagName("script")[0]; 
//           s.parentNode.insertBefore(hm, s);
//         })();
        </script>
    </body>
</html>