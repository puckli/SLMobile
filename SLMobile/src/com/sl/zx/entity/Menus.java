package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menus", schema = "dbo", catalog = "FileManageSys")
public class Menus{

	// Fields
	private Integer id;
	private Integer tops;
	private String title;
	private String url;
	private Integer level;
	private Integer pv;
	private Integer sequence;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Menus() {
	}
	
	public Menus(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	@Column(name = "tops")
	public Integer getTops()
	{
		return tops;
	}

	public void setTops(Integer tops)
	{
		this.tops = tops;
	}

	@Column(name = "title", length = 30)
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Column(name = "url", length = 100)
	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Column(name = "level")
	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer level)
	{
		this.level = level;
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

	@Column(name = "sequence")
	public Integer getSequence()
	{
		return sequence;
	}

	public void setSequence(Integer sequence)
	{
		this.sequence = sequence;
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