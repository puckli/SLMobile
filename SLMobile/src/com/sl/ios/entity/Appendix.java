package com.sl.ios.entity;



/**
 * Appendix entity. @author MyEclipse Persistence Tools
 */

public class Appendix  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String sldId;
     private String appendixName;
     private String uploadName;
     private Integer dr;


    // Constructors

    /** default constructor */
    public Appendix() {
    }

    
    /** full constructor */
    public Appendix(String sldId, String appendixName, Integer dr) {
        this.sldId = sldId;
        this.appendixName = appendixName;
        this.dr = dr;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSldId() {
        return this.sldId;
    }
    
    public void setSldId(String sldId) {
        this.sldId = sldId;
    }

    public String getAppendixName() {
        return this.appendixName;
    }
    
    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }

    public String getUploadName() {
		return uploadName;
	}


	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}


	public Integer getDr() {
        return this.dr;
    }
    
    public void setDr(Integer dr) {
        this.dr = dr;
    }
   








}