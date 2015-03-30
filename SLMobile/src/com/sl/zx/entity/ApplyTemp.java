package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ApplyTemp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "applyTemp", schema = "dbo", catalog = "FileManageSys")
public class ApplyTemp implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Users uid;
	private Files fid;
	private String returnDate;
	private String reason;

	// Constructors

	/** default constructor */
	public ApplyTemp()
	{
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

	@ManyToOne
	@JoinColumn(name = "uid", nullable = false, insertable = true, updatable = true)
	public Users getUid()
	{
		return uid;
	}

	public void setUid(Users uid)
	{
		this.uid = uid;
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

	@Column(name = "return_date", length = 50)
	public String getReturnDate()
	{
		return this.returnDate;
	}

	public void setReturnDate(String returnDate)
	{
		this.returnDate = returnDate;
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

}