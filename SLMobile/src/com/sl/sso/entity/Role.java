package com.sl.sso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", schema = "dbo", catalog = "SLPublicLogin")
public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private Integer roleNumber;
	private String description;
	private String createDate;
	
	/**
	 * 给角色分配权限
	 */
	private Integer pvMenu;
	private Integer pvOperate;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Role() {
	}
	
	public Role(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Role(String roleName, Integer roleNumber, String description,
			String createDate, Integer dr) {
		this.roleName = roleName;
		this.roleNumber = roleNumber;
		this.description = description;
		this.createDate = createDate;
		this.dr = dr;
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

	@Column(name = "roleName")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "roleNumber")
	public Integer getRoleNumber() {
		return this.roleNumber;
	}

	public void setRoleNumber(Integer roleNumber) {
		this.roleNumber = roleNumber;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "createDate")
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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