<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'agreeSldList.jsp' starting page</title>
    
<meta name="MobileOptimized" content="240" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="ios/style/list.css">
<link rel="stylesheet" type="text/css" href="style/button.css">
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
		<img class="btnimg" alt="" src="../slmobile/resource/back32.png">返回</a>
		<a class="button button-rounded" onclick="refresh();">
		<img class="btnimg" alt="" src="../slmobile/resource/reload32.png">刷新</a>
		<a class="title">拒绝的单据</a>
		<a class="button button-rounded" href="/slmobile/ios/getDisagreeSldList?pageNow=<%=pagePre %>&uid=<%=session.getAttribute("uid") %>">上一页</a> 第${requestScope.pageNow }/${requestScope.pageCount}页 
		<a class="button button-rounded" href="/slmobile/ios/getDisagreeSldList?pageNow=<%=pageNext %>&uid=<%=session.getAttribute("uid") %>">下一页</a>
	</header>
    
    <section>
			<table>
				<thead>
					<tr>
						<th>序号</th><th>单据号</th><th>公司</th><th>部门</th><th>业务类型</th><th>收付款单位</th><th>金额</th><th>制单人</th><th>制单日期</th>
					</tr>
				</thead>
				<tbody>
					<% int row = 1; %>
					<s:iterator value="#request.disagreeList">
					<tr onclick="showSLD(<s:property value="sid"/>);">
						<td>
							<%=row++ %>
						</td>
						<td>
							<s:property value="slddls"/>
						</td>
						<td>
							<s:property value="gongsiId.name"/>
						</td>
						<td>
							<s:property value="bumen.bname"/>
						</td>
						<td>
							<s:property value="ywlx.Yname"/>
						</td>
						<td>
							<s:property value="sfkdw"/>
						</td>
						<td>
							<s:property value="jine"/>
						</td>
						<td>
							<s:property value="writePeople.uname"/>
						</td>
						<td>
							<s:property value="ts"/>
						</td>
						
					</tr>
					</s:iterator>
				
				</tbody>
			
			</table>
    </section>
    <footer>
   		
    </footer>
    <br>
    <script type="text/javascript">
		function refresh()
		{
			window.location.reload(true);
		}
		function showSLD(sid)
		{
			var uid = '${requestScope.uid}';
			location.href="/slmobile/ios/showSLD?opinion=disagree&uid=" + uid + "&sid=" + sid;
		}
	</script>
    
    
  </body>
</html>
