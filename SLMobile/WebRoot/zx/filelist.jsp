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

</style>
<link rel="stylesheet" type="text/css" href="style/button.css">
<link rel="stylesheet" type="text/css" href="style/common.css">
<link rel="stylesheet" type="text/css" href="zx/style/filelist.css">
<link rel="stylesheet" type="text/css" href="js/zTree/css/zTreeStyle/zTreeStyle.css">
</head>
<body>
	<%
		String spage = request.getAttribute("pageNow").toString();
		int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		int pagePre = (spage != null &&  spage.length()>0) ? Integer.parseInt(spage)-1 : 1;
		int pageNext = (spage != null &&  spage.length()>0) ? Integer.parseInt(spage)+1 : 2;
		pageNext = pageNext > pageCount ? pageCount : pageNext;
		pageNext = pageNext < 1 ? 1 : pageNext;
		pagePre = pagePre < 1 ? 1 : pagePre;
	%>
	<header>
		<a class="button button-rounded" href="/slmobile/ios/mainPage?username=<%=request.getAttribute("uid") %>">
		返回</a>
		<a class="button button-rounded" href="javascript:void(0)" onclick="displayType()">类型</a>
		<a class="button button-rounded" href="javascript:void(0)" onclick="displayCompany()">公司</a>
		<a class="button button-rounded" href="javascript:void(0)" onclick="searchs()">查询</a>
		<span id="typeCount"></span> &nbsp; <span id="companyCount"></span>
		<a class="button button-rounded" href="javascript:void(0)" onclick="pagePre()">上一页</a> 第${requestScope.pageNow }/${requestScope.pageCount}页 
		<a class="button button-rounded" href="javascript:void(0)" onclick="pageNext()">下一页</a>
		
		<input type="hidden" id="companyIds" value="<%=request.getAttribute("cids")%>">
		<input type="hidden" id="typeIds" value="<%=request.getAttribute("tids")%>">
	</header>
	
	<section>
		<table>
				<thead>
					<tr>
						<td>序号</td><td>文件名</td><td>公司</td><td>部门</td><td>监管人</td><td>状态</td><td>借出次数</td>
					</tr>
				</thead>
				<tbody>
					<% int row = 1; %>
					<s:iterator value="#request.flist">
					<tr onclick="showFileDetail(<s:property value="id"/>);">
						<td>
							<%=row++ %>
						</td>
						<td>
							<s:property value="name"/>
						</td>
						<td>
							<s:property value="cid.name"/>
						</td>
						<td>
							<s:property value="depId.name"/>
						</td>
						<td>
							<s:property value="ouser.name"/>
						</td>
						<td>
							<s:if test="ostate==0">在库</s:if>
							<s:elseif test="ostate==1">借出</s:elseif>
							<s:else>其它</s:else>
						</td>
						<td>
							<s:property value="applyCount"/>
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
	</section>
	
	<aside>
		<div id="wrapType" class="window">
			<button onclick="selectAll('wrapType')">全选</button>&nbsp;
			<button onclick="reverseSelect('wrapType')">反选</button>&nbsp;
			<button onclick="cancelSelect('wrapType')">清空</button>&nbsp;&nbsp;
			<button onclick="submitType()">确定</button><br>
			<ul id='zTree' class="ztree" ></ul>
		</div>
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
<script type="text/javascript" src="js/zTree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/zTree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript">
function showFileDetail(id)
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
	location.href='<%=basePath%>zx/showFileDetail?pageNow=<%=spage%>&id='+id+'&cids=' + cids +　'&tids=' + tids;
}
function searchs()
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
	location.href='<%=basePath%>zx/searchFiles?pageNow=<%=spage%>&cids=' + cids +　'&tids=' + tids;
}
function pagePre()
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
	location.href='<%=basePath%>zx/searchFiles?pageNow=<%=pagePre%>&cids=' + cids +　'&tids=' + tids;
}
function pageNext()
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
	location.href='<%=basePath%>zx/searchFiles?pageNow=<%=pageNext%>&cids=' + cids +　'&tids=' + tids;
}
function displayType()
{
	document.getElementById("wrapType").style.display="block";
	document.getElementById("wrapCompany").style.display="none";
}
function displayCompany()
{
	document.getElementById("wrapType").style.display="none";
	document.getElementById("wrapCompany").style.display="block";
}
function submitCompany()
{
	var companys = $("#wrapCompany input:checked");
	if(companys.length>0)
	{
		var ids="";
		for(var i = 0; i < companys.length; i++)
		{
			ids += companys[i].value + ",";
		}
		ids = ids.substring(0,ids.length-1);
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
function submitType()
{
	var treeObj = $.fn.zTree.getZTreeObj("zTree");
	var nodes = treeObj.getCheckedNodes(true);
	if(nodes.length > 0)
	{
		var tids="";
		for(var i = 0; i < nodes.length; i++)
		{
			tids += nodes[i].id + ",";
		}
		tids = tids.substring(0,tids.length-1);
		document.getElementById("typeIds").value=tids;
	}
	else
	{
		document.getElementById("typeIds").value="";
	}
	document.getElementById("wrapType").style.display="none";
}
$(function(){
	$.ajax({
		type : 'post',
		url : 'zx/getFileTypeTree',
		data : {},
		success : function(data)
		{
			$.fn.zTree.init($("#zTree"), zTreeSetting, data);
		},
		error : function(xhr, type, exception)
		{
			alert(exception);
		}
	});
});
function onClick(event, treeId, treeNode)
{
	var treeObj = $.fn.zTree.getZTreeObj("zTree");
	var nodes = treeObj.getSelectedNodes();
	if(!treeNode.checked){
		for (var i=0, l=nodes.length; i < l; i++) {
			treeObj.checkNode(nodes[i], true, true);
		}
	}
	else{
		for (var i=0, l=nodes.length; i < l; i++) {
			treeObj.checkNode(nodes[i], false, true);
		}
	}
}
var zTreeSetting = {
		check: {
			enable: true,
			autoCheckTrigger: true
		},
	// 单击节点异步加载数据
	async : {
		enable : false,
		url : "",
		autoParam : [ "id", "name=n", "level=lv" ],
		otherParam : {
			"otherParam" : "zTreeAsyncTest"
		}
	},
	data : {
		simpleData : {
			enable : true,
			idKey : "id"
		}
	},
	callback : {
		onClick : onClick,
		//onCheck: zTreeOnCheck
	}
};
</script>
</body>
</html>
