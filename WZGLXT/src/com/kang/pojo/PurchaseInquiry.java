package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class PurchaseInquiry implements Serializable{
    private Integer purchaseinquiryid;

    private String inquirynumber;

    private Date starttime;

    private Date endtime;

    private String status;

    private String inquirydescription;

    private String remarks;

    private String inquirytype;

    private Date latedeliverytime;

    private String tendertype;

    private Integer currencyid;

    private String taxrate;

    private String placeofdelivery;

    private String quotationtype;

    private Integer purchasingmanager;

    private Date createdate;

    private Integer lastmodifiedid;

    private Date lastmodifiedtime;

    public Integer getPurchaseinquiryid() {
        return purchaseinquiryid;
    }

    public void setPurchaseinquiryid(Integer purchaseinquiryid) {
        this.purchaseinquiryid = purchaseinquiryid;
    }

    public String getInquirynumber() {
        return inquirynumber;
    }

    public void setInquirynumber(String inquirynumber) {
        this.inquirynumber = inquirynumber == null ? null : inquirynumber.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getInquirydescription() {
        return inquirydescription;
    }

    public void setInquirydescription(String inquirydescription) {
        this.inquirydescription = inquirydescription == null ? null : inquirydescription.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getInquirytype() {
        return inquirytype;
    }

    public void setInquirytype(String inquirytype) {
        this.inquirytype = inquirytype == null ? null : inquirytype.trim();
    }

    public Date getLatedeliverytime() {
        return latedeliverytime;
    }

    public void setLatedeliverytime(Date latedeliverytime) {
        this.latedeliverytime = latedeliverytime;
    }

    public String getTendertype() {
        return tendertype;
    }

    public void setTendertype(String tendertype) {
        this.tendertype = tendertype == null ? null : tendertype.trim();
    }

    public Integer getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(Integer currencyid) {
        this.currencyid = currencyid;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate == null ? null : taxrate.trim();
    }

    public String getPlaceofdelivery() {
        return placeofdelivery;
    }

    public void setPlaceofdelivery(String placeofdelivery) {
        this.placeofdelivery = placeofdelivery == null ? null : placeofdelivery.trim();
    }

    public String getQuotationtype() {
        return quotationtype;
    }

    public void setQuotationtype(String quotationtype) {
        this.quotationtype = quotationtype == null ? null : quotationtype.trim();
    }

    public Integer getPurchasingmanager() {
        return purchasingmanager;
    }

    public void setPurchasingmanager(Integer purchasingmanager) {
        this.purchasingmanager = purchasingmanager;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getLastmodifiedid() {
        return lastmodifiedid;
    }

    public void setLastmodifiedid(Integer lastmodifiedid) {
        this.lastmodifiedid = lastmodifiedid;
    }

    public Date getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(Date lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }
}