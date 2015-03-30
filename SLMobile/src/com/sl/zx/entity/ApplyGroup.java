package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * ApplyGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "applyGroup", schema = "dbo", catalog = "FileManageSys")
public class ApplyGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Users applyUser;
	private String applytime;
	private String sptime;
	private Examine examineId;
	private Integer detailCount;
	private String status;
	/**
	 * 是否归还，0未归还，1归还中（走审批），2已归还，3归还未通过，5无需归还（如：电子版）
	 */
	private Integer isReturn;
	private Integer dr;

	// Constructors

	/** default constructor */
	public ApplyGroup() {
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "applyUser", nullable = false, insertable = true, updatable = true)
	public Users getApplyUser()
	{
		return applyUser;
	}

	public void setApplyUser(Users applyUser)
	{
		this.applyUser = applyUser;
	}

	@Column(name = "applytime", length = 20)
	public String getApplytime() {
		return this.applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	
	@Column(name = "sptime", length = 20)
	public String getSptime()
	{
		return sptime;
	}

	public void setSptime(String sptime)
	{
		this.sptime = sptime;
	}

	@ManyToOne(optional=true,fetch=FetchType.EAGER,targetEntity=Examine.class)
	@JoinColumn(name = "examineID", nullable = true)
	public Examine getExamineId()
	{
		return examineId;
	}

	public void setExamineId(Examine examineId)
	{
		this.examineId = examineId;
	}

	@Column(name = "detailCount")
	public Integer getDetailCount()
	{
		return detailCount;
	}

	public void setDetailCount(Integer detailCount)
	{
		this.detailCount = detailCount;
	}

	@Column(name = "status", length = 50)
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Column(name = "isReturn")
	public Integer getIsReturn()
	{
		return isReturn;
	}

	public void setIsReturn(Integer isReturn)
	{
		this.isReturn = isReturn;
	}

	@Column(name = "dr")
	public Integer getDr()
	{
		return dr;
	}

	public void setDr(Integer dr)
	{
		this.dr = dr;
	}
	
}