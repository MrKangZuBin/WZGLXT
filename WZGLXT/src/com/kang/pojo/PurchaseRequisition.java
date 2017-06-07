package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class PurchaseRequisition implements Serializable{
	private Integer purchaserequisitionid;

    private String applicationno;

    private Integer applicantid;

    private Integer companyid;

    private Integer deptid;

    private String status;

    private String explains;

    private String remarks;

    private String placeofdelivery;

    private Date createdate;

    private Integer lastpersonid;

    private Date lastprocessingtime;

    public Integer getPurchaserequisitionid() {
        return purchaserequisitionid;
    }

    public void setPurchaserequisitionid(Integer purchaserequisitionid) {
        this.purchaserequisitionid = purchaserequisitionid;
    }

    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno == null ? null : applicationno.trim();
    }

    public Integer getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(Integer applicantid) {
        this.applicantid = applicantid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains == null ? null : explains.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPlaceofdelivery() {
        return placeofdelivery;
    }

    public void setPlaceofdelivery(String placeofdelivery) {
        this.placeofdelivery = placeofdelivery == null ? null : placeofdelivery.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getLastpersonid() {
        return lastpersonid;
    }

    public void setLastpersonid(Integer lastpersonid) {
        this.lastpersonid = lastpersonid;
    }

    public Date getLastprocessingtime() {
        return lastprocessingtime;
    }

    public void setLastprocessingtime(Date lastprocessingtime) {
        this.lastprocessingtime = lastprocessingtime;
    }
}