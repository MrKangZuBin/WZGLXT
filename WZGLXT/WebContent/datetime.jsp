<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/sucaijiayuan.js"></script>
<style>
*{margin:0;padding:0;list-style:none;border:none;}
body{background:#fff;}
.content{border:1px solid #ddd;width:100%;margin:0px auto;}
.datetable{border-top:1px solid #ccc;border-left:1px solid #ccc;background:#fff;}
.datetable td{border-bottom:1px solid #ccc;border-right:1px solid #ccc;text-align:center;}
.datetable thead{background:#FF0000;}
.datetable thead td{padding:10px 5px;font:normal 12px/normal 'microsoft yahei';color:#00000;text-align:center;}
.datetable thead td span{padding:0 5px;}
.datetable tbody td{padding:5px 3px;font-size:12px;}
</style>
</head>
<body>
<form name="CLD" class="content">
	<div align="center">
		<div style="float: left;margin-left: 40%;margin-top: 15px">
	    	<img src="images/tasks/u28.png">
	    </div>
	    <div style="float: right;margin-right: 38%">
	    	<br/>
	    	<font size="5px" color="#666666"><b>${userName }</b></font>
	    	<br/>
	    	<font size="3px" color="#666666">甲板部</font>
	    </div>
	</div>
	<div style="clear: both;margin-left: 28%" id="time"></div>
	<script type="text/javascript">
	 //获取系统时间，将时间以指定格式显示到页面。  
    document.getElementById('time').innerHTML=new Date().toLocaleString();     

	setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString();",1000);
	</script>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="datetable">
	    <thead>
	    <tr>
	      <td colSpan=7><span>公历</span>
	        <select name="SY" onchange="changeCld();" style="font-size: 9pt">
		      <script type="text/javascript">
	            for(i=1900;i<2050;i++) document.write('<option>'+i);
	          </script>
	        </select><span>年</span>
	        <select name="SM" onchange="changeCld();" style="font-size: 9pt">
		      <script type="text/javascript">
	            for(i=1;i<13;i++) document.write('<option>'+i);
	          </script>
	       	</select><span>月</span>
	       <span id="GZ"></span>
	      </td>
	    </tr>
	    </thead>
	    <tbody>
	    <tr style="background:#eee;">
	      <td width="54">日</td>
	      <td width="54">一</td>
	      <td width="54">二</td>
	      <td width="54">三</td>
	      <td width="54">四</td>
	      <td width="54">五</td>
	      <td width="54">六</td>
	    </tr>            
	    <script type="text/javascript">
	    var gNum;
	    for(i=0;i<6;i++) {
	       document.write('<tr align="center">');
	       for(j=0;j<7;j++) {
	          gNum = i*7+j;
	          document.write('<td id="GD' + gNum +'"><font id="SD' + gNum +'" size=2 face="Arial Black"');
	          if(j == 0) document.write('color="red"');
	          if(j == 6) document.write('color="#000080"');
	          document.write('></font><br/><font id="LD' + gNum + '" size=2 style="font-size:9pt"></font></td>');
	       }
	       document.write('</tr>');
	    }
	   </script>
	   </tbody>
	   </table>
</form>
</body>
