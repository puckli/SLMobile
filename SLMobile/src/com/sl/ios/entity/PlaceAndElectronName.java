package com.sl.ios.entity;

import java.io.Serializable;

public class PlaceAndElectronName implements java.io.Serializable {
			//三联单id
			private Integer sldId;
			//审批的职位
			private String auditingPlace;
			//审批人（电子签名）
			private String auditingPeople;
			//审批的名字
			private String auditingName;
			//是否是代理人
			private String isProxy;
			
			public Integer getSldId() {
				return sldId;
			}
			public void setSldId(Integer sldId) {
				this.sldId = sldId;
			}
			public String getAuditingPlace() {
				return auditingPlace;
			}
			public void setAuditingPlace(String auditingPlace) {
				this.auditingPlace = auditingPlace;
			}
			public String getAuditingPeople() {
				return auditingPeople;
			}
			public void setAuditingPeople(String auditingPeople) {
				this.auditingPeople = auditingPeople;
			}
			public String getAuditingName() {
				return auditingName;
			}
			public void setAuditingName(String auditingName) {
				this.auditingName = auditingName;
			}
			public String getIsProxy() {
				return isProxy;
			}
			public void setIsProxy(String isProxy) {
				this.isProxy = isProxy;
			}
			
		
}
