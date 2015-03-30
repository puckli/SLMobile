package com.sl.chatPages.entity;

import java.util.Date;

public class CTUserdynamic
{
	private String id;
	private String uid;
	private int type;
	private Date time;
	private String txt;
	private short dr;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	public String getTxt()
	{
		return txt;
	}

	public void setTxt(String txt)
	{
		this.txt = txt;
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
