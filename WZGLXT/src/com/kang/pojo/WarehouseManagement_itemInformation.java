package com.kang.pojo;

import java.io.Serializable;

public class WarehouseManagement_itemInformation implements Serializable{
    private Integer id;

    private Integer iteminformationid;

    private Integer warehousemanagementid;
    
    private Integer inventoryLocationid;

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

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getWarehousemanagementid() {
        return warehousemanagementid;
    }

    public void setWarehousemanagementid(Integer warehousemanagementid) {
        this.warehousemanagementid = warehousemanagementid;
    }
}