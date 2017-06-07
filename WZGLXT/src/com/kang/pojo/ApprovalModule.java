package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class ApprovalModule implements Serializable{
    private Integer approvalmoduleid;

    private Integer modulenameid;

    private Integer approvaltypeid;

    private String status;

    private String crosslevel;

    private Integer createpersonid;

    private Date createdate;

    private Integer lastmodifiedid;

    private Date lastmodifiedtime;

    public Integer getApprovalmoduleid() {
        return approvalmoduleid;
    }

    public void setApprovalmoduleid(Integer approvalmoduleid) {
        this.approvalmoduleid = approvalmoduleid;
    }

    public Integer getModulenameid() {
        return modulenameid;
    }

    public void setModulenameid(Integer modulenameid) {
        this.modulenameid = modulenameid;
    }

    public Integer getApprovaltypeid() {
        return approvaltypeid;
    }

    public void setApprovaltypeid(Integer approvaltypeid) {
        this.approvaltypeid = approvaltypeid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCrosslevel() {
        return crosslevel;
    }

    public void setCrosslevel(String crosslevel) {
        this.crosslevel = crosslevel == null ? null : crosslevel.trim();
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