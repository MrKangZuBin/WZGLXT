package com.kang.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProvinceCity implements Serializable{
    private Integer provincecityid;

    private String provincecityname;

    private Integer provincecitythe;

    private String status;

    private Date createdate;

    public Integer getProvincecityid() {
        return provincecityid;
    }

    public void setProvincecityid(Integer provincecityid) {
        this.provincecityid = provincecityid;
    }

    public String getProvincecityname() {
        return provincecityname;
    }

    public void setProvincecityname(String provincecityname) {
        this.provincecityname = provincecityname == null ? null : provincecityname.trim();
    }

    public Integer getProvincecitythe() {
        return provincecitythe;
    }

    public void setProvincecitythe(Integer provincecitythe) {
        this.provincecitythe = provincecitythe;
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