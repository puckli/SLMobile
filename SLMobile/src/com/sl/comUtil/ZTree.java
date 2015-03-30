package com.sl.comUtil;


public class ZTree
{
	// 元素id
	private int id;
	// 父节点id，第一级节点为 0
	private int pId;
	// 节点名
	private String name;
	// 加载时是否展开
	private boolean open;
	// 是否父节点，默认最后一级节点
	private boolean isParent;
	// 是否选中复选框
	private boolean checked;
	// 是否禁用复选框
	private boolean chkDisabled;

	private boolean nocheck;
	
	// 节点添加外链，target为html a标签target属性的取值
	private String target;
	private String url;
	
	// 标准javascript语法，相当于onclick
	private String click;
	
	private int pv;
	
	public ZTree()
	{
	}

	public ZTree(int id, int pId, String name, boolean open)
	{
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
	}

	public ZTree(int id, int pId, String name, boolean open, boolean isParent)
	{
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getpId()
	{
		return pId;
	}

	public void setpId(int pId)
	{
		this.pId = pId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isOpen()
	{
		return open;
	}

	public void setOpen(boolean open)
	{
		this.open = open;
	}

	public boolean isParent()
	{
		return isParent;
	}

	public void setParent(boolean isParent)
	{
		this.isParent = isParent;
	}
	
	public boolean isChecked()
	{
		return checked;
	}

	public void setChecked(boolean checked)
	{
		this.checked = checked;
	}

	public boolean isChkDisabled()
	{
		return chkDisabled;
	}

	public void setChkDisabled(boolean chkDisabled)
	{
		this.chkDisabled = chkDisabled;
	}

	public boolean isNocheck()
	{
		return nocheck;
	}

	public void setNocheck(boolean nocheck)
	{
		this.nocheck = nocheck;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getClick()
	{
		return click;
	}

	public void setClick(String click)
	{
		this.click = click;
	}
	
	public int getPv()
	{
		return pv;
	}

	public void setPv(int pv)
	{
		this.pv = pv;
	}

}
