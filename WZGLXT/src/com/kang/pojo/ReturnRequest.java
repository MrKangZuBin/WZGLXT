package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReturnRequest implements Serializable{
    private Integer returnrequestid;

    private String applicationno;

    private String status;

    private Integer submitterid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date committime;

    private Integer companyid;

    private String returnpolicy;

    private String remarks;

    private Integer createpersonid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;

    private Integer lastmodifiedid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastmodifiedtime;

    public Integer getReturnrequestid() {
        return returnrequestid;
    }

    public void setReturnrequestid(Integer returnrequestid) {
        this.returnrequestid = returnrequestid;
    }

    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno == null ? null : applicationno.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSubmitterid() {
        return submitterid;
    }

    public void setSubmitterid(Integer submitterid) {
        this.submitterid = submitterid;
    }

    public Date getCommittime() {
        return committime;
    }

    public void setCommittime(Date committime) {
        this.committime = committime;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getReturnpolicy() {
        return returnpolicy;
    }

    public void setReturnpolicy(String returnpolicy) {
        this.returnpolicy = returnpolicy == null ? null : returnpolicy.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Integer createpersonid) {
        this.createpersonid = createpersonid;
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