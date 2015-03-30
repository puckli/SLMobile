package com.sl.ios.entity;


/**
 * SldyiJian entity. @author MyEclipse Persistence Tools
 */

public class SldyiJian implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6914069952786244528L;
	private Integer yjid;
	private Integer certificateId;
	private Integer sldExamineid;
	private Integer lvl;
	private String yjname;
	private String yjcontent;
	private ULogin yijianExamineName;
	private String agentCause;
	private String ts;
	private String yijianModule;
	private Integer status;
	private Integer version;
	
	public Integer getYjid() {
		return yjid;
	}
	public void setYjid(Integer yjid) {
		this.yjid = yjid;
	}
	public Integer getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}
	public Integer getSldExamineid() {
		return sldExamineid;
	}
	public void setSldExamineid(Integer sldExamineid) {
		this.sldExamineid = sldExamineid;
	}
	public Integer getLvl() {
		return lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public String getYjname() {
		return yjname;
	}
	public void setYjname(String yjname) {
		this.yjname = yjname;
	}
	public String getYjcontent() {
		return yjcontent;
	}
	public void setYjcontent(String yjcontent) {
		this.yjcontent = yjcontent;
	}
	public ULogin getYijianExamineName() {
		return yijianExamineName;
	}
	public void setYijianExamineName(ULogin yijianExamineName) {
		this.yijianExamineName = yijianExamineName;
	}
	public String getAgentCause() {
		return agentCause;
	}
	public void setAgentCause(String agentCause) {
		this.agentCause = agentCause;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getYijianModule() {
		return yijianModule;
	}
	public void setYijianModule(String yijianModule) {
		this.yijianModule = yijianModule;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}