package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseOrder implements Serializable {
	private Integer purchaseorderid;
	
	private Integer warehousemanagementid;
	
	private String ordernumber;

	private String billsource;

	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date committime;

	private Integer submitterid;

	private Integer companyid;

	private Integer supplierid;

	private String remarks;

	private String speaking;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdate;

	private Integer createpersonid;
	
	private List<PurOrderReport> pur;
	
	private Integer money;

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public List<PurOrderReport> getPur() {
		return pur;
	}

	public void setPur(List<PurOrderReport> pur) {
		this.pur = pur;
	}

	private Integer lastmodifiedid;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastmodifiedtime;

	public String getSpeaking() {
		return speaking;
	}

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	public Integer getPurchaseorderid() {
		return purchaseorderid;
	}

	public void setPurchaseorderid(Integer purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber == null ? null : ordernumber.trim();
	}

	public String getBillsource() {
		return billsource;
	}

	public void setBillsource(String billsource) {
		this.billsource = billsource == null ? null : billsource.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getCommittime() {
		return committime;
	}

	public void setCommittime(Date committime) {
		this.committime = committime;
	}

	public Integer getSubmitterid() {
		return submitterid;
	}

	public void setSubmitterid(Integer submitterid) {
		this.submitterid = submitterid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getCreatepersonid() {
		return createpersonid;
	}

	public void setCreatepersonid(Integer createpersonid) {
		this.createpersonid = createpersonid;
	}

	public Integer getLastmodifiedid() {
		return lastmodifiedid;
	}

	public void setLastmodifiedid(Integer lastmodifiedid) {
		this.lastmodifiedid = lastmodifiedid;
	}

	public Date getLastmodifiedtime() {
		return lastmodifiedtime;
	}

	public void setLastmodifiedtime(Date lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}

	public Integer getWarehousemanagementid() {
		return warehousemanagementid;
	}

	public void setWarehousemanagementid(Integer warehousemanagementid) {
		this.warehousemanagementid = warehousemanagementid;
	}
}