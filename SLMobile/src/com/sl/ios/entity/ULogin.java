package com.sl.ios.entity;

import java.util.Set;

/**
 * ULogin entity. @author MyEclipse Persistence Tools
 */

public class ULogin implements java.io.Serializable
{

	// Fields
	private String uid;
	private String uname;
	private String upassword;
	private Integer ulvl;
	private String img;
	private String phoneNum;
	private Integer performanceAuthority;
	private Integer reimburse;
	private GongsiBak company;
	private Sldbm department;
	private PerformanceDepartment smallDepartment;
	private Integer supplyChain;
	private Integer pvMenu;
	private Integer pvOperate;
	private Integer pvSystems;
	private Set<Role> roles;
	private Integer dr;
	private Set<GongsiBak> companys;
	private Set<Sldbm> departments;

	public ULogin()
	{
		super();
	}
	
	public PerformanceDepartment getSmallDepartment()
	{
		return smallDepartment;
	}



	public void setSmallDepartment(PerformanceDepartment smallDepartment)
	{
		this.smallDepartment = smallDepartment;
	}



	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getUpassword()
	{
		return upassword;
	}

	public void setUpassword(String upassword)
	{
		this.upassword = upassword;
	}

	public Integer getUlvl()
	{
		return ulvl;
	}

	public void setUlvl(Integer ulvl)
	{
		this.ulvl = ulvl;
	}

	public String getImg()
	{
		return img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public Integer getPerformanceAuthority()
	{
		return performanceAuthority;
	}

	public void setPerformanceAuthority(Integer performanceAuthority)
	{
		this.performanceAuthority = performanceAuthority;
	}

	public Integer getReimburse()
	{
		return reimburse;
	}

	public void setReimburse(Integer reimburse)
	{
		this.reimburse = reimburse;
	}

	public GongsiBak getCompany()
	{
		return company;
	}

	public void setCompany(GongsiBak company)
	{
		this.company = company;
	}

	public Sldbm getDepartment()
	{
		return department;
	}

	public void setDepartment(Sldbm department)
	{
		this.department = department;
	}

	public Integer getSupplyChain() {
		return supplyChain;
	}

	public void setSupplyChain(Integer supplyChain) {
		this.supplyChain = supplyChain;
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

	public Integer getPvSystems()
	{
		return pvSystems;
	}

	public void setPvSystems(Integer pvSystems)
	{
		this.pvSystems = pvSystems;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public Integer getDr()
	{
		return dr;
	}

	public void setDr(Integer dr)
	{
		this.dr = dr;
	}

	public Set<GongsiBak> getCompanys()
	{
		return companys;
	}

	public void setCompanys(Set<GongsiBak> companys)
	{
		this.companys = companys;
	}

	public Set<Sldbm> getDepartments()
	{
		return departments;
	}

	public void setDepartments(Set<Sldbm> departments)
	{
		this.departments = departments;
	}
	
}