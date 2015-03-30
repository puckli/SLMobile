package com.sl.chatPages.entity;

import java.util.Date;

public class CTFriendGroup
{
	private int id;
	private String uid;
	private int sequence;
	private String name;
	private Date time;
	private short dr;

	
	public CTFriendGroup()
	{
	}

	public CTFriendGroup(String uid, int sequence, String name, Date time, short dr)
	{
		super();
		this.uid = uid;
		this.sequence = sequence;
		this.name = name;
		this.time = time;
		this.dr = dr;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public int getSequence()
	{
		return sequence;
	}

	public void setSequence(int sequence)
	{
		this.sequence = sequence;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
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
