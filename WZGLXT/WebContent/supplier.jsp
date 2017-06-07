<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据-供应商管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--web-fonts-->
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,300italic,600,700'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700'
	rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<script type="text/javascript">  
	
</script>
<script type="text/javascript">

	var supplierid;
	var suppliercode;
	var supplierabbreviation;
	var chinesename;
	var englishname;
	var status;
	var email;
	var companytelephone;
	var fax;
	var contacts;
	var contactstelephone;
	var postalcode;
	var bankaccount;
	var bankcode;
	var accountholder;
	var loginaccount;
	var loginpassword;
	var businesslicense;
	var organizationcodecertificate;
	var legalrepresentative;
	var taxregistrationnumber;
	var nationalityid;
	var provinceid;
	var cityid;
	var address;
	var description;
	var createtime;
	var finalprocessingtime;
	var createpersonid;
	var lastpersonid;
	var createpersonname;
	var lastpersonname;
	var bool=false;
	function selected(supplierid_o,suppliercode_o,supplierabbreviation_o,chinesename_o,englishname_o,
			 status_o,email_o,companytelephone_o, fax_o,contacts_o,contactstelephone_o,postalcode_o,
			 bankaccount_o,bankcode_o, accountholder_o,loginaccount_o, loginpassword_o, businesslicense_o,
			 organizationcodecertificate_o, legalrepresentative_o, taxregistrationnumber_o, nationalityid_o, provinceid_o,
			 cityid_o,address_o,description_o,createtime_o,finalprocessingtime_o,
			 createpersonid_o,lastpersonid_o,createpersonname_o,lastpersonname_o){
		$("#"+supplierid).removeClass("danger");
		supplierid=supplierid_o;
		suppliercode=suppliercode_o;
		supplierabbreviation=supplierabbreviation_o;
		chinesename=chinesename_o;
		englishname=englishname_o;
		status=status_o;
		email=email_o;
		companytelephone=companytelephone_o;
		fax=fax_o;
		contacts=contacts_o;
		contactstelephone=contactstelephone_o;
		postalcode=postalcode_o;
		bankaccount=bankaccount_o;
		bankcode=bankcode_o;
		accountholder=accountholder_o;
		loginaccount=loginaccount_o;
		loginpassword=loginpassword_o;
		businesslicense=businesslicense_o;
		organizationcodecertificate=organizationcodecertificate_o;
		legalrepresentative=legalrepresentative_o;
		taxregistrationnumber=taxregistrationnumber_o; 
		nationalityid=nationalityid_o; 
		provinceid=provinceid_o;
		cityid=cityid_o;
		address=address_o;
		description=description_o;
		createtime=createtime_o;
		finalprocessingtime=finalprocessingtime_o;
		createpersonid=createpersonid_o;
		lastpersonid=lastpersonid_o;
		createpersonname=createpersonname_o;
		lastpersonname=lastpersonname_o;
		bool=true;
		//$("#"+companytelephoneid).attr("class", "info");
		$("#"+supplierid).addClass("danger");
	}
	function getaddjson() {
		$.ajax({
			url:"${pageContext.request.contextPath}/supplier/selRequest.do",
			type:"post",
			datatType:"json",
			success:function(data){
				$("#suppliercode").val(data.code);
			}
		});
	}

	function notselected() {
		alert("请选中一行数据！");
	};
	function add() {
		$(':text').val("");
		$("select").val("");
		getNationality();
		getaddjson();
		$("#tabledv").hide();
		$("#filebtn").hide();
		$("#subform").attr("action","${pageContext.request.contextPath }/supplier/add.do");
		applyed();
	};
	function edit() {
		if(!bool){
			notselected();
			return false;
		}
		getNationality(1);
		getCity(nationalityid,1);
		getArea(provinceid,1);
		$("#tabledv").show();
		$("#filebtn").show();
		$("#supplierid").val(supplierid);
		$("#suppliercode").val(suppliercode);
		$("#supplierabbreviation").val(supplierabbreviation);
		$("#chinesename").val(chinesename);
		$("#englishname").val(englishname);
		$("#status").val(status);
		$("#email").val(email);
		$("#companytelephone").val(companytelephone);
		$("#fax").val(fax);
		$("#contacts").val(contacts);
		$("#contactstelephone").val(contactstelephone.replace(/\D/g,''));
		$("#contactstelephoneselect").val(contactstelephone.replace(/\d+/g,''));
		$("#postalcode").val(postalcode);
		$("#bankaccount").val(bankaccount);
		$("#bankcode").val(bankcode);
		$("#accountholder").val(accountholder);
		$("#loginaccount").val(loginaccount);
		$("#loginpassword").val(loginpassword);
		$("#businesslicense").val(businesslicense);
		$("#organizationcodecertificate").val(organizationcodecertificate);
		$("#legalrepresentative").val(legalrepresentative);
		$("#taxregistrationnumber").val(taxregistrationnumber);
		
		$("#address").val(address);
		$("#description").val(description);
		$("#createtime").text(createtime);
		$("#finalprocessingtime").text(finalprocessingtime);
		$("#createpersonid").val(createpersonid);
		//$("#lastpersonid").val(lastpersonid);
		$("#createpersonname").text(createpersonname);
		$("#lastpersonname").text(lastpersonname);
		$("#subform").attr("action","${pageContext.request.contextPath }/supplier/update.do");
		applyed();
	};
	
	function del() {
		if(!bool){
			notselected();
			return false;
		}
		$("#delid").val(supplierid);
		$("#delform").attr("action","${pageContext.request.contextPath }/supplier/delete.do");
		$("#gray").show();
		$("#popupdel").show();
		tc_center();
	};
	function hidedel() {
		$("#gray").hide();
		$("#popupdel").hide();
	}
	function applyed() {
		$("#gray").show();
		$("#popup").show();//查找ID为popup的DIV show()显示#gray
		center();
	};
	//点击关闭按钮
	function hide() {
		$("#gray").hide();
		$("#popup").hide();//查找ID为popup的DIV hide()隐藏
	}
	/*加载国籍下拉选  ${pageContext.request.contextPath}*/  
	function getNationality(flag) {  
		$("#nationalityid").empty();  
	    $.ajax({  
	        type: "post",  
	        url: "${pageContext.request.contextPath}/area/getNationality.do",  
	        success: function (data) {  
	        	if(flag==1){
	        		 for (var i = 0; i < data.length; i++) {  
			         	$('#nationalityid').append("<option value='" + data[i].provincecityid + "' >" + data[i].provincecityname + "</option>");  
			         } 
	            	$("#nationalityid").val(nationalityid);
	            }else{
		        	$('#nationalityid').append("<option value='' selected='selected' >" + '请选择' + "</option>");
		            for (var i = 0; i < data.length; i++) {  
		                $('#nationalityid').append("<option value='" + data[i].provincecityid + "' >" + data[i].provincecityname + "</option>");  
		            }  
	            }
	        },  
	        error: function () {  
	            alert("加载国籍失败");  
	        }  
	    });  
	} 
	/*加载省下拉选*/  
	function getCity(id,flag) {  
// 	    var id = $("#nationalityid").val();  
	    $("#provinceid").empty();  
	    $("#cityid").empty();  
	    $.ajax({  
	        type: "post",  
	        url: "${pageContext.request.contextPath}/area/getProvince.do",  
	        data: {"id": id},  
	        success: function (data) {  
	        	if(flag==1){
	        		for (var i = 0; i < data.length; i++) {  
		                $('#provinceid').append("<option value='" + data[i].provincecityid + "' >" + data[i].provincecityname + "</option>");  
		            } 
	            	$("#provinceid").val(provinceid);
	            }else{
		            $('#provinceid').append("<option value='' selected='selected' >" + '请选择' + "</option>");  
		            $('#cityid').append("<option value='' selected='selected' >" + '请选择' + "</option>");  
		            for (var i = 0; i < data.length; i++) {  
		                $('#provinceid').append("<option value='" + data[i].provincecityid + "' >" + data[i].provincecityname + "</option>");  
		            } 
	            }
	        },  
	        error: function () {  
	        	alert("加载省失败");  
	        }  
	    });  
	}  
	;  
	/*加载市下拉选*/  
	function getArea(id,flag) {  
// 	    var id = $("#provinceid").val();  
	    $("#cityid").empty();  
	    $.ajax({  
	        type: "post",  
	        url: "${pageContext.request.contextPath}/area/getCity.do",  
	        data: {"id": id},  
	        success: function (data) {  
	        	if(flag==1){
	        		for (var i = 0; i < data.length; i++) {  
		                $('#cityid').append("<option value='" + data[i].provincecityid + "' >" + data[i].provincecityname + "</option>");  
		            }
	            	$("#cityid").val(cityid);
	            }else{
		            $('#cityid').append("<option value='' selected='selected' >" + '请选择' + "</option>");  
		            for (var i = 0; i < data.length; i++) {  
		                $('#cityid').append("<option value='" + data[i].provincecityid + "' >" + data[i].provincecityname + "</option>");  
		            }
	            }
	        },  
	        error: function () {  
	        	alert("加载市失败"); 
	        }  
	    });  
	}  
	function center(){
		var _top=($(window).height()-$("#popup").height())/2;
		var _left=($(window).width()-$("#popup").width())/2;
		$("#popup").css({top:_top,left:_left});
	}
	function ps(){
		if (document.getElementById('loginpassword').type="password"){
			$("#box").html("<input class='form-control select-lg' type='text' name='loginpassword' id='loginpassword' style='width: 50%' value="+$("#loginpassword").val()+">");
			$("#click").html("<a href='javascript:txt()'>隐藏密码</a>");
		}
	};
	function txt(){
		if (document.getElementById('loginpassword').type="text"){
			$("#box").html("<input class='form-control select-lg' type='password' name='loginpassword' id='loginpassword' style='width: 50%' value="+$("#loginpassword").val()+">");
			$("#click").html("<a href='javascript:ps()'>显示密码</a>");
		}
	};
	function checkfile(target) {
		var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
		var fileSize = 0;
		if (isIE && !target.files) {
			var filePath = target.value;
			var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
			var file = fileSystem.GetFile(filePath);
			fileSize = file.Size;
		} else {
			fileSize = target.files[0].size;
		}
		var size = fileSize / 1024;
		if (size > 5120) {
			alert("附件不能大于5M,请重新选择！");
			$("#protocoenclosurefile").after($("#protocoenclosurefile").clone().val(""));   
			$("#protocoenclosurefile").remove(); 
		}

	}
	function addfiles(){
		filelist(supplierid);
	}
	function filelist(sid) {
		$.ajax({
			url:"${pageContext.request.contextPath}/supplierannex/annexlist.do",
			type:"post",
			data:{supplierid:sid},
			datatType:"json",
			success:function(data){
				$("#filetable").html("");
				var list = data.list;
				for (var i = 0; i < list.length; i++) {
					$("#filetable")
					.prepend(
							"<tr id='"+list[i].supplierannexid+"' align='center'> <td>"
									+ list[i].annexname
									+ "</td> <td><a href='${pageContext.request.contextPath }/supplyagreement/fileDownload.do?filename="+list[i].annexpath+"' style='color: #6633ff'>下载</a></td><td><a style='color: #ff0033'  onclick='delfile("+list[i].supplierannexid+",\""+list[i].annexpath+"\")'>删除</a></td> </tr>");
				}
			}
		});
		$("#fileinputid").val(sid);
	}
	function delfile(id,path) { 
		 $.ajax({  
             url: '${pageContext.request.contextPath}/supplierannex/delete.do' ,  
             type: 'POST',  
             data: {supplierannexid:id,path:path}, 
             datatType:"json",
             success: function (returndata) {  
            	 filelist(supplierid);
             },  
             error: function (returndata) {  
                 alert("删除失败！");  
             }  
        });
		//href='${pageContext.request.contextPath}/supplierannex/delete.do?supplierannexid="+list[i].supplierannexid+"&&path="+list[i].annexpath+"'
	}
	function Upload() { 
		if($("#protocoenclosurefile" ).val()==''){
			alert("请选择文件！");
		}else{
			doUpload();
		}
	}
    function doUpload() {  
        var formData = new FormData($("#uploadForm" )[0]);  
        $.ajax({  
             url: '${pageContext.request.contextPath}/supplierannex/add.do' ,  
             type: 'POST',  
             data: formData,  
             async: false,  
             cache: false,
             datatType:"json",
             contentType: false,  
             processData: false,  
             success: function (returndata) {
            	 $("#protocoenclosurefile").after($("#protocoenclosurefile").clone().val(""));
            	 $("#protocoenclosurefile").remove(); 
            	 filelist(supplierid);  
             },  
             error: function (returndata) {  
                 alert("文件上传失败！");  
             }  
        });  
   }  
</script>

</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<%
		List jurisdiction = (List) session.getAttribute("list");
	%>
	<div id="gray"></div>
	<div class="popup" id="popupdel" style="padding: 50px;">
		<center>
			<h2 style="color: #979797">确认删除？</h2>
			<br>
			<h5 style="color: #ff3300">此操作不可恢复，是否继续？</h5>
		</center>
		<br>
		<form class="form-horizontal" role="form" id="delform" action="#"
			method="post">
			<input type="hidden" name="currpage" value="${currpage }" /> <input
				type="hidden" name="suppliercode_o" value="${suppliercode }" /> <input
				type="hidden" name="suppliername_o" value="${suppliername }" /> <input
				type="hidden" name="supplierstatus_o" value="${supplierstatus }" />
			<input type="hidden" id="delid" name="supplierid">
			<center>
				<input style="padding-left: 30px; padding-right: 30px" type="button"
					class="btn btn-info" onclick="hidedel()" value="取消"> <input
					style="padding-left: 30px; padding-right: 30px" type="submit"
					class="btn btn-danger" value="确认" />
			</center>
		</form>
	</div>
	<div style="width: 100%;" align="center">
		<div style="width: 90%;" align="center">
			<div>
				<h3 class="b-tittle" style="color: #00ccff">供应商管理</h3>
				<div class="popup" id="popup"
					style="width: 90%; padding-bottom: 30px; padding-left: 30px; padding-right: 30px;">
					<div class="top_nav" id='top_nav' style="padding-top: 20px;">
						<span>新增/编辑 </span><a class="guanbi" onclick="hide();"></a><br>
					</div>
					<br>
					<form class="form-inline" role="form" id="subform" action="#"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="currpage" value="${currpage }" /> <input
							type="hidden" name="supplierid" id="supplierid" /> <input
							type="hidden" name="suppliercode_o" value="${suppliercode }" />
						<input type="hidden" name="suppliername_o"
							value="${suppliername }" /> <input type="hidden"
							name="supplierstatus_o" value="${supplierstatus }" /> <input
							type="hidden" id="createpersonid" name="createpersonid"
							value="${userID }" /> <input type="hidden" id="lastpersonid"
							name="lastpersonid" value="${userID }" />
						<div style="width: 100%; height: 400px; overflow: auto;">
							<table class="table table-condensed" style="background: #edebec;">
								<thead>
									<tr>
										<td><label for="exampleInputEmail1">供应商代码<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="suppliercode"
											id="suppliercode" readonly="readonly" /></td>
										<td><label for="exampleInputEmail1">中文名称<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="chinesename"
											id="chinesename" /></td>
										<td width="30%"></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">供应商简称<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="supplierabbreviation"
											id="supplierabbreviation" /></td>
										<td><label for="exampleInputEmail1">英文名称</label> <input
											class="form-control select-lg" type="text" style="width: 70%"
											name="englishname" id="englishname" /></td>
										<td width="30%"></td>
									</tr>
								</thead>
							</table>
							<table class="table table-condensed" style="background: #edebec;">
								<thead>
									<tr>
										<td colspan="3"><strong
											style="color: #828282; font-size: 16px;">基本信息 </strong></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">&#12288;&#12288;状态<font
												color="red">*</font></label> <select class="form-control select-lg"
											style="width: 70%" name="status" id="status">
												<option value="可用">可用</option>
												<option value="不可用">不可用</option>
										</select></td>
										<td><label for="exampleInputEmail1">E-MAIL<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="email" id="email" /></td>
										<td><label for="exampleInputEmail1">公司电话<font
												color="red">*</font></label><input class="form-control select-lg"
											type="text" style="width: 70%" name="companytelephone"
											id="companytelephone" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">&#12288;&#12288;传真<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="fax" id="fax" /></td>
										<td><label for="exampleInputEmail1">&#12288;联系人<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="contacts" id="contacts" /></td>
										<td><label for="exampleInputEmail1">联系人电话<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="contactstelephone"
											id="contactstelephone" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">开户银行<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="bankaccount"
											id="bankaccount" /></td>
										<td><label for="exampleInputEmail1">银行账号<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="bankcode" id="bankcode" /></td>
										<td><label for="exampleInputEmail1">开户人<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="accountholder"
											id="accountholder" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">登录账号<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="loginaccount"
											id="loginaccount" /></td>
										<td colspan="2"><label for="exampleInputEmail1">登录密码<font
												color="red">*</font></label> <span id="box"><input
												class="form-control select-lg" type="text"
												style="width: 50%" name="loginpassword" id="loginpassword" /></span><span
											id="click"><a href="javascript:txt()">隐藏密码</a></span></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">营业执照<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="businesslicense"
											id="businesslicense" /></td>
										<td><label for="exampleInputEmail1">组织机构代码证<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%"
											name="organizationcodecertificate"
											id="organizationcodecertificate" /></td>
										<td><label for="exampleInputEmail1">邮编<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="postalcode"
											id="postalcode" /></td>
									</tr>
									<tr>
										<td><label for="exampleInputEmail1">法人代表<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="legalrepresentative"
											id="legalrepresentative" /></td>
										<td><label for="exampleInputEmail1">税务登记号<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 70%" name="taxregistrationnumber"
											id="taxregistrationnumber" /></td>
										<td id="filebtn"><a id="modal-246071"
											onclick="addfiles()" href="#modal-container-246071"
											role="button" class="btn" data-toggle="modal">附件</a></td>
									</tr>
									<tr>
										<td colspan="3"><label for="exampleInputEmail1">地区<font
												color="red">*</font></label> <select class="form-control select-lg"
											style="width: 25%" name="nationalityid" id="nationalityid"
											onchange="getCity(this.value)">
												<option value="">请选择</option>

										</select> <select class="form-control select-lg" style="width: 25%"
											name="provinceid" id="provinceid"
											onchange="getArea(this.value)">
												<option value="">请选择</option>

										</select> <select class="form-control select-lg" style="width: 25%"
											name="cityid" id="cityid">
												<option value="">请选择</option>

										</select></td>
									</tr>
									<tr>
										<td colspan="3"><label for="exampleInputEmail1">地址<font
												color="red">*</font></label> <input class="form-control select-lg"
											type="text" style="width: 60%" name="address" id="address" /></td>
									</tr>
									<tr>
										<td colspan="3"><label for="exampleInputEmail1"
											style="vertical-align: top;">备注&nbsp;</label> <textarea
												rows="3" cols="50" style="width: 80%" name="description"
												id="description"></textarea></td>
									</tr>
								</thead>
							</table>

							<table class="table table-condensed" style="background: #edebec;"
								id="tabledv">
								<thead>
									<tr align="center">
										<td><label for="exampleInputEmail1">创建时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797" id="createtime"></font></td>
										<td><label for="exampleInputEmail1">最后修改时间&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="finalprocessingtime"></font></td>
										<td width="30%"></td>
									</tr>
									<tr align="center">
										<td><label for="exampleInputEmail1">&#12288;创建人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="createpersonname"></font></td>
										<td><label for="exampleInputEmail1">最后修改人&#12288;&#12288;</label>
											<font style="font-size: 16px; color: #979797"
											id="lastpersonname"></font></td>
										<td width="30%"></td>
									</tr>
								</thead>
							</table>
						</div>
						<center>
							<input style="padding-left: 30px; padding-right: 30px"
								type="button" class="btn btn-info" onclick="hide()" value="取消">
							<input style="padding-left: 30px; padding-right: 30px"
								type="submit" class="btn btn-warning" value="保存" />
						</center>

					</form>
				</div>
				<div class="modal fade" id="modal-container-246071" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">附件</h4>
							</div>
							<div class="modal-body">
								<form id="uploadForm">
									<table>
										<tr>
											<td><input type="hidden" id="fileinputid"
												name="supplierid_add" /> <input type="file"
												name="protocoenclosurename" id="protocoenclosurefile"
												onchange="checkfile(this);" /></td>
											<td><input type="button" class="btn btn-success"
												value="上传附件" onclick="Upload();" /></td>
										</tr>
									</table>

								</form>
								<div
									style="width: 100%; height: 150px; overflow: auto; background-color: #ffffff;">
									<table class="table table-condensed" id="filetable">
										<tr>
											<td>暂无数据！</td>
										</tr>
									</table>

								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
							</div>
						</div>

					</div>

				</div>
				<form class="form-search"
					action="${pageContext.request.contextPath }/supplier/paginglist.do">
					<table class="table" style="background: #edebec">
						<thead>
							<tr>
								<td><label for="exampleInputEmail1">供应商代码</label> <input
									class="form-control select-lg" type="text"
									name="suppliercode_o" value="${suppliercode }" /></td>
								<td><label for="exampleInputEmail1">供应商名称</label> <input
									class="form-control select-lg" type="text"
									name="suppliername_o" value="${suppliername }" /></td>
								<td><label for="exampleInputEmail1">状态</label> <select
									name="supplierstatus_o" class="form-control select-lg">
										<option value="">全部</option>
										<option value="可用" ${supplierstatus=="可用"?"selected":"" }>可用</option>
										<option value="不可用" ${supplierstatus=="不可用"?"selected":"" }>不可用</option>
								</select></td>
								<td>
									<button type="submit" class="btn btn-defult btn-info"
										style="margin-top: 25px">查询</button>
								</td>
							</tr>
						</thead>
					</table>
				</form>
				<%
					if (jurisdiction.contains("39")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="add()">新增供应商</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">新增供应商</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("42")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="edit()">编辑供应商</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">编辑供应商</button>
				<%
					}
				%>
				<%
					if (jurisdiction.contains("41")) {
				%><button type="button" class="btn btn-defult btn-warning"
					onclick="del()">删除供应商</button>
				<%
					} else {
				%><button class="btn btn-warning" type="button" onclick="rootget();">删除供应商</button>
				<%
					}
				%>
				<c:choose>
					<c:when test="${list!='[]'}">
						<table class="table table-hover table-bordered"
							style="margin-top: 10px">
							<thead>
								<tr class="info">
									<th>序号</th>
									<th>供应商代码</th>
									<th>供应商名称</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>创建人</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="supplier" varStatus="i">

									<tr id="${supplier.supplierid }"
										${(i.index+1)%2==0?"class='error'":"class='success'"}
										onclick="selected('${supplier.supplierid }','${supplier.suppliercode }','${supplier.supplierabbreviation }','${supplier.chinesename }','${supplier.englishname }',
								'${supplier.status }','${supplier.email }','${supplier.companytelephone }','${supplier.fax }','${supplier.contacts }','${supplier.contactstelephone }','${supplier.postalcode }','${supplier.bankaccount }','${supplier.bankcode }',
								'${supplier.accountholder }','${supplier.loginaccount }','${supplier.loginpassword }','${supplier.businesslicense }','${supplier.organizationcodecertificate }','${supplier.legalrepresentative }',
								'${supplier.taxregistrationnumber }','${supplier.nationalityid }','${supplier.provinceid }','${supplier.cityid }','${supplier.address }','${supplier.description }',
								'<fmt:formatDate value="${supplier.createtime }"
												type="both"/>',
								'<fmt:formatDate value="${supplier.finalprocessingtime }"
												type="both"/>',
								'${supplier.createpersonid }','${supplier.lastpersonid }','${supplier.createpersonname }','${supplier.lastpersonname }')">
										<td>${i.index+1 }</td>
										<td>${supplier.suppliercode }</td>
										<td>${supplier.chinesename }</td>
										<td>${supplier.status }</td>
										<td><fmt:formatDate value="${supplier.createtime }"
												type="both" /></td>
										<td>${supplier.createpersonname }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<table width="100%">
							<tr>
								<td width="18%">
									<div style="padding-top: 20px">
										<h6>
											共<strong style="color: #b93d00">${rowcount }</strong>条记录
											&nbsp;当前<strong style="color: #b93d00">${currpage }/${totalpage }</strong>页&nbsp;
										</h6>
									</div>
								</td>
								<td width="50%">
									<div>
										<ul class="pagination">
											<li><a
												href="${pageContext.request.contextPath }/supplier/paginglist.do?currpage=1&&suppliercode_o=${suppliercode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}">首页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/supplier/paginglist.do?currpage=${currpage-1 }&&suppliercode_o=${suppliercode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}">上一页</a></li>

											<c:forEach begin="${currpage-2>=0?currpage-2:'0' }"
												end="${currpage+2 }" step="1" var="i">
												<c:if test="${i>0&&i<=totalpage?'true':'false'}">
													<li><a
														href="${pageContext.request.contextPath }/supplier/paginglist.do?currpage=${i }&&suppliercode_o=${suppliercode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}"
														${i==currpage?"style='color: red'":"" }>${i}</a></li>
												</c:if>
											</c:forEach>
											<li><a
												href="${pageContext.request.contextPath }/supplier/paginglist.do?currpage=${currpage+1 }&&suppliercode_o=${suppliercode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}">下一页</a></li>
											<li><a
												href="${pageContext.request.contextPath }/supplier/paginglist.do?currpage=${totalpage }&&suppliercode_o=${suppliercode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}">尾页</a></li>
										</ul>
									</div>
								</td>
								<td width="32%">
									<div style="padding-top: 10px">
										<form class="navbar-form navbar-left" role="search"
											action="${pageContext.request.contextPath }/supplier/paginglist.do?suppliercode_o=${suppliercode}&&itemname_o=${itemname}&&bankaccount_o=${bankaccount}&&itemmaterial_o=${itemmaterial}"
											method="post">
											<input type="text" class="form-control" name="currpage"
												onkeyup="this.value=this.value.replace(/\D/g,'')"
												onafterpaste="this.value=this.value.replace(/\D/g,'')" />
											<button type="submit" class="btn btn-default">跳转</button>
										</form>
									</div>
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<br>
						<br>
						<br>
						<div class="container-fluid">
							<div class="row-fluid">
								<div class="span12">
									<div class="alert alert-info">
										<h3 align="center">抱歉，暂无数据！</h3>
									</div>
								</div>
							</div>
						</div>

					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>