package com.sl.chatPages.entity;

import java.util.Date;

public class CTRoom
{
	private int id;
	private Date time;
	private String name;
	private int type;
	private String createUser;
	private String CreateUname;
	private short dr;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getCreateUser()
	{
		return createUser;
	}

	public void setCreateUser(String createUser)
	{
		this.createUser = createUser;
	}

	public String getCreateUname()
	{
		return CreateUname;
	}

	public void setCreateUname(String createUname)
	{
		CreateUname = createUname;
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
