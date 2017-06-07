package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class InventoryPoJo implements Serializable{

	private Integer inventoryid;
	private String inventorynumber;
	private String inventorydescription;
	private Integer inventoryinventory;
	private String status;
	private String warehousename;
	private Date lastModifiedTime;
	private String loginname;
	
	public InventoryPoJo(){}
	
	
	
	public InventoryPoJo(Integer inventoryid, String inventorynumber, String inventorydescription,
			Integer inventoryinventory, String status, String warehousename, Date lastModifiedTime, String loginname) {
		this.inventoryid = inventoryid;
		this.inventorynumber = inventorynumber;
		this.inventorydescription = inventorydescription;
		this.inventoryinventory = inventoryinventory;
		this.status = status;
		this.warehousename = warehousename;
		this.lastModifiedTime = lastModifiedTime;
		this.loginname = loginname;
	}



	public Integer getInventoryid() {
		return inventoryid;
	}
	public void setInventoryid(Integer inventoryid) {
		this.inventoryid = inventoryid;
	}
	public String getInventorynumber() {
		return inventorynumber;
	}
	public void setInventorynumber(String inventorynumber) {
		this.inventorynumber = inventorynumber;
	}
	public String getInventorydescription() {
		return inventorydescription;
	}
	public void setInventorydescription(String inventorydescription) {
		this.inventorydescription = inventorydescription;
	}
	public Integer getInventoryinventory() {
		return inventoryinventory;
	}
	public void setInventoryinventory(Integer inventoryinventory) {
		this.inventoryinventory = inventoryinventory;
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
	
	
	
	
}
