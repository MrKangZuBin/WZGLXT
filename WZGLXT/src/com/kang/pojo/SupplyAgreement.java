package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class SupplyAgreement implements Serializable{
    private Integer supplyagreementid;

    private String protocolcode;

    private Integer supplierid;

    private Integer companyid;

    private String protocolexplain;

    private Date starttime;

    private Date endtime;
    
    private String starttimestr;

    private String endtimestr;

    public String getStarttimestr() {
		return starttimestr;
	}

	public void setStarttimestr(String starttimestr) {
		this.starttimestr = starttimestr;
	}

	public String getEndtimestr() {
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}

	private String protocostatus;

    private String protocoenclosure;

    private Date createdate;

    private Date lastprocessingtime;

    private Integer createpersonid;

    private Integer lastpersonid;

    public Integer getSupplyagreementid() {
        return supplyagreementid;
    }

    public void setSupplyagreementid(Integer supplyagreementid) {
        this.supplyagreementid = supplyagreementid;
    }

    public String getProtocolcode() {
        return protocolcode;
    }

    public void setProtocolcode(String protocolcode) {
        this.protocolcode = protocolcode == null ? null : protocolcode.trim();
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getProtocolexplain() {
        return protocolexplain;
    }

    public void setProtocolexplain(String protocolexplain) {
        this.protocolexplain = protocolexplain == null ? null : protocolexplain.trim();
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

    public String getProtocostatus() {
        return protocostatus;
    }

    public void setProtocostatus(String protocostatus) {
        this.protocostatus = protocostatus == null ? null : protocostatus.trim();
    }

    public String getProtocoenclosure() {
        return protocoenclosure;
    }

    public void setProtocoenclosure(String protocoenclosure) {
        this.protocoenclosure = protocoenclosure == null ? null : protocoenclosure.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastprocessingtime() {
        return lastprocessingtime;
    }

    public void setLastprocessingtime(Date lastprocessingtime) {
        this.lastprocessingtime = lastprocessingtime;
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