<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>创建群</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />
<style type="text/css">
#newusers{background-color:#ddd;}
.userSpan{border-radious:3px; padding:3px 5px;background-color:#fff;margin:1px 2px;}
#noadduser{background-color:#eee;}
.noAddUserDiv{margin:2px 0px;background-color:rgba(215,136,149,0.2);}
.wrap{width:100%;margin:0px 0px 5px;}
</style>

</head>

<body>
	<div class="wrap">
		<p>填写群信息</p>
		<label>群名称：</label><br>
		<input type="text" name="name" id="name" placeholder="群名称"><br>
		<label>群密码：(其他人申请入群时，可通过输入密码直接加入该群)</label><br>
		<input type="text" name="pwd" id="pwd" placeholder="不超过8位">
		<button class="button" onclick="createGroup()">创建</button>
	</div>
	
	<div class="wrap">
		<span>已添加的成员：</span>
		<div id="newusers"></div>
	</div>
	
	<div class="wrap">
		<input type="text" name="txt" id="txt" placeholder="用户名或用户id">
	    <button onclick="search()">搜索</button>
		<div id="noadduser"></div>
	</div>
	<script type="text/javascript" src="/slmobile/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		function createGroup()
		{
			var name = document.getElementById("name").value;
			var pwd = document.getElementById("pwd").value;
			if(name){alert(name);}
			var spans = document.getElementById("newusers").childNodes;
			var ids = "";
			if(spans.length==0){alert("必须为群添加新成员！");return;};
			
			
		}
		function search()
		{
			document.getElementById("noadduser").innerHTML="";
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
						var section = document.getElementById("noadduser");
						for(i in data)
						{
							var div = document.createElement("div");
							div.className="noAddUserDiv"
							var img = document.createElement("img");
							var span1 = document.createElement("span");
							var span2 = document.createElement("span");
							span1.innerHTML=data[i].uname;
							span2.innerHTML="＋";
							span2.id=data[i].uid;
							span2.name=data[i].uname;
							span2.onclick=addUser;
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
		function addUser()
		{
			var id = this.id;
			var name = this.name;
			var span = document.createElement("span");
			span.id = id;
			span.innerHTML=name;
			span.className="userSpan";
			document.getElementById("newusers").appendChild(span);
			document.getElementById("noadduser").removeChild(this.parentNode);
		}
		
	</script>
</body>
</html>
