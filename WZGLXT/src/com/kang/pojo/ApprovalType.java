package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class ApprovalType implements Serializable{
    private Integer approvaltypeid;

    private String approvaltypename;

    private String status;

    private Date createdate;

    public Integer getApprovaltypeid() {
        return approvaltypeid;
    }

    public void setApprovaltypeid(Integer approvaltypeid) {
        this.approvaltypeid = approvaltypeid;
    }

    public String getApprovaltypename() {
        return approvaltypename;
    }

    public void setApprovaltypename(String approvaltypename) {
        this.approvaltypename = approvaltypename == null ? null : approvaltypename.trim();
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
}