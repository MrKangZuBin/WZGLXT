package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Buyer implements Serializable{
    private Integer id;

    private String jobnumber;

    private String name;

    private String purchasingofficer;

    private Integer createpersonid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber == null ? null : jobnumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPurchasingofficer() {
        return purchasingofficer;
    }

    public void setPurchasingofficer(String purchasingofficer) {
        this.purchasingofficer = purchasingofficer == null ? null : purchasingofficer.trim();
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}