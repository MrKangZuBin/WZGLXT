package com.kang.pojo;

import java.io.Serializable;

public class PurchaseOrder_itemInformation implements Serializable{
    private Integer id;

    private Integer purchaseorderid;

    private Integer iteminformationid;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseorderid() {
        return purchaseorderid;
    }

    public void setPurchaseorderid(Integer purchaseorderid) {
        this.purchaseorderid = purchaseorderid;
    }


    public Integer getIteminformationid() {
        return iteminformationid;
    }

    public void setIteminformationid(Integer iteminformationid) {
        this.iteminformationid = iteminformationid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}