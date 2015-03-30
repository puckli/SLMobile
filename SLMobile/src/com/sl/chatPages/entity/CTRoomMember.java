package com.sl.chatPages.entity;

public class CTRoomMember
{
	private int id;
	private int roomID;
	private String uid;
	private short dr;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getRoomID()
	{
		return roomID;
	}

	public void setRoomID(int roomID)
	{
		this.roomID = roomID;
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
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
