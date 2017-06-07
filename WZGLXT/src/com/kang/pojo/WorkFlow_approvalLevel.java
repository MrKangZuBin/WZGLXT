package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class WorkFlow_approvalLevel implements Serializable{
    private Integer id;

    private Integer level;

    private Integer permissiongroup;

    private String approvaluser;

    private String conditions;

    private Long money;

    private String status;

    private Integer lastpersonid;

    private Date lastprocessingtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPermissiongroup() {
        return permissiongroup;
    }

    public void setPermissiongroup(Integer permissiongroup) {
        this.permissiongroup = permissiongroup;
    }

    public String getApprovaluser() {
        return approvaluser;
    }

    public void setApprovaluser(String approvaluser) {
        this.approvaluser = approvaluser == null ? null : approvaluser.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
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