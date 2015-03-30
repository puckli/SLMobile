package com.sl.ios.entity;


public class PerformanceDepartment implements java.io.Serializable {

	// Fields

	private Integer perDepartmentId;
	private String name;
	// 小部门所属大部门id
	private Sldbm departmentId;
	private String manageUid; 
	private String manageUname; 
	
	public Integer getPerDepartmentId()
	{
		return perDepartmentId;
	}
	public void setPerDepartmentId(Integer perDepartmentId)
	{
		this.perDepartmentId = perDepartmentId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Sldbm getDepartmentId()
	{
		return departmentId;
	}
	public void setDepartmentId(Sldbm departmentId)
	{
		this.departmentId = departmentId;
	}
	public String getManageUid()
	{
		return manageUid;
	}
	public void setManageUid(String manageUid)
	{
		this.manageUid = manageUid;
	}
	public String getManageUname()
	{
		return manageUname;
	}
	public void setManageUname(String manageUname)
	{
		this.manageUname = manageUname;
	}
	
}