package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Purrequisition implements Serializable{
	private Integer purchaseRequisitionID;
	private Integer intemInformationID;
	private String itemCode;
	private String chineseName;
	private String articleBarCode;
	private String purchaseSpecifications;
	private String purchasingUnit;
	private Integer currentStock;
    private String applicationNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastProcessingTime;
    private String commitName;
    private String lastName;
    private String createName;
    private String explains;
    private String status;
    private String remarks;
    private String materialMaterial;
	private String warehouseName;
	private String organizationName;
    private Integer number;
    private Integer pNumber;
    public Purrequisition(){
    	
    }
	public Purrequisition(Integer intemInformationID,Integer purchaseRequisitionID, String itemCode, String chineseName, String articleBarCode,
			String purchaseSpecifications, String purchasingUnit, Integer currentStock, String applicationNo,
			Date createdate, Date lastDate, Date lastProcessingTime, String commitName, String lastName,
			String createName, String explains, String status, String remarks, String materialMaterial,
			String warehouseName, String organizationName, Integer number, Integer pNumber) {
		this.intemInformationID =intemInformationID;
		this.purchaseRequisitionID = purchaseRequisitionID;
		this.itemCode = itemCode;
		this.chineseName = chineseName;
		this.articleBarCode = articleBarCode;
		this.purchaseSpecifications = purchaseSpecifications;
		this.purchasingUnit = purchasingUnit;
		this.currentStock = currentStock;
		this.applicationNo = applicationNo;
		this.createdate = createdate;
		this.lastDate = lastDate;
		this.lastProcessingTime = lastProcessingTime;
		this.commitName = commitName;
		this.lastName = lastName;
		this.createName = createName;
		this.explains = explains;
		this.status = status;
		this.remarks = remarks;
		this.materialMaterial = materialMaterial;
		this.warehouseName = warehouseName;
		this.organizationName = organizationName;
		this.number = number;
		this.pNumber = pNumber;
	}
	public Integer getIntemInformationID() {
		return intemInformationID;
	}
	public void setIntemInformationID(Integer intemInformationID) {
		this.intemInformationID = intemInformationID;
	}
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getArticleBarCode() {
		return articleBarCode;
	}

	public void setArticleBarCode(String articleBarCode) {
		this.articleBarCode = articleBarCode;
	}

	public String getPurchaseSpecifications() {
		return purchaseSpecifications;
	}

	public void setPurchaseSpecifications(String purchaseSpecifications) {
		this.purchaseSpecifications = purchaseSpecifications;
	}

	public String getPurchasingUnit() {
		return purchasingUnit;
	}

	public void setPurchasingUnit(String purchasingUnit) {
		this.purchasingUnit = purchasingUnit;
	}

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public Integer getPurchaseRequisitionID() {
		return purchaseRequisitionID;
	}
	public void setPurchaseRequisitionID(Integer purchaseRequisitionID) {
		this.purchaseRequisitionID = purchaseRequisitionID;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Date getLastProcessingTime() {
		return lastProcessingTime;
	}
	public void setLastProcessingTime(Date lastProcessingTime) {
		this.lastProcessingTime = lastProcessingTime;
	}
	public String getCommitName() {
		return commitName;
	}
	public void setCommitName(String commitName) {
		this.commitName = commitName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getpNumber() {
		return pNumber;
	}
	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}
	
}