<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>onBuilding.jsp</title>
<meta name="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
section{display:inline-block;margin:50px auto;font-size:2em;}
</style>
</head>
<body>
  <section>
	系统正在建设中...<br>
	<br>
	<a href="<%=basePath%>ios/mainPage?username=<%=request.getParameter("uid")%>">返回</a>
  </section>
    
</body>
</html>
