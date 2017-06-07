package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class WorkFlow implements Serializable{
    private Integer workflowid;

    private Integer approvalmoduleid;

    private String processname;

    private String status;

    private Integer lastpersonid;

    private Date lastprocessingtime;

    public Integer getWorkflowid() {
        return workflowid;
    }

    public void setWorkflowid(Integer workflowid) {
        this.workflowid = workflowid;
    }

    public Integer getApprovalmoduleid() {
        return approvalmoduleid;
    }

    public void setApprovalmoduleid(Integer approvalmoduleid) {
        this.approvalmoduleid = approvalmoduleid;
    }

    public String getProcessname() {
        return processname;
    }

    public void setProcessname(String processname) {
        this.processname = processname == null ? null : processname.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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