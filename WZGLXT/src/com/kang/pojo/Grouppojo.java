package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Grouppojo implements Serializable {
	private Integer purchaseOrderID;
	private Integer intemInformationID;
	private String orderNumber;
	private String billSource;
	private String materialMaterial;
	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date commitTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	private String itemCode;
	private String chineseName;
	private String articleBarCode;
	private String purchaseSpecifications;
	private String purchasingUnit;
	private Integer number;
	private String commitName;
	private String createName;
	private String warehouseName;
	private String supplierName;
	private String supplierCode;
	private Integer pNumber;
	private String speaking;
	private String remarks;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastModifiedTime;
	private String lastName;
	public Grouppojo(){
		
	}
	public Grouppojo(Integer purchaseOrderID, Integer intemInformationID, String orderNumber, String billSource,
			String materialMaterial, String status, Date commitTime, Date createDate, String itemCode,
			String chineseName, String articleBarCode, String purchaseSpecifications, String purchasingUnit,
			Integer number, String commitName, String createName, String warehouseName, String supplierName,
			String supplierCode, Integer pNumber, String speaking, String remarks, Date lastModifiedTime,
			String lastName) {
		this.purchaseOrderID = purchaseOrderID;
		this.intemInformationID = intemInformationID;
		this.orderNumber = orderNumber;
		this.billSource = billSource;
		this.materialMaterial = materialMaterial;
		this.status = status;
		this.commitTime = commitTime;
		this.createDate = createDate;
		this.itemCode = itemCode;
		this.chineseName = chineseName;
		this.articleBarCode = articleBarCode;
		this.purchaseSpecifications = purchaseSpecifications;
		this.purchasingUnit = purchasingUnit;
		this.number = number;
		this.commitName = commitName;
		this.createName = createName;
		this.warehouseName = warehouseName;
		this.supplierName = supplierName;
		this.supplierCode = supplierCode;
		this.pNumber = pNumber;
		this.speaking = speaking;
		this.remarks = remarks;
		this.lastModifiedTime = lastModifiedTime;
		this.lastName = lastName;
	}

	public Integer getIntemInformationID() {
		return intemInformationID;
	}

	public void setIntemInformationID(Integer intemInformationID) {
		this.intemInformationID = intemInformationID;
	}

	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getPurchaseOrderID() {
		return purchaseOrderID;
	}
	public void setPurchaseOrderID(Integer purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getBillSource() {
		return billSource;
	}
	public void setBillSource(String billSource) {
		this.billSource = billSource;
	}
	public String getMaterialMaterial() {
		return materialMaterial;
	}
	public void setMaterialMaterial(String materialMaterial) {
		this.materialMaterial = materialMaterial;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCommitName() {
		return commitName;
	}
	public void setCommitName(String commitName) {
		this.commitName = commitName;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public Integer getpNumber() {
		return pNumber;
	}
	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}
	public String getSpeaking() {
		return speaking;
	}
	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
