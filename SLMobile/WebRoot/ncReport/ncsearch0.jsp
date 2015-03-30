<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>财务报表</title>
<link rel="stylesheet" type="text/css" href="style/button.css">
<style type="text/css">  
	.bumen{
		width: 1%;
	}
	.leibie{
		width: 1%;
	}
	.kemu{
		width: 7%;
	}
	.nianchu{
		width: 5%;
	}
	.qichu{
		width: 6%;
	}
	.zichan{
		width:24%;
	}
	.huobi{
		width: 50%;
	}
	.jiefang{
		width:12%;
	}
	.dangri{
		width: 6%;
	}
	.dangri1{
		width: 6%;
	}
	.shouru{
		width: 25%;
	}
	.ka{
		width: 3.5%;
	}
	.div{
		display:none;position:absolute;margin:0;padding:0;widht:100%;height:25%;background-color:gray;
		margin-left: 600px; margin-top: 100px;
	}
	
	.s{
		font-family:微软雅黑; font-size: 15px;
	}
	table {table-layout:fixed;}
	table tr{height:22px;}
	td{min-width:60px; font-size: 12px; font-family:微软雅黑;}
	td
	{
		text-align:center;
	}

	tr:nth-child(2n){
		background: #ccc;
	}
	table>tbody>tr:hover{background-color:gray;}
	tr>td:nth-child(1),tr>td:nth-child(2),tr>td:nth-child(3){width:20px;min-width:20px;}
	tr>td:nth-child(1){background-color:#fff;}
	.blackBG{
		background: #FFFFFF;
	}
	.header{margin:10px 15px;}
	.content{margin:10px 15px;content:center;}
	.foter{margin:10px 15px;}
</style>
</head>

<body style="padding:0px 15px;">
		<a class="button button-rounded" href="/slmobile/ios/mainPage?username=<%=request.getParameter("uid") %>">
		<img class="btnimg" alt="" src="../slmobile/resource/back32.png">返回</a>
		<div style="text-align:center;vertical-align:middle; font-size: 1em; ">资产公司 资金/资产《收/支》平衡日报表</div><br/>
		
		<div class="header" id="div1">
			<form action="searched.action" method="post">
			编制单位：<s:select list="#request.list" name="company" id="corp" listKey="id" listValue="company"></s:select>
			年：<select id="year" name="year">
				<option value = "2014">2014</option>
				<option value = "2015">2015</option>
				<option value = "2016">2016</option>
			</select>
			月：<select id="month" name="month"></select>
			日：<select id="day" name="day"></select>
			<input id="btn1" type="submit"  value="查詢">
			<input id="btn2" type="button" value="打印" onclick="preview()">
			
			</form>
		</div>
		
	<div class="content">
		<div style="height:25px;">
			<div id="yang"  style="display: inline-block;">
			
			</div>
			<div style="text-align:right;display: inline-block; float: right;">
				单位：<select id="changess" onchange="changes()">
				<option value="1">元</option>
				<option value="2">万元</option>
				</select>
			</div>
		</div>
		<div style="width:98%">
		<table class="db" border="1" style="border-collapse: collapse" >
			<thead>
				<tr>
					<td rowspan="3" class="leibie">部门</td>
					<td rowspan="3" class="leibie">类别</td>
					<td rowspan="3" colspan="2" class="kemu" style="text-align:center;vertical-align:middle;">科目</td>
					<td rowspan="3" class="nianchu" style="text-align:center;vertical-align:middle;">年初数</td>
					<td rowspan="3" class="qichu" style="text-align:center;vertical-align:middle;">期初数</td>
					<td colspan="4" class="zichan" style="text-align:center;vertical-align:middle;">资产发生</td>
					<td colspan="12" class="huobi"" style="text-align:center;vertical-align:middle;">货币发生</td>
					<td rowspan="3">期末数</td>
				</tr>
				<tr>
					<td colspan="2" class="jiefang" style="text-align:center;vertical-align:middle;background:#FFFFFF;">借方</td>
					<td colspan="2" class="daifang" style="text-align:center;vertical-align:middle;background:#FFFFFF; " >贷方</td>
					<td colspan="6" style="text-align:center;vertical-align:middle;background-color:#FFFFFF;" class="xd">收入</td>
					<td colspan="6" style="text-align:center;vertical-align:middle;background-color:#FFFFFF;" class="xd">支出</td>
				</tr>
				<tr>
					<td class="dangri" style="text-align:center;vertical-align:middle;">当日</td>
					<td>本月累计</td>
					<td class="dangri1" style="text-align:center;vertical-align:middle;">当日</td>
					<td>本月累计</td>
					<td>现金</td>
					<td style="text-align:center;vertical-align:middle;" class="ka">卡</td>
					<td>银行</td>
					<td>承兑</td>
					<td>当日</td>
					<td>本月累计</td>
					<td>现金</td>
					<td style="text-align:center;vertical-align:middle;" class="ka">卡</td>
					<td>银行</td>
					<td>承兑</td>
					<td>当日</td>
					<td>本月累计</td>
				</tr>
			</thead>
			<tbody>
				<jsp:include page="ncsearch1.jsp"></jsp:include>
				<jsp:include page="ncsearch2.jsp"></jsp:include>
			</tbody>
		</table>
		</div>
	</div>

<div class="foter">
	<span>资金部确认：</span>
	<span style="margin-left: 150px;">融资部确认：</span>
	<span style="margin-left: 250px;">资产部确认：</span>
	<span style="margin-left: 400px;">费用确认：</span>
</div>

<script type="text/javascript"  src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="javascript"> 

//页面加载成功刷新后 将session中的日期返回到前台 赋值
window.onload = function(){
	var month1 = document.getElementById("month");
	var str1 = "";
	for(var i = 1;i<13;i++){
		str1 = i;
		if(i<10){
			str1 = "0"+ i ;
		}
		var option = document.createElement("OPTION");
		option.value = str1;
		option.innerHTML = str1;
		month1.appendChild(option);
	} 
	
	var day1 = document.getElementById("day");
	var str = "";
	for(var i = 1; i < 32; i++)
	{
		str = i;
		if(i<10)
		str = "0" + i;
		var option = document.createElement("OPTION");
		option.value = str;
		option.innerHTML = str;
		day1.appendChild(option);
	}

	var year = '${sessionScope.year1}';
	if(year != null && "" != year)
	{
		document.getElementById("year").value=year;//赋值
	}
	var month = '${sessionScope.month1}';
	if(month != null && "" != month )
	{
		document.getElementById("month").value = month;
		
	}
	var day = '${sessionScope.day1}';
	if(day != null && ""!=  day)
	{
		document.getElementById("day").value = day;
	}
	var glorgbook = '${sessionScope.glorgbook1}';
	if(glorgbook != null && ""!= glorgbook)
	{
		document.getElementById("corp").value = glorgbook ;
	}
};

function changes(){
	var tds = document.getElementsByTagName("td");
	var td;
	var title;
	var a = document.getElementById("changess").value;
	if(a == 2)
	{
 		for(var i = 0 ;i < tds.length;i++){
	 		td = tds[i];
	 		title = td.title;
	 		if(title != null && ""!= title){
	 			title = exchange(title);
	 			td.innerHTML = title;
	 		}
 		}
	}
	else
	{
		for(var i = 0 ;i < tds.length;i++){
	 		td = tds[i];
	 		title = td.title;
	 		if(title != null && ""!= title){
	 			td.innerHTML = title;
	 		}
 		}
	}

}
function exchange(arg)
{
	var sign = "";
	var bool = false;
	if(Number(arg)<0)
	{
	 bool = true;
	 sign = "-";
	}
	arg = Math.abs(Number(arg)) + "";
	if(arg.indexOf(".")<0)
		arg += ".00";
	else if(arg.indexOf(".") == (arg.length-2))
	{
		arg += "0";
	}
	var value = "";
	if(arg.length<5)
		value = "0.00";
	else if(arg.length==5)
	{
		var n = arg.substring(0,1);
		if(Number(n) > 4)
		value = "0.01";
		else
		value = '0.00';
	}
	else if(arg.length==6)
	{
		var n = arg.substring(1,2);
		var num = Number(arg.substring(0,1));
		if(Number(n) > 4){
			num = num + 1;
			value = "0.0" + num;
		}
		else{
			value = "0.0" + num;
		}
	}
	else if(arg.length==7)
	{
		var n = arg.substring(2,3);
		var num = Number(arg.substring(0,2));
		if(Number(n)>4){
			num = Number(num + 1) + "";
			if(num.length == 2)
			value = "0." + num ;
			else {
				value = "1.00";
			}
		}
		else {
			value = "0." + num ;
		
		}
	}
	else if(arg.length==8)
	{
	
		var n = arg.substring(3,4);
		if(arg=='507652.20')
		alert(n);
		var num =Number(arg.substring(0,3));
		if(Number(n)>4){
			num = num + 1;
			num = num + "";
			value = num.substring(0,num.length-2)+ "." + num.substring(num.length-2,num.length);
		}else{
			num = num + "";
			value = num.substring(0,num.length-2)+ "." + num.substring(num.length-2,num.length);
		}
	}
	else if(arg.length>8)
	{
		var length = arg.length;
		var n = arg.substring(length-5,length-4);
		var num =Number(arg.substring(0,length-5));
		if(Number(n)>4){
			num = Number(num + 1) + "";
			value = num.substring(0,num.length-2)+ "." + num.substring(num.length-2,num.length);
		}else{
			num = num + "";
			value = num.substring(0,num.length-2)+ "." + num.substring(num.length-2,num.length);
		}
	}
	
	if(bool)
	{
		return sign + value;
	}
	else
	{
		return value;
	}
}
		
function searchs(){
	document.getElementById("btn1").setAttribute("disabled","disabled");
	document.getElementById("btn2").setAttribute("disabled","disabled");
	var N = document.getElementById("n").value;
	var Y= document.getElementById("y").value;
	var R = document.getElementById("r").value;
	var C = document.getElementById("corp").value;
	
	$.ajax({
	type : "post",
	url : 'searched',
	data:{year:N,month:Y,day:R,corp:C},
	success:function(data){
		alert(data);
		document.getElementById("btn1").removeAttribute("disabled");
		document.getElementById("btn2").removeAttribute("disabled");
	},
	error:function(x,type,e)
	{
		alert("查询错误，type："+type + " :: e:" + e);
		document.getElementById("btn1").removeAttribute("disabled");
		document.getElementById("btn2").removeAttribute("disabled");
	}
});
}

function preview()         
{  
var year = document.getElementById("year").value;
var month = document.getElementById("month").value;
var day = document.getElementById("day").value;
var company = $("#corp").text();
var str = "编制单位:"+company+year+"年"+month+"月"+day+"日";
document.getElementById("yang").innerHTML = str;

document.getElementById("div1").style.display="none";

window.print();
document.getElementById("div1").style.display="";
  
}  
				
</script>
</body>
</html>
