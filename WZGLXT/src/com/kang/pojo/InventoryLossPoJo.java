package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class InventoryLossPoJo implements Serializable{

	private Integer inventorylossid;
	private String lossnumber;
	private String lossdescription;
	private Integer numberrs;
	private String status;
	private String warehousename;
	private Date lastModifiedTime;
	private String loginname;
	
	public InventoryLossPoJo(){}

	public Integer getInventorylossid() {
		return inventorylossid;
	}

	public void setInventorylossid(Integer inventorylossid) {
		this.inventorylossid = inventorylossid;
	}

	public String getLossnumber() {
		return lossnumber;
	}

	public void setLossnumber(String lossnumber) {
		this.lossnumber = lossnumber;
	}

	public String getLossdescription() {
		return lossdescription;
	}

	public void setLossdescription(String lossdescription) {
		this.lossdescription = lossdescription;
	}

	public Integer getNumberrs() {
		return numberrs;
	}

	public void setNumberrs(Integer numberrs) {
		this.numberrs = numberrs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public InventoryLossPoJo(Integer inventorylossid, String lossnumber, String lossdescription, Integer numberrs,
			String status, String warehousename, Date lastModifiedTime, String loginname) {
		this.inventorylossid = inventorylossid;
		this.lossnumber = lossnumber;
		this.lossdescription = lossdescription;
		this.numberrs = numberrs;
		this.status = status;
		this.warehousename = warehousename;
		this.lastModifiedTime = lastModifiedTime;
		this.loginname = loginname;
	}
	
	
	
	
}
