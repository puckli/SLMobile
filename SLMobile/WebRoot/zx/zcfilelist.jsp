<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>zcfilelist</title>
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=0.9, maximum-scale=1.2" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<style type="text/css">

</style>
<link rel="stylesheet" type="text/css" href="zx/style/zcfilelist.css">
<link rel="stylesheet" type="text/css" href="js/zTree/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="zx/js/zcfilelist.js"></script>
</head>
<body>
<header>
 <nav>
  <ul id="nav">
	<li class="top">
	<span class="top_link" href="/slmobile/ios/mainPage?username=<%=request.getAttribute("uid") %>">返回</span>
	</li>
	<c:forEach items="${toptypes}" var="type">
	<li class="top" id="tp${type.id}" value="${type.id}" onclick="showSubTypeOrSearch('${type.id}')">
		<span class="top_link" >${type.name}</span>
	</li>
	</c:forEach>
	<li class="top" onclick="showCompanyBlock()"><span class="top_link">公司</span>
		<%-- <ul>
			<c:forEach items="${clist}" var="c"></c:forEach>
		</ul> --%>
	</li>
  </ul>
 </nav>
</header>
<button id="btn">sss</button>
<%-- <br>
<section>
	<table>
			<thead>
				<tr>
					<td>序号</td><td>文件名</td><td>公司</td><td>部门</td><td>监管人</td><td>状态</td><td>借出次数</td>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
</section> --%>

	
<script type="text/javascript">
function showSubTypes()
{
	
}
function showFileDetail(id)
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
}
function searchs()
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
}
function pagePre()
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
}
function pageNext()
{
	var cids = document.getElementById("companyIds").value;
	var tids = document.getElementById("typeIds").value;
}

</script>
</body>
</html>
