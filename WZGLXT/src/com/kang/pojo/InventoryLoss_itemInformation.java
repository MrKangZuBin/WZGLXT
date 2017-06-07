package com.kang.pojo;

import java.io.Serializable;

public class InventoryLoss_itemInformation implements Serializable{
    private Integer id;

    private Integer inventorylossid;

    private Integer warehouseid;

    private Integer iteminformationid;

    private Integer lossnumber;

    private String lossreason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventorylossid() {
        return inventorylossid;
    }

    public void setInventorylossid(Integer inventorylossid) {
        this.inventorylossid = inventorylossid;
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

    public Integer getLossnumber() {
        return lossnumber;
    }

    public void setLossnumber(Integer lossnumber) {
        this.lossnumber = lossnumber;
    }

    public String getLossreason() {
        return lossreason;
    }

    public void setLossreason(String lossreason) {
        this.lossreason = lossreason == null ? null : lossreason.trim();
    }
}