package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Nationality implements Serializable{
    private Integer nationalityid;

    private String nationalityname;

    private String status;

    private Date createdate;

    public Integer getNationalityid() {
        return nationalityid;
    }

    public void setNationalityid(Integer nationalityid) {
        this.nationalityid = nationalityid;
    }

    public String getNationalityname() {
        return nationalityname;
    }

    public void setNationalityname(String nationalityname) {
        this.nationalityname = nationalityname == null ? null : nationalityname.trim();
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