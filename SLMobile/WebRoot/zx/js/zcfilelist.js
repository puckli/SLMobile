
window.onload=function(){
	initMenu();
}

function initMenu()
{
	var toplis = $("#nav>li");
	var ids="",tid="";
	for(var i = 0; i < toplis.length; i++)
	{
		tid = toplis[i].value.toString();
		if(!!tid && tid != "0"){
			ids += tid + ",";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type:'post',
		url:'zx/findSubTypeTree',
		data:{ids:ids},
		success:function(data)
		{
			if(data)
			{
				for(var i = 0; i < toplis.length; i++)
				{
					tid = toplis[i].value.toString();
					if(!!tid && tid != "0"){
						var subdata = data[tid];
						if(subdata)
						{
							var li = document.getElementById("tp"+tid);
							initSubMenu(li,subdata, data, 1);
						}
					}
				}
			}
		}
	});
}

// 递归处理菜单子节点
function initSubMenu(pli, data, src, level)
{
	var ul = document.createElement("ul");
	if(level == 1)
	{
		ul.setAttribute("class", "sub");
	}
	var li,a;
	var temp = "";
	for(var i = 0; i < data.length; i++)
	{
		temp = data[i].id;
		li = document.createElement("li");
		li.setAttribute("value", temp);
		li.id = "tp" + temp;
		a = document.createElement("span");
		a.innerHTML = data[i].name;
		a.setAttribute("class", "link");
		li.appendChild(a);
		li.setAttribute("onclick","showSubTypeOrSearch('"+temp+"');");
		
		var subdata = src[temp];
		if(subdata)
		{
			li.setAttribute("class", "fly");
			initSubMenu(li,subdata, src, level + 1);
		}
		ul.appendChild(li);
	}
	pli.appendChild(ul);
}

// 点击菜单查询，如果有子菜单，则显示子菜单
function showSubTypeOrSearch(arg, arg2)
{
	$("#tp"+arg).hover();
}

function showCompanyBlock()
{
	
}












