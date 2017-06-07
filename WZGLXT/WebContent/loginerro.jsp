<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>setTimeout</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
 <script type="text/javascript">     
  function countDown(secs){     
   //alert(surl);     
   var jumpTo = document.getElementById('jumpTo');
   jumpTo.innerHTML=secs;  
   if(--secs>0){     
     setTimeout("countDown("+secs+")",1000);     
      }     
  else{       
	  get();    
      }     
  } 
  
  function get() {
	  history.back();
	  location.replace("http://localhost:8080/WZGLK/wzgl.jsp") 
}
  
 </script> 
 </head>
 <body>登入信息已丢失<span id="jumpTo">,5</span>秒后自动跳转到登入页面
 <script type="text/javascript">countDown(5);</script>  
 </body>