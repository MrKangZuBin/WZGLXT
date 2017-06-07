package com.kang.pojo;

import java.io.Serializable;

public class SupplyAgreement_itemInformation implements Serializable{
    private Integer id;

    private Integer supplyagreementid;

    private Integer iteminformationid;

    private Long purchaseprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplyagreementid() {
        return supplyagreementid;
    }

    public void setSupplyagreementid(Integer supplyagreementid) {
        this.supplyagreementid = supplyagreementid;
    }

    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Long getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Long purchaseprice) {
        this.purchaseprice = purchaseprice;
    }
}