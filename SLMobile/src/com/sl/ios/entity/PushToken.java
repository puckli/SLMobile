package com.sl.ios.entity;


public class PushToken  implements java.io.Serializable {

     private Integer id;
     private String uid;
     private String uname;
     private String device;
     private String token;
     private Integer dr;


    public PushToken() {
    }

    public PushToken(Integer id) {
        this.id = id;
    }
    
    public PushToken(Integer id, String uid, String uname, String device, String token, Integer dr) {
        this.id = id;
        this.uid = uid;
        this.uname = uname;
        this.device = device;
        this.token = token;
        this.dr = dr;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getDevice() {
        return this.device;
    }
    
    public void setDevice(String device) {
        this.device = device;
    }

    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    public Integer getDr() {
        return this.dr;
    }
    
    public void setDr(Integer dr) {
        this.dr = dr;
    }

}