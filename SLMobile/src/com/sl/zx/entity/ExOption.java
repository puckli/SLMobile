package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExOption entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exOption", schema = "dbo", catalog = "FileManageSys")
public class ExOption implements java.io.Serializable {

	// Fields

	private Integer id;
	private ApplyGroup agId;
	private ApplyDetail adId;
	private Examine exId;
	private Integer lvl;
	private Integer agree;
	private String name;
	private Users exuser;
	private String exTime;
	private String isAgent;
	private String agentCause;
	private String options;
	private Integer status;

	// Constructors

	/** default constructor */
	public ExOption() {
	}
	
	public ExOption(Integer id) {
		this.id = id;
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

	@ManyToOne
	@JoinColumn(name = "ag_Id", nullable = false, insertable = true, updatable = true)
	public ApplyGroup getAgId()
	{
		return agId;
	}

	public void setAgId(ApplyGroup agId)
	{
		this.agId = agId;
	}

	@ManyToOne
	@JoinColumn(name = "ad_Id", nullable = false, insertable = true, updatable = true)
	public ApplyDetail getAdId()
	{
		return adId;
	}

	public void setAdId(ApplyDetail adId)
	{
		this.adId = adId;
	}

	@ManyToOne
	@JoinColumn(name = "ex_Id", nullable = false, insertable = true, updatable = true)
	public Examine getExId()
	{
		return exId;
	}

	public void setExId(Examine exId)
	{
		this.exId = exId;
	}

	@Column(name = "lvl")
	public Integer getLvl() {
		return this.lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	@Column(name = "agree")
	public Integer getAgree() {
		return this.agree;
	}

	public void setAgree(Integer agree) {
		this.agree = agree;
	}

	@Column(name = "name", length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "exUser", nullable = false, insertable = true, updatable = true)
	public Users getExuser()
	{
		return exuser;
	}

	public void setExuser(Users exuser)
	{
		this.exuser = exuser;
	}

	@Column(name = "exTime", length = 20)
	public String getExTime() {
		return this.exTime;
	}

	public void setExTime(String exTime) {
		this.exTime = exTime;
	}

	@Column(name = "isAgent", length = 1)
	public String getIsAgent() {
		return this.isAgent;
	}

	public void setIsAgent(String isAgent) {
		this.isAgent = isAgent;
	}

	@Column(name = "agentCause", length = 40)
	public String getAgentCause() {
		return this.agentCause;
	}

	public void setAgentCause(String agentCause) {
		this.agentCause = agentCause;
	}

	@Column(name = "options", length = 500)
	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}