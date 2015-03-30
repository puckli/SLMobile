<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'page.jsp' starting page</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
    <input type="submit" value="Start" onclick="start()" />
  </div>
  <div id="messages"></div>
  <script type="text/javascript">
    var webSocket = 
      new WebSocket('ws://localhost:8080/slmobile/websocket');

    webSocket.onerror = function(event) {
      onError(event)
    };

    webSocket.onopen = function(event) {
      onOpen(event)
    };

    webSocket.onmessage = function(event) {
      onMessage(event)
    };

    function onMessage(event) {
      document.getElementById('messages').innerHTML 
        += '<br />' + event.data;
    }

    function onOpen(event) {
      document.getElementById('messages').innerHTML 
        = 'Connection established';
    }

    function onError(event) {
      alert(event.data);
    }

    function start() {
      webSocket.send('hello');
      return false;
    }
  </script>
  </body>
</html>
