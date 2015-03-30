<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新增联系人页</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<style type="text/css">
body{font-size:10px;width:100%}
body,header,section,div,ul,li,span{margin:0px;padding:0px;border:0px;}
header{width:100%;height:10%;background-color:rgba(202,217,231,0.9);}
section{width:100%;height:90%;background-color:rgba(222,227,229,.3);overflow-y:scroll;}
#section{font-size:1.6em;}
</style>
  </head>
  
  <body>
    <header>
    	<span onclick="window.location.href='chat/toMain?uid=${requestScope.uid}'">返回</span>
    	<input type="text" name="txt" id="txt" placeholder="用户名或用户id">
    	<button onclick="search()">搜索</button>
    </header>
	<section id="section">
		
	</section>

	<script type="text/javascript" src="/slmobile/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		function search()
		{
			document.getElementById("section").innerHTML="";
			var txt = document.getElementById("txt").value;
			if(!txt || txt.trim() == ""){
				document.getElementById("txt").value=null;
				return;
			}
			$.ajax({
				type:'post',
				url:'chat/u_searchUser',
				data:{txt:txt},
				success:function(data){
					if(data)
					{
						var section = document.getElementById("section");
						for(i in data)
						{
							var div = document.createElement("div");
							var img = document.createElement("img");
							var span1 = document.createElement("span");
							var span2 = document.createElement("span");
							span1.innerHTML=data[i].uname;
							span2.innerHTML="＋";
							span2.id=data[i].uid;
							span2.onclick=addFriend;
							div.appendChild(span1);
							div.appendChild(span2);
							section.appendChild(div);
						}
					}
				},
				error:function(xhr,type,exception){
					alert("错误：" + exception);
				}
			})
		}
		
		function addFriend()
		{
			var uid = '${requestScope.uid}';
			var fuid = this.id;
			$.ajax({
				type:'post',
				url:'chat/u_addFriend',
				data:{uid:uid,fuid:fuid},
				success:function(data){
					if(data == "success")
					{
						document.getElementById(fuid).innerHTML="已添加";
					}
					else{
						document.getElementById(fuid).innerHTML="添加失败";
					}
				},
				error:function(xhr,type,exception){
					document.getElementById(fuid).innerHTML="添加失败！";
				}
			})
		}
	</script>
</body>
</html>
