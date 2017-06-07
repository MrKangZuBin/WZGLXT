package com.kang.pojo;

import java.io.Serializable;

public class WarehouseManagement_itemInformation2 implements Serializable{
    private Integer id;

    private Integer purchaserequisitionid;

    private Integer warehousemanagementid;
    
    private Integer inventoryLocationid;

    public Integer getPurchaserequisitionid() {
		return purchaserequisitionid;
	}

	public void setPurchaserequisitionid(Integer purchaserequisitionid) {
		this.purchaserequisitionid = purchaserequisitionid;
	}

	public Integer getInventoryLocationid() {
		return inventoryLocationid;
	}

	public void setInventoryLocationid(Integer inventoryLocationid) {
		this.inventoryLocationid = inventoryLocationid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehousemanagementid() {
        return warehousemanagementid;
    }

    public void setWarehousemanagementid(Integer warehousemanagementid) {
        this.warehousemanagementid = warehousemanagementid;
    }
}