package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable{
    private Integer organizationid;

    private String organizationname;

    private Integer firstid;

    private Integer secondid;

    private String whetherdisabled;

    private Date createtime;

    private Integer createpersonid;

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    public Integer getFirstid() {
        return firstid;
    }

    public void setFirstid(Integer firstid) {
        this.firstid = firstid;
    }

    public Integer getSecondid() {
        return secondid;
    }

    public void setSecondid(Integer secondid) {
        this.secondid = secondid;
    }

    public String getWhetherdisabled() {
        return whetherdisabled;
    }

    public void setWhetherdisabled(String whetherdisabled) {
        this.whetherdisabled = whetherdisabled == null ? null : whetherdisabled.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }
}