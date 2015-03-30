package com.sl.sso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "department", schema = "dbo", catalog = "SLPublicLogin")
public class Department  {

	// Fields

	private Integer id;
	private String name;
	private String shortName;
	private Jizi jizi;
	private Company cid;
	/**
	 * 部门负责人
	 */
	private String supervisorUid;  
	private String supervisorUname;  
	
	/**
	 * 给部门非配权限
	 */
	private Integer pvMenu;
	private Integer pvOperate;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String name) {
		this.name = name;
	}
	
	public Department(Integer id) {
		this.id = id;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "shortName", length = 10)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@ManyToOne
	@JoinColumn(name = "jizi", nullable = true, insertable = true, updatable = true)
	public Jizi getJizi()
	{
		return jizi;
	}

	public void setJizi(Jizi jizi)
	{
		this.jizi = jizi;
	}

	@ManyToOne
	@JoinColumn(name = "cId", nullable = true, insertable = true, updatable = true)
	public Company getCid()
	{
		return cid;
	}

	public void setCid(Company cid)
	{
		this.cid = cid;
	}
	
	@Column(name = "supervisorUid")
	public String getSupervisorUid()
	{
		return supervisorUid;
	}

	public void setSupervisorUid(String supervisorUid)
	{
		this.supervisorUid = supervisorUid;
	}

	@Column(name = "supervisorUname")
	public String getSupervisorUname()
	{
		return supervisorUname;
	}

	public void setSupervisorUname(String supervisorUname)
	{
		this.supervisorUname = supervisorUname;
	}

	@Column(name = "pvMenu")
	public Integer getPvMenu()
	{
		return pvMenu;
	}

	public void setPvMenu(Integer pvMenu)
	{
		this.pvMenu = pvMenu;
	}
	
	@Column(name = "pvOperate")
	public Integer getPvOperate()
	{
		return pvOperate;
	}

	public void setPvOperate(Integer pvOperate)
	{
		this.pvOperate = pvOperate;
	}

	@Column(name = "dr")
	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}