package com.kang.pojo;

import java.io.Serializable;

public class PurchaseInquiry_supplier implements Serializable{
    private Integer id;

    private Integer purchaseinquiryid;

    private Integer supplierid;

    private String quotestate;

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

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public String getQuotestate() {
        return quotestate;
    }

    public void setQuotestate(String quotestate) {
        this.quotestate = quotestate == null ? null : quotestate.trim();
    }
}