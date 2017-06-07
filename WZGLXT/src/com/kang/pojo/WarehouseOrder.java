package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class WarehouseOrder implements Serializable{
    private Integer purchaseordereid;

    private String warehousenumber;

    private Integer buyerid;

    private Integer warehouseid;

    private String companytelephone;

    private String address;

    private Integer supplierid;

    private String company;

    private Date createtime;

    private Date finalprocessingtime;

    private Integer createpersonid;

    private Integer lastpersonid;

    public Integer getPurchaseordereid() {
        return purchaseordereid;
    }

    public void setPurchaseordereid(Integer purchaseordereid) {
        this.purchaseordereid = purchaseordereid;
    }

    public String getWarehousenumber() {
        return warehousenumber;
    }

    public void setWarehousenumber(String warehousenumber) {
        this.warehousenumber = warehousenumber == null ? null : warehousenumber.trim();
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public Integer getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Integer warehouseid) {
        this.warehouseid = warehouseid;
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

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
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