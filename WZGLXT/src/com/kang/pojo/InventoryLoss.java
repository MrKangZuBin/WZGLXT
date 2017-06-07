package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class InventoryLoss implements Serializable{
    private Integer inventorylossid;

    private String lossnumber;

    private Integer warehouseid;

    private String status;

    private String lossdescription;

    private String remarks;

    private Integer createpersonid;

    private Date createdate;

    private Integer lastmodifiedid;

    private Date lastmodifiedtime;

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
        this.lossnumber = lossnumber == null ? null : lossnumber.trim();
    }

    public Integer getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Integer warehouseid) {
        this.warehouseid = warehouseid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLossdescription() {
        return lossdescription;
    }

    public void setLossdescription(String lossdescription) {
        this.lossdescription = lossdescription == null ? null : lossdescription.trim();
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