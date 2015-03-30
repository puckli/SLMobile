package com.sl.ios.entity;



/**
 * SanLianCeShi entity. @author MyEclipse Persistence Tools
 */

public class SanLianCeShi implements java.io.Serializable {

	// Fields
	private Integer sid;
	private String ts;
	private GongsiBak gongsiId;
	private Sldbm bumen;
	private String dykm;
	private String mxkm;
	private String jzh;
	private String zh;
	private String sfkdw;
	private Sldbz bizhong;
	private String piaohao;
	private String jine;
	private String zhaiyao;
	private String free1;
	private String free2;
	private String benbuid;
	private String status;
	private ULogin writePeople;
	private Sldjizi jizi;
	private String zi;
	private String isFinish;
	private Sldywlx ywlx;
	private String slddls;
	private String bakzi; 
	private Sldexamine sldExamine;
	private ULogin removePeople;
	private String sptime;
	private String printer;
	private String deleteTime;
	private String rushRed;
	private Integer callBackStatus;
	private String updateMarkStatus;
	private String currentMarkDate;
	private String fillMarkDate;
	private Integer newSLDId;
	private String benjin;
	private String feiyong;
	private String gaikuozhaiyao;
	private Integer editId;
	private Integer editExamineId;
	private Integer editStatus;
	private Integer invalidExId;
	private String invalidReason;
	private String appendixId;
	private Integer version;
	private Integer dr;
	private Integer readed;
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public GongsiBak getGongsiId() {
		return gongsiId;
	}
	public void setGongsiId(GongsiBak gongsiId) {
		this.gongsiId = gongsiId;
	}
	public Sldbm getBumen() {
		return bumen;
	}
	public void setBumen(Sldbm bumen) {
		this.bumen = bumen;
	}
	public String getDykm() {
		return dykm;
	}
	public void setDykm(String dykm) {
		this.dykm = dykm;
	}
	public String getMxkm() {
		return mxkm;
	}
	public void setMxkm(String mxkm) {
		this.mxkm = mxkm;
	}
	public String getJzh() {
		return jzh;
	}
	public void setJzh(String jzh) {
		this.jzh = jzh;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getSfkdw() {
		return sfkdw;
	}
	public void setSfkdw(String sfkdw) {
		this.sfkdw = sfkdw;
	}
	public Sldbz getBizhong() {
		return bizhong;
	}
	public void setBizhong(Sldbz bizhong) {
		this.bizhong = bizhong;
	}
	public String getPiaohao() {
		return piaohao;
	}
	public void setPiaohao(String piaohao) {
		this.piaohao = piaohao;
	}
	public String getJine() {
		return jine;
	}
	public void setJine(String jine) {
		this.jine = jine;
	}
	public String getZhaiyao() {
		return zhaiyao;
	}
	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}
	
	public String getFree1() {
		return free1;
	}
	public void setFree1(String free1) {
		this.free1 = free1;
	}
	public String getFree2() {
		return free2;
	}
	public void setFree2(String free2) {
		this.free2 = free2;
	}
	public String getBenbuid() {
		return benbuid;
	}
	public void setBenbuid(String benbuid) {
		this.benbuid = benbuid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ULogin getWritePeople() {
		return writePeople;
	}
	public void setWritePeople(ULogin writePeople) {
		this.writePeople = writePeople;
	}
	public Sldjizi getJizi() {
		return jizi;
	}
	public void setJizi(Sldjizi jizi) {
		this.jizi = jizi;
	}
	public String getZi() {
		return zi;
	}
	public void setZi(String zi) {
		this.zi = zi;
	}
	public String getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}
	public Sldywlx getYwlx() {
		return ywlx;
	}
	public void setYwlx(Sldywlx ywlx) {
		this.ywlx = ywlx;
	}
	
	public String getSlddls() {
		return slddls;
	}
	public void setSlddls(String slddls) {
		this.slddls = slddls;
	}
	public String getBakzi() {
		return bakzi;
	}
	public void setBakzi(String bakzi) {
		this.bakzi = bakzi;
	}

	public Sldexamine getSldExamine() {
		return sldExamine;
	}
	public void setSldExamine(Sldexamine sldExamine) {
		this.sldExamine = sldExamine;
	}
	public ULogin getRemovePeople() {
		return removePeople;
	}
	public void setRemovePeople(ULogin removePeople) {
		this.removePeople = removePeople;
	}
	
	public String getSptime() {
		return sptime;
	}
	public void setSptime(String sptime) {
		this.sptime = sptime;
	}
	
	public String getPrinter() {
		return printer;
	}
	public void setPrinter(String printer) {
		this.printer = printer;
	}
	public String getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getRushRed() {
		return rushRed;
	}
	public void setRushRed(String rushRed) {
		this.rushRed = rushRed;
	}
	
	public Integer getCallBackStatus() {
		return callBackStatus;
	}
	public void setCallBackStatus(Integer callBackStatus) {
		this.callBackStatus = callBackStatus;
	}
	public String getUpdateMarkStatus() {
		return updateMarkStatus;
	}
	public void setUpdateMarkStatus(String updateMarkStatus) {
		this.updateMarkStatus = updateMarkStatus;
	}
	public String getCurrentMarkDate() {
		return currentMarkDate;
	}
	public void setCurrentMarkDate(String currentMarkDate) {
		this.currentMarkDate = currentMarkDate;
	}
	public String getFillMarkDate() {
		return fillMarkDate;
	}
	public void setFillMarkDate(String fillMarkDate) {
		this.fillMarkDate = fillMarkDate;
	}
	public Integer getNewSLDId() {
		return newSLDId;
	}
	public void setNewSLDId(Integer newSLDId) {
		this.newSLDId = newSLDId;
	}
	
	public String getBenjin() {
		return benjin;
	}
	public void setBenjin(String benjin) {
		this.benjin = benjin;
	}
	public String getFeiyong() {
		return feiyong;
	}
	public void setFeiyong(String feiyong) {
		this.feiyong = feiyong;
	}
	public String getGaikuozhaiyao() {
		return gaikuozhaiyao;
	}
	public void setGaikuozhaiyao(String gaikuozhaiyao) {
		this.gaikuozhaiyao = gaikuozhaiyao;
	}
	public Integer getEditId() {
		return editId;
	}
	public void setEditId(Integer editId) {
		this.editId = editId;
	}
	public Integer getEditExamineId() {
		return editExamineId;
	}
	public void setEditExamineId(Integer editExamineId) {
		this.editExamineId = editExamineId;
	}
	public Integer getEditStatus() {
		return editStatus;
	}
	public void setEditStatus(Integer editStatus) {
		this.editStatus = editStatus;
	}
	
	public Integer getInvalidExId()
	{
		return invalidExId;
	}
	public void setInvalidExId(Integer invalidExId)
	{
		this.invalidExId = invalidExId;
	}
	public String getInvalidReason()
	{
		return invalidReason;
	}
	public void setInvalidReason(String invalidReason)
	{
		this.invalidReason = invalidReason;
	}
	
	public String getAppendixId() {
		return appendixId;
	}
	public void setAppendixId(String appendixId) {
		this.appendixId = appendixId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getDr() {
		return dr;
	}
	public void setDr(Integer dr) {
		this.dr = dr;
	}
	public Integer getReaded()
	{
		return readed;
	}
	public void setReaded(Integer readed)
	{
		this.readed = readed;
	}

}