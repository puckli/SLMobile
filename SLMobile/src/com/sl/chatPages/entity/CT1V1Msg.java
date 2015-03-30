package com.sl.chatPages.entity;

import java.util.Date;

public class CT1V1Msg
{
	private String id;
	private Date time;
	private String sendUser;
	private String receiveUser;
	private String txt;
	private short state;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getSendUser()
	{
		return sendUser;
	}

	public void setSendUser(String sendUser)
	{
		this.sendUser = sendUser;
	}

	public String getReceiveUser()
	{
		return receiveUser;
	}

	public void setReceiveUser(String receiveUser)
	{
		this.receiveUser = receiveUser;
	}

	public String getTxt()
	{
		return txt;
	}

	public void setTxt(String txt)
	{
		this.txt = txt;
	}

	public short getState()
	{
		return state;
	}

	public void setState(short state)
	{
		this.state = state;
	}

}
