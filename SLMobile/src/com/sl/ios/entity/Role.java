package com.sl.ios.entity;


public class Role implements java.io.Serializable
{
	private Integer id;
	private String roleName;
	private Integer roleNumber;
	private Integer limit;
	private String description;
	private String createDate;
	private Integer dr;
	private Integer systems;
	private Integer pvMenu;
	private Integer pvOperate;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getRoleName()
	{
		return roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	
	public Integer getRoleNumber()
	{
		return roleNumber;
	}
	public void setRoleNumber(Integer roleNumber)
	{
		this.roleNumber = roleNumber;
	}
	public Integer getLimit()
	{
		return limit;
	}
	public void setLimit(Integer limit)
	{
		this.limit = limit;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
	public Integer getDr()
	{
		return dr;
	}
	public void setDr(Integer dr)
	{
		this.dr = dr;
	}
	public Integer getSystems()
	{
		return systems;
	}
	public void setSystems(Integer systems)
	{
		this.systems = systems;
	}
	public Integer getPvMenu()
	{
		return pvMenu;
	}
	public void setPvMenu(Integer pvMenu)
	{
		this.pvMenu = pvMenu;
	}
	public Integer getPvOperate()
	{
		return pvOperate;
	}
	public void setPvOperate(Integer pvOperate)
	{
		this.pvOperate = pvOperate;
	}
	
}
