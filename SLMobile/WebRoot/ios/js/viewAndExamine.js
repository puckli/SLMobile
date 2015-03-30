function preview()
{
	var bodyHeight = document.body.offsetHeight;
	var sid = document.getElementById("slddls").value;
	document.getElementById("preview_wrapper").style.display = "block";
	var html = "<iframe id='iframe' frameborder='0' class='ifrme' src='ios/loadImagePage?sid=" + sid + "'></iframe>";
	document.getElementById("preview_wrapdiv").innerHTML = html;
	document.getElementById("preview_wrapper").style.height=bodyHeight+"px";
	document.getElementById("preview_wrapdiv").style.height=bodyHeight+"px";
	document.getElementById("iframe").style.height=bodyHeight+"px";
}
function closeWraper()
{
	document.getElementById("preview_wrapper").style.display = "none";
}
/*
 * window.onload=function(){ convertCurrency("<s:property
 * value='#request.sld.jine'/>"); };
 */
function jumpNext()
{
	var text = document.getElementById("jumpNext").innerHTML;
	if(text === "跳过")
	{
		document.getElementById("jumpNext").innerHTML = "不跳过"
		document.getElementById("jumpNextInput").value = "false"
		document.getElementById("jumpNext").style.backgroundColor = "rgba(111,111,111,0.2)";
	}
	else
	{
		document.getElementById("jumpNext").innerHTML = "跳过"
		document.getElementById("jumpNextInput").value = "true"
		document.getElementById("jumpNext").style.backgroundColor = "rgba(232,72,80,0.3)";
	}
}

function opinion(mark)
{
	var sid = document.getElementById("sid").value;
	var uid = document.getElementById("uid").value;
	var content = document.getElementById("content").value;
	var url = "/slmobile/ios/examineSld?uid=" + uid + "&sid=" + sid + "&content=" + content + "&opinion=";

	if(mark)
	{
		document.forms[0].submit();
		return;
	}
	else if(!mark)
	{
		document.getElementById("cover").style.display = "none";
		document.getElementById("alert").style.display = "none";
		return;
	}
}

function sAlert(str)
{
	document.getElementById("alert").style.display = "block";
	document.getElementById("cover").style.display = "block";
	if(str)
	{
		document.getElementById("opinion").value = "agree";
		document.getElementById("message").innerHTML = "确认同意吗？";
	}
	else
	{
		document.getElementById("opinion").value = "disagree";
		document.getElementById("message").innerHTML = "确认拒绝吗？";
	}
}

var args = null;
function getImage(arg)
{
	var display = document.getElementById(arg).style.display;
	if(display == "none" || "" == display)
	{
		args = arg;
		var fileName = document.getElementById(arg).getAttribute("alt");
		imgAjax(arg)
		document.getElementById(arg).style.display = "block";
	}
	else
	{
		document.getElementById(arg).style.display = "none";
	}
}

var xmlHttpRequest = null;
function imgAjax(arg)
{
	if(window.ActiveXObject)
	{
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else if(window.XMLHttpRequest)
	{
		xmlHttpRequest = new XMLHttpRequest();
	}
	if(null != xmlHttpRequest)
	{
		xmlHttpRequest.open("get", "/slmobile/ios/getImagePath?" + "arg=" + arg, true);
		xmlHttpRequest.onreadystatechange = ajaxCallback;
		xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
		xmlHttpRequest.send("arg=" + arg);
	}
}
function ajaxCallback()
{
	if(xmlHttpRequest.readyState == 4)
	{
		if(xmlHttpRequest.status == 200)
		{
			var responseText = xmlHttpRequest.responseText;
			if(responseText == "fail")
			{
				alert("获取图片失败！");
			}
			else
			{
				document.getElementById(args).setAttribute("src", responseText);
			}
		}
		else
		{
			alert("获取图片失败！");
		}
	}
}