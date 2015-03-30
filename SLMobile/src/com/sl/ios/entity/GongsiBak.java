package com.sl.ios.entity;

/**
 * GongsiBak entity. @author MyEclipse Persistence Tools
 */

public class GongsiBak implements java.io.Serializable {

	// Fields

	private Integer gbid;
	private String name;
	private String zi;
	private String dr;

	
	public Integer getGbid() {
		return this.gbid;
	}

	public void setGbid(Integer gbid) {
		this.gbid = gbid;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZi()
	{
		return zi;
	}

	public void setZi(String zi)
	{
		this.zi = zi;
	}

	public String getDr() {
		return this.dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dr == null) ? 0 : dr.hashCode());
		result = prime * result + ((gbid == null) ? 0 : gbid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((zi == null) ? 0 : zi.hashCode());
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
		GongsiBak other = (GongsiBak) obj;
		if (dr == null)
		{
			if (other.dr != null)
				return false;
		}
		else if (!dr.equals(other.dr))
			return false;
		if (gbid == null)
		{
			if (other.gbid != null)
				return false;
		}
		else if (!gbid.equals(other.gbid))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (zi == null)
		{
			if (other.zi != null)
				return false;
		}
		else if (!zi.equals(other.zi))
			return false;
		return true;
	}

}