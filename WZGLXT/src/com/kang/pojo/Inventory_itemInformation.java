package com.kang.pojo;

import java.io.Serializable;

public class Inventory_itemInformation implements Serializable{
    private Integer id;

    private Integer inventoryid;

    private Integer warehouseid;

    private Integer iteminformationid;

    private Integer inventoryinventory;

    private Integer profitlossnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Integer getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Integer warehouseid) {
        this.warehouseid = warehouseid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getInventoryinventory() {
        return inventoryinventory;
    }

    public void setInventoryinventory(Integer inventoryinventory) {
        this.inventoryinventory = inventoryinventory;
    }

    public Integer getProfitlossnumber() {
        return profitlossnumber;
    }

    public void setProfitlossnumber(Integer profitlossnumber) {
        this.profitlossnumber = profitlossnumber;
    }
}