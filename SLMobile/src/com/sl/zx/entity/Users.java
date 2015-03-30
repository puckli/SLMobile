package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sl.sso.entity.Company;
import com.sl.sso.entity.Department;
import com.sl.sso.entity.Role;

@Entity
@Table(name = "users", schema = "dbo", catalog = "FileManageSys")
public class Users implements java.io.Serializable{

	// Fields

	private String uid;
	private String name;
	private String password;
	private Integer lvl;
	private Integer pvMenu;
	private Integer pvOperate;
	private Company cId;
	private Department depId;
	private Role roleId;
	private String phone;
	private String phone2;
	private String gender;
	private String qq;
	private String address;
	private String headImg;
	private String createTime;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Users() {
	}
	
	public Users(String uid) {
		this.uid = uid;
	}

	/** minimal constructor */
	public Users(String password, Integer dr) {
		this.password = password;
		this.dr = dr;
	}


	// Property accessors
	@Id
//	@GeneratedValue
	@Column(name = "uid", unique = true, nullable = false, length = 10)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "name", length = 15)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 25)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "lvl")
	public Integer getLvl() {
		return this.lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	
	@Column(name = "pvMenu")
	public Integer getPvMenu()
	{
		return pvMenu;
	}

	public void setPvMenu(Integer pv)
	{
		this.pvMenu = pv;
	}
	
	@Column(name = "pvOperate")
	public Integer getPvOperate()
	{
		return pvOperate;
	}

	public void setPvOperate(Integer pvOperate)
	{
		this.pvOperate = pvOperate;
	}

	@ManyToOne
	@JoinColumn(name = "cId", nullable = true, insertable = true, updatable = true)
	public Company getcId()
	{
		return cId;
	}

	public void setcId(Company cId)
	{
		this.cId = cId;
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

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = true, insertable = true, updatable = true)
	public Role getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Role roleId)
	{
		this.roleId = roleId;
	}

	@Column(name = "createTime", length = 20)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "phone", length = 20)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(name = "phone2", length = 20)
	public String getPhone2()
	{
		return phone2;
	}

	public void setPhone2(String phone2)
	{
		this.phone2 = phone2;
	}

	@Column(name = "gender", length = 10)
	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	@Column(name = "qq", length = 20)
	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	@Column(name = "address", length = 50)
	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Column(name = "head_img", length = 20)
	public String getHeadImg()
	{
		return headImg;
	}

	public void setHeadImg(String headImg)
	{
		this.headImg = headImg;
	}

	@Column(name = "dr", nullable = false)
	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}