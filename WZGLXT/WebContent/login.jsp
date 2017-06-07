<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>物资管理系统-登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<link rel="shortcut icon" href="images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="themes/js/jquery.min.js" type="text/javascript"></script>
<script src="themes/js/jquery.form.js" type="text/javascript"></script>
<script src="themes/js/json.parse.js" type="text/javascript"></script>
<style type="text/css">
html,body {
	height: 100%;
}
.login_btn{
	width:100%;
	height:35px;
	color:blue;
}	
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 300px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>
</head>
<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>登录</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form id="fm">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="username" class="form-control" placeholder="用户名">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="password" name="password" class="form-control" placeholder="密码">
						</div>
					</div>
				</div>
			</form>
				<div class="form-group form-actions">
					<div style="line-height:30px; text-indent:10px;color:#F30" id="loginTips">&nbsp;</div>
					<div class="col-xs-4 col-xs-offset-4 ">
						<input class="login_btn" id="loginBtn" type="button" value="登录"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){	
		$("#loginBtn").click(function(){
			var username = $("#username").val();
			var userpass = $("#password").val();
				username = $.trim(username);
				userpass = $.trim(userpass);
			$("#loginTips").css({display:"none"});	
			
			if(username.length <2){
				//$("#username_tips").html("请输入正确的用户名!").css({display:"block"});
				$("#loginTips").html("请输入正确的用户名!").fadeIn();
				$("#loginBtn").val('登录').removeAttr('disabled');
				return false;
			}
			if(userpass == ''){
				$("#loginTips").html("请输入正确的密码!").fadeIn();
				$("#loginBtn").val('登录').removeAttr('disabled');
				return false;
			}
			$.ajax({
                url:"user/toLogin.do",
                type:"post",
                contentType:"application/x-www-form-urlencoded; charset=utf-8", 
                data:{username:username,password:userpass},
                success:function(data){
                    var result=data.success;
                    var error=data.errorInfo;
                    if(result){
                    	window.location.href="user/selectjurisdictionid.do?userid="+data.userid;
                    }else{
    					alert(error);
    				}
                }
            })      
		})
	})	
	//bind keyCode=13 Event
	$(function(){
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	$("#loginBtn").click();
		     }
		}
	}); 
</script>
</body>
</html>