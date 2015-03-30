<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<link rel="stylesheet" type="text/css" href="style/button.css">
<style type="text/css">
body {
	font-size: 10px;
	background-color: rgba(233, 233, 233, .8);
	background-position: 0px 5px, 10px 0px, 0px 10px, 10px 5px, 0% 0%, 0% 0%;
	background-color:#fff;
	background-size: 8px 8px;
}

section {
	margin: auto;
	padding: 0px;
	width: 85%;
}
.wait{
	background:url('resource/reset.gif') no-repeat 4px center;
}
.ok{
	background:url('resource/ok.gif') no-repeat 4px center;
}
.refuse{
	background:url('resource/delete.gif') no-repeat 4px center;
}

section a {
	width: 90%;
	color: #000;
	text-decoration: none;
	display: block;
	margin: 10px auto 25px;
	padding: .5em;
	height: 1em;
	font-size: 3em;
	background-color: #eee;
	background-image: -webkit-linear-gradient(bottom, #abc, #fff, #bbb);
	background-image: -moz-linear-gradient(bottom, #abc, #fff, #bbb);
	background-image: -o-linear-gradient(bottom, #abc, #fff, #bbb);
	background-image: -ms-linear-gradient(bottom, #abc, #fff, #bbb);
	background-image: linear-gradient(bottom, #abc, #fff, #bbb);
	border-radius: 2em;
	cursor: pointer;
	text-align: center;
	word-wrap: break-word;
	box-shadow: 0px 0px 4px 3px #ffffff;
	text-shadow: 0px 1px 0px rgba(0, 0, 0, 0.6);
}
header{
	margin-top:0px;
	padding-top:0px;
}
.img{
	display:inline-block;
	width:25px;
	float:left;
}
header>p {
	display:inline-block;
	width: 78%;
	margin: 3px auto 20px;
	padding-top:0px;
	color: rgba(12, 16, 21, .8);
	text-align: center;
	text-shadow: 0px 1.5px 0px rgba(0, 0, 0, .3);
	font-weight: bold;
}

header>div {
	width: 75%;
	margin: 0px auto 5px;
	color: rgba(12, 16, 21, .8);
	font-size: 1.4em;
}

header>div>span {
	display: inline-block;
	width: 35%;
	color: rgba(12, 16, 21, .8);
	font-size: 1.0em;
}

header>div>marquee {
	display: inline-block;
	width: 60%;
	float: right;
}

@media screen and (max-width: 2220px) {
	body {
		min-width: 768px;
	}
	section a {
		font-size: 3 em;
	}
	header img{
		width:80px;
	}
	header>p {
		width: 78%;
		float:right;
		font-size: 2.6em;
	}
}

@media screen and (max-width: 568px) {
	body {
		min-width: 480px;
	}
	section a {
		font-size: 2.5em;
	}
	header img{
		width:100px;
	}
	header>p {
		width: 78%;
		float:right;
		font-size: 2.2em;
	}
}

@media screen and (max-width: 320px) {
	body {
		min-width: 320px;
	}
	section a {
		font-size: 2em;
	}
	header img{
		width:80px;
	}
	header>p {
		margin:5px 9% 10px;
		width:80%;
		float:none;	
		font-size: 1.6em;
	}
}

</style>
</head>

<body>
	<header>
		<img onclick="backindex()" alt="SL" src="/slmobile/resource/SL.png">
		<a class="button button-rounded" href="/slmobile/ios/mainPage?username=<%=request.getParameter("uid") %>">
		<img class="btnimg" alt="" src="../slmobile/resource/back32.png">返回</a>
		<p onclick="backindex()">欢迎使用塑力集团移动电子商务系统</p>
		<div>
			<span>您好&nbsp;${requestScope.uname}</span>
			<marquee behavior="scroll" scrollamount="3">${requestScope.date }</marquee>
		</div>
	</header>
	<section>
		<a href="/slmobile/ios/getUnExamineSldList?uid=<%=session.getAttribute("uid")%>">
		 <span class="wait img">&nbsp;</span> 当前有${requestScope.unExamine}条未审批单据 </a>
		 
		<a href="/slmobile/ios/getAgreeSldList?uid=<%=session.getAttribute("uid")%>">
		<span class="ok img">&nbsp;</span> 有${requestScope.agree }条审批通过的单据 </a>
		
		<a href="/slmobile/ios/getDisagreeSldList?uid=<%=session.getAttribute("uid")%>">
		<span class="refuse img">&nbsp;</span> 共有${requestScope.disagree }条拒绝的单据</a>
		
	</section>

<script type="text/javascript">
function backindex()
{
	window.location.href='<%=basePath%>ios/mainPage?username=<%=session.getAttribute("uid")%>';
}
</script>
</body>
</html>
