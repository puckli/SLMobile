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
<title>My JSP 'page2.jsp' starting page</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script>
	var sock = new SockJS('http://localhost:8080/slmobile/websocket');
	sock.onopen = function()
	{
		document.getElementById("msgo").innerHTML="open";
		console.log('open');
	};
	sock.onmessage = function(e)
	{
		document.getElementById("msg").innerHTML=e.date;
		console.log('message', e.data);
	};
	sock.onclose = function()
	{
		document.getElementById("msgc").innerHTML="close";
		console.log('close');
	};
</script>
</head>

<body>
	
	<div id="msgo"></div>
	<div id="msg"></div>
	<div id="msgc"></div>



</body>
</html>
