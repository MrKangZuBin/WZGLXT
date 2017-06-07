package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Inventory implements Serializable{
    private Integer inventoryid;

    private String inventorynumber;

    private Integer warehouseid;

    private String status;

    private String inventorydescription;

    private String remarks;

    private Integer createpersonid;

    private Date createdate;

    private Integer lastmodifiedid;

    private Date lastmodifiedtime;

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
        this.inventorynumber = inventorynumber == null ? null : inventorynumber.trim();
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

    public String getInventorydescription() {
        return inventorydescription;
    }

    public void setInventorydescription(String inventorydescription) {
        this.inventorydescription = inventorydescription == null ? null : inventorydescription.trim();
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