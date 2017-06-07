package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class StoreWarning implements Serializable{
    private Integer storewarningid;

    private Integer shopid;

    private Integer iteminformationid;

    private String warningtype;

    private Integer status;

    private Date warningdate;

    private Integer personid;

    private Date processingtime;

    public Integer getStorewarningid() {
        return storewarningid;
    }

    public void setStorewarningid(Integer storewarningid) {
        this.storewarningid = storewarningid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public String getWarningtype() {
        return warningtype;
    }

    public void setWarningtype(String warningtype) {
        this.warningtype = warningtype == null ? null : warningtype.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getWarningdate() {
        return warningdate;
    }

    public void setWarningdate(Date warningdate) {
        this.warningdate = warningdate;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Date getProcessingtime() {
        return processingtime;
    }

    public void setProcessingtime(Date processingtime) {
        this.processingtime = processingtime;
    }
}