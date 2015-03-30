package com.sl.ios.entity;

/**
 * Sldexamine entity. @author MyEclipse Persistence Tools
 */

public class Sldexamine implements java.io.Serializable {

	// Fields

	private Integer seid;
	private Sldywlx ywlx;
	private Integer lvl;
	private ULogin examineName;
	private ULogin proxyName;
	private ULogin alterName;
	private String auditingPlace;
	private String date;
	private Integer phoneUser;
	private String module;
	private Integer showState;
	// 移号标识，0一般情况，1跳过（总裁），2交换到最后。
	private Integer moveMark;
	private String dr;
	
	public Integer getSeid() {
		return seid;
	}
	public void setSeid(Integer seid) {
		this.seid = seid;
	}
	
	public Sldywlx getYwlx() {
		return ywlx;
	}
	public void setYwlx(Sldywlx ywlx) {
		this.ywlx = ywlx;
	}
	public Integer getLvl() {
		return lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public ULogin getExamineName() {
		return examineName;
	}
	public void setExamineName(ULogin examineName) {
		this.examineName = examineName;
	}
	public ULogin getAlterName() {
		return alterName;
	}
	public void setAlterName(ULogin alterName) {
		this.alterName = alterName;
	}
	
	public ULogin getProxyName() {
		return proxyName;
	}
	public void setProxyName(ULogin proxyName) {
		this.proxyName = proxyName;
	}
	
	public String getAuditingPlace() {
		return auditingPlace;
	}
	public void setAuditingPlace(String auditingPlace) {
		this.auditingPlace = auditingPlace;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getPhoneUser() {
		return phoneUser;
	}
	public void setPhoneUser(Integer phoneUser) {
		this.phoneUser = phoneUser;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Integer getShowState() {
		return showState;
	}
	public void setShowState(Integer showState) {
		this.showState = showState;
	}
	public Integer getMoveMark()
	{
		return moveMark;
	}
	public void setMoveMark(Integer moveMark)
	{
		this.moveMark = moveMark;
	}
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
}