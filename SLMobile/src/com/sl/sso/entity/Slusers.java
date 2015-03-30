package com.sl.sso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Slusers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SLUsers", schema = "dbo", catalog = "SLPublicLogin")
public class Slusers implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String uid;
	private String name;
	private String password;
	private Company cid;
	private Department depId;
	private Role roleId;
	private String createTime;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Slusers()
	{
	}

	/** minimal constructor */
	public Slusers(String name, String password, Integer dr)
	{
		this.name = name;
		this.password = password;
		this.dr = dr;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "uid", length = 10)
	public String getUid()
	{
		return this.uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	@Column(name = "name", nullable = false, length = 16)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 25)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@ManyToOne
	@JoinColumn(name = "cid", nullable = false, insertable = true, updatable = true)
	public Company getCid()
	{
		return cid;
	}

	public void setCid(Company cid)
	{
		this.cid = cid;
	}

	@ManyToOne
	@JoinColumn(name = "depId", nullable = false, insertable = true, updatable = true)
	public Department getDepId()
	{
		return depId;
	}

	public void setDepId(Department depId)
	{
		this.depId = depId;
	}

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false, insertable = true, updatable = true)
	public Role getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Role roleId)
	{
		this.roleId = roleId;
	}

	@Column(name = "createTime", length = 20)
	public String getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	@Column(name = "dr", nullable = false)
	public Integer getDr()
	{
		return this.dr;
	}

	public void setDr(Integer dr)
	{
		this.dr = dr;
	}

}