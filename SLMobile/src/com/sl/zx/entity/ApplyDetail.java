package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ApplyDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "applyDetail", schema = "dbo", catalog = "FileManageSys")
public class ApplyDetail implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String applyNumber;
	private ApplyGroup agId;
	private Files fid;
	private String reason;
	private String backtime;
	private String realbacktime;
	private Integer state;
	private String address;
	private Integer isValid;
	// 原件、复件
	private String fileType;
	/**
	 * 是否归还，0未归还，1归还中（走审批），2已归还，3归还未通过，5无需归还（如：电子版）
	 */
	private Integer isReturn;
	private Integer dr;

	// Constructors

	/** default constructor */
	public ApplyDetail()
	{
	}
	
	public ApplyDetail(Integer id)
	{
		this.id = id;
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
	@Column(name = "applyNumber")
	public String getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}

	@ManyToOne
	@JoinColumn(name = "ag_id", nullable = false, insertable = true, updatable = true)
	public ApplyGroup getAgId()
	{
		return agId;
	}

	public void setAgId(ApplyGroup agId)
	{
		this.agId = agId;
	}

	@ManyToOne
	@JoinColumn(name = "fid", nullable = false, insertable = true, updatable = true)
	public Files getFid()
	{
		return fid;
	}

	public void setFid(Files fid)
	{
		this.fid = fid;
	}

	@Column(name = "reason")
	public String getReason()
	{
		return this.reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	@Column(name = "backtime", length = 20)
	public String getBacktime()
	{
		return this.backtime;
	}

	public void setBacktime(String backtime)
	{
		this.backtime = backtime;
	}

	@Column(name = "realbacktime", length = 20)
	public String getRealbacktime()
	{
		return this.realbacktime;
	}

	public void setRealbacktime(String realbacktime)
	{
		this.realbacktime = realbacktime;
	}

	@Column(name = "state")
	public Integer getState()
	{
		return this.state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	@Column(name = "address")
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Column(name = "isValid")
	public Integer getIsValid()
	{
		return this.isValid;
	}

	public void setIsValid(Integer isValid)
	{
		this.isValid = isValid;
	}

	@Column(name = "fileType", length = 200)
	public String getFileType()
	{
		return this.fileType;
	}

	public void setFileType(String fileType)
	{
		this.fileType = fileType;
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
		return this.dr;
	}

	public void setDr(Integer dr)
	{
		this.dr = dr;
	}

}