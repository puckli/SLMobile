<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'errors.jsp' starting page</title>
    
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <p>未知错误，请尝试完全退出程序，重新进入.或者转到登录!</p>
    <%-- <a href="/slmobile/ios/mainPage?username=<%=session.getAttribute("uid")%>">返回主页>></a> --%>
    <a href="/slmobile/login.jsp">转到登录>></a>
  </body>
</html>
