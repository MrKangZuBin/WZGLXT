package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RequestPojo implements Serializable{
	private Integer returnRequestID;
	private Integer intemInformationID;
	private String applicationNo;
	private String returnPolicy;
	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date commitTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastModifiedTime;
	private String commitName;
	private String createName;
	private String lastUpdateName;
	private String materialMaterial;
	private String warehouseName;
	private String orgName;
	private Integer number;
	private String itemcode;
	private String articlebarcode;
	private String chineseName;
	private String purchasespecifications;
	private String purchasingunit;
	private Integer pNumber;
	public RequestPojo(){
		
	}
	public RequestPojo(Integer returnRequestID, Integer intemInformationID, String applicationNo, String returnPolicy,
			String status, Date commitTime, Date createDate, Date lastModifiedTime, String commitName,
			String createName, String lastUpdateName, String materialMaterial, String warehouseName, String orgName,
			Integer number, String itemcode, String articlebarcode, String chineseName, String purchasespecifications,
			String purchasingunit, Integer pNumber) {
		this.returnRequestID = returnRequestID;
		this.intemInformationID = intemInformationID;
		this.applicationNo = applicationNo;
		this.returnPolicy = returnPolicy;
		this.status = status;
		this.commitTime = commitTime;
		this.createDate = createDate;
		this.lastModifiedTime = lastModifiedTime;
		this.commitName = commitName;
		this.createName = createName;
		this.lastUpdateName = lastUpdateName;
		this.materialMaterial = materialMaterial;
		this.warehouseName = warehouseName;
		this.orgName = orgName;
		this.number = number;
		this.itemcode = itemcode;
		this.articlebarcode = articlebarcode;
		this.chineseName = chineseName;
		this.purchasespecifications = purchasespecifications;
		this.purchasingunit = purchasingunit;
		this.pNumber = pNumber;
	}


	public Integer getIntemInformationID() {
		return intemInformationID;
	}


	public void setIntemInformationID(Integer intemInformationID) {
		this.intemInformationID = intemInformationID;
	}


	public Integer getpNumber() {
		return pNumber;
	}
	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getArticlebarcode() {
		return articlebarcode;
	}

	public void setArticlebarcode(String articlebarcode) {
		this.articlebarcode = articlebarcode;
	}

	public String getPurchasespecifications() {
		return purchasespecifications;
	}

	public void setPurchasespecifications(String purchasespecifications) {
		this.purchasespecifications = purchasespecifications;
	}

	public String getPurchasingunit() {
		return purchasingunit;
	}

	public void setPurchasingunit(String purchasingunit) {
		this.purchasingunit = purchasingunit;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getLastUpdateName() {
		return lastUpdateName;
	}

	public void setLastUpdateName(String lastUpdateName) {
		this.lastUpdateName = lastUpdateName;
	}

	public Integer getReturnRequestID() {
		return returnRequestID;
	}
	public void setReturnRequestID(Integer returnRequestID) {
		this.returnRequestID = returnRequestID;
	}
	public String getMaterialMaterial() {
		return materialMaterial;
	}
	public void setMaterialMaterial(String materialMaterial) {
		this.materialMaterial = materialMaterial;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommitName() {
		return commitName;
	}
	public void setCommitName(String commitName) {
		this.commitName = commitName;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getReturnPolicy() {
		return returnPolicy;
	}
	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}
	public Date getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
