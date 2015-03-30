package com.sl.ncreport.bean;

//@Entity
//@Table(name = "NcInfo", schema = "dbo", catalog = "NCbaobiao")
public class Ncinfo {
	private static final long serialVersionUID = 1L;
	// @Id
	// @GeneratedValue
	// @Column(name = "id", unique = true, nullable = false)
	private Integer id;
	// @Column(name = "company")
	private String company;
	// @Column(name = "pk_glorgbook")
	private String pk_glorgbook;
	// @Column(name = "dwpk_checktype")
	private String dwpk_checktype;
	// @Column(name = "bmpk_checktype")
	private String bmpk_checktype;
	// @Column(name = "hbpk_checktype")
	private String hbpk_checktype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPk_glorgbook() {
		return pk_glorgbook;
	}

	public void setPk_glorgbook(String pk_glorgbook) {
		this.pk_glorgbook = pk_glorgbook;
	}

	public String getDwpk_checktype() {
		return dwpk_checktype;
	}

	public void setDwpk_checktype(String dwpk_checktype) {
		this.dwpk_checktype = dwpk_checktype;
	}

	public String getBmpk_checktype() {
		return bmpk_checktype;
	}

	public void setBmpk_checktype(String bmpk_checktype) {
		this.bmpk_checktype = bmpk_checktype;
	}

	public String getHbpk_checktype() {
		return hbpk_checktype;
	}

	public void setHbpk_checktype(String hbpk_checktype) {
		this.hbpk_checktype = hbpk_checktype;
	}

}
