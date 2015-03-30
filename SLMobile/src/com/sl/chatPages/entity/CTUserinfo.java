package com.sl.chatPages.entity;

import java.util.Date;

public class CTUserinfo
{
	private String uid;
	private String uname;
	private String nickName;
	private String photo;
	private String sex;
	private String age;
	private Date lastLogin;
	private short dr;
	public String getUid()
	{
		return uid;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getNickName()
	{
		return nickName;
	}
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public Date getLastLogin()
	{
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
	}
	public short getDr()
	{
		return dr;
	}
	public void setDr(short dr)
	{
		this.dr = dr;
	}
}
