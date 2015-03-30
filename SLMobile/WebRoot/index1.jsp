<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>首页</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />  

<link rel="stylesheet" href="style/indexTab.css">
<style>
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
.links{
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

.stitle{text-align:center;font-weight:normal;font-size:2.2em;margin:5px auto 0px;
	text-shadow:0px 0px 2px #000;}


@media screen and (max-width: 2220px) {
	body {
		min-width: 768px;
	}
	.linka {
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
	.linka {
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
<div class="wrap">
    <div class="tabs">
        <a href="javascript:void(0)"  class="active stitle">业务审批体系</a>
        <a href="javascript:void(0)" class="stitle">管理经营体系</a>
        <a href="javascript:void(0)" class="stitle">网络营销体系</a>
    </div>    
    <div class="swiper-container">
        <div class="swiper-wrapper">
       		<div class="swiper-slide">
	           	<div class="content-slide">
	           	<a class="links linka" href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">
				<!-- <span class="wait img">&nbsp;</span> -->资金计划申请表</a>
				<a class="links linka" href="/slmobile/ios/goSLDIndex?uid=<%=session.getAttribute("uid")%>">
				<!-- <span class="ok img">&nbsp;</span>  -->资金支出审批表 (${requestScope.unExamineu}条未审单据)</a>
	         	</div>
          	</div>
        	<div class="swiper-slide">
	            <div class="content-slide">
	            <a class="links linka" href="/slmobile/ncreport/search.action?uid=<%=session.getAttribute("uid")%>">金融财务报表</a>
				<a class="links linka" href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">销售应收报表</a>
				<a class="links linka" href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">采购应付报表</a>
				<a class="links linka" href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">制造动能报表</a>
	            </div>
          	</div>
        	<div class="swiper-slide">
	            <div class="content-slide">
	            <a class="links linka" href="/slmobile/onBuilding.jsp?uid=<%=session.getAttribute("uid")%>">查看体系</a>
	            </div>
          	</div>
      </div>
   </div>
</div>
</section>


<script src="js/jquery-1.7.1.min.js"></script> 
<script src="js/indexTab.swiper.min.js"></script> 
<script>
var tabsSwiper = new Swiper('.swiper-container',{
	speed:500,
	onSlideChangeStart: function(){
		$(".tabs .active").removeClass('active');
		$(".tabs a").eq(tabsSwiper.activeIndex).addClass('active');
	}
});

$(".tabs a").on('touchstart mousedown',function(e){
	e.preventDefault()
	$(".tabs .active").removeClass('active');
	$(this).addClass('active');
	tabsSwiper.swipeTo($(this).index());
});

$(".tabs a").click(function(e){
	e.preventDefault();
});
</script>

</body>
</html>
