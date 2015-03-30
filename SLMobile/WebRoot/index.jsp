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

<style type="text/css">
body {
	font-size: 10px;
	background-color: rgba(233, 233, 233, .8);
	background-position: 0px 5px, 10px 0px, 0px 10px, 10px 5px, 0% 0%, 0% 0%;

	/* 天蓝 */
	/* background-image: linear-gradient(27deg, rgb(124,203,255) 5px,transparent 5px ), 
		linear-gradient(207deg, rgb(129,206,255) 5px,transparent 5px ),
		linear-gradient(27deg, rgb(131,206,255) 5px,transparent 5px ), 
		linear-gradient(207deg, rgb(137,209,255) 5px,transparent 5px ), 
		linear-gradient(90deg, rgb(144,209,252) 10px,transparent 10px ), 
		linear-gradient(rgb(144,209,252) 25%, rgb(137,209,255) 25%, rgb(131,206,255) 50%, transparent 50%, transparent
		75%, rgb(129,206,255) 75%, rgb(124,203,255) ); */
	/* 灰白 */
	/* background-image: linear-gradient(27deg, rgb(234,234,234) 5px,transparent 5px ), 
		linear-gradient(207deg, rgb(224,224,224) 5px,transparent 5px ),
		linear-gradient(27deg, rgb(214,214,214) 5px,transparent 5px ), 
		linear-gradient(207deg, rgb(204,204,204) 5px,transparent 5px ), 
		linear-gradient(90deg, rgb(194,194,194) 10px,transparent 10px ), 
		linear-gradient(rgb(194,194,194) 25%, rgb(204,204,204) 25%, rgb(214,214,214) 50%, transparent 50%, transparent
		75%, rgb(214,214,214) 75%, rgb(234,234,234) );  */
	
	/* 经典黑 background-color: rgb(19, 19, 19); */
	/* background-image: linear-gradient(27deg, rgb(21, 21, 21) 5px,
		transparent 5px ), linear-gradient(207deg, rgb(21, 21, 21) 5px,
		transparent 5px ), linear-gradient(27deg, rgb(34, 34, 34) 5px,
		transparent 5px ), linear-gradient(207deg, rgb(34, 34, 34) 5px,
		transparent 5px ), linear-gradient(90deg, rgb(27, 27, 27) 10px,
		transparent 10px ), linear-gradient(rgb(29, 29, 29) 25%,
		rgb(26, 26, 26) 25%, rgb(26, 26, 26) 50%, transparent 50%, transparent
		75%, rgb(36, 36, 36) 75%, rgb(36, 36, 36) ); */


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
		<img alt="SL" src="/slmobile/resource/SL.png">
		<p>欢迎使用塑力集团移动电子商务系统</p>
		<div>
			<span>您好&nbsp;${requestScope.uname}</span>
			<marquee behavior="scroll" scrollamount="3">${requestScope.date }</marquee>
		</div>
	</header>
	<section>
		<a href="/slmobile/ios/getUnExamineSldList?uid=<%=session.getAttribute("uid")%>">
		 <span class="wait img">&nbsp;</span> 当前有${requestScope.unExamineu}条未审批单据 </a>
		 
		<a href="/slmobile/ios/getUnExamineSldList?uid=<%=session.getAttribute("uid")%>">
		 <span class="wait img">&nbsp;</span> 当前有${requestScope.unExaminer}条暂不处理单据 </a>
		 
		<a href="/slmobile/ios/getAgreeSldList?uid=<%=session.getAttribute("uid")%>">
		<span class="ok img">&nbsp;</span> 有${requestScope.agree }条审批通过的单据 </a>
		
		<a href="/slmobile/ios/getDisagreeSldList?uid=<%=session.getAttribute("uid")%>">
		<span class="refuse img">&nbsp;</span> 共有${requestScope.disagree }条拒绝的单据</a>
		
	</section>


</body>
</html>
