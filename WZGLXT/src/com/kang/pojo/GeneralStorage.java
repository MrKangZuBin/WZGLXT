package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class GeneralStorage implements Serializable{
    private Integer generalstorageid;

    private String warehousenumber;

    private Integer purchaserid;

    private Integer warehouseid;

    private String storageinstructions;

    private String remarks;

    private Integer createpersonid;

    private Date createdate;

    private Integer lastmodifiedid;

    private Date lastmodifiedtime;

    public Integer getGeneralstorageid() {
        return generalstorageid;
    }

    public void setGeneralstorageid(Integer generalstorageid) {
        this.generalstorageid = generalstorageid;
    }

    public String getWarehousenumber() {
        return warehousenumber;
    }

    public void setWarehousenumber(String warehousenumber) {
        this.warehousenumber = warehousenumber == null ? null : warehousenumber.trim();
    }

    public Integer getPurchaserid() {
        return purchaserid;
    }

    public void setPurchaserid(Integer purchaserid) {
        this.purchaserid = purchaserid;
    }

    public Integer getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Integer warehouseid) {
        this.warehouseid = warehouseid;
    }

    public String getStorageinstructions() {
        return storageinstructions;
    }

    public void setStorageinstructions(String storageinstructions) {
        this.storageinstructions = storageinstructions == null ? null : storageinstructions.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
}