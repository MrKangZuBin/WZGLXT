package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReturnGoodsLibrary implements Serializable{
    private Integer returngoodslibraryid;

    private String returnnumber;

    private Integer returnrequestid;

    private Integer supplierid;

    private Integer warehouseid;

    private String status;

    private String librarydescription;

    private String remarks;

    private Integer createpersonid;

    private Date createdate;

    private Integer lastmodifiedid;

    private Date lastmodifiedtime;

    public Integer getReturngoodslibraryid() {
        return returngoodslibraryid;
    }

    public void setReturngoodslibraryid(Integer returngoodslibraryid) {
        this.returngoodslibraryid = returngoodslibraryid;
    }

    public String getReturnnumber() {
        return returnnumber;
    }

    public void setReturnnumber(String returnnumber) {
        this.returnnumber = returnnumber == null ? null : returnnumber.trim();
    }

    public Integer getReturnrequestid() {
        return returnrequestid;
    }

    public void setReturnrequestid(Integer returnrequestid) {
        this.returnrequestid = returnrequestid;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
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

    public String getLibrarydescription() {
        return librarydescription;
    }

    public void setLibrarydescription(String librarydescription) {
        this.librarydescription = librarydescription == null ? null : librarydescription.trim();
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