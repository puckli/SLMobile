<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Load Image Page</title>
	<meta name="MobileOptimized" content="240" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache" />    
	<script type="text/javascript" src="/slmobile/js/jquery-1.3.1.min.js"></script>
	<style type="text/css">
		body{text-align:center;padding:0px;margin:0px;}
		.preview_wrapper{color:#777;font-weight:lighter;width:480px;height:480px;margin:0px auto;
		text-align:left;overflow:hidden;font-family: 微软雅黑,Verdana,sans-serif,宋体;}
		.preview-dragOut{-webkit-transform:translateX(0px);
		-webkit-transition:all 0.3s ease-in;-moz-transition:all 0.3s ease-in;-ms-transition:all 0.3s ease-in;
		transition:all 0.3s ease-in;}
		.preview-inside{width:400px;height:400px;float:left;margin:0px;padding:0px;display: inline-block;position:relative;}
		.preview-inside img{display:block;max-width:400px;z-index:810;margin:0px auto;padding:0px;}
		.preview_description .keywords{padding-left:35%;}
		.preview_description .description{padding-left:80px;}
		.drag_div{display:block;width:18px;height:90px;top:10%;bottom:0px;border-radius:4px;cursor:pointer;
		background-color:rgba(222,222,182,.8);z-index:10000;position:relative;margin:0px;padding:9px;
		vertical-align:middle;writing-mode:tb-rl;}
		.dragLeft_div{float:left;}
		.dragRight_div{float:right;}
	</style>
  </head>
  
  <body>
     
    <div class="preview_wrapper">
    			<div id="preImage" class="dragLeft_div drag_div" onclick="dragLeft()">第一张</div>
    			<div style="width:400px;display:inline-block;overflow:hidden;margin:0px auto;padding:0px;">
    	<div id="drag" class="preview-dragOut" style="width:${requestScope.paths.size()*400}px;">
    	<c:forEach items="${paths}" var="item" varStatus="status" >  
    		<div id="img_wrap_${status.count}" class="preview-inside">
    			<img alt="图片无法加载" src="${item}">
    			<div class="preview_description">
            	</div>
    		</div>
    	</c:forEach>
    	</div>
    			</div>
    			<div id="nextImage" class="dragRight_div drag_div" onclick="dragRight()">下一张</div>
    </div>
    
    
	<input type="hidden" id="sid" value="${requestScope.sid}">    
	<input type="hidden" id="imgCount" value="${requestScope.paths.size()}">    
    <script type="text/javascript">
    	var current = Number(1);
    	var total = Number(${requestScope.paths.size()});
    	function dragLeft()
    	{
    		current = current - 1;
    		if(current <= 1)
    		{
    			current = 1;
    			document.getElementById("preImage").innerHTML="第一张";
    		}
   			if(current < total)
   			{document.getElementById("nextImage").innerHTML="下一张";}
    		var where = (current-1) * 400;
    		setTransform(where);
    	}
    	function dragRight()
    	{
    		current = current + 1;
    		if(current >= total)
    		{
    			current = total;
    			document.getElementById("nextImage").innerHTML="最后一张";
    		}
   			if(current > 1)
   			{document.getElementById("preImage").innerHTML="上一张";}
    		var where = (current-1) * 400;
    		setTransform(where);
    	}
    	function setTransform(arg)
    	{
    		var translate = "translateX(-" + arg + "px)"; 
    		document.getElementById("drag").style.webkitTransform=translate;
    		document.getElementById("drag").style.MozTransform=translate;
    		document.getElementById("drag").style.msTransform=translate;
    		document.getElementById("drag").style.transform=translate;
    	}
    	
    </script>
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
