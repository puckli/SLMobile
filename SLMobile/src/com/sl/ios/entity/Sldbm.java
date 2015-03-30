package com.sl.ios.entity;


/**
 * Sldbm entity. @author MyEclipse Persistence Tools
 */

public class Sldbm implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String bname;
	private String bdx;
	private Sldjizi jizi;
	private String dr;
	private GongsiBak company;
	private Integer systems;
	private Integer pvMenu;
	private Integer pvOperate;
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdx() {
		return bdx;
	}
	public void setBdx(String bdx) {
		this.bdx = bdx;
	}
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
	public Sldjizi getJizi() {
		return jizi;
	}
	public void setJizi(Sldjizi jizi) {
		this.jizi = jizi;
	}
	
	public GongsiBak getCompany()
	{
		return company;
	}
	public void setCompany(GongsiBak company)
	{
		this.company = company;
	}
	public Integer getSystems()
	{
		return systems;
	}
	public void setSystems(Integer systems)
	{
		this.systems = systems;
	}
	public Integer getPvMenu()
	{
		return pvMenu;
	}
	public void setPvMenu(Integer pvMenu)
	{
		this.pvMenu = pvMenu;
	}
	public Integer getPvOperate()
	{
		return pvOperate;
	}
	public void setPvOperate(Integer pvOperate)
	{
		this.pvOperate = pvOperate;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bdx == null) ? 0 : bdx.hashCode());
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((dr == null) ? 0 : dr.hashCode());
		result = prime * result + ((jizi == null) ? 0 : jizi.getJid().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sldbm other = (Sldbm) obj;
		if (bdx == null)
		{
			if (other.bdx != null)
				return false;
		}
		else if (!bdx.equals(other.bdx))
			return false;
		if (bid == null)
		{
			if (other.bid != null)
				return false;
		}
		else if (!bid.equals(other.bid))
			return false;
		if (bname == null)
		{
			if (other.bname != null)
				return false;
		}
		else if (!bname.equals(other.bname))
			return false;
		if (dr == null)
		{
			if (other.dr != null)
				return false;
		}
		else if (!dr.equals(other.dr))
			return false;
		if (jizi == null)
		{
			if (other.jizi != null)
				return false;
		}
		else if (!jizi.getJid().equals(other.jizi.getJid()))
			return false;
		return true;
	}
	
}