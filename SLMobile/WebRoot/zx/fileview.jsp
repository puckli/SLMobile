<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>viewfile</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.2" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.navaside{position:fixed;width:260px;height:100%;background-color:rgba(247,247,247,1);
margin:0;z-index: 300;transition:all 0.3s ease-in;box-shadow:1px 1px 1px 1px #ccc;}
.navOpen{top:0;left:0}
.navClose{top:0;left:-255px;}
.tab{position:fixed;width:380px;height:30px;background-color:rgba(94,134,196,1.0);margin:0;z-index:20;
z-index: 260;cursor:point;transition:all 0.3s ease-in;}
.tabOpen{top:20px;left:-100px;transform:skewX(-30deg);}
.tabClose{top:20px;left:-340px;transform:skewX(30deg);}

.nav-wrap{z-index:800;position:relative; top:40px;max-height:80%;overflow-y:auto;overflow-x:hidden;}
.nav-sub-item{text-align:right;}
.nav-item-wrap{margin:0;padding:0 0 0 10px;border-radius:5px;cursor:pointer;box-shadow:1px 0px 1px 2px #ddd;}
.nav-item-data{width:99%;margin:0 auto 5px;padding-left:3px;text-align:left;height:1.6em;line-height:1.6em;font-size:1.4em;
background-color:rgba(57,107,184,0.8);border-radius:5px 5px 0 0;overflow:hidden; user-select: none;}
</style>
<link rel="stylesheet" type="text/css" href="style/button.css">
<link rel="stylesheet" type="text/css" href="style/common.css">
<link rel="stylesheet" type="text/css" href="zx/style/fileoverview.css">
</head>
<body>
	<header>
		<input type="hidden" id="uid" value="<%=request.getAttribute("uid")%>">
		<input type="hidden" id="companyIds" value="<%=request.getAttribute("cids")%>">
		<input type="hidden" id="typeIds" value="<%=request.getAttribute("tids")%>">
		<input type="hidden" id="childTypeIds" value="<%=request.getAttribute("ctids")%>">
		
		<a class="button button-rounded" href="/slmobile/ios/mainPage?username=<%=request.getAttribute("uid") %>">
		返回</a>
		<a class="button button-rounded" href="javascript:void(0)" onclick="displayCompany()">公司</a>
		<span id="typeCount"></span> &nbsp; <span id="companyCount"></span>
		<a class="button button-rounded" href="javascript:void(0)" onclick="pagePre()">上一页</a> 
		<span id="pageShow">第${requestScope.pageNow }/${requestScope.pageCount}页 </span>
		<a class="button button-rounded" href="javascript:void(0)" onclick="pageNext()">下一页</a>
	</header>
	
	<aside id="navaside" class="navaside navOpen">
		<div class="nav-wrap">
		<s:iterator value="#request.data.list2">
			<div class="nav-item-wrap">
				<div class="nav-item-data" onclick="clicktoptype(this)" title="<s:property value="id"/>">
					<span><s:property value="name"/></span>
					<span>(<s:property value="#request.data.map.get(top.id)"/>)</span>
				</div>
				<div id="menu<s:property value="id"/>" class="nav-sub-item" title="none"></div>
			</div>
		</s:iterator>
		</div>
	</aside>
	<label id="navtab" class="tab tabOpen" onclick="swapnav(this)" title="open"></label>
	
	<section id="dataSection">
		<% int row = 1; %>
		<s:iterator value="#request.flist">
		<div class="file-item">
			<div class="file-data-wrap">
				<div><%=row++ %>.文件名：<s:property value="name"/></div>
				<div>文件编号：<s:property value="filesNumber"/></div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;状态：<s:if test="hasObject==1">电子版</s:if>
					<s:elseif test="ostate==0">在库</s:elseif>
					<s:elseif test="ostate==1">借出</s:elseif>
					<s:elseif test="ostate==2">丢失</s:elseif>
					<s:elseif test="ostate==3">补办中</s:elseif>
					<s:elseif test="ostate==4">申请中</s:elseif>
				</div>
				<div>&nbsp;&nbsp;监管人：<s:property value="ouser.name"/></div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;位置：<s:property value="oaddress"/></div>
				<div>注册日期：<s:property value="filesRegisterDate"/></div>
				<div>有效期至：<s:property value="filesExpireDate"/></div>
				<div>年检日期：<s:property value="filesAnnualSurveyDate"/></div>
			</div>			
			<div class="file-img-wrap">
			<button onclick="viewImg(this)" name="<s:property value="name"/>.<s:property value="type"/>" title="<s:property value="createTime"/>">点击查看图片</button>
			</div>
		</div>
		</s:iterator>
	</section>
	
	<aside>
		<div id="wrapCompany" class="window">
			<button onclick="selectAllC()">全选</button>&nbsp;
			<button onclick="reverseSelectC()">反选</button>&nbsp;
			<button onclick="cancelSelectC()">清空</button>&nbsp;&nbsp;
			<button onclick="submitCompany()">确定</button><br>
			<s:iterator value="#request.clist">
				<label><input type="checkbox" name="companys" value='<s:property value="id"/>'>
				<s:property value="name"/></label>
			</s:iterator>
		</div>
	</aside>
	
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
var tid = "";
var page = 1;
// 点击类型菜单,查询子节点和数据
function clicktoptype(e,pages)
{
	if(e){tid= e.title;}
	if(!pages){pages=1;}
	document.getElementById("typeIds").value=tid; 
	var cids = document.getElementById("companyIds").value;
	var uid = document.getElementById("uid").value;
	$.ajax({
		type:'post',
		url:'zx/getSubTypeTreeOrData',
		data:{id:tid,cids:cids,page:pages,uid:uid},
		success:function(data)
		{
			if(data.fileCount != 0) // 该节点下有文件
			{
				fillData(data, pages); // 填充文件数据
			}
			else{
				var sec = document.getElementById("dataSection");
				sec.innerHTML="";  // 清空文件数据
			}
			if(data.count != 0) // 该节点有子级节点（文件类型）
			{
				var docid = "menu" + tid;
				var div = document.getElementById(docid);
				if(div.title == "none")  // 该节点未初始化（还没查询过是否有子级节点，即没有点击过该节点）
				{
					div.setAttribute("title", "open");
					for(var item in data.rows)
					{
						var div2 = document.createElement("div");
						var div3 = document.createElement("div");
						var div4 = document.createElement("div");
						var span = document.createElement("span");
						var typename = data.rows[item]['name'];
						var count = data[typename];
						span.innerHTML = typename + "(" + count + ")";
						div2.className='nav-item-wrap';
						div3.className='nav-item-data';
						div3.setAttribute('onclick','clicktoptype(this)');
						div3.title=data.rows[item]['id'];
						div4.id="menu" + data.rows[item]['id'];
						div4.className='nav-sub-item';
						div4.title="none";
						div2.appendChild(div3);
						div2.appendChild(div4);
						div3.appendChild(span);
						div.appendChild(div2);
					}
				}
				else if(div.title == "open" && e != null)
				{
					$("#"+docid).slideUp();
					div.title="close";
				}	
				else if(div.title == "close" && e != null)
				{
					$("#"+docid).slideDown();
					div.title="open";
				}
			}
		}
	});
}
// 开关菜单
function swapnav(e)
{
	var aside = document.getElementById("navaside");
	var tab = document.getElementById("navtab");
	var a = aside.className;
	var t = tab.className;
	if(e.title == "open")
	{
		tab.title="close";
		aside.className = a.replace('navOpen', 'navClose');
		tab.className = t.replace('tabOpen', 'tabClose');
	}
	else
	{
		tab.title="open";
		aside.className = a.replace('navClose', 'navOpen');
		tab.className = t.replace('tabClose', 'tabOpen');
	}
}
function viewImg(e)
{
	var name = e.name;
	var date = e.title;
	var div = e.parentNode;
	var img = document.createElement("img");
	img.src = "zx/getFileImage?name="+name+"&date="+date;
	img.alt = "图片不存在或加载失败";
	div.innerHTML="";
	div.appendChild(img);
}

function showFileDetail(id)
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
}
function pagePre()
{
	page = page > 1 ? page-1 : 1;
	clicktoptype(null, page);
}
function pageNext()
{
	clicktoptype(null, page + 1);
}
function displayCompany()
{
	document.getElementById("wrapCompany").style.display="block";
}
function submitCompany()
{
	var companys = $("#wrapCompany input:checked");
	if(companys.length>0)
	{
		var ids="(";
		for(var i = 0; i < companys.length; i++)
		{
			ids += companys[i].value + ",";
		}
		ids = ids.substring(0,ids.length-1) + ")";
		document.getElementById("companyIds").value=ids;
	}
	else
	{
		document.getElementById("companyIds").value="";
	}
	document.getElementById("wrapCompany").style.display="none";
}
function selectAllC()
{
	var companys = document.getElementsByName("companys");
	for(var i = 0; i < companys.length; i++)
	{
		companys[i].checked=true;
	}
}
function reverseSelectC()
{
	var companys = document.getElementsByName("companys");
	for(var i = 0; i < companys.length; i++)
	{
		if(companys[i].checked)
		{
			companys[i].checked=false;
		}
		else
		{
			companys[i].checked=true;
		}
	}
}
function cancelSelectC()
{
	var companys = document.getElementsByName("companys");
	for(var i = 0; i < companys.length; i++)
	{
		companys[i].checked=false;
	}
}
$(function(){
	
});

function fillData(data,arg)
{
	var div01,div02,div03,div1,div2,div3,div4,div5,div6,div7,div8,div9;
	var btn;
	var sec = document.getElementById("dataSection");
	sec.innerHTML="";
	if(data.fileRows.length > 0)
	{
		page = arg;
		document.getElementById("pageShow").innerHTML="第"+page + "/" + data.pageCount + "页";
	}
	for(var i in data.fileRows)
	{
		var dt = data.fileRows[i];
		div01 = document.createElement("div");
		div02 = document.createElement("div");
		div03 = document.createElement("div");
		div1 = document.createElement("div");
		div2 = document.createElement("div");
		div3 = document.createElement("div");
		div4 = document.createElement("div");
		div5 = document.createElement("div");
		div6 = document.createElement("div");
		div7 = document.createElement("div");
		div8 = document.createElement("div");
		div9 = document.createElement("div");
		btn = document.createElement("button");
		div01.className="file-item";
		div02.className="file-data-wrap";
		div03.className="file-img-wrap";
		div1.innerHTML =　i + ".文件名：" + dt['name'];
		div02.appendChild(div1);
		div2.innerHTML =　"文件编号："+dt['filesNumber'];
		div02.appendChild(div2);
		var hasObject = dt['hasObject'];
		var ostate = dt['ostate'];
		if(hasObject == 1)
		{
			div3.innerHTML =　"状态：电子版";
		}
		else if(ostate == 0)
		{
			div3.innerHTML =　"状态：在库";
		}
		else if(ostate == 1)
		{
			div3.innerHTML =　"状态：借出";
		}
		else if(ostate == 2)
		{
			div3.innerHTML =　"状态：丢失";
		}
		else if(ostate == 3)
		{
			div3.innerHTML =　"状态：补办中";
		}
		else if(ostate == 4)
		{
			div3.innerHTML =　"状态：申请中";
		}
		div02.appendChild(div3);
		div4.innerHTML =　"监管人：" + dt['ouser']['name'];
		div02.appendChild(div4);
		var add = dt['oaddress'];
		if(add)
			div8.innerHTML = "位置：" + add;
		else
			div8.innerHTML = "位置：";
		div02.appendChild(div8);
		var reg = dt['filesRegisterDate'];
		if(reg)
			div5.innerHTML =　"注册日期：" + reg;
		else
			div5.innerHTML =　"注册日期：";
		div02.appendChild(div5);
		var exp = dt['filesExpireDate'];
		if(exp)
			div6.innerHTML =　"有效期至：" + exp;
		else
			div6.innerHTML =　"有效期至：";
		div02.appendChild(div6);
		var ann = dt['filesAnnualSurveyDate'];
		if(ann)
			div7.innerHTML =　"年检日期：" + ann;
		else
			div7.innerHTML =　"年检日期：";
		div02.appendChild(div7);
		btn.setAttribute("onclick","viewImg(this)");
		btn.title=dt['createTime'];
		btn.name=dt['name'] + "." + dt['type'];
		btn.innerHTML="点击查看图片";
		div03.appendChild(btn);
		div01.appendChild(div02);
		div01.appendChild(div03);
		sec.appendChild(div01);
	}
}
</script>
</body>
</html>
