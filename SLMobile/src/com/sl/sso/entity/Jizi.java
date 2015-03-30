package com.sl.sso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Jizi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jizi", schema = "dbo", catalog = "SLPublicLogin")
public class Jizi implements java.io.Serializable {

	// Fields

	private Integer jid;
	private String jzname;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Jizi() {
	}

	/** full constructor */
	public Jizi(String jzname, Integer dr) {
		this.jzname = jzname;
		this.dr = dr;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "jid", unique = true, nullable = false)
	public Integer getJid() {
		return this.jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	@Column(name = "jzname")
	public String getJzname() {
		return this.jzname;
	}

	public void setJzname(String jzname) {
		this.jzname = jzname;
	}

	@Column(name = "dr")
	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}