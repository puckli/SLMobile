package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sl.sso.entity.Company;
import com.sl.sso.entity.Department;

/**
 * Examine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "examine", schema = "dbo", catalog = "FileManageSys")
public class Examine implements java.io.Serializable {

	// Fields

	private Integer id;
	private Company cid;
	private Department depId;
	private Integer lvl;
	private Users examineUser;
	private Users proxyUser;
	private Users alterUser;
	private String auditingPlace;
	private String createDate;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Examine() {
	}
	
	public Examine(Integer id) {
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

	@Column(name = "lvl")
	public Integer getLvl() {
		return this.lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	@ManyToOne
	@JoinColumn(name = "examineUser", nullable = false, insertable = true, updatable = true)
	public Users getExamineUser()
	{
		return examineUser;
	}

	public void setExamineUser(Users examineUser)
	{
		this.examineUser = examineUser;
	}

	@ManyToOne
	@JoinColumn(name = "proxyUser", nullable = false, insertable = true, updatable = true)
	public Users getProxyUser()
	{
		return proxyUser;
	}

	public void setProxyUser(Users proxyUser)
	{
		this.proxyUser = proxyUser;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "alterUser", nullable = true, insertable = true, updatable = true)
	public Users getAlterUser()
	{
		return alterUser;
	}

	public void setAlterUser(Users alterUser)
	{
		this.alterUser = alterUser;
	}

	@Column(name = "auditingPlace", length = 50)
	public String getAuditingPlace() {
		return this.auditingPlace;
	}

	public void setAuditingPlace(String auditingPlace) {
		this.auditingPlace = auditingPlace;
	}

	@Column(name = "createDate", length = 20)
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "dr")
	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}