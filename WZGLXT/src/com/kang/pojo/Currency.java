package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Currency implements Serializable{
    private Integer currencyid;

    private String chinesename;

    private String englishname;

    private String exchangeratermb;

    private String status;

    private Date createdate;

    private Integer createpersonid;

    public Integer getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(Integer currencyid) {
        this.currencyid = currencyid;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename == null ? null : chinesename.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public String getExchangeratermb() {
        return exchangeratermb;
    }

    public void setExchangeratermb(String exchangeratermb) {
        this.exchangeratermb = exchangeratermb == null ? null : exchangeratermb.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
    }
}