package com.kang.pojo;

import java.io.Serializable;

public class PurchaseInquiry_itemInformation implements Serializable{
    private Integer id;

    private Integer purchaseinquiryid;

    private Integer iteminformationid;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseinquiryid() {
        return purchaseinquiryid;
    }

    public void setPurchaseinquiryid(Integer purchaseinquiryid) {
        this.purchaseinquiryid = purchaseinquiryid;
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