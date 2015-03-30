package com.sl.sso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company", schema = "dbo", catalog = "SLPublicLogin")
public class Company implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String zi;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Company() {
	}
	
	public Company(Integer id)
	{
		this.id = id;
	}

	/** minimal constructor */
	public Company(String name) {
		this.name = name;
	}

	/** full constructor */
	public Company(String name, String zi, Integer dr) {
		this.name = name;
		this.zi = zi;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "zi", length = 4)
	public String getZi() {
		return this.zi;
	}

	public void setZi(String zi) {
		this.zi = zi;
	}

	@Column(name = "dr")
	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}