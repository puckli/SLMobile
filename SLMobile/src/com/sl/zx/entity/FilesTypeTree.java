package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FilesTypeTree entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "filesTypeTree", schema = "dbo", catalog = "FileManageSys")
public class FilesTypeTree implements java.io.Serializable {

	// Fields

	private Integer id;
	private String icon;
	private String name;
	private String remark;
	private Integer seq;
	private String url;
	private String pid;

	// Constructors

	/** default constructor */
	public FilesTypeTree() {
	}

	/** full constructor */
	public FilesTypeTree(String icon, String name, String remark, Integer seq,
			String url, String pid) {
		this.icon = icon;
		this.name = name;
		this.remark = remark;
		this.seq = seq;
		this.url = url;
		this.pid = pid;
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

	@Column(name = "icon", length = 100)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "name", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "seq")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "url", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "pid", length = 50)
	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}