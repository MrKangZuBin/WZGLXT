package com.kang.pojo;

import java.io.Serializable;

public class Warehouse_itemInformation implements Serializable{
    private Integer id;

    private Integer purchaseordereid;

    private Integer inventorylocationid;

    private Integer iteminformationid;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseordereid() {
        return purchaseordereid;
    }

    public void setPurchaseordereid(Integer purchaseordereid) {
        this.purchaseordereid = purchaseordereid;
    }

    public Integer getInventorylocationid() {
        return inventorylocationid;
    }

    public void setInventorylocationid(Integer inventorylocationid) {
        this.inventorylocationid = inventorylocationid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}