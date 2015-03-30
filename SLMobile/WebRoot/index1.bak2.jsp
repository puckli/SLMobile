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
	background-color:#fff;
	background-size: 8px 8px;
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


section {
	margin: auto;
	padding: 0px;
	width: 85%;
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

.img{
	display:inline-block;
	width:25px;
	float:left;
}

header{
	width: 100%;
	margin:0px auto;
	padding-top:0px;
}

.title {
	display:inline-block;
	margin: 0px auto 1px;
	padding-top:0px;
	color: rgba(12, 16, 21, .8);
	text-align: center;
	text-shadow: 0px 1.5px 2px rgba(0, 0, 0, .3);
	font-weight: bold;
}

.logo{display:inline-block;}
.nullfill{display:inline-block;margin:0;}

.user {
	display: inline-block;
	width: 35%;
	color: rgba(12, 16, 21, .8);
	font-size: 1.0em;
}

.marquee {
	display: inline-block;
	width: 60%;
	float: right;
}

.blockwrap{display:inline-block;background-color:rgba(234,207,82,0.1);border-radius:5px;box-shadow:0 0 2px 2px #eee;
	margin:2px auto 10px;padding:2px 0px;width:100%;min-width: 400px;}
	
.blockwrap>p{text-align:center;font-weight:normal;font-size:1.4em;padding:0 auto;margin:5px auto;
	text-shadow:0px 0px 1px #000;}

.tips{padding:2px 8px;}

.count{color:#F76B00;margin-right:2px;text-shadow:1px 1px 0px #aaa;}
.link-wrap{text-align:center;}
@media screen and (max-width: 2220px) {
	body {
		min-width: 768px;
	}
	section a {
		font-size: 2.2em;
	}
	.logo,.nullfill{
		width:160px;
	}
	.title {
		width: 70%;
		font-size: 2.6em;
	}
}

@media screen and (max-width: 568px) {
	body {
		min-width: 480px;
	}
	section a {
		font-size: 1.8em;
	}
	.logo,.nullfill{
		width:100px;
	}
	.title {
		width: 70%;
		font-size: 2.0em;
	}
}

</style>
</head>

<body>
	<header>
		<img class="logo" alt="SL" src="/slmobile/resource/SL.png">
		<p class="title">欢迎使用塑力集团移动电子商务系统</p>
		<p class="nullfill">&nbsp;</p>
	</header>
	<section>
		<div class="tips">
			<span class="user">您好&nbsp;${requestScope.uname}</span>
			<marquee class="marquee" behavior="scroll" scrollamount="3">${requestScope.date }</marquee>
		</div>
		<div class="blockwrap">
			<p>业务审批体系</p>
			<div class="link-wrap">
				<a href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">
				 <!-- <span class="wait img">&nbsp;</span> -->资金计划申请表</a>
				<a href="/slmobile/ios/goSLDIndex?uid=<%=session.getAttribute("uid")%>">
				<!-- <span class="ok img">&nbsp;</span>  -->资金支出审批表 </a>
			</div>
		</div>
		
		<div class="blockwrap">
			<p>管理经营体系</p>
			<div class="link-wrap">
				<a href="/slmobile/ncreport/search.action?uid=<%=session.getAttribute("uid")%>">金融财务报表</a>
				<a href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">销售应收报表</a>
				<a href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">采购应付报表</a>
				<a href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">制造动能报表</a>
			</div>
		</div>
		
		<div class="blockwrap">
			<p>网络营销体系</p>
			<div class="link-wrap">
				<a href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">查看体系</a>
			</div>
		</div>
	</section>

</body>
</html>
