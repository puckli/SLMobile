<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Mobile Examine</title>
    
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
	section>div{
		width:280px;
		height:320px;
		margin:20px auto;
		text-align:center;
		background-color:#def;
		background-image:-webkit-linear-gradient(top,#eee,#bbb);
		background-image:linear-gradient(top,#eee,#bbb);
		border-radius:15px;
	}
	section form{
		width:170px;
		margin:20px auto;
		text-align:left;
	}
</style>
  </head>
  
  <body>
  		<section>
  			<div>
  			<br>
  			<form action="/slmobile/ios/mainPage" method="post">
			     用户名：<input type="text" name="username"><br>
			     密码：<input type="password" name="password">
			   <input type="submit" value="登录">
	   		</form>
	   		</div>
  		</section>
  </body>
</html>
