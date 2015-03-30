<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'pushpolling.jsp' starting page</title>

<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<section>
		<div>
			用户名：
			<input type="text" name="uid" id="uid">
			密码：
			<input type="password" name="password" id="password">
			<input onclick="push('start');" type="button" value="开启">
			<input onclick="push('end');" type="button" value="关闭">
		</div>
		<div>
			<button onclick="reloadSetting()">ReloadSetting</button>
		</div>
	</section>
	
	<script type="text/javascript">
		var xmlHttpRequest = null;
		function push(arg)
		{
			
			if(window.ActiveXObject)
			{
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			else if(window.XMLHttpRequest)
			{
				xmlHttpRequest = new XMLHttpRequest();
			}
			if(null != xmlHttpRequest)
			{
				var uid = document.getElementById("uid").value;
				var password = document.getElementById("password").value;
				xmlHttpRequest.open("POST","/slmobile/application/pushStart",true);
				xmlHttpRequest.onreadystatechange = ajaxCallback;
				xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
				xmlHttpRequest.send("uid=" + uid + "&password=" + password + "&arg=" + arg);
			}
		}
		function ajaxCallback()
		{
			if(xmlHttpRequest.readyState == 4)
			{
				if(xmlHttpRequest.status == 200)
				{
					var responseText = xmlHttpRequest.responseText;
					if(responseText == "success")
					{
						alert("操作成功！");
					}
					else if(responseText == "isStarted"){
						alert("在这之前已经开启，请先关闭在开启！");
					}
					else if(responseText === "userWrong")
					{
						alert("uid 或者密码错误！");
					}
					else{
						alert("操作失败！" + responseText);
					}
				}
			}
		}
		
		function reloadSetting()
		{
			ajax("/slmobile/application/reloadSetting");
		}
		
		var xmlHttpReq = null;
		function ajax(url)
		{
			if(window.ActiveXObject)
			{
				xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			}
			else if(window.XMLHttpRequest)
			{
				xmlHttpReq = new XMLHttpRequest();
			}
			if(null != xmlHttpReq)
			{
				var uid = document.getElementById("uid").value;
				var password = document.getElementById("password").value;
				xmlHttpReq.open("POST",url,true);
				xmlHttpReq.onreadystatechange = ajaxCallbacks;
				xmlHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
				xmlHttpReq.send("uid=" + uid + "&password=" + password);
			}
		}
		function ajaxCallbacks()
		{
			if(xmlHttpReq.readyState == 4)
			{
				if(xmlHttpReq.status == 200)
				{
					var responseText = xmlHttpReq.responseText;
					if(responseText == "success")
					{
						alert("操作成功！");
					}
					else if(responseText === "userWrong")
					{
						alert("uid 或者密码错误！");
					}
					else{
						alert("操作失败！" + responseText);
					}
				}
			}
		}
	</script>

</body>
</html>














