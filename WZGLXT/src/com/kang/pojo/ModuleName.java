package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class ModuleName implements Serializable{
    private Integer modulenameid;

    private String modulename;

    private String status;

    private Date createdate;

    public Integer getModulenameid() {
        return modulenameid;
    }

    public void setModulenameid(Integer modulenameid) {
        this.modulenameid = modulenameid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
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