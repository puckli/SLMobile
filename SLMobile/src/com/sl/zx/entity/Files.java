package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sl.sso.entity.Company;
import com.sl.sso.entity.Department;

/**
 * Files entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "files", schema = "dbo", catalog = "FileManageSys")
public class Files implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private String storeName;
	private Users upUser;
	private String year;
	//
	private String createTime;
	// 所属公司
	private Company cid;
	// 所属部门
	private Department depId;
	private String type;
	// 是否有实物（原件） 1原件；0电子版
	private Integer hasObject;
	private String oname;
//	是否在库
	private Integer ostate;
	private Integer otype;
	private String odescription;
	private String oaddress;
	// 保管部门
	private Department odepId;
	// 监管人
	private Users ouser;
	private FilesTypeTree fileType;
	private Integer status;
	private Integer applyCount;
	private Users lendUser;
	private String lendUserPhone;
	private String filesNumber;
	private String filesRegisterDate;
	private String filesExpireDate;
	private String filesAnnualSurveyDate;
	private Integer dr;
	private String backTime;
	private Integer permit;

	// Constructors

	/** default constructor */
	public Files()
	{
	}
	
	public Files(Integer id)
	{
		this.id = id;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "storeName", length = 50)
	public String getStoreName()
	{
		return this.storeName;
	}

	public void setStoreName(String storeName)
	{
		this.storeName = storeName;
	}

	@ManyToOne
	@JoinColumn(name = "upUser", nullable = false, insertable = true, updatable = true)
	public Users getUpUser()
	{
		return upUser;
	}

	public void setUpUser(Users upUser)
	{
		this.upUser = upUser;
	}

	@Column(name = "year", length = 4)
	public String getYear()
	{
		return this.year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	@Column(name = "createTime", length = 50)
	public String getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	@ManyToOne
	@JoinColumn(name = "cId", nullable = false, insertable = true, updatable = true)
	public Company getCid()
	{
		return cid;
	}

	public void setCid(Company cid)
	{
		this.cid = cid;
	}

	@ManyToOne
	@JoinColumn(name = "depId", nullable = true, insertable = true, updatable = true)
	public Department getDepId()
	{
		return depId;
	}

	public void setDepId(Department depId)
	{
		this.depId = depId;
	}

	@Column(name = "type", length = 10)
	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Column(name = "hasObject")
	public Integer getHasObject()
	{
		return this.hasObject;
	}

	public void setHasObject(Integer hasObject)
	{
		this.hasObject = hasObject;
	}

	@Column(name = "oName", length = 30)
	public String getOname()
	{
		return this.oname;
	}

	public void setOname(String oname)
	{
		this.oname = oname;
	}

	@Column(name = "oState")
	public Integer getOstate()
	{
		return this.ostate;
	}

	public void setOstate(Integer ostate)
	{
		this.ostate = ostate;
	}

	@Column(name = "oType")
	public Integer getOtype()
	{
		return this.otype;
	}

	public void setOtype(Integer otype)
	{
		this.otype = otype;
	}

	@Column(name = "oDescription")
	public String getOdescription()
	{
		return this.odescription;
	}

	public void setOdescription(String odescription)
	{
		this.odescription = odescription;
	}

	@Column(name = "oAddress")
	public String getOaddress()
	{
		return this.oaddress;
	}

	public void setOaddress(String oaddress)
	{
		this.oaddress = oaddress;
	}

	@ManyToOne
	@JoinColumn(name = "oDepId", nullable = true, insertable = true, updatable = true)
	public Department getOdepId()
	{
		return odepId;
	}

	public void setOdepId(Department odepId)
	{
		this.odepId = odepId;
	}

	@ManyToOne
	@JoinColumn(name = "oUser", nullable = true, insertable = true, updatable = true)
	public Users getOuser()
	{
		return ouser;
	}

	public void setOuser(Users ouser)
	{
		this.ouser = ouser;
	}
	@ManyToOne
	@JoinColumn(name="fileType" , nullable=true , insertable=true , updatable=true)
	public FilesTypeTree getFileType() {
		return fileType;
	}

	public void setFileType(FilesTypeTree fileType) {
		this.fileType = fileType;
	}

	@Column(name = "status")
	public Integer getStatus()
	{
		return this.status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
	
	@Column(name = "applyCount")
	public Integer getApplyCount()
	{
		return applyCount;
	}

	public void setApplyCount(Integer applyCount)
	{
		this.applyCount = applyCount;
	}

	@ManyToOne
	@JoinColumn(name="lendUser" , nullable=true , insertable=true , updatable=true)
	public Users getLendUser()
	{
		return lendUser;
	}

	public void setLendUser(Users lendUser)
	{
		this.lendUser = lendUser;
	}

	@Column(name = "lendUserPhone")
	public String getLendUserPhone()
	{
		return lendUserPhone;
	}

	public void setLendUserPhone(String lendUserPhone)
	{
		this.lendUserPhone = lendUserPhone;
	}
	@Column(name = "filesNumber")
	public String getFilesNumber() {
		return filesNumber;
	}

	public void setFilesNumber(String filesNumber) {
		this.filesNumber = filesNumber;
	}

	@Column(name = "filesRegisterDate")
	public String getFilesRegisterDate() {
		return filesRegisterDate;
	}

	public void setFilesRegisterDate(String filesRegisterDate) {
		this.filesRegisterDate = filesRegisterDate;
	}
	@Column(name = "filesExpireDate")
	public String getFilesExpireDate() {
		return filesExpireDate;
	}

	public void setFilesExpireDate(String filesExpireDate) {
		this.filesExpireDate = filesExpireDate;
	}
	@Column(name = "filesAnnualSurveyDate")
	public String getFilesAnnualSurveyDate() {
		return filesAnnualSurveyDate;
	}

	public void setFilesAnnualSurveyDate(String filesAnnualSurveyDate) {
		this.filesAnnualSurveyDate = filesAnnualSurveyDate;
	}

	@Column(name = "dr")
	public Integer getDr()
	{
		return this.dr;
	}

	public void setDr(Integer dr)
	{
		this.dr = dr;
	}

	@Column(name = "backTime", length = 50)
	public String getBackTime()
	{
		return backTime;
	}

	public void setBackTime(String backTime)
	{
		this.backTime = backTime;
	}

	@Column(name = "permit")
	public Integer getPermit()
	{
		return permit;
	}

	public void setPermit(Integer permit)
	{
		this.permit = permit;
	}

}