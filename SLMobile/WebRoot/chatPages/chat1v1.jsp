<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<title>与${requestScope.touname}聊天</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<style type="text/css">
body{font-size:10px;width:100%}
body,header,section,div,ul,li,span{margin:0px;padding:0px;border:0px;}
header{width:100%;height:10%;background-color:rgba(202,217,231,0.9);}
.back{width:3em;text-align:center;background-color:white;display:inline-block;font-size:2em;
line-height:40px;cursor:pointer;border-radius:5px;}
.title{text-align:center;background-color:white;display:inline-block;font-size:2em;
line-height:40px;cursor:pointer;border-radius:5px;margin:auto;padding:0px 8px;}
footer{display:block;width:100%;height:10%;position:absolute;bottom:0px;background-color:rgba(173,26,26,0.3);}
input{width:80%;height:90%;border-radius:5px;}
footer span{width:15%;text-align:center;background-color:white;display:inline-block;font-size:2em;
line-height:40px;left:0;right:0;margin:0px auto;cursor:pointer;border-radius:5px;}
section{height:80%;background-color:rgba(222,227,229,.3);overflow-y:scroll;overflow-x:hidden;}
.msg_div{width:100%;display:block;clear:both;}
.pop{display:inline-block;background-color:rgba(200,199,166,0.9);font-size:1.4em;line-height:2em;
padding:2px 10px;border-radius:5px;position:relative;margin:2px 15px;}
.left_pop{float:left;}
.right_pop{float:right;}
.left_pop:before{
	position:absolute;
	content:"\00a0";
	width:0px;
	height:0px;
	border-width:8px 18px 8px 0;
	border-style:solid;
	border-color:transparent #A6DADC transparent transparent;
	top:15px;
	left:-18px;
}
.right_pop:after{
	position:absolute;
	content:"\00a0";
	display:inline-block;
	width:0px;
	height:0px;
	border-width:8px 0px 8px 18px;
	border-style:solid;
	border-color:transparent transparent transparent #A6DADC;
	right:-15px;
	top:15px;
					
}
</style>

</head>

<body>
	<header>
		<span class="back" onclick="window.history.back(-1);">返回</span>
		<span class="title">${requestScope.touname}</span>
	</header>
	
	<section id="section">
		<div class="msg_div">
			<span class="right_pop pop">sdfew</span>
		</div>
		<div class="msg_div">
			<span class="left_pop pop">阿飞</span>
		</div>
	</section>
	
	<footer>
		<input type="text" name="msg" id="msg" placeholder="输入消息"><span onclick="sendMsg()">发送</span>
	</footer>
	
	
	
	
<script type="text/javascript" src="/slmobile/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
window.onload=getNewMsg;
var uid = '${requestScope.uid}';
var touid = '${requestScope.touid}';
function getNewMsg()
{
	$.ajax({
		type:'get',
		url:'chat/getNewMsg',
		data:{uid:uid,sendUser:touid},
		success:function(data){
			if(data)
			{
				for(i in data)
				{
					var div = document.createElement("div");
					div.className="msg_div";
					var span = document.createElement("apan");
					span.setAttribute("class","left_pop pop")
					span.innerHTML=data[i].txt;
					div.appendChild(span);
					document.getElementById("section").appendChild(div);
				}
				var date=new Date(data[0].time); 
				var str = convertDate(date);
			}
			
		},
		error:function(xhr,type,exception){
			alert("get newMsg error");
		}
	});
	setTimeout(getNewMsg,3*1000);
}
function sendMsg()
{
	var msg = document.getElementById("msg").value;
	if(msg == null || msg == "" || msg.trim() == ""){
		document.getElementById("msg").value="";
		return;
	}
	$.ajax({
		type:'post',
		url:'chat/sendMsg',
		data:{uid:uid,touid:touid,msg:msg},
		success:function(data){
			if(data == "success")
			{
				var div = document.createElement("div");
				div.className="msg_div";
				var span = document.createElement("apan");
				span.setAttribute("class","right_pop pop")
				span.innerHTML=msg;
				div.appendChild(span);
				document.getElementById("section").appendChild(div);
				document.getElementById("msg").value="";
			}
		},
		error:function(xhr,type,exception){
			alert("发送失败！");
		}
	});
}

function convertDate(date)
{
	var str1 = date.getFullYear()+"-"+(date.getMonth()+1) +"-"+ date.getDate();
	var str2 = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	return str1 + " " + str2;
}
</script>
	
	
	
	
	
	
	
	
	
</body>
</html>
