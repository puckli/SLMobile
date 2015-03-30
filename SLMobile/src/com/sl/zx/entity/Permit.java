package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permit", schema = "dbo", catalog = "FileManageSys")
public class Permit
{

	private Integer id;
	private String name;
	private Integer pv;
	private String sign;

	public Permit()
	{
	}

	public Permit(String name, Integer pv, String sign)
	{
		this.name = name;
		this.pv = pv;
		this.sign = sign;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "name")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "pv")
	public Integer getPv()
	{
		return pv;
	}

	public void setPv(Integer pv)
	{
		this.pv = pv;
	}

	@Column(name = "sign")
	public String getSign()
	{
		return sign;
	}

	public void setSign(String sign)
	{
		this.sign = sign;
	}

}