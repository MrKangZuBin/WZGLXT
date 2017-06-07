package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable{
    private Integer shopid;

    private String storecode;

    private String annexname;

    private String annexpath;

    private String companytelephone;

    private String address;

    private String description;

    private Integer companyid;

    private Date createtime;

    private Date finalprocessingtime;

    private Integer createpersonid;

    private Integer lastpersonid;

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getStorecode() {
        return storecode;
    }

    public void setStorecode(String storecode) {
        this.storecode = storecode == null ? null : storecode.trim();
    }

    public String getAnnexname() {
        return annexname;
    }

    public void setAnnexname(String annexname) {
        this.annexname = annexname == null ? null : annexname.trim();
    }

    public String getAnnexpath() {
        return annexpath;
    }

    public void setAnnexpath(String annexpath) {
        this.annexpath = annexpath == null ? null : annexpath.trim();
    }

    public String getCompanytelephone() {
        return companytelephone;
    }

    public void setCompanytelephone(String companytelephone) {
        this.companytelephone = companytelephone == null ? null : companytelephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getFinalprocessingtime() {
        return finalprocessingtime;
    }

    public void setFinalprocessingtime(Date finalprocessingtime) {
        this.finalprocessingtime = finalprocessingtime;
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Integer getLastpersonid() {
        return lastpersonid;
    }

    public void setLastpersonid(Integer lastpersonid) {
        this.lastpersonid = lastpersonid;
    }
}