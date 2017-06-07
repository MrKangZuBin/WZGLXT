package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DcgPojo implements Serializable{
	private String applicationNo;
	private String itemCode;
	private String chineseName;
	private Integer number;
	private Integer pNumber;
	private String purchasingUnit;
	private String purchaseSpecifications;
	private String category;
	private String materialMaterial;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastDate;
	private String commitName;
	private String organizationName;
	private String explains;
	private String warehouseName;
	public DcgPojo(){
		
	}
	public DcgPojo(String applicationNo, String itemCode, String chineseName, Integer number, Integer pNumber,
			String purchasingUnit, String purchaseSpecifications, String category, String materialMaterial,
			Date createDate, Date lastDate, String commitName, String organizationName, String explains,
			String warehouseName) {
		this.applicationNo = applicationNo;
		this.itemCode = itemCode;
		this.chineseName = chineseName;
		this.number = number;
		this.pNumber = pNumber;
		this.purchasingUnit = purchasingUnit;
		this.purchaseSpecifications = purchaseSpecifications;
		this.category = category;
		this.materialMaterial = materialMaterial;
		this.createDate = createDate;
		this.lastDate = lastDate;
		this.commitName = commitName;
		this.organizationName = organizationName;
		this.explains = explains;
		this.warehouseName = warehouseName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getCommitName() {
		return commitName;
	}

	public void setCommitName(String commitName) {
		this.commitName = commitName;
	}
	public Integer getpNumber() {
		return pNumber;
	}
	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}
	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPurchasingUnit() {
		return purchasingUnit;
	}
	public void setPurchasingUnit(String purchasingUnit) {
		this.purchasingUnit = purchasingUnit;
	}
	public String getPurchaseSpecifications() {
		return purchaseSpecifications;
	}
	public void setPurchaseSpecifications(String purchaseSpecifications) {
		this.purchaseSpecifications = purchaseSpecifications;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMaterialMaterial() {
		return materialMaterial;
	}
	public void setMaterialMaterial(String materialMaterial) {
		this.materialMaterial = materialMaterial;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
}	
