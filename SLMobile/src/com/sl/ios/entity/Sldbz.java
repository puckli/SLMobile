package com.sl.ios.entity;

/**
 * Sldbz entity. @author MyEclipse Persistence Tools
 */

public class Sldbz implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String bzname;
	private String dr;

	// Constructors

	/** default constructor */
	public Sldbz() {
	}

	/** full constructor */
	public Sldbz(String bzname, String dr) {
		this.bzname = bzname;
		this.dr = dr;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBzname() {
		return this.bzname;
	}

	public void setBzname(String bzname) {
		this.bzname = bzname;
	}

	public String getDr() {
		return this.dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

}