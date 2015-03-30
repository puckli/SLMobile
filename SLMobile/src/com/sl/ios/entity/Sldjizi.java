package com.sl.ios.entity;

/**
 * Sldjizi entity. @author MyEclipse Persistence Tools
 */

public class Sldjizi implements java.io.Serializable {

	// Fields

	private Integer jid;
	private String jzname;
	private String dr;

	// Constructors

	/** default constructor */
	public Sldjizi() {
	}

	/** full constructor */
	public Sldjizi(String jzname, String dr) {
		this.jzname = jzname;
		this.dr = dr;
	}

	// Property accessors

	public Integer getJid() {
		return this.jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public String getJzname() {
		return this.jzname;
	}

	public void setJzname(String jzname) {
		this.jzname = jzname;
	}

	public String getDr() {
		return this.dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

}