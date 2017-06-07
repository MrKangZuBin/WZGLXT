package com.kang.pojo;

import java.io.Serializable;

public class PurchaseRequisition_itemInformation implements Serializable{
    private Integer id;

    private Integer purchaserequisitionid;

    private Integer iteminformationid;

    private Integer number;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaserequisitionid() {
        return purchaserequisitionid;
    }

    public void setPurchaserequisitionid(Integer purchaserequisitionid) {
        this.purchaserequisitionid = purchaserequisitionid;
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