<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<link rel="shortcut icon" href="images/favicon.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Nuevo Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/towstyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="applijegleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath }/css/style.css" rel='stylesheet' type='text/css' />	
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<!-- start menu -->
<link href="${pageContext.request.contextPath }/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/megamenu.js"></script>
<!-- <script>$(document).ready(function(){$(".megamenu").megamenu();});</script> -->
<script src="${pageContext.request.contextPath }/js/menu_jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/simpleCart.min.js"> </script>
<script src="${pageContext.request.contextPath }/My97DatePickers/WdatePicker.js"> </script>
<!--web-fonts-->
 <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700' rel='stylesheet' type='text/css'>
 <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700' rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<script src="${pageContext.request.contextPath }/js/scripts.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easing.js"></script>
</head>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>
<!--加载响应式小窗口-->
<script type="text/javascript">

function rootget(){
	alert("抱歉你没有该权限，不可访问.");
}
//窗口水平居中
$(window).resize(function(){
	tc_center();
});

function tc_center(){
	var _top=($(window).height()-$(".popup").height())/2;
	var _left=($(window).width()-$(".popup").width())/2;
	
	$(".popup").css({top:_top,left:_left});
}	
</script>

<script type="text/javascript">
$(document).ready(function(){ 

	$(".top_nav").mousedown(function(e){ 
		$(this).css("cursor","move");//改变鼠标指针的形状 
		var offset = $(this).offset();//DIV在页面的位置 
		var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离 
		var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离 
		$(document).bind("mousemove",function(ev){ //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件 
		
			$(".popup").stop();//加上这个之后 
			
			var _x = ev.pageX - x;//获得X轴方向移动的值 
			var _y = ev.pageY - y;//获得Y轴方向移动的值 
		
			$(".popup").animate({left:_x+"px",top:_y+"px"},10); 
		}); 

	}); 

	$(document).mouseup(function() { 
		$(".popup").css("cursor","default"); 
		$(this).unbind("mousemove"); 
	});
}) 
</script>
<!-- 结束弹出小窗口 -->