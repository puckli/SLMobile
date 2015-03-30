package com.sl.ncreport.bean;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
//@Table(name = "Ncbb", schema = "dbo", catalog = "NCbaobiao")
public class Ncbb implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "datatime")
	private String datatime;
	@Column(name = "company")
	private String company;
	@Column(name = "system")
	private String system;
	@Column(name = "subject")
	private String subject;
	@Column(name = "yearbegin")
	private BigDecimal yearbegin;
	@Column(name = "qichu")
	private BigDecimal qichu;
	@Column(name = "jfday")
	private BigDecimal jfday;
	@Column(name = "jfyue")
	private BigDecimal jfyue;
	@Column(name = "dfday")
	private BigDecimal dfday;
	@Column(name = "dfyue")
	private BigDecimal dfyue;
	@Column(name = "srmoney")
	private BigDecimal srmoney;
	@Column(name = "srka")
	private BigDecimal srka;
	@Column(name = "srbank")
	private BigDecimal srbank;
	@Column(name = "srchengdui")
	private BigDecimal srchengdui;
	@Column(name = "srday")
	private BigDecimal srday;
	@Column(name = "sryue")
	private BigDecimal sryue;
	@Column(name = "zcmoney")
	private BigDecimal zcmoney;
	@Column(name = "zcka", insertable = false, updatable = false)
	private BigDecimal zcka;
	@Column(name = "zcbank")
	private BigDecimal zcbank;
	@Column(name = "zcchengdui")
	private BigDecimal zcchengdui;
	@Column(name = "zcday")
	private BigDecimal zcday;
	@Column(name = "zcyue")
	private BigDecimal zcyue;
	@Column(name = "qmdata")
	private BigDecimal qmdata;
	
	//获取的数据保留两位小数
	static DecimalFormat df = new DecimalFormat("#.00");
	
	//取出来的数据如果为零 就显示为空 
		private BigDecimal isNull(BigDecimal bd)
		{
			if(bd == null || "0".equals(bd.toString()) ||  bd.toString().startsWith("0.0"))
			{
				return null;
			}
			return new BigDecimal(df.format(bd));
		}
	
		
		public Ncbb()
	{
	}

	public Ncbb(String datatime, String company,String system, String subject) {
		this.datatime = datatime;
		this.company = company;
		this.system = system;
		this.subject = subject;
	}
	public void set(String datatime, String company, String system, String subject) {
		this.datatime = datatime;
		this.company = company;
		this.system = system;
		this.subject = subject;
	}

	public Ncbb(BigDecimal yearbegin, BigDecimal qichu, BigDecimal jfday, BigDecimal jfyue, BigDecimal dfday, BigDecimal dfyue, BigDecimal srmoney,
			BigDecimal srka, BigDecimal srbank, BigDecimal srchengdui, BigDecimal srday, BigDecimal sryue, BigDecimal zcmoney, BigDecimal zcka,
			BigDecimal zcbank, BigDecimal zcchengdui, BigDecimal zcday, BigDecimal zcyue, BigDecimal qmdata) {
		this.yearbegin = yearbegin;
		this.qichu = qichu;
		this.jfday = jfday;
		this.jfyue = jfyue;
		this.dfday = dfday;
		this.dfyue = dfyue;
		this.srmoney = srmoney;
		this.srka = srka;
		this.srbank = srbank;
		this.srchengdui = srchengdui;
		this.srday = srday;
		this.sryue = sryue;
		this.zcmoney = zcmoney;
		this.zcka = zcka;
		this.zcbank = zcbank;
		this.zcchengdui = zcchengdui;
		this.zcday = zcday;
		this.zcyue = zcyue;
		this.qmdata = qmdata;
	}

	public void setDate1(BigDecimal yearbegin, BigDecimal qichu, BigDecimal jfday, BigDecimal jfyue, BigDecimal dfday, BigDecimal dfyue) {
		this.yearbegin = yearbegin;
		this.qichu = qichu;
		this.jfday = jfday;
		this.jfyue = jfyue;
		this.dfday = dfday;
		this.dfyue = dfyue;
	}
	
	

	public  void setDate2(BigDecimal srmoney, BigDecimal srka, BigDecimal srbank, BigDecimal srchengdui, BigDecimal srday, BigDecimal sryue) {
		this.srmoney = srmoney;
		this.srka = srka;
		this.srbank = srbank;
		this.srchengdui = srchengdui;
		this.srday = srday;
		this.sryue = sryue;
	}

	
	
	public  void setDate3(BigDecimal zcmoney, BigDecimal zcka, BigDecimal zcbank, BigDecimal zcchengdui, BigDecimal zcday, BigDecimal zcyue, BigDecimal qmdata) {
		this.zcmoney = zcmoney;
		this.zcka = zcka;
		this.zcbank = zcbank;
		this.zcchengdui = zcchengdui;
		this.zcday = zcday;
		this.zcyue = zcyue;
		this.qmdata = qmdata;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getDatatime()
	{
		return datatime;
	}

	public void setDatatime(String datatime)
	{
		this.datatime = datatime;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getSystem()
	{
		return system;
	}

	public void setSystem(String system)
	{
		this.system = system;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	//保留两位小数 用此方法
	public BigDecimal  getYearbegin()
	{ 
		return isNull(yearbegin);
	}


	public void setYearbegin(BigDecimal yearbegin)
	{
		this.yearbegin = yearbegin;
	}
	//保留两位小数 用此方法
	public BigDecimal getQichu()
	{
		return isNull(qichu);
	}
	

	public void setQichu(BigDecimal qichu)
	{
		this.qichu = qichu;
	}

	public BigDecimal getJfday()
	{
		return isNull(jfday);
	}

	public void setJfday(BigDecimal jfday)
	{
		this.jfday = jfday;
	}

	public BigDecimal getJfyue()
	{
		return isNull(jfyue);
	}

	public void setJfyue(BigDecimal jfyue)
	{
		this.jfyue = jfyue;
	}

	public BigDecimal getDfday()
	{
		return isNull(dfday);
	}

	public void setDfday(BigDecimal dfday)
	{
		this.dfday = dfday;
	}

	public BigDecimal getDfyue()
	{
		return isNull(dfyue);
	}

	public void setDfyue(BigDecimal dfyue)
	{
		this.dfyue = dfyue;
	}

	public BigDecimal getSrmoney()
	{
		return isNull(srmoney);
	}

	public void setSrmoney(BigDecimal srmoney)
	{
		this.srmoney = srmoney;
	}

	public BigDecimal getSrka()
	{
		return isNull(srka);
	}

	public void setSrka(BigDecimal srka)
	{
		this.srka = srka;
	}

	public BigDecimal getSrbank()
	{
		return isNull(srbank);
	}

	public void setSrbank(BigDecimal srbank)
	{
		this.srbank = srbank;
	}

	public BigDecimal getSrchengdui()
	{
		return isNull(srchengdui);
	}

	public void setSrchengdui(BigDecimal srchengdui)
	{
		this.srchengdui = srchengdui;
	}

	public BigDecimal getSrday()
	{
		return isNull(srday);
	}

	public void setSrday(BigDecimal srday)
	{
		this.srday = srday;
	}

	public BigDecimal getSryue()
	{
		return isNull(sryue);
	}

	public void setSryue(BigDecimal sryue)
	{
		this.sryue = sryue;
	}

	public BigDecimal getZcmoney()
	{
		return isNull(zcmoney);
	}

	public void setZcmoney(BigDecimal zcmoney)
	{
		this.zcmoney = zcmoney;
	}

	public BigDecimal getZcka()
	{
		return isNull(zcka);
	}

	public void setZcka(BigDecimal zcka)
	{
		this.zcka = zcka;
	}

	public BigDecimal getZcbank()
	{
		return isNull(zcbank);
	}

	public void setZcbank(BigDecimal zcbank)
	{
		this.zcbank = zcbank;
	}

	public BigDecimal getZcchengdui()
	{
		return isNull(zcchengdui);
	}

	public void setZcchengdui(BigDecimal zcchengdui)
	{
		this.zcchengdui = zcchengdui;
	}

	public BigDecimal getZcday()
	{
		return isNull(zcday);
	}

	public void setZcday(BigDecimal zcday)
	{
		this.zcday = zcday;
	}

	public BigDecimal getZcyue()
	{
		return isNull(zcyue);
	}

	public void setZcyue(BigDecimal zcyue)
	{
		this.zcyue = zcyue;
	}

	public BigDecimal getQmdata()
	{
		return isNull(qmdata);
	}

	public void setQmdata(BigDecimal qmdata)
	{
		this.qmdata = qmdata;
	}

}
