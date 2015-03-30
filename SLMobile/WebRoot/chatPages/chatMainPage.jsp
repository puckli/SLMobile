<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>聊天主页</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<link type="text/css" href="chatPages/css/chatmainpage.css">
<style type="text/css">
body{font-size:10px;width:100%}
body,header,section,div,ul,li,span{margin:0px;padding:0px;border:0px;}
header{width:100%;height:10%;background-color:rgba(202,217,231,0.9); }
.menu{display:inline-block;width:50%;text-align:center;line-height:40px;font-size:2em;float:left;position:relative;}
.menuon{
	background-color: #ddd;
	background-image: -webkit-linear-gradient(bottom, #98C4F0, #6AADED, #6AADED, #98C4F0);
	background-image: -moz-linear-gradient(bottom, #98C4F0, #6AADED, #6AADED, #98C4F0);
	background-image: -o-linear-gradient(bottom, #98C4F0, #6AADED, #6AADED, #98C4F0);
	background-image: -ms-linear-gradient(bottom, #98C4F0, #6AADED, #6AADED, #98C4F0);
	background-image: linear-gradient(bottom, #98C4F0, #6AADED, #6AADEDs, #98C4F0);
}
.menuoff{
	background-color: #eee;
	background-image: -webkit-linear-gradient(bottom, #6AADED, #98C4F0, #98C4F0, #6AADED);
	background-image: -moz-linear-gradient(bottom, #6AADED, #98C4F0, #98C4F0, #6AADED);
	background-image: -o-linear-gradient(bottom, #6AADED, #98C4F0, #98C4F0, #6AADED);
	background-image: -ms-linear-gradient(bottom, #6AADED, #98C4F0, #98C4F0, #6AADED);
	background-image: linear-gradient(bottom, #6AADED, #98C4F0, #98C4F0, #6AADED);
}
section{display:block;width:100%;overflow:hidden;height:90%;}
.info_section{width:200%;height:100%;-webkit-transform:translateX(0%);-webkit-transition:all 0.3s easy-in;
-moz-transition:all 0.3s ease-in;-ms-transition:all 0.3s ease-in;transition:all 0.3s ease-in;}
.content{height:90%;display:inline-block;width:50%;text-align:center;font-size:1.6em;float:left;}
.content1{background-color:rgba(250,240,224,0.8);}
.content2{background-color:rgba(242,245,198,0.8);}
.head_photo{width:18px;}
li{line-height:34px;cursor:pointer;}
.addfriend{font-size:1em; font-weight:bold;background-color:rgba(201,213,225,0.9);cursor:pointer;position:absolute;
right:10px;width:25px;height:25px;top:0;bottom:0;margin:auto;line-height:1.2em;}
</style>
</head>

<body>
	<header>
		<div id="menu1" class="menuon menu" onclick="menu1Click()">
			<span>联系人 </span><span class="addfriend" onclick="addFriend()">＋</span>
		</div>
		<div id="menu2" class="menuoff menu" onclick="getUnReadMsg()">
			<span>未读消息</span>
		</div>
	</header>
	
	<section>
		<div id="infos" class="info_section">
			<div class="content1 content">
				<ul id="topul" class="tree-top-ul menuul">
					<li class="topli-item">群聊天</li>
						<ul>
							<s:if test="#session.groups != null">
								<s:iterator value="#session.groups" id="list">
									<li onclick="goGroupChat('<s:property value="id"/>')">
										<img class="head_photo" alt="h" src="img/userHead/groupDefault.png">
										<s:property value="name"/> </li>
								</s:iterator>
							</s:if>
							<li onclick="createGroup()">创建群</li>
						</ul>
					<li class="topli-item">默认组</li>
					<s:if test="#session.friends != null">
						<ul id="" class="">
							<s:iterator value="#session.friends" id="map">
								<s:set name="total" value="#map.value.size"/> 
								<s:iterator value="#map.value">
									<li onclick="goChat('<s:property value="uid"/>')">
										<img class="head_photo" alt="h" src="img/userHead/<s:property value="photo"/>">
										<s:property value="uname"/> </li>
								</s:iterator>
							</s:iterator>
						</ul>
					</s:if>
				</ul>
				
				
				<%-- 
				<s:if test="#session.friends != null">
				<ul id="topul" class="tree-top-ul menuul">
					<s:iterator value="#session.friends" id="map">
						<s:set name="total" value="#map.value.size"/> 
						<s:iterator value="#map.value">
							<li onclick="goChat('<s:property value="uid"/>')">
								<img class="head_photo" alt="h" src="img/userHead/<s:property value="photo"/>">
								<s:property value="uname"/> </li>
						</s:iterator>
					</s:iterator>
				</ul>
				</s:if>
				<s:else>
					您还没有添加联系人<br>
				</s:else>
				 --%>
				<%-- <c:choose>  
				<c:when test="${!empty sessionScope.friends}">
					<ul id="topul" class="tree-top-ul menuul">
						<c:forEach items="${sessionScope.friends}" var="item">
							<c:forEach items='item.value' var="list">
								<li onclick="goChat('${list.uid}')">
								<img alt="h" src="/img/userHead/${list.photo}">
								${list.uname} </li>
							</c:forEach>
						</c:forEach>
					</ul>
				</c:when>
				<c:otherwise>
					您还没有添加联系人<br>
					<button  onclick="addFriend()">点此添加</button>
				</c:otherwise>
				</c:choose> --%>
			</div>
			
			<div class="content2 content">
			...
			</div>
		</div>
	</section>
	
	<footer>
		<input type="hidden" id="current" value="${requestScope.uid}">
	</footer>

<script type="text/javascript" src="/slmobile/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
function goGroupChat(id)
{
}
function createGroup()
{
	var current = document.getElementById("current").value;
	location.href="/slmobile/chat/createGroupPage?uid="+current;
}
function menu1Click()
{
	$("#menu2").removeClass("menuon");
	$("#menu2").addClass("menuoff");
	$("#menu1").removeClass("menuoff");
	$("#menu1").addClass("menuon");
	setTransform("0%");
}
function getUnReadMsg()
{
	$("#menu1").removeClass("menuon");
	$("#menu1").addClass("menuoff");
	$("#menu2").removeClass("menuoff");
	$("#menu2").addClass("menuon");
	setTransform("50%");
	
	$.ajax({
		type:'post',
		url:'chat/getSendNewMsgFriends',
		data:{},
		success:function(data){
			
		},
		error:function(xhr,type,exception){
			
		}
	})
}
function goChat(touid)
{
	var current = document.getElementById("current").value;
	location.href="/slmobile/chat/chat1v1?uid="+current+"&touid="+touid;
}
function addFriend()
{
	var uid = document.getElementById("current").value;
	location.href="chat/u_addFriendPage?uid="+uid;
}
function setTransform(arg)
{
	var translate = "translateX(-" + arg + ")"; 
	document.getElementById("infos").style.webkitTransform=translate;
	document.getElementById("infos").style.MozTransform=translate;
	document.getElementById("infos").style.msTransform=translate;
	document.getElementById("infos").style.transform=translate;
}
</script>
</body>
</html>




