<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>
            物资管理系统
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
    <body>
    <% 
		String userName = (String)session.getAttribute("userName");
		List jurisdiction = (List) session.getAttribute("list");
	%>
	<% if(jurisdiction==null||userName==null){ %><jsp:include page="login.jsp"></jsp:include><%} %>
	<% if(jurisdiction!=null||userName!=null){ %>
        <div class="layui-layout layui-layout-admin">
            <div class="layui-header header header-demo">
                <div class="layui-main">
                    <a class="logo" href="./wzgl.jsp">
                        物资管理系统
                    </a>
                    <ul class="layui-nav" lay-filter="">
                      <li class="layui-nav-item">
                       <a href="javascript:;">${userName }</a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                          <dd><a href="./login.jsp">切换帐号</a></dd>
                          <dd><a href="./login.jsp">退出</a></dd>
                        </dl>
                      </li>
                      <li class="layui-nav-item">
                        <a href="" title="消息"><!--&#xe63a; -->
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                      </li>
                    </ul>
                </div>
            </div>
            <div class="layui-side layui-bg-black x-side">
                <div class="layui-side-scroll">
                    <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe607;</i><cite>采购管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("50")){ %><a href="javascript:;" _href="./pur/toaddPur.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>采购申请</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("54")){ %><a href="javascript:;" _href="./dcgpur/dcg.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>代采购物资</cite>
                                        </a>
                                    </dd>
                                </dd>
								 <dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("56")){ %><a href="javascript:;" _href="./purchase/selectPurchase.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>采购订单</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("62")){ %><a href="javascript:;" _href="./return/returnRequest.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>退货申请</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                    <% if(jurisdiction.contains("82")){ %><a href="javascript:;" _href="./iteminfo/inventoryIteminfo.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>库存预警</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                    <% if(jurisdiction.contains("81")){ %><a href="javascript:;" _href="./iteminfo/inventoryIteminfo.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>店仓预警</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>入库管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("11")){ %><a href="javascript:;" _href="./WarehouseOrder/selectByWhere.do" ><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>采购入库</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("12")){ %><a href="javascript:;" _href="./generalStorage/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>普通入库</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe634;</i><cite>出库管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("15")){ %><a href="javascript:;" _href="./returnRequest/selectall.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>待退货管理</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("16")){ %><a href="javascript:;" _href="./returnGoodsLibrary/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>退货出库</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("18")){ %><a href="javascript:;" _href="./MaterialLibraryID/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>领用出库</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe642;</i><cite>库存管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                       <% if(jurisdiction.contains("21")){ %> <a href="javascript:;" _href="./Stock/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>库存查询</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                        <% if(jurisdiction.contains("22")){ %><a href="javascript:;" _href="./InventoryLoss/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>库存报损</cite>
                                        </a>
                                    </dd>
                                </dd>
								<dd class="">
                                    <dd class="">
                                       <% if(jurisdiction.contains("25")){ %> <a href="javascript:;" _href="./Inventory/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                            <cite>库存盘点</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
						<li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>系统统计</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                   <% if(jurisdiction.contains("28")){ %> <a href="javascript:;" _href="./purchasrOrders/wupingcaigoubaobiao.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>物品采购统计表</cite>
                                    </a>
                                </dd>
                                <dd class="">
                                    <% if(jurisdiction.contains("29")){ %><a href="javascript:;" _href="./WarehouseOrder/selectcaigourukubaobiao.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>物品入库统计表</cite>
                                    </a>
                                </dd>
                                <dd class="">
                                    <% if(jurisdiction.contains("30")){ %><a href="javascript:;" _href="./Inventory/selectkucunpandianbaobiao.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>物品盘点统计表</cite>
                                    </a>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe630;</i><cite>审批管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                <% if(jurisdiction.contains("31")){ %><a href="javascript:;" _href="./pur/toaddPur.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>采购审批</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("36")){ %><a href="javascript:;" _href="./WarehouseOrder/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>入库审批</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("40")){ %><a href="javascript:;" _href="../MaterialLibraryID/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>出库审批</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("44")){ %><a href="javascript:;" _href="./supplyagreement/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>已办审批</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("63")){ %><a href="javascript:;" _href="./shop/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>我提交的审批</cite>
                                    </a>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe630;</i><cite>基础数据</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                <% if(jurisdiction.contains("31")){ %><a href="javascript:;" _href="./iteminfo/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>物品管理</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("36")){ %><a href="javascript:;" _href="./category/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>物品分类</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("40")){ %><a href="javascript:;" _href="./supplier/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>供应商管理</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("44")){ %><a href="javascript:;" _href="./supplyagreement/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>供货协议</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("63")){ %><a href="javascript:;" _href="./shop/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>店仓管理</cite>
                                    </a>
                                </dd><dd class="">
                                <% if(jurisdiction.contains("67")){ %><a href="javascript:;" _href="./warehouse/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>仓库管理</cite>
                                    </a>
                                </dd>
								<dd class="">
								<% if(jurisdiction.contains("71")){ %><a href="javascript:;" _href="./inventorylocation/paginglist.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>库位管理</cite>
                                    </a>
                                </dd>
                            </dl>
                        </li>
						<li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>系统设置</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                	 <% if(jurisdiction.contains("75")){ %><a href="javascript:;" _href="./user/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>用户管理</cite>
                                    </a>
                                </dd>
                                <dd class="">
                                	<% if(jurisdiction.contains("76")){ %><a href="javascript:;" _href="./role/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>角色管理</cite>
                                    </a>
                                </dd>
                                <dd class="">
                                	<% if(jurisdiction.contains("77")){ %><a href="javascript:;" _href="./Jurisdiction/selectByWhere.do"><%}else{ %> <a href="./wzgl.jsp"  onclick="rootget();"><%} %>
                                        <cite>权限管理</cite>
                                    </a>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
                <div class="x-slide_left"></div>
                <ul class="layui-tab-title">
                    <li class="layui-this">
                        我的桌面
                        <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
                    </li>
                </ul>
                <div class="layui-tab-content site-demo site-demo-body">
                    <div class="layui-tab-item layui-show">
                        <iframe frameborder="0" src="./welcome.jsp" class="x-iframe"></iframe>
                    </div>
                </div>
            </div>
            <div class="site-mobile-shade">
            </div>
        </div>
       <%}%>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-admin.js"></script>
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        
        function rootget(){
        	alert("抱歉你没有该权限，不可访问.");
        }
        </script>
    </body>
</html>