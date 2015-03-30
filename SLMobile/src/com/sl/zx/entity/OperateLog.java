package com.sl.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sl.comUtil.UtilMethod;

/**
 * 操作日志
 * --10-20号段为文件信息修改、移交管理人等操作； 20-30号段为借出归还等操作
 * -- 11.文件档案更新，12单个文件移交监管人，13文件批量移交监管人
 * -- 21电子版借出，22原文件借出，23原文件提交归还，24原文件确认归还
 */
@Entity
@Table(name = "OperateLog", schema = "dbo", catalog = "FileManageSys")
public class OperateLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private Integer pk;
	private String description;
	private String time;
	private Users operateUser;
	private Users targetUser;
	private Integer mark;
	private String info1;
	private String info2;
	private String info3;
	private String info4;
	private String info5;
	private int dr;
	
	
	
	public OperateLog()
	{
		this.dr=0;
		this.time = UtilMethod.dateTimeFormat();
	}
	
	public OperateLog(Integer id)
	{
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	@Column(name = "type")
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
	}
	
	@Column(name = "pk")
	public Integer getPk()
	{
		return pk;
	}

	public void setPk(Integer pk)
	{
		this.pk = pk;
	}

	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	@Column(name = "time")
	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}
	
	@ManyToOne
	@JoinColumn(name = "operateUser", nullable = false, insertable = true, updatable = true)
	public Users getOperateUser()
	{
		return operateUser;
	}
	public void setOperateUser(Users operateUser)
	{
		this.operateUser = operateUser;
	}
	
	@ManyToOne
	@JoinColumn(name = "targetUser", nullable = false, insertable = true, updatable = true)
	public Users getTargetUser()
	{
		return targetUser;
	}
	public void setTargetUser(Users targetUser)
	{
		this.targetUser = targetUser;
	}
	
	@Column(name = "mark")
	public Integer getMark()
	{
		return mark;
	}
	public void setMark(Integer mark)
	{
		this.mark = mark;
	}
	
	@Column(name = "info1")
	public String getInfo1()
	{
		return info1;
	}
	public void setInfo1(String info1)
	{
		this.info1 = info1;
	}
	
	@Column(name = "info2")
	public String getInfo2()
	{
		return info2;
	}
	public void setInfo2(String info2)
	{
		this.info2 = info2;
	}
	
	@Column(name = "info3")
	public String getInfo3()
	{
		return info3;
	}
	public void setInfo3(String info3)
	{
		this.info3 = info3;
	}
	
	public String getInfo4()
	{
		return info4;
	}

	public void setInfo4(String info4)
	{
		this.info4 = info4;
	}

	public String getInfo5()
	{
		return info5;
	}

	public void setInfo5(String info5)
	{
		this.info5 = info5;
	}

	@Column(name = "dr")
	public int getDr()
	{
		return dr;
	}
	public void setDr(int dr)
	{
		this.dr = dr;
	}
	
}