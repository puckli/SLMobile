<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.2" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.fileinfo{width:40%;height:260px; float:left;}
.fileinfo span{line-height:1.6em;}
.fileimg{width:59%;height:260px;max-height:98%; float:right;}
.img{margin:2px;padding:0px;overflow:hidden;max-width: 100%; max-height: 98%;}
.clear-border{border:none;}
.wrap{width:96%;margin:10px auto 5px;}
.title1{text-align:center;font-size:1.3em;margin:0px 3px;font-family: "微软雅黑","Helvetica Neue Light","Arial",;}
</style>
<link rel="stylesheet" type="text/css" href="style/button.css">
</head>
<body>
	 <header>
    	<a class="button button-rounded" href="javascript:location=document.referrer;">
    	<img class="btnimg" alt="" src="../slmobile/resource/back.ico">返回</a> 
    </header>
	<section class="wrap">
		<p class="title1">文件：${requestScope.file.name} </p>
		<div>
			<div class="fileinfo" id="fileinfo">
				<input type="hidden" id="fid" value="<s:property value='#request.file.id'/>"/>
				<input type="hidden" id="cdate" value="<s:property value='#request.file.createTime'/>"/>
				<input type="hidden" id="imgname" value="<s:property value='#request.file.name'/>.<s:property value='#request.file.type'/>"/>
				
				<span>文件编号：</span><span>${requestScope.file.filesNumber}</span><br/>
				<span>当前状态：</span>
				<span>
					<s:if test="#request.file.hasObject==1">电子版</s:if>
					<s:elseif test="#request.file.ostate==0">在库</s:elseif>
					<s:elseif test="#request.file.ostate==1">借出</s:elseif>
					<s:elseif test="#request.file.ostate==2">丢失</s:elseif>
					<s:elseif test="#request.file.ostate==3">补办中</s:elseif>
					<s:elseif test="#request.file.ostate==4">申请中</s:elseif>
				</span><br/>
				<span>监管人：</span><span>${requestScope.file.ouser.name}</span><br/>
				<span>监管人电话：</span><span>${requestScope.file.ouser.phone}</span><br/>
				<span>总借出次数：</span><span>${requestScope.file.applyCount}</span><br/>
				<span>文件位置：</span>
				<span>${requestScope.file.oaddress}</span><br/>
				<span>注册日期：</span>
				<span>${requestScope.file.filesRegisterDate}</span><br/>
				<span>有效期至：</span>
				<span>${requestScope.file.filesExpireDate}</span><br/>
			</div>
			<div class="fileimg">
				<img alt="文件图片" class="img" id="img" title="文件图片" src="">
			</div>
		</div>
	</section>
	
	
	
<script type="text/javascript">
window.onload=function()
{
	//getFileInOutRecord();
	//getLogInfo();
	var imgname = document.getElementById("imgname").value;
	var cdate = document.getElementById("cdate").value;
	var url = "zx/getFileImage.action?name="+encodeURI(imgname, "utf-8") + "&date="+cdate;
	document.getElementById("img").setAttribute("src",url);
}
</script>	
	
	
	
</body>
</html>
